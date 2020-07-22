package util;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CoderXshuai
 * @date 2020/7/10/0010 11:50
 */

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
    }
}
