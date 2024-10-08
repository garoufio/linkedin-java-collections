package com.linkedin.collections.practice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfCharactersTest {
  
  String source = "there are both smaller and bigger words here";
  List<String> list = new ArrayList<String>();
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  void setUp() {
    list = Arrays.asList("there", "are", "both", "and", "words", "here");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testFiveOrFewerCharacters() {
    List<String> words = NumberOfCharacters.findFiveOrFewer(source);
    assertTrue(words.size() == 6);
    
    for (int i = 0; i < words.size(); i++) {
      assertTrue(list.contains(words.get(i)));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  
  
}
