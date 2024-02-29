/*
Static Typing
Kotlin's static typing assures that the types of variables are known at compile time, optimising performance and improving clarity.
For instance:

val message: String = "Hello, Kotlin!"
In the above code snippet, message is clearly declared as a String. This clarity helps to prevent type-related errors.

Advantages of Kotlin's Type System
Null Safety: Kotlin's type system is tailored to get rid of the dreaded NullPointerException common in many Java programs.
It differentiates between nullable and non-nullable types.

var a: String = "abc"
//a = null // Compile error

var b: String? = "abc"
b = null // OK

Smart Casts: Kotlin smartly manages type casting, reducing the need for explicit casts.

if (obj is String) {
	// obj is automatically cast to String in this scope
	println(obj.length)
}
Type Inference: Kotlin has efficient type inference capabilities, indicating you don't always need to state the type clearly.

val language = "Kotlin" // Type inferred as String
val length = language.length // Type inferred as Int

Extension Functions: You can extend existing types with new functionality without inheriting from the type.

fun String.addExclamation() = this + "!"

println("Hello".addExclamation()) // Output: Hello!

Basic Types in Kotlin
Kotlin has an extensive type system that includes various basic types.
These function as the building blocks for data manipulation within the language.
Here's a short introduction to some fundamental types:

Int: Represents a 32-bit signed integer. It can range from a minimum value of -2,147,483,648 to a maximum value of 2,147,483,647.
val age: Int = 30

Double: A 64-bit double-precision floating-point number. It's perfect for representing numbers with fractional parts.
val pi: Double = 3.141592653589793

Char: Represents a single 16-bit Unicode character and is enclosed in single quotes.
val firstLetter: Char = 'A'

Boolean: Represents a truth value, which can either be true or false.
val isKotlinFun: Boolean = true

In Kotlin, these fundamental types are represented as objects, unlike Java's primitive types.
However, Kotlin's compiler optimizes managing these types to be as efficient as Java primitives whenever possible.
This optimisation process is called 'autoboxing'.
Kotlin also supports explicit type conversions as it does not perform implicit type conversions (widening conversions) for numbers.
This means you need to manually convert types if you wish to assign a value of one type to a variable of another:

val i: Int = 42
val d: Double = i.toDouble() // explicit conversion

val d: Double = 42.0
val i: Int = d.toInt() // explicit conversion

Kotlin also provides a special type called Unit, which represents the absence of a value.
It is used to indicate that a function doesn't return anything.

fun printSum(a: Int, b: Int): Unit {
	println(a + b)
}

 */