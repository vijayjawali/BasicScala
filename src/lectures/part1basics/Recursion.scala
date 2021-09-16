package lectures.part1basics

object Recursion extends App{

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else
    println("Computing Factorial of " + n + " - first need factorial of " + (n-1))
    val result = n * factorial(n-1)
    println("Computed Factorial of " + n + " - I first need factorial of " + (n-1))
    result
  }

  println(factorial(5))
}
