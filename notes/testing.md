Software Development Methodologies and Testing
================

#Roles in Software#

First, a few words about jobs in the software industry and where the responsibility for testing lies.

### Developer/Software Development Engineer (SDE)
This is the role many of you will desire when you complete your degree. In the beginning, you'll probably spend much of your time writing (and testing!) code. Software developers, however, spend much of their time discussing requirements with others in their organizations, communicating progress and problems, and performing other responsibilities such as interviewing possible new team mates. In most cases, in a short amount of time you'll go from mostly programming to more meetings and other interactions where you will be expected to define system architecture, identify new features, and so on. 

These links provide an interesting perspective:

- [Day in the Life of a Googler](http://matt-welsh.blogspot.com/2010/12/day-in-life-of-googler.html)
- [Day in the Life of a Google Manager](http://matt-welsh.blogspot.com/2015/01/day-in-life-of-google-manager.html)

Developers are expected to test code! The level of responsibility, however, depends on a variety of factors, including the size of the company. The smaller the company, the larger the burden on the developer.

### Quality Assurance Engineer (QA)

A more traditional "test" job is QA engineer. The QA engineer may or may not write much code, but is responsible for testing the end product. This may include using tools to facilitate automation, and may also require some domain-specific knowledge (e.g., understanding whether the product is giving the correct results or not). Generally, the software development team delivers the product to the QA team, who then identifies bugs that must be fixed before delivery.

### Software Development Engineer in Test (SDET)

Many larger companies also have SDETs. The goal of this role is to write the code to test the product. SDETs do write code, however their goal is to automate the process of identifying bugs.

#Software Engineering Overview#
###Failed Software Projects
- [Affordable care act website](http://www.cnn.com/2013/10/22/politics/obamacare-website-problems/)
- [Therac-25 radiation therapy machine](https://en.wikipedia.org/wiki/Therac-25) killed patients because of a software bug

###Software Engineering
The term was coined in 1969 and the goal was to discover more structure methods for building sofware.


#Software Development Methodologies#

### Waterfall - 1970s
This is the traditional method for software development that defines a lengthy and sequential design process. All of the requirements are defined up front and each stage of the process is completed before moving on to the next. If requirements change the process essentially needs to be restarted from the beginning. There is no flexibility. (see [Waterfall versus agile](https://www.atlassian.com/agile/program))

![waterfall](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Waterfall_model.svg/350px-Waterfall_model.svg.png)


- Each phase happens once
- Good for projects that require a lot of planning
 * NASA applications
- "Plan to throw one [implementation] away; you will, anyhow." -Fred Brooks, Jr.
- Need user/client in the loop
 * Early prototypes 

### Spiral - 1980s

![spiral](https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Spiral_model_(Boehm,_1988).svg/333px-Spiral_model_(Boehm,_1988).svg.png)

- Develop prototypes
- Consult client
- Iterate
- Iterations 6-24 months long

### Rational Unified Process - 2003

- Four Phases
 * Inception
 * Elaboration
 * Construction
 * Transition
- Each phase may have multiple iterations

### Agile - The Manifesto - 2001

![agile](https://s-media-cache-ak0.pinimg.com/736x/a6/64/bf/a664bfae939ac4da62d6783442e560ee.jpg)

Many (maybe most) companies these days use some flavor of agile development. In its purest form, agile is a methodology that conforms to the [agile manifesto](http://agilemanifesto.org/). In reality, this is often implemented by using a iterative approach. A single iteration (i.e., a *sprint*) is a fairly short time period during which the team works on some new feature or functionality. There is a daily meeting to discuss plans for the day and anything that is blocking progress.  At the end of the sprint, the goal is to have a fully functional version of the system, but perhaps without all of the necessary functionality.  

The main tenets of agile are as follows:

- Individuals and interactions over processes and tools
- Working software over comprehensive documentation
- Customer collaboration over contract negotiation
- Responding to change over following a plan


### Test-Driven Development

Not to be confused with agile, TDD in its purest form proposes that tests be written first, and the code developed to in order to meet the requirements of the tests. 

#Testing#

### Unit Testing

[Unit tests](http://en.wikipedia.org/wiki/Unit_testing) examine individual components, for example methods. Many of your lab tests were unit tests, calling individual methods and checking that the expected output was produced. In this strategy, knowledge of the code and logic is exploited, which means that it falls under the category of [white-box testing](http://en.wikipedia.org/wiki/White-box_testing).

### Integration Testing

[Integration testing](http://en.wikipedia.org/wiki/Integration_testing) also falls under the category of white-box testing. Integration tests examines how modules integrate with each other. An integration test may test parameter passing between modules, or consider a specific workflow through the application. Many of the lab tests are integration tests.

### System Testing

[System testing](http://en.wikipedia.org/wiki/System_testing) tests the entire, end-to-end system. System testing falls under the category of [black-box testing](http://en.wikipedia.org/wiki/Black-box_testing). Black-box testing advocates testing of the system without accessing the internal compoents. In other words, the system is treated like a black box and the tests explore whether the correct outputs are produced given appropriate inputs. No knowledge of the code or logic is exploited.

#Implementing Software Tests#

[JUnit](http://junit.org/) is the framework we have used for automated unit and integration testing this semester, but it is certainly not the only testing framework. There is a lot of good information available on the [JUnit FAQ](https://github.com/junit-team/junit/wiki/FAQ).

### JUnit Mechanics

JUnit is integrated into Eclipse, however to use JUnit outside of Eclipse you can download [from here](http://junit.org/).

To create a new set of tests in Eclipse, right-click and select ```New > JUnit Test Case```.

The wizard will remind you that JUnit must be in your build path, however you may manually add it in the ```Configure Build Path``` menu by selecting ```Libraries > JUnit```.

### JUnit API

The [javadoc](http://junit.org/javadoc/latest/index.html) is a helpful resource. 

**Annotations** are specified for methods in a JUnit test class. 

- ```@Before``` - indicates a method to be executed before every test. This method may contain *setup* code that is common for all methods, for example may instantiate a data structure.
- ```@After``` - indicates a method to be executed after every test. This method may contain teardown code common for all methods, for example may close a file stream.
- ```@Test``` - indicates a single test. Older versions of JUnit required every test method to have a name beginning with ```test```, however this is no longer necessary.
- ```@BeforeClass``` and ```@AfterClass``` - indicate methods executed once before all tests in the class and after all tests in the class respectively.

In addition, test annotations may specify a timeout, after which the test will fail, as well as an exception expected by the test where appropriate.

***Assertion*** methods are used in each test to determine whether the conditions tested are met. These methods evaluate some condition, and may optionally take as input a message to be displayed in case the test fails. The assertion methods include the following: 

- ```assertTrue```
- ```assertNull```
- ```assertSame```
- ```assertEquals```
- ```assertFalse```
- ```assertNotNull```
- ```assertNotSame```
- ```assertArrayEquals```

### Writing Good Tests

Of course, arguably the most challenging element of testing is writing good tests. Writing good tests takes practice, but following a few guidelines to consider:

- **Test one thing per test** - A good unit test will test one condition. If it fails, you should be able to identify the very specific case that needs to be address.
- **Tests should be small** - A test should be small --- very few lines of code.
- **Test should be automated and repeatable** - Running tests should be easy and tests should be rerun anytime the code changes.
- **Tests should be intuitive** - It should be easy for another developer to understand the test.
- **Start with the easy cases** - Begin with tests that assume valid input.
- **Test corner cases** - This includes null values and input out of bounds.

**References**

- [http://www.christiaanverwijs.nl/post/2012/10/17/How-writing-Unit-Tests-force-you-to-write-Good-Code-And-6-bad-arguments-why-you-shouldnt.aspx](http://www.christiaanverwijs.nl/post/2012/10/17/How-writing-Unit-Tests-force-you-to-write-Good-Code-And-6-bad-arguments-why-you-shouldnt.aspx)
- [http://programmers.stackexchange.com/questions/21133/how-to-write-good-unit-tests](http://programmers.stackexchange.com/questions/21133/how-to-write-good-unit-tests)

### Other Notes

Often, the number of lines of test code will exceed the number of lines of code being tested. In some cases, you may see 5x more test code than non-test code. 

Writing tests helps to enforce better design. If you have a hard time writing good test cases, you may want to rethink your original code.

### Exercise

- Identify the ten software applications you think are most important (either in general, or for you).
- For each, do you think agile would be an appropriate software development methodology?
