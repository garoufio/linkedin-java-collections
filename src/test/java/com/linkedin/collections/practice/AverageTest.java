package com.linkedin.collections.practice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AverageTest {
  
  List<Integer> numbers;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  void setUp() {
    numbers = Arrays.asList( 7, 17, 13, 19, 5 );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testAverage() {
    assertTrue(Average.getAverage(numbers) == 12.2);
  }
  
  //-------------------------------------------------------------------------------------------------------------------

}
