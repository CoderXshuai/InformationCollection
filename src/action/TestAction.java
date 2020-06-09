package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;

/**
 * @author CoderXshuai
 */
public class TestAction extends ActionSupport {
    private String name;
    private String psw;
    private int age;
    private User root;

    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setName(name);
        user.setPassword(psw);
        root = user;
        System.out.println(root.getName());
        return SUCCESS;
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

    public User getRoot() {
        return root;
    }

    public void setRoot(User root) {
        this.root = root;
    }
}
