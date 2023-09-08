package book5.ch4;

import java.time.*;
import java.time.format.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class TimeTester
{
    public static void main(String[] args)
    {
        /*System.out.println("\nLocalTime: " + LocalTime.now().toString());
        System.out.println("\nLocalDateTime: " + LocalDateTime.now().toString());
        System.out.println("\nZonedDateTime: " + ZonedDateTime.now().toString());
        System.out.println("\nOffsetTime: " + OffsetTime.now().toString());
        System.out.println("\nOffsetDateTime: " + OffsetDateTime.now().toString());
        System.out.println("\nMonthDay: " + MonthDay.now().toString());
        System.out.println("\nYearMonth: " + YearMonth.now().toString());
        System.out.println("\nInstant: " + Instant.now().toString());*/

//      Using the parse method to create a date time object
//        LocalDate d = LocalDate.parse("2014-12-15");
//        System.out.println(d + "\n");

       /* try
        {
            LocalDateTime ldt = LocalDateTime.parse("2014-12-15T15:45");
            System.out.println(ldt);
        } catch (DateTimeParseException e)
        {
            System.out.println(e.getLocalizedMessage());
        }*/

//      Using the of Method to Create a Date-Time Object
        /*LocalDate date = LocalDate.of(2014, Month.DECEMBER, 15);
        System.out.println(date);*/

//      Using the ZoneId class
//        for(String zone : ZoneId.getAvailableZoneIds())
//        {
//            System.out.println(zone);
//        }
//        ZoneId zi = ZoneId.of("America/Los_Angeles");
//        ZonedDateTime zDate;
//        zDate = ZonedDateTime.of(2014, 12, 15, 0, 0, 0, 0, zi);
//        System.out.println(zDate);

//      Using the ZoneOffset class
        /*// Accepts an integer as a parameter
        ZoneOffset zo = ZoneOffset.ofHours(-8);
        System.out.println(zo);

        // Accepts a string as a parameter
        ZoneOffset zos = ZoneOffset.of("-08:00");
        System.out.println(zos);

        // Using the ZoneOffset object to create an OffSetTime
        OffsetTime time = OffsetTime.of(10, 30, 0, 0, zos);
        System.out.println(time);*/

//      Extracting Information About a Date
        /*LocalDate date = LocalDate.now();
        // Gets year from LocalDate
        int year = date.getYear();
        System.out.println(year);
        // Gets month from LocalDate
        int month = date.getMonthValue();
        System.out.println(month);
        // Gets day from LocalDate
        int day = date.getDayOfMonth();
        System.out.println(date);
        // Gets day of year from LocalDate
        int dayOfYear = date.getDayOfYear();
        System.out.println(dayOfYear);*/

//      Comparing Dates
//      if (LocalDate.now() == LocalDate.now()) // Wrong way, cant use the == comparison operator with dates
        /*if (LocalDate.now().equals(LocalDate.now()))
        {
            System.out.println("All is right in the universe.");
        } else {
            System.out.println("There must be a disturbance in the space-time continuum!");
        }

        if (LocalDate.now().getDayOfMonth() < 15)
        {
            System.out.println("The 15th is still on the way!");
        }*/

        //Calculating with Dates
        /*System.out.println("Today: " + LocalDate.now());
        System.out.println("Tomorrow: " + LocalDate.now().plusDays(1));
        System.out.println("Next week: " + LocalDate.now().plusWeeks(1));
        System.out.println("Next month: " + LocalDate.now().plusMonths(1));
        System.out.println("Next year: " + LocalDate.now().plusYears(1));*/

       /* LocalDate date1 = LocalDate.parse("2023-09-04");
        LocalDate date2 = LocalDate.parse("2024-03-27");
        System.out.println(date1.until(date2, ChronoUnit.DAYS) + " days until your birthday");
        System.out.println(date1.until(date2, ChronoUnit.WEEKS) + " weeks until your birthday");
        System.out.println(date1.until(date2, ChronoUnit.MONTHS) + " months until your birthday");
        System.out.println(date1.until(date2, ChronoUnit.YEARS) + " years until your birthday");*/

        /*LocalDate today = LocalDate.now();
        LocalDate invDate = LocalDate.of(today.getYear(), today.getMonthValue(), 15);
        if (today.getDayOfMonth() > 15)
        {
            invDate = invDate.plusMonths(1);
        }
        long daysToInvoice = today.until(invDate, ChronoUnit.DAYS);
        System.out.println(daysToInvoice + " days until next invoice date.");*/

        //Formatting dates
       /* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM YYYY");
        LocalDate date = LocalDate.now();
        System.out.println(date.format(formatter));*/

        /*LocalDateTime now = LocalDateTime.now();
        printDate(now, "YYYY-MM-dd");
        printDate(now, "MM-dd-YYYY");
        printDate(now, "dd MMM YYYY");
        printDate(now, "MMMM d, YYYY");
        printDate(now, "HH:mm");
        printDate(now, "h:mm a");*/

    }

    /*private static void printDate(LocalDateTime date, String pattern)
    {
        DateTimeFormatter f;
        f = DateTimeFormatter.ofPattern(pattern);
        pattern = (pattern + "          ").substring(0, 14);
        System.out.println(pattern + " " + date.format(f));
    }*/
}
