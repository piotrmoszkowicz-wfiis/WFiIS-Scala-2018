import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util._

object Task2 {

  def psearch(vec: Vector[Char], c: Char): Future[Int] = {
    val splitted = vec.grouped(vec.length / 10).toList

    Future.sequence(splitted.map(x => Future[Int]{
      x.count(char => char == c)
    })) map {
      result => {
        result.sum
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val x = Random.alphanumeric
    val rstr = (x take 100).toVector

    val found = psearch( rstr, 'x')

    found onSuccess  {
      case f => println("found " + f )
    }

    Await.ready( found , Duration(10, SECONDS))
  }
}
