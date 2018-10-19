object Task2_3 {
  def main(args: Array[String]): Unit = {
    var inventory: List[(String, Int)] = List()

    inventory = ("rose while star", 12) :: inventory
    inventory = ("sunflower", 3) :: inventory
    inventory = ("orchid", 7) :: inventory
    inventory = ("carnation white", 30) :: inventory
    inventory = ("carnation red", 25) :: inventory

    printTupleList(inventory)

    println("----------")

    val filteredTuples = filterTupleList(inventory)
    printTupleList(filteredTuples)
  }

  /**
    * Prints list of tuples to the console
    *
    * @param list List[(String, int)] List of tuples
    */
  def printTupleList(list: List[(String, Int)]): Unit =
    list.foreach(item => println(f"${item._1}%20s: ${item._2}"))

  /**
    * Filters and sorts list of tuples
    *
    * @param inventory List[(String, Int)] List of tuples
    * @return List[(String, Int)] List of filtered tuples sorted by 2nd field
    */
  def filterTupleList(inventory: List[(String, Int)]): List[(String, Int)] = {
    inventory
      .filter(_._2 < 10)
      .sortBy(_._2)
  }
}
