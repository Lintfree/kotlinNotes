

//fun prt (a: Int, b: Int, c: Int, d: Int): Int {
    //return (a + b + c + d)
//}




/*
fun main() {
    println("Enter four numbers:")
    val input = readln().toIntOrNull()
    //ensure input is an int
    // input only 4 numbers
    if (input != null) {
            val a = readln().toInt()
            val b = readln().toInt()
            val c = readln().toInt()
            val d = readln().toInt()
            println("The result is: ${prt(a, b, c, d)}")
        } else {
            println("Invalid input. Please enter an integer:")
            return
        }
    }
    */
/*
fun main() {
    val size = readln().toInt()
    val mutList: MutableList<Int> = mutableListOf()
    for (i in 0..<size) {
        mutList.add(readln().toInt())
    }
    val input = readln()
    val nums = input.split(" ")

    if (mutList.contains(nums[0].toInt()) && mutList.contains(nums[1].toInt())) {
        println("YES")
    } else {
        println("NO")
    }
}

 */
/* same as above but better
fun main() {
    val list = MutableList(readln().toInt()) { readln().toInt() }
    val (p, m) = readln().split(" ")
    if (p.toInt() in list && m.toInt() in list) print("YES") else print("NO")
}
*/

/*
Right Rotation
Right rotation is an operation that shifts each element of the list to the right.

If we right rotate the list {1,2,3,4,5} by 1 position, the new list will be {5,1,2,3,4}.
Another example: if we right rotate the list {1,2,3,4,5} by 2 positions, the new list will be {4,5,1,2,3} because
{1,2,3,4,5} -> {5,1,2,3,4} -> {4,5,1,2,3}.

And one more example: if we right rotate the list {5,6,7,8,9} by 5 positions, the new list will be {5,6,7,8,9} because
{5,6,7,8,9} -> {9,5,6,7,8} -> {8,9,5,6,7} -> {7,8,9,5,6} -> {6,7,8,9,5} -> {5,6,7,8,9}.

The first line of the input contains the number of elements in the list, N.
The next N lines contain the elements of the list.
The last line is a value that indicates the number of positions to rotate.

The output contains the shifted elements of the list. Separate the elements by a space.

If you want to move the list of 5 items by 11 positions, you can move it by 1 position. To calculate the necessary shifts, it is enough to perform a simple calculation of 11 % 5, the remainder of the division and will be the necessary number of shifts. Here is another example: shifting 25 elements by 973 positions. The required number of shifts will be 973 % 25 equals 23. Such optimization will reduce the execution time of the program, as well as the amount of memory used.
If you move without optimization, you fail the tests!

Sample Input

5  // the number of elements in the list
1  // the lines contain the elements of the list
2  // ..
3  // ..
4  // ..
5  // ..
1  // the value that indicates the number of positions to rotate
Sample Output

5 1 2 3 4

*/

/*
fun main() {
    val n = readln().toInt()
    val originalList = MutableList(n) { readln().toInt() }
    var rotations = readln().toInt()
    //list size % num of rotations
    val size = originalList.size
    if (rotations > size) {
        rotations %= size
    }
    for (i in 1..rotations) {
        val lastElement = originalList.removeAt(originalList.size - 1)
        originalList.add(0, lastElement)
    }
    println(originalList.joinToString(" "))
}
 */

/*Write a program that counts the times a number M occurs in N numbers.

The first line contains the N number.
The next N lines contain the numbers.
The last line contains the M number.

Output only a single non-negative integer number.

Sample Input 1:
5
1
2
3
4
5
4
Sample Output 1:
2
 */

/*
fun main() {
    val n = readln().toInt()
    val list = MutableList(n) { readln().toInt() }
    val m = readln().toInt()
    var count = 0
    for (i in list) {
        if (i == m) {
            count++
        }
    }
    println(count)
}
 */

/*
You are given a list of positive integers.
Your task is to create a program that loops over the list and checks each number.
If the number is odd, multiply it by 2, if it's even, divide it by 2.
Print the transformed list as output. The input will be a string representation of a list of comma-separated integers,
and the output should be a string representation of the transformed list of comma-separated integers.
 */

/*fun main() {
    val list = readln().split(",").map { it.toInt() }
    //Returns a list containing the results of applying the given transform function
    // in this case the , is the delimiter/separator transform function
    // to each element in the original collection.
    val newList = mutableListOf<Int>()
    for (i in list) {
        if (i % 2 == 0) {
            newList.add(i / 2)
        } else {
            newList.add(i * 2)
        }
    }
    println(newList.joinToString(","))
}
*/

/*
import java.util.*

fun transformList(numbersString: String): String {
    // Converting the String of comma-separated integers to a MutableList of Integers.
    val numbers = numbersString.split(",").map { it.toInt() }.toMutableList()

    // Put your code here to loop over the list and transform the numbers according to the given constraints.

    for (i in numbers.indices) {
        if (numbers[i] % 2 == 0) numbers[i] = numbers[i] / 2 else {
            numbers[i] = numbers[i] * 2
        }
    }
    // After transforming the list, convert it back to a String and return.
    return numbers.joinToString(",")
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // The input will be read as a String, and you will need to parse it to a MutableList of Integers.
    val numbersString = scanner.nextLine()

    val transformedListString = transformList(numbersString)

    // Print the transformed list as a string.
    println(transformedListString)
}

//Given a string of numbers separated by commas, create a MutableList out of these numbers and find the third smallest element.
// Assume that the input string always has at least three distinct numbers. Return the third smallest number.

import java.util.*

fun thirdSmallest(numbers: String): Int {
    // Step 1: Initialize MutableList and populate it
    var numberList: MutableList<Int>
    // Your code goes here
    numberList = numbers.split(",").map { it.toInt() }.toMutableList()

    // Step 2: Sort the MutableList
    // Your code goes here
    numberList.sort()

    // Step 3: Return the third smallest number
    val thirdElement = numberList.elementAt(3)

    return thirdElement
}

fun main(args: Array<String>) {
    // Get input string from user
    val input = readln()

    // Call the thirdSmallest method and print the output
    println(thirdSmallest(input))
}
 */

