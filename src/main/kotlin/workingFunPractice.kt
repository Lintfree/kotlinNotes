fun sum(a: Int, b: Int, c: Int): Int {
	return a + b + c
}

fun getLastDigit(a: Int): Int {
	return a.toString().last().digitToInt()
}

fun isRightEquation(a:Int, b:Int, c:Int): Boolean {
	return (a * b == c)
}

/*
See if you can get this to work.
The goal is to find the number of years it would take to reach 700000.
The interest rate is 1.071%
finished by ai, review to understand
*/


fun findYears(depo: Double): Int{
    var deposit = depo
    val interestRate = 1.071
    val max = 700000
    var years = 0
    //
    while ( deposit < max ) {
        deposit *= interestRate
        years++
    }
    return years
}




fun main() {
	val a = readln().toInt()
	val b = readln().toInt()
	val c = readln().toInt()

	println(sum(a, b, c))
	println(getLastDigit(a))
	println(isRightEquation(a, b, c))

	val depo = readLine()!!.toDouble()
	println(findYears(depo))
}



