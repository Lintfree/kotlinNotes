/*
Elvis operator
If the value on the left side of the ?: operator is null, the value on the right side of the ?: operator is returned.

For example, if value is null, then 0 is returned, otherwise value is returned.

For example,

val value: Int? = null
val result = value ?: 0

println(result)

// Output
0


opposite of elvis operator is the !! operator
which returns the value on the right side of the expression,
even if the value on the left side is null or undefined, and it will throw an exception.

For example,

val value: Int? = null
val result = value!!

println(result)

// Output
java.lang.NullPointerException

It should be noted that the !! operator is not the same as the elvis operator:
It should not be used to check if a value is null and should be avoided.


Nullability
There are just a few ways how NPE may occur in Kotlin:

explicit call of throw NullPointerException() ;

!! syntax;

bad initializations, such as constructors and superclass constructors.

Remember that you don't have to pay as much attention to NPE as in Java and that you can concentrate on real tasks.
Don't forget that Kotlin is a pragmatic language. So, what do we have?

First of all, every reference in Kotlin can be either nullable or not.
Let's say we want to define a String variable, but we are not sure what it might be initially:

var name: String = null
So, what is null above?
It just means that the name variable doesn't have a certain value.
This code won't compile because we declared a non-null variable. How can we fix it? Pretty easy:

var name: String? = null
As you can see, we just added a ? sign right after the type of our variable.
We marked our name variable as nullable. We can also do the same with other types, like Int or Long:

var age: Int? = null
So, without a ? sign in the type you can't assign null to a variable.

Accessing nullable variables
Now try to guess what happens if you try to access this variable property:

var name: String? = null
print(name.length)
If you think there will be an error, you're right!
This code won't even compile. What can we do, then? Of course, we can add a common check for null like this:

if (name != null) {
    print(name.length)
}
If the name is null, the print won't be called.

Or we can access the length this way:

print(name?.length)
Here null is printed.

This ?. pair of symbols is called a safe call in Kotlin.
 */