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




 */