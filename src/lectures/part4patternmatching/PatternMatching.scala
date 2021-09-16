package lectures.part4patternmatching

import com.sun.jnlp.JNLPRandomAccessFileNSBImpl

import scala.util.Random

object PatternMatching extends App{

  //switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "Something else" // _ = Wildcard
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name : String, age: Int)
  val bob = Person("bob",20)

  val greetings = bob match {
    case Person(n,a) if a < 21 => s"Hi, my name is $n and I can't drink in US"
    case Person(n,a) => s"Hi, my name is $n and i am $a years old"
    case _ => "I don't know who I am"
  }

  println(greetings)

  /*
  1. cases are matched in order
  2. what if no cases match ? MatchError
  3. type of pattern matching expression ? Unified type of all the types in all cases
  4. PM really works with case classes
   */

  //PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a Dog of $someBreed breed")
  }

  //match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  /*
  Exercise
  simple function uses PM
  takes an expression => human readable form

  Sum(Number(2), Number(3)) => 2 + 3
  Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
  Prod(Sum(Sum(Number(2), Number(1)), Number(3))) = (2 + 1) * 3
  Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
   */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParantheses(exp: Expr)= exp match {
        case  Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "( " + show(exp) + " )"
      }
      maybeShowParantheses(e1) + " * " + maybeShowParantheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))


}
