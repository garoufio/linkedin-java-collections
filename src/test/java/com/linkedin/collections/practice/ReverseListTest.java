package com.linkedin.collections.practice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReverseListTest {
  
  List<Integer> numbers;
  List<Integer> numbersReversed;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  void setUp() {
    numbers = Arrays.asList( 7, 17, 13, 19, 5 );
    numbersReversed = Arrays.asList( 5, 19, 13, 17, 7 );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testReverseList() {
    List<Integer> reversed = ReverseList.getReversed(numbers);
    
    for (int i = 0; i < reversed.size(); i++) {
      assertTrue(reversed.get(i) == numbersReversed.get(i));
    }
    
    for (int i = 0; i < reversed.size(); i++) {
      assertFalse(reversed.get(i) == numbers.get(i));
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}
