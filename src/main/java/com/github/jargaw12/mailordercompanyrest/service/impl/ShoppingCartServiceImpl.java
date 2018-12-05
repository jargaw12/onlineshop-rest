package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.Shoppingcart;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductList;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ShoppingCartRepo;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    final ShoppingCartRepo shoppingCartRepo;
    final ProductList productRepo;
    final UserRepository userRepository;

    @Autowired
    EmailSenderImpl emailSender;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepo shoppingCartRepo, ProductList productRepo, UserRepository userRepository) {
        this.shoppingCartRepo = shoppingCartRepo;
        this.productRepo = productRepo;
        this.userRepository = userRepository;
    }

    @Override
    public List<Shoppingcart> getProducts(String username) {
        return shoppingCartRepo.findByBuyer(userRepository.findByUsername(username).getId());
    }

    @Override
    public int getTotalQuantity(String username) {
        OptionalInt total = shoppingCartRepo.findByBuyer(userRepository.findByUsername(username).getId()).stream().mapToInt(x -> x.getQuantity()).reduce((sum, p) -> sum + p);
        return total.orElse(0);
    }

    @Override
    public void addProduct(Long id, String username) throws MessagingException {
        long userId = userRepository.findByUsername(username).getId();
        Shoppingcart p = shoppingCartRepo.findByBuyerAndItem(userId, id);
        //
//        emailSender.sendEmail("jarrcioo@gmail.com","Witaj","");
        //
        if (p != null) {
            p.setQuantity(p.getQuantity() + 1);
            shoppingCartRepo.save(p);
        } else {
            Product product = productRepo.findProductById(id);
            Users u = userRepository.findById(userId).orElse(new Users());
            shoppingCartRepo.save(new Shoppingcart(1, u, product));
        }
    }

    @Override
    public void plusminusProduct(long id, int quantity, String username) {
        Shoppingcart cart = shoppingCartRepo.findByBuyerAndItem(userRepository.findByUsername(username).getId(), id);
        cart.setQuantity(cart.getQuantity() + quantity);
        shoppingCartRepo.save(cart);
    }

    @Override
    public void removeProduct(long id, String username) {
        long cartItemId = shoppingCartRepo.findByBuyerAndItem(userRepository.findByUsername(username).getId(), id).getId();
        shoppingCartRepo.deleteById(cartItemId);
    }

}
