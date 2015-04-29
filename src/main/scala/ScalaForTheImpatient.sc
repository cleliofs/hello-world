object Conversions {
  private val inchToCentRatio = 2.54
  private val galToLiter = 4.54609
  private val mileToKilometer = 1.609344

  def inchesToCentimeters(v: Double): Double = v * inchToCentRatio
  def gallonsToLiters(v: Double): Double = v * galToLiter
  def milesToKilometers(v: Double): Double = v * mileToKilometer
}

trait UnitConversion {
  val ratio: Double
  def convert(v: Double): Double = v * ratio
}

object InchesToCentimeters extends UnitConversion {
  override val ratio = 2.54
}

object GallonsToLitters extends UnitConversion {
  override val ratio = 4.54609
}

object MilesToKilometers extends UnitConversion {
  override val ratio = 1.609344
}

InchesToCentimeters.convert(10)
GallonsToLitters.convert(10)
MilesToKilometers.convert(10)

class Point(val a: Int, val b: Int) {

  override def toString() = s"Point($a, $b)"
}

object Point {
  def apply(a: Int, b: Int) = new Point(a,b)
}

Point(1,2)

"Hello World".split(" ").reverse.mkString(" ")

object Card extends Enumeration {
  type Card = Value
  val Club = Value("\u2663")
  val Spades = Value("\u2660")
  val Hearts = Value("\u2665")
  val Diamonds = Value("\u2666")

  def isRed(c: Card.Value) = c==Diamonds || c==Hearts
}
Card.Club
Card.Diamonds
Card.Spades
Card.Hearts
Card.isRed(Card.Club)
Card.isRed(Card.Diamonds)

object RGB extends Enumeration {
  type RGB = Value
  val Red = Value
}

