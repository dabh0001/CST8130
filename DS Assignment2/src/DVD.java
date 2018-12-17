
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DVD extends Resource {

    private String type;

    public DVD() {

    }

    @Override
    public boolean inputResource(Scanner in, MyDate myDate, boolean enableLog) throws ParseException {
        MyDate dueMydate = null;
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

        do {
            if (enableLog) {
                System.out.print("Enter the type of DVD (no spaces): ");
            }
            this.type = in.next();
        } while (this.type == null || this.type.trim().equals(""));

        return true;
    }

    @Override
    public String toString() {
        return "type of DVD : " + type + " " + super.toString();
    }

    /**
     * Method use for save data in file
     * @return 
     */
    @Override
    public String saveToString() {
        return "d " +super.saveToString() + type;
    }

}
