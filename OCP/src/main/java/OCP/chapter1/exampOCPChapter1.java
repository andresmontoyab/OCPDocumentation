package OCP.chapter1;

public class exampOCPChapter1 {

    public static void main(String[] args) {

        /**
         * 1. Good
         * 2. Good
         * 3. Good
         * 4. Bad -> Just remember that whenever that you are overriding a hashcode you must ensure dont break the result between hashCode and eqquals.
         * 5. Good
         * 6. Good
         * 7. Good
         * 8. Good
         * 9. Bad -> You must to clarify when a variable is effectively final
         * 10. Good
         * 11. Bad -> Just remember the proper way of import static member is "import static" and never "static import"
         * 12. Good
         * 13. Good
         * 14. Bad -> You have to clarify the specifics rules for instances of regarding when the compiler fails (Subclasses, interfaces and not relation class.)
         * 15. Good
         * 16. Bad -> The way of create a new instance of a inner class is Outer.Inner = new Outer().new Inner() is  a little weird.
         * 17. Bad -> Remember the rules for enums, the constructor is always private and if is public wont compile, and also must have ";" if there are more lines in the code.
         * 18. Good
         * 19. Good
         * 20. Good
         * 21. Good
         * Average -> Good 15/21 = 71.4%
         */
    }
}
