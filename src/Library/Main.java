package Library;


import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Database database;
    static Scanner s;
    static int num = -1;




    public static void main(String[] args) {
        database = new Database();


        System.out.println("Welcome ro Lirary Managment System");
        s = new Scanner(System.in);




        do{

        System.out.println(" \n" + "0. Exit \n" + "1. Login \n" + "2.New User");

            while (!s.hasNextInt()) {  // Ensures the input is a valid integer
                System.out.println("Invalid input. Please enter a number.");
                s.next(); // Consume the invalid input
            }

            num = s.nextInt();

        switch (num) {
            case 0:
                System.exit(0);
                break;
            case 1:
                login();
                break;
            case 2:
                SignUp();
                break;

            default:
                System.out.println("Please choose either Option 1 or 2 !");
        }

    } while(num !=0);

}


    private static void login() {
        System.out.println("please enter Phone Number");
        String phonenumber = s.next();
        System.out.println("please enter Email");
        String email = s.next();
        int n = database.login(phonenumber, email);

        if (n != -1) {
            User user = database.getUser(n);
            user.menu(database, user);

        } else {
            System.out.println("This Account does not exist");
            return ;
        }

    }

    private static void SignUp() {
        System.out.println("immmherrerer");
        System.out.println("please enter name");
        String name = s.next();
        System.out.println("please enter Phone Number");
        String phonenumber = s.next();
        System.out.println("please enter Email");
        String email = s.next();
        System.out.println("1. Admin \n 2. Normal User");
        int n2 = s.nextInt();

        if (n2 == 1) {
            User admin = new Admin(name, email, phonenumber);
            database.AddUser(admin);
        } else {
            User NormalUser = new NormalUser(name, email, phonenumber);
            database.AddUser(NormalUser);
        }
        System.out.println("User created ");
    }
}
