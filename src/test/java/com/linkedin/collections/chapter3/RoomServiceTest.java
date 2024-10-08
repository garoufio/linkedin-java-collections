package com.linkedin.collections.chapter3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

public class RoomServiceTest {
  
  RoomService roomService;
  
  Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.0);
  Room manchester = new Room("Manchester", "Suite", 5, 250.0);
  Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.0);
  Room oxford = new Room("Oxford", "Suite", 5, 225.0);
  Room victoria = new Room("Victoria", "Suite", 5, 225.00);
  Room westminster = new Room("Westminster", "Premiere Room", 4, 200.00);
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  void setUp() throws Exception {
    roomService = new RoomService();
    
    roomService.createRoom("Piccadilly", "Guest Room", 3, 125.0);
    roomService.createRoom("Cambridge", "Premiere Room", 4, 175.0);
    roomService.createRoom("Victoria", "Suite", 5, 225.00);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testCreateRoom() {
    roomService.createRoom("Westminster", "Premiere Room", 4, 200.0);
    
    assertEquals(4, roomService.getInventory().size());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testCreateRooms() {
    Room[] newRooms = {westminster, oxford, manchester};
    
    roomService.createRooms(newRooms);
    assertEquals(6, roomService.getInventory().size());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testRemoveRoom() {
    roomService.removeRoom(new Room("Victoria", "Suite", 5, 225.00));
    
    assertEquals(3, roomService.getInventory().size());
    assertFalse(roomService.getInventory().contains(victoria));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testGetInventory() {
    assertNotNull(roomService.getInventory());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testHasRoom() {
    assertFalse(roomService.hasRoom(manchester));
    assertTrue(roomService.hasRoom(cambridge));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testAsArray() {
    Room[] rooms = roomService.asArray();
    
    assertEquals(3, rooms.length);
    assertEquals(piccadilly, rooms[0]);
    assertEquals(cambridge, rooms[1]);
    assertEquals(victoria, rooms[2]);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testGetByType() {
    Collection<Room> guestRooms = roomService.getByType("Premiere Room");

    assertEquals(1, guestRooms.size());
    assertTrue(guestRooms.stream()
        .allMatch(r -> r.getType().equals("Premiere Room")));
    assertEquals(3, roomService.getInventory().size());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testApplyDiscount() {
    Room[] rooms = roomService.asArray();
    
    roomService.applyDiscount(0.10);
    
    assertEquals(112.5, rooms[0].getRate());
    assertEquals(157.5, rooms[1].getRate());
    assertEquals(202.5, rooms[2].getRate());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testGetRoomsByCapacity() {
    Room[] rooms = roomService.asArray();
    Collection<Room> roomsWithCapacity4 = roomService.getRoomsByCapacity(4);
    
    assertEquals(2, roomsWithCapacity4.size());
    assertTrue(roomsWithCapacity4.containsAll(Arrays.asList(rooms[1], rooms[2])));
    System.out.println(roomsWithCapacity4);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testgetRoomByRateAndType() {
    Room[] rooms = roomService.asArray();
    Collection<Room> roomsWithRateAndType = roomService.getRoomByRateAndType(190.00, "Premiere Room");
    
    assertEquals(1, roomsWithRateAndType.size());
    assertFalse(roomsWithRateAndType.contains(rooms[0]));
    assertTrue(roomsWithRateAndType.contains(rooms[1]));
    assertFalse(roomsWithRateAndType.contains(rooms[2]));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
