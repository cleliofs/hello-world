package main.scala.functional

import scala.annotation.tailrec


sealed trait MyList[+A] {
  def tail: MyList[A] = this match {
    case Nil => Nil
    case Cons(h, tail) => tail
  }

  def drop(n: Int): MyList[A] = {
    @tailrec
    def go(n: Int, l: MyList[A]): MyList[A] = {
      if (n == 0) l
      else go(n-1, l.tail)
    }

    go(n, this)
  }

  def dropWhile(p: A => Boolean): MyList[A] = {
    @tailrec
    def go(l: MyList[A]): MyList[A] = l match {
      case Nil => Nil
      case Cons(h, tail) if (p(h)) => go(tail)
      case Cons(h, tail) if !(p(h)) => Cons(h, tail)
    }

    go(this)
  }

  def setHead[A](e: A): List[A] = e :: List()
}

case object Nil extends MyList[Nothing]

case class Cons[+A](head: A, t: MyList[A]) extends MyList[A]

object MyList {
  def sum(ints: MyList[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: MyList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): MyList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  @tailrec
  def drop[A](l: MyList[A], n: Int): MyList[A] = {
    if (n==0) l
    else drop(l.tail, n-1)
  }

  @tailrec
  def dropWhile[A](l: MyList[A])(p: A => Boolean): MyList[A] = l match {
    case Nil => Nil
    case Cons(h, tail) if (p(h)) => dropWhile(tail)(p)
    case Cons(h, tail) if !(p(h)) => Cons(h, tail)
  }
//
//  def dropWhilePartial[A](l: MyList[A]): A => Boolean = {
//    @tailrec
//    def dropWhile2[A](l: MyList[A], p: A => Boolean): MyList[A] = l match {
//      case Nil => Nil
//      case Cons(h, tail) if (p(h)) => dropWhile2(tail, p)
//      case Cons(h, tail) if !(p(h)) => Cons(h, tail)
//    }
//
//    dropWhile2(l, _)
//  }

  def setHead[A](l: MyList[A], h: A): MyList[A] = Cons(h, l.tail)

  def init[A](l: MyList[A]): MyList[A] = {

    def go(l: MyList[A]): MyList[A] = {
      val res: Vector[A] = Vector[A]()
      def go2(l: MyList[A]): Unit = l match {
        case Nil => ()
        case Cons(h, Nil) => ()
        case Cons(h, tail) => h +: res; go2(tail)
      }

      Nil
    }

    go(l)
  }

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = MyList(1, 2, 3)
  val total = sum(example)

  val x = MyList(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }

}



/**
 * List exercise
 *
 * Created by clelio on 02/06/15.
 */
object ListExercise {

  def main(args: Array[String]): Unit = {
    println(MyList.x)

    println(MyList(1, 2, 3).tail)
    println(List(1,2,3,4,5).drop(2))
    println(MyList(1, 2, 3,4,5).drop(2))
    println(List(1,2,3,4,5).dropWhile(_ <= 2))
    println(MyList(1, 2, 3,4,5).dropWhile(_ <= 2))

    println(MyList.setHead(MyList(1, 2, 3,4,5), 2))
    println(MyList(1, 2, 3,4,5).setHead(2))

    val v: Vector[Int] = Vector[Int]()
    v:+ 1

//    println(MyList.init(MyList(1, 2, 3,4,5)))
  }
}
