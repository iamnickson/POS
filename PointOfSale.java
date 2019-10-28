/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author A Nickson Joram
 */
public final class PointOfSale {
    private String itemName;
    private double price;
    private int itemNumber;

    public PointOfSale(int itemNumber, String itemName, double price) {
        this.setItemName(itemName);
        this.setPrice(price);
        this.setItemNumber(itemNumber);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int quantity) {
        this.itemNumber = quantity;
    }
    
    public static void printInvoiceHeader() {
        System.out.println(String.format("%20s %20s %20s %20s %20s","Item Number", "|", "Item", "|", "Price(LKR)" ));
        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));
    }
    
    public void printInvoice() {
        System.out.println(String.format("%20s %20s %20s %20s %20.2f ", this.getItemNumber(), "|", this.getItemName(), "|", this.getPrice() ));
    }

    public static List<PointOfSale> buildInvoice() {
        List<PointOfSale> itemList = new ArrayList<>();
        itemList.add(new PointOfSale(1, "Bread 1 Loaf", 60.00));
        itemList.add(new PointOfSale(2, "Sugar 1 Kg", 99.00));
        itemList.add(new PointOfSale(3, "Water 1 L", 80.00));
        return itemList;
    }
    
    public static void Things(int requirement[][], int cart) {
        Scanner in = new Scanner(System.in);
        List<StoreItem1> itemList = new ArrayList<>();
        itemList.add(new StoreItem1(1, "Bread 1 Loaf", 60.00));
        itemList.add(new StoreItem1(2, "Sugar 1 Kg", 99.00));
        itemList.add(new StoreItem1(3, "Water 1 L", 80.00));
        
        System.out.println("Purchased things");
        
        System.out.println(String.format("%s", "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
        System.out.println(String.format("%80s", "Welcome to MyShop PVT LTD"));
        System.out.println(String.format("%10s", "Purchase Invoice"));
        System.out.println(String.format("%10s", now()));
        
        float totalPrice=0;
        System.out.println(String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s","Item Number", "|", "Item", "|", "Unit Price(LKR)", "|", "Quantity" , "|", "Price(LKR)"));
        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------------------------------------------------"));
        for(int i=0; i<cart; i++){
            int id=requirement[0][i]-1;
            int qty=requirement[1][i];
            float price=(int) (itemList.get(id).getPrice()*qty);
            totalPrice=totalPrice+price;
            System.out.println(String.format("%15s %15s %15s %15s %15.2f %15s %15s %15s %15.2f", itemList.get(i).getItemNumber(), "|", itemList.get(i).getItemName(), "|", itemList.get(i).getPrice(), "|", qty, "|",price ));
        } 
        System.out.println("Total price : LKR "+totalPrice+"0");
        System.out.print("Cash received : LKR ");
        float cash=in.nextFloat();
        System.out.println("Balance : LKR "+(cash-totalPrice)+"0");
    }
    
    public static void print(){
        StoreItem1.printInvoiceHeader();
        StoreItem1.buildInvoice().forEach(StoreItem1::printInvoice);
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(String.format("%50s", "Welcome to MyShop PVT LTD"));
        System.out.println("Enter your user name");
        String userName = in.nextLine();
        System.out.println("Enter your password");
        String password = in.nextLine();
        String adminUserName="admin";
        String adminPassword="admin";
        String c1="cashier1";
        String c2="cashier2";

        List<String> cashier = new ArrayList<>();
        cashier.add(c1);
        cashier.add(c2);
        
        if((userName.equalsIgnoreCase(adminUserName)) && (password.equalsIgnoreCase(adminPassword))){
            System.out.println("Welcome admin");
            System.out.println("Do you want to add or remove cashier?");
            System.out.println("Add-a, Remove-r, No-n");
            String get=in.nextLine();
            if(get.equalsIgnoreCase("a")){
                System.out.println("Enter cashier user name which has to be added");
                cashier.add(in.nextLine());
            }
            else if(get.equalsIgnoreCase("r")){
                System.out.println("Enter cashier user name which has to be removed");
                String rem=in.nextLine();
                for(int i=0; i<cashier.size(); i++){
                    if(rem.equalsIgnoreCase(cashier.get(i).toString())){
                        cashier.remove(i);
                    }
                    else{
                        System.out.println("No such user name found");
                    }
                }
            }
            else if(get.equalsIgnoreCase("n")){
                System.out.println("No operation done");
            }    
        }
        else if((userName.equalsIgnoreCase(c1)) && (password.equalsIgnoreCase(c1))){
            System.out.println("Welcome Cashier1");
            System.out.println("Things availabe");
            print();
            System.out.println("How many things are there in the cart?");
            int cart=in.nextInt();
            int requirement[][]=new int[2][cart];
            for(int i=0; i<cart; i++){
                System.out.println("Select the Item Number");
                requirement[0][i]=in.nextInt();
                System.out.println("Select the Quantity");
                requirement[1][i]=in.nextInt();
            }
            Things(requirement, cart);   
        }
        else if((userName.equalsIgnoreCase(c2)) && (password.equalsIgnoreCase(c2))){
            System.out.println("Welcome Cashier2");
            System.out.println("Things availabe");
            print();
            System.out.println("How many things are there in the cart?");
            int cart=in.nextInt();
            int requirement[][]=new int[2][cart];
            for(int i=0; i<cart; i++){
                System.out.println("Select the Item Number");
                requirement[0][i]=in.nextInt();
                System.out.println("Select the Quantity");
                requirement[1][i]=in.nextInt();
            }
            Things(requirement, cart);
        }
        else{
            System.out.println("User name and Password missmatched");
        }
    }
}
