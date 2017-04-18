package com.bh.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	private final String username = "monitor.zhxt@chinaebi.com";// 发件人邮箱地址
	private final String password = "zhxt123456";// 发件人邮箱密码
//	private String smtpHost = "smtp.chinaebi.com";// 邮件发送服务器（smtp）比如163就是smtp.163.com
	/**
	 * 发送邮件
	 * 
	 * @param mailAddress
	 *            收件人地址
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @return Boolean true 发送成功 false 发送失败
	 */
	public boolean sendMails(String content,String mailAddress,String subject) {

//		final String username = "yi.liyao@chinaebi.com";
//		final String password = "qwertyui";
		
		//�ռ���
		final String to = mailAddress;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		//������������֤��У��
		props.put("mail.smtp.ssl.checkserveridentity", "false");
		
		//������εķ�������ַ�������ַ֮���ÿո�ֿ�
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.host", "mail.chinaebi.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

}