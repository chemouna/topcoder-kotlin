package com.mounacheikhna.topcoder

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by m.cheikhna on 31/05/2017.
 */
class DevuClassTest {

  lateinit var devuClass: DevuClass

  @Before
  fun setUp() {
    devuClass = DevuClass()
  }

  @Test
  fun findCostOfRearrangingTest() {
    assertEquals(7, devuClass.findCostOfRearranging("BBBGGGBBGGGGBB", 2));
    assertEquals(8, devuClass.findCostOfRearranging("BBBBGGBGGGG", 1));
  }

  /*

   2
t: 2
2
Input type: 2
BBBGGGBBGGGGBB
costOfRearranging : 7
current value of t: 1
1
Input type: 1
BBBBGGBGGGG
costOfRearranging : 8
current value of t: 0
7
8

    */


}