fun main() {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    // println("Program arguments: ${args.joinToString()}")

    /*
    read only variables with val
    mutable variables with var
    to assign a value, use the assignment operator =
    declare mutable variables only if necessary
     */
    println("Variables")
    val popcorn = 5    // There are 5 boxes of popcorn
    val hotdog = 7     // There are 7 hotdogs
    var customers = 10 // There are 10 customers in the queue

    println("there are $popcorn of popcorn")
    println("there are $hotdog hotdogs")
    println("there are $customers customers")
    println("some customers leave the queue")
    customers -= 1
    println("there are now $customers customers")
    //You can access variables and change by using string templates
    println("more people come in")
    println("there are ${customers + 1} customers") //sort of like nesting
    customers += 1
    println("there are ${customers - 2} customers")
    // notice the assignment operator in the  two string templates above do not change the value of the variable
    /* You can also use the +=, -=, *=, /=, and %= operators to change the value of a variable.
    For example, if you want to increase the number of customers by 3, you can use the += operator:
    */
    println("some more customers come in")
    println("there are ${customers + 3}")
    /* customers -= 2
    customers += 3              // Example of addition: 11
    println("there are now $customers customers")
    customers += 18             // Example of addition: 18
    println("there are now $customers customers")
    customers -= 15             // Example of subtraction: 15
    println("there are now $customers customers")
    customers *= 30             // Example of multiplication: 30
    customers /= 10             // Example of division: 10

    +=, -=, *=, /=, and %= are augmented assignment operators. For more information, see Augmented assignments.
    */

    // to declare a variable without initializing it, specify the type with :
    val z: Int

    // Variable initialized
    // Int not really necessary
    val d: Int = 3

    // Variable explicitly typed and initialized
    // String not really necessary
    val e: String = "hello"

    // Variables can be read because they have been initialized
    println(d) // 3
    println(e) // hello

    //To get the length of a string, use the length property:
    val language = "Kotlin"
    println(language.length) // 6
    println("The length of the string is " + language.length)

    val empty = ""
    println(empty.length) // 0

    /*
    To access the characters (elements) of a string, you must refer to the index number inside square brackets.
    String indexes start with 0. In the example below, we access the first and third element in txt:
     */
    val txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    println(txt[0]) // A
    println(txt[2]) // C

    //To get the first character of a string, use the first() function:
    println("The first character of the string is " + txt.first())
    println("The first character of the string is " + txt[0])

    // There are many string functions available, for example toUpperCase() and toLowerCase():
    println(txt.uppercase())
    println(txt.lowercase())

    //The compareTo(string) function compares two strings and returns 0 if both are equal:
    println(txt.compareTo("HELLO")) // otherwise returns a negative or positive number
    var txt2 = "HELLO" // valtxt initialized above
    println(txt.compareTo(txt2))

    //The endsWith(string) function returns true if the string ends with the specified string:
    println(txt.endsWith("Z")) // true

    //The startsWith(string) function returns true if the string starts with the specified string:
    println(txt.startsWith("A")) // true

    //The substring(startIndex, endIndex) function returns a substring from the specified start index to the end index:
    println(txt.substring(3, 6)) // CDE

    println("strings")
    println ("")

    // the first argument determines the output
    val stringPlusBoolean = "abc" + 10 + true
    println(stringPlusBoolean) // abc10true

    //If the first is an int then string an error will occur
    val code = "123" + 456 + "789"
    println(code) // 123456789

    //repeat
    print("Hello".repeat(4)) // HelloHelloHelloHello
    println("Eat. Sleep. Code.\n".repeat(7))


    //escape character in case you need to print out quotes, tabs, etc.
    // prints 'H' is the first letter of "Hello world!" string.
    println("\'H\' is the first letter of \"Hello world!\" string.")

    //raw string for a large amount of text
    //For these cases, you can use a raw string.
    // A raw string can contain newlines and any other characters.
    // You just need to wrap the text in triple quotes ("""):
    val largeString = """
    This is the house that Jack built.
      
    This is the malt that lay in the house that Jack built.
       
    This is the rat that ate the malt
    That lay in the house that Jack built.
       
    This is the cat
    That killed the rat that ate the malt
    That lay in the house that Jack built.
	""".trimIndent() // removes the first and the last lines and trims indents
    print(largeString)

    /*
    trim indent cuts off all the lines of the common minimal indent and removes the first and last lines if they are empty.
    This text prints:
    This is the house that Jack built.

    This is the malt that lay in the house that Jack built.

    This is the rat that ate the malt
    That lay in the house that Jack built.

    This is the cat
    That killed the rat that ate the malt
    That lay in the house that Jack built
     */

    //The split(delimeter) function splits a string into an array of substrings:
    val str = "one,two,three"
    val result = str.split(",")
    println(result) // [one, two, three]

    //The joinToString(delimeter) function joins the elements of an array into a string:
    val numbers1 = arrayOf(1, 2, 3)
    val joinedString = numbers1.joinToString()
    println(joinedString) // 1,2,3

    //The replace(old, new) function replaces all occurrences of the old string with the new string:
    val str2 = "one two three"
    val result2 = str2.replace(" ", "-")
    println(result2) // one-two-three

    //The joinToString(delimeter, prefix, postfix) function joins the elements of an array
    // into a string with a specified delimeter, prefix, and postfix:
    val numbers2 = arrayOf(1, 2, 3)
    val joinedString2 = numbers2.joinToString(", ", "[", "]")
    println(joinedString2) // [1, 2, 3]

    //The joinToString(delimeter, prefix, postfix, limit, truncated) function joins the elements of an array
    // into a string with a specified delimeter, prefix, and postfix, with a maximum number of elements,
    // and with a truncated string if the array contains more elements than the limit:
    val numbers3 = arrayOf(1, 2, 3, 4, 5)
    val joinedString3 = numbers3.joinToString(", ", "[", "]", 2, "...")
    println(joinedString3) // [1, 2, 3, ...]

    //The trim() function removes whitespace from both ends of a string:
    val str3 = "   hello   "
    val result3 = str3.trim()
    println(result3) // hello

    //Finding a string in a string
    val str4 = "The quick brown fox jumps over the lazy dog"
    val result4 = str4.indexOf("fox")
    println(result4) // 16

    // to find quotes in a string, use single quotes
    val result5 = str4.indexOf('\'')
    println(result5) // 43

    // String concatenation
    val result6 = "$str4 $str"
    //same as val result6 = str4 + " " + str
    println(result6) // The quick brown fox jumps over the lazy dog one,two,three

    println()
    println("Data Types listed in file")
    /* Kotlin has the following basic data types:
    Integers: Byte, Short, Int, Long
    To convert a numeric data type to another type, you must use one of the following functions:
    toByte(), toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble() or toChar():
    Floating-point numbers: Float, Double
    Characters: Char The Char data type is used to store a single character.
    A char value must be surrounded by single quotes, like 'A' or 'c':
    Unlike Java, you cannot use ASCII values to display certain characters.
    The value 66 would output a "B" in Java, but will generate an error in Kotlin:
    Booleans: Boolean
    Strings: String
    Unsigned integers: UByte, UShort, UInt, ULong
    Capitalization is important
    */

    println()
    println("Collections")
    /*
Collections:
Collection Types        Description
Lists                   Ordered collections of items
Sets                    Unordered collections of unique items
Maps                    Sets of key-value pairs where the keys are unique and map to only one value
*/
    println("Lists")
//read only list
    val numbers = listOf(1, 2, 3)
    println(numbers)

//mutable list with add and remove
    val numbersMutable = mutableListOf(1, 2, 3)
    numbersMutable.add(4)
    numbersMutable.remove(2)
    println(numbersMutable)

//casting turns a mutable list into a read only list
    val shapes: MutableList<String> = (mutableListOf("square", "circle", "triangle"))
    val shapesLocked: List<String> = shapes
    println(shapesLocked)

//Lists are ordered so to access an item, use the indexed operator [], items start at 0
    println(shapesLocked[0])
    println("The second shape in the list is ${shapesLocked[1]}")

//  To get the first or last item in a list, use the first() and last() functions
    println("The first shape in the list is ${shapesLocked.first()}")
    println("The last shape in the list is ${shapesLocked.last()}")
    /* first and last functions are examples of extension functions. To call these functions
    on an object, use the dot operator.
    */

//  To get the number of items in a list, use the count() function
    println("There are ${shapesLocked.count()} shapes in the list")

// To check if an item is in a list, use the contains() function
    println("The list contains a circle? ${shapesLocked.contains("circle")}")

// To check that an item is in a list, use the in operator
    println("The list contains a circle? ${"circle" in shapesLocked}")

//  To check that an item is not in a list, use the !in operator
    println("The list does not contain a circle? ${"circle" !in shapesLocked}")

//  To get the index of an item in a list, use the indexOf() function
    println("The index of the circle in the list is ${shapesLocked.indexOf("circle")}")

//  To get the last index of an item in a list, use the lastIndexOf() function
    println("The last index of the circle in the list is ${shapesLocked.lastIndexOf("circle")}")

//  To get the number of times an item appears in a list, use the count() function
    println("The number of times the circle appears in the list is ${shapesLocked.count { it == "circle" }}")

// To add or remove an item from a list, use the add() and remove() functions
    println(shapes)
    shapes.add("rectangle")
    shapes.remove("circle")
    println(shapes)

// To sort a list, use the sort() function
    shapes.sort()
    println(shapes)

// To reverse a list, use the reverse() function
    shapes.reverse()
    println(shapes)

// To shuffle a list, use the shuffle() function
    shapes.shuffle()
    println(shapes)

// To sort a list in descending order, use the sortDescending() function
    shapes.sortDescending()
    println(shapes)

// To remove all items from a list, use the clear() function
    shapes.clear()
    println(shapes)

// To create an empty list, use the emptyList() function
    val emptyList = emptyList<String>()
    println(emptyList)

// To create an empty mutable list, use the mutableListOf() function
    val emptyMutableList = mutableListOf<String>()
    println(emptyMutableList)
    println()
    println("Sets")
    /*
Sets are unordered collections of unique items and allow duplicate items
*/
    val readOnlyFruits = setOf("apple", "banana", "orange", "apple")
    println(readOnlyFruits)

//Mutable Set with explicit type declaration
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "orange", "apple")
    println(fruit)
