# Java SE 8 New Features - David Gassner

Java SE 8 New Features, lynda.com course with David Gassner:

* I'm using Eclipse Luna (4.4.1), already supporting Java SE 8, in need of adaptation look at (Aless, find the url!!!)

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
`strings .forEach((str) -> System.out.println(str));`
    * Presenting the "predicate interface" which has a `test()` method that returns boolean. You won't need to write return keyword if use the single line implementation.
    * Review package `java.util.function`, because there is a lot of new useful interfaces there.


