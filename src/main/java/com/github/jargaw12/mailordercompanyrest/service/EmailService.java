package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Order;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void sendEmail(String to, Order order) throws IOException;
}
