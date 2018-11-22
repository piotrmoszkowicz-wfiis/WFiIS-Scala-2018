class STime(val hour: Int = 0, val minute: Int = 0, val seconds: Int = 0) {
  override def toString: String = s"${this.hour}:${this.minute}:${this.seconds}"
  def toSec: Int = this.hour * 3600 + this.minute * 60 + this.seconds
  def <(time: STime): Boolean = this.toSec < time.toSec
  def >(time: STime): Boolean = this.toSec > time.toSec
  def ==(time: STime): Boolean = this.toSec == time.toSec
  def !=(time: STime): Boolean = this.toSec != time.toSec
  def moveBy(value: Int, unit: STime.Value): STime = {
    if (unit == STime.Hours)
      STime.apply(this.hour + value, this.minute, this.seconds)
    else if (unit == STime.Minutes)
      STime.apply(this.hour, this.minute + value, this.seconds)
    else
      STime.apply(this.hour, this.minute, this.seconds + value)
  }
}

object STime extends Enumeration {
  val Hours, Minutes, Secounds = Value
  def apply() = new STime()
  def apply(hour: Int, minute: Int, second: Int) = new STime(hour, minute, second)
}

object Task2 {
  def main(args: Array[String]): Unit = {
    val firstTime = STime.apply(10, 10, 10)
    val secondTime = STime.apply(10, 10, 10)
    val thirdTime = STime.apply(10, 10, 11)
    val fourthTime = STime.apply(10, 10, 9)

    println("1:")
    println(firstTime)
    println(secondTime)
    println(thirdTime)
    println(fourthTime)

    println("2:")
    println(firstTime == secondTime)
    println(firstTime != secondTime)
    println(firstTime > secondTime)
    println(firstTime < secondTime)

    println("3:")
    println(firstTime == thirdTime)
    println(firstTime != thirdTime)
    println(firstTime > thirdTime)
    println(firstTime < thirdTime)

    println("4:")
    println(firstTime == fourthTime)
    println(firstTime != fourthTime)
    println(firstTime > fourthTime)
    println(firstTime < fourthTime)

    val fifthTime = firstTime.moveBy(2, STime.Hours)
    println(fifthTime)
  }
}
