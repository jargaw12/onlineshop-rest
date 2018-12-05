package com.github.jargaw12.mailordercompanyrest.service;

import com.github.jargaw12.mailordercompanyrest.domain.Orderdetails;
import com.github.jargaw12.mailordercompanyrest.domain.Orders;
import com.github.jargaw12.mailordercompanyrest.domain.Shoppingcart;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public interface PdfService {
    public void generateInvoice(Orders orders, List<Orderdetails> details, Users user) throws JRException, IOException, DocumentException, URISyntaxException, com.lowagie.text.DocumentException;
}
