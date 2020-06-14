package service;

import model.Doc;

import java.io.File;
import java.util.List;

/**
 * @author CoderXshuai
 */
public interface DocService {

    /**
     * 上传文件
     *
     * @param doc
     * @param inboxId
     */
    void upload(Doc doc, String inboxId);

    /**
     * 获取所有doc
     *
     * @param inboxId 收件箱ID
     * @return 该收件箱下所有的doc
     */
    List<Doc> getDocs(String inboxId);

    /**
     * 写入json
     *
     * @param json    前端传过来的json字符串
     * @param inboxId 对应的收件夹ID
     * @return 返回json文件名(UUID)
     */
    File writeJSON(String json, String inboxId);

    /**
     * 删除doc
     *
     * @param inboxId 收件夹ID
     */
    void del(String inboxId);
}
