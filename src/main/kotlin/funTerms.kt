/*fun main() {

    printMessagef("Hello")                                               // 5
    printMessageWithPrefixf("Hello", "Log")                              // 6
    printMessageWithPrefixf("Hello")                                     // 7
    printMessageWithPrefixf(prefix = "Log", message = "Hello")           // 8
    println(sumf(1, 2))                                                  // 9
    println(multiply(2, 4))
    println(checkNumber(10))
    println(evenOrOdd(10))
    println(range1(10))
    println(range2())
    (1..3).toList().also(::println) //range3

    // Booleans
    println( 1 in 1 until 3) //range4 is 1 in 1 to 3  true
    println(3 in 1 until 3) //range5 is 3 in 1 to 3, false
    // Ranges in Kotlin use until to specify an exclusive upper bound,
    // meaning the end value is not included in the range.
    println(3 in 1..3) //range6 is 3 in 1..3 = true
    // .. is used to specify an inclusive upper bound, meaning the end value is included in the range.
    println(2 !in 1..3) //range7 is 2 not in 1..3 = false
    println('x' in 'a'..'z') //range8 char x is  in a..z
    fun conc() = print(readln().toInt() in 1..9) //prints true if in range or else false
}


fun printMessagef(message: String): Unit {                              // 1
    println(message)
}

fun printMessageWithPrefixf(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")
}

fun sumf(x: Int, y: Int): Int {                                          // 3
    return x + y
}

fun multiply(x: Int, y: Int) = x * y                                     //4

/*
1. A simple function that takes a parameter of type String and returns Unit (i.e., no return value).
   Unit is a type with only one value - the Unit object. It is analogous to void in Java. [1]
   Functions that don't explicitly return a value have a return type of Unit.
   For example, a function that just prints something would return Unit.
   Unit is used as the return type for functions that perform some side effect but don't return a meaningful value, like println.
   The Unit value is returned by default if a function finishes execution without hitting a return statement.
   Unit is a singleton object - there is only one instance of it, accessed as Unit.
   Variables of type Unit don't hold any useful information
   they just indicate the variable is being used for a side effect rather than holding a value.
   To summarize, Unit represents non-return from a function
   it is similar to void in Java but is an actual type in Kotlin rather than being a non-type.
   Functions returning Unit perform some side effect like printing but don't return a meaningful value.
   Unit is not needed in this case
2. A function that takes a second optional parameter with default value Info.
   The return type is omitted, meaning that it's actually Unit.
3. A function that returns an integer.
4. A single-expression function that returns an integer (inferred).
5. Calls the first function with the argument Hello.
6. Calls the function with two parameters, passing values for both of them.
7. Calls the same function omitting the second one. The default value Info is used.
8. Calls the same function using named arguments and changing the order of the arguments.
9. Prints the result of the sum function call.
10. Prints the result of the multiply function call.
 */
// Check if even or odd
fun checkNumber(num: Int): String {
    return if (num % 2 == 0) "Even" else "Odd"
}

// same thing but shorter (best practice)
fun evenOrOdd(number: Int) = if (number % 2 == 0) "Even" else "Odd"

// ranges
fun range1(num: Int): String {
    return if (num in 1..10) "Number is in range" else "Number is not in range"
}

fun range2(): Boolean {
    return (1 in 3 downTo 1)
}

 */