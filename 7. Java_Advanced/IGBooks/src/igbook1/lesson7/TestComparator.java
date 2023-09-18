/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igbook1.lesson7;

import java.util.*;

/**
 *
 * @author Rourke Scott
 */
public class TestComparator
{
    public static void main(String[] args)
    {
        List<Student> studentList = new ArrayList<>();
        Comparator<Student> sortName = new StudentSortName();
        Comparator<Student> sortGpa = new StudentSortGpa();
        
        studentList.add(new Student("Thomas Jefferson", 1111L, 3.8));
        studentList.add(new Student("John Adams", 2222L, 3.9));
        studentList.add(new Student("George Washington", 3333L, 3.4)); 
        
        Collections.sort(studentList, sortName);
        for(Student s : studentList)
        {
            System.out.println(s);
        }
        
        System.out.println("\n");
        
        Collections.sort(studentList, sortGpa);
        for(Student s : studentList)
        {
            System.out.println(s);
        }
        
    }
}
