/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ocp.exam.ch1;

/**
 *
 * @author Rourke Scott
 */
public class WritingLiterals
{

    public static void main(String[] args)
    {
        /*long max = 31234567894597L;
        double notAStart = 1_000_000.00;
        System.out.println(notAStart);

        String reference = "Hello";
        System.out.println(reference.length());*/

//        int len = reference.length();
//        System.out.println(len);
//        int bad = len.length(); --- WILL NOT COMPILE
//        len = null --- WILL NOT COMPILE BECAUSE PRIMITIVES CANNOT BE ASIGNED NULL
//        reference = null; --- REFERENCES CAN BE ASSIGNED NULL
//        Integer len = reference.length();
//        System.out.println(len.equals(reference));
//        int i = Integer.parseInt("123");
//        System.out.println(i);

//        Integer i2 = Integer.valueOf("123");
//        i.equals(i2); -- WILL NOT COMPILE BECAUSE IT IS A PRIMITIVE
//        i2.equals(i2);

        Double apple = Double.valueOf("200.99");
        System.out.println(apple.byteValue()); // -56
        System.out.println(apple.intValue()); // 200
        System.out.println(apple.doubleValue()); // 200.99
    }
}
