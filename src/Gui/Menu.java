/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Management.Management;
import Management.Validation;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {

    private static Scanner sc = new Scanner(System.in);
    private static String[] ops = {
        "Print all Product",
        " Print all Customer Information",
        "Search a customer by his/her ID",
        "Add new Customer",
        "Update Customer",
        "Print all Orders",
        "Print all pending Orders",
        "Add new Orders",
        "Update Order",
        "Exist"
    };

    private static int getChoice() {

        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + "." + ops[i]);

        }
        return Validation.getInt(2,01, ops.length);

    }

    public static void display() {
        Management m = new Management();

        int choice;
        m.pLoad();
        m.cLoad();
        m.oLoad();

        do {
            System.out.println("  ====Publisher Management====  ");
            choice = getChoice();

            switch (choice) {
                case 1:
                    String c;
                    boolean r = true;
                    boolean l = true;
                    do {
                        m.listProducts();

                        do {
                            System.out.println("Do you want to back to menu(Y/N): ");

                            c = sc.nextLine();
                            if (c.equals("y") || (c.equals("Y"))) {
                                r = false;
                                l = false;
                            } else if (c.equals("n") || (c.equals("N"))) {
                                r = true;
                                l = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                l = true;

                            }
                        } while (l);
                    } while (r);
                    break;
                case 2:

                    Scanner op = new Scanner(System.in);
                    String q;
                    boolean p = true;
                    boolean n = true;
                    do {
                        m.listCustomers();

                        do {
                            System.out.println("Do you want to back to menu: ");

                            c = op.nextLine();
                            if (c.equals("y") || (c.equals("Y"))) {
                                p = false;
                                n = false;
                            } else if (c.equals("n") || (c.equals("N"))) {
                                p = true;
                                n = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                n = true;

                            }
                        } while (n);
                    } while (p);
                    break;

                case 3:

                    String ww;
                    boolean cc = true;
                    boolean vv = true;
                    do {
                        m.searchCustomer();

                        do {
                            System.out.println("Do you want to back to menu(Y/N): ");

                            ww = sc.nextLine();
                            if (ww.equals("y") || (ww.equals("Y"))) {
                                cc = false;
                                vv = false;
                            } else if (ww.equals("n") || (ww.equals("N"))) {
                                cc = true;
                                vv = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                vv = true;

                            }
                        } while (vv);
                    } while (cc);
                    break;

                case 4:

                    Scanner kl = new Scanner(System.in);
                    String o;
                    boolean u = true;
                    boolean i = true;
                    do {
                        m.addCustomer();
                        m.cLoad();
                        do {

                            System.out.println("Do you want to back to menu(Y/N): ");

                            o = kl.nextLine();
                            if (o.equals("Y") || (o.equals("y"))) {
                                u = false;
                                i = false;
                            } else if (o.equals("n") || (o.equals("N"))) {
                                u = true;
                                i = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                i = true;

                            }
                        } while (i);
                    } while (u);

                    break;
                case 5:
                    Scanner sf = new Scanner(System.in);
                    String h;
                    boolean d = true;
                    boolean f = true;
                    do {
                        m.updateCustomer();
                        m.cLoad();
                        do {

                            System.out.println("Do you want to back to menu(Y/N): ");

                            h = sf.nextLine();
                            if (h.equals("Y") || (h.equals("y"))) {
                                d = false;
                                f = false;
                            } else if (h.equals("n") || (h.equals("N"))) {
                                d = true;
                                f = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                f = true;

                            }
                        } while (f);
                    } while (d);
                    break;
                case 6:

                    Scanner rt = new Scanner(System.in);
                    String e;
                    boolean a = true;
                    boolean v = true;
                    do {
                        System.out.println("The list of customers: ");
                        m.listCustomers();
                        m.displayOrder();
                        do {

                            System.out.println("Do you want to back to menu(Y/N): ");

                            e = rt.nextLine();
                            if (e.equals("Y") || (e.equals("y"))) {
                                a = false;
                                v = false;
                            } else if (e.equals("N") || (e.equals("n"))) {
                                a = true;
                                v = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                v = true;

                            }
                        } while (v);
                    } while (a);
                    break;

                case 7:

                    Scanner bm = new Scanner(System.in);
                    String g;
                    boolean w = true;
                    boolean z = true;
                    do {
                        m.displayPendingOrders();
                        do {

                            System.out.println("Do you want to back to menu(Y/N): ");
                            g = bm.nextLine();
                            if (g.equals("y") || (g.equals("Y"))) {
                                w = false;
                                z = false;
                            } else if (g.equals("n") || (g.equals("N"))) {
                                w = true;
                                z = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                z = true;
                            }
                        } while (z);
                    } while (w);

                    break;
                case 8:

                    String nm;
                    boolean mm = true;
                    boolean nn = true;
                    do {
                        m.addOrder();
                        m.oLoad();
                        do {

                            System.out.println("Do you want to back to menu(Y/N): ");
                            nm = sc.nextLine();
                            if (nm.equals("y") || (nm.equals("Y"))) {
                                mm = false;
                                nn = false;
                            } else if (nm.equals("n") || (nm.equals("N"))) {
                                mm = true;
                                nn = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                nn = true;
                            }
                        } while (nn);
                    } while (mm);

                    break;
                case 9:
                    String oo;
                    boolean ii = true;
                    boolean ll = true;
                    do {
                        m.updateOrder();
                        m.oLoad();
                        do {

                            System.out.println("Do you want to back to menu(Y/N): ");
                            oo = sc.nextLine();
                            if (oo.equals("y") || (oo.equals("Y"))) {
                                ii = false;
                                ll = false;
                            } else if (oo.equals("n") || (oo.equals("N"))) {
                                ii = true;
                                ll = false;
                            } else {
                                System.out.println("Please choose Y/N!");
                                ll = true;
                            }
                        } while (ll);
                    } while (ii);

                    break;

            }
        } while (choice != 10);
    }
}
