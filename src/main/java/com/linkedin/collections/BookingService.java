package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {

		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 * 
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */

			Guest g = bookings.putIfAbsent(room, guest);
			if(g == null) return true;

			else return false;
	}

	public double totalRevenue() {
		
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */

		double total = 0;
		for (Map.Entry<Room, Guest> i: bookings.entrySet()
			 ) {
			total+= i.getKey().getRate();
		}
		return total;
	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
