package book2.ch2;

public class HelloApp {
//    public static String helloMessage;
//
//    public static void main(String[] args)
//    {
//        helloMessage = "Hello World!";
//        System.out.println(helloMessage);
//    }
//
// ******* CANNOT USE INSTANCE VARIABLE IN STATIC METHODS UNLESS YOU FIRST CREATE AN INSTANCE
//    String helloMessage;
//
//    public static void main(String[] args)
//    {
//        helloMessage = "Hello World!";
//        System.out.println(helloMessage);
//    }

    public String helloMessage; // Instance variable
    public static String helloMessage2; // Class variable

    public static void main(String[] args) {
        HelloApp h = new HelloApp(); // creating instance of class to use its instance variable
        h.helloMessage = "Java is something else";
        System.out.println(h.helloMessage);

        helloMessage2 = "HELLO WORLD"; // using class variable without creating an instance
        System.out.println(helloMessage2);


    }

}




