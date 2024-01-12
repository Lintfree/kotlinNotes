fun main() {
	val (var1, op, var2) = readln().split(" ")

	val a = var1.toInt()
	val b = var2.toInt()
	// if op is one of these it will perform the corresponding action
	when (op) {
		"+" -> println(a + b)
		"-" -> println(a - b)
		"*" -> println(a * b)
		else -> println("Unknown operator")
	}
	/*
		When can also return a result.
		In this case, every branch should return something, and an else branch is required.
		In the code example below, every branch returns a result of the corresponding operation.
		 */

	val result = when (op) {
		"+" -> a + b
		"-" -> a - b
		"*" -> a * b
		else -> "Unknown operator"
	}
	println(result)


	/*You don't need to declare an additional variable and can immediately pass the result to a function.
	Use this notation if you do not need to use the result somewhere else or when you keep your code short.
	 */
	println(
		when (op) {
			"+" -> a + b
			"-" -> a - b
			"*" -> a * b
			else -> "Unknown operator"
		}
	)


	/*
	When can also be used to check for equality.
	In this example, the branch with the value "==" is executed.
	 */
	when (op) {
		"==" -> println(a == b)
		else -> println("Unknown operator")
	}

	/*
	The program below reads three integer numbers a, b, and c, and then tries to determine how to calculate c using a and b.
	If there are many ways to calculate c, it will print only the first one:
	 */
	val (var3, var4, var5) = readln().split(" ")

	val d = var3.toInt()
	val e = var4.toInt()
	val f = var5.toInt()

	println(
		when (f) {
			d + e -> "$f equals $d plus $e"
			d - e -> "$f equals $d minus $e"
			d * e -> "$f equals $d times $e"
			else -> "We do not know how to calculate $f"
		}
	)
	/*
	if input values are 5 3 2 the program outputs 2 equals 5 minus 3.
	If input values are 0 0 0, it outputs 0 equals 0 plus 0.
	 */

	//Another interesting possibility is to check whether a value belongs to a range.
	val n = readln().toInt()
	when (n) {
		0 -> println("n is zero")
		in 1..10 -> println("n is between 1 and 10 (inclusive)")
		in 25..30 -> println("n is between 25 and 30 (inclusive)")
		else -> println("n is outside a range")
		//You can also combine ranges with a comma just like single values.
		//in 1..10, in 25..30 -> println("n belongs to a range")
	}

	/*
	You can use a when expression without arguments.
	In this case, every branch condition is a simple boolean expression, and a branch is executed when its condition is true.
	If several conditions are true, only the first one will be executed.
	 */
	val m = readln().toInt()

	when {
		m == 0 -> println("n is zero")
		m in 100..200 -> println("n is between 100 and 200")
		m > 300 -> println("n is greater than 300")
		m < 0 -> println("n is negative")
		// else-branch is optional here
		//Every branch condition is a boolean expression that may include any operations producing booleans.
		else -> println("n is positive")
	}

	/*
	when used as if or else if
	It's comparable to...:
	if (x == 10 || x == 11) println("a")
	else if (x == 11 || x == 12) println("b")

	... in opposite to:
	if (x == 10 || x == 11) println("a")
	if (x == 11 || x == 12) println("b")
	 */

	val x = 11
	when (x) {
		10, 11 -> println("a")
		11, 12 -> println("b")
	}

	fun checkNumber(number: Int): String {
		return when (number) {

			in 1..10 -> "Number is in range 1 to 10"
			in 11..20 -> "Number is in range 11 to 20"

			else -> "Number is outside the range 1 to 20"
		}

	}

	//fun main() {
		print(when (readln().toInt()) {
			0, 1, 2, 3, 5, 8, 13, 21, 34, 55 -> "F"
			0, 1, 3, 6, 10, 15, 21, 28, 36, 45 -> "T"
			1, 10, 100, 1000, 10_000, 100_000 -> "P"
			else -> "N"
		})
	//same as above
	//fun main() {
		val n1 = readLine()!!.toInt()
		val f1 = arrayOf( 0, 1, 2, 3, 5, 8, 13, 21, 34, 55)
		val t = arrayOf( 0, 1, 3, 6, 10, 15, 21, 28, 36, 45)
		val p = arrayOf (1, 10, 100, 1000, 10000, 100000)

		if (n1 in f1) println("F")
		else if (n1 in t) println("T")
		else if (n1 in p) println("P")
		else println("N")
	}


