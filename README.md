## WELCOME TO TARIQ'S PainfullAfternoon (Hurtlocker.JerkSON)

By this time you should have been introduced to Java Strings, Exceptions, Unit Testing, and Regex.

# You will need all of these today!
In this project you will find a file in the `resource` directory named `RawInput.JerkSON`.
It was supposed to be a grocery list formated in `JSON`. However, Tariq, your fearless yet petty leader decided to come reformat it in his own Object Notation. `JerkSON`... you are welcome.

## JSON Format
* In `JSON`,
  * _keys_ are encapsulated by quotes
  * _values_ are encapsulated by quotes (unless numeric)
  * _key_ and _value_ are seperated by a colon.
  * _key and value pairs_ are seperated by a comma.

```json
{
  "name" : "Joe",
  "age" : 30
}
```

## JerkSON Format
* Just like `JSON`, `JerkSON` is a [_key-value-pair-data-store_](https://en.wikipedia.org/wiki/Attribute%E2%80%93value_pair).
* In `JerkSON`,
  * _keys_ are encapsulated by quotes
  * _values_ are encapsulated by quotes (unless numeric)
  * _key_ and _value_ are seperated by any of the following (`:`, `@`, `^`, `*`, `%`)
  * _key and value pairs_ are seperated by a `##`.

## Your Task
Its your job to build a `JerkSON` data parser, that is able to read in the raw data , and output a string formated list that resembles (outputFormat.txt) 

There are some things to look out for.... If you haven't figured it out by now Tariq has many wonderful qualities, spelling isn't one of them, so Words may not be spelled correctly. You need to decipher what Tariq was trying to spell using pattern matching.

for example:

In the shopping list Tariq has Cookies, but he could spell like Cookies, c00Kies, Co0kies and so on.

YOU ARE NOT ALLOWED to use any Java based string manipulation!!!!!!!!!!!!

You must use regex to detect the patterns and match them.


Its not guranteed that every Key will have a Value, and every Value will have a pair. For instance:

you may see something like this

`Name:Milk;Price:3.23;type:;expiration:1/24/2016##`

Notice how TYPE has a key but no Value.... if you try and parse this into an object your program could crash.

You will need to handle your exceptions!

I also expect you to report on how many exceptions you saw while parsing the data.


GOOD LUCK ZIPCODERS!!!! My the Odds be ever in your favor!!!!

