/*
A regular expression (regex or regexp for short) is a sequence of characters that describes a common pattern for a set of strings.
Such patterns can be used to search, edit, and manipulate texts.
They can either check if a whole string or its substring matches the given pattern or replace the substring with another one.

When do we need such patterns? Say we want to obtain all the files with the same extension (like .pdf),
or extract all the entries of a particular name in different forms (for example, Edgar Poe, Edgar Allan Poe, E. A. Poe, etc.),
all email addresses, or even find all numeric structures denoting dates (02/03/2020).
With regexps, such tasks can be done in one line.

How do such patterns look? Well, at first, they may seem confusing, look, for example, at \d+(\.\d)? or [a-zA-Z].
And they're often substantially longer. We'll start with the basics, though.

Regexps may be regarded as a kind of sublanguage that most programming languages support,
but there are some differences in syntax called "flavors".
In this topic, we will consider regexps in isolation from programming languages to understand the general idea.

While learning this topic, you can visit the regexp site (https://regex101.com)to play around with regular expressions from our examples.
Choose PCRE as the flavor. It means Perl Compatible Regular Expressions which are the most common standard in practice.

Matching on examples: more PARKs
Let's start by exploring how matching works formally.
Although a regex pattern can be quite a complicated expression containing characters with special meaning,
the simplest regex is just a string of simple characters.

Suppose, there is a set of words: PARK, SPARK, PARKING, MARK, QUARKS.
You need to check which of them contain the word PARK.
This is what happens, for example, when you perform a Ctrl+F search on a web page.

We can easily solve this problem using the PARK pattern.
The pattern means that symbols P, A, R, K in a word must follow each other from the left end to the right in a word.
We suppose that the whole word matches the pattern if any part (substring) of the word matches it.

For example, the word PARK matches our pattern.
Here are some explanations:

the word PARK exactly matches our pattern;

the word SPARK matches our pattern because it has a suitable substring;

the word PARKING matches our pattern due to the same reason;

the word MARK doesn't match our pattern because of the letter M;

the word QUARKS doesn't match our pattern since it does not have a suitable part that matches PARK.

To sum up, only three words match the PARK pattern.

In regular expressions, the case of characters is relevant: park is not the same as PARK, i.e., they do not match.

In addition, let's consider another sequence of characters PAKR.
It does not match our pattern since the two characters are in the wrong (reverse) order.

The power of regular expressions
Finding substrings is not very impressive, though.
The real power of regular expressions comes when you start using special metacharacters called wildcards.
They allow you to define a pattern, so you can match strings that do not necessarily contain an identical sequence of characters.
You can skip some characters in a string or match different characters in the same positions, or even repeat a character several times.

Let's introduce the two simplest wildcards: dot and question mark.

The dot wildcard matches any character except a newline.
The question mark wildcard matches any character, including a newline.

The dot character
The dot character . matches any single character including letters, digits, and so on, except for the newline character,
unless it is specified.

Let's look at our previous example again with several additional words.

As you remember, in the previous example, two words did not match the pattern because of one unsuitable character.
Let's consider them and also add two additional words.
Here is our new pattern .ARK with the dot character. It says: "there is any character followed by ARK".

regex matching check using a pattern with dot character

Hooray, both words MARK and QUARKS match the new pattern!
But the WARM word does not. Think for a minute, how can this be fixed?

Tip: The answer is to use the .AR. pattern, which is matched by WARM, CLARA, PART, and so on.

The word ARK also does not match our pattern, since it does not have a character in the . position in the pattern, while it is required.

The question mark
The question mark ? is a special character that means “the preceding character or nothing".
The question mark ? signals that the character before it can occur once or zero times in a string to match the pattern.
When can we use it?

Maybe with this example, you will finally begin to feel the magic of regexps.
Consider the difference between British and American spelling.
Imagine, we are trying to find all the studies mentioning color blindness in some publications' archives.
However, it contains different sources and their spelling may vary. What word should we look for? The answer is both!

The pattern colou?r will match the strings colour and color, but not the string coloor.
It is also possible to include the possibility of different letter cases to match the uppercase "Color" as well.
We will learn how it is done in later topics.

Let's return to our previous example.
The word ARK does not match the .ARK pattern. But if we add ? right after the dot character .?ARK,
the word ARK will match the new pattern since the first character is optional now.

Note how we combine the powers of the different wildcards in the combination .?. It is an underlying idea of regexps as well.

Regexps allow you to find matching strings by a certain pattern.
They use special characters with special meanings along with simple characters in their literal interpretation:

the dot . character matches any single character except for \n;

the question mark ? character means "the previous character can be absent from the string";

regular expressions are case-sensitive.

Creating a regular expression
Let's look at two possible ways to make a regex instance in Kotlin.

The first way is creating a String instance and then calling the method toRegex(),
which will make a regex out of that string:

val string = "cat" // creating the "cat" string
val regex = string.toRegex() // creating the "cat" regex
Another way is calling the Regex constructor:

val regex = Regex("cat") // creating a "cat" regex
The result will be the same: we’ll get the required regular expression.
For now, we can assume that these options are equally good,
and choosing one over the other is a matter of personal preference.

Simple matching
Now let’s see how we can actually use regexes. The first method we will consider is matches().
It is used for finding a full match, that is, the whole string has to match the pattern.

Take a look at the signature: fun Regex.matches(string: CharSequence): Boolean.
As you see, it takes a regex, calls the string that will be matched against the regular expression, and returns the boolean result.

If you want more examples, check out the following code snippet:

val regex = Regex("cat") // creating the "cat" regex

val stringCat = "cat"
val stringDog = "dog"
val stringCats = "cats"

println(regex.matches(stringCat))   // true
println(regex.matches(stringDog))   // false
println(regex.matches(stringCats))  // false
As you can see in the example above, when our regex is just a sequence of simple characters,
the result will be true only when the string matches the regex perfectly.

This might seem a little excessive: after all, we could simply compare two strings, which would be faster and easier.
This is true, but remember that the true power of regular expressions is the option to use special characters that can define a certain pattern.
This pattern can be matched against multiple strings at once.

In addition to Regex.matches(),
there are two other functions that are used to check whether a regular expression has an exact match to part of a String or CharSequence
starting at a specific index:

Regex.matchAt(). This function returns the match if it's found, or null if it isn't.
If there is a match, the returned object is of type MatchResult, so we can access the matched String using the value property.
Here is an example:

val regex = Regex("cat")
val stringCat = "The cat is eating."

println(regex.matchAt(stringCat, 4)?.value) // cat
println(regex.matchAt(stringCat, 5)?.value) // null

Regex.matchesAt(). This function checks for a match and returns a Boolean result:

val regex = Regex("cat")
val stringCat = "The cat is eating."

println(regex.matchesAt(stringCat, 4)) // true
println(regex.matchesAt(stringCat, 5)) // false

In most programming languages, including Kotlin, the index of a string or array starts at 0.
This means that the first character or element is at index 0, the second is at index 1, and so on.

The dot character
This special character is already familiar to you: the dot . matches any single character including letters, digits, spaces, and so on.
The only character it cannot match is the newline character \n. Other control characters such as \b and \t will still match.

Consider the following examples of using the dot:

val regex = Regex("cat.") // creating the "cat." regex

val stringCat = "cat."
val stringEmotionalCat = "cat!"
val stringCatWithSpace = "cat "
val stringCatN = "cat\n"

println(regex.matches(stringCat))   // true
println(regex.matches(stringEmotionalCat))   // true
println(regex.matches(stringCatWithSpace))  // true
println(regex.matches(stringCatN))  //false
It's not complicated but certainly useful.
For example, it can come in handy when you need to find the same word that appears in the text in different forms.

The question mark
The question mark ? is a special character that denotes optionality. It means “the preceding character or nothing”.

The following example illustrates how it works:

val regex = Regex("cats?") // creating the "cats?" regex

val stringCat = "cat"
val stringManyCats = "cats"

println(regex.matches(stringCat))   // true
println(regex.matches(stringManyCats))   // true
You can also combine the dot character . and the question mark ? in one regex pattern.
This combination basically means that there can be any single character or no character at all:

val regex = Regex("cat.?") // creating the "cat.?" regex

val stringCat = "cat"
val stringManyCats = "cats"
val stringEmotionalCat = "cat!"
val stringCot = "cot"

println(regex.matches(stringCat))   // true
println(regex.matches(stringManyCats))   // true
println(regex.matches(stringEmotionalCat))  // true
println(regex.matches(stringCot))   // false
This can make your work much easier, but wait a second: what if you need to find the actual dot or the question mark?

The escape character
If part of the actual regex happens to be a special character, this can be managed with the escape character.
When you create strings with special characters, you can escape them using a double backslash \\:

val regex = Regex("cats\\?")

val stringCat = "cat"
val stringManyCats = "cats"
val stringEmotionalCats = "cats?"

println(regex.matches(stringCat))   // false
println(regex.matches(stringManyCats))   // false
println(regex.matches(stringEmotionalCats))  // true
The character after the \\ is interpreted as a literal character.
In the example above, the question mark was interpreted as a question mark and nothing more.

So, if you need to find a special character such as a dot or a question mark, you can escape it with \\.
The characters on which you used the escape symbol \\ will not be interpreted as special.

Some words are spelled differently in American and British English.
Using special characters, create a regular expression color that fits four options: "color", "colour", "colors", and "colours".
val color = Regex("colo.?r.?")

Create a regexp instance named regex that matches the line \

val regex = Regex("\\\\")

Interesting: seemingly, we do screen \ with \\.
But if we keep three backslashes, Kotlin will decide that one of it is for the quotation mark (\" is interpreted as escape sequence for " in String literals).
So we need four backslashes. Later, we’ll talk about how to avoid multiple levels of escaping.

The "?" often symbolizes optional elements, not any single character.
"." match any single character.

"?" match any single character or nothing
*/

fun main() {
	val report = readln()
	//write your code here.
	val pass = report.matches(Regex(". wrong answer.?"))
	println(pass)
}