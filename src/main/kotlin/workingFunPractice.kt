import java.util.*


fun sum(a: Int, b: Double, c: Int): Double {
	return a + b + c
}

fun getLastDigit(a: Int): Int {
	return a.toString().last().digitToInt()
}

fun isRightEquation(a:Int, b:Int, c:Int): Boolean {
	return (a * b == c)
}

/*
See if you can get this to work.
The goal is to find the number of years it would take to reach 700000.
The interest rate is 1.071%
finished by ai, review to understand
*/


fun findYears(depo: Double): Int {
	var deposit = depo
	val interestRate = 1.071
	val max = 700000
	var years = 0

	while (deposit < max) {
		deposit *= interestRate
		years++
	}
	return years
}




/*fun main() {
	val a = readln().toInt()
	val b = readln().toInt()
	val c = readln().toInt()

	println(sum(a, b, c))
	println(getLastDigit(a))
	println(isRightEquation(a, b, c))

	val depo = readLine()!!.toDouble()
	println(findYears(depo))
}

 */

/*
import java.util.Scanner
val scanner = Scanner(System.`in`)

fun main() {
	val numOfStudents = readln().toInt()
	var grade = 0
	var count = 0
	var d = 0
	var c = 0
	var b = 0
	var a = 0

	while (count < numOfStudents) {
		count++
		grade = scanner.nextInt()
		if (grade == 2) {
			d++
		}else if (grade == 3) {
			c++
		}else if (grade == 4) {
			b++
		}else if (grade == 5) {
			a++
		}
	}
	print("$d $c $b $a")
}
*/
// better than above


fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	// put your code here
	val n = scanner.nextInt()
	var (d, c, b, a) = arrayOf(0, 0, 0, 0)
	repeat(n) {
		val x = scanner.nextInt()
		when (x) {
			2 -> d++
			3 -> c++
			4 -> b++
			5 -> a++
		}
	}
	print("$d $c $b $a")
}



