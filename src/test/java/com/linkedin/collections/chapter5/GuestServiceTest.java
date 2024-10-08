package com.linkedin.collections.chapter5;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.linkedin.collections.chapter3.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GuestServiceTest {
  
  GuestService guestService;
  Guest john, maria, sonia, siri, bob;
  
  Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
  Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
  Room westminster = new Room("Westminster", "Premiere Room", 4, 175.00);
  Room oxford = new Room("Oxford", "Suite", 5, 225.0);
  Room victoria = new Room("Victoria", "Suite", 5, 225.0);
  Room manchester = new Room("Manchester", "Suite", 5, 225.0);
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  void setUp() {
    guestService = new GuestService();
    List<Room> rooms;
    
    john = new Guest("John", "Doe", false);
    rooms = john.getPreferredRooms();
    rooms.addAll(List.of(oxford, victoria, manchester));
    john.setPreferredRooms(rooms);
    
    maria = new Guest("Maria", "Doe", true);
    rooms = maria.getPreferredRooms();
    rooms.addAll(List.of(cambridge, oxford));
    maria.setPreferredRooms(rooms);
    
    sonia = new Guest("Sonia", "Doe", true);
    rooms = sonia.getPreferredRooms();
    rooms.addAll(List.of(cambridge));
    sonia.setPreferredRooms(rooms);
    
    siri = new Guest("Siri", "Doe", true);
    
    bob = new Guest("Bob", "Doe", false);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testFilterByFavoriteRoom() {
    List<Guest> guests = List.of(john, maria, sonia, siri, bob);
    
    assertTrue(GuestService.filterByFavoriteRoom(guests, cambridge).containsAll(List.of(maria, sonia)));
    assertFalse(GuestService.filterByFavoriteRoom(guests, cambridge).containsAll(List.of(john, siri, sonia)));
    assertTrue(GuestService.filterByFavoriteRoom(guests, oxford).containsAll(List.of(john)));
    assertFalse(GuestService.filterByFavoriteRoom(guests, oxford).containsAll(List.of(maria, sonia, siri, bob)));
    assertTrue(GuestService.filterByFavoriteRoom(guests, victoria).isEmpty());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testSwapPosition() {
    guestService.checkIn(bob);
    guestService.checkIn(maria);
    guestService.checkIn(sonia);
    guestService.checkIn(john);
    guestService.checkIn(siri);
    
    guestService.swapPosition(maria, john);
    guestService.swapPosition(siri, bob);
    
    List<Guest> guests = guestService.getCheckInList();
    assertEquals(4, guests.indexOf(maria));
    assertEquals(1, guests.indexOf(sonia));
    assertEquals(3, guests.indexOf(siri));
    assertEquals(2, guests.indexOf(bob));
    assertEquals(0, guests.indexOf(john));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testCheckIn() {
    guestService.checkIn(bob);
    guestService.checkIn(maria);
    guestService.checkIn(sonia);
    guestService.checkIn(john);
    guestService.checkIn(siri);
    
    List<Guest> guests = guestService.getCheckInList();
    assertEquals(5, guests.size());
    assertEquals(0, guests.indexOf(maria));
    assertEquals(1, guests.indexOf(sonia));
    assertEquals(2, guests.indexOf(siri));
    assertEquals(3, guests.indexOf(bob));
    assertEquals(4, guests.indexOf(john));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
