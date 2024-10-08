package com.linkedin.collections.chapter5;

import com.linkedin.collections.chapter3.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

  private List<Guest> checkInList;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public GuestService() {
    checkInList = new ArrayList<Guest>();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   *  Returns a new collection that contains guests from the provided collection
   *  who have indicated the provided room as the first preference in their preferred
   *  room list.
   */
  public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
    return guests
        .stream()
        .filter(guest -> {
          List<Room> rooms = guest.getPreferredRooms();
          if (!(rooms == null || rooms.isEmpty())) {
            return rooms.indexOf(room) == 0;
          }
          
          return false;
        })
        .collect(Collectors.toList());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   *  Adds a guest to the checkinList, placing members of the loyalty program
   *  ahead of those guests not in the program. Otherwise, guests are arranged in the
   *  order they were inserted.
   */
  public void checkIn(Guest guest) {
    if (guest != null) {
      if (guest.isLoyaltyProgramMember()) {
        for (int i = 0; i < checkInList.size(); i++) {
          Guest g = checkInList.get(i);
          if (!g.isLoyaltyProgramMember()) {
            checkInList.add(i, guest);
            return;
          }
        }
      }
      
      // add a non loyalty member or a loyalty member (if the checkinList is empty)
      checkInList.add(guest);
      
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   *  Swaps the position of the two provided guests within the checkinList.
   *  If guests are not currently in the list no action is required.
   */
  public void swapPosition(Guest guest1, Guest guest2) {
    if (!(guest1 == null || guest2 == null)) {
      int index1 = checkInList.indexOf(guest1);
      int index2 = checkInList.indexOf(guest2);
      if (!(index1 == -1 || index2 == -1)) {
        Guest tempGuest = guest1;
        checkInList.set(index1, guest2);
        checkInList.set(index2, tempGuest);
      }
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /**
   * Returns a copy of the checkInList.
   */
  public List<Guest> getCheckInList() {
    return List.copyOf(checkInList);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
