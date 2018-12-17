/**
 * Name : Aditya Dabhi
 * Student No : 040902920
 * Assignment Number 1
 * Date : 10/03/2018
 * Purpose of class : Sets the author name for the book.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Book extends Resource {

	protected String author;

	public Book() {

	}

	public boolean inputResource(Scanner in, MyDate myDate) throws ParseException {

		//set A book's due date to 14 days from today's date
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(myDate.toString());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		MyDate dueMydate = new MyDate(calendar.get(Calendar.DATE), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.YEAR));

		super.inputResource(in, dueMydate);
		//author
		do {
			System.out.print("Enter the author name (no spaces): ");
			this.author = in.next();
		} while (this.author == null || this.author.trim().equals(""));

		//overdueCost
		//A book overdue cost is $2.  
		this.overdueCost = 2;
		return true;
	}

	@Override
	public String toString() {
		return "author " + author + " " + super.toString();
	}

}
