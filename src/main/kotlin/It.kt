/*
In Kotlin, "it" is a special keyword that is used as the default name for a single parameter in a lambda expression
when no explicit parameter name is provided.
It is particularly useful when working with higher-order functions such as map, filter, forEach, and others.

Here's an example of how "it" can be used in a lambda expression:

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // Using "it" in a lambda expression
    val squaredNumbers = numbers.map { it * it }

    println("Original numbers: $numbers")
    println("Squared numbers: $squaredNumbers")
}
In this example, the map function is used to transform each element of the numbers list by squaring it.
The lambda expression { it * it } uses "it" to represent the single parameter (each element of the list) and then squares it.

Using "it" can make the code more concise, especially when the lambda expression has only one parameter.
It is important to note that "it" can only be used when there is a single parameter in the lambda expression,
and if there are multiple parameters, explicit names must be used for clarity.

Overall, "it" simplifies the syntax when working with single-parameter lambda expressions in Kotlin.
 */

/*
val narrationModifier: (String) -> String = { message ->
	val numExclamationPoints = 3
	message.uppercase() + "!".repeat(numExclamationPoints)
}
 */

val narrationModifier: (String) -> String = {
	val numExclamationPoints = 3
	it.uppercase() + "!".repeat(numExclamationPoints)
}

//When defining lambdas that accept exactly one argument, the "it" identifier can be used instead of the parameter name.
//Both it and a named parameter cen be used when you have a single parameter in the lambda expression.

// it is great for shorter expressions
val square: (Int) -> Int = { it * it }
val uppercase: List<String> = "abc".map { it.uppercase() }
val count: Int = "Mississippi".count { it == 's' }
val doubles: Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3).mapValues { it.value * 2 }
//but it is not great for longer more complex expressions like nested lambdas because it is not clear what to do with the value

