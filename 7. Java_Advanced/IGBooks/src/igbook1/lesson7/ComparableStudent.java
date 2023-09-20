/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igbook1.lesson7;

/**
 *
 * @author Rourke Scott
 */
public class ComparableStudent implements Comparable<ComparableStudent> {

    String name;
    Long id;
    Double gpa;

    public ComparableStudent(String name, Long id, Double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the gpa
     */
    public Double getGpa() {
        return gpa;
    }

//    ASCENDING NAME
//    @Override
//    public int compareTo(Student s) {
//        int result = this.getName().compareTo(s.getName());
//        if (result > 0) {
//            return 1;
//        } else if (result < 0) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
    
//    DECENDING NAME
    @Override
    public int compareTo(ComparableStudent s) {
        int result = this.getName().compareTo(s.getName());
        if (result > 0) {
            return -1;
        } else if (result < 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
//    ASCENDING GPA
//     @Override
//    public int compareTo(Student s) {
//        int result = this.getName().compareTo(s.getGpa());
//        if (result > 0) {
//            return 1;
//        } else if (result < 0) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
    
//    DECENDING GPA
//    public int compareTo(Student s) {
//        int result = this.getName().compareTo(s.getGpa());
//        if (result > 0) {
//            return -1;
//        } else if (result < 0) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
    
    
    
    @Override
    public String toString()
    {
        return "Student : " + this.name + "\tGPA : " + this.gpa;
    }
    

}
