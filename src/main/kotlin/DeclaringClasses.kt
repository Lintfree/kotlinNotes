//class DeclaringClasses   {
	/*
	When programmers implement an object-oriented program, they often use already defined classes to build it.
	For example, an object of the Scanner class allows you to get the next word from the console input, and this word is itself an object of the String class.
	Nevertheless, programmers still often need to declare some program-specific classes. In this topic,
	we will discuss several ways of creating and using your own simple class.

	Declaring new classes
	In order to declare a new class, you need to write the class keyword and the class name after it. First, let's declare a class named Emptiness:

	class Emptiness {
		// empty body
	}
	In Kotlin, when a class has an empty body, curly braces can be omitted. So the same class can be defined in the following way:

	class Emptiness
	You can declare classes in .kt files. Usually, it's better to declare them at the top level of a file but you can declare them in other places,
	even inside a function.
	*/

	/*
	Object creation
	What's the purpose of declaring a class? Well, simply speaking, each defined class introduces a new type.
	So you can create objects of a class and store them as variables and values. Sometimes standard types are not enough, so this comes in handy.
	There will be a few examples later on to make it clear.

	To create an instance of a class, simply write the class name and empty parentheses.
	In other words, the syntax is similar to calling a function. For example, let's do that for the Emptiness class:

	val empty: Emptiness = Emptiness()
	We have just assigned a new object of the Emptiness class to the empty variable.
	This variable has the Emptiness type so you can't reassign an object of any other type to it.
	as a general rule in Kotlin the explicit type directive can be omitted:

	val empty = Emptiness()

	 */

	/*
	Class member
	A class body can include class members. For now, we will discuss only properties that replace fields in Kotlin:
	they can store data, too. We will discuss other advantages of properties and other class members in further topics.

	Note that all class members are optional. For example, the Emptiness class has no properties.
	*/

	/*
	Writing properties
	Properties are pretty similar to variables and values.
	If you want to assign a value to a property during runtime, you declare it as a var, otherwise, a val is your choice.
	Also, any property has a strict type. It can be a standard type, like a number or a string, or a custom type.
	So a property type can be your own class and even the same class where the property is declared.

	A property that just stores data must somehow receive an initial value. For example, you can set the property in the class body.
	A class can have as many properties as you need.

	Now let's declare a class for representing a patient in a hospital information system:

	class Patient {
    var name: String = "Unknown"
    var age: Int = 0
    var height: Double = 0.0
	}
	Here we see that the Patient class has three properties that you can reassign: name, age, and height.
	Each object of the class has the same set of fields, but the values of the fields can differ from object to object.
	 */

	/*
	Accessing properties
	Now we will learn how to access object properties. First, we need to create an object:

	var patient = Patient()
	We haven't changed the object properties yet, so they have initial values now.
	To get those properties' values, type in a dot and the property name after the object name:

	println(patient.name) // prints "Unknown"
	println(patient.age)  // prints "0"
	 */

	/*
	Changing properties
	Take a look at the example below. This program creates two patients and sets their properties, then prints them.
	 */

	/*
	class Patient {
		var name: String = "Unknown"
		var age: Int = 0
		var height: Double = 0.0
	}

	fun main() {
		val john = Patient()
		john.name = "John"
		john.age = 30
		john.height = 180.0

		val alice = Patient()
		alice.name = "Alice"
		alice.age = 22
		alice.height = 165.0

		println("${john.name}: ${john.age} yrs, ${john.height} cm")
		println("${alice.name}: ${alice.age} yrs, ${alice.height} cm")
	}
	*/

	/*
	Pay attention that when we assign properties of Alice, the properties of John remain unchanged.
	Also, you need to understand that the val before alice means that we can't reassign a Patient to alice.
	But we can reassign properties of alice because they are marked as var inside the Patient class.
	 */

	/*
	Constructor
	A class can have a constructor. A constructor is a special method that is used to initialize the properties of the class.
	class Planet(var star: String = "Unknown Star", var mass: Double = 1.0, var numberOfSatellites: Int = 1)

	class Rectangle {
		var width: Int = 0
		var height: Int = 0
	}

	fun printArea(rectangle: Rectangle) {
		println(rectangle.width * rectangle.height)
	}

	fun main() {
		val rectangle = Rectangle()
		rectangle.width = 10
		rectangle.height = 5
		printArea(rectangle)
	}
	 */
/*
import java.util.Scanner

class Book(title: String, author: String, pages: Int) {
	var description: String = "$title by $author has $pages pages"

}

fun main(args: Array<String>) {
	val input = Scanner(System.`in`)
	val title = input.nextLine()
	val author = input.nextLine()
	val pages = input.nextInt()

	val book = Book(title, author, pages)
	println(book.description)
}



class BankAccount (deposited: Long, withdrawn: Long) {
	var deposited: Long
	var withdrawn: Long
	var balance: Long
	init {
		this.deposited = deposited
		this.withdrawn = withdrawn
		this.balance = deposited - withdrawn
	}
}
//data class is similar to class, but it can have default values for properties,
// and it can be extended from other classes

data class BankAccount(var deposited: Long, var withdrawn: Long, var balance: Long = deposited - withdrawn)

* from Koans
This code snippet defines a function sendMessageToClient that takes in a Client object,
a message, and a Mailer object.
It checks if the client and message are not null,
then retrieves the client's email address and sends the message using the provided mailer.
*/


data class Client(val personalInfo: PersonalInfo?)
data class PersonalInfo(val email: String?)

interface Mailer {
	//an interface is a way to define a contract for classes.
	// It can contain abstract methods as well as implementations of methods.
	// Classes can implement multiple interfaces, allowing them to inherit behavior from multiple sources.
	fun sendMessage(email: String, message: String)
}

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer) {
    if (client != null && message != null) {
        val email = client.personalInfo?.email
        if (email != null) {
            mailer.sendMessage(email, message)
        }
    }
}

