/*
Iterating through a range
The simplest example of using the for loop is printing each element of an integer range.

for (i in 1..4) {
    println(i)
}
This loop prints each number from 1 to 4.

1
2
3
4
It is also possible to iterate through a range of characters:

for (ch in 'a'..'c') {
    println(ch)
}
This loop prints:

a
b
c
Note that we cannot use a string range such as "da".."dd" to get the desired result "da" "db" "dc" "dd". In the range,
we can only use single characters.

Iterating through a String
Also, you may iterate over strings. The following code prints each symbol of a String:

val str = "Hello!"
for (ch in str) {
    println(ch)
}
This code prints:

H
e
l
l
o
!

From now on, all the examples will be about numbers because iterating through characters is always the same.

Iterating in the backward order
You can also iterate a range in the backward order.

for (i in 4 downTo 1) {
    println(i)
}
This loop prints numbers from 4 to 1.

4
3
2
1
Note that it is required to use in 4 downTo 1, not in 4..1, to iterate the range in reverse order.

Excluding the upper limit
If we need to exclude the upper limit from a range, we can subtract one from it or write until instead of ..:

for (i in 1 until 4) {
    println(i)
}
This loop prints numbers from 1 to 3.

Specifying a step
If we do not specify a step, it is assumed that the step is equal to one (e.g. 1, 2, 3, ...). Although if we want to change the step, we need to specify it explicitly.

In the example below, we print only odd numbers from the range 1..7.

for (i in 1..7 step 2) {
    println(i)
}
This loop prints four numbers:

1
3
5
7
You can also use it for backward iteration.

for (i in 7 downTo 1 step 2) {
    println(i)
}
This loop prints:

7
5
3
1

An example: the factorial of a number
Let's write a program that calculates the factorial of a given integer number.
It's a classic. The factorial of n is a product of integer numbers from 1 to n inclusive.
Assumed that factorial of 0 is 1. The factorial of 1 is 1 as well.

fun main() {
    val n = readln().toInt()
    var result = 1 // starting value of the factorial

    for (i in 2..n) { // the product from 2 to n
        result *= i
    }

    println(result)
}
The program above reads an integer number from the standard input.
We suppose that the starting value of the factorial is 1 and then sequentially multiply it by numbers from 2 to n.
If the input number is 1, the result is 1. If the input number is 5, the result is 120.
a factorial is a function that multiplies a number by every number below it till 1.
For example, the factorial of 3 represents the multiplication of numbers 3, 2, 1, i.e. 3! = 3 × 2 × 1 and is equal to 6.

An example: the multiplication table of even numbers
You can nest one for loop in the body of another for loop because loops are just regular statements.
Programmers often use nested loops to process multidimensional structures like tables (matrices), data cubes, and so on.

For example, the code below prints the multiplication table of even numbers from 2 to 10.

fun main() {
    for (i in 2..10 step 2) {
        for (j in 2..10 step 2) {
            print(i * j)
            print('\t')  // print the product of i and j followed by one tab
        }
        println()
    }
}
It prints:

4   8   12  16  20
8   16  24  32  40
12  24  36  48  60
16  32  48  64  80
20  40  60  80  100

Idiom
Almost everything in this topic is an idiom! Different types of ranges may be difficult to understand,
but they offer a really convenient and easy-to-read way to write code.
Here we give you a quick reminder of the syntax for iterating over basic ranges:

for (i in 1..6) { ... }        // closed range: 1, 2, 3, 4, 5, 6
for (i in 1 until 6) { ... }   // half-open range: 1, 2, 3, 4, 5
for (x in 1..6 step 2) { ... } // step 2: 1, 3, 5
for (x in 6 downTo 1) { ... }  // closed range, backward
 */

/*
Initializing a list
Create a mutable list of integers named numbers with 100 elements.
Its first element must be 1, the tenth must be 10, and the hundredth one must be 100.
All other elements must be equal to 0.
 */

/*
fun main() {
	val numbers = MutableList(100) { if (it == 0) 1 else if (it == 9) 10 else if (it == 99) 100 else 0 }
	//val numbers = MutableList(100) { if (it == 0 || it == 9 || it == 99) it + 1 else 0 }
	println(numbers.joinToString())
}

fun greetUser(
	name: String,
	admin: Boolean = false,
	smith: Boolean = false,
	honorific: String = "",
	greet: String = "Greetings"
): String {
	return if (!admin && !smith) {
		"$greet, $honorific $name"
	} else {
		"Matrix Error"
	}
}
// do not change lines above

fun greetUser(greet: String = "Hello, ", honorific: String = "Mr. ", name: String = "Anderson"): String {
return "$greet $honorific $name"
}

 */

/*
The index of the first max
Write a program that reads a list of integers and finds the index of the first maximum in the list.
In the other words, find the maximum in the list and output the index of its first occurrence.

The first line contains the number of elements in the list.
The other lines contain the elements of the list. There is at least one element in the list.

Output a single integer value, which is the index of the first maximum.
Finding the index of the maximum element
 */

/*
fun main() {
	val size = readln().toInt()
	val mutList: MutableList<Int> = mutableListOf()
	for (i in 0..<size) {
		mutList.add(readln().toInt())
	}
	var max = mutList[0]
	var maxIndex = 0
	for (i in 1..mutList.lastIndex) {
		if (mutList[i] > max) {
			max = mutList[i]
			maxIndex = i
		}
	}
	println(maxIndex)
}

 */

fun main() {
	val size = readln().toInt()
	val numbers = mutableListOf<Int>()
	repeat(size) {
		numbers.add(readln() .toInt())
	}
	val maxNumber = numbers.maxOrNull()
	val maxIndex = numbers.indexOf(maxNumber)
	println(maxIndex)
}
