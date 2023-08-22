package book4.ch2;

public class EnhancedLoop
{
    public static void main(String[] args)
    {
        String[] daysOfWeek = getDaysOfWeek();
        printStringArray(daysOfWeek);
    }

    public static String[] getDaysOfWeek()
    {
        String[] days = {"Sunday", "Monday", "Tuesday",
                "Wednesday", "Thursday",
                "Friday", "Saturday"};
        return days;
    }

    public static void printStringArray(String[] array)
    {
        for (String s : array)
        {
            System.out.println(s);
        }
    }
}



