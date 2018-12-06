package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.ShoppingCartItem;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductListRepo;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ShoppingCartRepo;
import com.github.jargaw12.mailordercompanyrest.domain.repository.UserRepository;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepo shoppingCartRepo;
    private final ProductListRepo productRepo;
    private final UserRepository userRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepo shoppingCartRepo, ProductListRepo productRepo, UserRepository userRepository) {
        this.shoppingCartRepo = shoppingCartRepo;
        this.productRepo = productRepo;
        this.userRepository = userRepository;
    }

    @Override
    public List<ShoppingCartItem> getProducts(String username) {
        return shoppingCartRepo.findByBuyer(userRepository.findByUsername(username).getId());
    }

    @Override
    public int getTotalQuantity(String username) {
        OptionalInt total = shoppingCartRepo.findByBuyer(userRepository.findByUsername(username).getId()).stream().mapToInt(ShoppingCartItem::getQuantity).reduce((sum, p) -> sum + p);
        return total.orElse(0);
    }

    @Override
    public void addProduct(Long id, String username)  {
        long userId = userRepository.findByUsername(username).getId();
        ShoppingCartItem p = shoppingCartRepo.findByBuyerAndItem(userId, id);
        //
//        emailService.sendEmail("jarrcioo@gmail.com","Witaj","");
        //
        if (p != null) {
            p.setQuantity(p.getQuantity() + 1);
            shoppingCartRepo.save(p);
        } else {
            Product product = productRepo.findProductById(id);
            Users u = userRepository.findById(userId).orElse(new Users());
            shoppingCartRepo.save(new ShoppingCartItem(1, u, product));
        }
    }

    @Override
    public void plusminusProduct(long id, int quantity, String username) {
        ShoppingCartItem cart = shoppingCartRepo.findByBuyerAndItem(userRepository.findByUsername(username).getId(), id);
        cart.setQuantity(cart.getQuantity() + quantity);
        shoppingCartRepo.save(cart);
    }

    @Override
    public void removeProduct(long id, String username) {
        long cartItemId = shoppingCartRepo.findByBuyerAndItem(userRepository.findByUsername(username).getId(), id).getId();
        shoppingCartRepo.deleteById(cartItemId);
    }

}
