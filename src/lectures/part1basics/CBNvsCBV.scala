package lectures.part1basics

object CBNvsCBV extends App{

  def call_by_value(x: Long): Unit = {
    println("by value: " +x)
    println("by value: " +x)
  }

  def call_by_name(x: => Long): Unit = {
    println("by value: " +x)
    println("by value: " +x)
  }

  println(call_by_value(System.nanoTime()))
  println(call_by_name(System.nanoTime()))

  def infinite(): Int = 1+infinite()
  def print_first(x: Int, y: => Int) = println(x)


  // Error, as infinite cannot br printed
 // print_first(infinite(), 44)

  //No Error, as second parameter is sent by name and is Lazy Evaluated, in this case is not evaluated at all
  print_first(44, infinite())


}
