import scala.annotation.tailrec
import scala.math.abs

object zad2 {
  def leng(x: Int, y: Int): Int = abs(x - y)

  def closest(num: Int*):(Int,Int)={

    val length = num.toList.length;
    @tailrec def help(list: List[Int], i: Int = 0, j: Int = 1, result: (Int, Int) = (0, 10)): (Int,Int) ={
      if(i == length || j == length) result else{
        if(leng(list(i), list(j)) < leng(result._1, result._2)){
          help(list, i, j+1,(list(i), list(j)));
        }else{
          help(list, i, j+1,result)
        }
      }
    }

    @tailrec  def helppp(list: List[Int],i: Int = 0, tuple: (Int, Int) = (0,10)): (Int, Int) ={
      if(i == list.length) tuple else {
        val newResult = help(list, i, i+1)
        if (leng(newResult._1, newResult._2) < leng(tuple._1, tuple._2)) {
          helppp(list, i+1, newResult)
        } else {
          helppp(list, i+1, tuple)
        }
      }
    }


     helppp(num.toList)

  }

  def main(args: Array[String]): Unit = {

    val c = closest( 1, 17, 8, 27, 21, 29, 99, 22 , 4)
    println("" + c._1 + " " + c._2 )

  }

}
