/* Comparison
Structural equality have the same state
== is used to check structural equality
!= is used to check structural inequality

val blueBox = Box(3)          // box with 3 balls
val azureBox = blueBox
println(blueBox == azureBox ) // true, it's a copy
blueBox.addBall()             // add a ball to the first box
println(blueBox == azureBox ) // true, the second box also contains 4 balls
When you change the first box, its copy changes, too.
This is because blueBox and azureBox point to the same object.

Referential equality have the same object
=== is used to check referential equality
!== is used to check referential inequality

val blueBox = Box(3)
val azureBox = blueBox
val cyanBox = Box(3)
println(blueBox == azureBox)  // true
println(blueBox === azureBox) // true, azureBox points to the same object
println(blueBox == cyanBox)   // true both have 3 balls, but they point to different objects
println(blueBox === cyanBox)  // false, cyanBox points to another object because it is a new object

So, blueBox and cyanBox have the same state,
but they point to different objects.
In this case, if you change the state of blueBox, cyanBox remains the same:

blueBox.addBall()
println(blueBox == cyanBox) // false

interesting thing about the === operator is the equality of immutable objects.
var two = 2
var anotherTwo = 2
println(two === anotherTwo) // true
These variables point to the same object
you cannot change an immutable object, so if you try to do something with the variable,
it will point to a new object and other variables will still point to the old object
two++
println(two)        // 3
println(anotherTwo) // 2
immutable objects are really useful and help you avoid a lot of possible problems with copying.
2 is immutable, by adding 1 to two you create a new object
but the variable anotherTwo still points ti the old object

the familiar Int, String, Float, and Double in Kotlin are also objects!
But there is a nuance. For example,
the Int or String variables behave just like the primitive types of data in other programming languages,
but at the same time, they are objects – in other words, immutable objects. Let's look how it works:

var a: Int = 100
val anotherA: Int = a
println(a == anotherA)  // true
println(a === anotherA) // true
a = 200
println(a == anotherA)  // false
println(a === anotherA) // false

when we change the value of the variable a = 200, we do not change its object –
the variable a is assigned a new reference to the object with the value 200.

in this example, the variables list1 and list2 refer to the same object.
When you change the object through the first variable,
we see the updated data through the second variable.

val list1: MutableList<Int> = mutableListOf()
val list2: MutableList<Int> = list1
list1.add(1)
println("list1 $list1") // list1 [1]
println("list2 $list2") // list2 [1]
list2.add(5)
println("list1 $list1") // list1 [1, 5]
println("list2 $list2") // list2 [1, 5]

Structural equality of variables implies equality of inner states.
You can use the operators == and != to check structural equality.
Referential equality of variables means that these variables point to the same object.
You can use the operators === and !== to check referential equality.
The val keyword means that you cannot reassign the variable, not immutability.
 */