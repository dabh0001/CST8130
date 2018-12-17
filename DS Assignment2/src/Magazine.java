
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Magazine extends Resource {

    protected MyDate edition;

    public Magazine() {
        edition = new MyDate();
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
            if (in.hasNextFloat()) {
                this.overdueCost = in.nextFloat();
            }
        }
        //dueDate
        this.dueDate = dueMydate;
        //edition
        if (enableLog) {
            System.out.print("Enter the edition date: ");
        }
        edition.inputDate(in, enableLog);

        //its overdue cost is $1
        this.overdueCost = 1;
        return true;
    }

    @Override
    public String toString() {
        return "edition " + edition + " " + super.toString();
    }

    /**
     * Method use for save data in file
     *
     * @return
     */
    @Override
    public String saveToString() {
        return "m " + super.saveToString() + edition.saveToString();
    }
}
