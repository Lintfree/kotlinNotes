//If the coffee machine has enough supplies to make the specified amount of coffee,
// the program should print "Yes, I can make that amount of coffee".
// Otherwise, it should print "No, I can make only X cups of coffee".
fun totalCups(water: Int, neededWater: Int, milk: Int, neededMilk: Int, beans: Int, neededBeans: Int, cupsNeeded: Int) {
	val cups = listOf(water / 200, milk / 50, beans / 15)
	val cupsAvail = cups.minOrNull() ?: 0

	when {
		cupsNeeded == cupsAvail -> return println("Yes, I can make that amount of coffee")
		cupsNeeded < cupsAvail -> return println("Yes, I can make that amount of coffee (and ${cupsNeeded - cupsAvail} more than that)")
		cupsNeeded > cupsAvail -> return println("No, I can make only $cupsAvail cups of coffee")
	}
}

fun main() {
	println("Write how many ml of water the coffee machine has:")
	val water = readln().toInt()
	println("Write how many ml of milk the coffee machine has:")
	val milk = readln().toInt()
	println("Write how many grams of coffee beans the coffee machine has:")
	val beans = readln().toInt()
	println("How many cups of coffee will you need?")
	val cupsNeeded = readln().toInt()
	val neededWater = cupsNeeded * 200
	val neededMilk = cupsNeeded * 50
	val neededBeans = cupsNeeded * 15

	println(totalCups( water, neededWater, milk, neededMilk, beans, neededBeans, cupsNeeded))
	//TODO Remove Kotlin unit from being printed?
	/*
		println("Starting to make a coffee")
		println("Grinding coffee beans")
		println("Boiling water")
		println("Mixing boiled water with crushed coffee beans")
		println("Pouring coffee into the cup")
		println("Pouring some milk into the cup")
		println("Coffee is ready!")
	 */
}