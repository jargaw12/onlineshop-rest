package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Address;
import com.github.jargaw12.mailordercompanyrest.domain.Orderdetails;
import com.github.jargaw12.mailordercompanyrest.domain.Orders;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.lowagie.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface OrdersService {
    List<Orders> findAllByUsersByUserid(String username);
    @Query("select o from Orders o where o.id=:id and o.usersByUserid.username=:username")
    Orders findByOrderById(@Param("username") String username,@Param("id") long id);
    Orders addNewOrder(Orders orders, String username) throws IOException, MessagingException, JRException, DocumentException, com.itextpdf.text.DocumentException, URISyntaxException;
    List<Orderdetails> addOrderDetails(String username,Orders orders);
    Long addAddress(Address address);
    int sendOrder(Orders orders, List<Orderdetails> orderdetails) throws IOException;
}
