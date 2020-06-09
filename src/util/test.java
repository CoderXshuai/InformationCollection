package util;

import model.Inbox;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.InboxService;

import java.io.File;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
        InboxService inboxService = (InboxService) context.getBean("inboxService");
        Inbox inbox = new Inbox();
        inbox.setTitle("title");
        inbox.setRemark("remark");
        inbox.setEndTime(new Date());
        File file = new File("web/upFile/logo0.png");
        inbox.setUploadFile(file);
        inbox.setUploadFileContentType("text/png");
        inboxService.add(inbox, 1);
//        System.out.println(objects[1]);
    }

    @Test
    public void test5() {
        File file = new File("web/upFile/logo0.png");
        System.out.println(file.exists());
    }
}
