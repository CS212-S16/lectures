CS 212 - Spring 2016 - Week 1 Notes
===================================

## Opening Notes

In CS 212 - Software Development you will spend the semester implementing a large piece of software using the Java programming language.

**Outcomes** Throughout the semester, you will practice using advanced Java constructs; implement complex data structures; implement concurrent programs; and learn and apply the major technologies underlying web applications. A full list of learning outcomes for the course may be found here: [Learning Outcomes] (https://usfca.instructure.com/courses/1558940/pages/outcomes)

**Web Page** The course web page at [http://cs212.cs.usfca.edu](http://cs212.cs.usfca.edu) is a very important resource. It will be updated frequently with assignments and links to resources.

**Lecture Format** Some lectures will include notes posted on github, some will include slides, and almost all will include code demonstrations that we will develop interactively as a class. Code will be posted to the class [Github](http://github.com) organization after class (feel free to remind me via slack if I forget!).

**Cool Project** We will **not** be building a search engine this semester, but hopefully you'll find this semester's project just as cool. We will be using song data from last.fm to build a *Song Finder*. Visit a web page, provide an artist, song title, or tag of your choosing, and the Song Finder will give you a list of other songs you might like! 

**Slack (also cool)** We will be using a tool called Slack for communication in this course. It is preferred that most questions be posted in the #general channel. You may send me a DM with private questions, but if the question is general I will require you to post it the #general channel before answering. You may reply to other's questions in the #general channel. Only the instructor is allowed to post in the #announcements channel. For sensitive issues, you may send me email. 

**Help!** Your TA for the course will be Richard Wang. He will have office hours Monday and Friday 12-2pm. You may also visit the tutoring center for help with this class.

**Homework** You will have a homework assignment due on Friday of most weeks. **Homework assignments may not be submitted late and may not be resubmitted.** Your grade will depend largely on how many test cases your solution is able to pass. You will not receive credit for a late homework submission unless you provide a doctor's note indicating a medical emergency.

**Projects** You will have five project assignments and we will use a mastery learning approach for the projects. In mastery learning, every project must demonstrate mastery of the topic, and be worthy of 100%. You will be graded on the number of projects completed. It is *possible* to pass the course completing only three projects, however most students will need to complete at least four projects to earn a passing grade.

**Mastery Learning** Each project has a *suggested* deadline. Projects 1 and 2 have a **final deadline**. If a project does not demonstrate mastery before the final deadline you will be assigned an automatic F in the course. 

A project may not be submitted until it passes all test cases. Once it passes all test cases, the instructor or TA will look at your code and may provide feedback. If feedback is provided, you must fix any problems, verify you are still passing all test cases, and resubmit. If your code passes the verification process, you will qualify for code review with the instructor. The instructor may request changes. If so, you must implement all changes and resubmit.

Each student will have one opportunity to resubmit each project without penalty. Additional resubmissions may result in a deduction from the final score.

**DO NOT CHEAT** I have **ZERO** tolerance for academic dishonesty!

## Homeworks 0 and 1

Your first assignment is due TOMORROW. Sign up for the Slack team, sign up for github, tell me a bit about yourself, and sign the class academic honesty policy.

Your second homework assignment is due FRIDAY at 11:59pm. Note, just because you have until 11:59pm does not mean you should wait to start this assignment. You are not guaranteed help from the professor or TA after 5pm on Friday, so keep that in mind if you are someone who likes to procrastinate!

Homework 1 is a good example of what you will be expected to do in this course: learn and apply new technologies quickly!

In particular, you will need to master the following for the first homework assignment:

1. Accessing your Github repositories. I will get these set up on Wednesday once you have completed Homework 0.
2. Use of Eclipse.
3. Parsing of files in JSON format.
4. Recursive traversal of a directory.
5. Use of test cases.

## Examples

To demonstrate use of the Github desktop, let's use it to clone the `lectures` repository. This repository contains lecture notes and guides as well as the code we will review in class.

### `YelpUser`

For your first homework, you will be working with the last.fm data set, which is stored in Java Script Object Notation (JSON) format. The `YelpUser` project that we will work with in class also uses data stored in JSON format, though from the Yelp data set.

Looking at JSON in pure text can be a pain, but there are lots of useful online formatters/parsers for JSON, like [this one](http://json.parser.online.fr/).

For this exercise, our goal is to open the `user_dataset.json` file, read in each line, and count the number of active users and the number of users who have voted at least once.

We *could* write our own code to search through all of those {} and : in the JSON file, but there are JSON parsers out there that will do that for us. We'll use [JSON Simple](https://code.google.com/archive/p/json-simple/). For this example, I'll show you how to download the JSON Simple library and include it in the *classpath* of your project. For your homework, I'll take care of that step for you.

Here are some of the things we'll need to do for this example:

1. Decide on the data memebrs for the `YelpUserStatistics` class.
2. Determine how to decompose our program into methods.
3. Implement the logic that has been provided. For this, we'll need to understand how to use the JSON Simple library.
4. *Hint:* for your homework you'll also need to process JSON objects of type `JSONArray`. Using the JSON API, if you `get` an array object you may cast it to be a `JSONArray`. `JSONArray` has a method `size`.

### `FileFinder`

For this exercise, we'll practice using recursion to traverse a directory structure.

## Test Cases

Your homework assignments will require you to pass all `JUnit` tests provided in the project. 

