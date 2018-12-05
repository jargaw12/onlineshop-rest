package com.github.jargaw12.mailordercompanyrest.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Column(name = "paymentdate", nullable = false)
    private Date paymentdate;
    @OneToMany(mappedBy = "paymentByPaymentid")
    private Collection<Orders> ordersById;
    @ManyToOne
    @JoinColumn(name = "paymenttype", referencedColumnName = "id", nullable = false)
    private Paymentdictionary paymentdictionaryByPaymenttype;

    public long getId() {
        return id;
    }

    public Payment setId(long id) {
        this.id = id;
        return this;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public Payment setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                Objects.equals(paymentdate, payment.paymentdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentdate);
    }

//    public Collection<Orders> getOrdersById() {
//        return ordersById;
//    }

    public Payment setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
        return this;
    }

    public Paymentdictionary getPaymentdictionaryByPaymenttype() {
        return paymentdictionaryByPaymenttype;
    }

    public Payment setPaymentdictionaryByPaymenttype(Paymentdictionary paymentdictionaryByPaymenttype) {
        this.paymentdictionaryByPaymenttype = paymentdictionaryByPaymenttype;
        return this;
    }
}
