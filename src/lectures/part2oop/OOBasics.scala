package lectures.part2oop

object OOBasics extends App{

  val person = new Person("john", 26)
  //When the class is initiated, entire block of code is initiated
  //Class Parameters are not fields
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()


  val author = new Writer("Charles","Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorage)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc
  counter.inc(10).print
}

//Constructor
class Person(name:String,val  age: Int = 0){
  //body

  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says : HI $name")

  //Overloading => overriding the same method with different parameters
  def greet(): Unit = println(s"Hi I am $name")

  //multiple constructors => Definition of another constructor should be a primary constructor and nothing else
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
  //Auxillary constructors can be avoided by using default parameters in primary constructors
}
/*
Novel and a Writer

Writer: firstname, surname, year
  -method fullname

Novel: name, year of release, author
  -authorage
  -iswrittenby(author)
  -copy(new year of release) = new instance of novel with new year of release
 */

class Writer(firstname: String, surname: String, val year: Int){
  def fullname: String = firstname+ " " +surname
}

class Novel(name: String, year: Int, author: Writer){
  def authorage = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newyear: Int):Novel = new Novel(name, newyear, author)
}

/*

Counter Class
  -receives an int value
  -method current count
  -method to increment and decrement => new counter
  -overload inc/dec to receive an amount
 */

class Counter(val count:Int = 0){

  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  }  //immutability
  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}