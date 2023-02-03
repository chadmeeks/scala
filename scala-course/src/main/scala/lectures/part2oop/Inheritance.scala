package lectures.part2oop

object Inheritance extends App{

  // single class inheritance (can only extend one class)
  // method: private access modifier means only the original class can access
  // method: protected access modifier means subclasses can also access.  only methods can access, can't call directly from an object instance
  // method: public (no modifier) means anyone can access
  class Animal {
    val creatureType = "Wild"
    def eat = println("nom nom nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch
  // cat.eat would not work

  //constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // need to include (name, age) to extend Person

  class Person2(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult2(name: String, age: Int, idCard: String) extends Person2(name) // calls the "this" constructor

  // overriding
  class Dog extends Animal {
    override val creatureType = "Domestic"
    override def eat = println("dog: crunch crunch")
  }
  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat

  // OverRIDING vs overLOADING
  // overriding = supplying different implementation in derived classes
  // overloading = supplying multiple methods with different signatures, but same name in the same class

  // super = reference a method or field from a parent class, i.e. super.eat

  // preventing overrides
  // 1 - use the keyword "final" on member
  // 2 - use final on the class itself, prevents the entire class from being extended
  // 3 - seal the class (keyword "sealed") = extend class in THIS FILE, prevent extension in other files
}
