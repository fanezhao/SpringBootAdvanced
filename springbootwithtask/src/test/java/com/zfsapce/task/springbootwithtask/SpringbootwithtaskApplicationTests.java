package com.zfsapce.task.springbootwithtask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootwithtaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知");
        message.setText("今晚开会");
        message.setTo("fanezhao@163.com");
        message.setFrom("978322858@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void testSendMail() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("通知");
        helper.setText("<b style='color:red'>今晚开会</b>", true);
        helper.setTo("fanezhao@163.com");
        helper.setFrom("978322858@qq.com");
        helper.addAttachment("th.jpg", new File("C:\\Users\\Administrator\\Desktop\\th.jpg"));
        javaMailSender.send(mimeMessage);
    }
}
