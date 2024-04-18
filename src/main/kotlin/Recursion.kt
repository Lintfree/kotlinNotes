/*

Recursion

Recursion is when a function calls itself.

For example, if a function calls itself,
it will continue calling itself until it reaches the base case.

The factorial of a non-negative integer
�
n is equal to the product of all positive integers from 1 to 10 inclusively.
Also, by definition, the factorial of 0 is 1

0! = 1
 Let's take a normal number though: for example, the factorial of 5

 (written as 5!) is 1∗2∗3∗4∗5=120
1∗2∗3∗4∗5=120

For example,

	fun factorial(n: Int): Int {
		if (n == 1) {
			return 1
		} else {
			return n * factorial(n - 1)
		}
	}

	fun sumRecursive(n: Int): Int {
    if (n == 1) return 1
    return n + sumRecursive(n - 1)
}

fun main() {
    val n = readLine()!!.toInt()
    print(sumRecursive(n))
}

	// factorial(5) = 5 * factorial(4)
	// factorial(4) = 4 * factorial(3)
	// factorial(3) = 3 * factorial(2)
	// factorial(2) = 2 * factorial(1)
	// factorial(1) = 1
	// factorial(5) = 5 * 4 * 3 * 2 * 1

	 As a rule, in Python and Java, loops are more efficient in terms of time and memory.
	 Recursion is slower and "heavier" because each call of a function takes additional memory,
	 and recursive functions usually get called many times.

	In that case, why recursion? Well, it has one certain advantage over loops: in some cases, it is intuitive.
	If you are certain that some function uses itself,
	it is much faster to write 3-4 lines of recursive code than to think how exactly a loop should behave.
	If you are short on time but don't have to worry about memory consumption, recursion is your choice.

	fun factorialRecursive(n: Int): Int {
    if (n == 0 || n == 1) return 1
    return n * factorialRecursive(n - 1)
}

Recursion should always be used very carefully.
If there are no conditions to stop a recursive function from another recursive call,
it gets stuck in a never-ending loop of invoking itself, which would break the program eventually.
Therefore, to use recursion properly and not make our PC run out of RAM,
we need to limit it and always make sure we have a terminal condition – with the factorial,
it’s when the function gets n equal or less than 0.

Each recursive function can be represented with a corresponding loop.
In the recursive factorial function, the call of f(n) is always followed by the call of f(n-1),
so in any consecutive pair of calls, n differs exactly by 1. So, if functions are always called with "n, n-1, n-2, n-3...",
why don't we just make a loop to make everything easier? Let’s use this idea to implement a non-recursive solution:

fun factorial(n: Int): Int {
    var f = 1
    for (i in 1..n)
        f *= i
    return f
}

Types of recursion
There are several types of recursion:

1. Direct recursion
It’s the case when a function simply calls itself only once. Our recursive factorial makes a good example:

fun factorialRecursive(n: Int): Int = if (n == 0 || n == 1) 1 else n * factorialRecursive(n - 1)

2. Indirect recursion
This is the case when a function uses some other function, which, in turn, calls the former function.
There’s no necessity to do it like that, but a modified version of the factorial function can be an example:

fun weirdFactorialRecursive(n: Int): Int = if (n == 0 || n == 1) 1 else factorialCompute(n)

fun factorialCompute(n: Int): Int = n * weirdFactorialRecursive(n - 1)

3. Tail recursion
A function utilizes tail recursion if a recursive call is the last thing the function does.

See, for example, a factorial function with the final call being recursive.
This version is a bit different, since usually, we do multiplication last,
while here we do it before passing the result to the recursive call.

fun tailFactorialRecursive(n: Int, cur: Int = 1): Int {
    if (n == 0) return cur
    return tailFactorialRecursive(n - 1, cur * n)
}
Why does tail recursion stand out as a separate type?
Because modern compilers can more efficiently work with it.
To compute another call of a recursion function,
the compiler usually pushes the stack frame onto the stack of operations to be performed,
therefore, creating a new set of local variables, which costs time and space.
In the case of tail recursion,
the compiler can just return to the beginning of the function to continue working with the same variables
that it already has in the current stack frame.

4. Multiple recursion
This is the case when a function makes several calls to itself.
As an example, there is a well-known sequence of numbers called the Fibonacci numbers.
In this sequence, each next number is the sum of the two preceding ones

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

Then, each new Fibonacci number is calculated as follows:
the formula is Fn = Fn-1 + Fn-2

A program for calculating this sequence utilizes multiple recursion:
in order to compute the current Fibonacci number, we need to compute the two preceding ones,
therefore making 2 recursive calls:

fun fibonacci(n: Int): Int {
    if (n <= 0) return 0
    if (n == 1) return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
}
However, this solution is extremely inefficient, as recursion branches each time we need another number;
therefore, the number of calls and calculations grows exponentially.

Optimizations
As we've already noted, multiple recursion in the case of the Fibonacci sequence is extremely inefficient
due to computing numerous values for a great number of recursion branches.
Apart from turning recursion into a loop, there is yet another method of optimizing it, which is called memoization.

Calling f(6), for example, would call f(5) and f(4), and f(5), in its turn, would also call f(4).
The basic version would compute f(4) two times, and it gets worse for the numbers which are used more often.

How could we make our function compute the required number only once?
Let’s save it to an array once we compute it and make all other recursion branches first check if the value
has already been computed.
If not, they will do it, but if the value is already there, it can be used right away.
Here’s a version of the same algorithm with memoization:

val fibList = MutableList(1000){0}

fun coolerFibonacci(n: Int): Int {
    if (n <= 0) return 0
    if (n == 1) return 1
    return if (fibList[n] != 0) fibList[n]
    else {
        fibList[n] = coolerFibonacci(n - 1) + coolerFibonacci(n - 2)
        fibList[n]
    }
}
One more possible optimization method involves replacing recursion with a loop,
which may be used, for example, in the case of calculating the Fibonacci sequence.
Why calculate a needed number if we can basically iterate through all required numbers:

fun fibonacciLoop(n: Int): Int {
    var n0 = 0
    var n1 = 1
    for (i in 1 until n) {
        val cur = n0 + n1
        n0 = n1
        n1 = cur
    }
    return n1
}

 */


