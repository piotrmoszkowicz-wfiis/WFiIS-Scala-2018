object Task2 {
  def checkThatWeUnderstand(str: String)(result: => Boolean): Boolean = {
    val buffer = result
    if (buffer)
      println(s"Yes we understand $str")
    else
      println(s"No we do NOT understand $str")
    buffer
  }

  def main(args: Array[String]): Unit = {
    checkThatWeUnderstand("String operations") {
      checkThatWeUnderstand("concatenation") {
        val s1 = "Hi "
        val s2 = "Res"
        val s3 = s1 + s2
        s3 == "Hi Res"
      } && checkThatWeUnderstand("indexing") {
        "Eva"(0) == 'E' && "Eva"(2) == 'a'
      } && checkThatWeUnderstand("multiplication") {
        "Eva"*2 == "Eva2"
      }
    }
  }
}
