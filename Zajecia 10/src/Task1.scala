trait Food {
  val name = "Food"
  override def toString: String = name
}

abstract class Animal {
  val name = "Animal"
  type AcceptedType <: Food
  def eat(f: AcceptedType): Unit
  override def toString: String = name
}

class PlantFood extends Food {
  override val name = "PlantFood"
}

class Grass extends PlantFood {
  override val name = "Grass"
}

class Hay extends PlantFood {
  override val name = "Hay"
}

class Cow(override val name: String = "") extends Animal with Food {
  override type AcceptedType = PlantFood
  override def eat(f: AcceptedType): Unit = println(s"Cow $name eats $f")
}

class Woolf(override val name: String = "") extends Animal {
  override type AcceptedType = Cow
  override def eat(f: AcceptedType): Unit = println(s"Woolf $name eats $f")
}

object WoolfTest extends App {
  val g = new Grass
  val h = new Hay
  val c1 = new Cow("ANiceCow")
  val c2 = new Cow("MilkyCow")
  val w1 = new Woolf("CowEaterBeast")
  // w1.eat(g)// has to fail compilation
  c1.eat( g );
  c2.eat( h );
  // c1.eat( c1 ); // has to fail compilation
  w1.eat( c1 );
  // expected output
  // Cow ANiceCow eats Grass
  // Cow MilkyCow eats Hay
  // Woolf CowEaterBeast eats Cow ANiceCow
}
