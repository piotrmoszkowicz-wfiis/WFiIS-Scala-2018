class MyString ( val content: String ) {
  override def toString: String = {
    content
  }
  def wrap(prefix: String, suffix: String): String = content
  def transform(func: String => String): String = content
}

trait Wrap extends MyString {
  var prefix = ""
  var suffix = ""
  override def wrap(pref: String, suff: String): String = {
    prefix = pref
    suffix = suff
    prefix + content + suffix
  }
  override def toString: String = prefix + super.toString + suffix
}

trait Transform extends MyString {
  var transformation: String => String = (str: String) => str
  override def transform(func: String => String): String = {
    transformation = func
    transformation(content)
  }
  override def toString: String = transformation(super.toString)
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