//Because sets only contain unique elements, the duplicate items are dropped

//To add or remove an item from a set, use the add() and remove() functions
    fruit.add("grape")
    fruit.remove("apple")
    println(fruit)

// To prevent unwanted modification, obtain read only views of mutable sets
// by casting them to set.
    val fruitLocked: Set<String> = fruit
    println(fruitLocked)

//To get the number of items in a set, use the count() function
    println("There are ${fruitLocked.count()} fruits in the set")

//To check if an item is in a set, use the contains() function
    println("The set contains a banana? ${fruitLocked.contains("banana")}")

//To check that an item is in a set, use the in operator
    println("The set contains a banana? ${"banana" in fruitLocked}")

//To check that an item is not in a set, use the !in operator
    println("The set does not contain a banana? ${"banana" !in fruitLocked}")

//To get the index of an item in a set, use the indexOf() function
    println("The index of the banana in the set is ${fruitLocked.indexOf("orange")}")

//To get the last index of an item in a set, use the lastIndexOf() function
    println("The last index of the banana in the set is ${fruitLocked.lastIndexOf("orange")}")

// finding the smallest int in a list
// class SmallestIntegerFinder {
// fun findSmallestInt(nums: List<Int>) = nums.minOf { it }
// }
    println()
    println("Maps")

    /* Maps are unordered collections of key-value pairs
    Maps store items as key-value pairs. You access the value by referencing the key.
    You can imagine a map like a food menu. You can find the price (value), by finding the food (key) you want to eat.
    Maps are useful if you want to look up a value without using a numbered index, like in a list.
*/
    val readOnlyFruitMap = mapOf("apple" to 1, "banana" to 2, "orange" to 3, "apple" to 4)
    println(readOnlyFruitMap)

