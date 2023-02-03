package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 0 ){
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(count: Int): String = s"$name watched $favoriteMovie $count times"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name} "
    def +(nickname: String): Person = new Person(this.name + " " + nickname, favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def likes(movie: String): Boolean = movie == favoriteMovie
    def learns(lesson: String): String = s"$name learns $lesson"
    def learnsScala: String = this learns "Scala" // same as this.learns("Scala")

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

  /* EXERCISES
  1. Overload the + operator
     mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person class with default 0 value
     Add a unary + operator => new person with the age + 1
     +mary => mary with the age incrementer

  3. Add a "learns" method in the Person class => "Mary learns Scala" (pass string)
     Add a learnsScala method, calls learns method with "Scala".

  4. Overload the apply method to receive a number and return a string
     mary.apply(2) => "Mary watched Inception 2 times"
  */

  println("\nExercise Results Starting Now")
  println("-----------------------------")
  println("Excercise 1")
  val rockstar = mary + "the rockstar"
  println(rockstar())
  println((mary + "the Rockstar")())
  println((mary + "the Rockstar").apply())

  println("\nExercise 2")
  println(mary.age) // should print 0, default age
  val oldMary = +mary
  println(oldMary.age) // should print 1
  println((+mary).age) // should print 1

  println("\nExercise 3")
  println(mary.learns("Cooking"))
  println(mary.learnsScala)
  println(mary learnsScala)

  println("\nExercise 4")
  println(mary(2))



}
