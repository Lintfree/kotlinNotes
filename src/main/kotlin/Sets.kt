/*
Set is an unordered collection of elements that does not allow duplicates.
It is an immutable collection, which means that its size and individual elements cannot be changed after the set is initialized.

Let's assume we want to record information about the customers of a café at the end of the working day.
Let's try to do it with the help of MutableList:
val visitors = mutableListOf<String>("Vlad", "Vanya", "Liza")
println(visitors) // output: [Vlad, Vanya, Liza]

Is MutableList really the best option for the task? First of all, anyone can change its contents:
visitors[2] = "Nina"
println(visitors) // output: [Vlad, Vanya, Nina]

Second, you could accidentally make a mistake and record a visitor twice:
val visitors = mutableListOf<String>("Vlad", "Vanya", "Liza", "Vanya")
println(visitors) // output: [Vlad, Vanya, Liza, Vanya]

Set can help us to solve this problem since Set is immutable, and it does not allow duplicate elements:
val visitors = setOf<String>("Vlad", "Vanya", "Liza", "Liza")
println(visitors) // output: [Vlad, Vanya, Liza]
We tried to create a Set with two identical elements, but since Set does not support duplicates,
we ended up with a set of unique elements only, which is exactly what we need! And of course,
Set is immutable, so no one will be able to mess with the contents.

Initialization
Set is a generic type. As you saw from the previous examples, you can initialize it with the help of setOf<E>,
where E is the type of elements contained in the set:

val languages = setOf<String>("English", "Russian", "Italian")
The type can also be derived from the context:
val languages = setOf("English", "Russian", "Italian")

If you need to initialize an empty set, you can use the method emptySet:
val numbers = emptySet<Int>()
println(numbers) // output: []

Another way of creating a set is to call a builder function buildSet():
val letters = setOf<Char>('b', 'c')

val set = buildSet<Char> {
    add('a')
    addAll(letters)
    add('d')
}
println(set) // output: [a, b, c, d]

Methods and properties
Let's see how the methods you already know work in Set.

First, let's see how to use isEmpty and size:
val visitors = setOf("Andrew", "Mike")

println("How many people visited our cafe today? ${visitors.size}") // 2
println("Was our cafe empty today? It's ${visitors.isEmpty()}") // Was our cafe empty today? It's false

indexOf(element) and contains work in the following way:
val visitors = setOf("Paula", "Tanya", "Julia")
println("Is it true that Tanya came? It's ${visitors.contains("Tanya")}") // Is it true that Tanya came? It's true
println("And what is her index? ${visitors.indexOf("Tanya")}" ) // And her index is 1

If you want to know who was your first or last customer of the day, that is, which element is in the first/last position,
you can use the methods first() and last(). These methods are not very useful since the set is an unordered collection.
val students = setOf("Bob", "Larry")
println(students.first()) // Bob
println(students.last()) // Larry

Use joinToString() to convert a Set to string, for example:
val visitors = setOf("Paula", "Tanya", "Julia")
val joinToString = visitors.joinToString()
println(joinToString) // Paula, Tanya, Julia

If you want to check that all elements from a specific collection are contained in a Set, use the containsAll(elements) method:
val studentsOfAGroup = setOf("Bob", "Larry", "Vlad")
val studentsInClass = setOf("Vlad")
println("Are all the students in the group in class today? It's ${studentsInClass.containsAll(studentsOfAGroup)}")
// Are all the students in the group in class today? It's false

If you want to add two sets together, simply use the "+" operator, or "-" operator
if you want to subtract one from the other. Note that after adding or subtracting, you will get a new set:
val productsList1 = setOf("Banana", "Lime", "Strawberry")
val productsList2 = setOf("Strawberry")
val finalProductsList1 = productsList1 + productsList2
println(finalProductsList1) // [Banana, Lime, Strawberry]
val finalProductsList2 = productsList1 - productsList2
println(finalProductsList2) // [Banana, Lime]

Got a MutableList and want to convert it to Set? Not a big deal, use toSet()method:
val groceries = mutableListOf("Pen", "Pineapple", "Apple", "Super Pen", "Apple", "Pen")
println(groceries.toSet()) // [Pen, Pineapple, Apple, Super Pen]

Iterating through elements
You can iterate through the elements in the Set with the help of the for loop. Let's see an example:

val visitors = setOf("Vlad", "Liza", "Vanya", "Nina")
for (visitor in visitors) {
    println("Hello $visitor!")
}
// output:
// Hello Vlad!
// Hello Liza!
// Hello Vanya!
// Hello Nina!

fun solution(first: Set<String>, second: MutableList<String>): Boolean {
	return first.containsAll(second)
}

fun solution(numbers1: Set<Int>, numbers2: Set<Int>): Int {
	return (numbers1 - numbers2).size
}
fun solution(numbers1: Set<Int>, numbers2: Set<Int>): Int = (numbers1 - numbers2).size

fun solution(first: Set<String>, second: Set<String>): Set<String> {
return (first + second)
}


// repeat, add, contains
fun main() {
	val n = readln().toInt()
	val numbers = buildSet< Int> {repeat(n) { add(readln().toInt()) } }
	var num = 0
	val m = readln().toInt()
	if (numbers.contains(m)) {
		println("YES")
	} else {
		println("NO")
	}
}
easy conversion
fun intsToSet(ints: MutableList<Int>): Set<Int> = ints.toSet()
fun intsToSet(ints: List<Int>): Set<Int> = ints.toSet()
 */
