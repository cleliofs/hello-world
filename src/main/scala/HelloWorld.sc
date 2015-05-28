import scala.collection.immutable.Stream.Empty

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
val hello = new HelloWorld("Test")
hello.printNumbers(1, 2)

val op: Option[String] = Option("Clelio")

op.map(n => n).getOrElse(println("None"))

op.map {
  name => name
}.getOrElse {
  println("None")
}

val unsortedList = List(4, 5, 1, 4, 2, 0)

def sortList(l: List[Int]): List[Int] = {
  l match {
    case x :: Nil => x :: Nil
    case x :: xs if (x <= xs.head) => x :: sortList(xs)
    case x :: xs if x > xs.head => sortList(xs) :+ x
  }
}

unsortedList.indices zip unsortedList.indices.drop(1)

def sortList2(l: List[Int]): List[Int] = {

  def bubbleSort[T](arr: Array[T])(implicit o: Ordering[T]) {
    import o._
    val consecutiveIndices = (arr.indices, arr.indices drop 1).zipped
    var hasChanged = true
    do {
      hasChanged = false
      consecutiveIndices foreach { (i1, i2) =>
        println(s"($i1, $i2)")

        if (arr(i1) > arr(i2)) {
          hasChanged = true
          val tmp = arr(i1)
          arr(i1) = arr(i2)
          arr(i2) = tmp
        }
      }
    } while(hasChanged)
  }


  def bubbleSort2[T](arr: Array[T])(implicit o: Ordering[T]) {
    import o._
    for (i<-arr.indices; j<-arr.indices.drop(1)) {
      println(s"($i, $j)")
      if (arr(i) > arr(j)) {
        val tmp = arr(i)
        arr(i) = arr(j)
        arr(j) = tmp
      }

    }
  }

  val a = l.toArray
  bubbleSort(a)
  a.toList
}


sortList2(unsortedList)

