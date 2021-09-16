package lectures.part1basics

object Expressions extends App{
  val x = 1 + 2  //Expression
  println(x)

  println(1 == 2)
  println(!(4==5))

  var avariable = 3
  avariable +=5
  println(avariable)

  //Instructions(Do) vs Expressions(Value)

  //if expression
  val if_a_condition = true
  val a_condition_value = if(if_a_condition) 5 else 3
  println(a_condition_value)

  //Loops are discouraged in Scala
  var i = 0
  while(i <10) {
    println(i)
    i += 1;
  }

  //Everything in Scala is a Expression
  val a_weird_value = (avariable = 3)  //Unit === void

  //Side Effects: println(), while, reassigning

  //Code Blocks
  //Variables in Code Blocks are not visible outside the block
  val a_code_block = {
    val y = 9
    val z = 9 + 1
    if(y > z) "Hello" else "Bye"
  }
  println(a_code_block)

}
