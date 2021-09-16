package lectures.part2oop

object Generics extends App{

  class MyList[+A] {
    //Use the type A
    def add[B >: A](element: B) : MyList[B] = ???
  }

  class MyMap[Key, Value]{

  }

  val listofIntegers = new MyList[Int]
  val listofStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //1. List[Cat] extends List[Animal] = COVARIANCE

  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //animalList.add(new Dog) ??? => we return a list of animal

  //2. No = Invariance
  class InvariantList[A]
  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Dog] //ERROR

  //3. Contravariance
  class ContraVariance[-A]
  val contravariantList: ContraVariance[Cat] = new ContraVariance[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: Animal)
  val cage = new Cage(new Cat)

  //expand MyList to be generic


}
