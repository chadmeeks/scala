package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println("by value: " + x) // i.e. 14592541101532
    println("by value: " + x) // i.e. 14592541101532
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x) // i.e. System.nanoTime()
    println("by name: " + x) // i.e. System.nanoTime()
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34)
  printFirst(34, infinite()) // pass by name is not evaluated until it is used in the function.  The function never uses y so no stack overflow infinite recursion




}
