package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Product;
import com.github.jargaw12.mailordercompanyrest.domain.repository.ProductList;
import com.github.jargaw12.mailordercompanyrest.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {
    @Autowired
    ProductList productListRepo;

    @Override
    public Iterable<Product> getProducts() {
        return productListRepo.findAll();
    }

    @Override
    public Page<Product> findPaginated(int page, int size) {
//        productListRepo.saveAll(createProducts());
        return productListRepo.findAll(PageRequest.of(page-1,size));
    }

    @Override
    public Product getProductById(long id) {
        return productListRepo.findProductById(id);
    }

//    private List<Product> createProducts(){
//        Product p1 = new Product();
//        Product p2 = new Product();
//        Product p3 = new Product();
//        Product p4 = new Product();
//        Product p5 = new Product();
//        Product p6 = new Product();
//        Product p7 = new Product();
//        Product p8 = new Product();
//
//        p1.setName("NikeCourt Dri-FIT Advantage1")
//                .setId(1)
//                .setPrice(new BigDecimal(219))
//                .setDescription("Męska koszulka polo do tenisa")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/omykwpvosooohsxcbd0q/meska-koszulka-polo-do-tenisa-nikecourt-dri-fit-advantage-78m8ms.jpg");
//
//        p2.setName("Nike Sportswear Club Fleece2")
//                .setId(2)
//                .setPrice(new BigDecimal(229))
//                .setDescription("Męska bluza z kapturem")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/jh3wlvilxj99fbvdcdbw/meska-bluza-z-kapturem-sportswear-club-fleece-pSqBs3.jpg");
//
//        p3.setName("Nike Sportswear Tech3")
//                .setId(3)
//                .setPrice(new BigDecimal(369))
//                .setDescription("Spodnie męskie")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/gnfh9ogvxwspbvcey5pb/meska-bluza-z-kapturem-hurley-hollowknit-fleece-ScLX1S.jpg");
//
//        p4.setName("Nike Flex Stride4")
//                .setId(4)
//                .setPrice(new BigDecimal(159))
//                .setDescription("Męskie spodenki z podszewką do biegania 18 cm")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/lxi11rd7jfyoqtt1wwsp/meskie-spodenki-z-podszewka-do-biegania-flex-stride-18-cm-Jtrwz3.jpg");
//
//        p5.setName("NikeCourt Dri-FIT Advantage5")
//                .setId(5)
//                .setPrice(new BigDecimal(219))
//                .setDescription("Męska koszulka polo do tenisa")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/omykwpvosooohsxcbd0q/meska-koszulka-polo-do-tenisa-nikecourt-dri-fit-advantage-78m8ms.jpg");
//
//        p6.setName("Nike Sportswear Club Fleece6")
//                .setId(6)
//                .setPrice(new BigDecimal(229))
//                .setDescription("Męska bluza z kapturem")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/jh3wlvilxj99fbvdcdbw/meska-bluza-z-kapturem-sportswear-club-fleece-pSqBs3.jpg");
//
//        p7.setName("Nike Sportswear Tech7")
//                .setId(7)
//                .setPrice(new BigDecimal(369))
//                .setDescription("Spodnie męskie")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/gnfh9ogvxwspbvcey5pb/meska-bluza-z-kapturem-hurley-hollowknit-fleece-ScLX1S.jpg");
//
//        p8.setName("Nike Flex Stride8")
//                .setId(8)
//                .setPrice(new BigDecimal(159))
//                .setDescription("Męskie spodenki z podszewką do biegania 18 cm")
//                .setImage("https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/lxi11rd7jfyoqtt1wwsp/meskie-spodenki-z-podszewka-do-biegania-flex-stride-18-cm-Jtrwz3.jpg");
//
//        return Arrays.asList(
//        p1,p2,p3,p4,p5,p6,p7,p8
//        );
//    }
}
