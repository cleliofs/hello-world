package main.scala

import scala.concurrent.{Await, Future, Promise}
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
 * Created by csouza on 15/05/2015.
 */
object FutureAndPromises extends App {

  val p: Promise[Int] = Promise[Int]
  val f: Future[Int] = p.future

  val p2: Promise[Int] = Promise[Int]
  val f2: Future[Int] = p2.future


  val producer = Future {
    val r = Random.nextInt()
    println(s"Producing value = $r")
    p success r
    println("Producer do something else more expensive...")
    Thread.sleep(2000)
  }

  val consumer = Future {
    println("Consumer starts doing something...")
    Thread.sleep(2000)
    f onSuccess {
      case r => {
        println(s"Consumer consumed value = $r and sent to result via a promise")
        p2 success r
      }
    }
  }

  val result = Future {
    f2 onSuccess {
      case r => println(s"Result value = $r")
    }
  }

  Await.result(consumer, Duration.Inf)
}
