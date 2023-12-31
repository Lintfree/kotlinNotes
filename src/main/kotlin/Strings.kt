/*
String Templates
The full syntax for a string template is ${your-expression-here}
Inside the curly braces you can write any expression you want.
Line breaks, comments, if/else expressions and when expressions are all allowed.
If you are only reading a variable you can omit the braces.

Escaping quotation marks:
If you want to put quotation marks inside a string literal use an escape character.
"Madrigal proclaims, "Hello world!"" would only print Madrigal proclaims,
Use an escape character to let the compiler know to treat it as text and not syntax.
The \ character accomplishes this
Other escape characters include:
\t  insert tab
\b backspace
\n newline
\r carriage return
\" double quotation marks
\' single quotation marks or apostrophe
\\ backslash
\$ dollar sign
\u unicode char

Raw strings: I prefer this method to the confusing escape characters.
Raw strings let you insert new line characters, quotation marks,and other symbols without the need to escape them
Raw strings do not need to be escaped at all.
To create a raw string, begin a string with """ (3) quotation marks and end with another 3.

Example from Bounty board.
 println(
        """
            |$HERO_NAME approaches the bounty board. It reads:
            |   "${obtainQuest(playerLevel)}"
        """.trimMargin()
    )

    The pipe character (|) defines the start of each line.
    The trimMargin() function removes the pipe character from the start of each line and removes all whitespace to the left of it.
    If you omit the pipe and the call to trimMargin, the text will be indented exactly as you type it in the code but
    hinders readability.

    trimIndent does not use the pipe character and will find a common amount of whitespace of the strings and remove it.a




 */