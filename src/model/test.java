package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * @author CoderXshuai
 */
public class test {
    private static final SessionFactory FACTORY;

    static {
        //加载核心配置文件
        Configuration configuration = new Configuration();
        configuration.configure(new File("./src/conf/hibernate.cfg.xml"));
        //创建SessionFactory对象，并在数据库中把表创建出来
        FACTORY = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return FACTORY.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        User user = new User();
        user.setName("张三");
        session.save(user);
        session.beginTransaction().commit();
    }
}
