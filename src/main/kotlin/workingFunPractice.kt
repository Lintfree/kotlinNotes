/*
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
*/



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
If your friend doesn't like cookies, you give the cookie to the next person in line at the bakery.
Since you don't know their name, you will say you instead.

One for you, one for me.
Here are some examples:

Name	Dialogue
Alice	One for Alice, one for me.
Bohdan	One for Bohdan, one for me.
One for you, one for me.
Zaphod	One for Zaphod, one for me.
 */

/*
fun twofer(name: String): String {
	return if (name != "") {
		"One for $name, one for me."
	} else {
		"One for you, one for me."
	}

}
*/

/*fun main (){
	val name = readln()
	val cookie = twofer(name)
	println(cookie)
}
*/

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

/*
	fun main() {
		val firstName = readln()!!
		val lastName = readln()!!

		println(firstName.first() + ". " + lastName)
*/

/*Check the order
Write a program that checks if N numbers are sorted according to the ascending order (from the smallest number to the largest one).


The first line contains the number N.
The other lines contain N numbers.

Output "YES" if N numbers are sorted in ascending order, otherwise, output "NO".
*/
/*
fun main() {
	val size : Int = readln()!!.toInt()
	val list = mutableListOf <Int>()

	for (i in 1..size) {
		list.add (readln().toInt())
	}
	val sortedList = list.sorted()
	if (sortedList == list) {
		println("YES")
	}else {
		println("NO")
	}
}
*/

/*same as above
fun main() {
	val n = readln().toInt()
	val nums = List(n) { readln().toInt() }
	if (nums == nums.sorted()) println("YES") else println("NO")
}
*/

/*
fun main() {
	val pi = 3.1415
	val radius = readln().toInt()
	val area = pi * (radius * radius)
	println(area)
}
*/

/*
imagine a bakery that has a holiday offer where you can buy two cookies for the price of one ("two-fer one!").
You go for the offer and (very generously) decide to give the extra cookie to a friend.

Instructions
Your task is to determine what you will say as you give away the extra cookie.

If your friend likes cookies, and is named Do-yun, then you will say:

One for Do-yun, one for me.
If your friend doesn't like cookies, you give the cookie to the next person in line at the bakery.
Since you don't know their name, you will say you instead.

One for you, one for me.


fun main() {
	val name = readln()
	if (name != "") {
		println("One for $name, one for me.")
	} else {
		println("One for you, one for me.")
	}
}
*/

//can be done better with repeat?

/*
fun main() {
	val numOfParts = readln().toInt()
	var larger = 0
	var smaller = 0
	var perfect = 0
	for (i in 1..numOfParts) {
		val part = readln() !!.toInt()
		if (part == 0) perfect ++
		if (part < 0) smaller ++
		if (part > 0) larger ++
	}
	println("$perfect $larger $smaller")
}
 */

/*
The sum of N numbers
Write a program that calculates the sum of N numbers.
The first line contains the number N.
The other lines contain N numbers.
Output the sum of N numbers.


fun main() {
	// write your code here
	val n = readln().toInt()
	var nums = mutableListOf <Int>()
	for (i in 1..n) {
		nums.add(readln().toInt())
	}
	val sum = nums.sum()
	println(sum)
}

 */
//below is better
//fun main() {
//    print(List(readLine()!!.toInt()) { readLine()!!.toInt() }.sum())
//}

/*
Write a program that reads three double values a, b, c, and solves this equation:

a * x + b = c
Output the value of x.
Guaranteed that a is not 0.

Sample Input 1:
2
-1
2
Sample Output 1:
1.5
Write a program in Kotlin


fun main() {
	val a = readln().toDouble()
	val b = readln().toDouble()
	val c = readln().toDouble()
	val x = (c - b) / a
	println(x)
}

fun main() {
	val number = readLine()!!.toInt()
	println(round(number))
}

// do not change function below

fun round(number: Int): Int? {
	return if (number >= 1000) 0 else number
}

fun identity(x: Int): Int {
	x.toString()
	return x
}

fun half(x: Int): Int = x / 2


fun zero(x: Int): Int = 0
*/


