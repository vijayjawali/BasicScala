package lectures.part2oop

object AbstractDataTypes extends App{

  //abstract
  //abstract classes cannot be instantiated
  abstract class Animal{
    val creature_type: String = "Wild"
    val eat: Unit
  }

  class Dog extends Animal{
    override val creature_type: String = "Canine"
    override val eat = println("crunch crunch")
  }

  //traits
  trait Carnivore{
    def eat(animal: Animal) : Unit
    val preferred_meal: String = "Fresh Meat"
  }

  trait ColdBlodded

  class Crocodile extends Animal with Carnivore with ColdBlodded {
    override val creature_type: String =  "croc"
    val eat: Unit = println("nomnomnom")
    def eat(animal: Animal) = println(s"I am a croc and i am eating a ${animal.creature_type}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract classes
  //1 - traits do not have constructor parameters
  //2 - Multiple traits can be inherited by the same class
  //3 - traits are behaviour, abstract class is a type of thing.
}