/*
var n = 6
fun f(n: Int): Int = if (n > 2) f(n - 1) + f(n - 2) + f(n - 3) else n
println(f(n))
20


The output of f(6) can be determined by evaluating the function recursively:

f(6) calls f(5) + f(4) + f(3) //not considered in the sum because all calls are greater than 2
f(5) calls f(4) + f(3) + f(2)
f(4) calls f(3) + f(2) + f(1)
f(3) calls f(2) + f(1) + f(0)

Now let’s work our way back up:

f(3) evaluates to 2 + 1 + 0 = 3
f(4) evaluates to 3 + 2 + 1 = 6
f(5) evaluates to 6 + 3 + 2 = 11
Finally, f(6) evaluates to 11 + 6 + 3 = 20.
Therefore, the output of f(6) is 20.

Let's delve into why the first call to `f(6)` isn't explicitly added to the subsequent recursive calls.

In the recursive function `f(n)`, the base case is when `n` is less than or equal to 2.
In that case, the function directly returns `n`.
However, when `n` is greater than 2,
the function recursively calls itself three times with the arguments `n - 1`, `n - 2`, and `n - 3`.
These recursive calls are then added together.

Here's the breakdown for `f(6)`:

1. `f(6)` calls `f(5) + f(4) + f(3)`
2. `f(5)` calls `f(4) + f(3) + f(2)`
3. `f(4)` calls `f(3) + f(2) + f(1)`
4. `f(3)` calls `f(2) + f(1) + f(0)`

At this point, we reach the base cases: >2
anything further are not evaluated because they are less than or equal to 2.


- `f(2)` returns `2`
- `f(1)` returns `1`
- `f(0)` returns `0`

since we now hit our base cases we now work back up to f5 using the same process
it keeps going because f keeps calling itself until it reaches the base cases then it returns the value of the base cases
Now let's work our way back up:

- `f(3)` evaluates to `2 + 1 + 0 = 3`
- `f(4)` evaluates to `3 + 2 + 1 = 6`
- `f(5)` evaluates to `6 + 3 + 2 = 11`

Finally, `f(6)` evaluates to `11 + 6 + 3 = 20`.

The initial call to `f(6)` is implicitly included in the sum of the recursive calls.
It serves as the starting point, and the subsequent additions build upon it.
So, while it's not explicitly written as part of the sum, it contributes to the final result.

In summary, the output of `f(6)` is 20.

Let’s explore the differences between recursion and iteration:

Definition:
Recursion: In recursion, a function calls itself directly or indirectly.
Iteration: Iteration involves using loops (such as for or while) to repeatedly execute a set of instructions.

Execution:
Recursion: The repeated execution in recursion happens through function calls.
Iteration: In iteration, the repetition occurs within a loop construct.

Base Case:
Recursion: Recursive functions have a base case that terminates the recursion.
Iteration: Loops continue until a specified condition (usually defined by the loop control) is met.

Time Complexity:
Recursion: The time complexity of recursive algorithms can be complex due to repeated function calls.
Solving recurrences helps analyze it.
Iteration: The time complexity of iteration depends on the number of cycles executed inside the loop.

Usage:
Recursion: Shorter code, but higher time complexity. Useful when code length matters more than execution time.
Iteration: Larger code, but generally lower time complexity.
Preferred for efficiency when the number of iterations is large.

Overhead:
Recursion: Involves overhead due to repeated function calls.
Iteration: No such overhead.

Infinite Repetition:
Recursion: Infinite recursive calls can lead to system crashes.
Iteration: Stops when memory is exhausted.
In summary, choose recursion for concise code and simplicity,
but be cautious about potential exponential time complexity.
Opt for iteration when efficiency matters and the number of iterations is significant.
 */


