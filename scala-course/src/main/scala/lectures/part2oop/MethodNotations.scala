package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String ){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name} "
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)
  // works when method has a single parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !
  /*
  ChatGPT
  In Scala, a unary prefix is a method that takes no arguments and returns a modified version of the object on which it is called.
  The method is prefixed with the unary_ operator, which is a special operator in Scala that allows you to define methods that are
  invoked using prefix notation, such as -x instead of x.unary_-.

  For example, you can define a unary prefix method that negates the value of an integer:

  class MyInt(val value: Int) {
    def unary_- : MyInt = new MyInt(-value)
  }
  val x = new MyInt(5)
  val y = -x
  println(y.value) // -5
  In this example, the unary_- method is defined on the MyInt class, and it returns a new MyInt object with the negated value of the original. When the - operator is used on an instance of MyInt, it calls the unary_- method, which negates the value.
  */

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply - special function in scala!
  println(mary.apply())
  println(mary()) // equivalent




}
