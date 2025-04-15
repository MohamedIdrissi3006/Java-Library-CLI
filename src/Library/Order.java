package Library;

public class Order {


    private Book book;
    private User NormalUser;
    private double price;
    private int Qty;

    public Order() {

    }

    public Order(Book book, User normalUser, double price, int qty) {
        this.book = book;
        NormalUser = normalUser;
        this.price = price;
        Qty = qty;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getNormalUser() {
        return NormalUser;
    }

    public void setNormalUser(User normalUser) {
        NormalUser = normalUser;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return " book name : " + book.getName() + "\n" +
                " Username : " + NormalUser.getName() + "\n" +
                " the price of the order : " + price + "\n" +
                " and Quantity" + Qty + "\n"  ;
    }

    public java.lang.String toString2() {
        return book.getName() + "<N/>" +
                NormalUser.getName() + "<N/>" +
                price + "<N/>" +
                +Qty + "<N/>" ;
    }
}
