/*
Basically, we can say that a multi-dimensional list is a list of lists.
That is, in order to create a multi-dimensional list, we need to present a list as an element of another list.
Eventually, we get a multi-dimensional list.

Such lists make it very easy to represent things that have many dimensions: for example, 3D objects with length, height, and width.
The universe we live in could be described with four measurements, time being the fourth dimension, so it is 4D.
Higher levels, like 5D and so forth, are hard to imagine, but when you put the concept into practice, they turn out to be handy and not too complicated!

Let's look at some more down-to-earth examples.
A seat in the theater can be indicated with a 2D-list: one index for the row and another one for the number of the seat in that row.
If you want to write a game that uses maps, such as Sea Battle, two-dimensional lists will be very helpful in setting coordinates on the map.
In addition, some mathematical structures are conveniently represented as multi-dimensional lists.

First, let’s take a look at a special case of a multi-dimensional list that is used quite often in practice: a two-dimensional list.

Creating 2-dimensional lists
While a one-dimensional list can be represented as a single sequence of elements,
an intuitive way of representing a two-dimensional list is a matrix or a table.
If you're working with matrices or tables in your program, it makes sense to present them in the form of a two-dimensional list.

Let's create a two-dimensional mutable list of Int with 3 rows and 4 columns where all elements are 0's (zeros). Here is what it looks like:

val mutList2D = mutableListOf(
    mutableListOf<Int>(0, 0, 0, 0),
    mutableListOf<Int>(0, 0, 0, 0),
    mutableListOf<Int>(0, 0, 0, 0)
)

You simply define each element of the mutList2D as a list of four zeros! It is easy to picture it like this:

0, 0, 0, 0
0, 0, 0, 0
0, 0, 0, 0

We can say that the lists with four zero elements are nested in the mutList2D.
The list that contains other lists is called the main list.

Note an interesting feature: nested lists do not necessarily have to be the same size.
In the example below, each new embedded list has a different length:

val mutList2D = mutableListOf(
    mutableListOf<Int>(0),
    mutableListOf<Int>(1, 2),
    mutableListOf<Int>(3, 4, 5)
)

0
1, 2
3, 4, 5

You can create nested lists with different numbers of elements in the same 2D list.

Accessing elements
Let’s see how we can access an element of a list. The principle is exactly the same as for one-dimensional lists. Only now we have to write two indices: first, the index of the element of the main list and then, the index of the nested list.

Let's get back to our mutList2D for a moment. Suppose we need to access an element that is in the first row and the first column. How do we find this particular element? As you recall, mutList2D is a list of lists. So, start by selecting one of the nested lists by its index in the main list. The principle is similar to a 1D list.

First, go to the nested lists and choose the inner list with its index:

val mutList2D = mutableListOf(
    mutableListOf<Int>(0, 1, 2),   //[0]
    mutableListOf<Int>(3, 4, 5)    //[1]
)

mutList2D[0]

0, 1, 2

mutList2D[1]

3, 4, 5

Second, in this nested list, choose the required element with its index, just like we did with 1D lists:

mutList2D[0][0]

0

mutList2D[0][1]

1

mutList2D[0][2]

2

mutList2D[1][0]

3

Let's print mutList2D[0][0]: the element in the first row and the first column of our mutList2D:

val mutList2D = mutableListOf(
    mutableListOf<Int>(0, 1, 2),   //[0]
    mutableListOf<Int>(3, 4, 5)    //[1]
)

println(mutList2D[0][0])	// 0

Remember that in all lists indexing starts with 0!

The following code will show all the elements of the two-dimensional list mutList2D:

print(mutList2D[0][0])  // 0
print(mutList2D[0][1])  // 1
print(mutList2D[0][2])  // 2
print(mutList2D[1][0])  // 3
print(mutList2D[1][1])  // 4
print(mutList2D[1][2])  // 5


Creating 2D lists of different types
Nested lists don't need to be of type Int: as you remember, Kotlin provides various types of lists.
For example, you can create a list of string lists as in the example below.

You can also clearly define the type of elements of nested lists:

val mutListOfString2D = mutableListOf(
    mutableListOf<String>("to", "be", "or"),
    mutableListOf<String>("not", "to", "be")
)

println(mutListOfString2D[0][0])	// to
println(mutListOfString2D[0][1])	// be
println(mutListOfString2D[0][2])	// or
println(mutListOfString2D[1][0])	// not
println(mutListOfString2D[1][1])	// to
println(mutListOfString2D[1][2])	// be


In order to create nested lists of primitives, you can use lists of a certain type as we did for one-dimensional lists:
Int, Long, Double, Float, Char, Short, Byte, and Boolean.

For example, let's consider creating a mutable list of the character type:

val mutListOfChar2D = mutableListOf(
    mutableListOf<Char>('A', 'R', 'R'),
    mutableListOf<Char>('A', 'Y', 'S')
)

You can imagine it like this:

A, R, R
A, Y, S

Besides, nested lists can be of different types.
For example, you can create a two-dimensional list that stores both Int and String lists:

val mutListOfStringAndInt2D = mutableListOf(
    mutableListOf<String>("Practice", "makes", "perfect"),
    mutableListOf<Int>(1, 2)
)

You can create nested lists of different types in the same 2D list.

Features of working with 2D lists
Let’s look at some useful and interesting features of working with two-dimensional lists.
You remember that we can print all the elements of a list as a string using the joinToString() function.
For nested lists, it will also work. Only now you must specify the index of the nested list that you want to convert to a string:

val mutListString = mutableListOf(
    mutableListOf<String>("A", "R", "R", "A", "Y")
)
print(mutListString[0].joinToString())    // A, R, R, A, Y

In the case of multi-dimensional lists, this will not always be convenient.
In order to get the contents of all lists in a single string, you just print the main list:

val mutListOfChar2D = mutableListOf(
mutableListOf<Char>('k'),
mutableListOf<Char>('o', 't'),
mutableListOf<Char>('l', 'i', 'n'))

println(mutListOfChar2D)	// [[k], [o, t], [l, i, n]]

Multi-dimensional lists (>2)
We are finally ready to deal with more complex concepts. There are lists with more than two dimensions. Even though it is more difficult to understand what it looks like, don’t worry: you will get used to working with them.

You can imagine a three-dimensional list like this:
[0,1]   [2,3]
[4,5]   [6,7]

In each element of a two-dimensional list, you have another nested list.

You can imagine it as a cube or a box: it has exactly three dimensions — length, width, and height.
Take the following practical situation: imagine that you need to figure out the location of a car in a multi-storey parking lot.
Then, you have to set three numbers, the three coordinates: floor, row, and place in a row.

The following code creates the three-dimensional mutable list you just saw above:

val mutList3D = mutableListOf(
    mutableListOf(mutableListOf<Int>(0,1), mutableListOf<Int>(2,3)),
    mutableListOf(mutableListOf<Int>(4,5), mutableListOf<Int>(6,7))
)

println(mutList3D)  // [[[0, 1], [2, 3]], [[4, 5], [6, 7]]]

Accordingly, in order to refer to an element of such a list, we need three indices:

println(mutList3D[0][0][1])   // 1
println(mutList3D[1][0][1])   // 5
println(mutList3D[1][1][1])   // 7

You can create lists with even more dimensions by analogy — 4, 5, 6 dimensions, and so on — as you need.
Just remember that an element of a multidimensional list has as many indices as there are dimensions in that list.

A multi-dimensional list is essentially a list of lists.

To find an element of a multi-dimensional list, you need a number of indices equal to the number of list dimensions.

You can explicitly specify nested lists of different types, not only Int.

You can assemble lists of different types and sizes in a multi-dimensional list.

To print all list elements, you can use the function joinToString().

Indexing starts with 0.
 */

