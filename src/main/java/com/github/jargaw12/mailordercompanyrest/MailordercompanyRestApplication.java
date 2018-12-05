package com.github.jargaw12.mailordercompanyrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jargaw12.mailordercompanyrest.domain.TransportModel.AuthToken;
import com.github.jargaw12.mailordercompanyrest.domain.TransportModel.OrderUser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

@SpringBootApplication
public class MailordercompanyRestApplication {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(MailordercompanyRestApplication.class, args);
    }
}
