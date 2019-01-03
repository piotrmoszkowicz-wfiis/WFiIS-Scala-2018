object Task2 {
  def main(args: Array[String]): Unit = {
    val people = List( ("John", "Doe", 23, "male"), ("Joan", "Doe", 23, "female"),
      ("Steve", "Jenkins", 24, "male"), ("Eva", "Robinson", 25, "female"), ("Ben", "Who", 22, "male"), ("Janet",
      "Reed", 21, "female"), ("Rob", "Jenkins", 26, "male"), ("Ella", "Dawson", 27, "female") )

    println("Males:")
    println(people.filter(_._4 == "male"))

    println("Females:")
    println(people.filter(_._4 == "female"))

    val aboveTwentryThree: List[String] = people.filter(_._3 >= 23).map(x => x._1)
    println("Above 23:")
    println(aboveTwentryThree)

    val isJohnJoe = people.count(person => person._1 == "John" || person._1 == "Joe" )
    println("Is there Joe or John:")
    println(isJohnJoe > 0)

    val isEveryoneOlderThan20 = people.count(person => person._3 > 20)
    println("Is everyone older than 20:")
    println(isEveryoneOlderThan20 == people.length)

    val nameAge = people.map(person => (person._1, person._3))
    println("Name&Age:")
    println(nameAge)

    val groupByAge = people.groupBy(person => person._3)
    println("Group by Age:")
    println(groupByAge)

    val (older, younger) = people.partition(person => person._3 > 23)
    println("Younger:")
    println(younger)
    println("Older:")
    println(older)

    val youngest = people.reduce((acc, value) => {
      if (acc._3 > value._3) value else acc
    })
    val oldest = people.reduce((acc, value) => {
      if (acc._3 < value._3) value else acc
    })
    println("Youngest:")
    println(youngest)
    println("Oldest:")
    println(oldest)

    val (women, men) = people.partition(person => person._4 == "women")
    println("Are equal num of genders:")
    println(women.length == men.length)

    val sortedAboveThwentyThree = people.sortBy(_._3).dropWhile(person => person._3 < 23)
    println("Sorted above 23:")
    println(sortedAboveThwentyThree)
  }
}
