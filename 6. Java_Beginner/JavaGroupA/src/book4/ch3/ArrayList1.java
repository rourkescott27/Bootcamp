package book4.ch3;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList1 implements Iterable
{
    public static void main(String[] args)
    {
//        ArrayList signs = new ArrayList();
////        ArrayList signs = new ArrayList<>(100);
//        signs.add(100);
//        signs.add("Hi");
//        System.out.println(signs);

//        ArrayList<Employee> signs = new ArrayList<>();
//        signs.add("Sheryl");
//        Employee emp = new Employee("Dreyer", "Sheryl");
//        signs.add(emp);
//        System.out.println(signs);

//        ArrayList<String> nums = new ArrayList<>(2);
//        nums.add("One");
//        nums.add("Two");
//        nums.add("Three");
//        nums.add("Four");
//        nums.add(2, "Eleven");

//        DIFFERENT WAYS OF NAVIGATING ARRAY LISTS/ ARRAYS
//        for(int i = 0; i < nums.size(); i++)
//        {
//            System.out.println(nums.get(i));
//        }

//        for(String e : nums)
//        {
//            int i = nums.indexOf(e);
//            System.out.println("Item " + i + " : " + e);
//        }

//        Iterator e = nums.iterator();
//        while(e.hasNext())
//        {
//            String s = (String) e.next();
//            System.out.println(s);
//        }

//        String first = nums.set(0, "UNO");
//        String second = nums.set(1, "DOS");
//        String third = nums.set(2, "TRES");
//        String fourth = nums.set(3, "QUATRO");
//        System.out.println(first);
//        System.out.println(second);
//        System.out.println(third);
//        System.out.println(fourth);
//        System.out.println(nums);

//        ArrayList <String> newItems = new ArrayList<>(4);
//        newItems.add("UNO");
//        newItems.add("DOS");
//        newItems.add("TRES");
//        newItems.add("CUATRO");
//
//        for(int i = 0; i < nums.size(); i++)
//        {
//            System.out.println(nums.set(i, newItems.get(i)));
//        }
//        System.out.println(nums);

//        ArrayList<Employee> emps1 = new ArrayList<Employee>();
//        // create employee objects
//        Employee emp1 = new Employee("Addams", "Gomes");
//        Employee emp2 = new Employee("Taylor", "Andy");
//        Employee emp3 = new Employee("Kirk", "James");

        // add employee objects to array list
//        emps1.add(emp1);
//        emps1.add(emp2);
//        emps1.add(emp3);
//
//        ArrayList<Employee> emps2 = new ArrayList<Employee>();
//        emps2.add(emp2);
//        emps2.add(emp3);

        // print the array list
//        System.out.println(emps1);
//        emps1.removeAll(emps2);
//        emps1.retainAll(emps2);

        // remove one of the employees
//        emps1.remove(emp3);

        // print the array list again
//        System.out.println(emps1);
    }

    @Override
    public Iterator iterator()
    {
        return null;
    }
}

class Employee
{
    String lastName;
    String firstName;

    public Employee(String lastName, String firstName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return this.firstName + " " + this.lastName;
    }
}
