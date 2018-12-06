package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.ShoppingCartItem;
import com.github.jargaw12.mailordercompanyrest.service.EmailService;
import com.github.jargaw12.mailordercompanyrest.service.PdfService;
import com.github.jargaw12.mailordercompanyrest.service.ShoppingCartService;
import com.github.jargaw12.mailordercompanyrest.service.UserService;
import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "/shoppingcart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingCartItem> getProducts(Authentication authentication) {
//        pdfService.generateInvoice(shoppingCartService.getProducts(authentication.getName()),userService.getUserByUsername(authentication.getName()));
//        emailService.sendEmail("jarrcioo@gmail.com","Hi",null);
        return shoppingCartService.getProducts(authentication.getName());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/totalquantity")
    public int getTotalQuantity(Authentication authentication) {
        if (authentication.isAuthenticated())
            return shoppingCartService.getTotalQuantity(authentication.getName());
        else return 0;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(Authentication authentication, @PathVariable("id") long id) {
        shoppingCartService.removeProduct(id, authentication.getName());
        System.out.println("Usunieto produkt nr: " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/change")
    public ResponseEntity<?> changeQuantity(Authentication authentication,@RequestBody ShoppingCartItem product) {
        shoppingCartService.plusminusProduct(product.getId(), product.getQuantity(), authentication.getName());
        System.out.println("Zmieniono liczbę kupionych produktów o: " + product.getQuantity());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public void addProduct(Authentication authentication,@RequestBody ShoppingCartItem product) throws MessagingException {
        shoppingCartService.addProduct(product.getId(), authentication.getName());
        System.out.println("Dodano nowy produkt: " + product.getId());
    }
}
