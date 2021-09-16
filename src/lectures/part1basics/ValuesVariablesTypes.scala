package lectures.part1basics

object ValuesVariablesTypes extends App{

  //Val are immuable
  val x: Int = 45;
  println(x)

  //Data Types of val are optional, compiler can infer types
  val y = 45;
  println(y)

  val new_string: String = "This is a String"

  val new_boolean: Boolean = false
  val new_char: Char = 'r'
  val new_short: Short = 355
  val new_int: Int = x;
  val new_long: Long = 5875687689L
  val new_float: Float = 3.14f
  val new_double: Double = 6.7777

  //Variables are reusable
  var reusable_int: Int = 4
  reusable_int = 5

  //prefer val over var

}
