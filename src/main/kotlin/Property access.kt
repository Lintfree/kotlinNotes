/*
Property getter
Suppose you have a simple class Client with one property name:

class Client {
    val name = "Unknown"
}

val client = Client()
You already know how to retrieve a property name: just type in the dot and the property name after the object name:

client.name
This looks very simple, but in fact, when you want to get the value of some property, you call a special get() function called getter.
This is what it actually looks like:

class Client {
    val name = "Unknown"
        get() {
            return field
        }
}

// or with omitted curly brackets and the body of the get() function

class Client {
    val name = "Unknown"
        get() = field
}
This function takes nothing (you only ask a value, nothing more) and returns one value.
When you try to retrieve a value, you will get the result of the get() function.
So, what is field?
Every property in Kotlin has its own backing field, which contains a property value that can be accessed with the special keyword field.

In this case, your getter just returns the value of the name variable.
This is the expected behavior, so Kotlin generates this function for us, and you don't need to write it.
If you want to change the logic of the getter, you should write your own get() function.

Sometimes you want to do something that does not fit into this implicit backing field scheme, you can always fall back to having a backing property.
For example, we can use it to have a mutable value to save the info, and always return a read only val.

class IntegerRepository {
    private val _list = mutableListOf<Int>()
    val list: List<Int> get() = _list // backing property
}

fun main() {
    val repository = IntegerRepository()
    repository.list.add(1) // Error: variable list is a read-only collection
    println(repository.list)
}

Custom getter
Let's print the customer's name every time we access name:

class Client {
    val name = "Unknown"
        get() {
            println("Somebody wants to know $field name")
            return field
        }
}

val client = Client()

val name = client.name // prints Somebody wants to know Unknown name
println(name)          // prints Unknown

Another use for a custom getter is if you want to return something else.
For example, your task could be to store complete customer information in a variable.
If you change some information about one person, you will have to change this variable as well.
If you are using a custom getter, you can generate information on-demand.
In the example below, the Client class gets an age property that stores the age of the client, and info property that returns the information about them:

class Client {
    var name: String = "Unknown"
    var age: Int = 18
    val info: String
        get() {
            return "name = $name, age = $age"
        }
}

val client = Client()
println(client.info) // name = Unknown, age = 18
client.name = "Lester"
client.age = 20
println(client.info) // name = Lester, age = 20

Property setter
Now you know that you can customize the process of getting the property's value.
It is also possible to modify the process of changing the property's value!
Let's take a look at a simple example:

class Client {
    var name = "Unknown" // default value
}

val client = Client()
client.name = "Ann"      // name property now stores "Ann"
When you want to set the value of some property, you should call a special set() function called setter.
This is what it looks like:

class Client {
    var name = "Unknown"
        set(value) {
            field = value
        }
}
This function takes one argument (it is named value by convention, but you can use a different name) and returns nothing.
As you know, field contains the current value of the property and you can change it by reassigning a different value.

In this case, your setter will simply change the value of the name variable to the received value.
This is the expected behavior and Kotlin generates this function for us, you don't need to write the setter yourself.

Custom setter
The set() function is a powerful instrument, and it's possible to customize the logic of a setter.
For example, let's print the customer's name every time we change the name property:

class Client {
    var name = "Unknown"
        set(value) {
            println("The name is changing. Old value is $field. New value is $value.")
            field = value
        }
}

val client = Client()
client.name = "Ann"   // The name is changing. Old value is Unknown. New value is Ann.
As you may notice, the setter is only called when you're trying to change the property, not when initializing it.

Another way to use a custom setter is if you wanted to assign a different value.
Let's add an age property that stores the age of the client. Of course, age cannot be negative.
If you want to take it into account, you can add a custom setter:

class Client {
    var name = "Unknown"
    var age = 18
        set(value) {
            field = if (value < 0) {
                println("Age cannot be negative. Set to $defaultAge")
                defaultAge
            } else
                value
        }
    val defaultAge = 18
}

val client = Client()
client.age = -1      // Age cannot be negative. Set to 18.
println(client.age)  // 18

Additional features
You may implement both a setter and a getter for your property:

class Client {
    var name = "Unknown"
        get() {
            println("Somebody wants to know $field name")
            return field
        }
        set(value) {
            println("The name is changing. Old value is $field. New value is $value.")
            field = value
        }
}
If you want to add a getter and/or a setter to a property in a constructor, just "move" the property out.
Remember that in this case, you need to use another variable, not the property from the constructor:


class Client(name: String, age: Int) {
    var fullName: String = name
        set(value) {
            println("The name is changing. Old value is $field. New value is $value.")
            field = value
        }
    var age: Int = age   // this is a new property, not a property from the constructor
        set(value) {
            println("The age is changing. Old value is $field. New value is $value.")
            field = value
        }
}
Keep in mind that when initializing your property, the setter will not be called.
This is also true for constructors since they initialize properties. Let's take a closer look:


class Client(name: String) {
    var name: String = name
        set(value) {
            println("The name is changing. Old value is $field. New value is $value.")
            field = value
        }
}

val client = Client("Annie")  // without output
client.name = "Ann"           // The name is changing. Old value is Annie. New value is Ann.
You cannot use a setter for val variables: the set() function reassigns the variable, which is not possible for val.
Of course, you can change the internal state of the val property another way, for example, with its own setters.


class Passport(number: String) {
    var number = number
    set(value) {
        println("Passport number has changed.")
        field = value
    }
}

class Client {
    val passport = Passport("1234567")
}

val client = Client()
println(client.passport.number)       // 1234567

client.passport = Passport("2345678") // This will not work.

client.passport.number = "2345678"    // This will change the passport number
                                      // prints Passport number has changed
println(client.passport.number)       // 2345678
 */

