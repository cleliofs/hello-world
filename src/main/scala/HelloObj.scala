package main.scala

/**
 * Created by clelio on 19/04/15.
 */
object HelloObj {

  def main(a: Array[String]) = {
    val h = new HelloWorld
    h.name="Test"
    println(h.name)

    val r = List(1,2,3) map { e =>
      val r = e+1
      println(r)
      r
    }
    val r2: List[Int] = r.map(e => e + 1)
    printf("Result: %s", r2(0))


  }
}
