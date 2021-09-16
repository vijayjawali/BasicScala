package lectures.part3fp

object AnonymousFunctions extends App{

  /*
  val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }
  */

  //anonymous function (Lambda)
  val doubler: Int => Int = x => x * 2

  //multiple parameters in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no parameters
  val just_do_something: () => Int = () => 3

  println(just_do_something)  //function itself
  println(just_do_something()) //call

  //curly braces with lambda
  val str_to_int = { (str: String) => str.toInt }

  //syntactic sugar
  val nice_incrementer: Int => Int = _ + 1
  val nice_adder: (Int, Int) => Int = _ + _

  /*
    1. MyList: Replace all the functionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  val super_adder = (x:Int) => (y:Int) => x + y
  println(super_adder(3)(4))
}
