package model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @author CoderXshuai
 */
public class Doc implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2728102862334727287L;
    /**
     * ID
     */
    private String id;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件所存地址
     */
    private String url;
    /**
     * 文件大小 带单位(Byte)
     */
    private String size;
    /**
     * 上传的时间
     */
    private Date createTime;
    /**
     * 下载次数
     */
    private int download;
    /**
     * many-to-one
     */
    private Inbox inbox;

    /**
     * 文件属性
     */
    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;
    private String downLoadFileName;

    public Doc(String id, String name, String url, String size,
               Date createTime, int download, Inbox inbox) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.size = size;
        this.createTime = createTime;
        this.download = download;
        this.inbox = inbox;
    }

    public Doc() {
        super();
    }

    public String getDownLoadFileName() {
        return downLoadFileName;
    }

    public void setDownLoadFileName(String downLoadFileName) {
        this.downLoadFileName = downLoadFileName;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public Inbox getInbox() {
        return inbox;
    }

    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }
}

