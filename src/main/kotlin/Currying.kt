/*
Currying

This concept allows you to transform a function with multiple arguments into a sequence of functions, each with a single argument.
This article will delve into the details of currying, providing a comprehensive understanding of its application, benefits, and real-world examples.

Understanding
In its essence, currying is a technique in functional programming where a function with multiple arguments is transformed into a sequence of functions,
each with a single argument. In other words, it breaks down a function that takes multiple arguments into a series of functions that take one argument.
Let's consider an example to understand the basic concept of currying:

fun  ((T1, T2) -> R).curried() =
    fun(p1: T1) = fun(p2: T2) = this(p1, p2)

In this example, we have created a curried function.
The function `curried()` takes a function with two parameters and returns a function that takes one parameter
and returns another function that also takes one parameter.
Instead of taking all its arguments at once, the function takes the first one and returns a new function that takes the second one.

Applying
To understand how currying can be applied, consider a function that calculates the total price of items with a certain discount.
This function takes two arguments: the original price and the discount rate.

fun calculateTotalPrice(price: Double, discount: Double): Double {
    return price - (price * discount / 100)
}

We can use the currying technique to transform this function into a series of functions, each taking one argument.

fun calculateTotalPrice(price: Double): (Double) -> Double {
    return { discount -> price - (price * discount / 100) }
}

Now, we can create a new function for a specific discount rate.
This new function takes the original price as an argument and returns the discounted price.

val calculateWith30PercentOff = calculateTotalPrice(100.0)
println(calculateWith30PercentOff(30.0))  // Output: 70.0

In this example, `calculateWith30PercentOff` is a new function created from the curried function `calculateTotalPrice`.
It takes the original price as an argument and applies a 30 percent discount.
 */