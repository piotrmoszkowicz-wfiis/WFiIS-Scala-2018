class MyMaybe[T](t: T, b: Boolean = true) {
  def flatMap(f: T => MyMaybe[T]): MyMaybe[T] = {
    if (b) {
      f(t)
    } else {
      new MyMaybe[T](t, false)
    }
  }

  override def toString: String = {
    if (b) {
      t.toString
    } else {
      "FAILED"
    }
  }
}

object temat extends App {
  val a = new MyMaybe(9.0)
  def fail(arg: Double) = new MyMaybe(0.0, false) // the false means that computation failed
  def mult(arg:Double) = { println("multiplying "+arg.toString); new MyMaybe( arg * 2.0 ) }
  val computationFailed =
    a.flatMap( mult _).flatMap( fail ).flatMap( mult _ )
  val computationSucceeded = a.flatMap( x => new MyMaybe(x*2) ).flatMap(x => new MyMaybe(x*2) )
  println(computationFailed)
  println(computationSucceeded)
  //multiplying 9.0
  //FAILED
  //36.0
}