package service;

import model.Inbox;

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
     * 添加文件收件夹
     *
     * @param inbox  收件夹实例
     * @param userId 用户ID
     */
    void add(Inbox inbox, int userId);

    /**
     * 删除该收件夹
     *
     * @param id
     */
    void delete(String id);
}
