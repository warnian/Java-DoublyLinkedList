README.txt 

readme.txt for MyLinkeList.java and MyLinkeListTester.java

Coursework for week 4 in Java Data Structures and Performance class through University of San Diego taken on Coursera
testGet was testSetup were provided by the class as well as the basic layout of what a node and nodeList should look MyLinkeList
This doubly linked list includes sentinal nodes (head and tail) which change the implementation slightly if you decided to only use a head
or tail or niether

All other methods and tests were authored by Ian Warn 

Passes autograder with 100%
Uses JUnit 5 but also should work with JUnit 4
The overall use of this doubly linked list is part ofthe textgen package. The textgen package generates so called Markov text which uses linked lists in order to create
text using the words already but in different orders. I have not yet implemented the Markov text generator part of the textgen package.

I found this assingment really interesting as it was my first time manually programming a doubly linked list. Using lists all the time it give you 
a new appreciation for what is happening  behind the scenes with Java and other languages. It is really just a bunch of random nodes in the heap chained together through pointers.
I now understand how this could lead to some performance limitations when compared with arrays (sequential in the heap) however you do get some nice functionality like being able to dynamically edit a list
without having to recreate the entire list as you would with an array.

This was also my first exposure to testing through JUnit which was very effective, I wrote the tests before writing the code in order to keep it clear what I wanted the resulting functionality to be.
Testing is a powerful concept which is very good to know, I would like to learn more.

