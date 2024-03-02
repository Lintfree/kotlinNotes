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