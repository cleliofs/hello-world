package main.scala

/**
 * Created by clelio on 18/04/15.
 */
class BasicOperator(i: Int, i1: Int, function: (Int, Int) => Int) {

  lazy val value = function(i, i1)

}
