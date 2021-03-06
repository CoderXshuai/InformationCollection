package service.impl;

import dao.InboxDao;
import dao.UserDao;
import model.Inbox;
import model.User;
import service.InboxService;
import util.DateTransform;
import util.MyUtils;
import util.Static;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * @author CoderXshuai
 */
public class InboxServiceImpl implements InboxService {
    /**
     * dao层配置
     */
    private InboxDao inboxDao;
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setInboxDao(InboxDao inboxDao) {
        this.inboxDao = inboxDao;
    }

    @Override
    public List<Inbox> getAll(Inbox inbox, int userId, int sortId) {
        // TODO Auto-generated method stub
        List<Inbox> inboxes = new ArrayList<Inbox>();
        // 获取该用户的所有inbox
        String hql = "from Inbox where userId =" + userId;
        // 添加排序条件
        hql = addSort(hql, sortId);
        inboxes = inboxDao.get(hql);
        // 当排序条件是3 说明是按照收件数量
        if (sortId == 3) {
            sortInboxByDocSize(inboxes);
        }
        return inboxes;
    }

    @Override
    public void add(Inbox inbox, int userId) {
        // TODO Auto-generated method stub
        User user = userDao.find("from User t where t.id =" + userId);
        Inbox newInbox = new Inbox();
        newInbox.setUser(user);
        // 复制属性(表单属性 包括:收件夹名称 收件夹说明 截止时间)
        newInbox.setTitle(inbox.getTitle());
        // 改变样式存入数据库
        newInbox.setRemark(MyUtils.textareaToSql(inbox.getRemark()));

        newInbox.setEndTime((Date) DateTransform.localDate2Date(LocalDate.now().plusWeeks(1L)));
        // 设置star status
        // 未标星
        newInbox.setStar(Static.INBOX_NOSTAR);
        // 开启
        newInbox.setStatus(Static.INBOX_ON);
        try {
            if (null != inbox.getUploadFile()) {
                // logo文件不为空
                File uploadFile = inbox.getUploadFile();
                String uploadFileContentType = inbox.getUploadFileContentType();
                // 获取图片后缀
                String ext = uploadFileContentType.split("/")[1];
                // 图片名称为 UUID保证唯一性
                String imgName = UUID.randomUUID().toString() + "." + ext;
                newInbox.setLogo(imgName);
                // 写入文件
                MyUtils.writeFile(uploadFile, Static.INBOX_LOGO, imgName);
            }
            // 设置创建时间
            inboxDao.save(newInbox);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        Inbox inbox = inboxDao.findById(Inbox.class, id);
        // 获取inbox的logo 把该logo删除
        String imgName = inbox.getLogo();
        // 删除inbox 根据级联关系 会删除所有的收件夹下的文件信息
        // 解除级联(父子)关系
        User user = inbox.getUser();
        user.getInboxs().remove(inbox);
        inboxDao.delete(inbox);
        // 删除文件
        MyUtils.deleteFile(Static.INBOX_LOGO, imgName);
    }

    /*************** 拓展方法 ****************/
    /**
     * 添加排序返回hql
     *
     * @param hql
     * @param sortId
     * @return
     */
    public String addSort(String hql, int sortId) {
        switch (sortId) {
            // 如果是1 说明是创建时间排序 所有排序都是倒序
            case 1:
                hql += " order by createTime desc";
                break;
            // 如果是2 说明是截止时间排序 所有排序都是倒序
            case 2:
                hql += "  order by endTime desc";
                break;
            // 如果是4 说明是只显示标星的数据
            case 4:
                hql += " and star = '" + Static.INBOX_STAR + "'";
                break;
            // 如果是5说明是只显示截止的数据
            case 5:
                hql += " and endTime <= '" + time()
                        + "'";
                break;
            // 如果是6 说明是只显示开启的数据
            case 6:
                hql += " and status = '" + Static.INBOX_ON + "'";
                break;
            // 如果是7 说明是只显示关闭的数据
            case 7:
                hql += " and status = '" + Static.INBOX_OFF + "'";
                break;
            default:
                hql += " order by createTime desc";
                break;
        }
        return hql;
    }

    public void sortInboxByDocSize(List<Inbox> data) {
        Collections.sort(data, new Comparator<Inbox>() {

            @Override
            public int compare(Inbox o1, Inbox o2) {
                // TODO Auto-generated method stub
                Integer a = o1.getDocs().size();
                Integer b = o2.getDocs().size();
                // 降序
                return b.compareTo(a);
            }

        });
    }

    public String time() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }
}
