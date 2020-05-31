package util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 邮件发送工具
 *
 * @author CoderXshuai
 */
public class MailUtil {
    /**
     * 发送者属性配置,在applicationContext.xml文件中
     */
    private JavaMailSenderImpl mailSender;
    private SimpleMailMessage mailMessage;

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    /**
     * 发送验证码的方法
     *
     * @param subject 发送主题
     * @param text    发送内容
     * @param to      发送者邮箱地址(数组形式)
     * @return 是否发送成功
     */
    public boolean sendMail(String subject, String text, String[] to) {
        try {
            mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setFrom(mailSender.getUsername());
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            //发送邮件
            mailSender.send(mailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
