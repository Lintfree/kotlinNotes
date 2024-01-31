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
/*
fun main() {
	val longs = mutableListOf<Long>(100_000_000_001, 100_000_000_002, 100_000_000_003)

	println(longs.joinToString())

	val words = ("first", "second", "third")
	val isListContainsThirdWord = words.contains("third")
	val listSize = words.size // 3

	words.add ("fourth")
	println("List contains 'third': $isListContainsThirdWord")
	println("List size before adding a new word: $listSize")
	println("List size after adding a new word: ${words.size}")

	val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
	val n = 6 // 6th element
	val elem = list[list[n]] //find n first [] then take that num and then find that num in the list = 6
}

	Outputting a list
	The first function is joinToString(). It helps us output our list in different ways using the separator attribute.

	Use joinToString() to see the resulting list and print its contents:

	val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
	println(southernCross.joinToString())   //  Acrux, Gacrux, Imai, Mimosa

	Remember that joinToString() takes elements from a mutable list in the order in which they are stored
	and presents them as a comma-delimited string line.

	You can also use another delimiter to separate elements :

	println(southernCross.joinToString(" -> "))   //  A

	Working with multiple lists
	Now, let’s look at a couple of things you might want to know about when working with several string lists.

	Mutable lists can be joined.

	You can concatenate several lists as shown in the following example:

	val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
	val stars = mutableListOf("Ginan", "Mu Crucis")

	val newList = southernCross + stars
	println(newList.joinToString())    //  Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis

	Mutable lists can be compared.

	You can use the operators == and != to compare lists – their contents and sizes:

	val firstList = mutableListOf("result", "is", "true")
	val secondList = mutableListOf("result", "is", "true")
	val thirdList = mutableListOf("result")

	println(firstList == secondList)  //  true
	println(firstList == thirdList)   //  false
	println(secondList != thirdList)  //  true
	Note that true is returned only if the elements of the two lists match completely and are arranged in the same order.

	Changing the list contents
	The keywords val and var tell you how the value/reference of a variable should be handled.

	var – the value/reference assigned to a variable can be changed at any time.
	val – the value/reference can be assigned to a variable only once and cannot be changed later during the execution.

	No matter which keyword you're using, val or var, you can still edit the values of the existing elements through their index.
	This is possible because when we change the contents of a list, we do not create a new list (the link to the list is not changed):

	val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
	var stars = mutableListOf("Ginan", "Mu Crucis")
	southernCross[1] = "star"
	stars[1] = "star"

	println(southernCross[1]) // star
	println(stars[1]) // star
	There are ways to remove list elements and add new elements to the list.

	You can use the functions add, remove, and clear to change lists:

	val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
	val stars = mutableListOf("Ginan", "Mu Crucis")
	val names = mutableListOf("Jack", "John", "Katie")
	val food = mutableListOf("Bread", "Cheese", "Meat")
	val fruits = mutableListOf("Apple", "Banana", "Grape", "Mango")

	southernCross.removeAt(0)
	southernCross.remove("Mimosa")

	stars.add("New star")
	stars.add(0, "First star")// add new items at any position in the list

	names.clear() // deletes all elements from the list

	food.addAll(fruits)

	println(names) // []
	println(southernCross.joinToString()) // Gacrux, Imai
	println(stars.joinToString()) // First star, Ginan, Mu Crucis, New star
	println(food.joinToString()) // Bread, Cheese, Meat, Apple, Banana, Grape, Mango

	add(element) and add(index, element) insert new items at any position in the list.
	If you don't specify the index, the item will be added to the end of the list.

	list1.addAll(list2) adds all elements from list2 to the end of the list1.

	remove(element) and removeAt(index) delete an item from the list.
	The former function deletes a single instance of the specified element from the list
	(it returns true if the item was successfully removed, otherwise it returns false).
	The latter function deletes the element at the specified position and returns the element that has been removed.

	clear() deletes all elements from the list.

	Also, you can use += to add new elements to the list:

	val vowels = mutableListOf('a', 'o', 'i', 'e', 'u')
	val intList1 = mutableListOf(1, 2, 3, 4, 5)
	val intList2 = mutableListOf(5, 4, 3, 2, 1)

	vowels += 'y'
	intList1 += intList2

	println(vowels)   // [a, o, i, e, u, y]
	println(intList1) // [1, 2, 3, 4, 5, 5, 4, 3, 2, 1]

	Copy list content
	Kotlin doesn't have any functions to copy existing lists. However, you can do it using the toMutableList() function:

	val list = mutableListOf(1, 2, 3, 4, 5)
	val copyList = list.toMutableList()

	print(copyList) // [1, 2, 3, 4, 5]

	This function creates a new MutableList and adds the contents of list to the new list. It works like this:

	val list = mutableListOf(1, 2, 3, 4, 5)
	val copyList = mutableListOf<Int>()
	copyList.addAll(list)

	print(copyList) // [1, 2, 3, 4, 5]

	There are some operations that can be really useful when you work with lists and their contents:

	list.isEmpty() and list.isNotEmpty() – check whether the list is empty.

	list.subList(from, to) – creates a smaller list (sublist),
	which includes items of the original list with the following indexes: from, from + 1, ..., to - 2, to - 1.
	The element with the index to is not included.

	val numbers = mutableListOf(1, 2, 3, 4, 5)
	var sublist = mutableListOf<Int>()
	if (numbers.isNotEmpty() && numbers.size >= 4) {
     sublist = numbers.subList(1, 4)
	}

	print(sublist) // [2, 3, 4]

	list.indexOf(element) – searches for the index of an element in the list.
	The result of this function is -1 if there is no such element in the list.
	Otherwise, when we access the list by the calculated index, we get the element.

	val numbers = mutableListOf(1, 2, 3, 4, 5)

	if (5 in numbers) { // true
    println(numbers.indexOf(5)) // 4
	}

	print(numbers.indexOf(7)) // -1  // 7 is not in the list
	list.minOrNull() and list.maxOrNull() – search for the minimum and maximum elements in the list.

	list.sum() – returns the sum of the elements in the list.

	list.sorted() and list.sortedDescending() – build a sorted list (ascending or descending) from the available list.

	val numbers = mutableListOf(1, 2, 3, 4, 5)

	val vowels = mutableListOf('e', 'a', 'y', 'i', 'u', 'o')

	println(numbers.minOrNull()) // 1
	println(numbers.maxOrNull()) // 5
	println(numbers.sum())      // 15

	println(vowels.sorted()) // [a, e, i, o, u, y]
	println(vowels.sortedDescending()) // [y, u, o, i, e, a]

	Iterating through a MutableList
	The simplest way to process each mutable list element is to use the following template:

	for (element in mutList) {
    // body of loop
	}
	Suppose we have a mutable list that includes weekdays. Let's print each day of the week:

	fun main() {
        val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

        for (day in daysOfWeek){
        println(day)
        }
	}
	After that, the program will print the following:

	Sun
	Mon
	Tues
	Wed
	Thur
	Fri
	Sat
	In the same way, you can process a mutable list of integers, characters, or any other data type.

	Iterating by indexes
	It is possible to access elements by their index directly from the loop.
	To do that, you must use the mutList.indices property, which represents a range of valid mutList indexes.

	Take a look at the daysOfWeek mutable list:

	fun main() {
        val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

        for (index in daysOfWeek.indices){
            println("$index: ${daysOfWeek[index]}")
        }
	}
	The program will print the following:

	0: Sun
	1: Mon
	2: Tues
	3: Wed
	4: Thur
	5: Fri
	6: Sat

	We can also iterate through the list in reverse order:
	Iterating by range indexes
	We have discussed two ways of iterating through a mutable list.
	They are useful when you need to process each list element.
	Sometimes, however, you may need to access a particular sublist.
	In such a case, you can specify the range of the indexes you need.

	The first element of a mutable list always has index 0.

	Take a look at the program below:

	fun main() {
        val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

        for (index in 1..5) {
            println("$index: ${daysOfWeek[index]}")
        }
	}
	It will print only the workdays:

	1: Mon
	2: Tues
	3: Wed
	4: Thur
	5: Fri

	To use the last index of a mutable list in ranges, you need to access mutList.lastIndex. So, we can modify the code this way:

	for (index in 1 until daysOfWeek.lastIndex) {
        println("$index: ${daysOfWeek[index]}")
	}
	It displays the same days as before:

	1: Mon
	2: Tues
	3: Wed
	4: Thur
	5: Fri

	If you want to iterate through a mutable list in reverse order, use downTo in a range.
	You can also specify the offset between indexes using step.

	The program below will print days in reverse order with a step of 2:

	fun main() {
        val daysOfWeek = mutableListOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

        for (index in daysOfWeek.lastIndex downTo 0 step 2) {
            println("$index: ${daysOfWeek[index]}")
        }
	}
	Output:

	6: Sat
	4: Thur
	2: Tues
	0: Sun
	So, you can iterate through an entire mutable list or a part of it in both direct and reverse order with any step you need.

	Reading MutableList elements
	Some tasks require you to read mutable list elements from the input.

	For example, the program below reads integer numbers and prints them in reverse order.

	fun main() {
        val size = readln().toInt()
        val mutList: MutableList<Int> = mutableListOf()
        for (i in 0 until size) {
            mutList.add(readln().toInt())
        }

        for (i in mutList.lastIndex downTo 0) {
            print("${mutList[i]} ")
        }
	}
	Here is the input:

	5
	1
	2
	3
	4
	5
	The program will output the following:

	5 4 3 2 1
	You can use this program as a template for your own solutions.Working with multiple lists

	Let's recap: List is a collection. List has a lot of methods and properties out-of-the-box.
	You cannot make changes to the elements of a List because it is immutable. Now we will learn about its mutable twin brother.

	MutableList is another version of List.
	It allows duplicates and stores elements in a specific order.
	In contrast to List, MutableList is a mutable or modifiable collection that allows you to add and remove elements.

	Imagine you decided to keep a List of all the places you've been to:

	val places = listOf<String>("Paris", "Moscow", "Tokyo")
	println(places) // output: [Paris, Moscow, Tokyo]
	You keep travelling, and your most recent trip was to Saint Petersburg.
	You want to add it to your List of places, but there is a problem:
	you cannot add another item to the List because it is immutable. Y
	ou can do this by reassigning, but this is a slow and inefficient way:

	var places = listOf<String>("Paris", "Moscow", "Tokyo") // note var keyword
	places += "Saint-Petersburg" // reassignment, slow operation
	println(places) // output: [Paris, Moscow, Tokyo, Saint-Petersburg]
	This is where MutableList comes to our rescue.
	As we said before, MutableList supports adding elements. So, let's switch to MutableList and add one more element:

	val places = mutableListOf<String>("Paris", "Moscow", "Tokyo")
	places.add("Saint-Petersburg")
	println(places) // output: [Paris, Moscow, Tokyo, Saint-Petersburg

	Initializing
	Here is how you can initialize MutableList:

	val cars = mutableListOf("Ford", "Toyota", "Audi", "Mazda", "Tesla")
	println(cars) // output: [Ford, Toyota, Audi, Mazda, Tesla]
	That is it! Here, we didn't even need to specify the type for our objects because it can be derived from the context.
	However, note that if you create an empty MutableList, you do have to specify the type:

	val cars = mutableListOf<String>()
	println(cars) // output: []
	You can also transform List into a MutableList with the help of the function toMutableList():

	val cars = listOf("Ford", "Toyota").toMutableList()
	cars.add("Tesla")
	println(cars) // output: [Ford, Toyota, Tesla]

	Adding and replacing elements
	MutableList has the same properties and methods as List:
	size, get(index), isEmpty(), indexOf(element), contains(element), and so on.

	Since MutableList is special because it can be modified, it has additional functionality for changing the contents:

	add(element) is a method that adds an extra element to your list.

	set(index, element) replaces the element at the specified position with the specified element. Laconic form:
	mutableList[index] = element

	addAll(elements) adds all of the elements of the specified collection to the end of the list.

	Let's take a look at some examples. Imagine that you're about to go get groceries, so you're making a List of products you need:

	val products = listOf("Milk", "Cheese", "Coke")
	You had a change of heart: suddenly, you decided that you also need to get some chips, and maybe get water instead of milk.
	Let's update our list of products:

	val finalList = products.toMutableList()
	finalList.add("Chips")
	finalList[0] = "Water" // or finalList.set(0, "Water")
	println(finalList) // output: [Water, Cheese, Coke, Chips]
	Then, let's say your dad came in and gave you his grocery list. Okay, let's add these products to our list as well:

	val products = mutableListOf("Milk", "Cheese", "Coke")
	val dadsProducts = listOf("Banana", "Watermelon", "Apple")
	products.addAll(dadsProducts)

	println(products) // output: [Milk, Cheese, Coke, Banana, Watermelon, Apple]

	Removing elements
	You might also need to remove some or all elements from your list. Let's see how this can be done:

	removeAt(index) removes an element at a specified index.

	remove(element) remove the specified element.

	clear() removes all elements from the current collection.

	Let's go back to our grocery list.
	As you were getting dressed, you gradually realized that you actually had all this food in your fridge. One by one,
	you decided to clear your list of these products:

	val products = mutableListOf("Milk", "Cheese", "Coke")

	products.removeAt(0)
	println(products) // output: [Cheese, Coke]

	products.remove("Coke")
	println(products) // output: [Cheese]

	products.clear()
	println(products) // output: []
	This is not an exhaustive list of methods you can use. To learn about other MutableList methods, check out kotlinlang.org.

	Iterating through elements
	You can iterate through the elements in MutableList with the help of the for loop. Here is an example:

	val products = mutableListOf("Cheese", "Milk", "Coke")

	for (product in products) {
    println("$product")
	}

	// Cheese
	// Milk
	// Coke
	We iterated through our MutableList and printed the name of each product.

	fun solution(first: List<Int>, second: List<Int>): MutableList<Int> {
	val result = mutableListOf<Int>()
	result.addAll(first)
	result.addAll(second)
	return result
}
 */

