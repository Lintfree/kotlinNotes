/*
In Kotlin, the this keyword is a reference to the current receiver of the function or the current instance of the class in which it is used. Its behavior can vary depending on the context in which it is used.

Here are the main uses of the this keyword in Kotlin:

Inside a Class:
Inside a class, this refers to the current instance of the class.
It can be used to access instance properties and methods, or to call other constructors from within a constructor.
For example:

class MyClass {
    val property: Int = 10

    fun printProperty() {
        println(this.property)  // Accessing the property of the current instance using this
    }
}
Extension Functions:
In extension functions, this refers to the receiver object on which the extension function is called.
It can be used to access members of the receiver object.
For example:

fun String.printLength() {
    println("Length of the string is: ${this.length}")  // Accessing the length property of the receiver object
}
Inside Lambda Expressions:
In a lambda expression, this refers to the context in which the lambda is executed.
It can have different meanings depending on the context,
such as the instance of a class, or the outer scope if the lambda is defined outside of a class. For example:

class MyClass {
    fun executeLambda() {
        val lambda: () -> Unit = {
            println(this)  // Inside the lambda, this refers to the instance of MyClass
        }
        lambda()
    }
}
Referring to Outer Scope:
When used in a nested class or lambda, this@label can be used to explicitly refer to the outer scope.
This is useful when there is potential ambiguity between outer and inner scopes. For example:

class OuterClass {
    val property: Int = 10

    inner class InnerClass {
        fun printProperty() {
            println(this@OuterClass.property)  // Referring to the property of the outer class
        }
    }
}
The this keyword in Kotlin provides a way to refer to the current instance or receiver object within different contexts,
and it is an important part of the language for accessing and manipulating class members and extension functions.
 */