//You are given a List of integers.
// Iterate through the given List and print in a single line the elements that are divisible by 2.

//Sample Input 1:

//8 11 13 2
//Sample Output 1:

//8 2

/*
fun solution(numbers: List<Int>) {
    for (i in numbers) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }

}

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    solution(numbers)
}
 */

/*
fun solution(strings: List<String>, str: String): Int {
    for (i in strings) {
        if (i == str) {
            return strings.count { it == str }
        }
    }
    return 0
}

fun main() {
    val strings = readln().split(" ")
    val str = readln()
    println(solution(strings, str))
}
*/

/*
In the input, you are given a List of products that you put on the shelf and a String that represents a specific product.
Print out this product's position on the shelf. Note that products may repeat.
 */

/*
fun solution(products: List<String>, product: String) {
        for (i in products.indices) {
            for (j in products.indices) {
                if (products[j] == product) {
                    print("$j ")
                }
            }
            return
        }

    }
*/
/*
fun main() {
    val products = readln().split(" ")
    val product = readln()
    solution(products, product)
}

//Write a program that finds the summation of every number from 1 to num. The number will always be a positive integer greater than 0.
// Your function only needs to return the result,

fun summation(n:Int):Int {
    var sum = 0
    for (i in 1..n) {
        sum += i
    }
    return sum
}
*/

/*The second of T
Iterate through every second element of a list in a loop and find the index of the first word that starts with T.
It is guaranteed that at least one word with an odd index starts with T.

Sample Input 1:
Test Kora Terra Tetta Garry
Sample Output 1:
3
*/

/*
fun solution(names: List<String>): Int {
    for ((i, j) in names.withIndex()) {
        if (i % 2 != 0 && j.first() == 'T') {
            return i
        }
    }
    return -1
}

fun main() {
    println(solution(readln().split(" ")))
}

 */
/*
The first position of the largest element
Write a program that reads a sequence of numbers of undefined size and prints the largest number and the position of its first occurrence. The position starts from 1.

Note that numbers can be negative.

You can stop typing in the console in IDEA by pressing Ctrl+D after you have entered the last number and hit Enter.

Sample Input 1:

5
1
2
3
4
5
Sample Output 1:

5 1
Sample Input 2:

-100000
-100000
-100000
Sample Output 2:

-100000 1
*/

/*
fun main() {
    val numbers = mutableListOf<Int>()
    while (true) {
        val input = readLine()
        if (input == null) {
            break
        }
        numbers.add(input.toInt())
    }
    if (numbers.isNotEmpty()) {
        val max = numbers.maxOrNull()
        val maxIndex = numbers.indexOf(max) + 1
        println("$max $maxIndex")
    }
}
*/

/*
The roots of equation
Given are numbers

a,b,c,d
Output in ascending order all the integers between
0 and 1000
 (inclusively) that are the roots of the equation

. The roots of a cubic equation are the values of the variable that satisfy the equation.

If a specified interval does not contain any roots of the equation, do not output anything.

Hint
The roots of a quadratic equation are the values of 'x' in the equation for which the equation holds true.
In other words, the roots of a quadratic equation are the values of 'x'

Details
You can just iterate over x from 0 to 1000 and check the value of the expression.
 */

/*
fun main() {
    // put your code here

    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    for (x in 0..1000) {
        val y = (a * x * x * x) + (b * x * x) + (c * x) + d
        if (y == 0) {
            println(x)
        }
    }
}
*/
/*
Write a program that checks if a set of N numbers contains a number M.

The first line contains the N number.
The next N lines contain the set of numbers one number per line.

The last line contains one integer number M.

You need to output either YES or NO.

Sample Input 1:
5
1
2
3
4
5

Sample Output 1:
YES
 */

/*
fun solution(newSet: MutableSet<String>, oldSet: Set<String>): MutableSet<String> {
	for (i in oldSet) {
		if (i.first().lowercaseChar() == 'a') {
			newSet.add(i)
		}
	}
	return newSet
}
*/


//fun solution(new: MutableSet<String>, old: Set<String>) =
	//new.apply { addAll(old.filter { it[0] in "aA" }) }


//Write a program that reads four characters and checks for each character whether it is a digit.
//
//The program must print either true or false for each character in a new line.

/*
Sample Input 1:

3
@
8
d
Sample Output 1:

true
false
true
false
 */

/*
fun main() {

	val list = mutableListOf<String>()
	for (i in 1..4) {
		val char = readln()
		list += char
	}

	for (i in list) if (i.all { it.isDigit() }) {
		println("true")
	} else println("false")
}
*/
//reads and prints individually
fun main() {
	repeat(4) {
		println(readln().first().isDigit())
	}
}