/*

In Kotlin, a set is a collection that contains unique elements.
It does not allow duplicate elements, and the order of elements is not guaranteed.
Sets are commonly used to store a collection of distinct items or to perform set operations such as
union, intersection, and difference.



You are given a MutableSet of integers and an integer as input.
Check if the given integer is present in the MutableSet.
If so, return an empty Set. If not, just return the same set.
 */

/*
fun solution(elements: MutableSet<Int>, element: Int): MutableSet<Int> {
	var setOrClear = mutableSetOf<Int>()
	setOrClear = elements
	if (element in elements) {
		setOrClear.clear()
	}
	return setOrClear
}
*/
// refactored/simplified
/*
fun solution(elements: MutableSet<Int>, element: Int) =
    if (elements.contains(element)) { mutableSetOf<Int>() } else { elements }

   fun updateSet(elements: MutableSet<Int>, element: Int): MutableSet<Int> {
    val updatedSet = elements.toMutableSet()
    if (element in elements) {
        updatedSet.clear()
    }
    return updatedSet
}


 */

/*
size returns the number of elements in the current collection.
size = list.size
size = set.size
size = map.size

clear() removes all elements from the current collection.
cl = set.clear()
cl = list.clear()
cl = map.clear()

sublist() returns a new list with the specified range of elements.
sub = list.subList(1, 3) can only be used with lists.


isEmpty() returns true if the current collection is empty.
isEmpty = set.isEmpty()
isEmpty = list.isEmpty()
isEmpty = map.isEmpty()

put() adds an element to the current collection.
put = map.put() can only be used with maps

add() adds an element to the current collection.
add = list.add()
add = set.add()
the add function is specific to mutable list and set collections
such as MutableList, ArrayList, and LinkedList in Kotlin.
It is used to add an element to the end of the list.
This function is not available for MutableMap.
*/

/*
Your friends made presents for your birthday,
but they just numbered them without signing their names.
The most desirable presents are from Alice and Victor,
so you want to know which gifts are from them.
Write a function findByIndex(names: Set<String>): String
and return the numbers of Alice's and Victor's presents separated by a comma and a space.

Sample input:

Ann, Alice, Bonny, Victor, Tom

Sample output:

1, 3
*/

fun findByIndex(names: Set<String>): String {
return (names.indexOf("Alice")).toString() + ", " + (names.indexOf("Victor")).toString()
}
//fun findByIndex(names: Set<String>) = "${names.indexOf("Alice")}, ${names.indexOf("Victor")}"

//Your function receives two sets of Int.
// Return a new set of elements in the first set that are multiples of the size of the second set.
//Sample Input:
//10 11 14 16 2 1
//2 1
//Sample Output:
//10 14 16 2

fun solution(first: Set<Int>, second: Set<Int>): Set<Int> {
	// put your code here
	return first.filter { it % second.size == 0 }.toSet()
}
/*In the given function, second.size returns the number of elements in the second set.
It is used to check if an element in the first set is divisible by the number of elements in the second set.
 */