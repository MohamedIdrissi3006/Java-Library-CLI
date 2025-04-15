package Library;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser() {
        this.operation = new IOOperations[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new Borrow(),
                new PayFine(),
                new ReturnBook(),
                new Exit()
        };
    }

    public NormalUser(String name) {
        super(name);
        this.operation = new IOOperations[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new Borrow(),
                new PayFine(),
                new ReturnBook(),
                new Exit()
        };
    }

    public NormalUser(String name, String email, String phonenumber) {
        super(name, email, phonenumber);
        this.operation = new IOOperations[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new Borrow(),
                new PayFine(),
                new ReturnBook(),
                new Exit()
        };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View Books \n");
        System.out.println("2. Search \n");
        System.out.println("3. Place Order \n");
        System.out.println("4. Borrow \n");
        System.out.println("5. calculate Fine \n");
        System.out.println("6. Return Book \n");
        System.out.println("7. Exit \n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operation[n-1].oper(database, user);

    }
    @Override
    public String toString(){
        return name+"<N/>"+email+"<N/>"+email+"<N/>"+"Normal";

    }
}
