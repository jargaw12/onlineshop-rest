package com.github.jargaw12.mailordercompanyrest.domain.repository.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductList;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductListImpl implements ProductList {
    List<Product> productListRepository;

    public ProductListImpl() {
        productListRepository = new ArrayList<>();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

        p1.setName("NikeCourt Dri-FIT Advantage")
                .setPrice(new BigDecimal(219))
                .setDescription("Męska koszulka polo do tenisa")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/omykwpvosooohsxcbd0q/meska-koszulka-polo-do-tenisa-nikecourt-dri-fit-advantage-78m8ms.jpg");

        p2.setName("Nike Sportswear Club Fleece")
                .setPrice(new BigDecimal(229))
                .setDescription("Męska bluza z kapturem")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/jh3wlvilxj99fbvdcdbw/meska-bluza-z-kapturem-sportswear-club-fleece-pSqBs3.jpg");

        p3.setName("Nike Sportswear Tech")
                .setPrice(new BigDecimal(369))
                .setDescription("Spodnie męskie")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/xhdfr8pk8sbbj4dlvgmy/spodnie-meskie-sportswear-tech-hrNjJ0.jpg");

        p4.setName("Nike Flex Stride")
                .setPrice(new BigDecimal(159))
                .setDescription("Męskie spodenki z podszewką do biegania 18 cm")
                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/lxi11rd7jfyoqtt1wwsp/meskie-spodenki-z-podszewka-do-biegania-flex-stride-18-cm-Jtrwz3.jpg");

        productListRepository.add(p1);
        productListRepository.add(p2);
        productListRepository.add(p3);
        productListRepository.add(p4);

    }

    @Override
    public List<Product> getProducts() {
        return productListRepository;
    }
}
