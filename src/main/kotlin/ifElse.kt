/*
There are different forms of conditional expressions,
such as the single if case, if-else cases, if-else-if cases, and nested if's.
 */

/*
Kotlin's if is an expression, not a statement.
This means it can return a value as a result of computations. The result must be the last expression in the body.
 */




private fun main() {
	val a = readln().toInt()
	val b = readln().toInt()
	//below is called idiom
	val max = if (a > b) a else b //maybe could modify to print out like answers below

	println(if (a == b) {
		"a equal b"
	} else if (a > b) {
		"a is greater than b"
	} else {
		"a is less than b"
	})
	println(max) // same as above but shorter using variable val

	//When
	val number = 5
	when (number) {
		1 -> println("One")
		2 -> println("Two")
		3 -> println("Three")
		4 -> println("Four")
		else -> println("Number is greater than four")
	}

	val number2 = 3
	val message = when (number2) {
		1 -> "One"
		2 -> "Two"
		3 -> "Three"
		4 -> "Four"
		else -> "Number is greater than four"
	}
	println(message) // Output: Three

	//when expressions can also be used with ranges and more complex conditions.
	val number3 = 15
	when {
		number3 < 0 -> println("Negative number")
		number3 in 1..10 -> println("Number between 1 and 10")
		number3 % 2 == 0 -> println("Even number")
		else -> println("Odd number greater than 10")
	}
}


