object Task1 {

  def indicate(list: List[List[Int]], value: PartialFunction[Int, Boolean]): List[Boolean] = {
    list.flatMap(x => x.collect(value))
  }

  def synchForEach(in: List[List[Int]], function: List[Int] => Any): List[Any] = {
    in.transpose.map(x => function(x))
  }

  def main(args: Array[String]): Unit = {
    val in = List(List(1, 2, 3, 4),
      List(5, 0, -1, 7),
      List(-1, 51, 1, 0),
      List(0, 0, 7, 7))

    val maxCollection = in.map(x => x.max)
    val max = maxCollection.max
    val listWithBiggest = in.filter(x => x.contains(max)).flatten

    println(f"Max: $max")
    println(f"Max collection: $maxCollection")
    println(f"List with max: $listWithBiggest")

    println( indicate( in, {case x if x < 0 => true} ) )
    println( synchForEach( in, { x => x } ) )
    println( synchForEach( in, { x => x.max } ) )
  }
}
