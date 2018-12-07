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

object Task1_3 {
  def main(args: Array[String]): Unit = {
    val s1 = new MyString("Hello") with Wrap wrap(">>", "<<")
    println(s1)
    val s2 = new MyString("There")  with Transform transform(
      _.toLowerCase )
    println(s2)
  }
}
