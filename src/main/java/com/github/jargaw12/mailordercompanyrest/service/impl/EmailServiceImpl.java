package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender, ResourceLoader resourceLoader) {
        this.emailSender = emailSender;
        this.resourceLoader = resourceLoader;
    }

    @Value(value = "classpath:prints/Order.pdf")
    private Resource print;

    @Value(value = "classpath:templates/emailTemplate.html")
    private Resource emailTemplate;

    final
    ResourceLoader resourceLoader;

    @Override
    public void sendEmail(String to, Order order) throws IOException {

        String c = String.join("", Files.readAllLines(emailTemplate.getFile().toPath()));
        MimeMessage mail = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom("Ubrani");
            helper.setSubject("Potwierdzenie zamówienia nr: "+ order.getId());
            helper.setText(c, true);
            File file= resourceLoader.getResource("file:src/main/resources/prints/Order_"+ order.getId()+".pdf").getFile();
            helper.addAttachment("Zamowienie nr: "+ order.getId(),file);

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }

        emailSender.send(mail);
    }
}
