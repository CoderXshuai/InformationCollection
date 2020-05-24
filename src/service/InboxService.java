package service;

import model.Inbox;

import java.util.Date;
import java.util.List;

/**
 * @author CoderXshuai
 */
public interface InboxService {
    /**
     * 获取所有的inbox
     *
     * @param inbox  对象参数
     * @param userId 用户id
     * @param sortId 排序的id
     * @return 返回该用户的所有数据
     */
    List<Inbox> getAll(Inbox inbox, int userId, int sortId);

    /**
     * 获取inbox
     *
     * @param id 收件夹ID
     * @return 收件夹实例
     */
    Inbox getInboxById(String id);


    /**
     * 添加文件收件夹
     *
     * @param inbox  收件夹实例
     * @param userId 用户ID
     */
    void add(Inbox inbox, int userId);

    /**
     * 修改截止时间
     *
     * @param endTime 截止时间
     * @param id      ID
     */
    void updateEndTime(Date endTime, String id);

    /**
     * 关闭收件夹
     *
     * @param closeReason 一般为到时间了
     * @param id
     */
    void closeInbox(String closeReason, String id);

    /**
     * 打开收件夹
     *
     * @param id 收件夹ID
     * @return 是否打开成功
     */
    boolean openInbox(String id);

    /**
     * 标星
     *
     * @param id
     */
    void star(String id);

    /**
     * 取消标星
     *
     * @param id
     */
    void cancelStar(String id);

    /**
     * 删除该收件夹
     *
     * @param id
     */
    void delete(String id);

    /**
     * 为收件夹添加密码
     *
     * @param id
     * @param pwd
     */
    void updatePwd(String id, String pwd);

}
