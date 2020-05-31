package util;

import org.junit.Test;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class test {
    MailSender mailSender;//XML中的id

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Test
    public void testName() throws Exception {
        //JavaMailSenderImpl xxx = (JavaMailSenderImpl)mailSender
        // 简单邮件对象
        SimpleMailMessage msg = new SimpleMailMessage();
        // 发送人:和配置一致
        msg.setFrom("1464978594@qq.com");
        // 收件人
        msg.setTo("18603761952@163.com");
        // 主题
        msg.setSubject("主题");
        // 内容
        msg.setText("内容");
        // 设置固定回邮地址
        msg.setReplyTo("1464978594@qq.com");
        // 发送
        mailSender.send(msg);
    }
}
