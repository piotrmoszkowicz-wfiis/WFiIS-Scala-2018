class BChar(val char: Array[Array[Char]]) {
  def print(): Unit = for ( i <- 0 until 5; j <- 0 until 5) {
    Console.print(char(i)(j))
    if (j == 4)
      println()
  }
  def +(charToAdd: BChar): BChar = {
    for ( i <- 0 until 5; j <- 0 until 5) {
      if (this.char(i)(j) != '*' && charToAdd.char(i)(j) == '*') {
        this.char(i)(j) = '*'
      }
    }
    this
  }
  def -(charToDelete: BChar): BChar = {
    for ( i <- 0 until 5; j <- 0 until 5) {
      if (this.char(i)(j) == '*' && charToDelete.char(i)(j) == '*') {
        this.char(i)(j) = ' '
      }
    }
    this
  }
}

object BChar {
  def A: BChar = {
    BChar.wholeRow(0) + BChar.wholeRow(2) + BChar.wholeColumn(0) + BChar.wholeColumn(4) - BChar.oneChar(0, 0) - BChar.oneChar(0, 4)
  }
  def I: BChar = {
    BChar.wholeColumn(2)
  }
  def Z: BChar = {
    BChar.wholeRow(0) + BChar.wholeRow(4) + BChar.wholeColumn(2)+ BChar.oneChar(3, 1) + BChar.oneChar(1, 3)
  }

  def wholeRow(row: Int): BChar = {
    val charArr: Array[Array[Char]] = Array.fill(5)(Array.fill(5)(' '))
    for ( i <- 0 until 5) {
      charArr(row)(i) = '*'
    }
    new BChar(charArr)
  }

  def wholeColumn(column: Int): BChar = {
    val charArr: Array[Array[Char]] = Array.fill(5)(Array.fill(5)(' '))
    for ( i <- 0 until 5) {
      charArr(i)(column) = '*'
    }
    new BChar(charArr)
  }

  def oneChar(row: Int, column: Int): BChar = {
    val charArr: Array[Array[Char]] = Array.fill(5)(Array.fill(5)(' '))
    charArr(row)(column) = '*'
    new BChar(charArr)
  }
}

object Task1 {
  def main(args: Array[String]): Unit = {
    val A = BChar.A
    A.print()

    println()
    println()

    val Z = BChar.Z
    Z.print()

    println()
    println()

    val I = BChar.I

    val deleted = Z - I
    deleted.print()
  }
}
