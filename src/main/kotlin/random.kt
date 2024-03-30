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
/*
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


Types of random numbers
You can set some restrictions for your random number by choosing a specific type.
Everything you need for this purpose is located in the kotlin.random package.
Take a look at the code snippet below:

import kotlin.random.Random

fun main() {
    // generates an integer value between Int.MIN_VALUE and Int.MAX_VALUE (inclusive)
    println( Random.nextInt() )
    // generates a long value between Long.MIN_VALUE and Long.MAX_VALUE (inclusive).
    println( Random.nextLong() )
    // generates a float value between 0 (inclusive) and 1.0 (exclusive)
    println( Random.nextFloat() )
    // generates a double value between 0 (inclusive) and 1.0 (exclusive)
    println( Random.nextDouble() )
    // same thing one more time
    println( Random.nextDouble() )
}

The code generates a bunch of random numbers of the given types:

-1272462740
8641728355635965765
0.036410034
0.9411751338804492
0.2533641025032649

Notice that if you run it again, the numbers will be different, as you can see with the last two numbers.
Even though we called the same nextDouble() function, the numbers are not the same.
That is because the generator gives us a new number every time: they could repeat sometimes but the probability of that is very low.

Types of random numbers
You can set some restrictions for your random number by choosing a specific type. Everything you need for this purpose is located in the kotlin.random package. Take a look at the code snippet below:

import kotlin.random.Random

fun main() {
    // generates an integer value between Int.MIN_VALUE and Int.MAX_VALUE (inclusive)
    println( Random.nextInt() )
    // generates a long value between Long.MIN_VALUE and Long.MAX_VALUE (inclusive).
    println( Random.nextLong() )
    // generates a float value between 0 (inclusive) and 1.0 (exclusive)
    println( Random.nextFloat() )
    // generates a double value between 0 (inclusive) and 1.0 (exclusive)
    println( Random.nextDouble() )
    // same thing one more time
    println( Random.nextDouble() )
}

The code generates a bunch of random numbers of the given types:

-1272462740
8641728355635965765
0.036410034
0.9411751338804492
0.2533641025032649

Notice that if you run it again, the numbers will be different, as you can see with the last two numbers.
Even though we called the same nextDouble() function, the numbers are not the same.
That is because the generator gives us a new number every time: they could repeat sometimes but the probability of that is very low.

Custom ranges
As you can see, some numbers ended up pretty big, others small, and one is even negative.
The default ranges for integers and floating-point numbers are different and chosen to cover the most common cases.
But what if we needed only the integers between 0 and 100 or floats between 0.0 and 5.0? Then, we can specify them explicitly:

// generates a non-negative integer value less than 100
Random.nextInt(100)
// generates an integer value between 1 (inclusive) and 100 (exclusive)
Random.nextInt(1, 100)

// generates a non-negative long value less than 100
Random.nextLong(100)
// generates a long value between 1 (inclusive) and 100 (exclusive)
Random.nextLong(1, 100)

// generates a non-negative double value less than 5.0
Random.nextDouble(5.0)
// generates a double value between 0.0 (inclusive) and 5.0 (exclusive)
Random.nextDouble(0.0, 5.0)

Now we can be sure there will be no negative numbers, all integers will be less than 100, and some floats are greater than 1.0:

 36
 41
 12
 53
 0.00709856968715783
 2.8675389664207414

Notice that nextFloat is the only function that doesn't allow specifying the custom range:
nextDouble provides better precision, so we use that instead.

Custom ranges
As you can see, some numbers ended up pretty big, others small, and one is even negative. The default ranges for integers and floating-point numbers are different and chosen to cover the most common cases. But what if we needed only the integers between 0 and 100 or floats between 0.0 and 5.0? Then, we can specify them explicitly:

// generates a non-negative integer value less than 100
Random.nextInt(100)
// generates an integer value between 1 (inclusive) and 100 (exclusive)
Random.nextInt(1, 100)

// generates a non-negative long value less than 100
Random.nextLong(100)
// generates a long value between 1 (inclusive) and 100 (exclusive)
Random.nextLong(1, 100)

// generates a non-negative double value less than 5.0
Random.nextDouble(5.0)
// generates a double value between 0.0 (inclusive) and 5.0 (exclusive)
Random.nextDouble(0.0, 5.0)

Now we can be sure there will be no negative numbers, all integers will be less than 100, and some floats are greater than 1.0:

 36
 41
 12
 53
 0.00709856968715783
 2.8675389664207414

Notice that nextFloat is the only function that doesn't allow specifying the custom range:
nextDouble provides better precision, so we use that instead.

Pseudorandom numbers and seeding
So why are these functions called next[......] and not get[.....]?
Every time the function is called, it gives us the next number in a predefined sequence.
These numbers are called pseudorandom, and they are not completely unpredictable!
We can calculate them all if we know the initial value and the algorithm of the sequence.
That initial value is called a seed. The seed itself is never returned by a next[......] function but it defines all the subsequent numbers.

It is guaranteed that the same seed produces the same sequence if the same Kotlin runtime version is used because the algorithm is the same.
This can be useful to reliably test code that uses random generators.

Let's generate five pseudorandom numbers from the sequence with the seed 42:

val randomGenerator42 = Random(42) // the generator takes the seed
for (i in 0..5) {
    randomGenerator42.nextInt(100)
}

In Kotlin 1.4, this code will always generate the same six numbers — 33, 40, 41, 2, 41, 32 — even on different machines.
In contrast, the default generator will give us a new sequence every time.

// the same generator we use when we call Random.nextInt(), Random.nextFloat() etc.
val defaultGenerator = Random.Default
for (i in 0..5) {
    defaultGenerator.nextInt(100)
}

To work with pseudorandom data, we need to decide whether we need a predictable result or not.
In the first case, we can use a known seed, and in the second case, we can generate a seed based on the system time
or simply use the default implementation.
Remember that random sequences are only guaranteed to be the same if they are generated with the same version of Kotlin runtime,
but they can be different in different Kotlin versions or different programming languages even for the same seed.
*/

