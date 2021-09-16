package lectures.part2oop

object Inheritance extends App{

  //single class inheritance
  sealed class Animal{
    val creature_type ="Wild"
    protected def eat = println("nomnomnom")
    def drink  = println("Animal Drinks water")
  }

  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }

  }

  val cat = new Cat
  cat.crunch

  //Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends  Person(name)

  //overriding
  class Dog(override val creature_type: String) extends Animal {
    //overriding works for method same as val and var
    override def eat = println("crunch crunch")
    //override val creature_type = "Domestic"
    //overriding can be possible in the constructor as well

    override def drink  = {
      super.drink
      println("Dog Drinks water")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creature_type)

  //type substitution (broad: polymorphism
  val unknownAnimal:Animal = new Dog("K9")
  //overloading
  unknownAnimal.drink

  //super

  // preventing overrides
  //use keyword final
  // 1 - use final on member
  // 2 - use final on entire class
  // 3 - seal the class(sealed) = extend classes in this file but prevent extension in other files
}
