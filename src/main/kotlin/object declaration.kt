/*
Singleton
Singleton is a design pattern that ensures that a class has only one instance with global access to it.
This means we can get an instance of a singleton class anywhere in the code.
Consider a simple analogy: when playing a board game, all players act within the field of the game.
This is a specific single field where the global state of the game is stored.

Before we move forward, let's quickly remind ourselves of the main singleton features:

Singleton class has only a single instance.

Singleton class provides a global access point.

Object declaration
Singleton is a really useful pattern, and Kotlin provides a specific structure to declare singletons: object declaration.
This is a special class with an object keyword that creates a singleton.
This keyword hides all complicated steps so you don't have to think about the ways to implement this pattern: just use object declaration.

Let's take a look at this example:

object PlayingField {

    fun getAllPlayers(): Array<Player> {
        /* ... */
    }

    fun isPlayerInGame(player: Player): Boolean {
        /* ... */
    }

}

When you use object declaration, the constructor is not available because Kotlin does it itself.
To get an instance of our playing field, use PlayingField declaration. We can use it anywhere and it will return the same object every time.

fun startNewGameTurn() {
    val players = PlayingField.getAllPlayers()
    if (players.size < 2) {
        return println("The game cannot be continued without players")
    }
    for (player in players) {
        nextPlayerTurn(player)
    }
}

fun nextPlayerTurn(player: Player) {
    if (!PlayingField.isPlayerInGame(player)) {
        return println("Current player lost. Next...")
    }
    /* Player actions here */
}

Nested object
Often you need to create a singleton that is somehow related to another class.
For example, you create a Player class to store information about different characters in the game.
All these characters can share some characteristics, for example, speed. How would we store such information?
 */

/*
Of course, you may use an object declaration and create something like that:

object PlayerProperties {
    // Default player speed in playing field – 7 cells per turn
    val defaultSpeed = 7

    fun calcMovePenalty(cell: Int): Int {
        /* calc move speed penalty */
    }
}

However, there can be many classes and related singletons, which makes the code confusing and difficult to read.
Another way to store this information is by using a nested object.

Object declaration can be nested in a class declaration.
A nested class is created inside another class; it cannot be accessed without an outer class declaration.

class OuterClass {
   //outer class code
    class NestedClass {
      //nested class code
    }
}

Now, let's take a closer look at a nested object construction:

class Player(val id: Int) {
    object Properties {
        /* Default player speed in playing field – 7 cells per turn */
        val defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {
            /* calc move speed penalty */
        }
    }
}

/* prints 7 */
println(Player.Properties.defaultSpeed)

The object Properties has the scope Player, which means we can access it only through Player.Properties.
That's how you can create a singleton connected to a special class.

You can also use properties and functions from a nested object in the outer class.
This can be useful for storing some data common to all instances of a class and for initializing variables. For example:

class Player(val id: Int) {
    object Properties {
        val defaultSpeed = 7
    }

    val superSpeed = Properties.defaultSpeed * 2 // 14
}

The opposite is not true. You cannot use the properties and the functions of the outer class in the inner.
For example, you cannot do something like that:

class Player(val id: Int) {
    val speed = 7
    object Properties {
        val defaultSpeed = speed // you cannot get this variable
    }
}

As you can see, it's similar to static in the other languages. Kotlin doesn't provide static members by default, but you may use nested objects if you need something related to the class.
 */

/*
Compile-time constants
As you know, sometimes it is necessary to use values in your code that will never change.
We call them constant values.
So, if you know that some read-only property that belongs to your object is a constant, you can declare it as const:

object Languages {
	const val FAVORITE_LANGUAGE = "Kotlin"

	// ...
}

The values of such constants are already known at compile time, so they are called compile-time constants.
Note that the constant must meet the following requirements:
firstly, it must be initialized with a value of type String or a basic type (Int, Double, etc.).
Also, it cannot be a custom getter. And remember that constants should be named using the SCREAMING_SNAKE_CASE.

By the way, if we know that the defaultSpeed property in the game is a constant, then we can make changes to the examples above as follows:

object Properties {
	/* Constant default player speed */
	const val DEFAULT_SPEED = 7

	// ...
}

You can access this property from outside the object like this:

object Properties {
	/* Constant default player speed */
	const val DEFAULT_SPEED = 7

	// ...
}

fun main() {
	println(Properties.DEFAULT_SPEED) // 7

	// ...
}

You might wonder: why not just declare all constants as top-level? Why do we need to declare them in an object?

