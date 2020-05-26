package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.SQLException;

/**
 * @ClassName：JdbcUtil
 * @Description:数据库连接工具类
 */
public class JdbcUtil {
    //    //数据库连接池需实现javax.sql.DataSource接口，DBCP连接池是javax.sql.DataSource接口的具体实现
//    private static DataSource ds = new BasicDataSource();
//
//    //使用静态代码块创建数据库连接池
//    static {
//        try {
//            //加载dbcpconfig.properties配置文件
//            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("./conf/db.properties");
//            Properties prop = new Properties();
//            prop.load(in);
////            log.info(prop.getProperty("password"));
////            log.info("开始创建数据源");
//            //创建数据源
//            ds = BasicDataSourceFactory.createDataSource(prop);
//        } catch (Exception e) {
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//
//    /**
//     * @return
//     * @throws SQLException
//     * @Method:getConnection
//     * @Description:从数据源中获取数据库连接
//     */
//    public static Connection getConnection() throws SQLException {
//        System.out.println("数据库连接");
//        //从数据源中获取数据库连接
//        return ds.getConnection();
//    }
//
//    /**
//     * @param conn
//     * @param st
//     * @param rs
//     * @Method:release
//     * @Description:释放资源(数据库连接对象conn,负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象)
//     */
//    public static void release(Connection conn, Statement st, ResultSet rs) {
//        if (rs != null) {
//            try {
//                //关闭存储查询结果的ResultSet对象
//                rs.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            rs = null;
//        }
//        if (st != null) {
//            try {
//                st.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if (conn != null) {
//            try {
//                //将Connection连接对象还给数据库连接池
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
    private static final SessionFactory FACTORY;

    static {
        //加载核心配置文件
        Configuration configuration = new Configuration();
        configuration.configure(new File("./src/conf/db.properties"));
        //创建SessionFactory对象，并在数据库中把表创建出来
        FACTORY = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return FACTORY.openSession();
    }

    public static void main(String[] args) throws SQLException {
//        Connection connection = getConnection();
//        Statement statement = connection.createStatement();
//        statement.execute("create table my(ID INT)");
//        statement.close();
//        connection.close();
        Session session = getSession();
//        User user = new User();
//        user.setName("张三");
//        session.save(user);
//        session.beginTransaction().commit();
    }
}