import scala.annotation.tailrec

object Task1 {
  def forel(ints: List[Int])(condition: Int => Boolean)(positive: => Unit)(negative: => Unit): Int = {
    @tailrec
    def forealHelper(ints: List[Int], condition: Int => Boolean, positive: => Unit, negative: => Unit, corrects: Int = 0): Int = {
      if (ints.isEmpty)
        return corrects
      val (head, nums) = ints.splitAt(1)
      val result = condition(head.head)
      var newCorrects = corrects
      if (result){
        positive
        newCorrects+=1
      } else negative
      forealHelper(nums, condition, positive, negative, newCorrects)
    }
    forealHelper(ints, condition, positive, negative)
  }

  def main(args: Array[String]): Unit = {
    val li = List(1,4,3,4,52,3,2)
    val npos1 = forel( li )( _<5){
      println("<3");
    }{
      println(" not <3 ");
    }
    println(npos1)
    val npos2 = forel( li )( _%3 == 0 ){
      println("divisble by 3");
    }{
      println(" not divisible 3");
    }
    println(npos2)
  }
}