//Mutable Map with explicit type declaration
    val fruitMap: MutableMap<String, Int> =
        mutableMapOf("apple" to 1, "banana" to 2, "orange" to 3, "apple" to 4).apply {
            println(this)
        }
//Because maps only contain unique keys, the duplicate keys are dropped: apple

// To prevent unwanted modification, obtain read only views of mutable maps
// by casting them to map.
    val fruitMapLocked: Map<String, Int> = fruitMap
    println(fruitMapLocked)

//To access the value of a key in a map, use the get() function
    println(fruitMapLocked["banana"]) //or
    println("This is banana's price: ${fruitMapLocked["banana"]}")

//To add or remove a key-value pair from a map, use the put() and remove() functions
    val juicemenu: MutableMap<String, Int> =
        mutableMapOf("apple" to 100, "banana" to 200, "orange" to 300, "apple" to 400)
    println(juicemenu)
    juicemenu["grape"] = 500
    juicemenu.remove("apple")
    println(juicemenu)

//To check if a key is in a map, use the contains() function
    println("The map contains a banana? ${juicemenu.contains("banana")}")
    println("The map contains a kiwi? ${juicemenu.contains("kiwi")}")

//To check that a key is in a map, use the in operator
    println("The map contains a banana? ${"banana" in juicemenu}")
    println("The map contains a kiwi? ${"kiwi" in juicemenu}")

