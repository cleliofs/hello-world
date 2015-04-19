package main.scala

/**
 * Created by clelio on 18/04/15.
 */
class HelloWorld {


  private var greetings: String = "Hello";

  def this(greetings: String) { this(); this.greetings = greetings;}

  def getGreetings = greetings;

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
