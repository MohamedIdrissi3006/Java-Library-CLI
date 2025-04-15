package Library;

import java.util.Scanner;

public class Addbook implements IOOperations {

    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter Book Name :");
        String name = s.next();

        if (database.getBook(name) > -1) {
            System.out.println("Book Name already exists !");
            user.menu(database, user);
            return;
        }

            book.setName(name);
            System.out.println("Enter Arthur Name :");
            book.setAuthor(s.next());
            System.out.println("Enter Publisher Name :");
            book.setPublisher(s.next());

            System.out.println("Enter Address Name :");
            book.setAdress(s.next());
            System.out.println("Enter Statut Name :");
            book.setStatut(s.next());
            System.out.println("Enter Quatitiy :");
            book.setQty(s.nextInt());
            System.out.println("Enter Price :");
            book.setPrice(s.nextDouble());
            System.out.println("Enter brwCopies :");
            book.setBrwcopies(s.nextInt());
            System.out.println(book);
            database.AddBook(book);
            System.out.println("Book added successfully\n");
            user.menu(database, user);

    }
}
