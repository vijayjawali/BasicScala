package lectures.part3fp

object TuplesAndMaps extends App {

  val aTuple = (2,"Hello, Scala") //Tuple2[Int, String] = (Int, String)
  println(aTuple._1)
  println(aTuple.copy(_2 = "Goodbye, Java"))
  println(aTuple.swap)

  //Maps - Keys => values
  val aMap: Map[String, Int] = Map()

  val phone_book = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is syntactic sugar for (a, b)
  println(phone_book)

  //Map operations
  println(phone_book.contains("Jim"))
  println(phone_book("Mary"))

  //Add a pairing
  val newPairing = "Mary" -> 899
  val new_phone_book = phone_book + newPairing
  println(new_phone_book)

  //functions on map
  //map, flatMap, filter

  println(phone_book.map(pair => pair._1.toLowerCase -> pair._2))

  //filterkeys
  println(phone_book.filterKeys(x => x.startsWith("J")))

  //mapvalues
  println(phone_book.mapValues(number => number * 10))

  //conversion to other collection
  println(phone_book.toList)
  val conv = phone_book.toList.toMap
  println(conv)

  val list = List("Daniel","Danny","Angela","Anny","John", "Jacob","Robin")
  println(list.groupBy(x => x.charAt(0)))

  /*
  1. What would happen if i had two original entries "Jim" -> 555 and "JIM" -> 555 and applied toLower() on key
      you may lose data

  2. overly simplified social network based on maps
     Person = String
     - add a person to the network
     - remove
     - friend (mutual)
     - unfriend

     - number of friends of a person
     - person with most friends
     - how many people have no friends
     - if there is a social connection between two people ( direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] ={
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if(!network.contains(person)) 0
    else network(person).size
  }

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(pair => pair._2.size)._1
  }

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(_._2.isEmpty)
  }

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if(person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))

}
