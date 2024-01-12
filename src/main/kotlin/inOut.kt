import java.util.*

//Example of Reading Input and Changing a Variable in Kotlin

//This example demonstrates how to read user input from the keyboard and change a variable based on the input:

fun main() {
    // Initialize a variable to store the user input
    var name: String = ""

    // Prompt the user for their name
    print("Enter your name: ")

    // Read the user input using the readLine() function
    //The elvis operator ?: handles the case where readLine() returns null by defaulting to an empty string.
    name = readlnOrNull() ?: ""

    // Check if the user entered a name
    if (name.isNotEmpty()) {
        // Change the variable based on the user input
        name = name.trim()
        println("Welcome, $name!")
    } else
        println("Please enter a valid name.")

/*
Explanation:

Variable Initialization: We first define a variable
Copy code
name
of type
String
to store the user input.
Prompting for Input: We use the
Copy code
print
function to display a message asking the user for their name.
Reading Input: We use the
Copy code
readLine
function to read the user's input from the keyboard. The
?: ""
operator assigns an empty string to the variable if the user doesn't enter anything.
Validating Input: We check if the user entered a name using the
Copy code
isNotEmpty
function.
Changing Variable: If the user entered a name, we trim any leading or trailing spaces using the
Copy code
trim
function and then use it to greet the user.
Error Handling: If the user entered an empty string, we display an error message.

This is a simple example of how to read user input and change a variable in Kotlin.
You can adapt this code to more complex scenarios based on your specific needs.
 */

// Initialize a variable to store the user input
    // !! is a safe call operator that throws an exception if the input is null
    val names = readlnOrNull()
    // name could be null here
    val nonNullName = names!!
    println(nonNullName)

    val number1: Int? = readlnOrNull()?.toInt()
    // number could be null here
    val nonNullNumber = number1!!
    println(nonNullNumber)


    println("Please enter a number")
    val a = readln().toInt()  //!! not used here because input is a string
    println("Please enter another number")
    val b = readln().toInt()
    // Prompt the user for their name
    print("Enter your name: ")

    //string templates: To add a variable value to a string, write the dollar sign $ before a variable name:
    val city = "Paris"
    val temp = "24"
    println("Now, the temperature in $city is $temp degrees Celsius.")

    //If we do not want to print a string, we can create a variable:
    val value = "55"
    val currency = "dollars"
    val price = "$value $currency" // "55 dollars"

    //Idioms are templates for clear and readable code.
    // These patterns clarify the code for other people, so it is a good idea to use them.
    // All idioms are endorsed by the community, so using them will bring you closer to the genuine Kotlin-style code.
    // You can find an exhaustive list of idioms at Kotlin docs.
    val language = "Kotlin"
    println("Have a nice $language!")        // nice code
    //println("Have a nice " + language + "!") // bad practice

    //ou can use string templates to put the result of an arbitrary expression in a string.
    // To do that, include the entire expression in curly braces {...} after the dollar sign $
    println("$language has ${language.length} letters in the name")

    // Read the user input using the readln() function
    /*The elvis operator ?: handles the case where readLine() returns null by defaulting to an empty string.
    The return type of readlnOrNull() is String?, meaning it can return either a String value or null.
    The ?: operator is the elvis operator in Kotlin. It returns the value on the left if it is non-null,
    or the value on the right if the left side is null.


    If readlnOrNull() returns a non-null String, that value will be assigned to firstUserAnswer
    If readlnOrNull() returns null, an empty string "" will be assigned to firstUserAnswer instead
    This allows readlnOrNull() to be safely called without needing to explicitly check for null.
    The elvis operator provides a default value as a fallback if a null is returned.
    So in summary, the ? in Kotlin denotes a nullable type that can hold null values,
    and the ?: operator (elvis operator) is used here to handle the potential null return from readlnOrNull() safely.
     */
    name = readlnOrNull() ?: ""

    // Check if the user entered a name
    if (name.isNotEmpty()) {
        // Change the variable based on the user input
        name = name.trim()
        println("Welcome, $name!")
    } else
        println("Please enter a valid name.")
    // Print the result
    println("The result is: $name")
    println("The result is: $a + $b = ${a + b}")

    //input using Scanner import at top
    val scanner = Scanner(System.`in`)
    println("Enter a number:")
    val number = scanner.nextInt()
    println("You entered: $number")
    scanner.close()

    val line = scanner.nextLine() //read a whole line of text
    println("You entered: $line")
    val string = scanner.next() //read a string, one word!
    println("You entered: $string")
    //It's possible to read a number as a string using scanner.next() or scanner.nextLine() if the number is on a new line.
    val num = scanner.nextInt() //read an integer
    println("You entered: $num")
    //processing goes in order effectively reversing the input
    val num1 = scanner.nextInt() // reads the first number
    val num2 = scanner.nextInt() // reads the second number
    println(num2) // prints the second number
    println(num1) // prints the first number
    val double = scanner.nextDouble() //read a double
    println("You entered: $double")
    val bool = scanner.nextBoolean() //read a boolean
    println("You entered: $bool")
    val char = scanner.next().first() //read a character
    println("You entered: $char")
    val long = scanner.nextLong() //read a long
    println("You entered: $long")
    val float = scanner.nextFloat() //read a float
    println("You entered: $float")
    val short = scanner.nextShort() //read a short
    println("You entered: $short")
    val byte = scanner.nextByte() //read a byte
    println("You entered: $byte")
    val decimal = scanner.nextBigDecimal() //read a BigDecimal
    println("You entered: $decimal")
    val bigInt = scanner.nextBigInteger() //read a BigInteger
    println("You entered: $bigInt")
    //.useDelimiter is a method in the Scanner class that allows you to specify a custom delimiter.
    //It allows you to read a string that contains multiple words separated by a custom delimiter.
    scanner.useDelimiter(" ")
    val words = scanner.next() //reads the first word
    println("You entered: $words")
    val words2 = scanner.next() //reads the second word
    println("You entered: $words2")

    //replacing spaces with a colon and a forward slash or other
    //fun main() {
    //val scanner = Scanner(System.`in`)
    val t = readln().replace(" ", ":")
    val u = scanner.nextLine().replace(" ", "/")
    print(t)
    print(" ")
    print(u)


    //.hasNext() is a method in the Scanner class that returns true if there is another token in the input stream.
    //It allows you to check if there is another word in the input stream.
    while (scanner.hasNext()) {
        val word = scanner.next()
        println("You entered: $word")
    }
    //or with data it can remove symbols
    scanner.useDelimiter("_")
    val numdata = Scanner("123_456")
    println(numdata.nextInt()) // prints 123
    println(numdata.nextInt()) // prints 456


    // hasNext() is a method in the Scanner class that returns true if there is another token in the input stream.
    // It allows you to check if there is another token in the input stream.
    //fun main() {
    val severalWords = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val word1 = scanner.next()
        println(word1)
        val word2 = scanner.next()
        println(word2)
        val word3 = scanner.next()
        println(word3)
        val word4 = scanner.next()
        println(word4)
    }
    //}
    //.hasNextLine() is a method in the Scanner class that returns true if there is another line in the input stream.
    //It allows you to check if there is another line in the input stream.
    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        println("You entered: $line")
    }

    //fun main() {
    //val scanner = Scanner(System.`in`)
    // output individual strings on separate lines
    while (scanner.hasNext()) {
        val word = scanner.next()
        println(word)
    }
    scanner.close()  //close scanner to stop from using resources
    /* 1. If Scanner isn't needed, always use readln().
       2.To read different types of data, Scanner has methods like next(), nextInt(), and nextLine().
       3. If you have input with strange delimiters, use the method useDelimiter().
       4. If you don't know how many words the input has, use the method hasNext().
       5. If you don't know how many lines the input has, use the method hasNextLine().
     */

    /*Booleans
    Precedence determines how other variables are grouped in the absence of parentheses:
    ! for NOT
    xor for XOR
    && for AND
    || for OR
    You can use parentheses (...) to change the order of execution.
     */

    /* precedence of arithmetic operators:
    Parentheses;
    Unary plus/minus;
    Multiplication, division, and modulus;
    Addition and subtraction.
     */

}



fun perimeter(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, x4: Double, y4: Double): Double {
    var scanner = Scanner(System.`in`)
    val x1 = scanner.nextDouble()
    val y1 = scanner.nextDouble()
    val x2 = scanner.nextDouble()
    val y2 = scanner.nextDouble()
    val x3 = scanner.nextDouble()
    val y3 = scanner.nextDouble()
    val x4 = scanner.nextDouble()
    val y4 = scanner.nextDouble()


    val side1 = Math.hypot(x1 - x2, y1 - y2)
    val side2 = Math.hypot(x2 - x3, y2 - y3)
    val side3 = Math.hypot(x3 - x4, y3 - y4)
    val side4 = Math.hypot(x4 - x1, y4 - y1)
    val perimeter = side1 + side2 + side3 + side4
    return perimeter
}