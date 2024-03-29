package lectures.part4patternmatching

object PatternsEverywhere extends App{

  //big idea #1
  try{
    //code
  } catch {
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "NullPointerException"
    case _ => "Something Else"
  }

  //catches are actually matches
  /*
  try {
  //code
  } catch (e) {
  e match {
  case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "NullPointerException"
    case _ => "Something Else"
  }
   */


  //Big Idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield  10 * x

  //generators are also based on pattern matching
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  //big idea #3
  val tuple = (1,2,3)
  val (a,b,c) = tuple

  //multiple value definitions based on pattern matching

  val head :: tail  = list
  println(head)
  println(tail)

  //big idea #4 - NEW
  //partial function
  val mappedList = list.map {
    case v if v % 2 ==0 => v + "is even"
    case 1 => "the one"
    case _ => "something else"
  } //partial function

  val mappedList_two = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + "is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }//Equivalent

  println(mappedList)
}
