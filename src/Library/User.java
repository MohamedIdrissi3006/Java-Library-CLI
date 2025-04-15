package Library;

import java.util.Arrays;

public abstract class User {


    protected String name;
    protected String email;
    protected String phonenumber;
    protected IOOperations[] operation;


    public User() { }


    public User(String name) {
        this.name = name;
    }

    public User(String name, String email, String phonenumber) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    abstract public String toString() ;

    abstract public void menu(Database database, User user);
}
