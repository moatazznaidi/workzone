package com.example.demo.Service;

import com.example.demo.Model.Mail;
import com.example.demo.Repository.MailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional

public class SendMailService {
    @Autowired private JavaMailSender javaMailSender ;
    @Autowired private MailRepository mailRepository ;

    public long sendMail (Mail mail) throws MailException{
        System.out.println("send email ..");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getDestinataire());
        msg.setCc("fatmaakarim01@gmail.com");
        msg.setSubject(mail.getObject());
        msg.setText(mail.getMessage());
        javaMailSender.send(msg);
        return mailRepository.save(mail).getId();
    }

    public List<Mail> getAll() {
        return  mailRepository.findAll();

    }

}
