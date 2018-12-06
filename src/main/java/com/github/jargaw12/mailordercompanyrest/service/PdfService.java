package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.OrderItem;
import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface PdfService {
    void generateInvoice(Order order, List<OrderItem> details, Users user) throws IOException, DocumentException;
}
