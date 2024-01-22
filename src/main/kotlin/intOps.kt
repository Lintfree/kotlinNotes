fun main() {
    /* += assignment after addition: A += B equals A = A + B
    -= assignment after subtraction: A -= B equals A = A - B
     *= assignment after multiplication: A *= B equals A = A * B
    /= assignment after division: A /= B equals A = A / B
    %= assignment of the remainder after division: A %= B equals A = A % B
     */

    var num = 3
    num++  //increments by 1
    println(num)
    num--//subtracts by 1
    println(num)

    //prefix and postfix
    var num2 = 3
    var num3 = 3
    println(++num2) //adds 1 before var is used  (4)
    println(--num2) //subtracts 1 before var is used  (3)
    println(num3++) //adds 1 after var is used, prints 3 but assigns variable as 4
    println(num3--) //subtracts 1 after var is used prints 4 but assigns variable as 3
    println(num3) //prints 3 because it was used in line above

    /* Order of precedence
    1. Parentheses ( (expr) );
    2. Postfix increment/decrement ( expr++, expr--);
    3. Unary plus/minus, prefix increment/decrement ( -expr, ++expr, --expr );
    4. Multiplication, division, and modulus ( *, /, % );
    5. Addition and subtraction ( +, - );
    6. Assignment operations ( =, +=, -=, *=, /=, %= ).
     */

    /*
    Byte: 8 bits (1 byte), range varies from -128 to 127;
    Short: 16 bits (2 bytes), range varies from -32768 to 32767;
    Int: 32 bits (4 bytes), range varies from −2,147,483,648 to 2,147,483,647;
    Long: 64 bits (8 bytes), range varies from 9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.
    Float: 32 bits (4 bytes), range varies from 1.4E-45 to 3.4028235E38;
    Double: 64 bits (8 bytes), range varies from 4.9E-324 to 1.7976931348623157E308.
    The range includes 0, that's why we subtract 1 from the upper bound.
     */

    val zero = 0 // Int
    val one = 1  // Int
    val oneMillion = 1_000_000  // Int
    val twoMillion = 2_000_000L           // Long because it is tagged with L
    val bigNumber = 1_000_000_000_000_000 // Long, Kotlin automatically chooses it (Int is too small)
    val ten: Long = 10                    // Long because the type is specified
    val shortNumber: Short = 15 // Short because the type is specified
    val byteNumber: Byte = 15   // Byte because the type is specified

    /* Double (64 bits) and Float (32 bits). These types can store only a limited number of decimal digits
    (~6-7 for Float and ~14-16 for Double). The Double type is more common in practice:
     */
    val pi = 3.1415              // Double
    val e = 2.71828f             // Float because it is tagged with f
    val fraction: Float = 1.51f  // Float because the type is specified

    /* To display the maximum and minimum value of a numeric type (including Double and Float),
    you need to write the type name followed by a dot . and then either MIN_VALUE or MAX_VALUE:
     */
    println(Int.MIN_VALUE)  // -2147483648
    println(Int.MAX_VALUE)  // 2147483647
    println(Long.MIN_VALUE) // -9223372036854775808
    println(Long.MAX_VALUE) // 922_3372_036_854_775_807
    // It is also possible to get the size of an integer type in bytes or bits (1 byte = 8 bits):
    println(Int.SIZE_BYTES) // 4
    println(Int.SIZE_BITS)  // 32

    //Each character is a letter character in single quotes. The size is similar to the Short type (2 bytes = 16 bits):
    val lowerCaseLetter = 'a'
    val upperCaseLetter = 'Q'
    val number = '1'
    val space = ' '
    val dollar = '$'
    //Characters can represent symbols of many alphabets, including hieroglyphs and some special symbols.

    //Boolean. It can store only two values: true and false.
    //It represents only one bit of information, but its size is not precisely defined.
    val enabled = true
    val bugFound = false

    fun internalFun() {
        val a = readln().toInt()
        val b = readln().toInt()
        println("$a plus $b equals ${a + b}")
    }

    val currentBalance = 1120.40
    println("$%,.2f".format(currentBalance))
    //%,.2f is a format string. The % indicates it is a format specifier
    //The , indicates that thousands separators should be used.
    //The .2f indicates that the number should be displayed with two decimal places.
    //format() takes the format string and value to format and returns the formatted string.

    /* unsigned numeric types:
    UByte = 0 to 255,
    UShort = 0 to 65535,
    UInt = 0 to 4294967295,
    ULong = 0 to 18446744073709551615
    unsigned numeric types cannot be negative values
    float and double have no unsigned counterpart
    declaring unsigned numeric types:
    */
    val unsignedByte: UByte = 5.toUByte()
    val unsignedShort: UShort = 5.toUShort()
    val unsignedInt: UInt = 5.toUInt()
    val unsignedLong: ULong = 5.toULong()
    val removeExplicitType = 5u

    /* Kotlin does not automatically convert between signed and unsigned types,
    so you need to explicitly convert between them:
     */
    var playerLevel = 5u
    val levelsToAdd = 1
    playerLevel += 1.toUInt() // adding a UInt to a UInt is allowed
    playerLevel += 1u // shorthand for above
    //playerLevel += 1 compiler error must convert 1 to UInt first
    //playerLevel += levelsToAdd error cannot add an Int to a UInt
    print(playerLevel * 10u) // is allowed
    //print(playerLevel * 10) error is not allowed because playerLevel is UInt

    /*
    if odd number, add 1, else add 2.
    if (number % 2 == 0) {
        println(number + 2)
    } else {
       println(number + 1)
    }
    better way below
     */

    //fun main() {
        var num4 = readln().toInt()
        println(++num4 + num4 % 2) //adds 1 before var is used then adds modulus

    //last digit
    val a = readln().toInt()
    val lastDigit = a % 10
    println("$lastDigit")

    //better way
    // fun main() = print(readLine()!!.last()) I didn't know about .last()


    /*
    You are given a number that represents the number of seconds passed since 1.1.1970.
    1/1/1970 is unix epoch which means:
    Unix time is currently defined as the number of non-leap seconds which have passed since 00:00:00 UTC on Thursday, 1 January 1970
    Write a program that calculates the current time,
    i.e., finds the hours, minutes, and seconds of the given number of seconds.
    Format: hours:minutes:seconds

    fun main() {
        val totalSeconds = System.currentTimeMillis() / 1000 // do not change this line
        val days = totalSeconds / 86400                  // how many days
        val hours = (totalSeconds % 86400) / 3600        // how many hours
        val minutes = (totalSeconds % 3600) / 60         // how many minutes
        val seconds = totalSeconds % 60                  // how many seconds
        println("$days:$hours:$minutes:$seconds")

    }
     */

    /*
    you cannot check the equality of Int and Long! You can compare Int and Long freely with >, <. >=, <=,
    but cannot use == and !=. You can check equality only for the same types, so you need to convert Int to Long

    val left = 100
    val right = 200
    val number = readln().toInt()
    val inRange = number >= left && number <= right // joining two expressions using AND
     */


    /*
    Double can represent a wider number range than Float.
    Double  range is 4.9E-324 to 1.7976931348623157E308;
    Float range is 1.4E-45 to 3.4028235E38.
    You can use the .toDouble() function to convert a Float into a Double.
    In practice, programmers mostly use the Double type.
    Double is the default type for numeric values in Kotlin.
    You can also use it to represent non-numeric values, such as the pi constant:
    val pi = 3.1415
    val squaredPi = pi * pi

    For fractional operands, the operator / performs division with a remainder, not integer division.
    println(squaredPi / 2) // prints 4.934511125

    Errors during computation
    Be careful — operations with floating-point numbers can produce an inaccurate result:

    You can use readln() to read Doubles and Floats from the standard input:
    val f = readln().toFloat()  // Float
    val d = readln().toDouble() // Double

     a program that calculates a triangle area. To find it, the program reads the base and the height from the standard input, then multiplies them and divides the result by 2. Note that the base and the height are perpendicular to each other.

    fun main() {
        val base = readln().toDouble()
        val height = readln().toDouble()

        val area = (base * height) / 2

        println(area)
    }

    Decimal separator
    It is crucial to use the correct decimal separator.
    The separator is locale-dependent, such as a dot for the US locale.
    If you happen to employ any other character, it may crash your program.
    If you work with another locale and want to use the dot character, you can use this construction:

    import java.util.Locale

    val floatNum = readln().format(Locale.US).toFloat()


    fun main() {
        val miles = readLine()!!.toDouble()
        val time = readLine()!!.toDouble()

        println(miles / time)
    }


    import kotlin.math.pow

    fun main() {
	    val x = readln().toDouble()

	    println(x.pow(3.0) + x.pow(2.0) + x + 1.0)
    }
     */


}