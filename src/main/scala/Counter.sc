class Counter {

  private var value: Int = Int.MaxValue

  def increment() = if (value < Int.MaxValue) value += 1

  def current() = value

}


val c = new Counter

c.current()
c.increment()
c.current()