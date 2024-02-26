/*
Collections are containers that support various ways to store and organize different objects
and make them easily accessible.
A collection usually contains a number of objects (this number may be zero) of the same type.
Objects in a collection are called elements or items.
Collections are an implementation of abstract data structures that can support the following operations:
retrieving an element;
removing an element;
changing or replacing an element;
adding a new element.
However, it is important to note that operations like adding, removing,
and changing elements only apply to mutable collections.

Mutability
Collections can be mutable or immutable.
Immutable collections cannot be changed.
That is, they only allow those operations that do not change the elements, such as accessing an element.
Immutability can be helpful when you want to store items together without allowing them to be modified in the future.
By using immutable collections, you can be sure that the contents of the collection will not change over time.
For example, you may have a list of pages in a book that cannot be changed.
Mutable collections also let you access the elements, but in addition,
they allow operations that change the content of a collection by adding, removing, or updating the stored items.
For example, you may have a collection of favourite restaurants that can change over time.

Kotlin Standard Library provides the implementation for the basic types of collections: list, set, and map.
All three exist in mutable and immutable variations. Before we consider each type in detail, let's have a quick overview.
List stores elements in a specified order and provides indexed access to them.
List is an immutable collection.
Its size cannot be changed after it is initialized.
This type allows duplicates and stores elements in a specific order.
List is a container that keeps the elements of a given type in the same order in which they were added.
Set stores unique elements whose order is generally undefined.
Map stores key-value pairs (entries); keys are unique, but different keys can be paired with equal values.

So, if you want to store items in the order of their insertion, and it doesn't matter to you that they can be repeated,
use List. For example, you could store student rating history in a List.

The difference between List and Set is that the latter does not allow duplicates: all elements in a Set are unique.
So, if you try to add an already existing element to a set, you will simply overwrite it.
Also, Set does not maintain the order. So, if you don't want to have duplicates and the order doesn't really matter,
Set is the best option.
For example, you could use Set to collect the names of your favourite restaurants or people you invited to your party.

Finally, Map stores elements as key-value pairs.
Each key is assigned a specific value that you set.
Map does not allow duplicate keys but allows duplicate values.
If you try to add a new key-value pair and the key is already present in the current map,
you will simply overwrite its value. Similarly to Set, Map does not store elements in the order they were inserted.
If you want to store key-value pairs, Map is the best option for you.
For example, you could store people's names as keys and their job titles as values.

Last but not least: you can combine different types in a collection if your task requires it.
That's why we refer to Kotlin collections as generic.

Common properties and methods for collections
As you can see, collections are quite different in structure and application.
However, there are properties and methods that can be used with any collection:
size returns the size of your collection.

contains(element) checks if the element is in your collection.

containsAll(elements) checks if all elements of the collection elements are in your collection.

isEmpty() shows whether the collection is empty or not.

joinToString() converts the collection to a string.

indexOf(element) returns the index of the first entry of the element, or -1 if the element is not in the collection.

In addition, all mutable collections have some common methods. You can use them with any mutable collection,
but they cannot be used with an immutable collection:

clear() removes all elements from the collection.

remove(element) removes the first occurrence of an element from your collection.

removeAll(elements) removes from your collection all elements contained in the collection elements.

add(element) adds an element to your collection.

addAll(elements) adds all elements of the collection elements to your collection.

addAll(index, elements) adds all elements of the collection elements to your collection at the specified index.

set(index, element) replaces the element at the specified index.

setAll(index, elements) replaces all elements of the collection elements at the specified index with the elements of the collection elements.

removeAt(index) removes the element at the specified index.

elementAt(index) returns the element at the specified index.

elementAtOrNull(index) returns the element at the specified index or null if the index is out of bounds.

elementAtOrElse(index, defaultValue) returns the element at the specified index or the default value if the index is out of bounds.

elementAtOrNull(index) returns the element at the specified index or null if the index is out of bounds.

Idiom
Another way to check if an item is contained in a collection is to use the keyword in.
You may have already seen this if you've studied ranges.
If not, no problem – it works just like the contains() function. Look at the example:

val collection = listOf(1, 2, 3, 4, 5)
println(elem in collection)
println(collection.contains(elem))
As you can see, the in keyword makes code easier to read.
You should use in instead of contains(), as it is recommended in the documentation on kotlinlang.org.


 */
/*
Anna has a home robot.
She sent it to the store and provided with a list of purchases in the form of a Map with key as the name of the product
and value as the number of items to be purchased.
However, later Anna decided to send an additional list of purchases (another Map) to the robot.
Write a function helpingTheRobot that combines the two purchase lists into one and returns it as the result.
If both lists contain the same product, its quantity in the final MutableMap must be the total value from both lists.

Tip: You can just use the addition operator: map[key] = a + b

Input: purchases: Map<String, Int>, addition: Map<String, Int>
Output: resulting MutableMap<String, Int>.

Sample Input:
purchases: {"bread" to 1, "potatoes" to 7, "milk" to 2}
addition: {"milk" to 1, "water" to 3}

Sample Result:
{bread=1, potatoes=7, milk=3, water=3}
 */

/*
fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>) : MutableMap<String, Int> {

	val result = mutableMapOf<String, Int>()
	for ((key, value) in purchases) {
		result[key] = value
	}
	for ((key, value) in addition) {
		result[key] = result.getOrDefault(key, 0) + value
	}
return result
}
*/
// another solution using apply and merge which I haven't learned yet
// what is ak?
/*
addition is a collection (e.g., a list, set, or map) over which the forEach function is being called.
{ ak -> merge(ak.key, ak.value, Int::plus) }
is a lambda expression that takes an element from the addition collection as its argument
and performs the merge operation using the key and value from ak.
So, ak is just a variable name chosen to represent each element of the addition collection as it is being iterated over.
It's a common practice to choose meaningful variable names,
but the specific name ak is not a built-in keyword or special identifier in Kotlin.
It could have been named something else, such as entry, pair, or any other valid variable name.
 */
/*
fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>): MutableMap<String, Int> {
	// write your code here
	return purchases.toMutableMap().apply { addition.forEach { ak -> merge(ak.key, ak.value, Int::plus) } }
}
*/

/*
Given a string of numbers separated by commas, create a MutableList out of these numbers and find the third smallest element.
Assume that the input string always has at least three distinct numbers. Return the third smallest number.

import java.util.*

fun thirdSmallest(numbers: String): Int {
	// Step 1: Initialize MutableList and populate it
	var numberList: MutableList<Int> = mutableListOf()
	numberList = numbers.split(",").map { it.toInt() }.toMutableList()

	// Step 2: Sort the MutableList
	// Your code goes here
	numberList.sort()

	// Step 3: Return the third smallest number
	// Your code goes here
	return numberList[2]
}

fun main(args: Array<String>) {
	// Get input string from user
	val input = readLine()!!

	// Call the thirdSmallest method and print the output
	println(thirdSmallest(input))
}

fun thirdSmallest(numbers: String) =
	numbers.split(",")
		.map { it.toInt() }
		.sorted()[2]

fun main(args: Array<String>) {
	readln()
		.let { thirdSmallest(it) }
		.also { println(it) }
}

fun solution(elements: MutableList<String>, index: Int): MutableList<String> {
	elements.removeAt(index)
	return elements
}
*/