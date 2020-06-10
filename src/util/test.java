package util;

import model.Doc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DocService;

import java.io.File;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/conf/applicationContext.xml", "/conf/applicationContext-beans.xml");
//        SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
//        InboxService inboxService = (InboxService) context.getBean("inboxService");
        DocService docService = (DocService) context.getBean("docService");
        List<Doc> docs = docService.getDocs("402881eb729d551601729d57510a0001");
        System.out.println(docs.size());
//        Inbox inbox = inboxService.getInboxById("402881eb729d551601729d57510a0001");
//        File file = new File("web/upFile/logo0.png");
//        Doc doc = new Doc();
//        doc.setUploadFile(file);
//        doc.setUploadFileFileName("file.png");
//        doc.setName("doc");
//        doc.setUrl("web\\upFile\\logo0.png");
//        doc.setSize("52k");
//        doc.setCreateTime(new Date());
//        doc.setDownload(5);
//        doc.setInbox(inbox);
//        docService.upload(doc, "402881eb729d551601729d57510a0001");
//        Session session = factory.openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from Doc WHERE inboxId=402881eb729d551601729d57510a0001");
//        List<Doc> docs = query.list();
//        System.out.println(docs.size());

    }

    @Test
    public void test5() {
        File file = new File("web/upFile/logo0.png");
        System.out.println(file.exists());
    }
}
