package test.scala

import main.scala.{BasicOperator, Addition, Square, HelloWorld}
import org.scalatest.FlatSpec

/**
 * Created by clelio on 18/04/15.
 */
class HelloWorldTest extends FlatSpec {

  "A HelloWorld" should "print the greetings 'Hello World, Clelio!'" in {
    val greetings: String = "Hello World, Clelio!";
    val helloWorld = new HelloWorld(greetings);
    assert(helloWorld.getGreetings == greetings);
  }

  "A HelloWorld" should "print numbers" in {
    val hello = new HelloWorld();
    hello.printNumbers(1, 10)
  }

  "A HelloWorld" should "print numbers with addition of 1" in {
    val hello = new HelloWorld;
    hello.printNumbersWithFunction(1, 10, (x: Int) => x + 1)
  }

  "A HelloWorld" should "print number with addition of 1 and subtraction of 1" in {
    val hello = new HelloWorld();
    println(hello.printNumbersWithFunction2(1, 10, (x: Int) => x + 1, (y: Int) => y - 1))
  }

  "A Square" should "return a square of a number" in {
    val square = new Square(10);
    assert(100==square.value, square.value)
  }

  "A Addition" should "add two numbers a+b" in {
    val a=10
    val b=5;
    val addition = new Addition(a, b)
    assert(15==addition.value, addition.value)
  }

  "A BasicOperator" should "operate properly with +, -, * or /" in {
    var basicOp=new BasicOperator(1, 2, (a: Int, b:Int) => a + b)
    assert(3==basicOp.value, basicOp.value)

    basicOp = new BasicOperator(1, 2, (_ - _))
    assert(-1==basicOp.value, basicOp.value)

    basicOp = new BasicOperator(7, 2, (_ * _))
    assert(14==basicOp.value, basicOp.value)

    basicOp = new BasicOperator(6, 2, (_ / _))
    assert(3==basicOp.value, basicOp.value)

  }

  "A PrintArray" should "print array items" in {
    val a: Array[Int] = new Array[Int](3);
    a(0)=1;
    a(1)=2;
    a(2)=3;
    a.toList.map(println)
    for (i <- 0 to a.length-1) {
      printf("%d ", a(i))
    }

    val a2 = Array(1, 2, 3)
    for (i <- 0 to a2.length-1) {
      printf("%d ", a2(i))
    }

  }

  "A List" should "operate properly" in {

    val l1: List[String] = List("scala", "java", "groovy")
    l1.filter(_.charAt(0)=='s').map(println)

    val l2 = "other"::Nil
    assert(List("other")==l2, l2)

    val l3 = "python"::l1
    assert(List("python", "scala", "java", "groovy")==l3, l3)
  }

  "A Range" should "operate properly" in {
    val r1 = 1 to 10
    r1.map(println)
  }
}
