package Library;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;



public class Borrowing {
    LocalDate start;
    LocalDate finish;
    int daysleft;
    Book book;
    User user;


    DateTimeFormatter formmater = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Borrowing(){

    };
    public Borrowing(Book book, User user) {
        start = LocalDate.now();
        finish = start.plusDays(14);
        daysleft = Period.between(start,finish).getDays();
        this.book = book;
        this.user = user;
    }
    public Borrowing(Book book,LocalDate start , LocalDate finish,User user) {
      this.finish = finish;
      this.start = start;
      this.daysleft = Period.between(start,finish).getDays();
      this.book = book;
      this.user = user;

    }

    public String getStart() {
        return formmater.format(start);
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public String getFinish() {
        return formmater.format(finish);
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    public int getDaysleft() {
        return Period.between(start,finish).getDays();
    }

    public void setDaysleft(int daysleft) {
        this.daysleft = daysleft;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Borrowing time : " + start +
                "\n Exipry Time" + finish +
                ", days left " + daysleft;
    }
    public java.lang.String toString2() {
        return getStart() + "<N/>" +
                getFinish() + "<N/>" +
                daysleft + "<N/>" + book.getName() + "<N/>" + user.getName() + "<N/>";
    }
}
