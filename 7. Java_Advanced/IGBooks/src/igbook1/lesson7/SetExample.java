/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igbook1.lesson7;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Rourke Scott
 */
public class SetExample {
  
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("C");
        set.add("D");
        set.add("B");
        
        for(String item: set)
        {
            System.out.println(item);
        }

    }
}
