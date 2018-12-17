/**
 * Name : Aditya Dabhi
 * Student No : 040902920
 * Assignment Number 1
 * Date : 10/03/2018
 * Purpose of class : Sets the type of DVD.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DVD extends Resource {

	private String type;

	public DVD() {

	}

	public boolean inputResource(Scanner in, MyDate myDate) throws ParseException {
		//DVD due date is 3 days after today's date and it's overdue cost is also $1
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(myDate.toString());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		MyDate dueMydate = new MyDate(calendar.get(Calendar.DATE), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.YEAR));

		super.inputResource(in, dueMydate);

		do {
			System.out.print("Enter the type of DVD (no spaces): ");
			this.type = in.next();
		} while (this.type == null || this.type.trim().equals(""));

		//its overdue cost is $1
		this.overdueCost = 1;
		return true;
	}

	@Override
	public String toString() {
		return "type of DVD : " + type + " " + super.toString();
	}

}
