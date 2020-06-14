package service.impl;

import dao.UserDao;
import model.User;
import service.UserService;
import util.MyUtils;
import util.Static;

import java.io.File;
import java.util.UUID;

/**
 * @author CoderXshuai
 */
public class UserServiceImpl implements UserService {
    /**
     * dao层配置
     */
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Object[] register(User user) {
        // TODO Auto-generated method stub
        User uEmail = userDao.find("from User u where u.email ='" + user.getEmail() + "'");
        User uName = userDao.find("from User u where u.name ='" + user.getName() + "'");
        if (uEmail == null) {
            //邮箱号未注册
            if (uName == null) {
                //用户名未注册
                uName = new User();
                uName.setName(user.getName());
                uName.setEmail(user.getEmail());
                uName.setStatus(0);
                uName.setRole(0);
                //默认头像
                uName.setHeadImg("default.png");
                uName.setPassword(user.getPassword());
                //保存
                userDao.save(uName);
                return new Object[]{uName, "注册成功!欢迎你"};
            } else {
                return new Object[]{null, "用户名已存在,请重新输入"};
            }
        }
        return new Object[]{null, "邮箱号已经被注册!请直接登录"};
    }

    @Override
    public Object[] login(User user) {
        // TODO Auto-generated method stub
        //按照用户名查找用户
        User u = userDao.find("from User u where u.name ='" + user.getName() + "'");
        if (u != null) {
            String password = u.getPassword();
            if (user.getPassword().equals(password)) {
                return new Object[]{u, "登录成功!欢迎你" + u.getName()};
            }
            return new Object[]{null, "密码错误"};
        }
        return new Object[]{null, "用户名不存在"};
    }


    @Override
    public Object[] changePwd(User user, int id) {
        // TODO Auto-generated method stub
        User u = userDao.find("from User u where u.id =" + id);
        //传来的原始密码
        String password = user.getPassword();
        //密码正确
        if (password.equals(u.getPassword())) {
            //更新密码
            String newPwd = user.getNewPassword();
            u.setPassword(newPwd);
            userDao.update(u);
            return new Object[]{true, "密码修改成功!"};
        }
        return new Object[]{false, "原密码输出错误！请重试"};
    }

    @Override
    public Object[] changeHeadImg(User user, int id) {
        // TODO Auto-generated method stub
        User u = userDao.find("from User u where u.id =" + id);
        //获取之前的图片文件名
        String oldImgName = u.getHeadImg();
        //获取图片文件
        File uploadFile = user.getUploadFile();
        String uploadFileContentType = user.getUploadFileContentType();
        //获取图片后缀
        String ext = uploadFileContentType.split("/")[1];
        //图片名称为 UUID保证唯一性
        String imgName = UUID.randomUUID().toString() + "." + ext;
        u.setHeadImg(imgName);
        userDao.update(u);
        //写入文件到服务器
        MyUtils.writeFile(uploadFile, Static.USER_HEADIMG, imgName);
        //删除之前的文件
        MyUtils.deleteFile(Static.USER_HEADIMG, oldImgName);
        return new Object[]{"头像修改成功!", imgName, u};
    }

    @Override
    public User getUserById(int id) {
        // TODO Auto-generated method stub
        User u = userDao.find("from User u where u.id =" + id);
        return u;
    }

}
