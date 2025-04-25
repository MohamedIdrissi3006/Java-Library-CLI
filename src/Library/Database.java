package Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Database {
    private static Database instance;
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> usernames = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> booknames = new ArrayList<String>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<String> ordersId = new ArrayList<String>();
    private ArrayList<Borrowing> Borrowings = new ArrayList<Borrowing>();


    private File userfile = new File("C:\\Users\\HP\\IdeaProjects\\Library\\src\\Users");
    private File booksfile = new File("C:\\Users\\HP\\IdeaProjects\\Library\\src\\Books");
    private File ordersfile = new File("C:\\Users\\HP\\IdeaProjects\\Library\\src\\Orders");
    private File borrowingfile = new File("C:\\Users\\HP\\IdeaProjects\\Library\\src\\Borrowings");
    private File folder = new File("C:\\Users\\HP\\IdeaProjects\\Library\\src");

    public Database() {
        if (!userfile.exists()) {
            userfile.mkdirs();
        }
        if (!booksfile.exists()) {
            booksfile.mkdirs();
        }
        if (!ordersfile.exists()) {
            ordersfile.mkdirs();
        }
        if (!borrowingfile.exists()) {
            borrowingfile.mkdirs();
        }
        try {
            getUsers();
            getBooks();

            getOrders();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void AddUser(User user) {
        users.add(user);
        usernames.add(user.getName());
        saveUsers();
    }

    public void AddBook(Book book) {
        books.add(book);
        booknames.add(book.getName());
        saveBooks();
    }

    public int login(String phonenumber, String email) {
        int n = -1;
        for (User s : users) {

            if (s.getPhonenumber().matches(phonenumber) && s.getEmail().matches(email)) {
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }


    public User getUser(int n) {
        System.out.println(users.get(n));
        return users.get(n);
    }


    private void getUsers() {
        String text = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(userfile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text = text + s1;

            }
            br1.close();
        } catch (Exception e) {

            System.err.println();
        }
        if (!text.matches("") || !text.isEmpty()) {
            String[] a1 = text.split("<NewUser/>");
            for (String s1 : a1) {
                String[] a2 = s1.split("<N/>");
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1], a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                } else {
                    User user = new NormalUser(a2[0], a2[1], a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                }
            }
        }
    }

    private void saveUsers() {
        String text = "";
        for (User u : users) {
            text = text + u.toString() + "<NewUser/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(userfile);
            pw.print(text);
            pw.close();

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void getBooks() {

        String text = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(booksfile));
            String s1;

            while ((s1 = br1.readLine()) != null) {
                text = text + s1;

            }
            br1.close();

        } catch (Exception e) {

            System.err.println(e);
        }

        if (!text.matches("") || !text.isEmpty()) {

            String[] a1 = text.split("<NewBook/>");

            for (String s1 : a1) {

                Book book = parseBook(s1);

                books.add(book);
                booknames.add(book.getName());

            }
        }
    }

    public Book parseBook(String s) {
        String[] a = s.split("<N/>");

        Book book = new Book();
        book.setName(a[0]);

        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setAdress(a[3]);
        book.setStatut(a[4]);

        book.setQty(Integer.parseInt(a[5]));

        book.setPrice(Double.parseDouble(a[6]));

        book.setBrwcopies(Integer.parseInt(a[7]));


        return book;

    }

    private void saveBooks() {
        String text = "";
        for (Book b : books) {
            text = text + b.toString() + "<NewBook/>\n";
        }

        try {
            PrintWriter pw = new PrintWriter(booksfile);
            pw.print(text);
            pw.close();

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


    public ArrayList<Book> getAllBooks() {

        return books;
    }

    public int getBook(String b) {
        int i = -1;
        for (Book book : books) {
            if (b.matches(book.getName())) {
                i = books.indexOf(book);

            }
        }
        return i;
    }

    public Book getBook(int a) {
        return books.get(a);
    }

    public void deleteBook(int i) {
        books.remove(i);
        booknames.remove(i);
        saveBooks();
    }

    public void deleteAllData() {
        if (userfile.exists()) {
            try {

                userfile.delete();

            } catch (Exception e) {

            }
            if (booksfile.exists()) {
                try {

                    booksfile.delete();

                } catch (Exception e) {

                }

            }
        }
    }

    private void saveOrders() {
        String text = "";
        for (Order b : orders) {
            text = text + b.toString2() + "<NewOrder/>\n";
        }

        try {
            PrintWriter pw = new PrintWriter(ordersfile);
            pw.print(text);
            pw.close();

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void AddOrder(Order order, Book book, int index) {
        orders.add(order);
        books.set(index, book);
        saveOrders();
        saveBooks();
    }

    public Order parseOrder(String s) {
        String[] a = s.split("<N/>");

        Order order = new Order();
        Book book = books.get(getBook(a[0]));
        order.setBook(book);
        order.setNormalUser(getUserName(a[1]));
        order.setPrice(Double.parseDouble(a[2]));
        order.setQty(Integer.parseInt(a[3]));

        return order;

    }/**/

    public User getUserName(String a) {
        User u = new NormalUser();
        for (User user : users) {
            if (user.getName().matches(a)) {
                u = user;
                break;
            }
        }
        return u;
    }

    private void getOrders() {
        String text = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(ordersfile));

            String s1;
            while ((s1 = br1.readLine()) != null) {
                text = text + s1;

            }
            br1.close();
        } catch (Exception e) {

            System.err.println(e);
        }

        if (!text.matches("") || !text.isEmpty()) {

            String[] a1 = text.split("<NewOrder/>");

            for (String s1 : a1) {


                Order order = parseOrder(s1);

                orders.add(order);
                System.out.println(orders);
            }

        }
    }

    public ArrayList<Order> getAllOrders() {

        return orders;
    }


public void saveBorowwings() {
    String text = "";
    for (Borrowing b : Borrowings) {
        text = text + b.toString2() + "<NewBorrowing/>\n";
    }

    try {
        PrintWriter pw = new PrintWriter(borrowingfile);
        pw.print(text);
        pw.close();

    } catch (Exception e) {
        System.err.println(e.toString());
    }

}


public void getBorowwings(){
    String text = "";
    try {
        BufferedReader br1 = new BufferedReader(new FileReader(borrowingfile));

        String s1;
        while ((s1 = br1.readLine()) != null) {
            text = text + s1;

        }
        br1.close();
    } catch (Exception e) {

        System.err.println(e);
    }

    if (!text.matches("") || !text.isEmpty()) {

        String[] a1 = text.split("<NewBorrowing/>");

        for (String s1 : a1) {


            Borrowing borrowing = parseBorrowing(s1);
            Borrowings.add(borrowing);
//
//
//            System.out.println(orders);
        }

    }
}

    public Borrowing parseBorrowing(String s) {

        String[] a = s.split("<N/>");


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(a[0],formatter);
        LocalDate finish = LocalDate.parse(a[1],formatter);
        Book book = getBook(getBook(a[2]));
        User user = getUserName(a[3]);
        Borrowing borrow = new Borrowing(book,start,finish,user);
        return  borrow;
    }
}