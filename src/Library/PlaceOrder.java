package Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperations {
    @Override
    public void oper(Database database, User user) {


        Order order = new Order();
        System.out.println("Enter Book Name : \n");
        Scanner s = new Scanner(System.in);
        String bookname = s.nextLine();
        int a = database.getBook(bookname);
        if (a <= -1) {
            System.out.println("Book nor found \n");

        } else {
            Book book = database.getBook(a);
            order.setBook(book);
            order.setNormalUser(user);
            System.out.println("Enter Qty : \n");
            int qty = s.nextInt();
            order.setQty(qty);
            order.setPrice(book.getPrice()*qty);
            book.setQty(book.getQty()-qty);
            database.AddOrder(order,book,a);
            System.out.println("Order placed successfully  ");
        }
     user.menu(database,user);

    }
}
