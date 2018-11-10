object Task1_1 {
  def max(i: Int = Int.MinValue)(j: Int = Int.MinValue): Int => Int = {
    k: Int => {
      if (i > j) {
        if (i > k)
          i
        else
          k
      } else {
        if (j > k)
          j
        else
          k
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(max(1)(2)(3))
    println(max(3)(2)(1))
    println(max(1)(3)(2))
  }
}
