package action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
import model.Inbox;
import model.User;
import service.InboxService;
import util.MyUtils;
import util.Static;

import java.io.File;
import java.util.List;

/**
 * @author CoderXshuai
 */
public class InboxAction implements ModelDriven<Inbox> {
    private final Inbox inbox = new Inbox();
    /**
     * 配置service
     */
    private InboxService inboxService;
    private List<Inbox> result;
    /**
     * 排序方式
     */
    private int sortId;

    @Override
    public Inbox getModel() {
        // TODO Auto-generated method stub
        return inbox;
    }


    public void setInboxService(InboxService inboxService) {
        this.inboxService = inboxService;
    }


    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public List<Inbox> getResult() {
        return result;
    }

    public void setResult(List<Inbox> result) {
        this.result = result;
    }

    public String addInbox() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            try {
                inboxService.add(inbox, user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            MyUtils.outMsg("创建收件夹成功!", true);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
        return "addInbox";
    }

    public String getAll() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            List<Inbox> list = inboxService.getAll(inbox, user.getId(), sortId);
            JSONObject jo = new JSONObject();
//            jo.put("rows", list);
//            jo.put("status", true);
//            MyUtils.writeJSON(jo);
            result = list;
            return "getAll";
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
        return "error";
    }

    public void getInboxById() {

        Inbox list = inboxService.getInboxById(inbox.getId());
        JSONObject jo = new JSONObject();
        jo.put("rows", list);
        jo.put("status", true);
        MyUtils.writeJSON(jo);

    }

    public void checkPassword() {
        Inbox list = inboxService.getInboxById(inbox.getId());
        JSONObject jo = new JSONObject();
        if (list.getPassword().equals(inbox.getPassword())) {
            //密码相同
            jo.put("rows", list);
            jo.put("status", true);
        } else {
            jo.put("status", false);
        }
        MyUtils.writeJSON(jo);
    }


    public void updateEndTime() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            inboxService.updateEndTime(inbox.getEndTime(), inbox.getId());
            MyUtils.outMsg("截止时间更改成功", true);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void closeInbox() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            inboxService.closeInbox(inbox.getCloseReason(), inbox.getId());
            MyUtils.outMsg("该收件夹已关闭", true);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void openInbox() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            boolean flag = inboxService.openInbox(inbox.getId());
            if (flag) {
                MyUtils.outMsg("该收件夹开启", true);
            } else {
                MyUtils.outMsg("该收件夹已截止!请重新设置截止时间", false);
            }
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void star() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            inboxService.star(inbox.getId());
            MyUtils.outMsg("标星成功", true);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void cancelStar() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            inboxService.cancelStar(inbox.getId());
            MyUtils.outMsg("已取消标星", true);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void delete() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            inboxService.delete(inbox.getId());
            MyUtils.outMsg("删除成功!", true);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void updatePwd() {
        User user = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != user) {
            System.out.println(inbox.getPassword());
            inboxService.updatePwd(inbox.getId(), inbox.getPassword());
            if ("".equals(inbox.getPassword())) {
                MyUtils.outMsg("清除成功", true);
            } else {
                MyUtils.outMsg("设置成功!", true);
            }
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
    }

    public void getLogo() {
        String imgName = inbox.getLogo();
        //图片目录文件
        String headImgPath = Static.INBOX_LOGO;
        //请求的图片路径
        String imgPath = headImgPath + File.separator + imgName;
        File imgFile = new File(imgPath);
        if (!imgFile.exists()) {
            imgPath = headImgPath + File.separator + "default.png";
            imgFile = new File(imgPath);
        }
        MyUtils.writeImg(imgFile);
    }

    public void test() {
        System.out.println(inbox.getId());
        MyUtils.outMsg("哈哈哈", true);
    }
}