/*
fun generate(functionName: String): (Int) -> Int {
	// TODO: provide implementation here
	return when (functionName) {
		"identity" -> ::identity
		"half" ->  ::half
		"zero" ->  ::zero
		else -> :: zero
	}

}



//Better and shorter, I overthinked it
//The generate function receives a functionName as input,
// which is then used in the when statement to determine which function to return.
// When the returned function is invoked with an Int argument,
// it performs the corresponding operation based on the functionName that was provided to the generate function.
fun generate(functionName: String): (Int) -> Int {
	when (functionName) {
		"identity" -> return { i: Int -> i }
		"half" -> return { i: Int -> i / 2 }
		else -> return { i: Int -> 0 }
	}
}
 */

// if the length of the input string is greater than 5, it returns null; otherwise it returns the string.
// It has to return 0 in null case.

/*
fun main() {
	val argument = readln()
	println(check(argument)?.length ?: "0")
}

// do not change function below

fun check(name: String): String? {
	return if (name.length > 5) null else name
}
 */

/*
open class Wood(val age: Int) {
	fun getWoodInfo(): String {
		return "age $age"
	}
}

class Pine(val isSpiny: Boolean, age: Int) : Wood(age) {
	fun getPineInfo(): String {
		return getWoodInfo() + ", spiny $isSpiny"
	}
}

fun main() {
	val pine = Pine(true, 3)
	println(pine.getPineInfo() + ", " + pine.getWoodInfo())
}

 */

/*
example hierarchy:
open class Animal

open class Mammal : Animal()
class Lion : Mammal()

open class Fish : Animal()
class Salmon : Fish()
class Carp : Fish()

open class Bird : Animal()
class Eagle : Bird()
 */


//Given a class named Car containing three properties:
// the Int property year, the String property make, and the Int property speed.
//
//Add the following member functions to the class:
//
//accelerate adds 5 to the speed property each time it's called;
//decelerate subtracts 5 from the speed property each time it's called.
// The speed cannot be less than zero, so if you get a negative speed, just make it equal to 0.
/*
class Car(val make: String, val year: Int) {

	var speed: Int = 0

	fun accelerate() {
		speed += 5
	}

 */

	/*
	fun decelerate() {
		if (speed - 5 < 0) {
			speed = 0
		} else if (speed in 1..5) {
			speed = 0
		} else if (speed > 5) {
			speed  -= 5
		}
	}
}

*/

/*
    fun decelerate() {
        speed = maxOf(0, speed - 5)
    }
}

 */

/*
fun carPrice(old: Int = 5, kilometers: Int = 100_000, maximumSpeed: Int = 120, automatic: Boolean = false) {
	var price = 20000
	price -= old * 2000
	price += (maximumSpeed - 120) * 100
	price -= (kilometers / 10000) * 200
	price = if (automatic) price + 1500 else price
	println(price)
}
*/

/*
fun main() {
	val smartOne = Smartphone("Ericsong")
	smartOne.price = -24 //-24-8 = -32
	val smartTwo = Smartphone("iNokhe") // iNokhe has a price of -5-6=-11
	print(smartTwo.price - smartOne.price)
}


class Smartphone(val name: String) {
	var price: Int = -5
		get() = name.length - field
}

 */

/*
Imagine that you're a tutor.
You need to write a program that parses your students' answers and prints true if the answer is I can do my homework on time!
or I can't do my homework on time! and false in all other cases.

To complete this task, use the function matches().
 */

/*
fun main() {
	val answer = readln()

	println(
		when (answer) {
			"I can do my homework on time!" -> true
			"I can't do my homework on time!" -> true
			else -> false
		}
	)
}

 */



