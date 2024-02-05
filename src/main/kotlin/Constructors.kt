/*
In Kotlin, constructors are special functions used to set up new instances of a class.
They are responsible for establishing the initial state of an object when it's created.
Kotlin provides two kinds of constructors: primary and secondary.
Purpose of Constructors
Constructors in Kotlin aim to:

Initialize properties with values passed to the constructor.

Carry out any initialization logic the class might need.

Kotlin's clean syntax and support for default parameter values often help reduce the need for multiple constructors,
leading to more clear and manageable code.

Primary Constructor
The primary constructor is part of the class header and is declared after the class name:
class Person(val name: String, var age: Int)
Characteristics of the primary constructor:

It's streamlined and cannot contain any code.
Initialization code can be placed in initializer blocks, prefixed with init.

class Person(val name: String, var age: Int) {
    init {
        println("New person instance created: $name, $age")
    }
}

Secondary Constructor
Secondary constructors are defined inside the class body using the constructor keyword:

class Person {
    val name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}
Characteristics of secondary constructors:

They are used when you need multiple methods to initialize your class.

They must delegate to the primary constructor (if it exists)
either directly or indirectly through another secondary constructor.

class Person(val name: String, var age: Int) {
    constructor(name: String) : this(name, 0) {
        println("Secondary constructor called")
    }
}
Secondary constructors are handy when you need more intricate initialization
that can't be covered by the primary constructor.
Or when you need to initialize properties in a different order than the primary constructor.

Primary Constructor and Initialization Blocks in Kotlin

In Kotlin, the primary constructor is part of the class header and is declared after the class name.
It can have parameters which can be used for initializing the class properties directly or within an init block.

Here's how to define a primary constructor:

class Person(val name: String, var age: Int) {
    // Class body
}
In the above example, the Person class has a primary constructor with two parameters, name and age.
The val and var keywords indicate that name and age are properties of the class.

For more complex setup needs, Kotlin provides init blocks.
These blocks run in the order they appear in the class body, interleaved with property initializers:

class Person(val name: String, var age: Int) {
    init {
        require(age > 0) { "Age must be positive" }
    }
}
In this case, the init block contains a check to confirm the age is positive.
If the requirement is not met, an IllegalArgumentException will be thrown.

Remember, if you have multiple init blocks, they are executed in order:

class Person(val name: String, var age: Int) {
    init {
        println("First initializer block")
    }

    // Property initializer
    val isAdult = age >= 18

    init {
        println("Second initializer block with isAdult: $isAdult")
    }
}
The primary constructor cannot contain any code.
Initialization code should be placed in init blocks or directly in property initializers.

Secondary Constructors in Kotlin
Kotlin allows for the definition of one primary constructor and one or more secondary constructors in a class.
Secondary constructors are less streamlined than the primary constructor and are defined with the constructor keyword.

Secondary constructors provide additional ways to set up an object when the primary constructor isn't enough
or when you need to perform extra initialization steps.

Here's how to create a secondary constructor:

class Person(val name: String) {
    var age: Int

    // Primary constructor
    init {
        age = 0
    }

    // Secondary constructor
    constructor(name: String, age: Int): this(name) {
        this.age = age
    }
}
In the example above,
the secondary constructor takes two parameters and delegates to the primary constructor using this(name).
After the primary constructor has been called, the secondary constructor body is executed,
allowing for additional initialization, such as setting the age property.

Secondary constructors must always delegate to the primary constructor, directly or indirectly,
to ensure that initialization of the base class is completed before the secondary constructor's body is executed.
 */

/*
There is this class:

class Site(val address: String, val foundationYear: Int)
Implement the makeReddit() function that returns a Site with the reddit.com address and the foundation year of 2005.

Write a program in Kotlin

 */

class Site(val address: String, val foundationYear: Int)
fun makeReddit(): Site = Site("reddit.com", 2005)

//the above make reddit function refers to the site class and assigns the address and foundation year

//Write a class Pet that has three String properties declared in the primary constructor: name, animal, and owner.
//
//The default value for animal should be "cat".
//
//Write a program in Kotlin
class Pet(val name: String, val animal: String = "cat", val owner: String)

//There is a program that reads a number.
// If the number is less than -128, then the property time of a ByteTimer class must be -128.
// If it's greater than 127, then it must be 127, otherwise, it must be its raw value.
//
//Fix the ByteTimer class.

fun main() {
	val timerValue = readLine()!!.toInt()
	val timer = ByteTimer(timerValue)
	println(timer.time)
}

class ByteTimer(var time: Int) {
	init {
		if (time < -128) {
			time = -128
		} else if (time > 127) {
			time = 127
		}

	}
}