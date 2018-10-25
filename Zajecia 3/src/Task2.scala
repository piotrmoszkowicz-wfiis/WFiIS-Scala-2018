import math.{ sqrt, pow }

object Task2 {
  def main(args: Array[String]): Unit = {
    val points = List(
      (1, 5),
      (6, 3),
      (3, 4),
      (3, 6),
      (6, 15),
      (7, 8),
      (47, 9),
      (9, 10),
      (10, 35),
      (40, 12)
    )

    var result = points
    var bestIteration = 0

    val initialDistance = calculateDistanceForAll(points, 10)
    var bestDistance = initialDistance

    for(i <- List.range(1, 100)) {
      val random = scala.util.Random.nextInt(8)+1
      val (pointsPartOne, pointsPartTwo) = points.splitAt(random)
      val newPoints = pointsPartTwo ++ pointsPartOne
      val newDistance = calculateDistanceForAll(newPoints, 10)

      if (newDistance < bestDistance) {
        bestDistance = newDistance
        result = newPoints
        bestIteration = i
      }
    }

    println(initialDistance)
    println(result)
    println(bestDistance)
    println(bestIteration)
  }

  def calculateDistanceForAll(points: List[(Int, Int)], currentPoint: Int): Double = {
    if (currentPoint == 1) {
      return 0.0
    }
    calculateDistance(points(currentPoint-1), points(currentPoint-2)) + calculateDistanceForAll(points, currentPoint - 1)
  }

  def calculateDistance(firstPoint: (Int, Int), secondPoint: (Int, Int)): Double = {
    sqrt(pow(firstPoint._1 - secondPoint._1, 2) + pow(firstPoint._2 - secondPoint._2, 2))
  }
}
