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
        * [Working with Enums](#Working-with-enums)
        * [Creating Nested Classes](#Creating-Nested-Classes)
* [Chapter 2 - Design Pattern and Principles](#Design-Pattern-and-Principles)
    * [Designing an Interface](#Designing-an-Interface)
    * [Introducing Functional Programming](#Introducing-Functional-Programming)
    * [Understaing Lambda Syntax.](#Understaing-Lambda-Syntax.)
    * [Implementing Polymirphism.](#Implementing-Polymirphism.)
        * [Object vs Reference.](#Object-vs-Reference.)
        * [Casting Object References.](#Casting-Object-References.)
    * [Understanding Design Principles.](#Understanding-Design-Principles.)
        * [The Is-a Relationship.](#The-Is-a-Relationship.)
        * [The has-a Relationship.](#The-Has-a-Relationship.)
    * [Design Patterns](#Design-Patterns)
        * [Singleton Pattern.](#Singleton-Pattern.)
        * [Inmutable Objects.](#Inmutable-Objects.)
        * [Builder Pattern.](#Builder-Pattern.)
        * [Factory Pattern](#Factory-Pattern)
    
    

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

### Working With Enums

* In programming, it is common to have a type that can only have a finitite se of values. An enumartion is like a fixed set of constants. In java an enum is a class that represents an enumeration. It is much better that a bunch of constant because it provides a type-safe checking. With numeric constants, you can pass an invalidad value and not find out until runtime. With enums, it is imposible to create invalid enum type without introducing a compiler error.

        enum Season {
             WINTER, SPRING, FALL;
        }

Since an enum is like a set of constants, use the upper letter convention that you used for constant.

Behind the scenes, an enum is a type of class that mainly contains static members. It also includes some helper methods like name().

        Season s = Season.WINTER;
        System.out.println(Season.SPRING);              // SPRING
        System.out.println(s == Season.SPRING);         // SPRING

As you can see, enums print the name of the enum when toString() is caled         

* As enum provides a method to get an array of all the values. 


        for(Season season : Season.values())
            {
              System.out.println(season.name() + season.ordinal()            // WINTER 0, SPRING 1, FALL 2
            }

* You can not compare an int and enum value directly anyway. Remember that an enum is a type and not an int.

        if(Season.SPRING == 2){} DOES NOT COMPILE

* You can also create can create an enum from String.

        Season s1 = Season.valueOf("WINTER");           // SUMMER
        Season s2 = Season.valueOf("Winter");           // Exception

The second statement encounters a problem, there is no enum value with the lowercase name "Winter" and for this reason java throws an IlegalArgumentExcepcion.

* Another thing that you can not do is extend an enum

        enum SeasonEXt extends Season {         // DOES NOT COMPILE
                WINTER, SPRING, FALL;
        }

* Enums may be used in switch statements.

        Season winter = Season.WINTER;
                switch (winter) {
                case FALL:
                        System.out.println("This is fall");
                        break;
                case SPRING:
                        System.out.println("This is Spring");
                        break;
                case WINTER:
                        System.out.println("This is winter");
                        break;
                default:
                        System.out.println("Should be summer");
                        break;
                }

Notice that we write just the name of the enum rather to Season.FALL and in fact if you write Season.FALL java will not compile.        

### Adding constructors, fields and methods.

        enum Season {
            WINTER("low"),
            SPRING("medium"),
            FALL("high");
        
            private String expectedVisitor;
        
            private Season(String expectedVisitor) {
                this.expectedVisitor = expectedVisitor;
            }
        
            public void printExpectedVisitors() {
                System.out.println(expectedVisitor);
            }
        }

The constructor is rpivate because it can only be called from within the enum, the code wont compile with a public constructor.

* Specific and default methods in enums.

        enum Season {
            WINTER {
                public void printHours() {
                   System.out.println(" 9 - 3");
                }
            },
            SPRING { public void printHours() {
                System.out.println(" 3 - 5");
                }
            },
            FALL;

        public void printHours() {
             System.out.println(" default hours");
           }
        }

We only code the special case and let the other use the default, other option is create the printHours default method as abstract and in this case each case must implement the method.


### Creating Nested Classes.

* A nested class is a class that is defined within another class. A nested class that is not static is called an inner class. There are four types of nested classes:

1. A Member inner class is a class defined at the same level as instance variables. It is not static. Often this is just referred to as an inner class without explicity saying the type.

2. A local inner class is defined within a method.

3. An anonymous inner class is a special case of a local inner class that does not have name.

4. A static nested class is a static class that is defined at the same leve as static variables.

* There are a few benefits of using inner classes. They can encapsulate helper classes by restricting them to the containing class.

### Member Inner Classes.

A member inner class is defined ar the member leve of a class. Member inner classes have the following properties:

1. Can be declared public, private or protected or default access.

2. Can extends any class and implements interfaces.

3. Can be abstract or final.

4. Can not declare static fields or methods.

5. Can access members of the outer class including private members.

        public class Outer {
        
                private String greeting = "Hi";
        
                protected class Inner {
                        public int repeat = 3;
                        public void go() {
                        for (int i = 0; i < repeat; i++) {
                                System.out.println(greeting);
                        }
                        }
                }
        
                public void callInner() {
                        Inner inner = new Inner();
                        inner.go();
                }

                public static void main(String[] args) {
                        Outer outer = new Outer();
                        outer.callInner();
                }
        }

Since a member inner class is not static, it has to be used with an instnace of the outer class.

        public static void main(String[] args) {
                Outer outer = new Outer();
                Inner inner = outer.new Inner();        // create inner class.
                inner.go();
                }
        }

Inner classes can have the same variable names as outer classes. There is a special way of calling, this to say which class you want to access.

        public class OuterTwo {
        private int x = 10;
        class B {
                private int x = 20;
                class C {
                private int x = 30;
                public void allTheX() {
                        System.out.println(x);                  // 30
                        System.out.println(this.x);             // 30        
                        System.out.println(B.this.x);           // 20
                        System.out.println(OuterTwo.this.x);    // 10
                }
                }
        }

        public static void main(String[] args) {
                OuterTwo outerTwo = new OuterTwo();
                OuterTwo.B b = outerTwo.new B();
                OuterTwo.B.C c = b.new C();
                c.allTheX();
        }
        }

* Private Interfaces

        public class PrivateInnerIneterface {
            private interface Secrete {
                public void shh();
                }
        
        class DontTell implements Secrete {
            public void shh() {
                
             }
        }
        }

The rules that all methods in an interfaces are public still applies.

If the interface is private this means that the interface can only be referred to within the current outer class.

### Local Inner Classes

* A local inner class is a nested class defined within a method. Like local variables a local inner class declaration does not exist until the method is invoked, and it goes out of scope when the methods returns. This means that you can create instances only from within the method. this instances can still be returned from the method.

1. They do not have an access specifiers.

2. They can not be declared static and can not declare static field or methods.

3. They have access to the all fields and methods of the enclosing class.

4. They do not have access to local variables of a method unless those variables are final or effectively final.

        public class InnerLocalClass {

        private int length = 5;
        String example = "almost final";
        public void calculate() {
                final int width = 20;
                class Inner {
                public void multiply() {
                        System.out.println(length + width + example);
                }
                }
                Inner inner = new Inner();
                inner.multiply();
        }

        public static void main(String[] args) {
                InnerLocalClass innerLocalClass = new InnerLocalClass();
                innerLocalClass.calculate();
        }
        }

Just remember if you want to use the variables in the outer class, those variables must be final or effectively final.

### Anonymous Inner Classes.

An anonymous inner class is a local inner class that does not have a name. It is declared and instantiated all in one statement using the new keywork. Aninymous inner classes are required to extend an existing class or implement an existing interfaces. They are useful when you have  a short implementation what will not be used anywhere else.

        public class AnnoInner {
        abstract class SaleTodayOnly {
                abstract int dollarOff();
        }
        
        public int admission(int basePrice) {
                SaleTodayOnly sale = new SaleTodayOnly() {
                int dollarOff() {
                        return 3;
                }
                };
                return basePrice - sale.dollarOff();
        } 
        }

If you want to implement both an interface and also a class  and extend a class, You can not with anonymous inner class.

        public class AnonymousAsParameter {
        interface SaleTodayOnly {
                int dollarOff();
        }

        public int pay() {
                return admission(5, new SaleTodayOnly() {
                public int dollarOff() {
                        return 3;
                }
                });
        }
        public int admission(int basePrice, SaleTodayOnly saleTodayOnly) {
                return basePrice - saleTodayOnly.dollarOff();
        }
        }

#### Static Nested Classes

* A Static nested class is a static class defined at the member level. It can be instantiated without an object of the enclosing class, so can not access the instances variables without an explicit object of the enclosing class. In other words is like a regular class except for the following.

1. The nesting create a namespace because the enclosing class name must be used to refer to it.
2. It can be made private or use one of the other access modifiers to encapsulate it.
3. The enclosing class can refer to the field and methods of the static nested class.

        public class StaticInnerClass {
        static class Nested {
                private int a = 6;
        }

        public static void main(String[] args) {
                Nested nested = new Nested();
                System.out.println(nested.a);
        }
        }

As we can see because this is a static nested class we dont need to use the enclosing class to create a instnace of the inner class.     

# Design Pattern and Principles

## Designing-an-Interface

* As you may recall, an interface is an abstract data type, similar to a class that defines a list of public abstract methods that any class implementing the interface must provide. An interface may also include constant public static final variables, default methods and static methods.


```
interface Fly {
    public int getWingSpan() throws Exception;
    public static final int MAX_SPEED = 100;
    
    public default void land() {
        System.out.println("Animal is landing");
    }
    
    public static double calculateSpeed(float distance, double time) {
        return distance/time;
    }
}

class Eagle implements Fly {
    public int getWingSpan() throws Exception {
        return 0;
    }

    public void land() {

    }
}
```

* An Interface can extend another interfaces, and in doing so it inherits all of the abstract methods.

```
interface Walk {
    boolean isQuadruped();
    abstract double getMaxSpeed();
}

interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}

class Lion implements Run {
    public boolean isQuadruped() {
        return false;
    }

    public boolean canHuntWhileRunning() {
        return false;
    }

    public double getMaxSpeed() {
        return 0;
    }
}
```

* The compiler automatically adds public to all interfaces methods and abstract to all non-static and non-default methods, if the developer does not provide them.

* Remember that an interface can not extend a class, nor can a class extend an interface.

```
public interface Sleep extends Lion {}          // Does not compile

public class Tiger extends Walk {}              // Does not compile

```

* Interface also serve to provide limited support for multiple inheritance within the java language, as a class may implement multiple interface.

```
public interface Swin {}

public interface Hop {}

public class Frog implements Swin, Hop {}

```

* <mark> Java will failing to compile if a class or interface inherits two defaults methods with the same signature and does not provide its own implementation <mark>.

* And interface provide a way for one individual to develop code that uses another individual's code, without having access to the other individual's underlying implementation, Interfaces can facilitate rapid application development by enabling development teams to create application in parallel, rather than being directly dependent on each other.


## Introducing Functional Programming

* Java defines a functional interface as an interface that contains a single abstract method. Functional interfaces are used as the basi for lambda expression in funcional programming. A lambda expression is a block of code that get passed around, like an anonymous method.

```
@FunctionalInterface
public interface FunctionalInterfaces {
    public void sprint(Object animal);
}

class Tiger implements FunctionalInterfaces {
    public void sprint(Object animal) {
        System.out.println("Animal is sprinting fast");
    }
}
```

* While it is a good practice to mark a functional interface with the @FunctionalInterface annotation for clarity, it is not required with functional programming. The java compiler implicity assumess that any interface that contains exactly one abstract method is a functional interface. Conversely, if a class marked with the @FunctionalInterface annotation contains more than one abstract method, or no abstract method al all, then the compiler will detect this error and not compile.

* One problem with no marking your functional interface with this annotaion is that another developer may treat any interface that you create like a simple interface.

## Understaing Lambda Syntax.

* The syntax of lambda is tricky because many parts are optional. These two lines are equivalent and do the exact same thing:

```

a -> a.canHop()

(Animal a) -> {return a.canHop();}

```

* The left side of the arrow operator "->" indicates the input parameters for the lambda expression. It can be consummed by a functional interfaces whose abstract methods has the same number of parameters and compatible data types. The right side is referred to as the body of the lambda expression. It can be consumed by a functional interface whose abstract method returns a compatible data type.

```
(Animal a) -> { return a.canHop();}

```

1. Optional parameter type.
2. Parameter name
3. arrow.
4. return and ";" are required if we used the {}
5. body.

* The parentheses () can be omitted in a lambda expression if there is exactly one input parameter and the type is not explicty staetd in the expression. This means that expressions that have zero or more than one input parameters will still require parentheses.

### Invalid Lambdas

```
Duck d -> d.quack()
a,d -> d.quack()
Animal a, Duck d -> d.quack()

```

* What is tricky here is that when you add braces {}. you must explicity terminate each statement in the body with semicolons ";".
* We were able to omit {}, ";" and return statement because this is a special shortcut that java allows for single-line lambda bodies.

* When using {} in the body of the lambda expression, you must use the return statement if the functional interface method that lambda implements returns a value. Alternatively a return statement is optional when the return type of the method is a void.

* Therenos rule that says the lambda expression must use all of the input parameters.

```
(a,b) -> a.startsWith("test")

```

* We've been defining an argument list in out lambda expressions. Since java does not allow us to re-declare a local variable. the following is a issue.

```
(a,b) -> { int a = 0; return 5}          // DOES NOT COMPILE.

```

## Implementing-Polymirphism

* Polymorphism is the ability of a single interface to su´pport multiple forms. In java, this allows multiples types of objects to e passed to a single method or class.

```
interface LivesInOcean {
    void makeSound();
}

class Dolphin implements LivesInOcean {
    public void makeSound() {
        System.out.println("whistle");
    }
}

class Whale implements LivesInOcean {
    public void makeSound() {
        System.out.println("Sing");
    }
}

class Oceanographer {

    public void checkSound(LivesInOcean livesInOcean){
        livesInOcean.makeSound();
    }
    public static void main(String[] args) {
        Oceanographer oceanographer = new Oceanographer();
        oceanographer.checkSound(new Dolphin());
        oceanographer.checkSound(new Whale());
    }
}
```

* A Java object may be accessed using a reference with the same type as the object, reference that is a superclass of the object. or a references that defines an interface that the object implements, either directly or through a super class. Furthermore a cast is not required if the object is being reassigned to a supertype or interface of the object.

* THIS IS VERY IMPORTANT -> If you use a variable to refer to an object, then only the methods or variables that are part of the variable's references type can be called without an explicity cast.

### Object vs Reference.

* Conceptually, though, you should consider the object as the entity that exists in memory, allocated by the Java runtime environment. Regardless of the type of the reference that the type of the reference that you have fo the object in memory, the object itself does not change.

1. The type of the object determine which properties exist within the object in memory.
2. The type of the reference to the object determines which methods and variables are accesible to the java program.

### Casting Object References 

* Here are the basic rules to keep in mind when casting variables:

1. Casting an object from a subclass to a superclass does not require an explicit cast.
2. Casting an object from a superclass to a subclass requires an explicit cast.
3. The compiler will not allow cast to unrelated types.

```

public class Bird {}

public class Fish {
        public static void main(String[] args) {
                Fish fish = new Fish();
                Bird bird = (Bird) fish; // DOES NOT COMPILE.
        }
}

```

4. Even when the code compiles without issue, an exception may be thrown at runtime if the object being cast is not actually an instance of that class.

```
public class Rodent {}

public class Capybara extends Rodent {
        public static void main(String[] args) {
                Rodent rodent = new Rodent();
                Capybara capyvara = (Capybara) rodent;          // ClassCastException.
        }
}

```

## Understanding Design Principles.

* A design principle is an established idea or best practice that facilitates the software design process.

* In general, following good desing principles leads to:

1. More logical code.
2. Code that is easier to understand.
3. Classes that are easier to reuse in other relationships and appications.
4. Code that are easier to maintain and that adapst more readity to changes in the application requirements.

### The Is-a Relationship.

* In Object Oriented design, we describe the property of an object being an instance of a data type as having an is-a relationship. the is-a relationship is also known as the inheritance test.

* The fundamental result of the is-a principle is that if A is-a B, the any instance of A can be treated like an instance of B. this hold true for a child that is subclass of any parent, be it direct subclass or a distant child.

* When constructing an inheritance-based data model, it is important to apply the is-a relationship regurlarly, so that you are deisgning classes that conceptually make sense.


### The Has-a Relationship.

* We refer to has-a relationship as the property of an object having a named data object or primitive as a member. The has-a relationship is also known as the object composition test.

* If a parent has-a object as a protected or public member, then any child of the parent must also have that object as a member.

* Object composition should be thought of as an alternate to inheritance and is often used to simulate polymorphic behavior that can not be achieved via single ingeritance.

## Design Patterns.

* A design pattern is an established general solution to a commonly ocurring software development problem.

* Creational patterns simply apply a level of indirection to object creation by creating the object in some other class, rather than creating the object directly in your application. Level of indirection is a general term for solving a software design problem by conceptually separing the task into multiples level.

### Singleton Pattern.

* Problem -> How do we create an object in memory only once in an application and have it shared by multiples classes?

* Solution -> The singletoon pattern is a creational pattern focused on creating only one instance of an object in memory within an application, shareable by all classes and threads within the application. The globally available object created by the singletoon parent is referred to as an singletoon.

```
class HayStorage {
    private int quantiyt;
    private HayStorage() {
        
    }
    
    private static final HayStorage instance = new HayStorage();
    
    public static HayStorage getInstance() {
        return instance;
    }
    
    public synchronized void addHay(int amount) {
        quantiyt += amount;
    }
}
```

* Singletoon in java are created as private static variables within the class, often with the name instance. They are accessed via a single singleton Object. Finally all constructor in a singletoon class are marked as private, which ensures that no other class is capable of instantiate another version of the class.

* Singletoon are used in a situations where we need access to a single set of data thoughout an application.

### Singletons in Server Environment.

* For the purpose of the exam, singletoon are always unique. When you get to writting application that run across multiple computer would have its own JVM. In those situations, you might still use the singletoon pattern, although it might be implemented with a database or a queue that a static object.

### Inmutable Objects.

* Problem -> How do we create read-only objects that can be shared and used by multiple classes?

* Solution -> The inmutable object pattern is a creational pattern based on the idea of creating objects whose state does not change after they are created abd can be easily shared across multiple classes.

1. Use a constructor to set all properties of the object.
2. Mark all of the instance variable private and final.
3. Do not define any setter method.
4. Do not allow reference mutable objects to be modified or accesed directly.
5. Prevent methods from being overriden.

* Regarding to the point 4, if for example we have a List<> and we have getList() method, the idea is never to return the reference to this list. More generally stated, you should never share references to a mutable objects contained within an inmutable object. 

### Builder Pattern.

* Problem -> How do we create an object that requires numerous values to be set at the time the object is instantiated.?

* Solution. -> The Builder patterns is a creational pattern in which parameters are passed to a builder object, often through method chaining and an object is generated with a final build call. It is often used with inmutable objects, since inmutable objects do not have setter methods and must be created with all of their parameters set, although it can be used with mutable objects as well.

```
public class AnimalBuilder {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }
    
    public Animal build() {
        return new Animal(this.species, this.age, this.favoriteFoods);
    }

    public static void main(String[] args) {
        AnimalBuilder animalBuilder = new AnimalBuilder();
        Animal cat = animalBuilder
                .setAge(15)
                .setSpecies("Feline")
                .setFavoriteFoods(Arrays.asList("Bread", "etc"))
                .build();
                
    }
}

class Animal {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = favoriteFoods;
    }
}
```

* The primary advantage of the builder pattern is that, over the time this approach leads to far more maintainable code. If a new optional field is added to the Animal class, the our code that creates object using the AnimalBuilder class will not need to be changed.

### Factory Pattern

* Problem -> How do we write code that creates objects in which the precise type of the object may not be known until run time.

* Solution -> The factory pattern, sometimes referred to as the factory method pattern, is a creational pattern based on the idea of using a factory class to produce instnaces of objects based on a set of input parameters. It is similar to the builder pattern, although it is focused on supporting class polymorphism.

```
abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public abstract void consumed();
}

class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Hay eaten : " + getQuantity());
    }
}

class Pellets extends Food {
    public Pellets(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Pellets eaten : " + getQuantity());
    }
}

class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Fish eaten : " + getQuantity());
    }
}

class FoodFactory {
    public static Food getFood(String animalName) {
        switch (animalName) {
            case "Zebra": return new Hay(100);
            case "rabbit": return new Hay(100);
            case "goat": return new Hay(100);
            case "polar": return new Hay(100);
        }
    }
}

class ZooKeeper {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("rabbit");
        food.consumed();
    }
}
```