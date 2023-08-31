package book4.ch5;

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

class HourlyEmployee extends Employee
{

    public HourlyEmployee(String lastName, String firstName)
    {
        super(lastName, firstName);
    }
}
