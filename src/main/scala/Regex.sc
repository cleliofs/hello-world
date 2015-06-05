//val Value = "This is a test, with another test2 and finally a test3 and 1, 2, 3"
//val Expression = """This is a ([^,]+), with another ([^,]+) and finally a ([^,]+)""".r
val Value = "a test, with test2 finally a test 3 with 1, 2 and 3"
val Expression = """a (.+), with (.+) finally a test 3 with ([\d]+), ([\d]+) and ([\d]+)""".r
Value match {
  case Expression(t, t2, n1, n2, n3) => println(s"Matched: $t, and $t2 with $n1, $n2 and $n3")
  case _ => println("None")
}


val Expr2 = """these numbers, ([\d]+\.[\d]+), ([\d]+) and ([\d]+)""".r

"these numbers, 11.12, 22 and 33" match {
  case Expr2(n, n2, n3) => s"Numbers: $n, $n2 and $n3"
  case _ => "none"
}