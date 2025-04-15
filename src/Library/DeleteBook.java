package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperations {
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of the Book : ");
        String bookname = s.next();
        int i = database.getBook(bookname);
        if (i > -1) {
         database.deleteBook(i);
         System.out.println("\nbook is deleted ");
        }else {
            System.err.println(bookname + " is Not Found \n");
        }

        user.menu(database, user);
        s.close();
    }
}
