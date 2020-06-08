package util;

import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.getUserById(1);
        user.setName("28");
        userService.register(user);

//        User user = userService.getUserById(1);
//        System.out.println(user.getName());
    }
}
