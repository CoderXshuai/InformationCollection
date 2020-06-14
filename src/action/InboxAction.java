package action;

import com.opensymphony.xwork2.ModelDriven;
import model.Inbox;
import model.User;
import service.InboxService;
import util.MyUtils;
import util.Static;

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
            result = list;
            return "getAll";
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录!", false);
        }
        return "error";
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

}
