package com.linkedin.collections.practice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IndicesTest {
  
  List<Integer> numbers;
  int targetSum;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  void setUp() {
    numbers = Arrays.asList( 7, 17, 13, 19, 55 );
    targetSum = 26;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  void testIndices() {
    assertTrue(Indices.getIndices(numbers, targetSum).get(0) == 0);
    assertTrue(Indices.getIndices(numbers, targetSum).get(1) == 3);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  
}
