# OCP Documentation

# Index

* [Chapter 1 - Advanced Class Design](#Advanced-Class-Design)
    * [Reviewing OCA Concepts](##Reviewing-OCA-Concepts)
        * [Access Modifiers](###Access-Modifiers)
        * [Overloading and Overriding](###Overloading-and-Overriding)

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

Overloading.

The method name is the same but the parameter must vary by type or number.

When multiple overloaded methods are present, Java looks for the closest match first.

1. Exact match types.
2. Matching superclass types.
3. Converting to a larger primitive type.
4. Converting to an autoboxed type.
5. Varargs.

Overrinding.

Overrinding occurs only when the method signature is the same(name and parameters).

1. The access modifier must be the same or more accesible.
2. The return type must be the same or more restrictive type, also known as covariante return types.
3. If any checked excepcion are thrown, only the same exceptions or subclasses of those exception are allowed to be thrown.
4. The methods must not be static(If they are, the method is hidden and not overriden.)


