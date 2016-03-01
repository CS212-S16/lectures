Inheritance
===========

## Overview ##

Interfaces, for example [Comparable](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) and [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html), enable software reuse by allowing the programmer to specify the behavior that will be supported by any class that implements the interface. This is useful if a set of classes will all support the same behavior in different ways. However, it is often the case that a set of classes support some of the same functionality, but also some different functionality. They exhibit a hierarchical relationship.

Consider a program to model a beverage vending machine. We might want to have a class that stores information about any beverage that could be dispensed by our machine, for example the size of the beverage. 

We might also want to have a class to provide more specific information about each individual type of beverage. Coffee, for example, may have a property to indicate whether it is decaffinated. Water may have a property to indicate whether it is sparkling or still.

Inheritance enables the programmer to take advantage of the hierarchical relationships inherent in software design. The programmer can define a **base** class (aka **superclass** or **parent** class) that defines some generic behavior. Unlike an interface, the base class can actually provide method implementations. **Derived** classes (aka **subclasses** or **child** classes) extend the base class; they inherit all of the functionality in the base class and may optionally define additional functionality specific to the child class. We say that a derived class has an "is-a" relationship with the base class.

## Syntax ##

### Defining a base class.

A base class looks like any other Java class you might implement. A `Beverage` class might look as follows:

```java
public abstract class Beverage {

	protected int ounces;
		
	public Beverage(int ounces) {
		this.ounces = ounces;
	}
		
	public int getSize() {
		return this.ounces;
	}
	
	public void drink() {
		System.out.println("Mmm, tasty");
	}

	public abstract String getServingGlass();
}

```

`protected` Visibility

Notice that we used a new keyword `protected`. Typically, we would have used the visibility modifier `private` to indicate that the data member `ounces` should only be accessible from within the class `Beverage`. However, private members may not be accessed by subclasses. Making the data members `public` would violate the principle of encapsulation by making the data members accessible to any class. The modifier protected is more appropriate; a protected member can be accessed within the class, as well as from any derived class.

### Defining a Derived Class

A derived class `Coffee` might look as follows:

```java
public class Coffee extends Beverage {
	
	protected boolean isDecaf;
	
	public Coffee(int ounces, boolean isDecaf) {
		super(ounces);
		this.isDecaf = isDecaf;
	}
	
	public String getServingGlass() {
		return "Cup";
	}
	
	public boolean isDecaf() {
		return this.isDecaf;
	}	

	public void drink() {
		System.out.println("Wow, that's hot!");
	}
}
```

**`extends`**

The keyword `extends` is used to indicate that a particular class is derived from another. Recall that a class may implement multiple interfaces, but it may only extend one other class.

**`super`**

Notice that we use the keyword super on the first line of the constructor. Recall that we often use the keyword this to indicate we want to access a particular member in this object. `super` allows the programmer to access members of the super class. In this case, `super(ounces)` invokes the super class constructor -- that is the constructor in the class `Beverage`.

## Method Invocation ##

Because `Beverage` is abstract, it may not be instantiated. The following code will not compile:

```java
//Invalid because Beverage is abstract
Beverage b = new Beverage(12);
```

The following code instantiates an object of type `Coffee` and invokes the `getSize` method in the superclass.

```java
Coffee c = new Coffee(8, false);
System.out.println(c.getSize());
```

Because `Coffee` is-a `Beverage` a reference of type `Beverage` can refer to an object of type `Coffee`, *but* since `Beverage` does not have an `isDecaf` method the following code will result in a compiler error.
 

```java
Beverage b = new Coffee(8, false);
//Invalid to call isDecaf on a referece of Beverage.
System.out.println(b.isDecaf())
```
**Dynamic binding** means that the `Coffee` drink method will be invoked even though the method is called on a reference of type `Beverage`. Java determines which version of an inherited method is called by evaluating the contents of the object, not the reference.

```java
Beverage b = new Coffee(8, false);
b.drink();
```

`Coffee` is served in a cup!

```java
Beverage b = new Coffee(8, false);
System.out.println(b.getServingGlass());
```

## More Concepts ##

### Overriding

In some cases, you may want to reimplement methods from the base class in the derived class. The `drink` method of `Beverage` is overridden in `Coffee`.

### Partial Overriding

Partial overriding enables us to avoid duplicating code by invoking the superclass version of a method from the subclass using the super keyword. 

If we wanted the `Coffee` `drink` method to print both "MMM, tasty" and "Wow, that's hot!" we could modify it as follows:

```java
public void drink() {
	super.drink();
	System.out.println("Wow, that's hot!");
}
```

### `final`

The keyword `final` can be applied to variables, methods, and classes.

- Final variables are constant. The value of a final variable cannot change.
- Final methods cannot be overriden. This ensures that the functionality defined in a method remains the same in any derived class.
- Final classes cannot be extended.

### `abstract`

In some cases, it will not make sense to ever create an instance of a base class. To enforce this property, we can declare the base class `abstract`, as we have done in `Beverage`.

Recall that interfaces allow the programmer to specify that a derived class must implement a particular method, but the interface itself only specifies the method header. Similarly, abstract methods are simply method headers defined in an abstract superclass that must be implemented by a derived class. Note that an abstract method can only be specified in an abstract class.

## Polymorphism

Polymorphism means many forms.

> A polymorphic reference is a reference variable that can refer to different types of objects at different points in time.

As we did above, we could have a `Beverage` reference that refers to an object of type `Coffee`. The same reference could refer to an object of type `Soda` if `Soda` extended `Beverage`. 

In the example below, we have an array of `Beverage` references that refer to different types of specific objects.

```java
Beverage[] bevs = new Beverage[3];
bevs[0] = new Coffee(8, false);
bevs[1] = new Soda(12, 45);
```

We may also have a `Beverage` reference that first refers to a `Coffee`, and then is assigned the value of a `Soda` as below:

```java
Beverage b = new Coffee(8, false);
b = new Soda(12, 45);
```

## Example
Assuming the following class structure, which of the following lines of code would result in an error?

Which version of each method would be invoked?

```
Class1		Class2 extends Class1
-method1	-method2
-method2	-method3

Class1 c1 = new Class2();
Class2 c2 = new Class2();
c1.method3();
c1.method2();
c2 = (Class2)c1;
c2.method3();

```