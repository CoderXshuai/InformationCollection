package util;

import com.sun.net.ssl.internal.ssl.Provider;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

/**
 * @author CoderXshuai
 */
public class EmailUtil {
    public static void sendEmail(String emailAddress, String emailSubject, String htmlContent) {
        try {
            // 设置SSL连接、邮件环境
            Security.addProvider(new Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtp.auth", "true");

            // 建立邮件会话
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                // 身份认证
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 账户 授权码
                    return new PasswordAuthentication("1464978594@qq.com", "dzbguwqynvdngfgi");
                }
            });

            // 建立邮件对象
            MimeMessage message = new MimeMessage(session);
            // 设置邮件的发件人、收件人、主题
            // 附带发件人名字
            message.setFrom(new InternetAddress("1464978594@qq.com"));
            message.setRecipients(Message.RecipientType.TO, emailAddress);
            message.setSubject(emailSubject);
            // 文本部分
            message.setContent(htmlContent, "text/html;charset=UTF-8");
            message.saveChanges();
            // 发送邮件
            Transport.send(message);
            // 打印成功信息
            System.out.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