Generally speaking, both approaches may make sense depending on the situation.
The fact is that careless use of top-level properties reduces the readability and organization of the code and,
as a result, leads to unpleasant errors.
If you declare all the constants at the top of the file, then eventually,
you may realize that in one place you have hundreds of declarations that are not related to each other.
Therefore, if a constant refers to a specific object, it is better to declare it in that object.

It is better to declare constants in the object to which they relate.
*/

/*
Objects and nested objects
Let's discuss additional features. Sometimes you want to create more than one singleton associated with a class.
You can declare any number of objects inside another class:

class Player(val id: Int) {
	object Properties {
		/* Default player speed in playing field – 7 cells per turn */
		val defaultSpeed = 7

		fun calcMovePenalty(cell: Int): Int {
			/* calc move speed penalty */
		}
	}

	/* creates a new instance of Player */
	object Factory {
		fun create(playerId: Int): Player {
			return Player(playerId)
		}
	}
}

/* prints 7 */
println(Player.Properties.defaultSpeed)


/* prints 13 */
println(Player.Factory.create(13).id)

In this example, we've created an additional singleton that can create a new instance of the class.
This pattern is called Factory and can be really useful for complex cases.
You can read about this pattern here. The usual way to use this pattern is through nested objects.

Another useful feature of nested objects is that you can declare any number of objects inside another object.

object Game {
	object Properties {
		val maxPlayersCount = 13
		val maxGameDurationInSec = 2400
	}

	object Info {
		val name = "My super game"
	}
}

This is helpful for organizing the data in the singletons.

 */

/*
Data objects
When printing a plain object declaration in Kotlin, the string representation contains both its name and the hash of the object.

object MyObject

fun main() {
	println(MyObject) // MyObject@1f32e575
}

Just like data classes, you can mark an object declaration with the data modifier.
This instructs the compiler to generate a number of functions for your object:

	toString() returns the name of the data object
equals()/hashCode() pair
data object MySingleton

fun main() {
	println(MySingleton) // MySingleton
}

You should not confuse this functionality with what already exists in data classes.
A data object declaration is intended to be used as singleton objects, no copy() function is generated.
The singleton pattern restricts the instantiation of a class to a single instance,
which would be violated by allowing copies of the instance to be created.
Unlike a data class, a data object does not have any data properties.
Since attempting to destructure such an object without data properties would not make sense, no componentN() functions are generated.

 */

/*
Object declaration
Idiom
As you can see, the singleton is a powerful tool.
In many languages, you would have to write such a class yourself, but Kotlin recommends using object declaration as a standard solution.

object Resource {
	val name = "Name"
}

Also, we can configure properties of an object using the scope function apply.

val myRectangle = Rectangle().apply {
	length = 4
	breadth = 5
	color = 0xFAFAFA
}

Summary
Object declaration is a useful feature.
Mainly, we can use the object keyword to create singletons.
Another use of object declaration is nested objects.
It is an easy way to create a structure that is associated with the entire class rather than a single instance.
If you use it wisely and correctly, you can improve your programming experience and make your code more readable.
 */


/*
object Me
	val CURRENT_AGE = 18
	val EYES_COLOR = "green"
	val HEIGHT = 188

fun main() {
	println(Me)
	println(CURRENT_AGE)
	println(EYES_COLOR)
	println(HEIGHT)
}

 */

/*
Cell
You have a class Cell with a nested object BaseProperties.
This nested object contains two properties height and width.
However, the dimensions of a cell may be different from the default ones,
so you need to create its own height and width with the default values from the singleton BaseProperties.
 */

/*
class Cell {
	val height = BaseProperties.height
	val width = BaseProperties.width
	object BaseProperties {
		var width = 10
		var height = 10
	}
}

object PlayingField {
	object Size {
		var width: Int = 0
		var height: Int = 0
	}
	fun changeSize(newWidth: Int, newHeight: Int) {
		Size.width = newWidth
		Size.height = newHeight
	}
}

object PlayingField {
	object Size {
		var width: Int = 0
		var height: Int = 0
	}
	fun changeSize(newWidth: Int, newHeight: Int) {
		Size.width = newWidth
		Size.height = newHeight
	}
}

/*create a simple equivalent of the Math library with one function for calculating modules.

You need to add two abs functions in the Math singleton.
One of these functions should receive an Int value, while the other works with Double.
These functions must return the absolute value of the obtained variable.
 */


object Math {
    fun abs(x: Int): Int{
		if(x < 0)
			return -x
		else
			return x
	}
	fun abs(x: Double): Double{
		if(x < 0)
			return -x
		else
			return x
	}
}
*/