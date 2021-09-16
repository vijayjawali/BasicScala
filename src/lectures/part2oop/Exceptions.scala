package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length)
  //^^^^^^^^^^^^^^^^^ ths will crash with .NullPointerException

  //throwing and catching exceptions

  //val aweirdvalue: String = throw new NullPointerException

  //throwable classes extend the Throwable class.
  //Exception and Error are major throwable subtype

  //how to catch exceptions
  def getInt(withException: Boolean): Int = {
    if(withException) throw new RuntimeException(" No int for you! ")
    else 42
  }

  val potential_fail = try{
    //code that might throw exception
    getInt(false)
  }catch {
    case e:RuntimeException => 45 //println("Caught a Runtime Exception")
  }finally {
    //code that will get executed no matter what
    //optional
    //does not influence the side effect of the expression
    // use finally only for side effects
    println("finally")
  }

  println(potential_fail)

  //Defining own exceptions
  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
  1. crash your program with a OutOfMemoryError
  2. crash your program with a StackOverflowError
  3. Pocket Calculator
    -add(x,y)
    -subtract(x,y)
    -multiply(x,y)
    -divide(x,y)

    Throw
    -overflowException if add(x,y) exceeds Int.MAX_VALUE
    -underflowException if add(x,y) exceeds Int.MIN_VALUE
    -MathCalculationException for division by 0
   */

  //crash your program with a OutOfMemoryError
  //val array = Array.ofDim(Int.MaxValue)

  //crash your program with a StackOverflowError
  //def infinite: Int = 1+infinite
  //val no_limit = infinite

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by Zero")

  object PocketCalculator{
    def add(x: Int, y: Int) ={
      val result = x+y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y < 0 && result > 0)throw new UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int) ={
      val result = x-y
      if(x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y > 0 && result > 0)throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int) ={
      val result = x*y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if(x > 0 && y < 0 && result > 0)throw new UnderFlowException
      else if(x < 0 && y > 0 && result > 0)throw new UnderFlowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y ==0) throw new MathCalculationException
      else x/y

    }
  }

  println(PocketCalculator.divide(2,0))
}
