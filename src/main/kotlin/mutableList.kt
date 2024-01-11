/*
A MutableList is a collection capable of holding a list of elements and allows modification of its contents.
This implies that elements can be added, removed, or updated anytime.
This stands in contrast to an immutable list, which does not permit changes after its creation.

Key Differences:
Mutability:
MutableList lets you make changes after it's created.
The immutable list (for example, listOf) can only be read, not modified.

Functions:
MutableList includes functions such as add, remove, and clear.
These functions are not available for the immutable list.

Common Operations in Kotlin's MutableList
Kotlin's MutableList is a generic ordered collection of elements that supports adding, removing, and updating operations.

add: Adds an element to the list.
val list = mutableListOf(1, 2, 3)
list.add(4) // list becomes [1, 2, 3, 4]

add at index: Inserts an element at a specified index.
list.add(1, 5) // list becomes [1, 5, 2, 3, 4]

remove: Removes an element from the list.
list.remove(5) // list becomes [1, 2, 3, 4]

removeAt: Removes an element at a specified index.
list.removeAt(0) // list becomes [2, 3, 4]

set: Updates an element at a specified index.
list.set(1, 10) // list becomes [2, 10, 4]

clear: Removes all elements from the list.
list.clear() // list becomes []

Mutability in lists is a vital feature that enables dynamic alterations of the list's content.
In Kotlin, a MutableList is an interface that expands the List interface, including methods that alter the list,
like add, remove, and clear. Here's a demonstration of a MutableList at work:
val mutableList = mutableListOf(1, 2, 3) mutableList.add(4) // The list now contains [1, 2, 3, 4]

On the flipside, a read-only List in Kotlin does not permit such alterations:

You should utilize a MutableList when you anticipate the elements of your list to change over time.
This is especially handy when dealing with a collection of items of unknown size initially,
or when the list elements need frequent updates, additions, or removals according to the program logic.

In contrast, pick a read-only List when you're working with a specific set of elements that shouldn't change.
This immutability offers protection against unintended alterations, making your code less error-prone and simpler to comprehend.

Iteration
You can use a for loop to go through a MutableList:

val mutableList = mutableListOf("apple", "banana", "cherry")
for (item in mutableList) {
    println(item)
}

You also have the option to use the forEach method:
mutableList.forEach { item ->
    println(item)
}

Batch Operations
You can perform batch operations using functions like map, filter, and forEach.

val lengths = mutableList.map { it.length }
val longFruits = mutableList.filter { it.length > 5 }
mutableList.forEach { println(it.toUpperCase()) }

The map function modifies each element:
The filter function retains elements that fulfill a condition:
The forEach function carries out an action on each element:

Modifying Lists
You can modify elements in a batch using replaceAll. This requires API level 24 or higher on Android:
mutableList.replaceAll { it.toUpperCase() }

Keep in mind, batch operations like map and filter that transform the list,
yield a new list; they don't change the original MutableList.
 */

fun main() {
	val longs = mutableListOf<Long>(100_000_000_001, 100_000_000_002, 100_000_000_003)

	println(longs.joinToString())

	val words = ("first", "second", "third")
	val isListContainsThirdWord = words.contains("third")
	val listSize = words.size

	words.add ("fourth")
	println("List contains 'third': $isListContainsThirdWord")
	println("List size before adding a new word: $listSize")
	println("List size after adding a new word: ${words.size}")

	val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
	val n = 6
	val elem = list[list[n]] //find n first [] then take that num and then find that num in the list = 8
}