class Point(val x: Int, val y: Int) {
  override def toString = s"Point($x,$y)"
}

object Point {
  def apply(x: Int, y: Int) = new Point(x, y)
}

val p = Point(2, 1)
p.x
p.y

class LabeledPoint(val label: String, override val x: Int, override val y: Int) extends Point(x,y) {
  final override def equals(other: Any) = {
    val that = other.asInstanceOf[LabeledPoint]
    if (that == null) false
    else label==that.label && x==that.x && y==that.y
  }
}

val l = new LabeledPoint("label", 2, 1)
l.label
l.x
l.y

val l2 = new LabeledPoint("label", 2, 1)
l == l2

abstract class Shape {
  def centerPoint: Point
}

class Line(p1: Point, p2: Point) extends Shape {
  override def centerPoint: Point = Point((p1.x + p2.x)/2, (p1.y + p2.y)/2)
}

class Rectangle(p1: Point, p2: Point) extends Shape {
  def centerPoint = Point((p1.x + p2.x)/2, (p1.y + p2.y)/2)
}

object Rectangle {
  def apply(p1: Point, p2: Point) = new Rectangle(p1, p2)
}

class Circle(p1: Point, r: Int) extends Shape {
  override def centerPoint: Point = Point(-1,-1)
}

val r = Rectangle(Point(1,2), Point(2,1))
r.centerPoint


