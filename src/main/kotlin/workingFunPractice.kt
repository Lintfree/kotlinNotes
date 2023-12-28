fun sum(a: Int, b: Int, c: Int): Int {
	return a + b + c
}

fun getLastDigit(a: Int): Int {
	return a.toString().last().digitToInt()
}

fun isRightEquation(a:Int, b:Int, c:Int): Boolean {
	return (a * b == c)
}



fun main() {
	val a = readln().toInt()
	val b = readln().toInt()
	val c = readln().toInt()

	println(sum(a, b, c))
	println(getLastDigit(a))
	println(isRightEquation(a, b, c))
}



