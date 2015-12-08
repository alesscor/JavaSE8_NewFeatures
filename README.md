# Java SE 8 New Features - David Gassner

Java SE 8 New Features, lynda.com course with David Gassner:

* I'm using Eclipse Luna (4.4.1), already supporting Java SE 8, in need of adaptation look at https://wiki.eclipse.org/JDT/Eclipse_Java_8_Support_For_Kepler

* The Lambda Project

    * To simplify code and take advantage of existing simple structures like the "Functional Interfaces" that clases like `Runnable`, `Callable`, `Comparator` and `TimerTask` have, among others.
        * Those types were called "Single Abstract Method types", which have exactly one abstract method
            * There is no need to use new with Functional Interfaces nor to create their implementation classes. The lambda expression _produces an implemented instance of the "Functional Interface"_, recognizing template's concrete types even.
        * Parts of the "lambda expression"
            * The variable and its Functional Interface type
            * The Method signature (with no types, there is no ambiguity)
            * The lambda arrow or lambda operator
            * The Method implementation
            * Example: `[Runnable r=][()][->][System.out.println("carajada")];`
    * It allows to use anonymous classes and methods
        * It makes less code and improves its readability and maintainability
    * Using the new Functional Interfaces that come in collection super interfaces, like the case of `Iterator` "superinterface" used by `Iterable` and its `Consumer` Funcional Interface with method `accept`, whose purpose is to operate items present in the collection. It's used in the `forEach` method to traverse a collection, for example
`strings.forEach((str) -> System.out.println(str));`
    * Presenting the "predicate interface" which has a `test()` method that returns boolean. You won't need to write return keyword if use the single line implementation.
    * Review package `java.util.function`, because there is a lot of new useful interfaces there.


* Method references:
    * You are able to refer to methods of types by using the double colon operator. This allows you to pass them as arguments of other methods like `Collections.sort(people,Person::compareAges);` or which is the same: `people.sort(Person:: compareAges);`. You can call the double colon operator with the needed class or `this` as it is simpler.


* Default and static methods:
    * You are now able to implement methods into interface declarations, which allows you to implement less classes, for example some base classes won't be needed to implement "abstract" method as mere non-useful intermediary class, inheriting directly implemented methods from the interfaces as required <3.
    * You are also able to add implemented static methods to interfaces.


* Handling of collections:

    * The stream API, which provides serial and parallel streams. It facilitates the implementation of arrays content by using interfaces for Stream and directly from the same containers, as Arrays.stream(anArray). Example: `Arrays.stream(people).forEach( p -> System.out.println( p.getInfo()));`
    * It comes an example of processing elements from a list using parallel streams, yes it makes the process faster but you must take care of the order if processing, which can be random. Aggregate functions take advantage of the parallel processing: count, sum, average, min/max etc.
        * For sum or special aggregate operations on the content, it comes a `mapToInt()` functional interface that has a method called sum to get the result. An example: `int sum= people.stream().mapToInt(p -> p.getAge()).sum();`
        * It uses optional variables using `OptionalDouble`, which comes along the expression `isPresent` and `getAsDouble` to check if its value is presented and the respective value, very interesting cause I'd never use them before. It was used with the average of this example:

```java
                OptionalDouble avg=people .stream().mapToInt(p -> p.getAge()).average();
                if(avg .isPresent()){
                    System. out.println("The average of ages is: "+avg.getAsDouble());
                }
```


* New API for date and time:
    * Package java.time
    * New classes are inmutable and thread-save
        * Instant, comes with function to look at nanoseconds
        * Duration
    * Three more useful classes: local date, local time, local date time. They have consistency with instant and duration. In this new API everything is 1-based, i.e. 1 is January instead of February.

    * There is a formatter class to provide custom work on the date and time values's format: `DateTimeFormatter`

    ```java
            DateTimeFormatter df=DateTimeFormatter.ISO_DATE;
            System.out.println("the current date: "+df.format(currentDate));
    ```
    * The formatters can be customized <3, even more with using a completely custom formatter employing the «Builder Design Pattern» with DateTimeFormatterBuilder. The formatter is made from scratch, like in this example:
```java
            DateTimeFormatterBuilder builder=new DateTimeFormatterBuilder()
                  .appendValue(ChronoField. MONTH_OF_YEAR)
                  . appendLiteral("|")
                  .appendValue(ChronoField. DAY_OF_MONTH)
                  .appendLiteral( "|")
                  .appendValue(ChronoField. YEAR);
            DateTimeFormatter formatter=builder .toFormatter();

```

    * Time Zone handling with operations for date time values regarding different time zones. You are able to get the time zones set's values to review the ones you are interested to use in your applications.

* JavaScript engine for Java
    * Engine called Nashorn
        * To code in JavaScript instead that in Java (replaces Rhino's engine)
            * Able to use from the command line or in the java code files.
            * From command line:
                * You don't have access to documents so neither to their models, so there is no browser and then you don't have access to the window instance. BUT YOU ARE ABLE TO USE JAVA CLASSES!!!, and call Java platform objects methods.
                * example: `services.explorecalifornia.org/rss/tours.php. Using var input=java.utils.Scanner(new java.net.URL("a working url").openStream()); input.useDelimiter("$");var contents=input.next();`
                * And contents will have the xml page stored in the URL.
            * From java source code:
                * You use a ScriptEngineManager instance and a ScriptEngine instance, the latest must evaluate a script.
                * Example:
```java
            ScriptEngineManager manager=new ScriptEngineManager();
            ScriptEngine engine=manager .getEngineByName("nashorn");
            String script="var welcome='Hello';"
                        + "welcome+=' Alessandrín';"
                        + "welcome;";
             try {
                  String result=(String)engine .eval(script);
                  System. out.println(result );
            } catch (ScriptException e ) {
                  System. out.println("There was a JavaScript error" );
                   e.printStackTrace();
            }
```
    * But it's recommended to evaluate a JavaScript Script.

