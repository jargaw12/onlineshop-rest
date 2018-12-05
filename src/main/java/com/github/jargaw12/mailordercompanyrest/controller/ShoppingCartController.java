package com.github.jargaw12.mailordercompanyrest.controller;

import com.github.jargaw12.mailordercompanyrest.domain.Shoppingcart;
import com.github.jargaw12.mailordercompanyrest.service.EmailSender;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/shoppingcart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    UserService userService;

    @Autowired
    PdfService pdfService;

    @Autowired
    EmailSender emailSender;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Shoppingcart> getProducts(Authentication authentication) throws JRException, DocumentException, IOException, URISyntaxException, com.lowagie.text.DocumentException, MessagingException {
//        pdfService.generateInvoice(shoppingCartService.getProducts(authentication.getName()),userService.getUserByUsername(authentication.getName()));
//        emailSender.sendEmail("jarrcioo@gmail.com","Hi",null);
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
    public ResponseEntity<?> changeQuantity(Authentication authentication,@RequestBody Shoppingcart product) {
        shoppingCartService.plusminusProduct(product.getId(), product.getQuantity(), authentication.getName());
        System.out.println("Zmieniono liczbę kupionych produktów o: " + product.getQuantity());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public void addProduct(Authentication authentication,@RequestBody Shoppingcart product) throws MessagingException {
        shoppingCartService.addProduct(product.getId(), authentication.getName());
        System.out.println("Dodano nowy produkt: " + product.getId());
    }
}
