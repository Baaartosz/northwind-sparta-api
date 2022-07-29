package com.sparta.group3.northwindtask.northwindtask.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "`order details`")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Discount", nullable = false)
    private Double discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderID", insertable = false, updatable = false)
    private Order order;

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}