//It is considered good practice to start the name of a class with an upper case letter, for better organization.

/*basic way
Create class
class Car {
    var brand = ""
    var model = ""
    var year = 0
}
Objects
val c1 = Car()
c1.brand = "Ford"
c1.model = "Mustang"
c1.year = 1969

val c2 = Car()
c2.brand = "BMW"
c2.model = "X5"
c2.year = 1999

println(c1.brand)  // Ford
println(c2.brand)  // BMW
*/

// Constructor
//class Car(var brand: String, var model: String, var year: Int) separate file
/*
fun main() {
    val c1 = Car("Ford", "Mustang", 1969)
    val c2 = Car("BMW", "X5", 1999)
    val c3 = Car("Tesla", "Model S", 2020)
    val c4 = Car("Dodge", "Coronet", 1968)

    println(c4.brand)
    println(c4.model)
    println(c4.year)
    }

    A class is a blueprint for creating objects that have properties and functions.
    A class is declared using the keyword class followed by the class name and optional type parameters. For example:

	class Person(val name: String, var age: Int)

	This declares a class named Person with two properties: name and age.
	The val keyword means that the property is read-only, while the var keyword means that the property is mutable.

	A constructor is a special function that is used to initialize a class instance.
	A class can have a primary constructor and one or more secondary constructors.
	The primary constructor is declared in the class header, after the class name and type parameters. For example:

	class Person(val name: String, var age: Int) // primary constructor
	The primary constructor can have parameters that are used to initialize the class properties or run some code in the initializer blocks.
	The initializer blocks are declared with the init keyword inside the class body. For example:


	class Person(val name: String, var age: Int) {
        init {
            println("Person created with name $name and age $age")
        }
	}

	The secondary constructors are declared inside the class body with the constructor keyword.
	They must call the primary constructor or another secondary constructor using the this keyword.
	The this keyword is used to refer to the current class instance or its members.
	For example:

	class Person(val name: String, var age: Int) {
        constructor(name: String) : this(name, 0) // secondary constructor that calls the primary constructor
        constructor() : this("Unknown") // secondary constructor that calls another secondary constructor
        fun printInfo() {
            println("Name: $name, Age: $age")
        }
        fun updateAge(newAge: Int) {
            this.age = newAge // use this to access the property of the current instance
            this.printInfo() // use this to call a function of the current instance
        }
	}
 */