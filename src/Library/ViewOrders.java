package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrders implements IOOperations {
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter Book name : ");
        Scanner s = new Scanner(System.in);
        String bookname = s.nextLine();
        int i = database.getBook(bookname);
        System.out.println(i);
        if (i > -1) {

            System.out.println("Book\t\tUser\t\tPrice\t\tQty\n");
            database.getAllOrders();
            for (Order order : database.getAllOrders()) {

                if (order.getBook().getName().matches(bookname)) {
                    System.out.println(order.getBook().getName()+"\t\t"+order.getNormalUser().getName()+"\t\t"+order.getPrice()+"\t\t"+order.getQty());
                }
            }
        } else {
            System.out.println("Book does not exist : ");
        }
        user.menu(database,user);
    }
}
