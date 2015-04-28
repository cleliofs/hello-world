case class Time(val hours: Long, val min: Long) {
  def before(other: Time): Boolean = other match {
    case Time(h,m) if (h > this.hours) => true
    case Time(h,m) if h == this.hours && m > this.min => true
    case _ => false
  }
}

class Time2(val hours: Long, val min: Long) {
  def before(o: Time2): Boolean = {
    if (o.hours > this.hours) true
    else if (o.hours == this.hours && o.min > this.min) true
    else false
  }


  override def toString = s"Time2($hours, $min)"
}

val t1=new Time(14,39)
val t2=new Time(14,38)
t2.before(t1)