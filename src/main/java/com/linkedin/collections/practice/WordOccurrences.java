package com.linkedin.collections.practice;

import java.util.Arrays;

public class WordOccurrences {
  
  // Return the number of occurrences of word in source
  public static int getOccurrences(String source, String word) {
    String cleanedUpString = source
        .replaceAll("[^a-zA-Z]", " ").replaceAll("  ", " ");
    
    return (int)Arrays
        .stream(cleanedUpString.split(" "))
        .filter(w -> w.equals(word))
        .count();
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
