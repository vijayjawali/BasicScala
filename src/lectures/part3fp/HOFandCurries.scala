package lectures.part3fp

object HOFandCurries extends App {

  val super_function: (Int,(String, (Int => Boolean)) => Int) => (Int, Int) = null
  //higher order function => have function as a parameter

  //function that applies a function n times over a value x
  //nTimes(f, n, x)
  //nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  //nTimes(f, n, x) = f(f(....f(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if(n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  val plus_one = (x:Int) => x + 1

  println(nTimes(plus_one, 10, 1))

  //nTimesBetter(f, n) = x => f(f(f(...(x)))
  //increment10 = nTimesBetter(plus_one,10) = x => plus_one(plus_one(plus_one(plus_one....(x))))

  def nTimesBetter(f:Int => Int, n: Int): (Int => Int) ={
    if(n <= 0) (x:Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus_10 = nTimesBetter(plus_one, 10)

  println(plus_10(1))


  //curried functions
  val super_adder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val adder_10 = super_adder(10)
  println(adder_10(3))
  println(super_adder(10)(3))

  //function with multiple parameter lists
  def curried_formatter(str: String)(d: Double): String = d.formatted(str)

  val standard_formatter: (Double => String) = curried_formatter("%4.2f")
  val precise_formatter: (Double => String) = curried_formatter("%10.8f")

  println(standard_formatter(Math.PI))
  println(precise_formatter(Math.PI))

  /*

  1. Expand MyList
      - foreach method A => Unit
        [1,2,3].foreach(x => println(x))

      - sort function((A, A) => Int) => MyList
        [1,2,3].sort((x,y) => y - x) => [3,2,1]

      - zipWith (list, (A,A) => B) => MyList[B]
        [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]

      - fold(start)(function) => a value
        [1,2,3].fold(0)(x+y) = 6

  2. toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
     fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

  3. compose(f, g) => x => f(g(x))
     andThen(f, g) => x => g(f(x))

   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = x => y => f(x, y)
  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = (x, y) => f(x)(y)

  //def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  //def andThen(f: Int => Int, g: Int => Int): Int => Int = x => g(f(x))

  def compose[A,B,T](f: A => B, g: T => A): T => B = x => f(g(x))
  def andThen[A,B,C](f: A => B, g: B => C): A => C = x => g(f(x))

  def superAdder:(Int => Int => Int) = toCurry(_+_)
  def add_five = super_adder(5)
  println(add_five(10))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(5, 10))

  val add_two = (x: Int) => x + 2
  val times_three = (x: Int) => x * 3

  val composed = compose(add_two, times_three)
  val ordered = andThen(add_two, times_three)

  println(composed(4)) // add_two(times_three(4))) = add_two(4 * 3) = add_two(12) = 12 +2 = 14
  println(ordered(4)) // times_three(add_two(4)) = times_three(4 + 2) = times_three(6) = 6 * 3 = 18

}
