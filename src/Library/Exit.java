package Library;

import javax.lang.model.element.ExecutableElement;
import java.util.Scanner;

public class Exit implements IOOperations{
    static Database database;
    static Scanner s;
    @Override
    public void oper(Database database, User user) {
        System.out.println("\n Are you sure that you want to exit : \n");
        System.out.println("\n 1.Ywes.\n");
        System.out.println("\n 2.Return to Menu.\n");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if (i==1){
            try{
                System.out.println(" \n" + "0. Exit \n" + "1. Login \n" + "2.New User");

                while (!s.hasNextInt()) {  // Ensures the input is a valid integer
                    System.out.println("Invalid input. Please enter a number.");
                    s.next(); // Consume the invalid input
                }

                int num = s.nextInt();

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
                System.out.println("Out of gere See ya !");
            }catch(Exception e){
                System.out.println("Out ");
            }
        } else {
            user.menu(database,user);
        }

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
