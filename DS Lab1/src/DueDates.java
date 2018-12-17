import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class will model a due dates for assessments in a course
Author:  Linda Crane and xxxxxxxxxx
Course: F2018 - CST8130
Lab Section: xxxxxxxx
Data members:  

Methods:                                             


 *************************************************************************************************************/

public class DueDates {
	private MyDate[] dueDates ;
	int count = 0;

	public DueDates() {

		dueDates = new MyDate[10];
		//*****  write the code for this method here
	}

	public DueDates(int max) {

		dueDates = new MyDate[max];
		//*****  write the code for this method here
	}

	public boolean inputDueDates(Scanner in) {
		
		for (int i=0; i < dueDates.length; i++) {
			dueDates[i] = new MyDate();
			System.out.println(" " + (i+1) + ":");
			dueDates[i].inputDate(in);
		}
		
		return true;
		//*****  write the code for this method here
	}

	public void addOne () {

		for (int i=0; i< dueDates.length; i++) {
			dueDates[i].addOne();
		}
		//*****  write the code for this method here
	}

	public String toString() {
		//*****  write the code for this method here
		String result = "";
		for (int i=0; i<dueDates.length; i++) {
			
			result =  result + " " + (i+1) + ": " + dueDates[i].toString() + "\n" ;
		}
		return result;
	}

}

