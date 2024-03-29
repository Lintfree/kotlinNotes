
/*
class classes and Inheritance {
}

Here's how you usually create a class in Kotlin:

class Book(val pages: Int, val author: String)

If your code looks like this, you're creating a final class.
It means that this class won't be available for inheritance in the future.
You just prohibit it. However, don't worry, it's totally OK in Kotlin, as all classes are closed for inheritance by default.
As famous software engineer Joshua Bloch once said, "Design and document for inheritance or else prohibit it."

So, if you're really sure that you need to extend your Book class (parent class), here's an easy way to do it:

open class Book(val pages: Int, val author: String)

As you can see we just added the open keyword, and now our class is ready for extending. First, let's modify it:

open class Book(val pages: Int, val author: String, var cost: Float = 0F) {
    fun getFullInfo(): String {
        return "$pages pages, $author author, $$cost cost"
    }
}
And then extend it:

class Comics(pages: Int, author: String, cost: Float) : Book(pages, author, cost)

As you can see, we've created a new Comics class (child class) as an extension of our Book class.
We haven't added any additional logic here yet, we've just passed all of its parameters right into the Book main constructor.
Let's try it on a real example:

fun main() {
    val spidermanBook = Comics(60, "The Universe", 8.99F)
    print(spidermanBook.getFullInfo())
}
// output: 60 pages, The Universe author, $8.99 cost


Extend it
We can also add more functions to the child classes:

class Booklet(pages: Int, cost: Float) : Book(pages, "", cost) {
    fun getUSDCost(): String {
        return "$$cost cost"
    }

    fun getEuroCost(): String {
        return "€$cost cost"
    }
}
And use them:

fun main() {
    val centralBooklet = Booklet(5, 0.14F)
    print(centralBooklet.getUSDCost())
}
// output: $0.14 cost

Reuse it
You can do even more with the child classes. Let's create a function which defines whether your book is long enough:

fun isBigBook(book: Book): Boolean {
    return book.pages >= 100
}
Note that you can use this function for both parent and child classes:

fun main() {
    val spidermanBook = Comics(113, "The Universe", 8.99F)
    val centralBooklet = Booklet(5, 0.14F)
    println(isBigBook(spidermanBook))
    println(isBigBook(centralBooklet))
}
// output: true false
As you can see, inheritance has a powerful mechanism. We can pass any child of the Book instance to the isBigBook() function.
 */