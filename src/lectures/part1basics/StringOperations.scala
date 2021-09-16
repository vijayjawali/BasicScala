package lectures.part1basics

object StringOperations extends App{

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 10))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val a_number_string = "2"
  val a_number = a_number_string.toInt

  //prepending and appending
  println('a' +:a_number_string:+ 'z')

  println(str.reverse)
  println(str.take(2))

  //Scala Specific String Interpolators

  //s-interpolators

  val name = "David"
  val age = 12
  val greetings = s"Hello, my name is $name and my age is $age"
  val another_greetings = s"Hello, my name is $name and i will be turning  ${age+1} ears old"

  println(greetings)
  println(another_greetings)

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw interpolators
  println(raw"This is a \n line")
  val escaped = "This ia a \n line"
  println(raw"$escaped")

}
