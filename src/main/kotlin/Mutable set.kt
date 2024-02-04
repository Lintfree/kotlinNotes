/*
MutableSet is an unordered collection of elements that does not allow duplicates.
Unlike Set which is an immutable collection, MutableSet is mutable or modifiable: you can freely add and remove elements.

Imagine you're making a list of groceries you need to buy:
val groceries = setOf("Banana", "Strawberry")
println(groceries) // [Banana, Strawberry]

But what if you remembered something later and need to add more elements?
This is exactly the kind of situation where MutableSet is useful. MutableSet supports the addition of elements:
val groceries = mutableSetOf("Banana", "Strawberry")
groceries.add("Water")
println(groceries) // [Banana, Strawberry, Water]

You might ask: why not just use a MutableList? The MutableList unlike MutableSet allows you to have duplicates:
val groceries = mutableSetOf("Banana", "Banana", "Strawberry")
println(groceries) // [Banana, Strawberry]
val secondGroceries = mutableListOf("Banana", "Banana", "Strawberry")
println(secondGroceries) // [Banana, Banana, Strawberry]

Creating a MutableSet
You can initialize MutableSet the following way:
val students = mutableSetOf("Joe", "Elena", "Bob")
println(students) // [Joe, Elena, Bob]

Here, we didn't even need to specify the type for our objects because it can be derived from the context.
However, note that if you create an empty MutableSet, you do have to specify the type:
val points = mutableSetOf<Int>()
println(points) // []

You can also transform Set into a MutableSet with the help of the function toMutableSet():
val students = setOf("Joe", "Elena", "Bob").toMutableSet()
students.add("Bob")
println(students) // [Joe, Elena, Bob]

Adding elements
MutableSet has the same properties and methods as Set:
size, isEmpty(), indexOf(element), contains(element), first(), last(), and so on.

Also, MutableSet offers additional functionality for changing the contents:
add(element) is a method that adds the specified element to the set;
addAll(elements) adds all the elements of the specified collection to the set.

Let's take a look at an example.
Imagine that you're working in a pair with your colleague, and your task is writing down the recorded words quickly and correctly.
You decide to transcribe together and then combine the results, and here is how it goes:
val words = mutableSetOf<String>("Apple", "Coke")
val friendsWords = mutableSetOf<String>("Banana", "Coke")
words.add("Phone")
words.add("Controller")
friendsWords.add("Phone")
friendsWords.add("Pasta")
friendsWords.add("Pizza")
words.addAll(friendsWords)
println(words) // [Apple, Coke, Phone, Controller, Banana, Pasta, Pizza]

Removing elements
You might also need to remove some or all of the elements from your set. Let's see how this can be done.
remove(element) removes the specified element;
clear() removes all the elements from the current collection;
removeAll(elements) removes all the elements that are also contained in the specified collection (see the example below).

val groceries = mutableSetOf("Apple", "Water", "Banana", "Pen")
groceries.remove("Apple")
println(groceries) // [Water, Banana, Pen]

val uselessGroceries = setOf("Banana", "Pen")
groceries.removeAll(uselessGroceries)
println(groceries) // [Water]

groceries.clear()
println(groceries) // []

Of course, there are many other useful MutableSet methods: check out kotlinlang.org and get familiar with them!

Iterating through elements
You can iterate through the elements of a MutableSet with the help of the for loop. Here is a simple example:
val places = mutableSetOf("Saint-Petersburg", "Moscow", "Grodno", "Rome")
for (place in places) {
    println(place)
}

// Saint-Petersburg
// Moscow
// Grodno
// Rome
 */

/*
Complete the evenFilter() function that takes a Set of Int and returns a new set containing only the even elements from that set.
Don't use the += operator: work with MutableSet because it is faster than reassigning.
 */

/*
fun evenFilter(numbers: Set<Int>): Set<Int> {
	val evenNumbers = mutableSetOf<Int>()
	for (number in numbers) {
		if (number % 2 == 0) {
			evenNumbers.add(number)
		}
	}
	return evenNumbers
}

 */

//alternative solution with filter but problem wanted to work with MutableSet
//fun evenFilter(numbers: Set<Int>): Set<Int> {
	//return numbers.filter { it % 2 == 0 }.toSet()
//}
/*
// Don't like the next solution?
A bitwise AND operation is a binary operation that takes two equal-length binary representations
and performs the logical AND operation on each pair of corresponding bits.
The result in each position is 1 if both bits are 1; otherwise, the result is 0.
true = 1, false = 0
For example:

Bitwise AND of 5 (binary 0101) and 3 (binary 0011) yields 1 (binary 0001).
Bitwise AND of 7 (binary 0111) and 2 (binary 0010) yields 2 (binary 0010).
In Kotlin, the bitwise AND operation is represented by the and infix function,
which can be used to perform the bitwise AND operation on two integer values.
 */

//fun evenFilter(numbers: Set<Int>): Set<Int> {
	//return numbers.filter { it.and(1).equals(0) }.toSet()
//}
