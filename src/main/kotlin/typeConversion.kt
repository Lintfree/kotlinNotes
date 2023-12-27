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

    /* type coercion:
    what happens if we calculate the sum of Int and Long variables? In this case, the type is inferred from the context.
    the compiler automatically sets all components (it's called type coercion)
    and the result type to the widest type in the expression.
    This is called type coercion.
    short < int < long < float < double
     */

    // Int to Long:
    val num = 1
    val longNum: Long = 1000 // : explicitly specifies the type of the variable.
    val result = num + longNum  // not used here as without it the type is inferred.
    println("The result is $result")

    // Long to Double:
    val num2 = 1000L
    val doubleNum: Double = 0.0
    val result2 = num2 + doubleNum
    println("The result is $result2")


    // Double to Int:
    val num3 = 1000.0
    val intNum: Int = 1000 // is allowed because Int is assigned to Double
    val result3 = num3 + intNum
    println("The result is $result3")

    // Short and Byte: Byte and Short types are unusual in this respect.
    // If you need to do some calculations with these types, the result of the calculation is Int:
    val one: Byte = 1
    val two: Byte = 2
    val three = one + two // 3, Int

    //Short and Short
    val one2: Short = 14
    val two2: Short = 20
    val three2 = one2 + two2 // 32, Int

    // short and byte:
    val one3: Short = 100
    val two3: Byte = 5
    val zero = one3 % two3 // 0, Int

    /*
    if we want to sum two Byte variables and get a Byte result?
    In this case, you must manually perform type conversion:
     */

    val one4: Byte = 1
    val two4: Byte = 5
    val six = (one4 + two4).toByte() // 6, Byte

    //Remember that Byte can store data in the range -128..127.
    //If you need to store data in the range 0..255, you must use the unsigned Byte type.

    /*
    this causes type overflow
    fun main() {
    val a: Byte = 120
    println((a + a).toByte()) // prints -16 because 120+120 > 127
    toByte() can force conversion to byte, even if value over limit
    }
     */

    /*
    basic rules:
    1.If either operand is of type Double, the result is Double.
    2.Otherwise, if either operand is of type Float, the result is Float.
    3.Otherwise, if either operand is of type Long, the result is Long.
    4.Otherwise, the result is Int.
     */
}