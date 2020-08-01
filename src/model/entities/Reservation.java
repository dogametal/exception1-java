package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomnumber;
	private Date checkin;
	private Date checkout;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	public Reservation(Integer roomnumber, Date checkin, Date checkout) {
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

	public void updateDates (Date checkin, Date checkout) {
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
