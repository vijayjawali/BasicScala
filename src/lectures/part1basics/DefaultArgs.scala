package lectures.part1basics

object DefaultArgs extends App{

  def tail_recursive_function(n: Int, acc: Int = 1): Int = {
    if(n <= 1) acc
    else tail_recursive_function(n-1, n * acc)
  }

  val fact_10 = tail_recursive_function(10)

  //Default parameters must be added at the end

  def save_picture(format: String, width: Int, height: Int): Unit = println("Saving Picture")
  save_picture("JPEG", 720, 1080)

  //Either pass in all leading arguments or name the arguments
  def save_picture_1(format: String = "JPEG", width: Int, height: Int = 1080): Unit = println("Saving Picture")
  save_picture_1(width = 720)

}
