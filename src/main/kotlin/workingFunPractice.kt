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


/*fun main(args: Array<String>) {
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
 */

/*Write a program that reads four characters and prints the previous character in the Unicode table
for each of them.

Sample Input 1:

b
c
d
e
Sample Output 1:

a
b
c
d
*/

//fun main(): Unit {
/*		val scanner = Scanner(System.`in`)
		var w: Char = scanner.next().first()
		var x: Char = scanner.next().first()
		var y: Char = scanner.next().first()
		var z: Char = scanner.next().first()
		 println(-- w)
		 println(-- x)
		 println(-- y)
		 println(-- z)
}
*/



/*task is to determine what you will say as you give away the extra cookie.

If your friend likes cookies, and is named Do-yun, then you will say:

One for Do-yun, one for me.
If your friend doesn't like cookies, you give the cookie to the next person in line at the bakery. Since you don't know their name, you will say you instead.

One for you, one for me.
Here are some examples:

Name	Dialogue
Alice	One for Alice, one for me.
Bohdan	One for Bohdan, one for me.
One for you, one for me.
Zaphod	One for Zaphod, one for me.
 */

fun twofer(name: String): String {
	return if (name != "") {
		"One for $name, one for me."
	} else {
		"One for you, one for me."
	}

}

//fun main() {
	//val name = readln()
	//println(twofer(name))
//}


/*
Write a program that reads the first name, the last name and the age of a person and then prints the information as in the examples below.

To solve this problem, use string templates.

Sample Input 1:

John Smith 30
Sample Output 1:

J. Smith, 30 years old
Sample Input 2:

Reece Weber 20
Sample Output 2:

R. Weber, 20 years old
 */

/*
fun main() {
	val (firstName, lastName, age) = readln().split(" ")
	println("${firstName.first()}. $lastName, $age years old")
*/

	//fun main() {
		//val string = readln()
		//val number = readln().toInt()

		//println("Symbol # $number of the string \"$string\" is '${string[number - 1]}'")
	//}

	fun main() {
		val firstName = readln()!!
		val lastName = readln()!!

		println(firstName.first() + ". " + lastName)

}