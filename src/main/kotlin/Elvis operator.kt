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
 */