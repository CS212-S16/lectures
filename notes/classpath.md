Setting the Classpath
=====================

As programmers, we often want to take advantage of the work that other programmers have done, using their code to solve specific problems rather than implementing our own. You may have used existing third-party libraries to read MP3 files, for example.

In CS 212, we'll use a number of existing libraries. For example, you will use the [JSONSimple](https://code.google.com/p/json-simple/) library to read a file in JSON format and access its contents. This will save you from having to parse the file to extract the content from the formatting (e.g., : and {}).

To use a library, you'll need to download a [jar file](http://en.wikipedia.org/wiki/JAR_%28file_format%29) containing the executable class files provided by the other developer, and then you'll need to make sure that jar file is in your [classpath](http://en.wikipedia.org/wiki/Classpath_%28Java%29). The classpath simply tells Java where to find the classes it will need.

You will need to follow these general steps:

1. Download the jar file, for example from a site [like this](https://code.google.com/p/json-simple/). In some cases, I may have provided the jar file for you in the appropriate Github project.
2. Put the jar file in an appropriate location. You'll notice that for some homework and project assignments I have created a `lib` directory in your Eclipse project directory. This is a convenient place to put your jar files.
3. Add the jar to your classpath. If the jar file is in a lib directory inside of your project directory, right-click the project and select `Build Path > Configure Build Path`. Select `Libraries` and then `Add JARs`. Navigate to the jar file and click `OK`. 
4. You're done!