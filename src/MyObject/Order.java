/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyObject;


/**
 *
 * @author Admin
 */
public class Order {
    private String orderID;
    private String customerID;
    private String productID;
    private int orderQuanity;
    private String orderDate;
    private String status;

    public Order() {
    }

    public Order(String orderID, String customerID, String productID, int orderQuanity, String orderDate, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.productID = productID;
        this.orderQuanity = orderQuanity;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getOrderQuanity() {
        return orderQuanity;
    }

    public void setOrderQuanity(int orderQuanity) {
        this.orderQuanity = orderQuanity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
return String.format("%s,%s,%s,%d,%s,%s\n", orderID,customerID,productID,orderQuanity,orderDate,status);
    }
    
    
    
}
