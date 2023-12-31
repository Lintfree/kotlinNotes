/*
There are different strategies to find runtime errors: (not logic errors or unhandled exceptions ie: divide by zero)
1. debug your program;
2. write automatic tests for your program;
3. to use code review practice as part of the development process.
In general, this practice stands for a case when one or more developers visually inspect the source code of a program.
 */

/*
Compile-time errors happen when a program fails to compile.
They include typos and incorrect method invocation.
Static code analyzers in IDEs help to spot compile-time errors before program compilation.
Run-time errors, or bugs, occur after compilation when a program is running.
They may result in program unexpected behavior and crashes.
Debugging is a useful instrument to identify run-time errors in your program.
 */

// handling divide by zero error using try-catch block.
/*
try-catch block is used to handle exceptions.
The try block contains the code that may throw an exception.
The catch block contains the code that handles the exception.
 */

// example:

fun main() {

	 try {
		val num = 100
		val divisor = 0
		val result = num / divisor
	} catch (e: ArithmeticException) {
		println("Can't divide by zero!")
	}

	/*
	this will throw an out of bounds exception.
	val intsList = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
	for (i in 0..11) println(intsList[i])
	 */

	//conversion error using try-catch block to handle it.
	try{
		val number = "123abc".toInt()
		println(number)
	} catch (e: NumberFormatException) {
		println("Error: ${e.message}")
	}

	/*
	Exceptions are objects that contain information about an error.
	The standard method for triggering an exception is by using the throw keyword,
	followed by an instance of the exception.
	 */

	val exception = Exception("This is an exception")
	//throw exception

	//throwing an exception in a try-catch block
	try {
		val result = 10 / 0
	} catch (e: ArithmeticException) {
		throw Exception("$exception")
	}

	/*
	Kotlin also has a finally block that executes the code,
	irrespective of whether an exception was triggered or not,
	typically used for cleaning up resources.
	try {
        // risky code that could trigger an exception
	} catch (e: Exception) {
        // handling the exception
	} finally {
        // code that will execute no matter what
	}
	 */

	/*
	All exceptions are unchecked in Kotlin because it doesn't have checked exceptions.
	Unchecked Exceptions
	These exceptions aren't checked at compilation.
	They usually result from programming mistakes like logic errors or incorrect use of an API.
	Unchecked exceptions are subclasses of RuntimeException and include examples such as
	IndexOutOfBoundsException or NullPointerException.
	 */

	fun accessElement(list: List<String>, index: Int) {
		try {
			println(list[index])
		} catch (e: IndexOutOfBoundsException) {
			println("Index is out of bounds.")
		}
	}

	/*
	The main constructs for exception handling in Kotlin are try, catch, and finally blocks.
	try: This block encloses the code that might trigger an exception.
	If an exception occurs within this block, it is thrown, and the control is transferred to the corresponding catch block.
	catch: This block captures the exceptions thrown from the try block.
	It should follow the try block, and you can have multiple catch blocks to manage different types of exceptions.
	finally: This block is optional and runs after the try and catch blocks,
	whether or not an exception has been thrown or caught. It's typically used to clean up resources.
	 */

	fun divide(a: Int, b: Int): Int {
		try {
			return a / b
		} catch (e: ArithmeticException) {
			println("Cannot divide by zero!")
		} finally {
			println("Operation attempted.")
		}
		return 0
	}

	/*
	Kotlin also supports try as an expression,
	letting you assign the result of a try block to a variable:
	 */
	val result = try {
		divide(10, 0)
	} catch (e: Exception) {
		-1
	} finally {
		println("Operation completed.")
	}

	/*
	The subtype is a datatype that is related to another datatype (supertype)
	and inherits common characteristics and rules of behavior from it.
	Note that the rules of behavior of different subtypes may vary.

	Logically, a supertype is a type whose properties and methods specify
	the characteristics and rules of behavior that its subtypes will follow.

	An Error indicates serious problems that a reasonable application should not try to process.

	The RuntimeException type is a rather special subtype of Exception.
	Subtypes of RuntimeException, such as ArithmeticException and NumberFormatException,
	can be thrown during the normal program execution.
	These exceptions are usually caused by insufficient checks in the program code, and can be prevented programmatically.
	a hierarchy of subtypes descended from RuntimeException

	ArithmeticException is the runtime exception that is thrown when the code attempts an illegal arithmetic operation.

	During calculations you can get another type of exception: NumberFormatException.
	It is thrown when a method expects to receive a number, but the actual input is something else

	IndexOutOfBoundsException occurs when you access some non-existent index
	For example, if you are trying to access the tenth element of a collection that has only 5 elements,
	your index will be out of bounds.

	StringIndexOutOfBoundsException, a special type of IndexOutOfBoundsException
	If the string does not contain the character with the specified index,
	a StringIndexOutOfBoundsException will be thrown.
	 */

	/*

	val inputString = readln()
	val i = (inputString.length) - 1
	val lastIndexChar = (inputString[i])
	println(lastIndexChar)

	same as:
	val lastIndexChar = inputString[inputString.length-1]
	println(lastIndexChar)
	 */

	val a = readln().toInt()
	val b = readln().toInt()
	try {
		println(a / b)
	}
	catch (e: ArithmeticException) {
		println("Division by zero, please fix the second argument!")
	}

}
