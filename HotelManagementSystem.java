/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hotelmanagementsystem;

import java.util.*;
import java.io.*;

class Hotel {
    
    protected static ArrayList <RestaurantCustomer> RestaurantCustomerList = new ArrayList <>();
    protected static ArrayList <RoomCustomer> RoomCustomerList = new ArrayList <>();
    protected static ArrayList <Manager> ManagerList = new ArrayList <>();
    protected static ArrayList <Rooms> RoomsList = new ArrayList <>();
    protected static ArrayList <Reception> ReceptionstaffList = new ArrayList <>();
    protected static ArrayList <Restaurant> RestaurantList = new ArrayList <>();
}

class Customer{
    Scanner sc=new Scanner (System.in);
    protected String name, address, ID;
    protected long phone;

    public Customer(){}

    public Customer(String name, String address, String ID, long phone) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.phone = phone;
    }
    
    void printCustomer(){
        System.out.println("Name: "+this.name);
        System.out.println("Address: "+this.address);
        System.out.println("ID: "+this.ID);
        System.out.println("Phone: "+this.phone);
    }
}

class RestaurantCustomer extends Customer{
    Scanner sc=new Scanner (System.in);
    private double bill;
    private Restaurant restaurant;

    public RestaurantCustomer(){}

    public RestaurantCustomer(String name, String address, String ID, long phone, double bill, boolean book, Restaurant restaurant) 
    {
        super(name, address, ID, phone);
        this.bill = bill;
        this.restaurant = restaurant;
    } 
}

class RoomCustomer extends Customer{
    Scanner sc=new Scanner (System.in);
    private double bill;
    private boolean book;
    private Rooms room;

    public RoomCustomer() {
    }

    public RoomCustomer(double bill, boolean book, Rooms room, String name, String address, String ID, long phone) {
        super(name, address, ID, phone);
        this.bill = bill;
        this.book = book;
        this.room = room;
    }
}

class Rooms {
    Scanner sc=new Scanner (System.in);
    private int price, duration;
    private String type, no; 
    private boolean availability;

    public Rooms() {
    }

    public Rooms(int price, String type, String no) {
        this.price = price;
        this.duration = 0;
        this.type = type;
        this.no = no;
        this.availability = true;
    }
    
