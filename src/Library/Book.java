package Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Book {
    private String name;
    private String Author;
    private String publisher;
    private String adress;
    private String statut;
    private int qty;
    private double price;
    private int brwcopies;

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBrwcopies() {
        return brwcopies;
    }

    public void setBrwcopies(int brwcopies) {
        this.brwcopies = brwcopies;
    }


    public Book(String name, String author, String publisher, String adress, String statut, int qty, double price, int brwcopies) {
        this.name = name;
        Author = author;
        this.publisher = publisher;

        this.adress = adress;
        this.statut = statut;
        this.qty = qty;
        this.price = price;
        this.brwcopies = brwcopies;

    }


    @Override
    public java.lang.String toString() {
        return name + "<N/>" +
                Author + "<N/>" +
                publisher + "<N/>" +
                adress + "<N/>" +
                statut + "<N/>" +
                +qty + "<N/>" +
                +price + "<N/>" +brwcopies;
    }


    public String toString2() {
        return "Book: " +
                "name : '" + name + '\'' +
                ", Author: '" + Author + '\'' +
                ", publisher : '" + publisher + '\'' +
                ", adress : '" + adress + '\'' +
                ", statut : '" + statut + '\'' +
                ", quantity : '" + qty +
                ", price : '" + price +
                ", borrow copies : '" + brwcopies ;
    }
//    public ArrayList<String> toList(){
//        ArrayList<String> list = new ArrayList<String>;
//    }







}
