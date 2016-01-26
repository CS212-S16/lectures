Exceptions in Java
==================

From the [Java Exceptions Tutorial](https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html):

> **Definition:** An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.

## Checked Exceptions

> are exceptional conditions that a well-written application should anticipate and recover from. For example, suppose an application prompts a user for an input file name, then opens the file by passing the name to the constructor for java.io.FileReader. Normally, the user provides the name of an existing, readable file, so the construction of the FileReader object succeeds, and the execution of the application proceeds normally. But sometimes the user supplies the name of a nonexistent file, and the constructor throws java.io.FileNotFoundException. A well-written program will catch this exception and notify the user of the mistake, possibly prompting for a corrected file name.

The compiler will complain if a checked exception is not handled appropriately. It is very likely you have encountered these kinds of exceptions, particularly when dealing with file input and output.

### try-catch
It is likely that you have dealt with checked exceptions by using a `try-catch` statement. In this case, you surround the code that may generate the exception in a try block, and catch the exception(s) in a catch block. If the exception is generated, the code in the catch block is executed.

```java
	try {
		//some code that tries to open a file
	} catch (IOException e) {
		//do this if the IOException is generated
	}		
```

You may also have seen a try-catch with multiple catch statements:

```java
	try {
		//some code that tries to open a file
	} catch (IOException e) {
		//do this if the IOException is generated
	} catch (ParseException pe) {
		//do this if the ParseException is generated
	}
```

The approach above is useful if you wish to execute different code based on the type of exception thrown. If you wish to execute the same code in case two different types of exceptions are thrown, you may use the multi-catch as follows:

```java
	try {
		//some code that tries to open a file
	} catch (IOException| ParseException e) {
		//do this if either exception is generated
	} 	
```

In either case, you may also include a finally block that will execute whether the exception is generated or not:

```java
	try {
		//some code that tries to open a file
	} catch (IOException| ParseException e) {
		//do this if either exception is generated
	} finally {
		//always executed
	}
```


### Propagating Exceptions

An exception may also be propagated to the calling method. This is useful in case the method that executes the code that generates the exception doesn't know how to handle the exception.

In the example below, a method `promptUser` asks a user for a file name and calls a method to process the file. What should `processFile` do in case an `IOException` is generated? 

```java
	public void processFile(String fileName) {
		try {			
			Path path = Paths.get(fileName);
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			//read the file
		} catch (IOException ioe) {
			//What to do!?!?!
		}		
	}
	
	public void promptUser() {	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file name: ");
		String fileName = scan.nextLine();
		processFile(fileName); //was this successful?
	}
```

If it is unclear how `processFile` should handle the exception, consider propagating it to the calling method instead.

In the example below, `processFile` need not use a try-catch. Instead, we specify that the method `throws IOException`. `promptUser` then uses a try-catch block to handle the exception. 

```java
	public void processFile(String fileName) throws IOException {		
		Path path = Paths.get(fileName);
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
		//read the file
	}
	
	public void promptUser() {		
		Scanner scan = new Scanner(System.in);
		boolean processed = false;
		while(!processed) {		
			System.out.println("Enter file name: ");
			String fileName = scan.nextLine();
			try {
				processFile(fileName);
				processed = true;
			} catch(IOException ioe) {
				System.out.println("Sorry, bad file name.");
			}
		}				
	}
```

### try-with-resources

Where appropriate, using try-with-resources rather than plain 'ol try is a good idea. A `Closeable` resources such as a `BufferedReader` is automatically closed in case try-with-resources has been used. This is very handy if you often forget to close your resources, like I did above! 

It may be used with a catch:

```java
	try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
		//read the file
	} catch(IOException ioe) {
		//do something!
	}
```
Or without...

```java
	try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
		//read the file
	} 
```


## Runtime Exceptions

> are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from. These usually indicate programming bugs, such as logic errors or improper use of an API. For example, consider the application described previously that passes a file name to the constructor for FileReader. If a logic error causes a null to be passed to the constructor, the constructor will throw NullPointerException. The application can catch this exception, but it probably makes more sense to eliminate the bug that caused the exception to occur.

It is likely you have also seen many runtime exceptions in your programming career. These include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ClassCastException`. The compiler will not complain about these, but your program may crash as a result.

Pay particular attention to the last sentence of the definition above! It is generally not good practice to try-catch runtime exceptions. Instead, avoid the exception, as in the example below.

```java
	//DO NOT DO THIS!!!
	try {
		System.out.println(object.toString());
	} catch(NullPointerException npe) {
		System.err.println("object has not been initialized");
	}
```

```java
	//INSTEAD DO THIS
	if(object != null) {
		System.out.println(object.toString());
	}
```

## Errors

> are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from. For example, suppose that an application successfully opens a file for input, but is unable to read the file because of a hardware or system malfunction. The unsuccessful read will throw java.io.IOError. An application might choose to catch this exception, in order to notify the user of the problem — but it also might make sense for the program to print a stack trace and exit.


