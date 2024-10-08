package com.linkedin.collections.chapter7;

import com.linkedin.collections.chapter3.Room;
import com.linkedin.collections.chapter5.Guest;

import java.util.HashMap;
import java.util.Map;

public class BookingService {
  
  private Map<Room, Guest> bookings;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public BookingService() {
    bookings = new HashMap<>();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * The provided Guest is placed in the bookings Map and associated with the provided room, only if no other guest
   * is associated with the room.  Returns a boolean that indicates if the Guest was successfully placed in the room.
   */
  public boolean book(Room room, Guest guest) {
    return bookings.putIfAbsent(room, guest) == null;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Returns a double that totals the rate of each Room booked in the bookings Map.
   */
  public double totalRevenue() {
    return bookings
        .keySet()
        .stream()
        .mapToDouble(Room::getRate)
        .sum();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Map<Room, Guest> getBookings() {
    return bookings;
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
