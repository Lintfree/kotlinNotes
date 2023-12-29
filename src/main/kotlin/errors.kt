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


}
