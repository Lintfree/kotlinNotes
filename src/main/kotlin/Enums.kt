/*
Basic Enums
enum is a keyword, which allows us to create our own enumeration (the word that enum represents) just from a usual class:

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

As you can see from the example above, here is an enum for 7 colors of the rainbow.
Now we have our own storage for all these colors. Each of them is a separate instance of Enum.
You'll see how we can modify it further. Although now you can create your own Enum, for instance, for statuses of orders:

enum class Status {
    OPEN, PENDING, IN_PROGRESS, RESOLVED, REJECTED, CLOSED
}
or for the main types of building materials:

enum class Materials {
    GLASS, WOOD, FABRIC, METAL, PLASTIC, CERAMICS, CONCRETE, ROCK
}

According to Kotlin Coding Conventions, you can use either uppercase underscore-separated names (as usual Kotlin constants are RED_COLOR)
or regular camel-humps names starting with an uppercase letter (RedColor).
In our examples, we will omit the second option and use only uppercase Enums for better understanding, but keep in mind that both options are possible.

Let's go back to our first example with colors.
Since each color is an instance of Rainbow Enum, you can initialize them by passing names of these colors to the constructor:

enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}
Now we can use color value wherever we want like this:

val color = Rainbow.RED.color
It looks very promising, but you may ask "What are the benefits?" That's the right question.
You'll find it out later, but now let's modify our Enum and add one more parameter per color:

enum class Rainbow(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF")
}
Great! Rainbow enum contains information not only about the name of the color but also its HEX value.
It's a widely used approach in web development to store a color value as a hexadecimal-digit form of blue, red, and green colors.
You can find out more about web colors here. https://en.wikipedia.org/wiki/Web_colors
Now, you can use them like this:

val rgb = Rainbow.RED.rgb

As we said before, Enum is still a custom class, so we can add to it our own methods.
Let's add a method which will print full information about an instance of our Rainbow:

enum class Rainbow(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF");

    fun printFullInfo() {
        println("Color - $color, rgb - $rgb")
    }
}
Now, let's call it:

val rgb = Rainbow.RED
rgb.printFullInfo()
The output will be the following:

Color - Red, rgb - #FF0000

Inside Enum
Now we know what Enum is and how to create it, but in most situations, that's not enough.
It's time to find out which methods and properties Enum provides in Kotlin out of the box:

1. name allows you to get the name of Enum's instance, for example:

val color: Rainbow = Rainbow.RED
println(color.name)
with the output:

RED

2. ordinal contains a position of Enum's instance, for example:

val color: Rainbow = Rainbow.GREEN
println(color.ordinal)
with the following output:

3

3. entries property returns an array of all instances of Enum.
It might be helpful if you want to iterate through Enum instances.
Now we can check if any specific color is part of the Rainbow or not.
The entries property is a modern and performant replacement for the synthetic values() function and it is the recommended way :

fun isRainbow(color: String) : Boolean {
    for (enum in Rainbow.entries) {
        if (color.toUpperCase() == enum.name) return true
    }
    return false
}
and try to call it:

println(isRainbow("black"))
with the following output:

false

4. valueOf() returns an instance of Enum by its name with String type and case sensitivity:

println(Rainbow.valueOf("RED"))
and the output will be:

RED

If there isn't any appropriate instance of Enum then IllegalArgumentException will be thrown.
Please, note that this method is case sensitive.

Let's look at the example with entries:

enum class Rainbow(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF"),
    NULL("", "");

    fun printFullInfo() {
        println("Color - $color, rgb - $rgb")
    }
}

fun findByRgb(rgb: String): Rainbow {
    for (rainbow in Rainbow.entries) {
        if (rgb == rainbow.rgb) return rainbow
    }
    return Rainbow.NULL
}
You can use it like this:

println(findByRgb("#FF0001"))
and the output will be:

NULL
Have you guessed why it is NULL?
As you might've noticed, we added one more NULL constant in order to return it if we cannot find a color by its RGB parameter.
In our example, there isn't any color associated with "#FF0001" RGB, therefore the output is NULL.


enum class DangerLevel (val danger: String, val level: Int) {
	HIGH("HIgh", 3),
	MEDIUM("Medium", 2),
	LOW("Low", 1);

	fun getLevel(): Int {
		return level
	}
}

/*
enum class DangerLevel(private val level: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = this.level
}
 */

fun main() {
	val high = DangerLevel.HIGH
	val medium = DangerLevel.MEDIUM
	val low = DangerLevel.LOW

	println(high.getLevel().toString() + ", " + medium.getLevel().toString())
}
*/

/*
enum class Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

fun main() = print(Rainbow.values().map { it.name }.contains(readLine()!!.toUpperCase()))

 */
//Above is better
/*
enum class RAINBOW {
	RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

}

	fun isRainbow(color: String): Boolean {
		for (enum in RAINBOW.entries) {
			if (color == enum.name) return true
		}
		return false
	}


fun main() {
	val color = readln( ).uppercase()
	println(isRainbow( color ))
}
*/

/*
val color: Rainbow = Rainbow.GREEN
println(color.ordinal)
 */

/*
enum class Rainbow(val order: Int) {
	RED(1), ORANGE(2), YELLOW(3), GREEN(4), BLUE(5), INDIGO(6), VIOLET(7)
}


fun main(): Unit {
	val input = readln().uppercase()
	val rainbow = Rainbow.valueOf(input)
	println(rainbow.order)
}
*/


//Write a program that declares an enum DaysOfTheWeek
// and prints the name of each enum's instance on a new line, starting from SUNDAY.


enum  class DaysOfTheWeek {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,

}

fun main() {
	for (day in DaysOfTheWeek.values()) {
		println(day)
	}
}


