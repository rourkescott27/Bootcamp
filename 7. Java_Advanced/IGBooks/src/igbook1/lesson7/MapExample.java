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
public class MapExample {
    
    public static void main(String[] args) {
        Map <String, String> partList = new TreeMap<>();
        partList.put("S001", "Blue Polo Shirt");
        partList.put("S002", "Black Polo Shirt");
        partList.put("H001", "Duke Hat");
        
        partList.put("S002", "Black T-Shirt"); //OVERWRITING
        Set <String> keys = partList.keySet();
        
        System.out.println("=== Part List ===");
        for(String key: keys)
        {
            System.out.println("Part#: " + key + " " + partList.get(key));
        }
        
        }
}
