/* Objects and their properties
	Every time when you work with variables, you work with objects.
	For example, an integer 5 and a string "love" are objects.

	A simple example of an object is a String that stores a message.
	a message has a state: it contains not only a sequence of symbols but also the size of the sequence.
	something that allows you to access the state of an object is called a property.

	In Kotlin, something that allows you to access the state of an object is called a property.
	Just put a dot and write the name of the property after the object, and you will get what you want
	ie: .length
	or a function ie: .toUpperCase() .repeat

	 An object can be either mutable or immutable.



	 Functions as Objects
	 In Kotlin, functions are "first-class citizens," meaning they can be treated like any other object.
	 This feature of the functional language enables more flexible and expressive code.
	 Here's what making functions first-class involves:

	Stored in Variables: Functions can be assigned to variables for dynamic function invocation.

	val greet: (String) -> Unit = { name -> println("Hello, $name!") }
	greet("World") // Output: Hello, World!

	Passed as Arguments: Functions can be passed to other functions as parameters,
	which is useful for callbacks and higher-order functions.

	fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
	}
	val sum = operateOnNumbers(2, 3, { x, y -> x + y }) // Output: 5
	val subtract = operateOnNumbers(2, 3, { x, y -> x - y }) // Output: -1

	Returned from Functions: Functions can be returned from other functions, allowing complex compositions and factory patterns.

	fun getMathFunction(type: String): (Int, Int) -> Int {
        return when (type) {
            "sum" -> { x, y -> x + y }
            "subtract" -> { x, y -> x - y }
            else -> { _, _ -> 0 }
        }
	}
	val sumFunction = getMathFunction("sum")
	val result = sumFunction(4, 5) // Output: 9

	Manipulated: Since functions are objects, you can manipulate them, such as being stored in collections or having properties.

	val functionList: List<(Int) -> Int> = listOf(
        { it * 2 },
        { it * it }
	)
	val doubled = functionList[0](2) // Output: 4
	val squared = functionList[1](2) // Output: 4

	Anonymous Functions
	Kotlin's support for treating functions as first-class citizens enables functional programming patterns,
	making the code more concise, flexible, and easy to understand.

	Event Listeners
	You often use functions as objects to implement event listeners. Kotlin offers a simpler approach to creating an anonymous class:

	button.setOnClickListener { view ->
        // Handle click event
	}

	Callbacks
	By passing around callbacks as function parameters, managing asynchronous tasks becomes easier:

	fun fetchData(callback: (data: Data) -> Unit) {
     // Asynchronous fetch
        callback(result)
	}

	fetchData { data ->
        println("Data received: $data")
	}

	Collection Manipulation
	kotlin's collection API heavily uses functions for tasks such as filtering, mapping, etc.:

	val numbers = listOf(1, 2, 3, 4)
	val evenNumbers = numbers.filter { it % 2 == 0 } // [2, 4]

	Benefits
	Utilizing functions as objects results in more concise code as it reduces anonymous classes.
	Also, readability improves since the behavior can be defined in line or through well-named functions.
	Flexibility is another key benefit as functions can be created and passed around dynamically, adjusting to the context they're used in.

	In Kotlin, the :: operator is used to refer to a function by its name, enabling you to pass it around as a reference.
	This is particularly useful when you need to pass a function as a parameter to another function or store it in a variable.
	Here's a brief explanation of how it works with an example:

	Function Reference: The :: operator creates a function reference, allowing you to use the function without invoking it immediately.

	fun topFun() {
        println("Hello from topFun!")
	}
	val functionRef = ::topFun

	Invoking Function Reference: You can invoke this reference like a normal function.
		functionRef() // This will output: "Hello from topFun!"

	Passing as a Parameter: Function references can be passed as arguments to other functions.
	fun executeFunction(func: () -> Unit) {
        func()
	}
	executeFunction(::topFun) // This will also output: "Hello from topFun!"

	Conclusion
	In summary, using :: with a function name in Kotlin creates a reference to the function, which you can then use like any other object.
	This feature enhances the flexibility of the language, allowing for functional programming techniques and higher-order functions.

	fun composition(value: Int, y: (Int) -> Int, g: (Int) -> Int): Int {
		//Complete the composition function body.
		// It receives an integer value, a function y, and a function g and returns y(g(value)).
		return y(g(value))
	}

	fun square(value: Int, context: Any, continuation: (Int, Any) -> Unit) {
        // The function is to compute the square of the given integer.
		// Then it should pass the square and the given context to the provided continuation function.
		continuation(value * value, context)
	}

	import java.io.BufferedReader
	import java.io.InputStreamReader

	fun main(args: Array<String>) {
        val reader = BufferedReader(InputStreamReader(System.`in`))

        val input = reader.readLine().split(" ").map(String::toInt)
        val x = input[0]
        val y = input[1]

        // Write your code here. You may declare a function that takes an integer as input
        // and returns an integer as output.
        fun sum(x: Int, y: Int) = x + y
        println(sum(x, y))
}
 */
