package service.impl;

import com.sun.jmx.snmp.Timestamp;
import dao.DocDao;
import dao.FileHashDao;
import model.Doc;
import model.Inbox;
import service.DocService;
import util.MyUtils;
import util.Static;

import java.io.File;
import java.util.ArrayList;
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
    private FileHashDao fileHashDao;

    public void setFileHashDao(FileHashDao fileHashDao) {
        this.fileHashDao = fileHashDao;
    }

    public void setDocDao(DocDao docDao) {
        this.docDao = docDao;
    }

    @Override
    public void upload(Doc doc, String inboxId) {
        // TODO Auto-generated method stub
        File file = doc.getUploadFile();
        String uploadFileContentType = doc.getUploadFileContentType();
        String fileName = doc.getUploadFileFileName();
        //计算hash值
//        String fileHash = MyUtils.getMd5ByFile(file);
//        //数据库查询
//        FileHash myHash = fileHashDao.findById(FileHash.class, fileHash);
        System.out.println("文件大小:" + file.length());
        //如果为空 说明文件库里面没有该文件
//        if (myHash == null) {
        //上传文件
        Doc d = new Doc();
        d.setName(fileName);
        d.setSize(MyUtils.getFormatSize(file.length()));
        d.setDownload(0);
        String url = UUID.randomUUID().toString() + "." + fileName.split("\\.")[1];
        d.setUrl(url);
        d.setCreateTime(new Timestamp().getDate());
        Inbox inbox = new Inbox();
        inbox.setId(inboxId);
        d.setInbox(inbox);
        docDao.save(d);
        //保存该hash值
//            myHash = new FileHash();
//            myHash.setId(fileHash);
//            myHash.setFileName(fileName);
//            myHash.setFileUrl(url);
//            fileHashDao.save(myHash);
        //写入文件到服务器
        MyUtils.writeFile(file, Static.INBOX_PATH, url);
//        } else {
//            //上传文件 但不写入到服务器 已经存在
//            Doc d = new Doc();
//            d.setName(fileName);
//            d.setUrl(myHash.getFileUrl());
//            d.setSize(MyUtils.getFormatSize(file.length()));
//            d.setDownload(0);
//            d.setCreateTime(new Timestamp().getDate());
//            Inbox inbox = new Inbox();
//            inbox.setId(inboxId);
//            d.setInbox(inbox);
//            docDao.save(d);
//        }
    }

    @Override
    public List<Doc> getDocs(String inboxId) {
        List<Doc> docs = new ArrayList<Doc>();
        // 获取该inbox的所有doc
        String hql = "from Doc where inboxId ='402881eb729d551601729d57510a0001'";
//        String hql = "from Doc where inboxId ='" + inboxId+"'";
        docs = docDao.get(hql);
        return docs;
    }
}
