package com.mounacheikhna.topcoder

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.function.Predicate

/**
 * Created by m.cheikhna on 29/05/2017.
 */
class DevuClass {

  //BBGBGGGGBBGGB

  fun findCostOfRearranging(arrangement: String, type: Int): Int {
    var b = 0
    var g = 0
    arrangement.toCharArray().forEach {
      if (it == 'B') {
        b++
        g++ // why this ?
      }
    }
    if (Math.abs(b - g) > 1) {
      return -1
    }
    var cost = 0
    val predicate = Predicate<Int> { i -> i % 2 != 0 }

    if (b > g) {
      cost = findArrangementCost(arrangement, type, predicate)
    } else if (g > b) {
      cost = findArrangementCost(arrangement, type, predicate.negate())
    } else {
      cost = findArrangementCost(arrangement, type, predicate)
      val otherCost =
          findArrangementCost(arrangement, type, predicate.negate())
      if (otherCost < cost) {
        cost = otherCost
      }
    }
    return cost;
  }

  fun findArrangementCost(
      arrangement: String, type: Int, predicate: Predicate<Int>): Int {
    var cost = 0
    val boysOffPosition = ArrayDeque<Int>()
    val girlsOffPosition = ArrayDeque<Int>()
    findOffPositions(arrangement, boysOffPosition, girlsOffPosition, predicate)
    val weirdos = boysOffPosition.size
    kotlin.repeat(weirdos, {
      cost += getCost(boysOffPosition.poll(), girlsOffPosition.poll(), type)
    })
    return cost
  }

  fun findOffPositions(arrangement: String, boysOffPosition: Queue<Int>,
                       girlsOffPosition: Queue<Int>, predicate: Predicate<Int>) {
    //for (var i = 0; i < arrangement.length(); i++) {
    var i = 0
    while (i < arrangement.length) { //replace with more idiomatic kotlin code
      if (arrangement.get(i) == 'B') {
        if (predicate.test(i)) {
          boysOffPosition.add(i)
        }
      } else {
        if (predicate.negate().test(i)) {
          girlsOffPosition.add(i)
        }
      }
      i++
    }
  }

  fun getCost(index1: Int, index2: Int, t: Int): Int {
    if (t == 0) {
      return 1
    } else {
      return Math.abs(index1 - index2)
    }
  }

}

fun main(args: Array<String>) { // throws IOException
  val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
  val stringBuilder = StringBuilder()
  val devuClass = DevuClass()
  var t = Integer.parseInt(bufferedReader.readLine())
  println("t: "+ t)
  while (t > 0) {
    val type = Integer.parseInt(bufferedReader.readLine())
    println("Input type: $type")
    val costOfRearranging = devuClass.findCostOfRearranging(bufferedReader.readLine(), type)
    println("costOfRearranging : "+ costOfRearranging)
    stringBuilder.append(costOfRearranging).append('\n')
    t--
    println("current value of t: "+ t)
  }
  System.out.println(stringBuilder)
}
