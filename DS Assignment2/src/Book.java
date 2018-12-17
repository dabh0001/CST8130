
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Book extends Resource {

    protected String author;

    public Book() {

    }

    @Override
    public boolean inputResource(Scanner in, MyDate myDate, boolean enableLog) throws ParseException {
        MyDate dueMydate;
        super.inputResource(in, myDate, enableLog);
        if (enableLog) {
            //set A book’s due date is 14 days from “today’s date”  
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(myDate.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, 14);
            dueMydate = new MyDate(calendar.get(Calendar.DATE), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.YEAR));
        } else {
            dueMydate = new MyDate();
            dueMydate.inputDate(in, enableLog);

            //overdueCost
            //A book overdue cost is $2.  
            if (in.hasNextFloat()) {
                this.overdueCost = in.nextFloat();
            }
        }
        this.dueDate = dueMydate;

        //author
        do {
            if (enableLog) {
                System.out.print("Enter the author name (no spaces): ");
            }
            this.author = in.next();
        } while (this.author == null || this.author.trim().equals(""));

        return true;
    }

    @Override
    public String toString() {
        return "author " + author + " " + super.toString();
    }

    /**
     * Method use for save data in file
     *
     * @return
     */
    @Override
    public String saveToString() {
        return "b " + super.saveToString() + author;
    }

}
