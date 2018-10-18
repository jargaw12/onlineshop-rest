package com.github.jargaw12.mailordercompanyrest;

import com.github.jargaw12.mailordercompanyrest.domain.CustomUserDetail;
import com.github.jargaw12.mailordercompanyrest.domain.Role;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class MailordercompanyRestApplication {

//    @Bean
//    public CommandLineRunner setupDefaultUser(UserService service) {
//        return args -> {
//            service.save(new Users(
//                    "user", //username
//                    "user", //password
//                    Arrays.asList(new Role("USER"), new Role("ACTUATOR"))
//            ));
//        };
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    public static void main(String[] args) {
        SpringApplication.run(MailordercompanyRestApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
        if (repo.count()==0){
//            repo.save(new Users("user", getPasswordEncoder().encode("password"), Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
        }
        builder.userDetailsService(username -> new CustomUserDetail(repo.findByUsername(username)));
    }
}
