package com.linkedin.collections.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {
  
  // Return a new list in reversed order
  public static List<Integer> getReversed(List<Integer> source) {
    if (source == null) return null;
    
    List<Integer> reversed = new ArrayList<>(source);
    Collections.reverse(reversed);
    
    return reversed;
  }
  
}
