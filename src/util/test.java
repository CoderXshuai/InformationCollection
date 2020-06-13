package util;

import model.Doc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DocService;

import java.io.File;

public class test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        DocService docService = (DocService) context.getBean("docService");
        Doc doc = new Doc();
        String form = "[{\"name\":\"name\",\"value\":\"1\"},{\"name\":\"num\",\"value\":\"1\"},{\"name\":\"age\",\"value\":\"1\"},{\"name\":\"birthday\",\"value\":\"2020-06-09\"},{\"name\":\"sex\",\"value\":\"男\"},{\"name\":\"province\",\"value\":\"2\"},{\"name\":\"city\",\"value\":\"1\"},{\"name\":\"hobby\",\"value\":\"write\"},{\"name\":\"hobby\",\"value\":\"movie\"},{\"name\":\"intro\",\"value\":\"1\"}]";
        File file = docService.writeJSON(form);
        doc.setUploadFile(file);
        doc.setUploadFileContentType("json");
        doc.setUploadFileFileName(file.getName());
        doc.setName(file.getName());
        doc.setSize((file.length() / 1024 + 1) + "kb");
        doc.setUrl(file.getAbsolutePath());
        docService.upload(doc, "402881eb729d551601729d57510a0001");

    }

    @Test
    public void test5() {
        File file = new File("D:\\IntelliJ IDEA 2019.2.3\\InformationCollection\\src\\util\\1.json");
        System.out.println(file.getName());
    }
}
