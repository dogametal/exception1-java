package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {

	private Integer roomnumber;
	private Date checkin;
	private Date checkout;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	public Reservation(Integer roomnumber, Date checkin, Date checkout) throws DomainException{
		if (!checkout.after(checkin)) {
			//exception good to use to treatment- throw new IllegalArgumentException("Check-out date must be after check-in date.");	
			throw new DomainException("Constructor >>Check-out date must be after check-in date.");
		}
		this.roomnumber = roomnumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(Integer roomnumber) {
		this.roomnumber = roomnumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	//Applied throws exception on method cause compiler error message
	public void updateDates (Date checkin, Date checkout) throws DomainException {
		Date now = new Date();

		if(checkin.before(now) || checkout.before(now)) {			
			//exception good to use to treatment - throw new IllegalArgumentException("Reservation dates for update must be future dates");
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkout.after(checkin)) {
			//exception good to use to treatment- throw new IllegalArgumentException("Check-out date must be after check-in date.");	
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		 return "Room " 
				+ roomnumber
				+ ", check-in :"
				+ sdf.format(checkin)
				+ ", check-out :"
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " night(s).";
				
		
	}
}
