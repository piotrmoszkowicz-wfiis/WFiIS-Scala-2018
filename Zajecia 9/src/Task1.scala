object Sentences {
  def unapplySeq(str: String): Option[Seq[String]] = {
    // println(str.matches("(?<=[?!.])"))
    if (str.contains('?') || str.contains('!') || str.contains('.')) {
      Some(str.split("(?<=[?!.]) "))
    } else {
      None
    }
  }
}

object Task1 {
  def main(args: Array[String]): Unit = {
    val text = "Hello Marry! How are you today? I have see you yesterday in the sample place. What are you doing here?"

    val text2 = "Hello"

    val Sentences(s1, s2, s3, _*) = text2
    println(s1)
  }
}