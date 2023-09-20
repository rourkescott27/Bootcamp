/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ocp.exam.ch1;

//import java.util.Date;
//import java.sql.Date;
/**
 *
 * @author Rourke Scott
 */
public class Conflicts
{

    public static void main(String[] args)
    {
        java.sql.Date sDate = new java.sql.Date(124, 12, 12);
        java.util.Date uDate = new java.util.Date();
        
        System.out.println(uDate.toString());
        System.out.println(sDate);
    }

}
