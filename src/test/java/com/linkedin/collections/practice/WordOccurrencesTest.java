package com.linkedin.collections.practice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordOccurrencesTest {
  
  String source;
  String target;
  
  //-------------------------------------------------------------------------------------------------------------------

  @BeforeEach
  void setUp() {
    source = "Here is an example. Right here. here here?";
    target = "here";
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testWordOccurrences() {
    assertTrue(WordOccurrences.getOccurrences(source, target) == 3);
    assertFalse(WordOccurrences.getOccurrences(source, target) == 0);
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
