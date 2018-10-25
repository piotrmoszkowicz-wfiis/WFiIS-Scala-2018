object Task1 {
  def main(args: Array[String]): Unit = {
    val data = List.range(0, 100)

    data.map(myfunc).foreach(println(_))
  }

  def myfunc(x: Int):String = x match {
    case x if x % 5 == 0 && x % 3 == 0 => "Fuzz Buzz"
    case x if x % 5 == 0 => "Fuzz"
    case x if x % 3 == 0 => "Buzz"
    case x => x.toString
  }
}
