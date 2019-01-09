import math.max

object Task1 {
  def repeated(l: List[Int]): List[Int] = {
    l.foldLeft(Map.empty[Int, Int])((acc, value) => {
      acc.updated(value, acc.getOrElse(value, 0) + 1)
    }).filter(_._2 > 1).keys.toList
  }

  def condMerge(list: List[Int], vector: Vector[Int], value: ((Int, Int)) => Int): List[Int] = {
    list.zip(vector).filter(tpl => tpl._1 > 0 && tpl._2 > 0).map(tpl => value(tpl))
  }

  def main(args: Array[String]): Unit = {
    // println(repeated(List(-8,5,6,1,4,4,2,5,-1,9,9)))

    val m = condMerge(List(2,-9,1,8), Vector(3,-2,45,2),
      {
        case x: (Int,Int) if max(x._1, x._2) > 0 => max(x._1,x._2)
      } )

    println(m)
  }
}
