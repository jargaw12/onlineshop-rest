package com.github.jargaw12.mailordercompanyrest.service.impl;

import com.github.jargaw12.mailordercompanyrest.domain.Order;
import com.github.jargaw12.mailordercompanyrest.domain.OrderItem;
import com.github.jargaw12.mailordercompanyrest.domain.Users;
import com.github.jargaw12.mailordercompanyrest.service.PdfService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PdfServiceImpl implements PdfService {
    private final BaseFont helvetica=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1250,BaseFont.EMBEDDED);
    private final Font font = new Font(helvetica, 11, Font.BOLD);
    private final Font fontBold = new Font(helvetica, 11, Font.BOLD);

    @Value(value = "classpath:static/Ubrani3.jpg")
    private Resource logo;

    public PdfServiceImpl() throws IOException, DocumentException {
    }

    @Override
    public void generateInvoice(Order order, List<OrderItem> details, Users user) throws DocumentException, IOException {
        Document document = new Document();
        FileOutputStream file= new FileOutputStream("src/main/resources/prints/Order_"+ order.getId()+".pdf");
        PdfWriter.getInstance(document, file);
        document.open();

        document.add(createCurrentDate("Warszawa"));
        document.add(createTitle("Dokument PRO FORMA: "+ order.getId()));
        document.add(addLogo());
        document.add(createHeader("Sprzedawca"));
        document.add(createSellerDetails());
        document.add(createHeader("Nabywca"));
        document.add(createCustomerDetails(user));
        document.add(createTabe(details));
        document.add(addTotalAmount(order.getTotalprice()));
        document.add(addAttention());
        if (order.getPaymentByPaymentid().getId()==1){
            document.add(createPaymentDetails(order));
            document.add(qrCode(order));
            document.add(createScanText());
        }
        document.close();
    }

    private Element createHeader(String header) {
        return new Paragraph(header, fontBold);
    }

    private Paragraph createCurrentDate(String city) {
        Paragraph paragraph = new Paragraph(city + ", " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "r.");
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        return paragraph;
    }

    private PdfPTable createTabe(Collection<OrderItem> items) {
        float[] columnWidths = {1f, 8f, 2f, 3f, 3f};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);
        addTableHeader(table);
        addRows(table, items);
        return table;
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("L.p.", "Nazwa produktu", "Ilość", "Cena", "Wartość")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setPhrase(new Phrase(columnTitle,font));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, Collection<OrderItem> items) {
        DecimalFormat df = new DecimalFormat("0.00");
        for (OrderItem item : items) {
            table.addCell(String.valueOf(1));
            table.addCell(item.getProductByProductid().getName());
            table.addCell(String.valueOf(item.getQuantity()));
            table.addCell(df.format(item.getProductByProductid().getPrice()));
            table.addCell(df.format(item.getQuantity() * item.getProductByProductid().getPrice()));
        }
    }

    private Paragraph createTitle(String title) {
        Paragraph paragraph = new Paragraph(title, fontBold);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }

    private Paragraph createSellerDetails() {
        return new Paragraph("Ubrani Sp. z o.o.\n" +
                "Urbanowicza 11 ,\n" +
                "01-476 Warszawa\n\n",font);
    }


    private Paragraph createCustomerDetails(Users users) {
        return new Paragraph(users.getFirstname() + " " + users.getLastname() + "\n"
                + users.getAddress().getStreet() + " " + users.getAddress().getStreetnumber() +" "
                + users.getAddress().getPostcode() + " " + users.getAddress().getCity() + "\n\n",font);
    }

    private Paragraph createPaymentDetails(Order order){
        BarcodeQRCode barcodeQRCode = new BarcodeQRCode("||63114000008575925659435273|"+(Math.round(order.getTotalprice()*100))+"|Ubrani|Zamówienie nr "+ order.getId()+"|||", 1500, 1500, null);

        return new Paragraph("Odbiorca: Ubrani\n" +
                "Nr rachunku: 63114000008575925659435273\n" +
                "Kwota: "+ order.getTotalprice()+"\n"+
                "Tytułem: Zamówienie nr "+ order.getId()+"\n", font);
    }

    private Paragraph addTotalAmount(Double total) {
        DecimalFormat df = new DecimalFormat("0.00");
        Paragraph paragraph = new Paragraph("Ogółem: " + df.format(total), fontBold);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        return paragraph;
    }

    private Paragraph addAttention() {
        Paragraph paragraph = new Paragraph("\n\nUwaga: Dokument pro forma nie jest dokumentem księgowym\n\n", fontBold);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;

    }

    private Image addLogo() throws IOException, DocumentException {
        File file = new File(logo.getURI());
        Image img = Image.getInstance(file.getAbsolutePath());
        img.scalePercent(60);
        return img;
    }

    private Image qrCode(Order order) throws DocumentException {
        BarcodeQRCode barcodeQRCode = new BarcodeQRCode("||63114000008575925659435273|"+(Math.round(order.getTotalprice()*100))+"|Ubrani|Zamówienie nr "+ order.getId()+"|||", 1500, 1500, null);
        Image codeQrImage = barcodeQRCode.getImage();
        codeQrImage.scaleAbsolute(100, 100);
        codeQrImage.setAlignment(Element.ALIGN_CENTER);
        return codeQrImage;
    }

    private Paragraph createScanText() {
        Paragraph paragraph = new Paragraph("Zeskanuj aby zapłacić",font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }

}
