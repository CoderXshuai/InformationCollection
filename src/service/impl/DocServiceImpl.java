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
        String hql = "from Doc where inboxId ='" + inboxId + "'";
        docs = docDao.get(hql);
        return docs;
    }

    @Override
    public File writeJSON(String json, String inboxId) {
        try {
            String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            Object jsonObject = JSONUtils.convertToJSON(json, uuid);
            System.out.println(jsonObject.toString());
            File file = JSONUtils.createJSONFile(jsonObject, uuid, inboxId);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void del(String inboxId) {
        List<Doc> docs = docDao.get("from Doc where inboxId='" + inboxId + "'");
        for (Doc doc : docs) {
            File file = new File(doc.getUrl());
            file.delete();
            doc.getInbox().getDocs().removeAll(docs);
            docDao.delete(doc);
        }
    }
}
