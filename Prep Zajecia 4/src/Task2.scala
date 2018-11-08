import scala.annotation.tailrec

object Task2 {
  @tailrec
  def minMaxRec(list: List[Int], result: (Int, Int) = (Int.MaxValue, Int.MinValue), check: Int = 0): (Int, Int) = {
    if (check == list.length)
      result
    else
      minMaxRec(
        list,
        (
          if (list(check) < result._1) list(check) else result._1,
          if (list(check) > result._2) list(check) else result._2
        ),
        check+1
      )
  }

  def main(args: Array[String]): Unit = {
    print(minMaxRec( List(1,3,4,5,2,9,4,5,-1,5,6,110) ))
  }
}
