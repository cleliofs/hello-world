package main.scala

/**
 * Created by clelio on 18/04/15.
 */
class HelloWorld(var name: String = "") {

  def printNumbers(b: Int, e: Int): Unit = {
    for {i <- b to e} printf("%s ", i)
  }

  def printNumbersWithFunction(b: Int, e: Int, f: (Int) => Int): Unit = {
    for {i <- b to e} printf("%d ", f(i))
  }

  def printNumbersWithFunction2(b: Int, e: Int, add: (Int) => Int, sub: (Int) => Int): Seq[Int] = {
    for (i <- b to e) yield add(i)
  }
}
