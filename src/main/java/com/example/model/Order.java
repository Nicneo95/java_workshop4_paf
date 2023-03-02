package com.example.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
// 1. create the order table (parent)
public class Order {
    private String orderId;
    private String notes;
    private Date orderDate;
    private String customerName;
    private String shippingAddress;
    private BigDecimal tax;
    // create a list to add the item to the list
    private List<LineItem> lineItems = new LinkedList<LineItem>();
    
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public BigDecimal getTax() {
        return tax;
    }
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void addLineItem(LineItem i) {
        this.lineItems.add(i);
    }
}
