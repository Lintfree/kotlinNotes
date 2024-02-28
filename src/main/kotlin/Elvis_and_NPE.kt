/*
Elvis operator
If the value on the left side of the ?: operator is null, the value on the right side of the ?: operator is returned.

For example, if value is null, then 0 is returned, otherwise value is returned.

For example,

val value: Int? = null
val result = value ?: 0

println(result)

// Output
0


opposite of elvis operator is the !! operator
which returns the value on the right side of the expression,
even if the value on the left side is null or undefined, and it will throw an exception.

For example,

val value: Int? = null
val result = value!!

println(result)

// Output
java.lang.NullPointerException

It should be noted that the !! operator is not the same as the elvis operator:
It should not be used to check if a value is null and should be avoided.


Nullability
There are just a few ways how NPE may occur in Kotlin:

explicit call of throw NullPointerException() ;

!! syntax;

bad initializations, such as constructors and superclass constructors.

Remember that you don't have to pay as much attention to NPE as in Java and that you can concentrate on real tasks.
Don't forget that Kotlin is a pragmatic language. So, what do we have?

First of all, every reference in Kotlin can be either nullable or not.
Let's say we want to define a String variable, but we are not sure what it might be initially:

var name: String = null
So, what is null above?
It just means that the name variable doesn't have a certain value.
This code won't compile because we declared a non-null variable. How can we fix it? Pretty easy:

var name: String? = null
As you can see, we just added a ? sign right after the type of our variable.
We marked our name variable as nullable. We can also do the same with other types, like Int or Long:

var age: Int? = null
So, without a ? sign in the type you can't assign null to a variable.

Accessing nullable variables
Now try to guess what happens if you try to access this variable property:

var name: String? = null
print(name.length)
If you think there will be an error, you're right!
This code won't even compile. What can we do, then? Of course, we can add a common check for null like this:

if (name != null) {
    print(name.length)
}
If the name is null, the print won't be called.

Or we can access the length this way:

print(name?.length)
Here null is printed.

This ?. pair of symbols is called a safe call in Kotlin.

types are non-nullable by default. If you attempt to assign or return null to a non-nullable variable, the compiler will give an error:

var name: String = "Kotlin"
name = null // Compiler error
To permit a variable to carry a null value, you must declare it as nullable by adding a ? to its type:

var name: String? = "Kotlin"
name = null // This is fine
Kotlin offers several mechanisms to deal with nullable types securely:

Safe Calls (?.): This allows you to perform operations on a nullable object only if it's not null.
val length = name?.length // length is null if name is null

Elvis Operator (?:): It furnishes a default value if the expression to the left is null.
val length = name?.length ?: 0 // length is 0 if name is null

Non-Null Assertion (!!): Transforms a nullable type to a non-nullable type, throwing an exception if the value is null.
val length = name!!.length // Throws NullPointerException if name is null
Safe Casting (as?): Safely casts to a type and returns null if the casting isn't possible.

val x: Any = "Kotlin"
val y: String? = x as? String // y is safely cast to String or null

Understanding Nullable Types in Kotlin
Kotlin seeks to eliminate the dreaded NullPointerException from our code by introducing a clear distinction between nullable and non-nullable types.

Non-Nullable Types: By default, variables in Kotlin are non-nullable.
If you try to assign or return null in a non-nullable variable, the compiler will give an error.

var name: String = "Kotlin"
name = null // Compiler error

Nullable Types: To declare a variable that can hold a null value, you append a question mark ? to the type.
var name: String? = "Kotlin"
name = null // This is fine

When you work with nullable types, Kotlin requires you to handle the possibility of null values explicitly,
thereby making your code safer and more predictable.

Safe Calls (?.): Kotlin provides the safe call operator
that allows you to access properties or call methods on nullable variables without risking a NullPointerException.
val length = name?.length // length is null if name is null

Elvis Operator (?:): The Elvis operator allows you to provide a default value if the expression to the left is null.
val length = name?.length ?: 0 // length is 0 if name is null

Non-null Assertion (!!): If you're absolutely certain a nullable reference isn't null,
you can use the non-null assertion operator to throw an exception if the value turns out to be null.
val length = name!!.length // Throws NullPointerException if name is null

Separated between nullable and non-nullable types,
Kotlin provides a sturdy mechanism for managing null, making your code less vulnerable to NullPointerExceptions.

Safe Calls (?.)
Safe calls allow you to access properties and methods of nullable objects without risk of a NullPointerException.
When you use a safe call, Kotlin checks for null before performing the operation.
If the object is null, it will return null instead of casting an exception.

Here's how to use a safe call:

val name: String? = person?.name
If person is not null, name will be assigned the value of person.name. If person is null, name will be null.

The Elvis Operator (?:)
The Elvis operator lets you provide an alternative value in case the expression to its left is null.
This is particularly handy for delivering default values or resorting to a safe operation.

Here's an example of using the Elvis operator:

val name: String = person?.name ?: "Unknown"
In this case, if person isn't null and person.name isn't null, name will be given the value of person.name.
If either person or person.name is null, name will receive the value "Unknown".

The !! Operator in Kotlin: Use With Caution
Kotlin, designed to eradicate the NullPointerException from your code, introduces features that ensure null safety.
However, the !! operator is an exception that reintroduces the potential for such errors.
It forcefully casts a nullable type to a non-null type.

val name: String? = null
val nonNullName: String = name!! // Throws NullPointerException
The !! operator asserts that the value is non-null, and if it's actually null, a NullPointerException is cast immediately.
This is contrary to Kotlin's philosophy of null safety and should be used sparingly.

Why Overuse is Problematic:
Defeats Null Safety: Kotlin's type system is designed to handle nulls gracefully. Overusing !! bypasses these safety measures.

Code Smell: Regular use often indicates a disregard for proper null checks and can lead to code that's less stable and more challenging to maintain.

Unexpected Crashes: It can cause your application to crash unexpectedly if proper null checks are not done before using !!.

Safer Alternatives:
Safe Calls (?.): Returns the value if it's non-null; otherwise, returns null.
val length = name?.length // Safe call, length will be null if name is null

Elvis Operator (?:): Delivers a default value if the expression to the left is null.
val length = name?.length ?: 0 // If name is null, length will be 0

Safe Casting (as?): Safely casts to the given type or returns null if the cast isn't possible.
val nullableInt: Int? = something as? Int

Let Function: Executes a block of code if the variable is not null.
name?.let {
    println("Name is $it")
}

In conclusion, the !! operator should be your last option.

Best Practices for Null Safety in Kotlin
Kotlin's type system is designed to eliminate the danger of null references from the code,
also known as the billion-dollar mistake. Here are some best practices to enforce null safety:

Use Nullable Types Wisely: Only use nullable types (Type?) when a variable can indeed be null.
If a variable should not be null, use a non-nullable type.

Safe Calls (?.): Use the safe call operator when accessing properties or methods on a nullable object.
This will return null if the object is null instead of throwing a NullPointerException.
val length = nullableString?.length

Elvis Operator (?:): The Elvis operator lets you to offer an alternative value if an expression evaluates to null.
val length = nullableString?.length ?: 0


Non-Null Assertion (!!): Use this operator only when you are certain that the value is not null.
It will throw a NullPointerException if the value is null.
val length = nullableString!!.length

Use let for Null Checks: The let function can be used to execute block of code only if the variable is not null.
nullableString?.let {
    // Code here will only run if nullableString is not null
}

Use apply for Configuration: Use apply on a nullable object to configure it if it's not null.
nullableObject?.apply {
    // Configure object here
}

Use takeIf and takeUnless: These functions are useful for conditional checks that return null if the condition is not met.
val positiveNumber = input.takeIf { it > 0 }
val notBlankString = input.takeUnless { it.isBlank() }

Design APIs for Null Safety: When designing APIs, use default parameters and provide non-null types.
This encourages API consumers to think about nullability and reduces chances of NullPointerException.

fun process(input: String = "") { /*...*/ }
 */

//Try to read a line. If there is no line, throw an IllegalStateException(). If there is a line, output Elvis says: $line.
//
//Use the ?: throw construction to solve this task.
//
//
//Sample Input:
//hairstyle
//
//Sample Output:
//Elvis says: hairstyle

//fun main() {
	//val line: String = readlnOrNull().takeIf { it != "" } ?: throw IllegalStateException()
	//println("Elvis says: $line")
	//readLine()?.let { println("Elvis says: $it") } ?: throw IllegalStateException()
//}

import java.util.Scanner    // required import

fun main(args: Array<String>) {
	val input = Scanner(System.`in`)  // Scanner for user input

	val str = "Learning Kotlin"   // Given constant string
	val lengthOfSubstring: Int    // Variable to store the given number (length of substring)

	// TODO: Use Scanner to get integer input and assign it to lengthOfSubstring
	lengthOfSubstring = input.nextInt()

	// TODO: Implement null safety and check if the given number is bigger than the length of the string
	// If it is, print 'Out of range'. Else, print a substring from the constant string starting from
	// the beginning which is as long as the lengthOfSubstring suggests.

	if (lengthOfSubstring > str.length) {
		println("Out of range")
	} else {
		println(str.substring(0, lengthOfSubstring))
	}
}