/*
fun digitSum(number: Int): Int {
	// Base case: if number is 0, return 0
	if (number == 0) {
		return 0
	}
	// Take the last digit of the number and add it to the sum of the remaining digits
	return number % 10 + digitSum(number / 10)
}

fun main() {
	println(digitSum(12345))
}
*/


//This code snippet is a recursive function called digitSum, which calculates the sum of the digits of a given integer.
// If the input is 0, it returns 0. Otherwise,
// it calculates the sum of the last digit (n % 10) and calls itself with the remaining digits (n / 10).
/*
fun digitSum(n: Int): Int {
    if (n == 0) {
        return 0
    }
    val lastDigit = n % 10  // Calculate the last digit
    val remainingDigits = n / 10  // Calculate the remaining digits
    val sumOfRemainingDigits = digitSum(remainingDigits)  // Recursively call digitSum with the remaining digits
    return lastDigit + sumOfRemainingDigits  // Return the sum of the last digit and the sum of the remaining digits
}

Sure! Let's go through an example to illustrate the process using basic math:

If we call digitSum(123), here's how it would be calculated:

digitSum(123) = 3 + digitSum(12)
digitSum(12) = 2 + digitSum(1)
digitSum(1) = 1 + digitSum(0)
digitSum(0) = 0
Now we can substitute the values back:

digitSum(1) = 1 + 0 = 1
digitSum(12) = 2 + 1 = 3
digitSum(123) = 3 + 3 = 6
So, the sum of the digits of 123 is 6.
 */

//Write a recursive function which would return true if the given number is prime and false if it is not.
//
//Hint: a second parameter is used to indicate which number the function is currently assuming to be the divisor.

/*
fun isPrime(n: Int, i: Int = 2): Boolean {
	// a few base cases here
	if ( n < 2) {
		return false
	}
	if (n == 2) {
		return true
	}
	if (n % i == 0) {
		return false
	}
	if (i * i > n) {
		return true
	}
	// recursive case here
	return isPrime(n, i + 1)
}

fun main() {
	val n = readln().toInt()
	print(isPrime(n))
}

 */

/*
fun isPrime(n: Int, i: Int = 2): Boolean = when {
    n <= 1 -> false
    i >= n -> true
    n % i == 0 -> false
    i <= 1 -> isPrime(n)
    else -> isPrime(n, i + 1)
}
 */

/*
fun f(n: Int) {
	if (n > 0) g(n - 1)
}

fun g(n: Int) {
	print("*")
	if (n > 1) f(n - 3)
}

fun main() {
	f(10)
}
 */

//Implement a recursive function F with the following rules:
//
//f(n) = f(n-1)/2 + 2*f(n-2)
//
//f(0) = 4
//
//f(-1) = 1
//
//The function needs to return the result of the calculation.
//
//Sample Input 1:
//
//5
//Sample Output 1:
//
//39

/*
fun f(n: Int): Int {
	// your code here

	if (n == 0) {
		return 4
	}
	if (n == -1) {
		return 1
	}
	return f(n - 1) / 2 + 2 * f(n - 2)
}

fun main() {
	val n = readln()!!.toInt()
	print(f(n))
}
*/

/*Given function F, what's the sum of all numbers it prints if called as f(2)?
Here are the steps involved when calling recursiveFunction(2):

recursiveFunction(2, 0) is called.
Prints: 2
Calls recursiveFunction(3, 2)
recursiveFunction(3, 2) is called.
Prints: 3
Calls recursiveFunction(4, 5)
recursiveFunction(4, 5) is called.
Prints: 4
Calls recursiveFunction(5, 9)
recursiveFunction(5, 9) is called.
Prints: 5
Returns 14 to the previous call (recursiveFunction(4, 5)).
recursiveFunction(4, 5) continues:
Calls recursiveFunction(7, 14)
recursiveFunction(7, 14) is called.
Prints: 7
Calls recursiveFunction(8, 21)
recursiveFunction(8, 21) is called.
Prints: 8
Returns 29 to the previous call (recursiveFunction(7, 14)).
recursiveFunction(7, 14) continues:
Calls recursiveFunction(10, 29)
recursiveFunction(10, 29) is called.
Prints: 10
Returns 39 to the previous call (recursiveFunction(7, 14)).
recursiveFunction(7, 14) continues:
Returns 39 to the initial call (recursiveFunction(2, 0)).
So, the sum of all numbers printed when calling recursiveFunction(2) is 39.
 */
fun recursiveFunction(number: Int, sum: Int = 0): Int {
	println(number)
	val newSum = sum + number
	if (number < 5) {
		val sum1 = recursiveFunction(number + 1, newSum)
		val sum2 = recursiveFunction(number + 3, sum1)
		return sum2
	}
	return newSum
}

fun main() {
	val totalSum = recursiveFunction(2)
	println("Sum of all numbers printed: $totalSum")
}
