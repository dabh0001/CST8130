/**
 * Name : Aditya Dabhi
 * Student No : 040902920
 * Assignment Number 1
 * Date : 10/03/2018
 * Purpose of class : Sets the edition of the magazine.
 */

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

	public boolean inputResource(Scanner in, MyDate myDate) throws ParseException {

		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(myDate.toString());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		MyDate dueMydate = new MyDate(calendar.get(Calendar.DATE), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.YEAR));

		super.inputResource(in, dueMydate);
		//edition
		System.out.print("Enter the edition date: ");
		edition.inputDate(in);

		//its overdue cost is $1
		this.overdueCost = 1;
		return true;
	}

	@Override
	public String toString() {
		return "edition " + edition + " " + super.toString();
	}

}
