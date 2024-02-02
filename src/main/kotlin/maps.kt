/*
*Map collection
A Map is an immutable collection that holds pairs of objects (keys and values) and supports efficiently retrieving values corresponding to each key.
* As you remember, immutable implies that the size and content of the collection cannot be changed once it's initialized.
* It's important to remember that Map keys are unique: in other words, a Map can hold only one value for each individual key.

Imagine you are helping a school write a program that keeps track of the students' grades.
* Your current task is to save information about the students and their final grade (on a scale from 1 to 5). Let's do it with the help of Map:

val students = mapOf(
   "Zhenya" to 5,
   "Vlad" to 4,
   "Nina" to 5
)
println(students) // output: {Zhenya=5, Vlad=4, Nina=5}
But why use Map? Couldn't we achieve the same result with the help of a MutableList?
* Well, we could. For this, we would actually need two lists: one for the keys and another for their values:

val studentsName = mutableListOf("Zhenya", "Vlad", "Nina")
val studentsMarks = mutableListOf(5, 4, 5)
println("${studentsName[0]}=${studentsMarks[0]}, ${studentsName[1]}=${studentsMarks[1]}, ${studentsName[2]}=${studentsMarks[2]}")
// output: Zhenya=5, Vlad=4, Nina=5
*
It stores fine, but what if we need to check, for example, Nina's grade? If we were using a MutableList,
* we would need to iterate through each element and find out what position Nina is in.

On the other hand, if we use Map, we can very easily get the value corresponding to the key. Let's see how that works:

val grade = students["Nina"]
println("Nina's grade is: $grade") // output: Nina's grade is: 5
*
*  Map element
An entry in a Map is represented by the special Pair type designated for generic pairs of two values. Let's see an example:

val (name, grade) = Pair("Zhenya", 5) // easy way to get the first and the second values
println("Student name is: $name And their grade is: $grade")
// output: Student name is: Zhenya And their grade is: 5
*
Another way to take access to the elements of Pair is the .first and the .second .
* It's quite wordy, so you should use the () statement. Take a look:

val p = Pair(2, 3)
println("${p.first} ${p.second}") // 2 3
val (first, second) = p
println("$first $second")         // 2 3
*
As you have probably noticed, we use the to construct to create an entry in the Map.
* Here, to is a simplified construct for creating a Pair:
*
val (name, grade) = "Vlad" to 4
println("Student name is: $name And their grade is: $grade")
// output: Student name is: Vlad And their grade is: 4
*
* Initialization
Map is a generic type. As you saw from the previous examples, you can initialize it this way:
* mapOf<K, V>(vararg pairs: Pair<K,V>), where K is the key type and V is the value type.

val staff = mapOf<String, Int>("John" to 1000)
*
The type can also be derived from the context:
val staff = mapOf("Mike" to 1500)
*
If you need to initialize an empty map, you can use the method emptyMap<K, V>:
val emptyStringToDoubleMap = emptyMap<String, Double>()
*
Another way of creating a map is to call a builder function buildMap():

val values = mapOf<String, Int>("Second" to 2, "Third" to 3)

val map = buildMap<String, Int> {
    put("First", 1)
    putAll(values)
    put("Fourth", 4)
}
println(map) // output: {First=1, Second=2, Third=3, Fourth=4}
*

Methods and properties
Let's look at some basic properties and methods of Map:

size gives the size of your Map.

isEmpty() shows whether the map is empty or not.

If you want to get an element by the key, do so as you would with a Mutablelist: use [key].
* You can also get an element using the get(key) construction. Both of these will return the value corresponding to the given key.

Say your help is also needed at the HR department. You have information about potential employees and the salaries they expect:

val employees = mapOf(
    "Mike" to 1500,
    "Jim" to 500,
    "Sara" to 1000
)
Let's say we need to know how many candidates there are and specifically check how much Mike wants to earn:

if (!employees.isEmpty()) {
    println("Number of employees: ${employees.size}")
    println("Mike wants to earn ${employees["Mike"]}")
}
Good! And what if we need to know whether Jim wants to be our employee? Let's use containsKey(key) and find it out:

val isWanted = employees.containsKey("Jim")
println("Does Jim want to be our employee? It's $isWanted")
Since the budget is tight, let's check if any candidate is willing to work for $500.
For this, we'll use the containsValue(value) method:

val isAnyoneWilling = employees.containsValue(500)
println("Is anyone willing to earn $500? It's $isAnyoneWilling")
*
* Iterating through elements
Let's see how you can iterate through the elements of a Map. You can use the for loop construction:

val employees = mapOf(
    "Mike" to 1500,
    "Jim" to 500,
    "Sara" to 1000
)

for (employee in employees)
    println("${employee.key} ${employee.value}")

for ((k, v) in employees)
    println("$k $v")
Both of these constructions will give you the same result:

// Mike 1500
// Jim 500
// Sara 1000
*
* Idioms
There are many idioms you can use to work with a Map collection. Even map creation has an idiom! As you can see,
* the Kotlin community approves of the concise way to initialize a Map:

val map = mapOf("a" to 1, "b" to 2, "c" to 3)
Another helpful idiom allows you to access elements. In the Map collection you can use a key to find the corresponding value.
* One way is the function get(key). This statement is a bit wordy, so it's best to just write [key]:

println(map.get("a")) // 1
println(map["b"])     // 2, idiomatic way
Last but not least, there's an idiom for iterating over a map. You almost always need to work with the keys and the values of map elements.
* So you can easily access all of them with this idiom:

for ((k, v) in map) {
    println("$k -> $v")
}
*
*
*In the store, all products are stored in a Map<String, Int>, which holds name - price pairs.
The customer comes with a shopping list and wants to know what the total price of products on the list will be.
* Keep in mind that some products may not be available in the store.

You are given Map<String, Int> (product name and price) and MutableList of String (shopping list) as the function parameters.
* Return the total price of the items the customer needs to buy.

Sample Input 1:
{Cola to 500}, {Apple to 1500}, {Banana to 300}
Cola Apple
Sample Output 1:
2000
*
Sample Input 2:
{Pen to 1}, {Ananas to 2}, {Sheet to 0}
Result is One or Zero
Sample Output 2:
0
*
Sample Input 3:
{Sprite to 150}, {Lays to 200}, {Milk to 600}, {Snickers to 100}
Sprite Lays Coffee
Sample Output 3:
350
*
* fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var total = 0
	for (item in shoppingList) {
		if (priceList.containsKey(item)) {
			total += priceList[item]!!
		}
	}
	return total
}

iterates over shoppingList and adds priceList[item] value to total

*
*or
* fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    return shoppingList.sumOf { priceList[it] ?: 0 }
}
*
* /*You are given three Strings as input.
// Create a Map using these strings.
// Use the String as the key, and its length as the value. Return the resulting Map.
//
//Sample Input 1:
//
//I love Kotlin
//Sample Output 1:
//
//{I to 1}, {love to 4}, {Kotlin to 6}
//Sample Input 2:
//
//Strings Ints Objects
//Sample Output 2:
//
//{Strings to 7}, {Ints to 4}, {Objects to 7}  */

fun stringToMap(first: String, second: String, third: String): Map<String, Int> {
	return mapOf(first to first.length, second to second.length, third to third.length)
}
the to keyword associates the value with the key


 /* Sum of values
You are given Map<Int, Int> as input. Return the sum of all values that have even keys.

Sample Input 1:

{100 to 10}, {55 to 3}, {112 to 5}
Sample Output 1:

15
Sample Input 2:

{1 to 2}, {10 to 5}
Sample Output 2:

5 */
fun summator(map: Map<Int, Int>): Int {
	var sum = 0
	for ((key, value) in map) {
		if (key % 2 == 0) {
			sum += value
		}
	}
	return sum
}

val map = buildMap<String, String> {
	put ("Apple" , "Green")
	put("Banana" , "Yellow")
	put("Strawberry" , "Red")
}
 */



