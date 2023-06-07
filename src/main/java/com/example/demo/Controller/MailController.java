package com.example.demo.Controller;

import com.example.demo.Model.Mail;
import com.example.demo.Service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")

public class MailController {
    @Autowired
    private SendMailService sendMailService ;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type")
    @PostMapping(value = "/mail" )
    public long save(@RequestBody Mail mail){
        System.out.println("send mail");
        return sendMailService.sendMail(mail) ;
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type")
    @GetMapping("/mails")
    public List<Mail> list() {
        return sendMailService.getAll();
    }




}
