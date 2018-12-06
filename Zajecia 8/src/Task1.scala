abstract class Pizza() {
  def price: Double
  def name: String
}

trait TomatoSauce extends Pizza {
  override abstract def price: Double = super.price + 2
  override abstract def name: String = " Tomato Sauce " + super.name
}

trait Mozarella extends Pizza {
  override abstract def price: Double = super.price + 2
  override abstract def name: String = " Mozarella " + super.name
}

trait Ham extends Pizza {
  override abstract def price: Double = super.price + 3
  override abstract def name: String = " Ham " + super.name
}

trait Mushroms extends Pizza {
  override abstract def price: Double = super.price + 3.5
  override abstract def name: String = " Mushrooms " + super.name
}

class ThinDough() extends Pizza {
  override def price: Double = 7
  override def name: String = "on thin dough "
}

object Task1 {
  def main(args: Array[String]): Unit = {
    val myPizza = new ThinDough with TomatoSauce with Mozarella with Ham
    println( myPizza.name + myPizza.price )
    val yourPizza = new ThinDough with TomatoSauce with Mozarella with Mushroms
    println( yourPizza.name + yourPizza.price )
  }
}
