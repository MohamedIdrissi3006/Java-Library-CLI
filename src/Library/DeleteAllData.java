package Library;

import java.util.Scanner;

public class DeleteAllData implements IOOperations{
    @Override
    public void oper(Database database, User user) {
        System.out.println("\n Are you sure that you want to delete all data  : \n");
        System.out.println("\n 1.Continue.\n");
        System.out.println("\n 2.Return to Menu.\n");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        if (i==1){
database.deleteAllData();
        } else {
            user.menu(database,user);
        }

    }
}
