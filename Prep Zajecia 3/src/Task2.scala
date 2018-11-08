object Task2 {
  def main(args: Array[String]): Unit = {
   val maxFibNumber = 100
   val n = 3

   val result = nfib(n, maxFibNumber, List.fill(n)(1), 0)
  }

  def nfib(n: Int, maxLenList: Int, list: List[Int], curVal: Int): Unit = {
    if (list.length == maxLenList) {
      return curVal
    }
    val res = list.sum
    println()
    nfib(n, maxLenList, list :+ res, res)
  }
}
