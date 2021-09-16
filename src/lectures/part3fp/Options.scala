package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  //unsafe API
  def unsafMethod(): String = null
  val result = Option(unsafMethod())
  println(result)

  //chained methods
  def backupMethod(): String = "A Valid Result"
  val chainedResult = Option(unsafMethod()).orElse(Option(backupMethod()))

  //Design unsafe API
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A Valid Result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  //functions on options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)  //unsafe - Do not use

  //map, flatMap, filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //for-comprehensions

  /*
  Exercise
   */

  val config: Map[String, String] = Map(
    //fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" ->"80"
  )

  class Connection{
    def connect = "Connected"
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if(Random.nextBoolean()) Some(new Connection)
      else None
  }

  //try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  //chaining
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  //for - comprehension
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)

}
