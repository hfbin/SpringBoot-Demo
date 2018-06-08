package cn.hfbin.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEmailApplicationTests {


	@Autowired
	JavaMailSenderImpl mailSender;

	//简单发送
	@Test
	public void contextLoads() {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("通知");
		message.setText("今晚开会 7：30");
		message.setTo("1340287013@qq.com");
		message.setFrom("1716850375@qq.com");
		mailSender.send(message);

	}
	//带文件 或者 页面html
	@Test
	public void sipTest() {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject("通知");
			//带html 标签   后面发要设置为true 否则无效
			mimeMessageHelper.setText("<b style='color:red'>今晚开会 7：30</b>" ,true);
			//上传文件
			mimeMessageHelper.addAttachment("1.png",new File("C:\\Users\\HuangFuBin\\Desktop\\note\\springboot\\img\\12\\5.png"));
			mimeMessageHelper.addAttachment("1.png",new File("C:\\Users\\HuangFuBin\\Desktop\\note\\springboot\\img\\12\\4.png"));
			mimeMessageHelper.setTo("1340287013@qq.com");
			mimeMessageHelper.setFrom("1716850375@qq.com");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);

	}


}