/*
Imagine you have a 2D list inputList. It is guaranteed that it has at least two nested lists.

Create a new two-dimensional list with two nested lists — the first and last lists from inputList — in reverse order.
In other words, the last one should become the first, and vice versa.

Print the resulting list.
 */

/*
fun main() {

	val inputList = mutableListOf(
		mutableListOf('P', 'R', 'O', 'G', 'R', 'A', 'M', 'M', 'I', 'N', 'G'),
		mutableListOf('I', 'S'),
		mutableListOf('M', 'A', 'G', 'I', 'C')
	)

	print(inputList.last().joinToString())
	print(", ")
	print(inputList.first().joinToString())
}
*/

/*

fun main() {
	// Do not touch code below
	val inputList: MutableList<MutableList<String>> = mutableListOf()
	val n = readLine()!!.toInt()
	for (i in 0 until n) {
		val strings = readLine()!!.split(' ').toMutableList()
		inputList.add(strings)
	}
	val outputList = mutableListOf(inputList.last(), inputList.first())
	println(outputList)
}

 */

/*
Write code that prints the third row of inputList in one string.
The elements should be separated by a comma and space.

It is guaranteed that inputList is already initialized and contains at least 3 nested lists.

Tip: Use the joinToString() function.

Sample Input 1:

val inputList = mutableListOf(
    mutableListOf("one", "two", "three"),
    mutableListOf("four", "five", "six"),
    mutableListOf("seven", "eight", "nine"),
    mutableListOf("ten", "eleven", "twelve")
)

Sample Output 1:

seven, eight, nine
 */

fun main() {
	val inputList: MutableList<MutableList<String>> = mutableListOf()
	val n = readLine()!!.toInt()
	for (i in 0 until n) {
		val stringsList = readLine()!!.split(' ').toMutableList()
		inputList.add(stringsList)
	}

	println(inputList[2].joinToString(separator = ", " ))

}

/*
val mutList3D = mutableListOf(
	mutableListOf(mutableListOf(0, 1), mutableListOf(2)),
	mutableListOf(mutableListOf(4, 5, 6, 7), mutableListOf(8, 9)),
	mutableListOf(mutableListOf(10, 11), mutableListOf(12)),
	mutableListOf(mutableListOf(13, 14, 15), mutableListOf(16, 17, 18))
)
println(mutList3D.size) // how many lists
println(mutList3D.first().size) // how many elements in the first list
println(mutList3D[mutList3D.size - 1].last()) //  size = (how many lists) - 1, last elements of the last list
println(mutList3D.first().last().size) // first list, last list, how many elements
//answers
4
2
[16, 17, 18]
1

 */



