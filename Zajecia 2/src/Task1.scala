object Task1 {
  def main(args: Array[String]): Unit = {
    val first = if (args.length == 2) args(0).toInt else 0
    val last = if (args.length == 2) args(1).toInt else args(0).toInt
    val list = List.range(first, last);

    list.foreach(number => print(s"$number "))
  }
}
