import java.util.*

/*
To use the simplest loop, write repeat(n) and a sequence of statements in curly braces {...}.
n is an integer that determines how many times these statements are going to be repeated.
If n is zero or a negative number, Kotlin will ignore the loop.
 */
fun main() {
	repeat(3) {
		println("Hello")
	}

	repeat(3) {
		println(it) // This 'it' variable will be set to the index of the current iteration, starting from 0.
	} //The code in curly braces is commonly called a "lambda expression".
	// It's a function that doesn't have a name and is passed immediately as an expression.

	//You can read data from the standard input,
	// declare variables and even perform calculations inside the repeat statement.
	// This code reads a length of a number sequence and assigns it to the n variable.
	// After that, it creates a variable to store the total sum.
	// The code reads the next number and adds it to the sum exactly n times.
	// Then, the loop stops, and the program prints the total sum.
	val n = readln().toInt()
	var sum = 0

	repeat(n) {
		val next = readln().toInt()
		sum += next
	}

	println(sum)

	//There are several ways to repeat a block of code while a certain condition is true.
	//while and do...while.
	//The difference between them is the repetition order and the evaluation of the condition.

	/*
	The while loop includes a block of code and a condition, which is a boolean expression.
	If the condition is true, the loop initiates the statements.
	They are repeated until the condition becomes false.
	This loop checks the condition before the execution, so it is also known as a pre-test loop.
	 */
	var i = 0
	while (i < 5) {
		println(i)
		i++
	}
	println("Completed")

	var letter = 'A'
	while (letter <= 'Z') {
		print(letter)
		letter++
	}

	val scanner = Scanner(System.`in`)
	while (scanner.hasNext()) {    //hasNext checks whether an input has a value
		val next = scanner.next()
		println(next)
	}

	/*
	input
	Hello Scott

	output
	Hello
	Scott
	 */

	/*
	Use scanner.hasNext() for strings and scanner.hasNextInt() for integers
	when you do not know the size of your input data.
	 */

	/*
	The do...while loop is similar to the while loop,
	but the difference is that the condition is checked after the execution of the statements.
	This loop is also known as a post-test loop.
	In contrast with the while loop, which tests the condition before the execution,
	the do..while loop is an exit-condition loop. So, the body is always executed at least once.
	 */

	do {
		val dw = readln().toInt()
		println(dw)
	} while (dw > 0)

	//be careful as The do...while loop can also be infinite just like the while loop.
	//In practice, programmers do not use do..while as often as while.
	// A good example of using this loop is a program that reads data from the standard input
	//until a user enters a certain number or a string.


	var o = readln().toInt()
	while (o > 1) {
		print(n)
		if (o % 2 == 0) {
			o /= 2
		}
		else {
			o = o * 3 + 1
		}
		print(" ")
	}
	print(o)

	//concated
	var p = readln().toInt()
	while (p!= 1) {
		print(p)
		print(" ")
		p = if (p % 2 == 0) p / 2 else p * 3 + 1
	}
	print(p)


	//repeat
	val reps = readln().toInt()
	var j = 1
	var numOfReps = 0
	// prints out like this 1 2 2 3 3 with the input limiting the amout printed out
	do {
		repeat(j) {
			if (numOfReps < reps)
				print("$j ")
			numOfReps++
		}
		j++
	}while (numOfReps < reps)

	/*
	this worked also but came back as incorrect in Hyperskill
	for (i in 0..reps) {
		repeat(i) {
			if (numOfReps < reps && i < reps)
			print("$i ")
		numOfReps++
	}
}
*/

	//finds max of input
	var max  = 1
	do {
		val input = readln().toInt()
		if (input > max) {
			max = input
		}
	} while (input != 0)
	println(max)

	//finds sum of input

	var add = 0
	do {
		val input = readln().toInt()
		add += input
	}
	while (input != 0)
	println(add)
}






