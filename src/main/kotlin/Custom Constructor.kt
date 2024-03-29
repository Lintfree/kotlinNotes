/*
Primary constructors have their limitations.
For example, you may need to create several different constructors for the same class,
but you can't do that with a primary constructor alone.
That's where secondary, or custom, constructors come in handy.

Custom constructor
You can declare custom constructors for a class along with a primary constructor or without one.

To declare a secondary constructor,
write the keyword constructor inside the class body and parentheses with the constructor's parameters
after the keyword.
Then, put curly braces with the constructor logic inside:

class Size {
    var width: Int = 0
    var height: Int = 0

    constructor(_width: Int, _height: Int) {
        width = _width
        height = _height
    }
}
Now you can create objects in one line, just as if you were using a primary constructor:

val size1 = Size(3, 4)
val size2 = Size(5, 1)
Be careful: you have to either use an implicit constructor or declare your own,
but you cannot use both at the same time:

class Size {
    var width: Int = 0
    var height: Int = 0

    constructor(_width: Int, _height: Int) {
        width = _width
        height = _height
    }
}

val size = Size() // Error! No values passed for parameters _width and _height
What you can do is create a replica of the default constructor explicitly
(empty curly braces can be removed):

// preferable solution
class Size() {
    var width: Int = 0
    var height: Int = 0
}

// or this way

class Size {
    var width: Int = 0
    var height: Int = 0

    constructor() {
    }
}

Multiple constructors
Creating several constructors for a class is almost as simple as creating just one,
but there is a particular constraint you need to keep in mind.
Every secondary constructor has to have a unique signature.
You cannot use the same signature for the primary or any other constructor.

The constructor signature consists of the number, the types, and the order of the parameters.
To create a valid constructor, you need to make sure it has a unique list of parameters.
As an example, look at the following constructors for the class Size:

class Size {
    var width: Int = 0
    var height: Int = 0

    constructor(_height: Int) {
        height = _height
    }

    constructor(_width: Int, _height: Int) {
        width = _width
        height = _height
    }

    constructor(_width: Int, _height: Double) {
        width = _width
        height = _height.toInt()
    }

    constructor(_height: Double, _width: Int) {
        width = _width
        height = _height.toInt()
    }
}
The code below will create four Size objects with the same property values using different constructors:

val size1 = Size(7) // uses 1st constructor
val size2 = Size(0,7) // uses 2nd constructor
val size3 = Size(0, 7.0) // uses 3rd constructor
val size4 = Size(7.0, 0) // uses 4th constructor
Remember that signatures are defined by the types of the parameters, not by their names.
For example, the compiler can not tell these two constructors apart,
even if they look different for a person:

constructor(width: Int, height: Int) {}
constructor(x: Int, y: Int) {}
So, implemented in the same class, these constructors will cause an error.

this keyword
Inside the class code,
you can also access the object members using a special keyword this that represents the current object.

For example, you can use it to name the constructor parameters the same as the class properties.
Let's change the class Size:

class Size {
    var width: Int = 0
    var height: Int = 0

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }
}
In the code above, you will get an error without the keyword this,
since the names will be interpreted as the immutable constructor parameters and not the class members.

Omitting default values
As you remember, if a property value is assigned in the constructor,
you don't have to provide a default value:

class Size (var width: Int, var height: Int) {
    // whatever you want
}
This is also true for the secondary constructor.
Let's change var to val in the Size class, so the properties cannot be reassigned.
For the sake of demonstration,
let's add another property area that will be calculated based on the constructor parameters:

class Size {
    val width: Int
    val height: Int
    val area: Int

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
        this.area = width * height
    }
}
It looks like a reassignment, but you are just initializing the values, so nothing wrong.

Note that you cannot use the val and var keywords in the secondary constructor.

class Size {
    constructor(val width: Int, val height: Int) { // error, val is not allowed
    }
}

Constructors delegation
If a class has a primary constructor, each secondary constructor needs to call the primary one,
either directly or indirectly through another secondary constructor(s). This is called delegation.

Delegation to another constructor of the same class is done with the keyword
this placed after the constructor arguments and before the constructor body:

class Size(val width: Int, val height: Int) {
    var area: Int = width * height

    constructor(width: Int, height: Int, outerSize: Size) : this(width, height) {
        outerSize.area -= this.area
        println("Updated outer object's area is equal to ${outerSize.area}")
    }
}
Delegation to the primary constructor becomes the first statement of a secondary constructor,
so the properties are initialized before the secondary constructor code is executed.
Initializer blocks, if present, are also executed before the secondary constructor.
If a class has no primary constructor, the delegation happens implicitly.

Constructor execution
Let's look at the example and see in which order the class code is executed:

class Size(val width: Int, val height: Int) {
    var area: Int = width * height

    init {
        println("Object with area equal to $area is created")
    }

    constructor(width: Int, height: Int, outerSize: Size) : this(width, height) {
        outerSize.area -= this.area
        println("Updated outer object's area is equal to ${outerSize.area}")
    }
}

fun main() {
    val outerObject = Size(5, 8)
    val innerObject = Size(2, 3, outerObject)
}
When creating outerObject, the primary constructor is directly called,
the properties are initialized and the init block is executed.
In case of innerObject, the secondary constructor first calls the primary,
the properties initialization and the initialization block happen, and finally,
the secondary constructor code is executed.

It results in the following output:

Object with area equal to 40 is created
Object with area equal to 6 is created
Updated outer object's area is equal to 34

Let's review the key points from the topic before you can move on to practice.

A class can also declare secondary constructors. They have to be prefixed with the keyword constructor.

Each constructor within the same class must have a unique signature.

Object members inside the class code can be accessed with this keyword.

Default values can be omitted if property values are assigned in the constructor.

The code in the initializer blocks effectively becomes part of the primary constructor.

Secondary constructor code is executed after the primary constructor,
initializer blocks, and property initialization.
 */

