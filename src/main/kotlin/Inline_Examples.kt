//Other examples are scattered in other files

fun getLength(input: String?): Int {
	if (input == null) return -1
	return input.length
}

fun getLength2(input: String?): Int = input?.length ?: -1

fun multiply(x: Int, y: Int) = x * y

fun words(words: String) = println(words)