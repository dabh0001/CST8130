
import java.text.ParseException;
import java.util.Scanner;

/**
 * Resource class to store data of each resource
 *
 */
public class Resource {

    protected String title;
    protected String borrower;
    protected MyDate dueDate;
    protected float overdueCost;

    public Resource() {

    }

    public boolean inputResource(Scanner in, MyDate myDate, boolean enableLog) throws ParseException {
        //title
        do {
            if (enableLog) {
                System.out.print("Enter title being borrowed: ");
            }
            this.title = in.next();
        } while (this.title == null || this.title.trim().equals(""));

        //borrower
        do {
            if (enableLog) {
                System.out.print("Enter borrower name (no spaces):");
            }
            this.borrower = in.next();
        } while (this.borrower == null || this.borrower.trim().equals(""));

        //dueDate
        this.dueDate = myDate;
        return true;
    }

    @Override
    public String toString() {
        return borrower + " has " + title + " due on " + dueDate + " and if late " + overdueCost;
    }

    /**
     * Method use for save data in file
     *
     * @return
     */
    public String saveToString() {
        return borrower + " " + title + " " + dueDate.saveToString() + " " + overdueCost + " ";
    }

    public boolean isOverDue(MyDate today) throws ParseException {
        return dueDate.isGreaterThan(today);
    }

    public void displayOverDue() {
        System.out.println("Borrower name:" + this.borrower + " and Due Cost: " + overdueCost);
    }

    public boolean isSameTitle(String resouceTitle) {
        return title.equalsIgnoreCase(resouceTitle);
    }

}
