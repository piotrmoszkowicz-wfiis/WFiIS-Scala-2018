class Person(val name: String, val fname: String, val age: Int) {
  override def toString: String = s"Person($name,$fname,$age)"
}
class Company(val name: String, val origin: String) {
  override def toString: String = s"Company($name,$origin)"
}
class DiWord(val word1: String, val word2: String) {
  override def toString: String = s"DiWord($word1,$word2)"
}

object Task2 {
  def extr(list: List[Any]): List[Any] = {
    list.map(_ match {
        case map: Map[String, String] => {
          if(map contains "name") {
            new Person(map("name"), map("fname"), map("age").toInt)
          } else {
            new Company(map("company"), map("origin"))
          }
        }
        case diWord: List[String] => new DiWord(diWord.head, diWord(1))
      }
    )
  }

  def onlyPeople(list: List[Any]): List[Person] = {
    list.filter(_.isInstanceOf[Person]).asInstanceOf[List[Person]]
  }

  def onlyComp(list: List[Any]): List[Company] = {
    list.filter(_.isInstanceOf[Company]).asInstanceOf[List[Company]]
  }

  def main(args: Array[String]): Unit = {
    val data = List( Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
      Map("company" -> "ABB", "origin" -> "Sweden"),
      Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
      Map("company" -> "F4", "origin" -> "Poland"),
      List("Cos", "innego"),
      Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
      Map("company" -> "AGH", "origin" -> "Poland"),
      Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
    )
    val p = extr(data)
    println(p)
    println(onlyPeople(p))
    println(onlyComp(p))
  }
}
