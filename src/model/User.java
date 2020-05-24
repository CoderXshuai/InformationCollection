package model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CoderXshuai
 */
public class User implements Serializable {

    /**
     * 序列化,方便转成json对象传输
     */
    private static final long serialVersionUID = 1L;

    //持久化属性
    /**
     * ID
     */
    private int id; // 唯一标识符
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码(口令)
     */
    private String password;
    /**
     * 权限(暂定管理员和普通用户),管理员为1,普通用户0
     */
    private int role;
    /**
     * 状态
     */
    private int status;
    /**
     * 邮箱号
     */
    private String email; //手机号
    /**
     * 用户创建时间
     */
    private Date createTime; // 创建时间
    private String salt; // 盐 用来加密密码的 防止被彩笔表破解
    private String headImg; //头像

    /**
     * many-to-one
     */
    private Set inboxs = new HashSet(0);


    //非持久化属性
    /**
     * 前端密码
     */
    private String newPassword; //前台新密码
    /**
     * 密码确认
     */
    private String newPasswordAgain;
    /**
     * 文件的其他属性
     */
    private File uploadFile;
    private String uploadFileContentType;

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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }

    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(int id, String name, String password, int role, int status,
                String email, Date createTime, String salt, String headImg,
                Set inboxs) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
        this.email = email;
        this.createTime = createTime;
        this.salt = salt;
        this.headImg = headImg;
        this.inboxs = inboxs;
    }

    public User() {
        super();
    }

    public Set getInboxs() {
        return inboxs;
    }

    public void setInboxs(Set inboxs) {
        this.inboxs = inboxs;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }


}
