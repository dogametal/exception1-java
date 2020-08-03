package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		//

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room Number : ");
			
			int number = sc.nextInt();
			
			System.out.print("Check-in date (mm/DD/yyyy) :" );
			Date checkIn = sdf.parse(sc.next());
	
			System.out.print("Check-out date (mm/DD/yyyy) :" );
			Date checkOut = sdf.parse(sc.next());
			
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update reservation :");
			System.out.print("Check-in date(mm/DD/yyyy) :");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(mm/DD/yyyy) :");
			checkOut = sdf.parse(sc.next());
	 
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format.");			
		}
		catch (DomainException e) {
			System.out.println("Reservation error :" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error ...");
		}
		sc.close();
	}

}
