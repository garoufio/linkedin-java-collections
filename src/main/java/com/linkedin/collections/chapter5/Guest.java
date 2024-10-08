package com.linkedin.collections.chapter5;

import com.linkedin.collections.chapter3.Room;

import java.util.ArrayList;
import java.util.List;

public class Guest {
  
  private String firstName;
  private String lastName;
  private boolean loyaltyProgramMember;
  private List<Room> preferredRooms;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Guest(String firstName, String lastName, boolean loyaltyProgramMember) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.loyaltyProgramMember = loyaltyProgramMember;
    this.preferredRooms = new ArrayList<Room>();
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public String getFirstName() {
    return firstName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public String getLastName() {
    return lastName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public boolean isLoyaltyProgramMember() {
    return loyaltyProgramMember;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setLoyaltyProgramMember(boolean loyaltyProgramMember) {
    this.loyaltyProgramMember = loyaltyProgramMember;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public List<Room> getPreferredRooms() {
    return preferredRooms == null ? null : new ArrayList<>(preferredRooms);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setPreferredRooms(List<Room> preferredRooms) {
    if (!(preferredRooms == null || preferredRooms.isEmpty())) {
      this.preferredRooms.clear();
      this.preferredRooms.addAll(preferredRooms);
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Guest other = (Guest) obj;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName)){
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    
    return true;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Override
  public String toString() {
    return String.format("%s %s", firstName, lastName);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