class Kitty {
	var color: String = ""
	var age: Int = 0

	constructor(color: String) {
		this.color = color
	}

	constructor(age: Int) {
		this.age = age
	}

	constructor(age: Int, color: String) {
		this.age = age
		this.color = color
	}

	constructor(color: String, age: Int) {
		this.color = color
		this.age = age
	}
}

class Fabric(var color: String) {
	var pattern: String = ""
	var patternColor: String = ""
	init {
		println("$color fabric is created")
	}

	constructor(color: String, pattern: String, patternColor: String) : this(color) {
		this.pattern = pattern
		this.patternColor = patternColor
		println("$patternColor $pattern pattern is printed on the fabric")
	}
}

/*
You are to calculate the cost of coffee for a machine that uses both capsules and beans.
Write the class EspressoMachine with the property costPerServing of theFloat type.
Objects of the class can be created with two secondary constructors.

The first constructor takes two arguments: coffeeCapsulesCount (of Int type) and totalCost (of Float type).
The value of the property costPerServing is calculated as the cost of one coffee capsule.

The second constructor takes two arguments: coffeeBeansWeight and totalCost, both of the type Float.
Calculating the cost of one serving, take into account that each cup of coffee requires 10 weight units of coffee beans.
Using the given coffeeBeansWeight and the totalCost of coffee beans, calculate costPerServing.

Write a program in Kotlin
 */

class EspressoMachine {
	var costPerServing: Float = 0f


	constructor(coffeeCapsulesCount: Int, totalCost: Float) {
		costPerServing = totalCost / coffeeCapsulesCount
	}

	constructor(coffeeBeansWeight: Float, totalCost: Float) {
		costPerServing = totalCost / (coffeeBeansWeight / 10)
	}
}

/*
class EspressoMachine {

    val costPerServing: Float

    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
        costPerServing = totalCost / coffeeCapsulesCount
    }

    constructor(coffeeBeansWeight: Float, totalCost: Float) : this((coffeeBeansWeight / 10).toInt(), totalCost)

    //don't understand this line of code
    // how is it working?
    This line of code is using a secondary constructor in Kotlin.
    It is calling the primary constructor with the expression (coffeeBeansWeight / 10).toInt()
    as the first argument and totalCost as the second argument.
    The expression (coffeeBeansWeight / 10).toInt()
    is evaluating the weight of coffee beans in tenths of the original weight
    and then converting it to an integer.
    This value is then passed to the primary constructor along with the totalCost.
}
 */

/*
Write the class IceCreamOrder that has one Int property: price. The class must have two secondary constructors.

The first one takes one Int argument: popsicles, which signifies the number of popsicles the customer wants.
The price is calculated as 7 currency units per popsicle.

The second constructor takes two Int arguments: scoops and toppings,
which signifies the number of ice cream scoops and the number of different toppings that the customer wants in the order.
The price is calculated as 5 currency units per scoop plus 2 currency units per topping.
 */

class IceCreamOrder {

	var price: Int = 0

	constructor(popsicles: Int) {
		price = 7 * popsicles
	}

	constructor(scoops: Int, toppings: Int) {
		price = 5 * scoops + 2 * toppings
	}
}

/*
Given a class named Box. It has three double properties.

Write a member function to calculate the volume of the box.
The function must be named as getVolume. It should take no arguments and return a double result.
 */

class Box(var height: Double, var width: Double, var length: Double) {

	fun getVolume(): Double {
		return height * width * length
	}
}