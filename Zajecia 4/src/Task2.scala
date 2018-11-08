import math.abs
import scala.annotation.tailrec

object Task2 {
  def countDistance(a: Int, b: Int): Int = {
   abs(a - b)
  }
  def closest(numbersFromArg: Int*): (Int, Int) = {
    val numbers = numbersFromArg.toList

    @tailrec
    def closestOneRecursive(checkPointIndex: Int, result: (Int, Int) = (Int.MinValue, Int.MaxValue), bestDistance: Int = Int.MaxValue, current: Int = 0): (Int, Int) = {
      if (current == numbers.length) {
        result
      } else {
        val curDistance = countDistance(numbers(checkPointIndex), numbers(current))
        if (checkPointIndex != current && curDistance < bestDistance) {
          closestOneRecursive(checkPointIndex, (numbers(checkPointIndex), numbers(current)), curDistance, current+1)
        } else {
          closestOneRecursive(checkPointIndex, result, bestDistance, current+1)
        }
      }
    }

    @tailrec
    def closestRecursive(result: (Int, Int) = (Int.MinValue, Int.MaxValue), bestDistance: Int = Int.MaxValue, current: Int = 0): (Int, Int) = {
      if (numbers.length == current) {
        result
      }
      else {
        val resultCurrent = closestOneRecursive(current)
        val resultDistance = countDistance(resultCurrent._1, resultCurrent._2)

        if (resultDistance < bestDistance) {
          closestRecursive(resultCurrent, resultDistance, current + 1)
        } else {
          closestRecursive(result, bestDistance, current + 1)
        }
      }
    }
    closestRecursive()
  }

  def main(args: Array[String]): Unit = {
    val c = closest( 1, 17, 8, 27, 21, 29, 99, 22 , 4)
    println("" + c._1 + " " + c._2 )
  }
}
