package service.impl;

import dao.DocDao;
import model.Doc;
import model.Inbox;
import service.DocService;
import util.JSONUtils;
import util.MyUtils;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CoderXshuai
 */
public class DocServiceImpl implements DocService {
    /**
     * dao层
     */
    private DocDao docDao;

    public void setDocDao(DocDao docDao) {
        this.docDao = docDao;
    }

    @Override
    public void upload(Doc doc, String inboxId) {
        File file = doc.getUploadFile();
        String fileName = doc.getUploadFileFileName();
        System.out.println("文件大小:" + file.length());
        doc.setName(fileName);
        doc.setSize(MyUtils.getFormatSize(file.length()));
        try {
            doc.setDownload(0);
            Timestamp t = new Timestamp(System.currentTimeMillis());
            Date date = new Date(t.getTime());
            doc.setCreateTime(date);
            Inbox inbox = new Inbox();
            inbox.setId(inboxId);
            doc.setInbox(inbox);
            docDao.save(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Doc> getDocs(String inboxId) {
        List<Doc> docs = new ArrayList<Doc>();
        // 获取该inbox的所有doc
//        String hql = "from Doc where inboxId ='402881eb729d551601729d57510a0001'";
        String hql = "from Doc where inboxId ='" + inboxId + "'";
        docs = docDao.get(hql);
        return docs;
    }

    @Override
    public File writeJSON(String json) {
        try {
            String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            Object jsonObject = JSONUtils.convertToJSON(json, uuid);
            System.out.println(jsonObject.toString());
            File file = JSONUtils.createJSONFile(jsonObject, uuid);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void del(String inboxId) {
        docDao.executeHql("delete Doc where inboxId='" + inboxId + "'");
    }
}
