package Library;

import java.util.Scanner;

public class Borrow implements IOOperations{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of the Book : ");
        String bookname = s.next();
        int i = database.getBook(bookname);
        if (i > -1) {
           Book book = database.getBook(i);
            System.out.println("\nbook is deleted ");
            if(book.getBrwcopies()>1){
                Borrowing borowwing = new Borrowing(book,user);
            }
        }else {
            System.err.println(bookname + " is Not Found \n");
        }
        user.menu(database, user);
    }
}