//To check that a key is not in a map, use the !in operator
    println("The map does not contain a banana? ${"banana" !in juicemenu}")
    println("The map does not contain a kiwi? ${"kiwi" !in juicemenu}")

//To get the keys in a map, use the keys() function
    println("The keys in the map are ${juicemenu.keys}")
    println(juicemenu.keys)

//To get the values in a map, use the values() function
    println("The values in the map are ${juicemenu.values}")
    println(juicemenu.values)

//To get the number of items in a map, use the count() function
    println("There are ${juicemenu.count()} items in the map")

//To get the smallest int in a map, use the minOf() function
// it refers to the values in the map juicemenu in this case
    println("The smallest int in the map is ${juicemenu.minOf { it.value }}")

//To get the largest int in a map, use the maxOf() function
    println("The largest int in the map is ${juicemenu.maxOf { it.value }}")

//To get the smallest string in a map, use the minOf() function
    println("The smallest string in the map is ${juicemenu.minOf { it.key }}")

//To get the largest string and value in a map, use the maxBy function
    println("The largest string in the map is ${juicemenu.maxByOrNull { it.key }}")
    println()

//Collections practice
//I did this way for exercise 1
    /*fun main() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        // Write your code here
        val green = greenNumbers.count()
        val red = redNumbers.count()
        val total = green + red
        println("Total of numbers =  $total")
    }

     */

//Better way
    /*
    fun main() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val total = greenNumbers.count() + redNumbers.count()
        println("Total of numbers =  $total")
    }
    */

//I did this way for exercise 2
    /*
    fun main() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested in SUPPORTED
        println("Support for $requested: $isSupported")
    }
    */

//Forgot to cast to uppercase
    /*
fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}
*/

    /*
    I did this way for exercise 3, forgot single quotes
    fun main() {
        val number2word = mapOf("one" to 1, "two" to 2, "three" to 3)
        val n = 2
        println("$n is spelt as ${number2word.[n]")
    }
    */

//Better way
    /*
    fun main() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        println("$n is spelt as '${number2word[n]}'")
        single quotes inside double quotes makes it a string and not a variable
    }
    */

    /* Comparison operators are used to compare two values, and returns a Boolean value: either true or false.
     * The following operators are used to compare two values:
     * == Equality operator
     * != Inequality operator
     * > Greater than
     * < Less than
     * >= Greater than or equal to
     * <= Less than or equal to
     */

    /* Logical operators are used to determine the logic between variables or values:
     * && AND
     * || OR
     * ! NOT
     */


    println("Conditionals")