/*Imagine that you have a wish list.
It's very long and you want all the listed items; however,
you can't buy the items with the price greater than limit.

Write a function makeMyWishList that returns a map with all the elements with the price lower than or equal to limit.

fun makeMyWishList(wishList: Map<String, Int>, limit: Int): MutableMap<String, Int> {

	val result = mutableMapOf<String, Int>()
	for ((key, value) in wishList) {
		if (value <= limit) {
			result[key] = value
		}
	}
	return result
}

fun makeMyWishList(wishList: Map<String, Int>, limit: Int) =
	wishList.filterValues { it <= limit }.toMutableMap()

 */

/*
Keys and values must be read on a new line each.
Input is over when the program receives the word "stop" instead of the next key. If the same key is entered more than one time, MutableMap must keep the value that was entered first.

Input: key: String, value: Int (on a new line), until the word "stop" is read.

Output: resulting MutableMap<String, Int>.

Sample Input 1:

Alice
88
John
92
Harry
60
stop
Sample Output 1:

{Alice=88, John=92, Harry=60}
Sample Input 2:

Alice
45
Alice
66
stop
Sample Output 2:

{Alice=45}
*/




fun main() {
	val studentsMarks = mutableMapOf<String, Int>()
	while (true) {
		val name = readln()
		if (name == "stop") {
			break
		}
		val mark = readln().toInt()
		studentsMarks.putIfAbsent(name, mark)
	}
	print (studentsMarks)
}