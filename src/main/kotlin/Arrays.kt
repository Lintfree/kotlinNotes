/*
Introduction to arrays
Arrays are useful when you need to process multiple values of the same type.
You can save and process them together in an array as a single unit.
It is convenient if you don't know how many elements the program will process during its runtime.

You may consider an array as a collection of elements of one type. All elements are stored in the memory sequentially.

The collection provides one name for all elements. Once an array is created,
it cannot be changed. However, you can modify a stored element at any time.

Introduction to arrays
Arrays are useful when you need to process multiple values of the same type. You can save and process them together in an array as a single unit.
It is convenient if you don't know how many elements the program will process during its runtime.

You may consider an array as a collection of elements of one type. All elements are stored in the memory sequentially.

The collection provides one name for all elements. Once an array is created, it cannot be changed. However, you can modify a stored element at any time.

The picture below illustrates an array of five floating-point numbers. Each element has an integer index (0-4), so you can access it.
The first element always has the index of 0, the last element has the index that equals array size - 1.

Details
We hope you got a general idea of what arrays are. Now, let's see how we can use them in Kotlin.

Creating an array with specified elements
Kotlin can handle many types of arrays: IntArray, LongArray, DoubleArray, FloatArray, CharArray, ShortArray, ByteArray, BooleanArray.
Each array stores elements of the corresponding type (Int, Long, Double, and so on). Note that Kotlin doesn't have a default StringArray type.
You can store Strings in arrays, but we will talk about it in another topic.

To create an array of a specified type, we need to invoke a special function and pass all elements to store them together:

intArrayOf creates IntArray;

charArrayOf creates CharArray;

doubleArrayOf creates DoubleArray;

and so on.

For example, let's create three arrays:

val numbers = intArrayOf(1, 2, 3, 4, 5) // It stores 5 elements of the Int type
println(numbers.joinToString()) // 1, 2, 3, 4, 5

val characters = charArrayOf('K', 't', 'l') // It stores 3 elements of the Char type
println(characters.joinToString()) // K, t, l

val doubles = doubleArrayOf(1.25, 0.17, 0.4) // It stores 3 elements of the Double type
println(doubles.joinToString()) // 1.25, 0.17, 0.4
This code snippet above prints three arrays:

1, 2, 3, 4, 5
K, t, l
1.25, 0.17, 0.4

The joinToString() function converts an array into a string.

When you initialize an array (or anything else) with a sequence of arguments, you can add a trailing comma.
It can be useful if you want to add or change some values:

val array = intArrayOf(1, 2, 3, 4,) // works since Kotlin 1.4

Creating an array of a specified size
To create an array of a certain size, we need to write its type and pass it after the type name in round brackets (the constructor):

val numbers = IntArray(5) // an array of 5 integer numbers
println(numbers.joinToString())

val doubles = DoubleArray(7) // an array of 7 doubles
println(doubles.joinToString())
These arrays are going to have a predefined size.
They are filled by the default values of the corresponding types (0 for numeric types):

0, 0, 0, 0, 0
0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
You cannot change the size of an array, but you can modify the elements.

Another option is to use the Array constructor that takes the array size and the function that returns values of array elements given its index
or a constant value or using a combination of the apply scope function and the fill() method that fills an array with the specified element.

val numbers = IntArray(10) { i -> i + 1 }
println("Numbers: ${numbers.joinToString()}")
// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
val onlyOne = IntArray(10) { 1 }
println("Only 1: ${onlyOne.joinToString()}")
// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
val onlyMinusOne = IntArray(10).apply { fill(-1) }
println("Only -1: ${onlyMinusOne.joinToString()}")
// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1

Reading array from input
You don't need to figure out all the snippets right now, just use them as a template for your projects!

To read an array of a certain size from the console, we first need to create an array of some type with a known size.
Inside the parentheses, we should place readln(), with the help of which we can read input from the console.
The readln() function returns a string, so don’t forget to convert the input string into the type of the created array.

val numbers = IntArray(5) { readln().toInt() } // on each line single numbers from 1 to 5
println(numbers.joinToString()) // 1, 2, 3, 4, 5
This code allows you to read 5 numbers, each number on a separate line.

If you want to read an array in a single line, use the following approach.
You can read the array with the readln() function. You’ll get a string, which you should split.

// here we have an input string "1 2 3 4 5"

val numbers = readln().split(" ").map { it.toInt() }.toTypedArray()
println(numbers.joinToString()) // 1, 2, 3, 4, 5
Let’s have a look at this code snippet.
We read a string from input and then use split().
We divide our string into smaller ones by space, then every element with a map function we convert to Int,
and we return an integer array. Here you can read more about mapping transformation.

There is also a way that allows you to ignore line breaks and extra spaces in the input string.
You can do this with the help of regular expressions, which are often used in text searching and editing.

val regex = "\\s+".toRegex()
val str = "1 2\t\t3  4\t5  6"
val nums = str.split(regex).map { it.toInt() }.toTypedArray()
println(nums.joinToString()) // 1, 2, 3, 4, 5, 6
With this regular expression, you can ignore spaces and tabs in the input string. You can learn more about regular expressions in our topics.

Array size
An array always has a size, that is, the number of elements.
To obtain it, we need to take the value of the size property. It is a number of Int type.

val numbers = intArrayOf(1, 2, 3, 4, 5)
println(numbers.size) // 5
You cannot change the size of an array after it has been created.

Accessing elements
You can change the values of array elements. Use the index to set a value in the array.

Setting the value by the index:

array[index] = elem
Getting the value by the index:

val elem = array[index]
Array indexes are numbers from 0 (the first element) to array.size-1 (the last element).

Here is an example of a three-element array of integers:

val numbers = IntArray(3) // numbers: 0, 0, 0

numbers[0] = 1 // numbers: 1, 0, 0
numbers[1] = 2 // numbers: 1, 2, 0
numbers[2] = numbers[0] + numbers[1] // numbers: 1, 2, 3

println(numbers[0]) // 1, the first element
println(numbers[2]) // 3, the last element
Let's take a closer look at the code above.
First, we have an array with three elements. By default, all elements are equal to 0.
Then, the value 1 is assigned to the first element of the array by the index of 0.
Then, the value 2 is assigned to the second element of the array by the index of 1.
After that, the value 3 (the sum of 1 and 2) is assigned to the last element of the array by the index of 2.
Then, we print the first and the last element of the three-element array.

If we try to access a non-existing element by the index, the program will throw an exception.
Let's try to get the fourth element with the index of 3 of the considered numbers array:

val elem = numbers[3]
The program will throw ArrayIndexOutOfBoundsException.

As you may already know, the last element has an index equal to array.size - 1. Let's access the last element and the one before the last:

val alphabet = charArrayOf('a', 'b', 'c', 'd')

val last = alphabet[alphabet.size - 1]    // 'd'
val prelast = alphabet[alphabet.size - 2] // 'c'
Kotlin provides several convenient ways to access the first and the last elements of an array as well as to access the last index:

println(alphabet.first())   // 'a'
println(alphabet.last())    // 'd'
println(alphabet.lastIndex) // 3
Use this approach to make your code more readable and prevent accessing non-existent indexes.

Comparing arrays
To compare two arrays, invoke the contentEquals() function of an array and pass another array as the argument.
This function returns true when two arrays contain the same elements in the same order. Otherwise, it returns false:

val numbers1 = intArrayOf(1, 2, 3, 4)
val numbers2 = intArrayOf(1, 2, 3, 4)
val numbers3 = intArrayOf(1, 2, 3)

println(numbers1.contentEquals(numbers2)) // true
println(numbers1.contentEquals(numbers3)) // false
Beware, the operators == and != do not compare the contents of arrays, they compare only the variables that point to the same object:

val simpleArray = intArrayOf(1, 2, 3, 4)
val similarArray = intArrayOf(1, 2, 3, 4)

println(simpleArray == simpleArray)  // true, simpleArray points to the same object
println(simpleArray == similarArray) // false, similarArray points to another object

Swap elements
Suppose you have a numbers array of the IntArray type. Swap its first and last elements.
It is guaranteed that the size of the array is larger than 0.

val numbers = intArrayOf(1, 2, 3, 4, 5)
val temp = numbers[0]
numbers[0] = numbers[numbers.size - 1]
numbers[numbers.size - 1] = temp
*/