//If you have to chose between two values, use the if statement
//If you have to choose between three values, use the when statement

    val i: Int
    val check = true

    if (check) {
        i = 1
    } else {
        i = 2
    }

    println(i)


// same as above but the val variable is integrated into the if statement
//val check = true  not used here because it is declared above
    val k: Int = if (check) {
        1
    } else {
        2
    }

    println(k)

//There is no ternary operator condition ? then : else in Kotlin.
// Instead, if can be used as an expression.
// When using if as an expression, there are no curly braces {}:
    val a = 1
    val b = 2

    println(if (a > b) a else b) // Returns a value: 2

//when
//Place the conditional expression within parentheses () and the actions to take within curly braces {}.
//Use -> in each branch to separate each condition from each action.
    val obj = "Hello"

    when (obj) {
        // Checks whether obj equals to "1"
        "1" -> println("One")
        // Checks whether obj equals to "Hello"
        "Hello" -> println("Greeting")
        // Default statement
        else -> println("Unknown")
    }


//If when is used as an expression, the else branch is mandatory,
// unless the compiler can detect that all possible cases are covered by the branch conditions.
//The previous example showed that when is useful for matching a variable.
// when is also useful when you need to check a chain of Boolean expressions:

    val temp = 18

    val description = when {
        // If temp < 0 is true, sets description to "very cold"
        temp < 0 -> "very cold"
        // If temp < 10 is true, sets description to "a bit cold"
        temp < 10 -> "a bit cold"
        // If temp < 20 is true, sets description to "warm"
        temp < 20 -> "warm"
        // Sets description to "hot" if no previous condition is satisfied
        else -> "hot"
    }
    println(description)

    println("Ranges")
//To create a range, use the range function
//The most common way to create a range in Kotlin is to use the .. operator.
// For example, 1..4 is equivalent to 1, 2, 3, 4.
//To declare a range that doesn't include the end value, use the ..< operator.
// For example, 1..<4 is equivalent to 1, 2, 3.
//To declare a range in reverse order, use downTo.
// For example, 4 downTo 1 is equivalent to 4, 3, 2, 1.
//To declare a range that increments in a step that isn't 1, use step and your desired increment value.
// For example, 1..5 step 2 is equivalent to 1, 3, 5.
//You can also do the same with Char ranges:
//'a'..'d' is equivalent to 'a', 'b', 'c', 'd'
//'z' downTo 's' step 2 is equivalent to 'z', 'x', 'v', 't'
    val range = 1..5
    println(range)
    println(1 in range)
    println(5 in range)
    println(6 in range)
    println(10 !in range)
    println()

    println("Loops")
//To loop through a range, use the for statement
    for (number in 1..5) {
        print(number)
    }
    println()

//Collections can also be iterated over by loops:
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    println()
    println("While loops")
    println()
//while can be used in two ways:
//
//To execute a code block while a conditional expression is true. (while)
//
//To execute the code block first and then check the conditional expression. (do-while)
//
//In the first use case (while):
//
//Declare the conditional expression for your while loop to continue within parentheses ().
//
//Add the action you want to complete within curly braces {}.
    var x = 0
    while (x < 5) {
        print(x)
        x++
    }
    print("\ndue to the variable above using print instead of println the next print statement will be on the same line \n")
    print("unless you add a new line using the backslash n character\n")
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }
    println(" ")
