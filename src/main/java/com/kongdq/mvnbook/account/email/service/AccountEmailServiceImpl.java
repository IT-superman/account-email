package com.kongdq.mvnbook.account.email.service;

import com.kongdq.mvnbook.account.email.exception.AccountEmailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


public class AccountEmailServiceImpl  implements AccountEmailService{



    private JavaMailSender javaMailSender;


    private String systemEmail;

    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException {



        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelp = new MimeMessageHelper(msg);
            msgHelp.setFrom(systemEmail);
            msgHelp.setTo(to);
            msgHelp.setSubject(subject);
            msgHelp.setText(htmlText, true);

            javaMailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new AccountEmailException("fail to send mail!",e);
        }


    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

}
