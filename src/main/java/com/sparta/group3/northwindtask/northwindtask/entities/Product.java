//package com.sparta.group3.northwindtask.northwindtask.entities;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "products")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ProductID", nullable = false)
//    private Integer id;
//
//    @Column(name = "ProductName", nullable = false, length = 40)
//    private String productName;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "SupplierID")
//    private Supplier supplierID;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CategoryID")
//    private Category categoryID;
//
//    @Column(name = "QuantityPerUnit", length = 20)
//    private String quantityPerUnit;
//
//    @Column(name = "UnitPrice", precision = 10, scale = 4)
//    private BigDecimal unitPrice;
//
//    @Column(name = "UnitsInStock")
//    private Integer unitsInStock;
//
//    @Column(name = "UnitsOnOrder")
//    private Integer unitsOnOrder;
//
//    @Column(name = "ReorderLevel")
//    private Integer reorderLevel;
//
//    @Column(name = "Discontinued", nullable = false)
//    private Boolean discontinued = false;
//
//    @OneToMany(mappedBy = "id")
//    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public Supplier getSupplierID() {
//        return supplierID;
//    }
//
//    public void setSupplierID(Supplier supplierID) {
//        this.supplierID = supplierID;
//    }
//
//    public Category getCategoryID() {
//        return categoryID;
//    }
//
//    public void setCategoryID(Category categoryID) {
//        this.categoryID = categoryID;
//    }
//
//    public String getQuantityPerUnit() {
//        return quantityPerUnit;
//    }
//
//    public void setQuantityPerUnit(String quantityPerUnit) {
//        this.quantityPerUnit = quantityPerUnit;
//    }
//
//    public BigDecimal getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(BigDecimal unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//    public Integer getUnitsInStock() {
//        return unitsInStock;
//    }
//
//    public void setUnitsInStock(Integer unitsInStock) {
//        this.unitsInStock = unitsInStock;
//    }
//
//    public Integer getUnitsOnOrder() {
//        return unitsOnOrder;
//    }
//
//    public void setUnitsOnOrder(Integer unitsOnOrder) {
//        this.unitsOnOrder = unitsOnOrder;
//    }
//
//    public Integer getReorderLevel() {
//        return reorderLevel;
//    }
//
//    public void setReorderLevel(Integer reorderLevel) {
//        this.reorderLevel = reorderLevel;
//    }
//
//    public Boolean getDiscontinued() {
//        return discontinued;
//    }
//
//    public void setDiscontinued(Boolean discontinued) {
//        this.discontinued = discontinued;
//    }
//
//    public Set<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(Set<OrderDetail> orderDetails) {
//        this.orderDetails = orderDetails;
//    }
//
//}