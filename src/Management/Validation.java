/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import MyObject.Customer;
import MyObject.Order;
import MyObject.Product;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import static jdk.internal.org.objectweb.asm.Opcodes.GOTO;

/**
 *
 * @author Admin
 */
public class Validation {

    public Validation() {
    }

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(int mode,int min, int max) {
        String c;
        Pattern p = Pattern.compile("^[0-9]{1,2}$");
        while (true) {
          
                System.out.print("Input your choice:");
                c = sc.nextLine();
                if(!c.isEmpty()){
                if (p.matcher(c).find()&& min <= Integer.parseInt(c) && Integer.parseInt(c) <= max) {
                    break;
                }else{
                    if(mode==2||mode==1){
                          System.err.println("Please enter an integer number in range: " + min + "-->" + max);
                    }
                    
                }
                }else{
                    if(mode==2){
                          System.err.println("Please enter an integer number in range: " + min + "-->" + max);
                    }
                    if(mode==1){
                        return 711;
                    }
                    
                    
                }
            }
         return Integer.parseInt(c);
        }
       
    

    public static String getCID(int mode, List<Customer> cList) {
        String err1 = "The customer is not exist";
        Pattern p = Pattern.compile("^C[0-9]{3}$");

        String s;
        //MODE:
        //1: Input -  customer
        //2: Update - customer
        //3: Seatch - customer
        //4: Input - order

        System.out.println("The ID must follow the format:Cxxx( x is a number(0-9))");
        while (true) {

            System.out.print("Enter ID:");
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && p.matcher(s).find() && checkCID(s, cList) == null)) {

                    break;
                } else if (mode == 1 && p.matcher(s).find() && checkCID(s, cList) != null) {
                    System.err.println("ID EXIST");
                } else if (mode == 2 && p.matcher(s).find() && checkCID(s, cList) != null) {
                    break;

                } else if (mode == 2 && p.matcher(s).find() && checkCID(s, cList) == null) {
                    System.out.println(err1);
                    return "";

                } else if (mode == 3 && p.matcher(s).find() && checkCID(s, cList) != null) {
                    break;
                } else if (mode == 3 && p.matcher(s).find() && checkCID(s, cList) == null) {
                    System.err.println(err1);
                } else if (mode == 4 && p.matcher(s).find() && checkCID(s, cList) != null) {
                    break;
                } else if (mode == 4 && p.matcher(s).find() && checkCID(s, cList) == null) {
                    System.err.println(err1);
                } else {
                    if (mode == 2) {
                        return "";
                    } else {
                        System.err.println("Error Format");
                    }
                }
            } else {
                if (mode == 3) {
                    break;
                } else {
                    System.err.println("The Id can not be empty");
                }
            }

        }
        return s;
    }

    public static Customer checkCID(String id, List<Customer> cList) {
        for (Customer o : cList) {
            if (o.getCustomerID().equals(id)) {
                return o;
            }

        }
        return null;
    }

    public static String cName(int mode, List<Customer> cList) {
        String k;
        //1-input
        //2-update
        while (true) {
            System.out.print("Input the name: ");
            k = sc.nextLine();
            if (!k.isEmpty()) {
                if (mode == 1 || mode == 2) {
                    break;
                }

            } else {
                if (mode == 2) {
                    break;
                } else {
                    System.err.println("The name can not be empty");
                }
            }
        }
        return k.toUpperCase();

    }

    public static String cAddress(int mode, List<Customer> cList) {
        String k;
        //1-input
        //2-update
        while (true) {
            System.out.print("Input the Adress: ");
            k = sc.nextLine();

            if (!k.isEmpty()) {
                if (mode == 1 || mode == 2) {
                    break;
                }

            } else {
                if (mode == 2) {
                    break;
                } else {
                    System.err.println("The adress can not be empty");
                }
            }
        }

        return k.toUpperCase();

    }

    public static String cPhonenumber(int mode, List<Customer> cList) {
        String q;
        String err1 = "The phone number is already exist";
        Pattern p = Pattern.compile("^[0-9]{10,12}$");

        while (true) {
            System.out.print("Input phone number(10-12 length): ");
            q = sc.nextLine();

            if (!q.isEmpty()) {

                if (mode == 1 && p.matcher(q).find() && checkP(q, cList) == null) {
                    break;
                } else if (mode == 1 && p.matcher(q).find() && checkP(q, cList) != null) {
                    System.err.println(err1);
                } else if (mode == 2 && p.matcher(q).find() && checkP(q, cList) != null) {
                    System.err.println(err1);

                } else if (mode == 2 && p.matcher(q).find() && checkP(q, cList) == null) {
                    break;
                } else {
                    System.err.println("The phone number must follow the format");
                }
            } else {
                if (mode == 2) {
                    break;
                } else {
                    System.err.println("The phone number can not be empty");
                }
            }
        }
        return q;

    }

    public static Customer checkP(String p, List<Customer> cList) {
        for (Customer o : cList) {
            if (o.getCustomerPhone().equals(p)) {
                return o;
            }
        }
        return null;

    }

    public static String getcNameByCID(String id, List<Customer> cList) {
        for (Customer c : cList) {
            if (c.getCustomerID().equals(id)) {
                return c.getCustomerName();
            }
        }
        return null;
    }

    public static String pOName(String id, List<Order> oList, List<Customer> cList) {

        for (Order o : oList) {
            if (o.getCustomerID().equals(id)) {
                return getcNameByCID(id, cList);
            }
        }

        return null;
    }

    public static int countC(List<Customer> cList) {
        int count = 0;
        for (Customer customer : cList) {
            count++;
        }

        return count;

    }

    public static String getChoice(int mode,List<Order> oList, List<Customer> cList) {

        String[] ctm = new String[countC(cList)];
        int i = 0;
        boolean cont = true;
        String temp = "lala";
        int count = countC(cList);
        int u = 1;

        for (Customer c : cList) {
            ctm[i] = temp;
            cont = true;
            for (int j = 0; j < u; j++) {
                if (ctm[j].equals(c.getCustomerID())) {
                    cont = false;
                    break;
                }
            }
            if (cont == true) {
                ctm[i] = c.getCustomerID();
                temp = ctm[i];
            }
            i++;
            u++;

        }

        Scanner sc = new Scanner(System.in);
        for (int h = 0; h < ctm.length; h++) {
            System.out.println((h) + "." + ctm[h]);

        }

        int choice;
       
            System.out.println("=======Customer id List======");
            System.out.println("Choosing customer id");
            choice = getInt(mode,0, countC(cList)-1);
       if(choice==711){
           return "";
       }
        for (int j = 0; j < ctm.length; j++) {
            if (choice == j) {
                return ctm[j];
            }
        }
        return null;
    }

    public static int countP(List<Product> pList) {
        int count = 0;
        for (Product p : pList) {
            count++;
        }

        return count;

    }

    public static String getPChoice(int mode,List<Order> oList, List<Product> pList) {

        String[] ctm = new String[countP(pList)];
        int i = 0;
        boolean cont = true;
        String temp = "lala";
        int count = countP(pList);
        int u = 1;

        for (Product c : pList) {
            ctm[i] = temp;
            cont = true;
            for (int j = 0; j < u; j++) {
                if (ctm[j].equals(c.getProductID())) {
                    cont = false;
                    break;
                }
            }
            if (cont == true) {
                ctm[i] = c.getProductID();
                temp = ctm[i];
            }
            i++;
            u++;

        }

        Scanner sc = new Scanner(System.in);
        for (int h = 0; h < ctm.length; h++) {
            System.out.println((h) + "." + ctm[h]);

        }

        int choice;
        
            System.out.println("=======Product id List======");
            System.out.println("Choosing product id:");
            choice = getInt(mode,0, countP(pList)-1);
     if(choice==711){
         return "";
     }
        for (int j = 0; j < ctm.length; j++) {
            if (choice == j) {
                return ctm[j];
            }
        }
        return null;
    }

    public static String getOID(int mode, List<Order> oList) {

        Pattern p = Pattern.compile("^D[0-9]{3}$");

        String s;
        String err = "The order is not exist";
        //MODE:
        //1: Input -  order
        //2: Update - oder
        //3: Delete - order
        
        System.out.println("The ID must follow the format:Dxxx( x is a number(0-9))");
        while (true) {

            System.out.print("Enter ID:");
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && p.matcher(s).find() && checkOID(s, oList) == null)) {

                    break;
                } else if (mode == 1 && p.matcher(s).find() && checkOID(s, oList) != null) {
                    System.err.println("ID EXIST");
                } else if (mode == 2 && p.matcher(s).find() && checkOID(s, oList) != null) {
                    break;

                } else if (mode == 2 && p.matcher(s).find() && checkOID(s, oList) == null) {
                    System.out.println(err);

                } else if (mode == 3 && p.matcher(s).find() && checkOID(s, oList) != null) {
                    break;
                } else if (mode == 3 && p.matcher(s).find() && checkOID(s, oList) == null) {
                  break;
                }
                 else {
                    if (mode == 2) {
                        return "";
                    }if(mode==3){
                        break;
                    }else{
                    System.err.println("Error Format");
                }
                }
            } else {
                if (mode == 3 || mode == 2) {
                    break;
                } else {
                    System.err.println("The Id can not be empty");
                }
            }

        }
        return s;
    }

    public static String getPID(int mode, List<Product> pList) {

        Pattern p = Pattern.compile("^P[0-9]{3}$");

        String s;
        String err = "The product is not exist";
        //MODE:
        //1: Input -  order
        //2: Update - order
        //3: Input - order

        System.out.println("The ID must follow the format:Pxxx( x is a number(0-9))");
        while (true) {

            System.out.print("Enter ID:");
            s = sc.nextLine();
            if (!s.isEmpty()) {
                if ((mode == 1 && p.matcher(s).find() && checkPID(s, pList) == null)) {

                    break;
                } else if (mode == 1 && p.matcher(s).find() && checkPID(s, pList) != null) {
                    System.err.println("ID EXIST");
                } else if (mode == 2 && p.matcher(s).find() && checkPID(s, pList) != null) {
                    break;

                } else if (mode == 2 && p.matcher(s).find() && checkPID(s, pList) == null) {
                    System.out.println(err);

                } else if (mode == 3 && p.matcher(s).find() && checkPID(s, pList) != null) {
                    break;
                } else if (mode == 3 && p.matcher(s).find() && checkPID(s, pList) == null) {
                    System.err.println(err);
                } else {
                    System.err.println("Error Format");
                }
            } else {

                System.err.println("The Id can not be empty");

            }

        }
        return s;
    }

    public static int getQuanity(int mode, List<Order> oList) {
        int o = 0;

        while (true) {
            System.out.print("Input Quanity:");
            try {
                o = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println("The input can not be empty and must be integer number");
            }

            if (o > 0 && mode == 1) {
                break;
            }
            if (o == 0 && mode == 2) {
                break;
            }
            if (o > 0 && mode == 2) {
                break;
            } else {
                System.err.println("Please follow the format");
            }

        }
        return o;

    }

    public static String dateO(int mode) {
        String day;
        String month;
        String year;

        while (true) {
            System.out.print("Input day: ");
            day = sc.nextLine();
            System.out.print("Input month : ");
            month = sc.nextLine();
            System.out.print("Input year: ");
            year = sc.nextLine();
            if (!day.isEmpty() || !month.isEmpty() || !year.isEmpty()) {
                if (mode == 1) {
                    break;
                }
                if(mode==2){
                    break;
                }

            } else {
                if (mode == 2) {
                    return "" ;
                } else {
                    System.err.println("The date can not be empty");
                    
                }
            }
        }

        return String.format("%s/%s/%s", day, month, year);

    }

    public static String getDateO(int mode, List<Order> oList) {
        String d;
        Pattern p = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        while (true) {
            d = dateO(mode);
            if (!d.isEmpty()) {
            if (p.matcher(d).find()&&mode==1||mode==2) {
                break;
            }
             if(!p.matcher(d).find()&&mode==1||mode==2){
                System.out.println("Invalid date");
                }
            }else {
               
                if(mode==2){
                    break;
                }
        }
        }
        return d;
    }

    public static String getStatus(int mode, List<Order> oList) {
//1-input
//2-update
        Pattern p = Pattern.compile("^[Tt]{1}$");
        Pattern a = Pattern.compile("^[Ff]{1}$");
        String k;
        while (true) {
            System.out.print("Input the status true or false(T/F): ");

            k = sc.nextLine();
            if (!k.isEmpty()) {

                if (p.matcher(k).find() && mode == 1) {
                    k = "true";
                    break;
                }
                if (a.matcher(k).find() && mode == 1) {
                    k = "false";
                    break;
                }
                if (a.matcher(k).find() && mode == 2) {
                    k = "false";
                    break;
                }

                if (p.matcher(k).find() && mode == 2) {
                    k = "true";
                    break;
                } else {
                    System.err.println("Invalid status");
                }
            } else {
                if (mode == 1) {
                    k = "false";
                    break;
                }
            }

            if (mode == 2) {
                break;
            }

        }
        return k;
    }

    public static Order checkOID(String id, List<Order> oList) {
        for (Order order : oList) {
            if (order.getOderID().equals(id)) {
                return order;
            }
        }

        return null;
    }

    public static Product checkPID(String id, List<Product> pList) {
        for (Product p : pList) {
            if (p.getProductID().equals(id)) {
                return p;
            }
        }
        return null;
    }

}
