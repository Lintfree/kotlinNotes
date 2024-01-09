//in is a special keyword that is used to check whether a value is within a range
fun main() {
	val x = 10
	val y = 9
	if (x in 1..y + 1) {
		println("fits in range")
	}

	//Also, we have an open-ended range:
	// a..<b is a range of numbers from a until b (excluding the border value, b).
	println(5 in 5..15)  // true
	println(12 in 5..15) // true
	println(15 in 5..15) // true
	println(20 in 5..15) // false
	println(5 in 5..<15)  // true
	println(15 in 5..<15) // false

	//If you need to exclude the right border,
	// you may subtract 1 from it or use ..< to get the open-ended range (the recommended way).
	val withinExclRight = c in a..<b // a <= c && c < b (the recommended way)


	//If you need to check that a value is not within a range, just add ! (not) before in.
	val notWithin = 100 !in 10..99 // true

	//You may combine ranges using standard logical operators.
	// The code below checks if c is within one of three ranges.
	val within = c in 5..10 || c in 20..30 || c in 40..50 // true if c is within at least one range

	//You can assign a range to a variable and use it later.
	val range = 100..200
	println(300 in range) // false

	//In addition to integer ranges,
	// you can also use ranges of characters and even strings (according to dictionary order).
	println('b' in 'a'..'c') // true
	println('k' in 'a'..'e') // false

	println("hello" in "he".."hi") // true
	println("abc" in "aab".."aac") // false

	//fun main() { ranges expressed when entered by user
		val a = readln().toInt()..readln().toInt()
		val b = readln().toInt()..readln().toInt()
		val c = readln().toInt()

		print(c in a && c in b)

	fun checkNumberRange(number: Int): String {
		val range = 1..10
		return if (number in range) "$number is inside the range." else "$number is outside the range."
	}

	println(checkNumberRange(5))
	println(checkNumberRange(11))

	//fun main() {
		val num = readln()!!.toInt()
		val range2 = readln().toInt()..readln().toInt()
		println(num in range2)
	//}

}