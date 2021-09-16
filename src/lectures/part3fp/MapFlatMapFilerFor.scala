package lectures.part3fp

object MapFlatMapFilerFor extends App {

  val list = List(1, 2, 3)

  println(list)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_+1))
  println(list.map(_+ " is a number"))

  //filter
  println(list.filter(_ % 2 ==0))

  //flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  //print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colours = List("Black","White")

  val combinations = numbers.flatMap(n => chars.flatMap(c => colours.map(colour => ""+ c + n +"-"+ colour)))
  println(combinations)

  //foreach
  list.foreach(println)

  //for - comprehensions
  val forCombinations = for {
    n <- numbers if n %2 ==0
    c <- chars
    colour <- colours
  } yield ""+ c + n +"-"+ colour
  println(forCombinations)

  for{
    n <- numbers
  } println(n)

  //syntax overload
  println(list.map(x => x * 2))

  /*
  1. MyList supports for comprehensions ?
  map(f: A => B) => MyList[B]
  filter(p:A => Boolean) => MyList[A]
  flatMap(f: A => MyList[B]) => MyList[B]
  2. A small collection of at most one element - Maybe[+T]
      -map, flatMap, filter
   */


}
