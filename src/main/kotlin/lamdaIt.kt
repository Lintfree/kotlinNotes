/*
https://kotlinlang.org/docs/lambdas.html#lambda-expression-syntax
1. Lambda expressions
Often built-in functions that work with collections accept lambda expressions. We will talk about them in detail later,
but currently it is enough to know that:

they offer a special way to tell built-in functions what they should do with each element from the collection;
they have a special syntax.
Consider the following example that traverses a word and keeps only the A symbols:

var result = ""
for (symbol in "ABCDDD") {
	if (symbol == 'A') {
		result += symbol
	}
}
We used the already familiar constructions like for and if, but it can also be rewritten via built-in functions and lambda expressions:

// Keep only A symbol
"ABCDDD".filter { symbol: Char -> symbol == 'A' }
In this case, we are using a lambda expression (a condition),
which will be applied to each element of the collection via the built-in function filter.
The lambda expression takes one parameter Char (character) and compares it with the character A (for characters we need to use single quotes).

The -> sign indicates the end of the left part of the lambda expression with the arguments.
The right part of the lambda expression (after ->) says what exactly we should do: e.g., compare the symbol with 'A'.

2. Different ways to work with arguments in lambda expressions
In the previous example, we used the full form for the lambda expression arguments: the name and type of the argument.
If the type of the argument is clear from the context (as it usually is with collections), then the type can be omitted:

"ABCDDD".filter { symbol -> symbol == 'A' }
Also, if you need only one argument, then this argument already has a built-in name it, and in this case it can also be omitted:

"ABCDDD".filter { it == 'A' }

Kotlin has many built-in functions: e.g.,
we can filter and manipulate with not only the elements from the list but also list indices.
For example, given two words, we need to build a new word,
which consists of the characters that occur in both words at the same positions.

The classic way is:
val secondWord = "AACAAA"
var result = ""
for ((index, symbol) in "ABCDDD".withIndex()) {
   if (secondWord[index] == symbol) {
      result += symbol
   }
}
// The result will be: "AC"
But we can also use the filterIndexed function to make code shorter:

val secondWord = "AACAAA"
// The result will be: "AC"
"ABCDDD".filterIndexed { index, symbol -> secondWord[index] == symbol }
By the way, in this case, the lambda expression takes two arguments, so we use custom names for the arguments (index and symbol), not it.

 Indices
For example, we can use the indices function to iterate over the indices of the list:
val numbers = listOf(10, 20, 30, 40, 50)
for (i in numbers.indices) {
    println("Index $i: ${numbers[i]}")
}
// Index 0: 10
// Index 1: 20
// Index 2: 30
// Index 3: 40
// Index 4: 50
 */

