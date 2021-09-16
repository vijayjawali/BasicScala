package lectures.part2oop

import playground.{Cinderalla => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App{

  //package members are accessible by their simple names
  val writer = new Writer("Daniel","RockTHeJVM",2018)

  //import the package
  val princess = new playground.Cinderalla  //fully qualified name

  val princess_cinderella = new Princess

  //packages are in hierarchy
  //matching folder structure

  //package object
  sayHello
  println(speed_of_light)

  //imports
  val prince = new PrinceCharming

  // use fully qualified name
  val date = new java.util.Date(2018, 5, 4)
  val sql_date = new java.sql.Date(2018, 5, 4)

  val sql_renamed_date = new sqlDate(2018,5,4)

  //default imports
  //java.lang = String, Object Exception
  //Scala = Int, Nothing, Function
  //scala.predef = println. ???
}
