import kotlin.math.roundToInt
/*
Type Conversion
To convert a value from one type to another, you can use the following functions:
toInt(): Use this when you need to transform the value into an Int,
or an integer format of a value.

toFloat(): Converts the value to a floating-point representation, or Float.

toLong(): Use this when working with larger integer values;
it transforms the value into a Long.

toDouble(): Use this when dealing with high-precision arithmetic,
it transforms the value into a Double.

toByte(): Transforms the value into a Byte;
it's often used when dealing with low-level byte manipulation.

toShort(): Transforms the value into a Short.
This method is lesser-known but can be helpful for specific scenarios.

toString(): This is often used for converting the value into a text representation,
String, or for concatenation.
 */

/*Type conversion best practices
You must execute type conversion with caution in Kotlin to avoid problems like precision loss or ClassCastException.
Here are some guidelines to remember:

Use Explicit Conversions: Kotlin doesn't permit implicit type conversion,
so utilize explicit methods like toInt(), toDouble(), and so on.
*/
fun main() {
    val i: Int = "123".toInt()

//Check for null: If you are working with nullable types, make sure to use the safe call operator ?. before conversion.
    val s: String? = null
    val j: Int? = s?.toInt()

//Handle NumberFormatException:
// Potential NumberFormatException should be handled when converting from String to a numeric type.
    val t: String = "abc"
    val k: Int? = try {
        t?.toInt()
    } catch (e: NumberFormatException) {
        null
    }

//Avoid Loss of Precision: Be careful when converting between numeric types to avoid losing precision.
    val l: Long = 1_000_000_000L
    val m: Int = l.toInt() // Potential loss of precision

    /*Smart Casts with is: Use is checks for safe casting when dealing with inheritance.
if (obj is String) {
    println(obj.length)
}
*/

//Use the as? Operator for Safe Casting: Use as? to safely cast to a type and to avoid ClassCastException.
// This will return null if the operation fails.
    val x: Any = "Kotlin"
    val u: String? = x as? String

    // This will return true or false.
    //not sure how it works without an if statement to seperate everything else
    // from typed true.
    //fun main() = println(readln().toBoolean())

    //import kotlin.math.roundToInt, rounds to nearest integer instead of rounding down to zero
    val distanceToObjective = 4.6
    println("The objective is about ${distanceToObjective.roundToInt()} miles away")
}