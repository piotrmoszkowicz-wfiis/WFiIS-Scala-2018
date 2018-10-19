object Task2 {
  def main(args: Array[String]): Unit = {
    val inventory = List(
      ("rose while star", 12),
      ("sunflower", 3),
      ("orchid", 7),
      ("carnation white", 30),
      ("carnation red", 25)
    )

    printTupleList(inventory)

    println("----------")

    val filteredTuples = filterTupleList(inventory)
    printTupleList(filteredTuples)

    println("----------")

    val filteredTuplesWithGenerator = filterTupleListGenerator(inventory)
    printTupleList(filteredTuplesWithGenerator)
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

  /**
    * Filters and sorts list of tuples
    *
    * @param inventory List[(String, Int)] List of tuples
    * @return List[(String, Int)] List of filtered tuples sorted by 2nd field
    */
  def filterTupleListGenerator(inventory: List[(String, Int)]): List[(String, Int)] = {
    for(item <- inventory if item._2 < 10) yield item
  }
}