/*
Roll the dice
Let's play a game. We'll write a program that simulates rolling a six-sided dice. Players roll it over and over again and it produces numbers from 1 to 6 in an almost unpredictable way.

Your task is to write a function that returns a random integer value in the interval [1, 6] each time it's called.

Tip: Use lower and upper bounds to set the proper range for a dice value.
 */
import kotlin.random.Random

fun throwD6(): Int {
	val numberOnTheDice = Random.nextInt(1, 7)
	return numberOnTheDice
}

/*
RPG dices
The tabletop role-playing games usually use multiple dice with various number of faces. Most often the RPG dice have 4, 6, 8, 12 and 20 sides.

Let’s consider an RPG game where all decisions are made by throwing 2 dice with different number of faces.
Create the rpgDices function that gets as arguments the number of the faces of 2 dice and returns the sum of the result of rolling both of them.
 */

fun rpgDices(dice1: Int, dice2: Int): Int {
	val sumOfDices = Random.nextInt(1,dice1 + 1 ) + Random.nextInt(1,dice2 + 1)
	return sumOfDices
}

/*
Predictable "random" password
Let's say we are trying to establish encrypted communication with our friend.
For this, we will use a secret seed that we agreed on, then generate a 10-character long password and prompt our friend for the same password.
If it is indeed our friend, the words will match.

Write a function that takes a known seed and generates a string of exactly 10 random printable characters (codes between 33 and 126 inclusive) using this seed.
Use the .toChar() function to convert a random number to a character and join all the characters into a single string.

Tip: Make sure to call the Random constructor only once and reuse the same instance to generate all the numbers.

Tip: Note that code 33 and 126 both need to be included.

val randomGenerator42 = Random(42) // the generator takes the seed
for (i in 0..5) {
    randomGenerator42.nextInt(100)
}
 */

/*
fun generatePredictablePassword(seed: Int): String {
	var randomPassword = ""
	val randomGenerator = Random(seed)
	for (i in 0..9) {
		randomPassword += randomGenerator.nextInt(33, 127).toChar()
	}
	return randomPassword
}

fun main() {
	println(generatePredictablePassword(66))
}


/*
Rock, paper, scissors
Let's play a game. We'll write a program that simulates rock, paper and scissors.
 */

fun makeDecision(): String {
	return when (Random.nextInt(1, 4)) {
		1 -> "Rock"
		2 -> "Paper"
		else -> "Scissors"
	}
}

 */