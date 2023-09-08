package book5.ch2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher
{
    private static Pattern droidPattern;
    public static void main(String[] args)
    {
        validDroidName("R2-D2");
        System.out.println(validDroidName("R2-D2"));
    }

    private static boolean validDroidName(String droid)
    {
        if (droidPattern == null)
        {
            String regex = "(\\w\\d-\\w\\d)|" + "(\\w-\\d\\w\\w)";
            droidPattern = Pattern.compile(regex);
        }
        Matcher m = droidPattern.matcher(droid);
        return m.matches();
    }

}
