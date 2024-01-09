/*
Functional decomposition is a process in software development where a complex system is broken down into simpler,
easier-to-manage components, also known as functions or modules.
This method is essential for understanding, maintaining, and improving software by separating functionalities;
this encourages code reuse and testing.
*/
/*
Basic principles of functional decomposition in Kotlin
This method is in line with Kotlin's support for the functional programming style. Here are some fundamental concepts:

Pure Functions: The result of a pure function only depends on its input values and has no noticeable side effects.
This predictability makes it simpler to understand what the function will do.
*/
fun add(a: Int, b: Int): Int {
    return a + b // Pure function
}

/*
Immutability: Once created, immutable data can't be altered.
This prevents issues with shared states and makes concurrent environments less risky.
*/
val list = listOf(1, 2, 3) // Immutable list
/*

Higher-Order Functions: Kotlin functions can take other functions as parameters or return functions, making the code more modular and reusable.
*/
fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b) // Higher-order function usage
}
val sum = applyOperation(2, 3, ::add) // Passes ::add as a parameter
 //println(sum)

/*
Monads
Monads are structures that wrap computation logic.
In Kotlin, the Result type is a monad that can hold a value or an exception.
Monads let you link operations together while handling errors smoothly.
*/
//val result: Result<Int> = Result.runCatching { someRiskyOperation() }
//result.map { value -> doSomethingWith(value) }

/*
Functors
Functors are structures that can be mapped over, much like a List in Kotlin.
They apply a function to wrapped values without changing the actual structure.

val numbers = listOf(1, 2, 3)
val squared = numbers.map { it * it } // Functor usage

In this code, a list of numbers [1, 2, 3] is created using the listOf function.
Then, the map function is called on the numbers list, and a lambda expression { it * it } is passed as an argument.

The lambda expression { it * it } is an example of a shorthand notation for a lambda function in Kotlin.
The it keyword refers to the current element being processed by the map function.
In this case, it represents each number in the numbers list one at a time.

The map function applies the lambda expression to each element in the numbers list and returns a new list [1, 4, 9],
where each element is the square of the corresponding element in the numbers list.\
So, the squared variable will contain the list [1, 4, 9].
 */

/*
Tail Recursion
Tail Recursion is a pattern where a function calls itself at the end of its operation,
allowing the compiler to optimize the call stack. Kotlin supports tail recursion with the tailrec modifier.

tailrec fun factorial(n: Int, acc: Int = 1): Int {
    return if (n == 1) acc else factorial(n - 1, n * acc)
}

// Usage
println(factorial(5)) // 120
The factorial function is a mathematical function that calculates the product of an integer and all the positive integers below it.
It is denoted by the exclamation mark (!). For example, 5! is equal to 5 * 4 * 3 * 2 * 1, which is 120.

The function takes two parameters:
n (the number for which the factorial is calculated) and acc (the accumulator that stores the intermediate result).
The default value of acc is 1.
The function uses a ternary operator (if-else) to check if n is equal to 1.
If it is, the function returns the value of acc, which is the final result.
Otherwise, it recursively calls itself with n - 1 as the new value of n and n * acc as the new value of acc.
 */

fun greet(name: String) = "Hello, $name!"
fun getFeeling(feeling: String) = when (feeling) {

		"happy" -> "You seem very cheerful today!"
		"sad" -> "I hope your day gets better."
	else -> "It's a great day!"
}

fun main() {
	val name = "John"
	val greeting = greet(name)
	val feeling = getFeeling("happy")
		println("$greeting $feeling")
}