package book4.ch5;

public class GenQueueTest
{
    public static void main(String[] args)
    {
        GenQueue<Employee> empList = new GenQueue<>();
        GenQueue<HourlyEmployee> hList = new GenQueue<>();

        hList.enqueue(new HourlyEmployee("Trump", "Donald"));
        hList.enqueue(new HourlyEmployee("Gates", "Bill"));
        hList.enqueue(new HourlyEmployee("Forbes", "Steve"));

        empList.addItems(hList);

        while (empList.hasItems())
        {
            Employee emp = empList.dequeue();
            System.out.println(emp);
        }

    }
}
