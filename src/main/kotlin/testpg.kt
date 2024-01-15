
fun prt (a: Int, b: Int, c: Int, d: Int): Int {
    return (a + b + c + d)
}



fun main() {
    println("Enter four numbers:")
    val input = readln().toIntOrNull()
    //ensure input is an int
    // input only 4 numbers
    if (input != null) {
            val a = readln().toInt()
            val b = readln().toInt()
            val c = readln().toInt()
            val d = readln().toInt()
            println("The result is: ${prt(a, b, c, d)}")
        } else {
            println("Invalid input. Please enter an integer:")
            return
        }
    }




