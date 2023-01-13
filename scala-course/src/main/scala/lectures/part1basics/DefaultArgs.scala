package lectures.part1basics

object DefaultArgs extends App{

  // Example using a default value for a parameter, in this case the accumulator
  // if you have a default value then you don't need to pass the parameter in the function call
  // however, you cannot omit leading arguments because the compiler will get confused
  def tailRecursiveFactorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailRecursiveFactorial(n-1, n*acc)

  val fact10 = tailRecursiveFactorial(10)

 def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

 savePicture(width = 800)

 /*
 1. pass in every leading argument
 2. name the arguments

 naming the arguments lets you put them in any order
 */

}
