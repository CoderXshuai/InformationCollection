package service;

import model.User;

/**
 * @author CoderXshuai
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user 注册的用户实例
     * @return object[0]代表用户对象 object[1]代表返回信息
     */
    Object[] register(User user);

    /**
     * 用户登录
     *
     * @param user 登录的用户实例
     * @return object[0]代表用户对象 object[1]代表返回信息
     */
    Object[] login(User user);

    /**
     * 根据传来的id  和密码信息进行修改密码
     *
     * @param user 用户实例
     * @param id   用户ID
     * @return object[0]代表用户对象 object[1]代表返回信息
     */
    Object[] changePwd(User user, int id);

}
