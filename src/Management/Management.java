/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import MyObject.Customer;
import MyObject.Order;
import MyObject.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Management {

    private Scanner sc = new Scanner(System.in);
    private List<Product> pList;
    private List<Customer> cList;
    private List<Order> oList;

    public Management() {
        pList = new ArrayList<>();
        cList = new ArrayList<>();
        oList = new ArrayList<>();
    }

    public void pSAVE() {
        try {
            File f = new File("products.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Product o : pList) {
                bw.write(o.toString());

            }

            bw.close();

            fw.close();
            System.out.println("Saved successful");

        } catch (IOException ex) {
                ex.printStackTrace();
        }

    }

    public void cSAVE() {
        try {
            File f = new File("customers.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Customer o : cList) {
                bw.write(o.toString());

            }

            bw.close();

            fw.close();
            System.out.println("Saved successful");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void oSAVE() {
        try {
            File f = new File("orders.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Order o : oList) {
                bw.write(o.toString());

            }

            bw.close();

            fw.close();
            System.out.println("Saved successful");

        } catch (IOException ex) {
           ex.printStackTrace();

        }
    }

    public void pLoad() {
        try {
            File f = new File("products.txt");

            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[,]");
                String productID = info[0].trim();
                String productName = info[1].trim();
                String unit = info[2].trim();
                String origin = info[3].trim();
                double price = Double.parseDouble(info[4].trim());
                pList.add(new Product(productID, productName, unit, origin, price));

            }

            br.close();

            fr.close();
        } catch (IOException e) {
            System.out.println("Load fails");
        }
    }

    public void cLoad() {
        try {
            File f = new File("customers.txt");

            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[,]");
                String customerID = info[0].trim();
                String customerName = info[1].trim();
                String customerAddress = info[2].trim();
                String customerPhone = info[3].trim();

                cList.add(new Customer(customerID, customerName, customerAddress, customerPhone));

            }

            br.close();

            fr.close();
        } catch (IOException e) {
            System.out.println("Load fails");
        }
    }

    public void oLoad() {
        try {
            File f = new File("orders.txt");

            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[,]");
                String oderID = info[0].trim();
                String customerID = info[1].trim();
                String productID = info[2].trim();
                int orderQuanity = Integer.parseInt(info[3].trim());
                String orderDate = info[4].trim();
                String status = info[5].trim();

                oList.add(new Order(oderID, customerID, productID, orderQuanity, orderDate, status));

            }

            br.close();

            fr.close();
        } catch (IOException e) {
            System.out.println("Load fails");
        }
    }

    public void listProducts() {
        System.out.println(pList);

    }

    public void listCustomers() {
        System.out.println(cList);
    }

    public void searchCustomer() {
        this.listCustomers();
        String ID = Validation.getCID(3, cList);
        for (Customer o : cList) {
            if (o.getCustomerID().equals(ID)) {
                System.out.println(o);
                break;
            } else if (ID.equals("")) {
                System.out.println(cList);
                break;
            }

        }
    }

    public void addCustomer() {
        this.listCustomers();
        String customerID = Validation.getCID(1, cList);
        String customerName = Validation.cName(1, cList);
        String customerAddress = Validation.cAddress(1, cList);
        String customerPhone = Validation.cPhonenumber(1, cList);
        cList.add(new Customer(customerID, customerName, customerAddress, customerPhone));
        this.cSAVE();
        cList.removeAll(cList);

    }

    public void NAME() {
        for (Order o : oList) {
            System.out.println(Validation.pOName(o.getCustomerID(), oList, cList));
        }

    }

    public void Psort() {
        try {
            Collections.sort(oList, new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return Validation.pOName(o1.getCustomerID(), oList, cList).compareTo(Validation.pOName(o2.getCustomerID(), oList, cList));
                }
            });
        } catch (Exception e) {
            System.out.println("Sort fails");
        }
    }

    public void displayOrder() {

        this.Psort();
        System.out.println("The list of orders: ");
        System.out.println(oList);
    }

    public void updateCustomer() {

        String customerID;
        String customerName;
        String customerAddress;
        String customerPhone;
        String id;
        String name;
        String address;
        String phone;
        this.listCustomers();
        System.out.println("Enter Customer's ID:");
        customerID = Validation.getCID(2, cList);
        if (!customerID.equals("")) {
            for (Customer o : cList) {
                if (o.getCustomerID().equals(customerID)) {
                    name = o.getCustomerName();
                    address = o.getCustomerAddress();
                    phone = o.getCustomerPhone();

                    customerName = Validation.cName(2, cList);
                    customerAddress = Validation.cAddress(2, cList);
                    customerPhone = Validation.cPhonenumber(2, cList);
                    if (customerName.equals("")) {
                        o.setCustomerName(name);
                    } else {
                        o.setCustomerName(customerName);
                    }
                    if (customerAddress.equals("")) {
                        o.setCustomerAddress(address);

                    } else {
                        o.setCustomerAddress(customerAddress);
                    }
                    if (customerPhone.equals("")) {
                        o.setCustomerPhone(phone);
                    } else {
                        o.setCustomerPhone(customerPhone);
                    }
                    System.out.println("Update successfully");
                }

            }
        } else {
            System.out.println("There is no customer match!!");
            System.out.println("Update failse");
        }
        this.cSAVE();
        cList.removeAll(cList);
    }

    public void addOrder() {
        System.out.println("=======Order List======");
        this.displayOrder();
        String oderID = Validation.getOID(1, oList);
        System.out.println("=======Customer id List======");
        String customerID = Validation.getChoice(2, oList, cList);
        System.out.println("=======Product id List======");
        String productID = Validation.getPChoice(2, oList, pList);
        int orderQuanity = Validation.getQuanity(1, oList);
        String orderDate = Validation.getDateO(1, oList);
        String status = Validation.getStatus(1, oList);
        oList.add(new Order(oderID, customerID, productID, orderQuanity, orderDate, status));
        this.oSAVE();
        oList.removeAll(oList);

    }

    public void inputInformationOrde() {
        String orderID;
        String customerID;
        String productID;
        String orderQuanity;
        String orderDate;
        String status;

        String cid;
        String pid;
        int q;
        String d;
        String s;

        Pattern p = Pattern.compile("^[0-9]{1,15}$");
        System.out.println("Enter Customer's ID:");
        System.out.println("=======Order List======");
        this.displayOrder();
        System.out.println("=======Order List======");
        orderID = Validation.getOID(2, oList);
        if (!orderID.equals("")) {
            for (Order o : oList) {
                if (o.getOderID().equals(orderID)) {
                    cid = o.getCustomerID();
                    pid = o.getProductID();
                    q = o.getOrderQuanity();
                    d = o.getOrderDate();
                    s = o.getStatus();
                    System.out.println("=======Customer id List======");
                    customerID = Validation.getChoice(1, oList, cList);
                    System.out.println("=======Product id List======");
                    productID = Validation.getPChoice(1, oList, pList);

                    do {
                        System.out.print("Input the quanity: ");
                        orderQuanity = sc.nextLine();
                        if (!orderQuanity.isEmpty()) {
                            if (p.matcher(orderQuanity).find()) {
                                o.setOrderQuanity(Integer.parseInt(orderQuanity));
                                break;
                            } else {
                                System.err.println("Wrong format");
                            }
                        }else{
                            break;
                        }
                    } while (true);
                    orderDate = Validation.getDateO(2, oList);
                    status = Validation.getStatus(2, oList);

                    if (customerID.equals("")) {
                        o.setCustomerID(cid);
                    } else {
                        o.setCustomerID(customerID);
                    }
                    if (productID.equals("")) {
                        o.setProductID(pid);
                    } else {
                        o.setProductID(productID);
                    }
                    if (orderQuanity.equals("")) {
                        o.setOrderQuanity(q);
                    }

                    if (orderDate.equals("")) {
                        o.setOrderDate(d);
                    } else {
                        o.setOrderDate(orderDate);
                    }
                    if (status.equals("")) {
                        o.setStatus(s);
                    } else {
                        o.setStatus(status);
                    }
                    System.out.println("Update successfull");
                    this.oSAVE();
                }
            }

        } else {
            System.err.println("Update fails");
        }

        oList.removeAll(oList);
    }

    public void deleteO() {
        String choice;
        System.out.println("=======Order List======");
        this.displayOrder();
        System.out.println("=======Order List======");
        System.out.println("Input the id: ");

        String or = Validation.getOID(3, oList);
        int count = 0;
        if (!or.isEmpty()) {
            System.out.println("are you sure to delete this order('y' to confirm and another key to cancel)");
            choice = sc.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                for (Order o : oList) {
                    if (o.getOderID().equals(or)) {
                        oList.remove(o);
                        System.out.println("Delete sucessful");
                        System.out.println("=======Order List======");
                        this.displayOrder();
                        System.out.println("=======Order List======");
                        count++;
                        this.oSAVE();
                        break;

                    }

                }
                if (count == 0) {
                    System.err.println("Unmatched id");
                    System.err.println("Delete fails");

                }
            } else {
                System.err.println("The id can not be empty");
                System.err.println("Delete fails");

            }

            oList.removeAll(oList);
        }
    }

    public void updateOrder() {
       
        System.out.println("1-Update information");
        System.out.println("2-Delete order");

        String choice;
        while (true) {
             System.out.print("Please input your choice:");
            choice = sc.nextLine();
            if (choice.equals("1")) {
                this.inputInformationOrde();
                break;
            }
            if (choice.equals("2")) {
                this.deleteO();
                break;
            } else {
                System.err.println("Pleae input valid option");
            }

        }
    }

    public void displayPendingOrders() {

        this.displayOrder();
        System.out.println("The list of pending order: ");
        for (Order o : oList) {
            if (o.getStatus().equals("false")) {
                System.out.println(o);
            }
        }
    }

}
