package edu.sdccd.cisc191.template;
import java.util.Scanner;
import java.lang.*;
/**
 * This program will let you create a menu for your restaurant (less than 10 item with price)
 * after create a menu which will be added into  an array
 * you can edit by setting the new name and new price for the item
 * or delete the item
 * Once the Menu was created, you will have to use edit to add or change thing in there.
 */
public class Server {

    public static void main(String[] args) {
        Server m = new Server();
        int choose;
        //1 for name ,1 for price
        String[] mMenu = new String[10];
        double[] pMenu = new double[10];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the choose \n" + "1. create menu\n" + "2. edit item\n" + "3. delete item\n");
        choose = input.nextInt();
        while (choose != 0) {
            if (choose == 1) {
                m.creatMenu(mMenu,pMenu);
            }
            if (choose == 2) {
                showTool(mMenu, pMenu);
                m.editMenu(mMenu,pMenu);
            }
            if (choose == 3) {
                showTool(mMenu, pMenu);
                m.deleteMenu(mMenu,pMenu);
            }
            System.out.print("Enter the choose \n" + "1. create menu\n" + "2. edit item\n" + "3. delete item\n");
            choose = input.nextInt();
        }
    }
    //show and update the menu every times the user input data
    public static void showTool(String[] a, double[] b) {
        int y = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && (!a[i].equals("end"))) {
                System.out.printf(y + ". " + "%-20s %s\n", a[i], b[i]);
                y += 1;
            }
        }
    }
    //rearrange the array by putting null value to the end of the array
    public static void reArrray(String[] a) {
        boolean trigger = true;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] == null) && (trigger)) {
                if (i < a.length - 1) {
                    a[i] = a[i + 1];
                    trigger = false;
                }
            }
            if (!trigger) {
                if (i < a.length - 1) {
                    a[i] = a[i + 1];
                }
            }
        }
        a[a.length - 1] = null;
    }
    //rearrange the array by putting 0 value to the end of the array
    public static void repArrray(double[] a) {
        boolean trigger = true;
        for (int i = 0; i < a.length - 1; i++) {
            if ((a[i] == 0) && (trigger)) {
                if (i < a.length - 1) {
                    a[i] = a[i + 1];
                    trigger = false;
                }
            }
            if (!trigger) {
                if (i < a.length - 1) {
                    a[i] = a[i + 1];
                }
            }
        }
        a[a.length - 1] = 0;
    }
    //Create a menu with 10 item and price, the user can go back by type 'end'
    private void creatMenu(String[] a, double[] b) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter the item name: (or type 'end' to exit the menu)\n");
            a[i] = input.next();
            //condition to end the menu quicker
            if (a[i].equals("end")) {
                i = a.length;
            } else {
                System.out.print("Enter the item price:\n");
                b[i] = input.nextDouble();
            }
            //menu will update and show to the user everytime he/she input something
            showTool(a, b);
        }
    }
    //Edit menu: the user can access to the menu that was created and edit or add more item.
    private void editMenu(String[] a, double[] b){
        Scanner input = new Scanner(System.in);
        System.out.println("enter which line you want to fix: (or 0 to go back) \n");
        int c= input.nextInt();
        while (c - 1 < a.length && c != 0) {
            System.out.println("Enter the new name:");
            a[c - 1] = input.next();
            System.out.println("Enter the new price:");
            b[c - 1] = input.nextDouble();
            showTool(a, b);
            System.out.println("enter which line you want to fix: (or 0 to go back) \n");
            c = input.nextInt();
        }
    }
    //Delete menu: the user can delete any line in the menu
    private void deleteMenu(String[] a, double[] b){
        Scanner input = new Scanner(System.in);
        System.out.println("enter which line you want to delete: (or 0 to go back) \n");
        int c = input.nextInt();
        while (c != 0) {
            if (c - 1 < a.length) {
                a[c - 1] = null;
                b[c - 1] = 0;
            }
            /*after the user delete 1 line the menu will rearrange themselves
             *so when the input another number the computer know which line it is
             */
            reArrray(a);
            repArrray(b);
            showTool(a, b);
            System.out.println("enter which line you want to delete: (or 0 to go back) \n");
            c = input.nextInt();
        }
    }
}

