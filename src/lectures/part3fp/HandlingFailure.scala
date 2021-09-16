package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{

  //create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String")

  //TRY
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  //Syntax Sugar
  val anotherPotentialFailure = Try {
    //code that might throw
  }

  //utilities
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A Valid Result"
  val fallbackTry = Try(unsafeMethod() orElse (backupMethod()))
  println(fallbackTry)

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A Valid Result")
  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()

  println(betterFallBack)

  //map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  // => for-comprehensions

  /*
  Exercise
   */

  val host = "localhost"
  val port = "8000"
  def renderHTML(page: String) = println(page)

  class Connection{
   def get(url: String): String = {
     val random = new Random(System.nanoTime())
     if(random.nextBoolean()) "<html>...</html>"
     else throw new RuntimeException("Connection Interrupted")
   }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService{
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone Else took the port")
    }
    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  //if you get the html page from the connection, print it to the console i.e. call renderHTML
  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connectioon => connectioon.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  //shorthand version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  //for-comprehension
  for{
    connection <-  HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)
}
