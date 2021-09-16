package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal{
    def eat: Unit
  }

  //anonymous class
  val funnyanimal: Animal = new Animal {
    override def eat: Unit = println("hahaha")
  }

  println(funnyanimal.getClass)

  class Person(name: String){
    def sayHi = println(s"HI, my name is $name.")
  }

  val jim = new Person("Jim"){
    override def sayHi = println(s"HI, my name is Jim.")
  }
  jim.sayHi
}
