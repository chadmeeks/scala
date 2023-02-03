package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Objects do not have parameters

  object Person { // type + its only instance, has "static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //Often used to contain Factory methods
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) { // instance-level functionality

  }
  // COMPANIONS = object and class with the same name and same scope



  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
  // which gets converted into public static void main(String[] args)
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val john = Person
    println(mary == john)

    // If you have a class then you can instantiate an instance
    val chad = new Person("chad")
    val meghan = new Person("meghan")
    println(chad == meghan)

    val bobbie = Person(meghan, chad) // Factory implemented as apply() method in the Singleton object

  }

}

/*
ChatGPT
what is extends App in scala?

extends App in Scala is a shorthand for extending the App trait and defining a main method.
It is a convenient way of creating a standalone executable Scala program.

The App trait is defined in the scala.App package and it provides a main method that takes an array of strings as an argument.
The main method is automatically executed when the program is run.
Instead of defining a main method, you can put the code you want to execute in the body of the class or object that extends App.

For example, the following is a valid Scala program:

object HelloWorld extends App {
  println("Hello, World!")
}

It is equivalent to the following program with a main method:

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}
It is a nice way to write a short script, or to test some code that you want to run, but it is not recommended for bigger projects,
as it can make the code harder to test and understand the control flow.
*/