//In the second use case (do-while):
//
//Declare the conditional expression for your do-while loop to continue within parentheses ().
//
//Add the action you want to complete within curly braces {}.

    var cakesEaten2 = 0
    var cakesBaked = 0
    while (cakesEaten2 < 3) { // this runs first
        println("Eat a cake")
        cakesEaten2++
    }
    do { // this runs third
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < cakesEaten) // this runs second

    /*
Exercise 1 Conditionals
My answer is correct but there is a better way
fun main() {
val button = "A"
when(button){
"A" -> println("Yes")
"B" -> println("No")
"X" -> println("Menu")
"Y" -> println("Nothing")
else -> println("There is no such button")
}
}
Better way
Example solution
fun main() {
val button = "A"

println(
    when (button) {
        "A" -> "Yes"
        "B" -> "No"
        "X" -> "Menu"
        "Y" -> "Nothing"
        else -> "There is no such button"
    }
)
}
 */

    var pizzaSlices = 0
    var wholePizza = 8

    while (pizzaSlices < wholePizza) {
        do {
            println("There are $pizzaSlices slice/s of pizza")
            pizzaSlices++
            wholePizza--
        } while (wholePizza > 0)
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")

    }
    println()
    /*
2 Better ways

fun main() {
var pizzaSlices = 0
while ( pizzaSlices < 7 ) {
    pizzaSlices++
    println("There's only $pizzaSlices slice/s of pizza :(")
}
pizzaSlices++
println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

fun main() {
var pizzaSlices = 0
pizzaSlices++
do {
    println("There's only $pizzaSlices slice/s of pizza :(")
    pizzaSlices++
} while ( pizzaSlices < 8 )
println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}
 */

    for(number in 1..100){
        when {
            number % 3 == 0 && number % 5 == 0 -> println("fizzbuzz")
            number % 3 == 0 -> println("fizz")
            number % 5 == 0 -> println("buzz")
            else -> println(number)
        }
    }
    println()
    println("or shorter version kotlin style")
    println()

    for (number in 1..100) {
        println(
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> number.toString()
            }
        )
    }

//exercise 4
//my way looks like C
    val words = listOf("dinosaur", "limousine", "magazine", "language")
// Write your code here
    for (word in words) {
        if (word[0] == 'l') {
            println(word)
        }
    }
    println()
    println("or shorter version kotlin style")
    println()

    for (w in words) {
        if (w.startsWith("l"))
            println(w)
    }
    println()
    println("Functions")
    /*
function parameters are written within parentheses ().

each parameter must have a type, and multiple parameters must be separated by commas ,.

the return type is written after the function's parentheses (), separated by a colon :.

the body of a function is written within curly braces {}.

the return keyword is used to exit or return something from a function.

If a function doesn't return anything useful, the return type and return keyword can be omitted. Learn more about this in Functions without return.

In the following example:

x and y are function parameters.

x and y have type Int.

the function's return type is Int.

the function returns a sum of x and y when called.
*/

    fun sum(x: Int, y: Int): Int {
        return x + y
    }

    fun sum2(x: Int, y: Int) = x + y

    // The break statement is used to jump out of a loop.
    // The continue statement is used to jump to the next iteration of a loop.

    fun main() {
        var i = 0
        while (i < 10) {
            i++
            if (i == 5) {
                break
            }
            println(i)
        }
        println()
        println("continue")
        println()
        var j = 0
        while (j < 10) {
            j++
            if (j == 5) {
                continue
            }
            println(j)
        }
    }
    /*code wars Create a method that accepts a list and an item,
        and returns true if the item belongs to the list, otherwise false.
        not all code here but you get the idea

    Basic tests here was the testing suite
    fun `Basic Tests`() {
        assertEquals(true, include(intArrayOf(1, 2, 3, 4), 2))
        assertEquals(false, include(intArrayOf(1, 2, 4, 5), 3))
        assertEquals(true, include(intArrayOf(0, 1, 2, 3, 5, 8, 13, 2, 2, 2, 11), 0))
        assertEquals(false, include(intArrayOf(0, 1, 2, 3, 5, 8, 13, 2, 2, 2, 11), 14))
        assertEquals(false, include(intArrayOf(), 13))
    }
    This was the answer
    fun include(arr: IntArray, item: Int) = item in arr
    */

    /*
    val age: Int = 42  // this is correct for integer type not a String type
    Int age = 42  // invalid Kotlin syntax
    val age = “42”: String  // invalid syntax, colon, and type should come right after the value name
    String age = “42”  // valid in Java but not in Kotlin
    var age = 42  // var is used here not val, and age is of type Int, not a String
    val age: String = “42”  // correct syntax, although not mandatory we can explicitly declare the type
    val age: Char = ‘42’  // '42' is not Char type, in fact, it is not a valid type Kotlin knows about
     */
}