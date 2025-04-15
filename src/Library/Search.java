package Library;

import java.util.Scanner;

public class Search implements IOOperations{
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter name of the Book : ");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        int i = database.getBook(name);
          if(i >-1){
        String bookname = database.getBook(i).toString2();
        System.out.println(bookname);
        } else
        {
            System.out.println("Enter name of the Book : ");
        }

          user.menu(database,user);
    }
}
