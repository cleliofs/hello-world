class Person(var age: Int = 0) {
  if (age < 0) age = 0
}

val p = new Person(-1)
p.age

val p2 = new Person(32)
p2.age


class Person2(val name: String) {
  var firstName: String = ""
  var lastName: String = ""
  name match {
    case s => firstName = s.split(' ')(0); lastName = s.split(' ')(1);
  }
}
val p3 = new Person2("John Smith")
p3.firstName
p3.lastName


def f(i: Int) = "John Smith".split(' ')(i)
f(0)
f(1)

class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1) {

  var licensePlate: String = ""

  def this(manufacturer: String, modelName: String) {
    this(manufacturer, modelName, -1)
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName)
    this.licensePlate = licensePlate
  }

  def this(manufacturer: String, modelName: String, modelYear: Int, licensePlate: String) {
    this(manufacturer, modelName, modelYear)
    this.licensePlate = licensePlate
  }


}
