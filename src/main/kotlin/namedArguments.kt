fun main() {

	fun calcEndDayAmount(startAmount: Int, ticketPrice: Int, soldTickets: Int) =
		startAmount + ticketPrice * soldTickets

	val amount1 = calcEndDayAmount(1000, 10, 500)  // 6000
	/*
This would work fine, although there is one problem: unclear arguments. Of course,
we can declare standard variables and pass them on, but sometimes you have to work with literals, not variables.
Named arguments can make our code more readable. To fix this problem, you can name each argument of this function:
 */
	val amount2 = calcEndDayAmount(
		startAmount = 1000,
		ticketPrice = 10,
		soldTickets = 500
	)  // 6000

	/*
You can change the order of arguments in a function call with the help of named arguments.
All you need to do is to specify the names in any order you want
 */
	val amount3 = calcEndDayAmount(
		ticketPrice = 10,
		soldTickets = 500,
		startAmount = 1000
	)  // 6000

	/*
Named arguments can be mixed with positional arguments.
You can also call a function with named and regular (positional) arguments,
as long as named arguments are placed after positional ones:
 */
	calcEndDayAmount(1000, ticketPrice = 10, soldTickets = 500)  // 6000

	/*
Kotlin 1.4 or later allows you to use positional arguments after named arguments,
but you need to maintain their order. For example:
 */
	//calcEndDayAmount(ticketPrice = 10, 500, 1000)   // Incorrect invocation!
	calcEndDayAmount(startAmount = 1000, 10, 500)   // OK


	calcEndDayAmount(soldTickets = 500, ticketPrice = 10, startAmount = 500) // OK
	//calcEndDayAmount(soldTickets = 500, ticketPrice = 10, 500)  // Incorrect invocation!

	/*
Named arguments can be mixed with regular arguments.
default arguments are sometimes confusing as Kotlin may not understand which parameters to assign.
modify the previous function and make the first parameter optional:
 */
	fun calcEndDayAmount2(startAmount: Int = 0, ticketPrice: Int, soldTickets: Int) =
		startAmount + ticketPrice * soldTickets

	//val amount = calcEndDayAmount(ticketPrice = 10, soldTickets = 500)  // 5000    bogus error here

	/*
Named arguments and default values
The default values for function parameters may or may not be constant.
They can also be another named argument or a function.
 */
	fun sum2(a: Int, b: Int = a) = a + b

	sum2(1)    // 1 + 1
	sum2(2, 3) // 2 + 3
}
/*
To sum it all up, use named arguments wisely to improve code readability and
change the argument order when some parameters have default values.
 */


