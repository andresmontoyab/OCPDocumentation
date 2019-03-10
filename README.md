# OCP Documentation

# Index

* [Chapter 1 - Advanced Class Design](#Advanced-Class-Design)
    * [Reviewing OCA Concepts](#Reviewing-OCA-Concepts)
        * [Access Modifiers](#Access-Modifiers)
        * [Overloading and Overriding](#Overloading-and-Overriding)
        * [Abstract Classes](#Abstract-Classes)
        * [Static vs Final](#Static-vs-Final)
        * [Import](#Import)

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

###





