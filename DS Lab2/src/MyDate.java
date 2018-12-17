
import java.util.Scanner;

/**
 * **********************************************************************************************************
 * Purpose: This class will model a simple date by keeping day, month and year
 * information. Leap years are NOT accommodated in this class. Author: Linda
 * Crane and xxxxxxxxxx Course: F2018 - CST8130 Lab Section: xxxxxxxx Data
 * members: day : int - value between 1 and 31 inclusive (depending on value in
 * month) month: int - value between 1 and 12 inclusive year: int - positive
 * value Methods: default constructor - sets date to Jan 1, 2018 toString ():
 * String - prints date in year/moht/day format inputDate(Scanner): boolean -
 * reads a valid date from the Scanner parameter and returns through boolean
 * success or not addOne(): void - adds one to the day field and then adjusts
 * month and year as needed. *
 *
 ************************************************************************************************************
 */
public class MyDate {

    private int day = 1;
    private int month = 1;
    private int year = 2018;

    public MyDate() {
    }

    public String toString() {
        return new String("" + year + "/" + month + "/" + day);
    }

    public boolean inputDate(Scanner in, boolean enableLog) {
        month = 0;
        day = 0;
        year = 0;
        do {
            if (enableLog) {
                System.out.println("Enter month - between 1 and 12: ");
            }
            if (in.hasNextInt()) {
                this.month = in.nextInt();
            } else {
                System.out.println("Invalid month input");
                in.next();
            }
        } while (this.month <= 0 || this.month > 12);

        do {
            if (enableLog) {
                System.out.println("Enter day - between 1 and 31: ");
            }
            if (in.hasNextInt()) {
                this.day = in.nextInt();
            } else {
                System.out.println("Invalid day input");
                in.next();
            }
        } while (this.day <= 0 || this.day > 31 || (this.month == 2 && this.day > 29) || (this.day > 30 && (this.month == 9 || this.month == 4 || this.month == 6 || this.month == 11)));

        do {
            if (enableLog) {
                System.out.println("Enter year: ");
            }
            if (in.hasNextInt()) {
                this.year = in.nextInt();
            } else {
                System.out.println("Invalid day input");
                in.next();
            }
        } while (this.year <= 0);

        return true;
    }

    public void addOne() {
        // *********    write the code for this method here  **************

        if (day < 29 && month == 2) {														//for feb
            day = day + 1;
        } else {
            if (day == 29 && month == 2) {
                day = 1;
                month = month + 1;
                return;
            }

        }// end of feb

        if (day < 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {			// for months ending 31st except dec

            day = day + 1;

        } else {
            if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
                day = 1;
                month = month + 1;
                return;
            }
        }// end for months ending 31st except dec

        if (day < 31 && month == 12) {							// for dec
            day = day + 1;
        } else {
            if (day == 31 && month == 12) {
                day = 1;
                month = 1;
                year = year + 1;
                return;
            }
        }// end for dec

        if (day < 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {				// for months ending with 30 
            day = day + 1;
        } else {
            if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                day = 1;
                month = month + 1;
                return;
            }
        }// end for months ending with 30

    }

}
