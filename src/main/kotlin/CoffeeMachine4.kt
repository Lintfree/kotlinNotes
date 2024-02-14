class CoffeeMachine
var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550

fun buy() {
	println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino")
	val choice = readln()
	when  (choice){
		"1" -> {
			water -= 250
			milk -= 0
			beans -= 16
			cups -= 1
			money += 4

		}
		"2" -> {
			water -= 350
			milk -= 75
			beans -= 20
			cups -= 1
			money += 7

		}
		"3" -> {
			water -= 200
			milk -= 100
			beans -= 12
			cups -= 1
			money += 6
		}
	}
}

//Todo fill
/*fun fill() {
    println("Write how many ml of water do you want to add:")
    val water = readln().toInt()
    println("Write how many ml of milk do you want to add:")
    val milk = readln().toInt()
    println("Write how many grams of coffee beans do you want to add:")
    val beans = readln().toInt()
    println("Write how many disposable coffee cups do you want to add:")
    val cups = readln().toInt()
    return fill(water, milk, beans, cups, money)
}

//Todo take
fun take() {
    println("I gave you $$money")
    return take(money)
}
*/

fun main() {
	println("The coffee machine has:")
	println("$water ml of water")
	println("$milk ml of milk")
	println("$beans g of coffee beans")
	println("$cups disposable cups")
	println("$$money of money")
	println()
	println("Write action (buy, fill, take):")

	val action = readln()
	when (action) {
		"buy" -> buy()
		//"fill" -> fill()
		//"take" -> take()
	}
	println( )
	println("The coffee machine has:")
	println("$water ml of water")
	println("$milk ml of milk")
	println("$beans g of coffee beans")
	println("$cups disposable cups")
	println("$$money of money")
}