/*
Lamdas or Anonymous Functions in Kotlin are functions without a name.
They are used to pass functions as arguments to other functions.

Syntax:
val someLamda: (Int, Int) -> Int = { a, b -> a + b }
or
"Missippi".count({letter -> letter =='s'})

project NyetHack has some examples

val narrationModifier: (String) -> String = {  //  -> String is the return type
	val numExclamationPoints = 3
	message.uppercase() + "!".repeat(numExclamationPoints)
}
Unlike regular functions, the return type is inferred from the last expression of the lambda.
It also allows us to omit the return keyword.

Multiple arguments
val loudNarration: (String, String) -> String = { message, tone ->
 	when (tone) {
 		"excited" -> {
 			val numExclamationPoints = 3
 			message.uppercase() + "!".repeat(numExclamationPoints)
 		}
 		"sneaky" -> {
 			"$message. The narrator has just blown Madrigal's cover.".uppercase()
 		} else-> message.uppercase()
 	}
 }

 println(loudNarration("Madrigal cautiously tip-toes through the hallway", "sneaky"))
//MADRIGAL CAUTIOUSLY TIP-TOES THROUGH THE HALLWAY. THE NARRATOR HAS JUST BLOWN MADRIGAL'S COVER.

Unlike regular functions, lambdas cannot have default arguments.
The function type is the only information Kotlin retains about the lambda, and it is not posssible to include default arguments.
Named arguments are also not supported in lambdas.


Functions without names
To create a Kotlin function that isn't bound to its name, you can use either an anonymous function or a lambda expression:

fun(arguments): ReturnType { body } – this is commonly called an "anonymous function".

{ arguments -> body } – this is commonly called a "lambda expression".

To better understand it, take a look at the example below. Here, two functions are declared: they are declared in different ways, but they do the same thing:

fun(a: Int, b: Int): Int {
    return a * b
} // normal function but no name

{ a: Int, b: Int -> a * b } // we shifted the parameter or argument in the curly braces
As you see, they compute the multiplication of two numbers.

Both these functions have a reasonable type: (Int, Int) -> Int. So, types work here just the way they do for top-level functions discussed in previous topics.

Note that if you want to declare a lambda without arguments, you do not need to write the "arrow symbols".
A lambda without argument definition looks like this: { body }.

You may ask: how can we use a function without a known name? The answer is: there are several options.

For example, you can assign the function to a variable and then invoke it by invoking the variable:

val mul1 = fun(a: Int, b: Int): Int {
    return a * b
}

val mul2 = { a: Int, b: Int -> a * b }

println(mul1(2, 3))  // prints "6"
println(mul2(2, 3))  // prints "6" too
Also, you can pass such a function as an argument or return such a function from another function.

Finally, you can place parentheses with desired arguments right after the function definition to invoke it in place.
However, that doesn't make much sense. So, mostly the first three described options are used.

The process of creating these two functions is quite similar, but lambdas have a more concise and convenient syntax.
Therefore, lambdas are almost always used to create a function at runtime in real life.
Moreover, there are programmers who don't stick to Kotlin official naming rules and can say "an anonymous function" instead of "a lambda".
Despite the fact that everybody understands them, we suggest that you use the proper naming.

Lambdas and syntactic sugar
There are ways to make code more readable for human beings without changing the code logic.
If there is such a way in a programming language and it relates to syntax, we call it syntactic sugar.
Kotlin promotes Functional Programming so there is syntactic sugar for it.

Let's recall this example of passing a function as an argument:

fun isNotDot(c: Char): Boolean = c != '.'
val originalText = "I don't know... what to say..."
val textWithoutDots = originalText.filter(::isNotDot)
println(textWithoutDots) // I don't know what to say
Simply put, we have created the function isNotDot, which returns Boolean and then uses originalText.filter,
which will iterate over every char in the string, apply the isNotDot function, and then return a string without any dots.
The filter excludes any char in the string that returns false.

Just in case, there is a specific topic for filtering elements in collection.

Now, let's rewrite it to pass a lambda:

val originalText = "I don't know... what to say..."
val textWithoutDots = originalText.filter({ c: Char -> c != '.' })
println(textWithoutDots) // I don't know what to say
It works! First of all, we don't need to specify a function and then take reference from it.

Kotlin infers types of many objects, and here specifying the c type isn't necessary:

originalText.filter({ c -> c != '.' })
Second, there are situations when the lambda is passed as the last argument.
In such a case, Kotlin provides a way to eliminate bracket sequences ({ }) and write the lambda outside the parentheses:

originalText.filter() { c -> c != '.' }
If the parentheses are left empty after that operation, you can remove them:

originalText.filter { c -> c != '.' }
Please note that sometimes function reference is more readable than a lambda,
and there is no right answer which one is preferable.
However, if the code is quite complex, instead of copy-pasting some lambda,
it may be better to use function reference for easier maintenance and reusability.

Implicit name of a single parameter: it
Finally, when there is a single parameter in a lambda, there is an opportunity to skip it.
The parameter is available under the it name.
The type of it is inferred from the type of the argument being passed to the lambda.
The final version of the code that removes dots is this:

val originalText = "I don't know... what to say..."
val textWithoutDots = originalText.filter { it != '.' }
Pretty impressive, huh?

Returning from a lambda expression in Kotlin is achieved using return@label, where label is a tag,
usually matching the name of the higher-order function in the context of which the lambda was called.
For example, when using someLambda as a lambda expression in a higher-order function, the return from the lambda would look like return@someLambda.

This is particularly useful in cases where the lambda is used in functions such as forEach, map, let, and so on.
Returning with return@label allows for exiting the lambda expression without interrupting the execution of the outer function.

Here is an example of using return@label in Kotlin:

listOf(1, 2, 3, 4).forEach {
    if (it == 3) return@forEach  // Skipping number 3
    println(it)
}
println("End")
In this example, when it equals 3, the lambda expression is interrupted and continues with the next iteration of the forEach loop.
The println("End") will execute after the loop completes.

 */

//Write a lambda expression that calculates a⋅x2+b⋅x+c
//, where a, b, c are variables and x is the lambda parameter. The lambda is to have the (Int) -> Int type.
//val a = 1
//val b = 2
//val c = 3
//val lambda: (Int) -> Int = { x -> a * x * x + b * x + c }
// or
// val lambda = { x -> a * it * it + b * it + c }

//Suppose you have an originalPredicate: (Char) -> Boolean predicate.
//It is necessary to complete the declaration of the notPredicate predicate; the predicate takes the Char variable.
//
//The notPredicate predicate returns the opposite of the originalPredicate.

//val originalPredicate: (Char) -> Boolean = { it != '.' }

//val notPredicate: (Char) -> Boolean = { it -> !originalPredicate(it) }

/*
val lambda: (Int, Int) -> Int = { a, b ->
	if (a > b) a
	else b
}
 or
val lambda: (Int, Int) -> Int = ::maxOf  // :: refers to the maxOf function based on Int, Int -> Int
 */

/*
fun fizzbuzz(from: Int, to: Int, transformation: (Int) -> String) {
	for (number in from..to) {
		println(transformation(number))
	}
}

fun main() {
	fizzbuzz(1, 100) { number ->
		if (number % 15 == 0) {
			return@fizzbuzz "fizzbuzz"
		}
		if (number % 3 == 0) {
			return@fizzbuzz "fizz"
		}
		if (number % 5 == 0) {
			return@fizzbuzz "buzz"
		}
		return@fizzbuzz number.toString()
	}
}

fun compose(g: (Int) -> Int, h: (Int) -> Int): (Int) -> Int {
	return { it -> g(h(it)) }
}

 */

/*
Write a lambda expression that accepts two long arguments as range borders
and returns the multiplication of all the numbers in this range (inclusively).
Guaranteed that 0 <= left border <= right border. If left border == right border then the result is any border.

Note that you don't need to write in one line, you can use loops.
 */


val lambda: (Long, Long) -> Long = { left, right ->
	var result = 1L
	for (i in left..right) {
		result *= i
	}
	result
}



// use reduce from kotlin.collections
//val lambda: (Long, Long) -> Long = { left, right -> left * right }

fun main() {
	println(lambda(1, 10))
}