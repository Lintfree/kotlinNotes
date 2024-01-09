fun actionIsCorrect(action: String): Boolean {
	// something here
}

fun remainingValue() {
	// something here
}

fun fillMl() {
	// something here
}

fun buyCoffee() {
	// something here
}

fun takeCoffee() {
	// something here
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