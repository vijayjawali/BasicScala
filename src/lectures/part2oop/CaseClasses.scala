package lectures.part2oop

object CaseClasses extends App{

  case class Person(name: String, age: Int)

  //1. Class Parameters are fields
  val jim = new Person("Jim",55)
  println(jim.name)

  //2. Sensible toString
  //println(instance) = println(instance.toString) //Syntactic sugar
  println(jim)

  //3. equals and hashcode implemented OOTB
  val jim_2 = new Person("Jim",55)
  println(jim == jim_2) //TRUE

  //4. case class have handy copy method
  val jim_3 = jim_2.copy(age = 44)
  println(jim)

  //5. case class have companion objects already created
  val theperson = Person
  val mary = Person("Mary", 23)

  //6. case classes are serializable

  //7. case classes have extractor patterns = case classes can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "UK"
  }

  /*
  Expand MyList - use case classes and case objects
   */
}
