import math.Pi
object Task1 {
  def pi: Double = Pi
  def pi(arg: Double): Double = Pi * arg

  def printarg(arg: String = "-"): Unit = println(arg)

  def repN(i: Int, intToInt: Int => Int, i1: Int): Int = {
    if (i == 0) i1 else repN(i - 1, intToInt, intToInt(i1))
  }

  def max(i: Int)(j: Int): Int = if (i < j) j else i

  def pall(a: Int*): Unit = {
    a.foreach(v => print(v.toString.concat(" ")))
  }

  def main(args: Array[String]): Unit = {
    println( pi )
    println( pi(pi) )
    println( pi(pi(pi)) )
    printarg(arg="hello")
    printarg()
    println(repN(5, (x: Int) => 2*x , 1 ))
    // invokes the function N times (here 5) passing the previous result to it, implementation does not need to be recursive of course
    println( max(4)(5) )
    pall( 1,2,3,4,5,4, 3, 3, 4)
  }
}
