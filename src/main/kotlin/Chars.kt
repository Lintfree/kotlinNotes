/*
A character is just a symbol enclosed in single quotes.
The Char type represents letters (both uppercase and lowercase), digits, and other symbols:
 */

val lowerCaseLetter: Char = 'a'
val upperCaseLetter: Char = 'Q'
val number: Char = '1'
val space: Char = ' '
val dollar: Char = '$'

/*
A character can also be represented by its hexadecimal code in the Unicode table.
The code starts with \u:
 */

val ch = '\u0040' // it represents '@'
println(ch) // @

/*
You can also convert numbers to characters and vice versa.
 */

val ch = 'a'
println(ch.code)   // 97
val num = 97
println(num.toChar()) // a

/*
If you need to read one Char in a whole line, use this construction:
 */

val ch = readLine()!!.first()
println(ch)


/*
There are two operators for adding (+) and subtracting (-) integer numbers
in order to get the next and previous characters according to the Unicode order:
 */

val ch1 = 'b'
val ch2 = ch1 + 1 // 'c'
val ch3 = ch2 - 2 // 'a'

/*
It is possible to use the increment (++) and decrement (--) operators in their prefix and postfix forms.
The assignment operator combined with + or - also works for characters, as well as += and -=.
The comparison operators (==, !=, >, <, >=, <=) can be used with characters.
 */


var ch = 'A'

ch += 10
println(ch)   // 'K'
println(++ch) // 'L'
println(++ch) // 'M'
println(--ch) // 'L'
println('a' < 'c')  // true
println('x' >= 'z') // false
println('D' == 'D') // true
println('Q' != 'q') // true because capital and small letters are not the same
println('A' < 'a')  // true because capital Latin letters are placed before small ones


/*
There are some special characters starting with a backslash \, which are known as escape or control sequences.
Most of them do not have corresponding symbols, and you cannot find them on your keyboard.
To represent such characters, we use a pair of regular symbols.
In a program, this pair is considered as exactly one character with the appropriate code.
'\n' is the newline character;
'\t' is the tab character;
'\r' is the carriage return character;
'\\' is the backslash character itself;
'\'' is the single quote mark;
'\"' is the double quote mark.
 */

print('\t') // makes a tab
print('a')  // prints 'a'
print('\n') // goes to a new line
print('c')  // prints 'c'

/*
we can check whether a Char is a digit: all ten digits have codes from '\u0030' to '\u0039'.
If the input is a digit, '0', '1', '2', ..., '8' or '9' (without quotes), the program prints true.
Otherwise, it prints false.
*/

fun main() {
	val ch = readln().first()
	val isDigit = ch >= '\u0030' && ch <= '\u0039'

	println(isDigit)
}

/*
There's a variety of useful functions to work with characters. You can use these functions instead of dealing with character codes.
isDigit() returns true if the given character represents a digit ('1', '2', etc); otherwise, false;
isLetter() returns true if the given character represents a letter ('a', 'B', 'm', etc); otherwise, false;
isLetterOrDigit() returns true if the given character represents a letter or a digit; otherwise, false;
isWhitespce() returns true if the given character represents a whitespace (' ', or '\t', or '\n'); otherwise, false;
isUpperCase() returns true if the given character is an uppercase character; otherwise, false;
isLowerCase() returns true if the given character is a lowercase character; otherwise, false;
toUpperCase() returns the uppercase form of the given character (before Kotlin 1.5; you shouldn't use it nowadays);
uppercaseChar() returns the uppercase form of the given character ;
uppercase() returns a String with the uppercase form of the given character;
toLowerCase() returns the lowercase form of the given character (before Kotlin 1.5; you shouldn't use it nowadays);
lowercaseChar() returns the lowercase form of the given character;
lowercase() returns a String with the lowercase form of the given character
 */

val one = '1'

val isDigit = one.isDigit()   // true
val isLetter = one.isLetter() // false

val capital = 'A'
val small = 'e'

val isLetterOrDigit = capital.isLetterOrDigit() // true

val isUpperCase = capital.isUpperCase() // true
val isLowerCase = capital.isLowerCase() // false

val capitalEString = small.uppercase() // "E"
val capitalE = small.uppercaseChar()   // 'E'

//fun main() {  check if uppercase or digit and not 0
	val char = readln().first()
	val upper = char.isUpperCase() || char.isDigit() && char != '0'
	println(upper)

//fun main() {  check if same unicode
	val first  = readln().toInt()
	val second : Char = readln().first()
	val num = first.toChar()
	println(second == num)

//fun main() {  checks if chars are in order

	val first : Char = readln().first()
	val second : Char = readln().first()
	val third : Char = readln().first()

	println(first +1 == second && second == third - 1)

}
