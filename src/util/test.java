package util;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From User");
        List<User> users = query.list();
        for (User user : users) {
            System.out.println("name" + user.getName());
        }
        session.beginTransaction().commit();
//        User user = userService.getUserById(1);
//        System.out.println(user.getName());
    }
}
