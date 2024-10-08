package com.linkedin.collections.practice;

import java.util.List;

public class Average {
  
  static double getAverage(List<Integer> source) {
    if (source == null || source.isEmpty()) return 0;
    
    return source.stream().reduce(0, (a, b) -> a + b) / (double)source.size();
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
