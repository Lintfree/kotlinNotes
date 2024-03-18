/*
JSON's lightweight syntax allows you to easily store and send everything from numbers and strings to arrays and objects to other apps.
You can also create more complex data structures by linking arrays to each other.

Basic syntax and structure
JSON text can be built on one of two structures:

a collection of the key:value pairs (associative array);

an orderly set of values (array or list).

JSON objects are written in curly braces {}, and their key:value pairs are separated by a comma ,.
The key and the value in the pair are separated by a colon :. Here is an example for you:

{
    "first_name": "Sophie",
    "last_name": "Goodwin",
    "age": 34
}
Here, you can see some user data in JSON format.

Keys in an object are always strings, but values can be any of seven types of values, including another object or array.

Note that you should not put a comma (,) after the last key:value pair.

Again, the value in the array can be of any type, including another array or object. Here is an example of an array:

["night", "street", false, [ 345, 23, 8, "juice"], "fruit"]
Most often, an array will include similar elements.

JSON does not support comments.

Nested objects
JSON is a highly flexible format. You can nest objects inside other objects as properties:

{
  "persons": [
    {
      "firstName": "Whitney",
      "lastName": "Byrd",
      "age": 20
    },
    {
      "firstName": "Eugene",
      "lastName": "Lang",
      "age": 26
    },
    {
      "firstName": "Sophie",
      "lastName": "Goodwin",
      "age": 34
    }
  ]
}
The data has a tree-like structure if objects and arrays contain other objects or arrays.

The nested objects are fully independent and may have different properties:

{
  "persons": [
    {
      "firstName": "Whitney",
      "age": 20
    },
    {
      "firstName": "Eugene",
      "lastName": "Lang"
    }
  ]
}
But in practice, such objects often look similar.

camelCase vs. snake_case
If you have read the JSON objects examples carefully, you might have a lingering question: what style of compound word writing should be used for JSON?

CamelCase is a style where compound words are together without spaces, but each word inside the phrase starts with a capital letter.
The style is called camelCase because the capital letters inside the word resemble camel's humps.

With snake_case style, compound words are written with the underscore.

The right choice of JSON naming convention depends directly on your programming language and libraries.
You can use both camelCase and snake_case; any choice will be valid but do not mix them in one JSON.

JSON advantages
JSON is a widespread format for data exchange on the Internet because of its strong advantages:

compactness;

flexibility;

high readability, even for people far from programming;

most programming languages have functions and libraries for reading and creating JSON structures.

JSON is a popular format for transmitting structured data over a network.
When you serialize data to JSON, you can easily deserialize it back without losing any information.
One of the main advantages of JSON over plain text is that it allows you to describe relationships between objects through nesting and key-value pairs.
Many of the websites you visit likely use JSON as well.

Other popular applications of JSON are data storage and configuration files for other programs.
if you want to save the code on your computer, save the files to the .json extension.


Moshi
Moshi is a Kotlin library for working with JSON.

Moshi is fast and requires less memory, making it a great option to choose.
In this topic, you'll learn how to use it and find out more about the structure of JSON along the way.

To use the Moshi library, we need to add the following dependency to our build.gradle.kts file in the dependencies section:

implementation("com.squareup.moshi:moshi-kotlin:1.11.0")
With this in place, our IDE will import the required classes as we write our code.

You can find out more by visiting Moshi's GitHub page.

Serializing Kotlin objects into JSON strings
We'll start by defining a Human class that we can use to perform operations:

class Human(var name: String, var age: Int, var friends: Array<String>)
Now let's create an instance of the Human class:

val human = Human("Mike", 20, arrayOf("Alex", "Valery", "Ann"))
To work with Moshi, we need to use the Builder pattern to create the following object:

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
Next, we need to create an adapter to serialize the Human class and pass it the correct reference.
This can be done with the Kotlin Classname::class.java feature:

val humanAdapter = moshi.adapter(Human::class.java)
That's it! Now we're all set to quickly and conveniently convert our object into a JSON representation.
For simplicity, we'll print the string to the output stream. However, in an actual application, we could save the result to a text file or database.

print(humanAdapter.toJson(human))
// {"name":"Mike","age":20,"friends":["Alex","Valery","Ann"]}

Deserializing JSON into Kotlin objects
We've got our adapter ready for the class, so let's try to use it to recreate a new object from a JSON string:

val newHumanString = """
    {"name":"John",
    "age":25,
    "friends":["Mike","Helen"]}""".trimIndent()

val newHuman = humanAdapter.fromJson(newHumanString)

The fromJson method doesn't return a Human, it returns a Human? object.
This is because it can be nullable (the fromJson method may not recognize the supplied JSON string), so ?. is used to access it safely.

Now we want to deserialize a more complex structure — a list of class objects.

Because our transformation will involve two classes, Human and List, we need to pass them in a ParameterizedType object.
This approach allows us to store information about both classes together so it can be passed to the adapter for use during deserialization:

val humanList = listOf(human, newHuman)

val type = Types.newParameterizedType(List::class.java, Human::class.java)
val humanListAdapter = moshi.adapter<List<Human?>>(type)
print(humanListAdapter.toJson(humanList)) // [{"name":"Mike","age":20,"friends":["Alex","Valery","Ann"]},{"name":"John","age":25,"friends":["Mike","Helen"]}]
Having created a suitable adapter by combining the List and Human classes, we can use it to convert a JSON string:

val jsonStr =
    """[{"name":"Nick","age":10,"friends":["Valery"]},
       {"name":"John","age":25,"friends":[]},
       {"name":"Kate","age":40,"friends":[]}]
       """.trimIndent()

val newHumanList = humanListAdapter.fromJson(jsonStr)

Working with JSON
In the previous section, we learned how to retrieve objects from JSON via deserialization.
Now we'll look at some examples of how to make use of them:

It's simple to find out the name of the newHuman object we created with our adapter:

print(newHuman?.name) // John
We can output more complex data as well. Let's see who John's friends are!

print(newHuman?.friends.contentToString()) // [Mike, Helen]
We also created an adapter based on two classes that enabled us to deserialize a list of Human objects. Here's what it contains:

for (h in newHumanList!!) {
    print(h?.name + " ")
} // Nick John Kate
We are sure our list is definitely not null, so use !! when we refer to it.

For the final example, let's change our class a little by adding a Map that displays subject grades:

class Human(var name: String, var age: Int, var friends: Array<String>, var grades: Map<String, String>)
Next, create an appropriate adapter that includes Map:

val type = Types.newParameterizedType(List::class.java, Human::class.java, Map::class.java)
val humanListAdapter = moshi.adapter<List<Human?>>(type)
We finish by converting our objects from a JSON string as we did before:

val jsonStr =
    """[{"name":"Ruslan","age":20,"friends":["Victoria","Valery"],
        "grades":{"Math":"A","Philosophy":"F","Physics":"D"}},
        {"name":"Victoria","age":35,"friends":["Ruslan","Anastasia"],
        "grades":{"Math":"B","Philosophy":"C","Physics":"B"}}]""".trimIndent()
val humanList = humanListAdapter.fromJson(jsonStr)
But this time, we're also able to display information about people's grades, as shown below:

for (h in humanList!!) {
    println(h?.name + " has a grade of ${h!!.grades["Math"]} in maths")
}
// Ruslan has a grade of A in maths
// Victoria has a grade of B in maths
 */

/*
{
	persons: [  quotes missing around persons
	{
		"firstName": "Stanislaw",
		"lastName": "Lem",
		"book": [
		{
			"title": "Summa Technologiae",
			"year": 1964
		}
		]
	},
	{
		"firstName": "Isaac",
		"lastName": "Asimov",
		"book": [
		{
			"title": "The End of Eternity",
			"year": 1955
		}
		]
	}
	]
}

 */

/*
class Tourist(val name: String, val age: Int, val visitedCountries: Array<String>)

val moshi = Moshi.Builder()
	.add(KotlinJsonAdapterFactory())
	.build()

val touristAdapter = moshi.adapter(Tourist::class.java)

val touristString = """
    {"name":"Jacky",
    "age":23, 
    "visitedCountries":["Israel","Argentina", "Malaysia"]}""".trimIndent()

val newTourist = touristAdapter.fromJson(touristString)

println(visitedCountries(newTourist!!))

 */