/*
readln() reads a line of input from the user and returns it as a string.
To work with numeric values, use the function toInt().
To convert the input to an integer, use the toInt()function and dot syntax:
In case we need to process a larger number, for example,
the cost of a large and luxurious yacht, use the function toLong()
The same logic works for Boolean: use the function toBoolean()
If you want to enter several values and their data types are different,
then you need to press Enter in order to separate the different types.
 */

fun main() {
    println("Enter your name:")
    val name = readln()
    println("Enter your age:")
    val age = readln().toInt()
    println("Hello, $name! You are $age years old.")

    println("Enter your cost:")
    val cost = readln().toLong()
    println("Your cost is $cost.")

    println("Enter your Boolean:")
    val boolean = readln().toBoolean()
    println("Your Boolean is $boolean.")

    println("Enter your age:")
    val a = readln().toInt()
    val b = 10
    val c = a + b
    println("Enter your name:")
    println("Your age is $a.")
    println("Your name is $b.")
    println("Your total is $c.")

    //If you need to read two values in one line, you can use this construction:
    println("Enter two things:")
    val (d, e) = readln().split(" ")
    println("The sum of $d and $e is ${d + e}")

    //you can read up to four values per line:
    println("Enter four things:")
    val (f, g, h, i) = readln().split(" ")
    println(f)
    println(g)
    println(h)
    println(i)

    /*
    Your program can handle string, number, and boolean input using type conversion.
    To convert, use the functions toInt(), toLong(), toDouble(), and toBoolean().
    You can also input and output multiple values of the same or different types.
     */

    //check if input is an integer
    val n: Int? = readln().toIntOrNull()
    if (n !is Int) {
        println("Wrong Type")
    }
    println(n)
}