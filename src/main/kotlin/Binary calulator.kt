// Binary Calculator in Kotlin
// convert decimal to binary

fun main() {
	val decimal = readln().toInt()
	val binary = Integer.toBinaryString(decimal)
	println("Binary of $decimal is $binary")
}


// convert binary to decimal
/*
fun main() {
	val binary = readln().toInt()
	val decimal = Integer.parseInt(binary.toString(), 2)
	println("Decimal of $binary is $decimal")
}
*/

//add 2 binary numbers
/*
fun addBinary(binary1: String, binary2: String, ): String {
	var i = binary1.length - 1
	var j = binary2.length - 1
	var carry = 0
	var result = ""

	while (i >= 0 || j >= 0 || carry > 0) {
		val sum = carry
		if (i >= 0) carry += binary1[i--] - '0'
		if (j >= 0) carry += binary2[j--] - '0'
		result = (carry % 2).toString() + result
		carry /= 2
	}
	return result
}

//add 2 binary numbers and return decimal
fun main() {
	val binary1  = readln()
	val binary2 = readln()
	println("Sum of $binary1 and $binary2 is ${addBinary(binary1, binary2)}")
	println("The decimal representation of the sum of $binary1 and $binary2 is ${addBinary(binary1, binary2).toInt(2)}")
}

*/



/*
2 --> 010
3 --> 011
4 --> 100
5 --> 101
6 --> 110
7 --> 111
8 --> 1000
9 --> 1001
10 --> 1010
11 --> 1011
12 --> 1100
13 --> 1101
14 --> 1110
15 --> 1111
16 --> 10000


 */


