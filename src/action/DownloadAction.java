package action;


import com.opensymphony.xwork2.ActionSupport;
import util.MyUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author CoderXshuai
 */
public class DownloadAction extends ActionSupport {

    //文件流
    private InputStream inStream;
    //文件地址
    private String fileUrl;
    //文件名称
    private String fileName;


    public InputStream getInStream() {
        return inStream;
    }


    public void setInStream(InputStream inStream) {
        this.inStream = inStream;
    }


    public String getFileUrl() {
        return fileUrl;
    }


    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


    public String getFileName() {
        try {
            fileName = new String(fileName.getBytes("GBK"), StandardCharsets.ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String execute() {
        String inboxId = MyUtils.getReq().getParameter("inboxId");
        System.out.println(inboxId);
        File file = new File("D:\\IntelliJ IDEA 2019.2.3\\InformationCollection\\web\\upFile\\inbox\\json" + File.separator + inboxId);
        Vector<InputStream> v = new Vector<InputStream>();
        Enumeration<InputStream> e;
        if (file.isDirectory()) {
            System.out.println(inboxId);
            try {
                File[] files = file.listFiles();
                for (File value : files) {
                    v.add(new FileInputStream(value));
                }
                e = v.elements();
                SequenceInputStream sis = new SequenceInputStream(e);
                inStream = sis;
                System.out.println("红红火火恍恍惚惚");
                return SUCCESS;
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return ERROR;
    }
}
