package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, favouritemovie: String,val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouritemovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouritemovie)
    def unary_! : String = s"$name, what the heck ?!"
    def unary_+ : Person = new Person(name, favouritemovie, age+1)
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and my favourite movie is $favouritemovie"
    def apply(n: Int): String = s"$name watched $favouritemovie $n times"
    def learns(thing: String) = s"$name is learning $thing"
    def learnscala = this.learns("Scala")

  }

  val mary = new Person("Mary","Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //Equivalent
  //infix notation = operator notation (syntactic sugar)

  //operators in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+ (tom))

  println(1 + 2)
  println(1.+ (2))
  //All Operators are methods


  //prefix notation
  val x = -1
  val y = 1.unary_- //equivalent
  //unary operator only works with + - ~ !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) //equivalent



  /*

  1. Overload the + operator
  mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the person class
  Add a unary + operator => new person with the age + 1
  +mary => mary with the age incrementer

  3. Add a learns method in person class => "Mary Learns Scala"
  add a learnscala method, calls learns method with "scala".
  use it in postfix notation

  4. overload the apply method
  mary.apply(2) => "Mary watched inception 2 times"

   */

  println((mary + "the Rockstar")())
  println((mary + "the Rockstar").apply()) //Equivalent

  println((+mary).age)
  println(mary.learns("Spark"))
  println(mary.learnscala)
  println(mary.apply(4))
}
