
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class Assign2 {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        Library library = new Library();
        MyDate todayDate = new MyDate(calendar.get(Calendar.DATE), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.YEAR));
        int choice = 0;
        do {
            System.out.println("\nEnter \n1 to add to resources borrowed,");
            System.out.println("2 to display overdue items,");
            System.out.println("3 to display all resources borrowed,");
            System.out.println("4 to delete a resource,");
            System.out.println("5 to change today date");
            System.out.println("6 to view a specific resource,");
            System.out.println("7 to read resources from a file,");
            System.out.println("8 to save the current resources to a file,");
            System.out.println("9 to quit:");

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Invalid entry – prompted to reenter choice");
                input.next();
            }

            if (choice == 1) {
                library.inputResource(input, todayDate);
            } else if (choice == 2) {
                library.resourcesOverDue(todayDate);
            } else if (choice == 3) {
                library.toString();
            } else if (choice == 4) {
                library.deleteResource(input, todayDate);
            } else if (choice == 5) {
                todayDate = new MyDate();
                System.out.println("Enter a new date for today's date: ");
                todayDate.inputDate(input, true);
            } else if (choice == 6) {
                library.viewResource(input);
            } else if (choice == 7) {
                library.readResourceFile(input, todayDate);
            } else if (choice == 8) {
                library.saveResourceFile(input);
            } else if (choice == 9) {
                System.out.println("goodbye");
            }
        } while (choice != 9);

    }

}
