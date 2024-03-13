/*
Coordinated Universal Time (UTC) is the world's principal time standard for regulating clocks and time.
The time is based on the number of seconds that have elapsed since 12:00:00 midnight, January 1, 1970, Coordinated Universal Time (UTC).

The local time of a time zone is represented as UTC+<hours:minutes> or UTC-<hours:minutes>. For example:

UTC-05:00
UTC+00:00
UTC+02:00
UTC+05:45
Time zones may also be denoted by alphabetic abbreviations, for example "MUT" stands for "Mauritius Time", that is UTC+04:00.

Following are some examples of time zones. Note that normally, countries have a single time zone, but some large countries may be divided into several time zones.

Country, Time zone,Time zone name, Country Abbr

Japan, UTC+09:00, Japan Standard Time, JST

Italy, UTC+01:00, Central European Time, CET

Sri Lanka, UTC+05:30, Sri Lanka Standard Time, SLST

Peru, UTC−05:00, Peru Time, PET

Greece, UTC+02:00, Eastern European Time, EET

China, UTC+08:00, China Standard Time, CST

Brazil, UTC−03:00, Amazon Time, AMT

India, UTC+05:30, India Standard Time, IST

Mexico, UTC−07:00, Mountain Standard Time, MST

ISO is the abbreviation for the International Organization for Standardization, an international non-governmental organization for issuing various standards.
ISO 8601 is an international standard for the text representation of date and time.
It is used for the correct date and time data communication and is country-independent.

This standard defines the notation for dates, times, time zones, and time intervals.
There are 2 categories of notations: the basic notation, where the minimum required number of characters is used,
and the extended notation, which is more human-friendly.

The ISO 8601 date and time representation
A date is formatted as YYYY-MM-DD (extended) or YYYYMMDD (basic), where Y denotes the year digits, M denotes the month digits, and D denotes the day digits.
For example:
2000-01-01
2001-12-31
20100207
20121120

Time is formatted as Thh:mm:ss.fff, Thh:mm:ss (extended), Thhmmss or Thhmmss.fff (basic),
where h denotes the hour digits, m the minutes digits, s the seconds, and f the seconds' decimal digits (depending on the accuracy).
T is used as an indicator that the string that follows represents time.
Also, note that midnight may only be referred as 00:00:00 and not 24:00:00.
For example:
T12:00:15
T120015
T14:01:34.55
14:01:34.55
T170517.3432
T00:00:00
00:00:00

The time zone indicator is formatted as Z (for UTC standard time), ±hh:mm, ±hhmm, or ±hh. For example:
Z
+07:00
+0700
-02:00
-02
All time data have a fixed number of digits, and if the actual numbers have less digits, then they have to be padded with leading zeros.
For example, the correct date format is 2022-02-02 and not 2022-2-2.

Date and time together are represented in the format of <date>T<time><time zone indicator>.
The time indicator T cannot be omitted here, while the time zone indicator is optional.

Following are some examples of the ISO 8601 date-time representation:

2022-02-16T16:31:03+02:00
2022-02-16T16:31:03Z
20220216T163103Z

The ISO 8601 duration representation
Time duration is represented as P<n>Y<n>M<n>DT<n>H<n>M<n>S,
where P denotes that this string represents time duration, Y denotes years, M months, D days,
T is the days-time divider, H denotes hours, the M after T denotes minutes, and S – seconds. <n> denotes the value of the time element that follows it.
For example:
P2Y11M5DT4H10M3S
The string denotes the duration of 2 years, 11 months, 5 days, 4 hours, 10 minutes, and 3 seconds.

If the value of a time item is zero, it can be omitted. For example:
P4Y      Duration of 4 years
PT3H5M   Duration of 3 hours and 5 minutes
P7DT6H   Duration of 7 days and 6 hours
The last item may also have decimal digits. For example:

P12.5Y         Duration of 12.5 years
PT2H3M10.23S   Duration of 2 hours, 3 minutes and 10.23 seconds
P2M7.3D        Duration of 2 months and 7.3 days

The ISO 8601 time interval representation
Time intervals can be expressed in the following formats:

1) <Starting date-time>/<Ending date-time>

For example:

2022-12-01T00:00:00Z/2022-12-31T23:59:59Z
2000-01-01T00:00:00+03:00/2011-01-01T00:00:00+03:00
2022-02-01T14:00:00-05:00/2022-02-01T14:15:59-05:00
2) <Starting date-time>/<Duration>

For example:

2000-01-01T00:00:00Z/P3Y10M4DT2H11M13S
2012-07-19T17:12:00Z/PT35M
3) <Duration>/<Ending date-time>

For example:

P1Y1M2DT21H9M7S/2000-01-01T00:00:00Z
P3Y/2021-01-01T01:00:00Z

Kotlinx is a collection of projects that aren't part of the standard library but are useful extensions.
One of the most useful projects is the kotlinx-datetime library, which is a multiplatform Kotlin library for handling date and time data.

How to use the library in a project
In your Gradle project, add the Maven Central repository with:

repositories {
    mavenCentral()
}

Then add to the dependencies block (for example, for version 0.4.0 here):
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}

In your Maven project, add the dependency:
<dependency>
    <groupId>org.jetbrains.kotlinx</groupId>
    <artifactId>kotlinx-datetime-jvm</artifactId>
    <version>0.4.0</version>
</dependency>
The latest kotlinx-datetime version can be found in the Maven Central depository.

In all source files that deal with time, add the following import line:

import kotlinx.datetime.*
What is Instant?
Instant represents a point on the timeline.
This class is used to represent a moment in time, usually for comparing two moments in time or storing a date-time in a database.

Creating Instant Objects
Creating an instance of Instant is quite straightforward.

You can use the now() method to get the current date and time, looks:

import kotlinx.datetime.Clock


fun main() {
    val currentInstant = Clock.System.now()
    println(currentInstant) // 2023-07-24T13:39:16.310148200Z your result is another
}
if you need time in milliseconds you can use .toEpochMilliseconds():

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

fun main() {
    val currentInstant = Clock.System.now()
    val currentInstantInMillisec = currentInstant.toEpochMilliseconds() // returns current instant in milliseconds

    println(currentInstant) // 2023-07-24T13:39:16.310148200Z
    println(currentInstantInMillisec) // 1690205956310
}
or fromEpochMilliseconds() to create an instance based on milliseconds.

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

fun main() {
    val currentInstant = Clock.System.now()
    val currentInstantInMillisec = currentInstant.toEpochMilliseconds() // returns current instant in milliseconds
    val specificInstant = Instant.fromEpochMilliseconds(currentInstantInMillisec) // returns specific instant in milliseconds

    println(currentInstant) // 2023-07-24T13:39:16.310148200Z
    println(currentInstantInMillisec) // 1690205956310
    println(specificInstant) // 2023-07-24T13:39:16.310Z
}

Instant Methods
Instant offers a number of methods that allow you to obtain various data or transform the Instant.
For example, plus and minus methods allow you to add or subtract temporal units.

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration


fun main() {
    val currentInstant = Clock.System.now()
    val currentInstantInMillisec = currentInstant.toEpochMilliseconds() // returns current instant in milliseconds
    val specificInstant = Instant.fromEpochMilliseconds(currentInstantInMillisec) // returns specific instant in milliseconds
    val futureInstant = currentInstant.plus(Duration.parse("6h"))
    val pastInstant = currentInstant.minus(Duration.parse("24h"))

    println(currentInstant)
    println(currentInstantInMillisec)
    println(specificInstant)
    println(futureInstant)
    println(pastInstant)
}
Output:

2023-07-24T13:39:16.310148200Z
1690205956310
2023-07-24T13:39:16.310Z
2023-07-24T19:39:16.310148200Z
2023-07-23T13:39:16.310148200Z

Conversion Between Instant and Other Date and Time Types
Instant can easily be converted to other date and time types and vice versa.

import kotlinx.datetime.*

fun main() {
    val currentInstant = Clock.System.now() // val currentInstant: Instant

    val zonedDateTime = currentInstant
        .toLocalDateTime(TimeZone.currentSystemDefault()) // val zonedDateTime: LocalDateTime
    val backToInstant = zonedDateTime
        .toInstant(TimeZone.currentSystemDefault()) // val backToInstant: Instant
    println(zonedDateTime)
    println(backToInstant)
}

Applying Instant in Real Scenarios
Instant can be used in any scenario where it's important to know a specific moment in time.
This could be event logging, comparing moments in time in task management apps, or the time of the last update in a user interface.

Best Practices and Common Mistakes When Working with Instant
It's important to remember that Instant always represents time in UTC.
Therefore, if you want to display time in a specific time zone,
you will need to convert the Instant to another date and time type such as LocalDateTime or ZonedDateTime.
Also, remember that Instant does not contain information about the time zone.

TimeZone classes
The TimeZone class is used to keep time zone information. It can be initialized in many ways.

The currentSystemDefault() member function provides the computer system time zone,
while UTC sets the time zone to UTC (denoted as Z in ISO 8601), as in the following example:

val tz1 = TimeZone.currentSystemDefault()  // The computer system time zone

val tz2 = TimeZone.UTC                     // UTC time zone
println(tz2)                               // Z
Any other time zone is set with the help of the of() member function, which takes a string as a parameter.
It can be either the UTC offset (e.g., "UTC-3" or "UTC-03:00") or the time zone name (e.g., "Europe/Rome").
You can find the valid time zone names in the tz database. For example:

val tz3 = TimeZone.of("Europe/Paris")      // Paris, France time zone
println(tz3)                               // Europe/Paris

val tz4 = TimeZone.of("UTC+2")             // UTC + 2 hours time zone
println(tz4)                               // UTC+02:00
In case the provided parameter of the of() function isn't valid, the IllegalTimeZoneException is thrown.

DateTimePeriod class
The DateTimePeriod class is used for keeping the difference between two Instant objects split into date and time components.
These can be accessed from the relevant properties named years, months, days, hours, minutes, seconds, and nanoseconds.
Printing a DateTimePeriod object gives the difference as an ISO 8601 duration representation.

A difference between two Instant objects can be acquired with the use of the periodUntil(other: Instant, timeZone: TimeZone) member function,
where other is another Instant and timezone is a time zone. For example:

val instant1 = Instant.parse("2000-01-01T20:00:00Z")
val instant2 = Instant.parse("2000-10-14T00:00:00Z")

val period: DateTimePeriod = instant1.periodUntil(instant2, TimeZone.UTC)

println(period)
// P9M12DT4H

println("Months: ${period.months} Days: ${period.days} Hours: ${period.hours}")
// Months: 9 Days: 12 Hours: 4
An important use of the DateTimePeriod class is to apply a time offset to an Instant with the Instant.plus() function,
which adds an amount of time to an Instant, and the Instant.minus() function, which subtracts an amount of time from an Instant.

val instant = Instant.parse("2000-01-01T00:00:00Z")
println(instant)
// 2000-01-01T00:00:00Z

val period: DateTimePeriod = DateTimePeriod(years = 1, months = 1, days = 1, hours = 1, minutes = 1, seconds = 1, nanoseconds = 123456789L)
println(period)
// P1Y1M1DT1H1M1.123456789S

val after = instant.plus(period, TimeZone.UTC)

println(after)
// 2001-02-02T01:01:01.123456789Z

val before = instant.minus(period, TimeZone.UTC)

println(before)
// 1998-11-29T22:58:58.876543211Z
Following are some examples to depict the differences between the Duration (kotlin.time package) and the DateTimePeriod (kotlinx) classes:

val instant1 = Instant.parse("2100-01-01T00:00:00Z")
val instant2 = Instant.parse("2105-07-09T15:23:40Z")

val duration: Duration = instant2 - instant1
println(duration)                                             // 2015d 15h 23m 40s
println(duration.inWholeDays)                                 // 2015
println(duration.inWholeHours)                                // 48375

println( instant1.periodUntil(instant2, TimeZone.UTC) )       // P5Y6M8DT15H23M40S
println( instant1.periodUntil(instant2, TimeZone.UTC).days )  // 8
 */

/*
fun isLeapYear(year: String): Boolean {
	val y = year.toInt()
	return y % 4 == 0 && y % 100 != 0 || y % 400 == 0
}

fun main() {
	val year = readln()
	println(isLeapYear(year))
}

 */

//much better way need to read the docs to see what else you can do
//fun main() = print(Year.of(readln().toInt()).isLeap)

//The function nextMonth(date: String): String takes an ISO 8601 date and time string (e.g., 2022-02-01T22:10:00Z) as a parameter
// and returns an ISO 8601 date and time string of the following month.
//Write the correct code for the nextMonth() function.
/*
fun nextMonth(date: String): String {
	val instant = Instant.parse(date)
	val period = DateTimePeriod(months = 1)
	return instant.plus(period, TimeZone.UTC).toString()
	}


fun main() {
	val date = readln()
	println(nextMonth(date))
}
*/
