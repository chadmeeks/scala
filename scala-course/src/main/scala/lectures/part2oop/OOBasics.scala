package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  // Exercise 1
  println("Starting Exercise 1")
  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  // Exercise 2
  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

  // constructor:  class definition is a constructor
  // default values can be provided, i.e. age: Int = 0
  class Person(name:String, val age: Int = 0) {
    //body
    val x = 2 // val and var definitions ARE fields, i.e. can access via .field

    println(1+3)


    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overloading, same method name with different signature
    def greet(): Unit = println (s"Hi, I am $name") // $name is implied to be the object name "John" unless the method has the same parameter name, then you need .this

    // multiple constructors
    def this(name: String) = this(name, 0)
    def this() = this("John Doe")

}

// class parameters are NOT FIELDS
// add val to parameter to turn it into a field

/*
  Exercise 1:  Novel and a Writer
  Writer: first name, surname, year of birth
    -method fullname

  Novel: name, year of release, author
  -authorAge = returns age of author at year of release
  -isWrittenBy(author)
  -copy (new year of release) = new instance of Novel

  Exercise 2: Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => new Counter
  - overload inc/dec to receive an amount (will be a new Counter)
*/

  class Writer(first_name: String, last_name: String, val birth_year: Int){
    def fullName(): String = first_name + " " + last_name
  }

  class Novel(novel_name: String, release_year: Int, author: Writer){
    def authorAge = release_year - author.birth_year // scala lets you skip the () signature and also infers the return type
                                                     // must add "val" to the Writer class signature to make birth_year an accessible Field

    def isWrittenBy(author: Writer) = author == this.author

    def copy(new_release_year: Int): Novel = new Novel(novel_name, new_release_year, author)

  }

class SimpleCounter(val x: Int) {
  //def currentCount = x // OR currentCount(): Int = x OR just add "val" before the parameter in the signature to turn it into an accessible field
  def inc = new Counter(x + 1) // immutability
  def dec = new Counter(x - 1)

  def inc(n: Int) = new Counter(x + n)
  def dec(n: Int) = new Counter(x - n)

  def print = println(x)
}

class Counter(val x: Int = 0){
    def inc = {
      println("incrementing " + x + " to " + (x+1))
      new Counter(x + 1) // immutability
    }
    def dec = {
      println("decrementing")
      new Counter(x - 1)
    }

    def inc(n: Int): Counter = {
      if (n <= 0) this
      else inc.inc(n-1)
    }
    def dec(n: Int): Counter = {
      if (n <= 0) this
      else dec.dec(n-1)
    }

    def print = println(x)
  }