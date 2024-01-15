import java.io.IOException

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


	val (var1 , op, var2) = readln().split(" ")
	val y = var1.toLong()
	val z = var2.toLong()
	try {
		when (op) {
			"+" -> println (y + z)
			"-" -> println (y - z)
			"*" -> println (y * z)
			"/" -> println (y / z)
			else -> println("Unknown operator")
		}
	}catch (e: ArithmeticException) {
		println("Division by 0!")
	}

	/* or
    val (firstNumber, op, secondNumber) = readln().split(" ")
    val a = firstNumber.toLong()
    val b = secondNumber.toLong()
    println(
        when {
            op == "/" && b == 0L -> "Division by 0!"
            op == "+" -> a + b
            op == "-" -> a - b
            op == "*" -> a * b
            op == "/" -> a / b
            else -> "Unknown operator"

        }
    )
	*/

	/*
	You can quickly wrap a code block in useful constructs.Select it in the editor and press,Ctrl, Alt, T, (Code | Surround With).
	The list of available options or wrappers is context-sensitive and depends on the language.
	For example, you can surround html blocks with tags, and so on.
	 */

	println("Before the try-catch block") // it will be printed
	try {
		println("Inside the try block before an exception") // it will be printed
		println(2 / 0) // it throws ArithmeticException
		println("Inside the try block after the exception") // it won't be printed
	} catch (e: ArithmeticException) {
		println("Division by zero!") // it will be printed
	}

	println("After the try-catch block") // it will be printed

	/*
	Replacing ArithmeticException with Exception or RuntimeException in the catch statement does not change the execution flow of the program.
	But replacing it, for instance, with NumberFormatException will make the handler unsuitable for the exception and the program will fail.
	If the result of the execution of the try block throws an exception not foreseen in the catch expression,
	the program will fail despite all precautions.
	When an exception is caught by the catch block, it is possible to get some information on it. To do this, we use message:
	 */
	try {
		val d = (2 / 0).toDouble()
	} catch (e: Exception) {
		println(e.message)
	}

	/*
	You can add as many catch blocks as you need. When an exception occurs in the try block,
	the runtime system determines the first suitable catch block according to the type of exception; matching goes from top to down.
	The catch block with the base type has to be written below all the blocks with subtypes.
	In other words, more specialized handlers (like IOException) must be written before the more general ones (like Exception).
	Otherwise, the block with the subtype will be ignored.
	 */

	fun convertStringToDouble(input: String): Double {
		/**
		 * It returns a double value or 0 if an exception occurred
		 */
		try {
			return input.toDouble()
		}
		catch (e: NumberFormatException) {
			return 0.0
		}
	}

	fun printFifthCharacter(input: String): String {
		try {
			return "The fifth character of the entered word is ${input[4]}"
		} catch (e: StringIndexOutOfBoundsException) {
			return "The input word is too short!"
		}
	}

	/*
	try-catch-finally
	The finally block is executed after the try and catch blocks,
	in situations when you need to perform some finishing actions regardless of whether an exception is thrown.
	 */

	try {
		println("Inside the try block")
		println(2 / 0) // throws ArithmeticException
	}
	catch (e: Exception) {
		println("Inside the catch block")
	}
	finally {
		println("Inside the finally block")
	}

	println("After the try-catch-finally block")

	/*
	If we remove the line that throws the ArithmeticException,
	the finally block will still execute after the try block:
	 */

	/*
	code can contain any number of catch blocks or no such blocks at all, and finally blocks can be omitted.
	However, at least one catch or finally block must be present.
	This means that when you handle an exception with try, you should add at least one other block: catch or finally.
	Otherwise, the statement simply won't work.
	 */

	/*
	try can be an expression in Kotlin. This means that it may have a return value:
	 */

	val number: Int = try { "abc".toInt() } catch (e: NumberFormatException) { 0 }
	println(number) // 0

	/*
	In the try block, we're trying to assign the value "abc" to the variable number.
	When we attempt to convert the string "abc" to the Int type, the NumberFormatException is thrown.
	Then, the catch block is executed, so the number variable takes the value 0.

	The returned value of a try expression is either the last expression in the try block or the last expression in the catch block(s).
	The contents of the finally block do not affect the result of the expression:
	 */

	/*
	Another useful technique is to rethrow exceptions to the caller.
	You need to add a way to handle exceptions in the code snippet where you call the function that can throw an exception.
	Here is an example of how to do this with an expression-style try:
	 */

	/*
	fun test() {
		val result = try {
			countSomething()
		} catch (e: ArithmeticException) {
			throw IllegalStateException(e) // do not forget to deal with it
		}

		// Working with result
	}

	try {
		test()
	} catch (e: IllegalStateException) {
		...
	}
	*/

	/*
	Using try-catch blocks as expressions is an idiomatic way of working with exceptions in Kotlin.
	You get the result immediately, which is very convenient.
	Compare this method with a less direct one:
	 */

	val string1 = "abc"
	val number1 = try {
		string1.toInt()
	} catch (e: NumberFormatException) {
		-1
	}

	// Longer version of the same code

	val string = "abc"
	var number2 = 0 // try to avoid var if possible
	try {
		number2 = string.toInt()
	} catch (e: NumberFormatException) {
		number2 = -1
	}

	/*Remember that you can skip catch or finally when you handle an exception with try,
	but you can't omit both at the same time.
	 */

	fun returnValue(): Int {
		val value = readln().toInt()
		if (value > 0) {
			throw Exception("It's too big")
		} else {
			return (value)
		}
	}

	/*
	from hyperskill practice  correct answer:
    There is a function suspiciousFunction, and for some reason, you suspect that an exception might occur in it.
	Process the call of suspiciousFunction with the help of the try-catch-finally statement. If an exception occurs in the function, print the exception message.
	In the case of IOException, print the following message instead: The IOException occurred.
	In the final block, output Handling completed successfully!.
	*/

	//import java.io.IOException
	//import java.lang.ArithmeticException

	fun suspiciousFunction (param: Int) {
		when (param) {
			0 -> throw Exception("Some exceptions?")
			1 -> throw java.lang.ArithmeticException("Division by zero")
			2 -> throw Exception("An exception occurred here")
			3 -> throw IOException()
		}
	}

	fun handleException (data: Int) {
		val exception = try {
			suspiciousFunction(data)
		} catch (e: IOException) {
			println("The IOException occurred")
		} catch (e: java.lang.ArithmeticException) {
			println(e.message)
		} catch (e: Exception) {
			println(e.message)
		} finally {
			println("Handling completed successfully!")
		}
	}
}
