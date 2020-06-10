package action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
import model.User;
import service.UserService;
import util.MailUtil;
import util.MyUtils;
import util.Static;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.File;


/**
 * @author CoderXshuai
 */
public class UserAction implements ModelDriven<User> {
    private final User user = new User();
    private String word;
    /**
     * json返回值
     */
    private String result;
    /**
     * 用户业务
     */
    private UserService userService;
    private MailUtil mailUtil;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public MailUtil getMailUtil() {
        return mailUtil;
    }

    public void setMailUtil(MailUtil mailUtil) {
        this.mailUtil = mailUtil;
    }

    public String login() {
        Object[] obj = userService.login(user);
        if (obj[0] != null) {
            //存入session
            MyUtils.getSession().setAttribute(Static.ONLINE_USER, obj[0]);
            //存cookie
            User u = (User) obj[0];
            String cookieValue = MyUtils.encodeCookie(u.getId(), u.getPassword());
            MyUtils.addCookie(Static.ONLINE_USER, cookieValue);
            //在返回响应前  写入cookie
            MyUtils.outMsg((String) obj[1], true);
            result = (String) obj[1];
            return "login";
        } else {
            MyUtils.outMsg((String) obj[1], false);
        }
        return null;
    }

    /**
     * 注册
     */
    public String register() {
        //获取验证码
        String smsCode = MyUtils.getSessionObject(user.getEmail());
        if (null != smsCode && smsCode.equals(word)) {
            //正确
            Object[] obj = userService.register(user);
            //返回用户不为空 代表注册成功
            if (obj[0] != null) {
                MyUtils.getSession().setAttribute(Static.ONLINE_USER, obj[0]);
                //清空验证码
                MyUtils.getSession().removeAttribute(user.getEmail());
                //返回数据
                MyUtils.outMsg(obj[1].toString(), true);
                return "register";
            } else {
                //注册失败 返回数据
                MyUtils.outMsg(obj[1].toString(), false);
            }
        } else {
            //返回数据
            MyUtils.outMsg("验证码有误", false);
        }
        return "error";
    }

    /**
     * 更新密码
     */
    public void changePwd() {
        User onlineUser = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != onlineUser) {
            Object[] obj = userService.changePwd(user, onlineUser.getId());
            MyUtils.outMsg((String) obj[1], (boolean) obj[0]);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录", false);
        }
    }

    public void changeHeadImg() {
        User onlineUser = MyUtils.getSessionObject(Static.ONLINE_USER);
        if (null != onlineUser) {
            Object[] obj = userService.changeHeadImg(user, onlineUser.getId());
            //更新session
            MyUtils.getSession().setAttribute(Static.ONLINE_USER, obj[2]);
            JSONObject jo = new JSONObject(); //返回数据
            jo.put("msg", obj[0]);
            jo.put("headImg", obj[1]);
            jo.put("status", true);
            MyUtils.writeJSON(jo);
        } else {
            MyUtils.outMsg("你已经断网或离线,请刷新页面重新登录", false);
        }
    }

    public void displayCookie() {
        Cookie[] cookies;
        cookies = MyUtils.getReq().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());

        }
    }

    public void getHeadImg() {
        String imgName = user.getHeadImg();
        //图片目录文件
        String headImgPath = Static.USER_HEADIMG;
        //请求的图片路径
        String imgPath = headImgPath + File.separator + imgName;
        File imgFile = new File(imgPath);
        if (!imgFile.exists()) {
            imgPath = headImgPath + File.separator + "default.png";
            imgFile = new File(imgPath);
        }
        MyUtils.writeImg(imgFile);
    }

    public String SMS() {
        //获取随机验证码 6位
        String verification = MyUtils.getSix();
        String recNum = user.getEmail();
        boolean isSuc = mailUtil.sendMail("验证码", Static.getHtmlMail(user.getEmail(), verification), new String[]{user.getEmail()});
        //发送成功后  直接把验证码存入session;
        result = String.valueOf(isSuc);
        if (isSuc) {
            HttpSession sessionMsgCode = MyUtils.getSession();
            //有效期为5分钟
            sessionMsgCode.setMaxInactiveInterval(5 * 60);
            sessionMsgCode.setAttribute(recNum, verification);
            System.out.println(verification);
        } else {
            System.out.println("2");
        }
        //返回数据
        JSONObject jo = new JSONObject();
        jo.put("msg", verification);
        MyUtils.writeJSON(jo);
        word = verification;
        return "sms";
    }

}
