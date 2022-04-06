import java.time.LocalDate;
import java.time.Month;

public class Date {

    private int day;
    private int month;
    private int year;
    private LocalDate currdate = LocalDate.now();

    // default constructor to record account creation date
    public Date() {
        setDay();
        setMonth();
        setYear();
    }

    // setters for default constructor
    private void setDay() {
        day = currdate.getDayOfMonth();
    }

    private void setMonth() {
        month = currdate.getMonthValue();
    }

    private void setYear() {
        year = currdate.getYear();
    }

    // getters to allow read only access
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void DisplayDate() {
        System.out.println(day + "/" + month + "/" + year);
    }
}
