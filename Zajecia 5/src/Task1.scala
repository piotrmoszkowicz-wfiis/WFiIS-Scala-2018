import math.abs
import scala.annotation.tailrec

object Task1 {
  def redux(numbers: Int*)(function: (Int, Int) => Int): Int = {
    val (head, nums) = numbers.toList.splitAt(1)
    val operation = function

    @tailrec
    def reduxInner(list: List[Int], result: Int = 0): Int = {
      if (list.isEmpty)
        result
      else {
        val (buffer, newList) = list.splitAt(1)
        reduxInner(newList, operation(result, buffer.head))
      }
    }
    reduxInner(nums, head.head)
  }

  def main(args: Array[String]): Unit = {
    val res1 = redux( 1,7,8,9,10)( _+_ )
    val res2 = redux( 2,-4,5,-2,4)( _*abs(_) )

    println(s"Res1: ${res1}, Res2: ${res2}")
  }
}
