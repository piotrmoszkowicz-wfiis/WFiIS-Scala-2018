object Task2 {
  object Int {
    def *(count: Int): Array[Int] = count
  }

  implicit def toArray(count: Int): Array[Int] = Array.ofDim[Int](count)

  def main(args: Array[String]): Unit = {
    val x = Int * 6
    println( x.getClass.getSimpleName + x.mkString(" ") )
  }
}