    void displayRoomDDetail(){
        System.out.println("Room Number: "+this.no);
        System.out.println("Price: "+this.price);
        System.out.println("Type: "+this.type);
        if(availability)
        {
            System.out.println("Available");  
        }
        else
        {
            System.out.println("Booked");
        }
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

class Restaurant{
    Scanner sc=new Scanner (System.in);
    String name, cuisine;
    ArrayList <Dish> Menu = new ArrayList<>();  
    
    public Restaurant() {}

    public Restaurant(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<Dish> getMenu() {
        return Menu;
    }

    public void setMenu(ArrayList<Dish> Menu) {
        this.Menu = Menu;
    }
    
    class Dish{
      String dishName, dishType;
      float price;

        public Dish() {
        }

        public Dish(String dishName, String dishType, float price) {
            this.dishName = dishName;
            this.dishType = dishType;
            this.price = price;
        }

        public String getDishName() {
            return dishName;
        }

        public void setDishName(String dishName) {
            this.dishName = dishName;
        }

        public String getDishType() {
            return dishType;
        }

        public void setDishType(String dishType) {
            this.dishType = dishType;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
}
    
    public void displayMenu(){
        System.out.println("MENU");
        System.out.println("\nSTARTERS");
        for(Dish d : Menu)
        {
            if(d.getDishType().equals("Starter"))
            {
                System.out.println(d.dishName + "Rs." + d.getPrice());
            }
        }
        System.out.println("\nMAIN COURSE");
        for(Dish d : Menu)
        {
            if(d.getDishType().equals("MainCousre"))
            {
                System.out.println(d.dishName + "Rs." + d.getPrice());
            }
        }
        System.out.println("\nDESSERT");
        for(Dish d : Menu)
        {
            if(d.getDishType().equals("Desert"))
            {
                System.out.println(d.dishName + "Rs." + d.getPrice());
            }
        }
    }
        
    public void addDish(){
    System.out.println("Enter Dish Name: ");
    String dn = sc.next();
    System.out.println("Enter Dish Type: ");
    String dt = sc.next();
    System.out.println("Enter Dish Price: ");
    float dp = sc.nextFloat();
    Dish d = new Dish(dn, dt, dp);
    this.Menu.add(d);
    }
    
    public void deleteDish()
    {
        Dish dish = null;
        
        System.out.println("Enter Dish Name: ");
        String dn = sc.next();
        
        for(Dish d : Menu)
        {
            if(d.getDishName().equals(dn))
            {
                dish = d;
            }
        }
        
        Menu.remove(dish);
        dish = null;
    }
    
    public void updateDish(Dish d)
    {
        System.out.println("Enter the update of price");
        int newPrice = sc.nextInt();
        d.setPrice(newPrice);
    }
    
    public void selectDish()
    {   
        
    }
    
    public void display()
    {
        System.out.println("\nName: "+this.name);
        System.out.println("Cuisine: "+this.cuisine);
    }
}

class Manager extends Hotel{
    Scanner sc=new Scanner (System.in);
    private String name, userName, password;
    private long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public void addRooms(){
        System.out.println("Enter Room Number: ");
        String n = sc.next();
        System.out.println("Enter Price: ");
        int p = sc.nextInt();
        System.out.println("Enter Type");
        String t = sc.next();
        Rooms r = new Rooms(p, t, n);
        RoomsList.add(r);
    }
    
    public void updateRooms(Rooms r){
        System.out.println("Enter what kind of updates you want to make");
        String x = sc.next();
        
        if(x.equals("Type"))
        {
            System.out.println("Enter the update of type");
            String newType = sc.next();
            if(newType.equals("Single")||newType.equals("Double"))
            {
                r.setType(newType);
            }
        }
        else if(x.equals("Price"))
        {
            System.out.println("Enter the update of price");
            int newPrice = sc.nextInt();
            r.setPrice(newPrice);
        }
    }
    
    public void addDish(Restaurant r)
    {
        r.addDish();
    }
    
    public void deleteDish(Restaurant r)
    {
        r.deleteDish();
    }
    
    public void updateDish(Restaurant r)
    {
        r.displayMenu();
        String name;
        for(Dish d : r.Menu)
        {
            if()
            {
                r.updateDish(d);
            }
        }
        
    }
    
}

class Reception extends Hotel{
    Scanner sc=new Scanner (System.in);
    private RestaurantCustomer restaurant_customer;
    private RoomCustomer room_customer;
    private Restaurant restaurant;
    
    void checkIn()
    {
        System.out.println("Enter Your ID");
        String pn = sc.next();
        
        
    }
    
    void displayRooms(){
        for(Rooms r : RoomsList)
        {
            System.out.println("\n");
            r.displayRoomDDetail();
        }
        
    }
    
    void displayMenu(){
        System.out.println("Enter the restaurant you whose menu you want to see");
        String rn = sc.next();
        for(Restaurant r : RestaurantList)
        {
            if(r.equals(rn))
            {
                r.displayMenu();
            }
        }
    }
    
    void selectChoice(){
        String id, n, ad;
        long cnt;
                
        int choice;
        System.out.println("Enter 1.Resturant 2.Rooms");
        choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter ID: ");
                id = sc.next();
                System.out.println("Enter Name: ");
                n = sc.next();
                System.out.println("Enter Contact Number: ");
                cnt = sc.nextLong();
                System.out.println("Enter Address: ");
                ad = sc.next();
                Rooms r = booking();
            break;

            case 2:
                System.out.println("Enter ID: ");
                id = sc.next();
                System.out.println("Enter Name: ");
                n = sc.next();
                System.out.println("Enter Contact Number: ");
                cnt = sc.nextLong();
                System.out.println("Enter Address: ");
                ad = sc.next();
                Restaurant rst = selectRestaurant();
            break;    
                  
            }
        }
    
    Rooms booking(){
        Rooms room = null;
        
        System.out.println("Which room do you want?");
        System.out.println("1. Single Bed Room");
        System.out.println("2. Double Bed Room");
        int n = sc.nextInt();
        System.out.println("Enter the number of days you want to stay to:");
        int d = sc.nextInt();
        
        switch(n)
        {
            case 1:
                for (Rooms r : RoomsList)
                {
                    if(r.getType().equals("Single"))
                    {
                        room = r;
                        r.setAvailability(false);
                        r.setDuration(d);
                        break;
                    }
                }
            break;
            
            case 2:
                for (Rooms r : RoomsList)
                {
                    if(r.getType().equals("Double"))
                    {
                        room = r;
                        r.setAvailability(false);
                        r.setDuration(d);
                        break;
                    }
                }
            break;   
        }
        return room;
    }
    
    void vacateRooms(String no){
        Rooms room = null;
        
        for(Rooms r : RoomsList)
        {
            if(r.getNo().equals(no))
            {
                r.setAvailability(true);
                r.setDuration(0);
                break;
            }
        }
    }
    
    Restaurant selectRestaurant()
    {
        Restaurant restauarnt = null;
        for(Restaurant r : RestaurantList)
        {
            r.display();
        }
        
        String rname = sc.next();
        
        for(Restaurant r : RestaurantList)
        {
            if(r.getName().equals(rname))
            {
                restaurant = r;
            }
        }
        return restaurant;
    }
}

public class HotelManagementSystem {
    
}
