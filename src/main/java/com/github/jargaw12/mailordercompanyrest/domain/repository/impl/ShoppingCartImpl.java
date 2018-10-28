package com.github.jargaw12.mailordercompanyrest.domain.repository.impl;

import com.github.jargaw12.mailordercompanyrest.domain.CartPosition;
import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShoppingCartImpl implements ShoppingCart {
    Map<Long, Integer> shoppingCart;
    private List<Product> products;

    public ShoppingCartImpl() {
        products=new ArrayList<>();
        shoppingCart = new HashMap();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();


        p1.setName("NikeCourt Dri-FIT Advantage")
                .setId(1)
                .setPrice(new BigDecimal(219.50))
                .setDescription("Męska koszulka polo do tenisa")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/omykwpvosooohsxcbd0q/meska-koszulka-polo-do-tenisa-nikecourt-dri-fit-advantage-78m8ms.jpg");

        p2.setName("Nike Sportswear Club Fleece")
                .setId(2)
                .setPrice(new BigDecimal(229.40))
                .setDescription("Męska bluza z kapturem")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/jh3wlvilxj99fbvdcdbw/meska-bluza-z-kapturem-sportswear-club-fleece-pSqBs3.jpg");

        p3.setName("Nike Sportswear Tech")
                .setId(3)
                .setPrice(new BigDecimal(369.99))
                .setDescription("Spodnie męskie")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/xhdfr8pk8sbbj4dlvgmy/spodnie-meskie-sportswear-tech-hrNjJ0.jpg");

        p4.setName("Nike Flex Stride")
                .setId(4)
                .setPrice(new BigDecimal(159.6))
                .setDescription("Męskie spodenki z podszewką do biegania 18 cm")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/lxi11rd7jfyoqtt1wwsp/meskie-spodenki-z-podszewka-do-biegania-flex-stride-18-cm-Jtrwz3.jpg");

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        shoppingCart.put(p1.getId(),1);
        shoppingCart.put(p2.getId(),2);
        shoppingCart.put(p3.getId(),3);
        shoppingCart.put(p4.getId(),1);
    }

    @Override
    public Map<Long, Integer> getProducts() {
        return shoppingCart;
    }

    @Override
    public Product getProductById(Long id) {
        return products.stream().filter(x->x.getId()==id).findFirst().get();
    }


}
