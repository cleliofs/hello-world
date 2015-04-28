import scala.beans.BeanProperty

class Student {
  @BeanProperty
  var name: String = "";
  @BeanProperty
  var id: Long = 0;
}

val s = new Student
s.setName("Clelio")
s.getName
s.name