/*
What will be the output of the code below?

fun main() {
    val smartOne = Smartphone("Ericsong")
    smartOne.price = -24
    val smartTwo = Smartphone("iNokhe")
    print(smartTwo.price - smartOne.price)
}

class Smartphone(val name: String) {
    var price: Int = -5
        get() = name.length - field
}

Starting with the definition of the class, it has a default setter( that is not visible in code), when we do
smartOne.price = -24 the value of price must change to -24 (just keep that in your mind)
Now when we crate a car for the first time, the value of price is always -5 at the beginning. (remember this also)

The tricky thing is the get() function, the get is used when we need the value of a field.
the default getter is usually always present but invisible to us, but in this case, we are using a custom getter.
The custom getter allows us to run some code while asking for the value of a field.

If the class was
class Smartphone(val name: String) {
    var price: Int = -5
}
here print(smartOne.price) prints -5
But with
class Smartphone(val name: String) {
    var price: Int = -5
        get() = name.length - field
}
a print(smartOne.price) produces something else, because here when we ask the value of price we execute the code of get()
So smartOne.price executes get() and return the value of name.length - field ("field" is the reference to the field "price")
so for a newly created object smartOne.price  is name.length - field or name.length - (-5)
But when we do  smartOne.price = -24
name.length - field is not name.length - (-5) but name.length - (-24)

And so on for the next steps,
just remember that in this case, when you need the value of the field "price" you call the get() function and return the result of it's execution.

fun main() {
	val smartOne = Smartphone("Ericsong")
	smartOne.price = -24 //-24-8 = -32
	val smartTwo = Smartphone("iNokhe") // iNokhe has a price of -5-6=-11
	print(smartTwo.price - smartOne.price)  // -32-11 = -21  difference in price
}


class Smartphone(val name: String) {
	var price: Int = -5
		get() = name.length - field
}

City population
Imagine we want to implement the City class which stores the name of the city and its population.

There are some restrictions.
If the number is out of range, the population is corrected like this: zero for negative values and 50 million for greater than 50_000_000.

Finish the implementation of the City class following this logic.
*/

/*
class City(val name: String) {
    var population: Int = 0
		get() = if (field < 0) 0 else if (field > 50_000_000) 50_000_000 else field
		set(value) {
			if (value < 0) field = 0
			else if (value > 50_000_000) field = 50_000_000
			else field = value
		}
}
*/

data class City(val name: String) {
	var population: Int = 0
		set(value) {
			field = value.coerceIn(0, 50_000_000)
		}
}
