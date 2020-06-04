package util;

import dao.UserDao;
import model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void hu() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        List<User> users = userDao.get("From User");
        System.out.println(users.size());
    }
}
