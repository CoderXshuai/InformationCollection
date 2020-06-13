package util;

import model.Doc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DocService;

import java.io.File;
import java.util.UUID;

public class test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        DocService docService = (DocService) context.getBean("docService");
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
        File file = JSONUtils.createJSONFile(json, uuid);
        Doc doc = new Doc();
        doc.setUploadFile(file);
        doc.setUploadFileContentType("json");
        doc.setUploadFileFileName(file.getName());
        doc.setUrl(file.getAbsolutePath());
        docService.upload(doc, "402881eb729d551601729d57510a0001");
    }

    @Test
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
        File file = JSONUtils.createJSONFile(json, uuid);
        System.out.println(file.getAbsolutePath());
    }
}
