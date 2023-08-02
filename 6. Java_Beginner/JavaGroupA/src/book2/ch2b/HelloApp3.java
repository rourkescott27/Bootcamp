package book2.ch2b;

import book2.ch2.HelloApp;

public class HelloApp3
{
    public static void main(String[] args)
    {
        HelloApp h = new HelloApp(); // creating instance of HelloApp to use and print its instance variable
        h.helloMessage = "Rourke Scott";
        System.out.println(h.helloMessage);

        System.out.println(HelloApp.helloMessage2); // printing a class/static variable from HelloApp using the class name in front

        HelloApp.main(args); // running static/class method of HelloApp
    }
}
