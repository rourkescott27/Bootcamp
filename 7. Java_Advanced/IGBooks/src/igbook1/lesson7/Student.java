/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package igbook1.lesson7;

/**
 *
 * @author Rourke Scott
 */
public class Student
{

    String name;
    Long id;
    Double gpa;

    public Student(String name, Long id, Double gpa)
    {
        this.name = name;
        this.id = id;
        this.gpa = gpa;

    }
    
     @Override
    public String toString()
    {
        return "Student : " + this.name + "\tGPA : " + this.gpa;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @return the gpa
     */
    public Double getGpa()
    {
        return gpa;
    }
}
