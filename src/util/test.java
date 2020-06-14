package util;

import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.util.UUID;

public class test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setName("1");
        user.setPassword("1");
        Object[] objects = userService.login(user);
        System.out.println(objects[1]);
    }


    public void test5() {
        String json = "{\n" +
                "  \"age\": \"20\",\n" +
                "  \"birthday\": \"2020-06-25\",\n" +
                "  \"city\": \"海淀区\",\n" +
                "  \"hobby\": \"[write, read]\",\n" +
                "  \"intro\": \"125\",\n" +
                "  \"name\": \"许帅\",\n" +
                "  \"num\": \"201877100332\",\n" +
                "  \"province\": \"北京市\",\n" +
                "  \"sex\": \"男\"\n" +
                "}";
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
//        File file = JSONUtils.createJSONFile(json, uuid);
//        System.out.println(file.getAbsolutePath());
    }
}
