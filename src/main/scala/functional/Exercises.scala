package main.scala.functional

import scala.annotation.tailrec

/**
 * Fibonacci of a number
 *
 * Created by clelio on 02/06/15.
 */
object Exercises {

  def main(args: Array[String]) {

    def fib(n: Int) = {
      @tailrec
      def go(n: Int, acc: Int): Int = {
        if (n == 1) acc
        else go(n-1, acc * n)
      }

      go(n, 1)
    }

    println(fib(10))


    def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
      @tailrec
      def go(as: List[A], gt: (A, A) => Boolean): Boolean = as match {
        case List() => true
        case a :: List() => true
        case a :: b :: tail if (gt(a, b)) => go(b :: tail, gt)
        case a :: b :: tail if (!gt(a, b)) => false
      }
      go(as.toList, gt)
    }

    val a = Array(1, 2, 3, 4)
    println(isSorted(a, (a: Int, b: Int) => a < b))
    val b = Array(1, 2, 3, 0, 4)
    println(isSorted(b, (a: Int, b: Int) => a < b))


    def partial1[A, B, C](a: A, f: (A, B) => C): B => C = f(a, _)

    def curry[A,B,C](f: (A,B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)

    def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

    def compose1[A,B,C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

    def compose2[A,B,C](f: B => C, g: A => B): A => C = f.compose(g)

    def compose3[A,B,C](f: B => C, g: A => B): A => C = g.andThen(f)

  }
}
