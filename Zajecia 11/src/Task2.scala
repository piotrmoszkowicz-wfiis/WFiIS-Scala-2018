import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util._

object Task2 {

  def psearch(vec: Vector[Char], c: Char): Future[Option[Char]] = {
    val splitted = vec.grouped(vec.length / 10).toList

    Future.sequence(splitted.map(x => Future[Boolean]{
      x.indexOf(c) != -1
    })) map {
      result => if (result.contains(true)) Option(c) else None
    }
  }

  def main(args: Array[String]): Unit = {
    val x = Random.alphanumeric
    // val rstr = (x take 100).toVector
    val rstr = (x take 100).toVector

    val found = psearch( rstr, 'x')

    found onComplete   {
      case Success(f) => println("found " + f )
    }

    Await.ready( found , Duration(10, SECONDS))
  }
}
