import kotlin.math.abs

/*
Kotlin can assign default values to function parameters in the function declaration.
To invoke the function, you can either omit the arguments with default values or invoke it in the usual way.

Here is a function named printLine with two parameters.
The first parameter defines a line, the second parameter is a string that ends this line.
Both parameters have default values: an empty line ("") and a new line ("\n").
 */
fun printLine(line: String = "", end: String = "\n") = print("$line$end")
// main function invokes the printLine function
fun main() {
	printLine("Hello, Kotlin", "!!!") // prints "Hello, Kotlin!!!"
	printLine("Kotlin") // prints "Kotlin" with an ending newline
	printLine() // prints an empty line like println()
}

/*
During the first call, two arguments are passed to the function ("Hello, Kotlin" and "!!!").
During the second call, only one argument is passed ("Kotlin"), the value of the second parameter is default ("\n").
During the third call, we pass no arguments at all, but it still works because both parameters have default values.

The program outputs:
Hello, Kotlin!!!Kotlin

We cannot pass the second argument without the first one.
Kotlin cannot understand that we want to assign a value to the second parameter only.
 */

/*
Mixing default and regular arguments
You can also mix default and regular parameters during declaration.
For example, the function below finds the max of two integer arguments.
It has a special parameter that determines whether it needs to compare numbers by their absolute values.
The default value of this parameter is false.
 */

//The absolute value is the non-negative value of a number, effectively removing its negative sign, if present
fun findMax(n1: Int, n2: Int, absolute: Boolean = false): Int {
	val v1: Int
	val v2: Int

	if (absolute) {
		v1 = abs(n1)
		v2 = abs(n2)
	} else {
		v1 = n1
		v2 = n2
	}

	return if (v1 > v2) n1 else n2
}

fun max() {
	println(findMax(11, 15)) // 15
	println(findMax(11, 15, true)) // 15
	println(findMax(-4, -9)) // -4
	println(findMax(-4, -9, true)) // -9
}

/*
This code defines a function called findMax that takes three parameters:
n1, n2, and absolute. n1 and n2 are integers, and absolute is a boolean with a default value of false.
The function returns the maximum value between n1 and n2, or their absolute values if the absolute parameter is true.
In the main() function, the findMax function is called with different arguments, and the results are printed using println.
 */

/*
Idiom
Default function arguments are a part of the Kotlin idioms.
It's a good practice to add default arguments, they are useful when you write complex functions.
 */
fun foo(a: Int = 0, b: String = "") {
	println("a = $a, b = $b")
}


fun concatenate(word1: String, word2: String, word3: String, seperator: String = " "): String {
	return "$word1$seperator$word2$seperator$word3"
}

fun getVolume(length: Int, width: Int = 1, height: Int = 1): Int {
	return length * width * height
}

fun checkSpeed1(speed: Int, limit : Int = 60) {
	if (speed > limit) {
		var n = speed - limit
		println("Exceeds the limit by $n kilometers per hour")
	}else {
		println("Within the limit")
	}
}

fun checkSpeed(speed: Int, limit: Int = 60) {
	println(if (speed <= limit) "Within the limit" else "Exceeds the limit by ${speed - limit} kilometers per hour")
}