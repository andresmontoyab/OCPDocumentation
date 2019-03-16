package OCP.chapter1;

public class Enums {

    public static void main(String[] args) {

        //usingValuesMethod();
        //notToDo();
        //usingValueOf();
        //usingSwichWithEnums();



    }

    private static void usingSwichWithEnums() {
        Season winter = Season.WINTER;
        switch (winter) {
            case FALL:
                System.out.println("This is fall");
                break;
            case SPRING:
                System.out.println("This is Spring");
                break;
       //     case Season.WINTER:
       //         System.out.println("This is winter");
       //         break;
            default:
                System.out.println("Should be summer");
                break;
        }
    }

    private static void usingValueOf() {
        Season s1 = Season.valueOf("WINTER");
        //Season s2 = Season.valueOf("Winter");
    }

    private static void notToDo() {
        //if(Season.SPRING == 2){} DOES NOT COMPILE
    }

    private static void usingValuesMethod() {
        for(Season season : Season.values())
        {
            System.out.println(season.name() + season.ordinal()
            );
        }
    }
}

enum Season {
    WINTER {
        public void printHours() {
            System.out.println(" 9 - 3");
        }
    },
    SPRING { public void printHours() {
        System.out.println(" 3 - 5");
    }},
    FALL;

   public void printHours() {
       System.out.println(" default hours");
   }
}

/*
enum SeasonEXt extends Season {
    WINTER, SPRING, FALL;
}
*/