package com.linkedin.collections.chapter3;

import java.util.*;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RoomService {

  Collection<Room> roomsInventory;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public RoomService() {
    roomsInventory = new LinkedHashSet<>();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Collection<Room> getInventory() {
    return new HashSet<>(roomsInventory);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void createRoom(String name, String type, int capacity, double rate) {
    roomsInventory.add(new Room(name, type, capacity, rate));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void createRooms(Room[] rooms) {
    roomsInventory.addAll(Arrays.asList(rooms));
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void removeRoom(Room room) {
    roomsInventory.remove(room);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public boolean hasRoom(Room room) {
    return roomsInventory.contains(room);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Room[] asArray() {
    return roomsInventory.toArray(new Room[roomsInventory.size()]);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Collection<Room> getByType(String type) {
    return roomsInventory.stream()
        .filter(r -> r.getType().equals(type))
        .collect(Collectors.toSet());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Reduces the rate of each room by the provided discount */
  public void applyDiscount(final double discount) {
    if (!(roomsInventory == null || roomsInventory.isEmpty())) {
      roomsInventory.forEach(room -> {
        room.setRate(room.getRate() - (room.getRate() * discount));
      });
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {
    return roomsInventory
        .stream()
        .filter(room -> room.getCapacity() >= requiredCapacity)
        .collect(Collectors.toSet());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Collection<Room> getRoomByRateAndType(final double rate, final String type) {
    return roomsInventory
        .stream()
        .filter(room -> room.getRate() < rate && room.getType().equals(type))
        .collect(Collectors.toSet());
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
