package com.linkedin.collections.practice;

import java.util.ArrayList;
import java.util.List;

public class Indices {
  
  
  // Return the indices of the numbers in the source list that add up to target
  static List<Integer> getIndices(List<Integer> source, int target) {
    if (source == null) return null;
    
    List<Integer> result = new ArrayList<>();
    boolean targetFound = false;
    
    for (int i = 0; i < source.size() - 1; i++) {
      for (int j = i + 1; j < source.size(); j++) {
        if (source.get(i) + source.get(j) == target) {
          result.add(i);
          result.add(j);
          targetFound = true;
          break;
        }
        
        if (targetFound ==  true) break;
      }
    }
    
    return result;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
