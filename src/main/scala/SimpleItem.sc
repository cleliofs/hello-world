import scala.collection.mutable.ArrayBuffer

abstract class Item {
  def price: Double
  def description: String = s"Item = $price"
}

class SimpleItem(_price: Double, _desc: String = "") extends Item {
  override val price = _price
  override val description = _desc

  override def toString() = s"Item($price)"
}


object Item {
  def apply(p: Double) = new SimpleItem(p)
}

class Bundle extends Item {
  private var items: ArrayBuffer[Item] = new ArrayBuffer[Item]();
  override lazy val price = items.foldLeft(Item(0.0))((a, b) => Item(a.price+b.price)).price
  override lazy val description = s"Bundle[$items]"
  def addIem(i: Item*): Unit = items ++= i

  override def toString() = items.toString()
}

val items = ArrayBuffer[Item](Item(1), Item(2), Item(3))
items.foldLeft(Item(0))((a, b) => Item(a.price+b.price)).price

val s = new SimpleItem(0, "SimpleItem")
s.price
s.description

val b = new Bundle
b.addIem(Item(1.0), Item(2.0), Item(3))
b
b.price
b.description