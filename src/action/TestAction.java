package action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import model.User;

/**
 * @author CoderXshuai
 */
public class TestAction extends ActionSupport {
    private String name;
    private String psw;
    private int age;
    private String root;

    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setName(name);
        user.setPassword(psw);
        age = 15;
        root = JSON.toJSONString(user);
        System.out.println(root);
        return root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
