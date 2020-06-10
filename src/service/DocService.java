package service;

import model.Doc;

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
}
