package com.linkedin.collections.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfCharacters {
  
  public static List<String> findFiveOrFewer(String source) {
    if (source == null) return null;
    
    String cleanedUpString = source
        .replaceAll("[^a-zA-Z]", " ").replaceAll("  ", " ");
    
    return Arrays
        .stream(cleanedUpString.split(" "))
        .filter(word -> word.length() <= 5)
        .collect(Collectors.toList());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
