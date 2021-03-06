package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CoderXshuai
 */
public class Inbox implements Serializable {

    /**
     * 序列号UUID
     */
    private static final long serialVersionUID = 2789190961255785222L;
    /**
     * 唯一标识符,通过ID访问收件地址
     */
    private String id;
    /**
     * 收件夹标题
     */
    private String title;
    /**
     * logo图片名称
     */
    private String logo;
    /**
     * 收件夹备注
     */
    private String remark;
    /**
     * 上交的截止时间
     */
    private Date endTime;
    /**
     * 任务创建时间
     */
    private Date createTime;
    /**
     * 是否完成(标星)
     */
    private int star;
    /**
     * 收件密码
     */
    private String password;
    /**
     * 状态 开启 关闭
     */
    private int status;
    /**
     * 关闭原因
     */
    private String closeReason;
    /**
     * many-to-one
     */
    private User user;

    /**
     * one-to-many
     */
    private Set<Doc> docs = new HashSet(5);

    /**
     * 上传文件的其他属性
     */
    private File uploadFile;
    private String uploadFileContentType;


    public Inbox() {
        super();
    }

    public Inbox(String id, String title, String logo, String remark,
                 Date endTime, Date createTime, int star, String password,
                 int status, String closeReason, User user, Set docs) {
        super();
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.remark = remark;
        this.endTime = endTime;
        this.createTime = createTime;
        this.star = star;
        this.password = password;
        this.status = status;
        this.closeReason = closeReason;
        this.user = user;
        this.docs = docs;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Doc> getDocs() {
        return docs;
    }

    public void setDocs(Set<Doc> docs) {
        this.docs = docs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Inbox)) return false;

        Inbox inbox = (Inbox) o;

        return new EqualsBuilder()
                .append(getId(), inbox.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }
}
