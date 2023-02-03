package lectures.part2oop

object AbstractDataTypes extends App{

  // abstract
  abstract class Animal {
    val creatureType: String = "wild" //abstract, typically no value provided, but you can provide one
    def eat: Unit //abstract, no implementation provided
  }

    class Dog extends Animal {
      override val creatureType: String = "Canine"
      def eat: Unit = println("crunch crunch") // don't need keyword override, compiler figures this out
    }

    // traits - ultimate abstract data types in scals
    trait Carnivore {
      def eat(animal: Animal): Unit
      val preferredMeal: String = "freshMeat"
    }

    trait ColdBlooded

    class Crocodile extends Animal with Carnivore with ColdBlooded {
      override val creatureType: String = "croc"
      def eat: Unit = println("nomnomnom")
      def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
    }

    val dog = new Dog
    val croc = new Crocodile
    croc.eat(dog)

    // traits vs abstract classes
    // both allow abstract and non-abstract members
    // 1 - traits do not have constructor parameters
    // 2 - multiple traits may be inherited by the same class
    // 3 - traits = behavior, abstract class = "thing"

}
