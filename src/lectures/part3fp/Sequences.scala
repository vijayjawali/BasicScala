package lectures.part3fp

import scala.util.Random

object Sequences extends App{
  val aSequence = Seq(1,2,3,4,0)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence++Seq(5,6,7))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //Lists
  val aList = List(1,2,3)
  val prepend = 42 +: aList :+ 56
  println(prepend)

  val apple_five = List.fill(5)("Apple")
  println(apple_five)
  println(aList.mkString("-+-"))

  //Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  //mutation
  numbers(2) = 0 //syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  //arrays and sequences
  val numberSeq: Seq[Int] = numbers  //implicit conversion
  println(numberSeq)

  //Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  //vector vs list

  val maxRuns = 1000
  val maxCapacity = 100000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for{
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}
