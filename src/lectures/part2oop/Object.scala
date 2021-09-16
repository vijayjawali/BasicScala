package lectures.part2oop

object Object{

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")
  object Person { //type + its only instance
    //"static"/"class" - level functionality
    val N_EYES = 2
    def can_fly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person) = new Person("Bobbie")
  }

  class Person(name: String) {
    //instance level functionality
  }

  def main(args: Array[String]): Unit = {
    //COMPANIONS
    //Scala Companions can access each others private members
    println(Person.N_EYES)
    println(Person.can_fly)

    //SCALA OBJECT = SINGLETON INSTANCE
    val person_1 = Person
    val person_2 = Person
    println(person_1 == person_2)

    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val bobbie = Person(mary, john)
    /*
  Scala Application = Scala object with
  def main(args: Array[String]): Unit
   */
  }
}
