class MyString ( val content: String ) {
  override def toString: String = {
    content
  }
}

trait Wrap extends MyString {
  def wrap(prefix: String, suffix: String): String = prefix + content + suffix
}

trait Transform extends MyString {
  def transform(func: String => String): String = func(content)
}

case class SpacedWord( str: String ) extends MyString ( str ) with Wrap with Transform {
  wrap("/", "/")
  transform( _.toUpperCase )
}

object Task1_3 {
  def main(args: Array[String]): Unit = {
    val s1 = new MyString("Hello") with Wrap wrap(">>", "<<")
    println(s1)
    val s2 = new MyString("There")  with Transform transform(
      _.toLowerCase )
    println(s2)

    implicit def toSpaceWord(str: String): SpacedWord = SpacedWord(str)

    val w = List[SpacedWord]( "you", "manage", "it", "easily" )
    println( w.mkString("") )
  }
}
