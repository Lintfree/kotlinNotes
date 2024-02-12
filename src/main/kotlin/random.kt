/*
1. The random function
How can you generate a word? For example,
you can specify a possible alphabet
(a list of characters that can be used in the word) and randomly select the characters the desired number of times.

To do that, you can use a special function, random, which works with a list (or with a string,
which, as we have already found out, can be represented as a list):

// Return any single symbol from the string "ABCD"
"ABCD".random()
2. How to create a new list with random elements
To get a list of random elements, you need to create a list with the desired number of elements,
specifying in a lambda expression (the condition) how each element will be generated:

// Create a list with 5 elements, each of them is 6
List(5) { 6 }
// Create a list with 5 elements, each of them is 'A'
List(5) { 'A' }
// Create a list with 5 elements, each of them is a random symbol from the string "ABCD"
List(5) { "ABCD".random() }

We have already learned how to generate a list of random letters, but we need to work with strings.
To join a list of elements into a string, you can use the joinToString function,
passing the separator — a character (or string) that will be used to separate the elements — as an argument.:

// The separator is "; ", the resulting string is: "6; 6; 6; 6; 6"
List(5) { 6 }.joinToString("; ")
// The default separator is ", ", the resulting string is: "A, A, A, A, A"
List(5) { 'A' }.joinToString()
 */

fun main() {
	val wordLength = 5
	val alphabet = "ABCD"
	val secret = generateSecret(wordLength, alphabet)
	println(secret)
}

fun generateSecret(wordLength: Int, alphabet: String) : String {
	val secret = alphabet.toMutableList()
	while (secret.size < wordLength) {
		secret.add(alphabet.random())
	}
	return secret.toString()
}

fun isCorrectInput(userInput: String, wordLength: Int, alphabet: String): Any {
	return when (userInput) {
		(userInput.length != wordLength).toString() -> "The word should be of length $wordLength"

		!in alphabet -> "The word should contain only letters from $alphabet"
		else -> userInput
		}
	}
