
import java.util.*;
import java.io.*;
import java.text.ParseException;

/**
 * **********************************************************************************************************
 * Purpose: This class is the method main for Lab 1 Author: Linda Crane and
 * xxxxxxxxxx Course: F2018 - CST8130 Lab Section: xxxxxxxx
 *
 *
 *
 ************************************************************************************************************
 */
public class Lab4 {

    public static void main(String[] args) throws ParseException {
        Formatter x;
        Scanner keyboard = new Scanner(System.in);
        DueDates dd = null;
        boolean isValid = false;
        String ask = "n";
        String fName;
        String variable = "null";
        int value = 0;

        System.out.println("Enter name of file to import or the word null to bypass:");
        fName = keyboard.nextLine();
        if (variable.equalsIgnoreCase(fName) == true) {
            System.out.println("You choose to bypass this step.... continuing");
            do {
                System.out.print("How many assessments in this course must be greater than 0?");
                while (!isValid) {
                    if (keyboard.hasNextInt()) {  // testing to see if what was entered is valid int
                        value = keyboard.nextInt();
                        if (value > 0) { // testing  for value > 0
                            isValid = true;  // to end loop

                        } else {
                            System.out.println("Error please reenter a valid value");
                        }
                    } else {
                        System.out.println("Error please reenter a valid value");
                        keyboard.next();  // read past the badvalue}}
                    }
                }
                dd = handleDates(value, dd, keyboard);
                System.out.print("Do another (y/n)?");
                ask = keyboard.next();
                isValid = false;
            } while (ask.charAt(0) == 'y');

            if (ask.charAt(0) != 'y') {
                String temp = "" + dd;
                try {
                    System.out.println("Enter name of file to write to: ");
                    x = new Formatter(keyboard.next());
                    x.format("%s", temp);
                    x.close();
                } catch (Exception e) {
                    System.out.println("you have an error");
                }
            }
        } else {
            try {
                File file = new File(fName);
                if (file.exists()) {
                    keyboard = new Scanner(file);

                    if (keyboard.hasNextInt()) {  // testing to see if what was entered is valid int
                        value = keyboard.nextInt();
                        if (value <= 0) {
                            System.out.println("Error please reenter a valid value");
                        } else {
                            dd = handleDates(value, dd, keyboard);
                        }
                    } else {
                        System.out.println("First line of file should be number.");
                        keyboard.next();  // read past the bad value}}
                    }
                } else {
                    System.out.println("File does not exist");
                }

            } catch (IOException e) {
                System.out.println("Could not open file..." + fName + "exiting");
            }
        }
    }

    private static DueDates handleDates(int value, DueDates dd, Scanner keyboard) throws ParseException {
        dd = new DueDates(value);
        System.out.println("Enter due dates:");
        dd.inputDueDates(keyboard);

        System.out.println(dd);

        dd.insertionSort();

        System.out.println("Enter due dates after sorting:");
        System.out.println(dd);

        dd.addOne();

        System.out.println("The due dates with one day added are :");

        System.out.println(dd);
        return dd;
    }
}
