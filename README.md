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















