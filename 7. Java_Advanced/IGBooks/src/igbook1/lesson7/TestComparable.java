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
public class TestComparable {
    
    public static void main(String[] args) {
        Set<ComparableStudent> studentList = new TreeSet<>();
        studentList.add(new ComparableStudent("Thomas Jefferson", 1111L, 3.8));
        studentList.add(new ComparableStudent("John Adams", 2222L, 3.9));
        studentList.add(new ComparableStudent("George Washington", 3333L, 3.4));
        
        for(ComparableStudent s : studentList)
        {
            System.out.println(s);
        }

    }
    
}
