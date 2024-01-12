fun actionIsCorrect(action: String): Boolean {
	TODO()
}

fun remainingValue() {
	TODO()
}

fun fillMl() {
	TODO()
}

fun buyCoffee() {
	TODO()
}

fun takeCoffee() {
	TODO()
}

fun main() {
	val action = readln()
	if (!actionIsCorrect(action)) {
		// something here
	} else {
		when (action) {
			"remaining" -> {
				remainingValue()
			}
			"fill" -> {
				fillMl()
			}
			"buy" -> {
				buyCoffee()
			}
			"take" -> {
				takeCoffee()
			}
		}
	}
}