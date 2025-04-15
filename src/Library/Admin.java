package Library;

import java.util.Scanner;

public class Admin extends User{


    public Admin() {
        this.operation = new IOOperations[]{

                new ViewBooks(),
                new Search(),
                new Addbook(),
                new DeleteBook(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()

        };
    }

    public Admin(String name) {
        super(name);
        this.operation = new IOOperations[]{

                new ViewBooks(),
                new Search(),
                new Addbook(),
                new DeleteBook(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()

    };
    }

    public Admin(String name, String email, String phonenumber) {
        super(name, email, phonenumber);
        this.operation = new IOOperations[]{
                new ViewBooks(),
                new Search(),
                new Addbook(),
                new DeleteBook(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit(),

        };
    }

    @Override
    public void menu(Database database, User user){
        System.out.println("1. View Books \n");
        System.out.println("2. Search \n");
        System.out.println("3. Add Book \n");
        System.out.println("4. Delete Book \n");
        System.out.println("5. Delete all Data \n");
        System.out.println("6. View Orders \n");
        System.out.println("7. Exit \n");

        Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         System.out.println( this.operation[n-1]);
        this.operation[n-1].oper(database,user);

}
@Override
    public String toString(){
        return name+"<N/>"+email+"<N/>"+email+"<N/>"+"Admin";

    }

}

