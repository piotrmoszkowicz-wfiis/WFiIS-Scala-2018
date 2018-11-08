object Task1 {
  def concat(strings: String*): String = {
    strings.reduce((old, cur) => old.concat(cur))
  }

  def <(string: String = ""): Unit = println(string)
  def <<(): Unit = println()

  def max(i: Int = Int.MinValue): Int => Int => Int = {
    j: Int => {
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
  }

  def main(args: Array[String]): Unit = {
    println( concat("hello", " all") )
    println( concat("hello", " all", " the") )
    println( concat("hello", " all", " the", " word", " and", " all", " people") )
    <( "here we are again")
    << // prints empty line
    println( max(3)(5)(1) )
    println( max(3)(5)(8) )
    println( max(9)(5)(8) )
    val rangeMax = max()(100)
    println( rangeMax(200) )
    println( rangeMax(2) )
  }
}
