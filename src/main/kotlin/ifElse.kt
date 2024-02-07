/*
There are different forms of conditional expressions,
such as the single if case, if-else cases, if-else-if cases, and nested if's.
 */

/*
Kotlin's if is an expression, not a statement.
This means it can return a value as a result of computations. The result must be the last expression in the body.
 */


/*

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

	val number3 = readln().toInt()
	when {
		number3 < 0 -> println("Negative number")
		number3 in 1..10 -> println("Number between 1 and 10")
		number3 % 2 == 0 -> println("Even number")
		else -> println("Odd number greater than 10")
	}

	// input 3 variables

	val f = readln().toInt()
	val g = readln().toInt()
	val h = readln().toInt()

	// a = hours needed to sleep
	//b = no more than b hours
	//h = hours slept today

	if (h in f..g) {
		println("Normal")
	} else if (h < f) {
		println("Deficiency")
	} else {
		println("Excess")
	}

	// hyperskill problem wanted how many ifs, correct but better if a when statement
	val name = readln()
	if (name == "Emily") {
		println("sister")
		} else if (name == "Luke") {
			println("brother")
		} else if (name == "James") {
		println("father")
		} else {
		println("mother")
		}

	// good example of use of if && ||
	val leapyear : Int = readln().toInt()
	if (leapyear % 4 == 0 && leapyear % 100 != 0 || leapyear % 400 == 0) {
		println("Leap")
	} else {
		println("Regular")
	}
}
*/
/*
3 use case examples of if

The conditional operator as an expression: variables
In Kotlin, the if expression can be also assigned to a variable or be a returned value in a function;
in such a case, the last operator in each branch will be returned:
*/

val max1 = if (x > y) {
	println(x)
	// if x > y return x
	x
} else {
	// The opposite condition: x <= y
	println(y)
	// if x <= y return y
	y
}

/*
For input x = 5 and y = 15, the result will be max = 15; and otherwise, if x = 20 and y = 15, the result will be max = 20.

The conditional operator as an expression: functions
It is the same with functions:
*/

fun max2(x: Int, y: Int) = if (x > y) {
	println(x)
	// if x > y return x
	x
} else {
	// The opposite condition: x <= y
	println(y)
	// if x <= y return y
	y
}
//Or, in the full notation:

fun max3(x: Int, y: Int): Int {
	return if (x > y) {
		println(x)
		// if x > y return x
		x
	} else {
		// The opposite condition: x <= y
		println(y)
		// if x <= y return y
		y
	}
}

