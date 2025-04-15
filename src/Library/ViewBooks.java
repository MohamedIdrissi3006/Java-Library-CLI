package Library;

import java.util.ArrayList;

public class ViewBooks implements IOOperations{
    @Override
    public void oper(Database database, User user) {
        ArrayList<Book> books = database.getAllBooks();

        System.out.println("Name Author Publisher Location Statut Quantity Price Borrwoed Copies ");
    for(Book b :books){
        System.out.println(b.getName()+ "\t"+ "\t"+ b.getAuthor()+"\t"+ "\t"+  b.getPublisher()+"\t"+ "\t"+ b.getAdress()+"\t"+
                "\t"+b.getStatut()+"\t"+"\t"+ b.getQty()+"\t"+"\t"+ b.getPrice()+"\t"+"\t"+ b.getBrwcopies());
    }
    user.menu(database, user);
    }
}
