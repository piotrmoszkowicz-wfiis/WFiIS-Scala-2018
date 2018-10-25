object Task1 {
  def main(args: Array[String]): Unit = {
    val test = Array.ofDim[Double](4,5);
    for ( i <- 0 until 4; j <- 0 until 5) test(i)(j) = (1+i)/(1+j)
    print2DArr( test, 4) // 4 digits
    print2DArr( test, 3) // 3 digits
  }

  def print2DArr(arr: Array[Array[Double]], formatter: Int): Unit = {
    arr.foreach(x => println(formatNumbers(x, formatter)))
  }

  /* def print2DArr(arr: Array[Array[Double]], formatter: Int): Unit = {
    for (
      arrone <- arr;
      output <- formatNumbers(arrone, formatter)
    ) yield print(output)
  }*/

  def formatNumbers(num: Array[Double], formatter: Int): String = {
    num.map(_.formatted(s"%.${formatter}f")).mkString(" ").concat("\n")
  }
}
