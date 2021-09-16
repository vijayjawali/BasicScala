package lectures.part1basics

object Functions extends App{

  def a_Function(a: String, b: Int): String = {
    a + "" + b
  }
  println(a_Function("Hello", 6))

  def a_parameterless_function() = 56
  println(a_parameterless_function())
  println(a_parameterless_function)

  //Recursive Function
  def a_reperated_function(a_string: String, n: Int): String = {
    if(n == 1) a_string else a_string + " " + a_reperated_function(a_string, n-1)
  }

  println(a_reperated_function("HI", 6))

  //When you need loops, use recursion

  def a_function_with_side_effects(input_string: String): Unit = {
    println(input_string)
  }
  a_function_with_side_effects("Print this")

  //Auxiliary Functions
  def a_big_function(n: Int): Int = {
    def a_small_function(a: Int, b:Int): Int = a + b
    a_small_function(n, n+1)
  }

  println(a_big_function(20))

}
