# OCP Documentation

# Index

* [Chapter 1 - Advanced Class Design](#Advanced-Class-Design)
    * [Reviewing OCA Concepts](#Reviewing-OCA-Concepts)
        * [Access Modifiers](#Access-Modifiers)
        * [Overloading and Overriding](#Overloading-and-Overriding)
        * [Abstract Classes](#Abstract-Classes)
        * [Static vs Final](#Static-vs-Final)
        * [Instance of ](#Instance-of)
        * [To String](#To-String)
        * [Equals](#Equals)
        * [HasCode](#HasCode)

# Advanced-Class-Design

## Reviewing OCA Concepts

### Access Modifiers

The rules for access modifiers are the next:

| Can Access                                        |   Private     |   Default     |  Protected    |  Public       |
| ------------------------------------------------- | :----------:  | :-----------: | :-----------: | :-----------: |
| Member in the same class                          |     Yes       |      Yes      |      Yes      |       Yes     |
| Member in the another class in the same package   |     No        |      Yes      |      Yes      |       Yes     |
| Member in a superclass in different package       |     No        |      No       |      Yes      |       Yes     |
| Member in different package                       |     No        |      No       |      No       |       Yes     |


### Overloading and Overriding

### Overloading.

The method name is the same but the parameter must vary by type or number.

When multiple overloaded methods are present, Java looks for the closest match first.

1. Exact match types.
2. Matching superclass types.
3. Converting to a larger primitive type.
4. Converting to an autoboxed type.
5. Varargs.

### Overrinding.

Overrinding occurs only when the method signature is the same(name and parameters).

1. The access modifier must be the same or more accesible.
2. The return type must be the same or more restrictive type, also known as covariante return types.
3. If any checked excepcion are thrown, only the same exceptions or subclasses of those exception are allowed to be thrown.
4. The methods must not be static(If they are, the method is hidden and not overriden.)

### Abstract Classes

1. An Anstract class may contain any number of methods including zero. 
2. The methods can be abstract or concrete. 
3. Abstract methods may no appear in a class that is not abstract. T
4. The first concrete subclass of an abstract class is required to implement all abstract methods that were not implemented by a superclass.

### Static vs Final

1. Static makes a variable shared at the class level and uses the class name to refer to a method.

2. Final prevent a variable from changing or a method for being overriden. Using final in a class means that it can not be subclassed.

### Instance of 

In " a instanceof b" return true if the reference in which points "a" is an instance of class B, a subclass of B or a class that implements the B interface.

        class HeavyAnimal{}
        class Hippo extends HeavyAnimal{}
        class Elephant extends HeavyAnimal{}

        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo;        // true
        boolean b1 = hippo instanceof HeavyAnimal;  // true
        boolean b1 = hippo instanceof Elepahnt;     // false

All java classes inherit from Objec, which means that "x instanceof Object" is usually true, except for one case where it is false. If the literal null or a variable reference pointing to null is used to check instanceof, the result is false.

There is another scenario.

        Hippo hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo;        // true
        boolean b1 = hippo instanceof HeavyAnimal;  // DOES NOT COMPILE

There's no posible way that for a hippo variable reference to be an Elephant , since hippo doesn't extends Elephant.

The compilation check only applies if instanceof is called on a class. When checking whether an object is in an instanceof of an interface , java wait until runtime to do the check. the reason is that a subclass could implement that interface and the compiler wouldnt know it.

### To String

Java automatically calls the toString() method if you try to print out an object.

When you implement the toString() method, you can provide as much or as little information as you would like.

        public String toString() {
                return "Name: " + name + ", weight: "+ weight;
        }

### Equals.

Remeber that java uses == to compare primitives and for checking if two variables refer to the same object. Checking if two objects are equivalent uses the equals() method, or at least it does if the develiper implementing the method iverrides equals().

String does have an equals() method. It checks that the values are the same. StringBuilder uses the implementation of equals provided by Object,which simply checks if the two objects being referred to are the same.

        String s1 = new String("lion");
        String s2 = new String("lion");
        System.out.println(s1.equals(s2));                      // true
        StringBuilder sb1 = new StringBuilder("lion");
        StringBuilder sb2 = new StringBuilder("lion");
        System.out.println(sb1.equals(sb2));                    // false

The contract for equals() methods.

Since equals() is such a key method, java provides a number of rules in the conrtact for the method. The exam expects you to recognize correct and incorrect equals() methods, but it will not ask you to name which property is broken:

1. It is reflexive: For any non-null reference values x , x.equals(x) should return true.
2. It is symmetric: For any non-null references values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
3. It is transitive: For any non-null references values x,y and z. If x.equals(y) returns true amd y.equals(z) returns true , then x.equals(z) should return true.
4. It is consistent: For any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false.
5. For any non-null reference value x, x.equals(null) should return false.

The definition of equality does not change at random, and the same objects can not be equals sometimes.

### HasCode.

whenever you override equals(), you are also expected to override hashCode(). The hash code is used when storing the object as a key in a map. A hash code is a number that puts instances of a class into a finite number of categories. Also remember that a hash code is just a number, so you can use a primitive number or divide to get a smaller int.

The contract for hashCode() methods is :

1. Whitin the same program, the result of hashCode() must not change. This means that you should not include variables that changes in figuring out the hash code.
2. If equals return true when called with two object, calling hashCode()  on each of those objects must return the same result.
3. If equals() returns false when called with two objects, calling hashCode() on each of those objects does not have to return a different result. This mean hashCode() result do not need to be unique when called on unequals objects.

It is common to multiply by a prime number when combining multiple fields in the hashCode. this makes the hashCode more unique, which helps when distributing objects into the buckets.














