package ca.bcit.comp2522.bank;

/**
 * The {@code Date} class represents a validated calendar date and provides utility methods
 * for date formatting and day-of-week calculation. It is designed to encapsulate the core
 * components of a date—year, month, and day—while enforcing strict validation rules to ensure
 *  correctness and consistency.
 * Firstly, it defines constants for years, such as the first year of the 1900s,
 * the first year of the 2000s, and the current year.
 * Secondly, it defines constants for the maximum number of days in months,
 * including leap year and non-leap year variations.
 * Thirdly, it stores useful divisors to check
 * leap years.
 * Fourthly, it defines constants for months
 * and for common numeric values.
 * Finally, it provides month codes used for calculating the day of the week.
 *
 * @author Minsu Kim
 * @author Hali Imanpanah
 * @author Esin Sahutoglu
 * @version 1.0
 */
public class Date
{
    private static final int FIRST_YEAR_OF_1900S = 1900;
    private static final int FIRST_YEAR_OF_2000S = 2000;

    private static final int CURRENT_YEAR = 2025;
    private static final int MAXIMUM_DAYS_IN_LEAP_YEAR     = 29;
    private static final int MAXIMUM_DAYS_IN_NON_LEAP_YEAR = 28;
    private static final int MAXIMUM_DAYS_IN_JANUARY       = 31;
    private static final int MAXIMUM_DAYS_IN_APRIL         = 30;

    private static final int LEAP_YEAR_DIVISOR_400 = 400;
    private static final int LEAP_YEAR_DIVISOR_100 = 100;
    private static final int LEAP_YEAR_DIVISOR_4   = 4;

    private static final int NO_OFFSET = 0;
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int OFFSET_FOR_1800S = 2;
    private static final int YEARS_DIVISOR_4 = 4;
    private static final int CENTURY_OFFSET_2000S = 6;
    private static final int DAYS_PER_WEEK = 7;
    private static final int MONTHS_PER_YEAR = 12;
    private static final int YEARS_PER_CENTURY = 100;
    private static final int MINIMUM_YEAR = 1800;

    private static final int  SUNDAY    = 1;
    private static final int  MONDAY    = 2;
    private static final int  TUESDAY   = 3;
    private static final int  WEDNESDAY = 4;
    private static final int  THURSDAY  = 5;
    private static final int  FRIDAY    = 6;

    private static final int JANUARY_CODE = 1;
    private static final int FEBRUARY_CODE = 4;
    private static final int MARCH_CODE = 4;
    private static final int APRIL_CODE = 0;
    private static final int MAY_CODE = 2;
    private static final int JUNE_CODE = 5;
    private static final int JULY_CODE = 0;
    private static final int AUGUST_CODE = 3;
    private static final int SEPTEMBER_CODE = 6;
    private static final int OCTOBER_CODE = 1;
    private static final int NOVEMBER_CODE = 4;
    private static final int DECEMBER_CODE = 6;

    private static final int LEAP_YEAR_DEFAULT = 0;

    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    private final int year;
    private final int month;
    private final int day;

    /**
     * Creates a new Date with the given year, month, and day.
     * Firstly, it validates the year.
     * Secondly, it validates the month.
     * Thirdly, it validates the day based on the month and year
     * (including leap year checks).
     * Finally, it assigns the values to the fields.
     *
     * @param year  the year (must be valid and not less than the minimum allowed)
     * @param month the month of the year (1 = January, 12 = December)
     * @param day   the day of the month (must match the rules for the given month and year)
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day, month, year);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Creating getter to get year.
     *
     * @return year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Creating getter to get month.
     *
     * @return month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Creating getter to get day.
     *
     * @return day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Creating method to print date in the format "YYYY-MM-DD".
     *
     * @return formatted date
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     *  Calculates the day of the week for the given date (year, month, and day).
     *  This method uses century offsets, month codes, and leap year rules
     *  to determine the correct weekday. The result is returned as a
     *  string such as "monday", "tuesday", etc.
     *  Following is the algorithm used:
     *  Step 1: calculates the number of twelves in the last two digits of the year.
     *  Step 2: calculates the remainder of step 1.
     *  Step 3: calculates the number of fours in step 2.
     *  Step 4: Add steps 1-3 and add the number of days in the month.
     *  Step 5: Add the month code. (referring to jfmamjjasond: 144025036146)
     *  Step 6: Find the remainder of the current number divided by seven.
     *  Step 7: Convert the final number to the corresponding day of the week, going
     *  from 0-6 to Saturday-Friday.
     *
     *  Additional calculations are added for:
     *  January/February during leap years, add 6 at the start.
     *  All dates in the 2000s, add 6 at the start.
     *  All dates in the 1800s, add 2 at the start.
     *
     *  @return the name of the day (Saturday, Sunday, Monday, etc.)
     */
    public String getDayOfTheWeek()
    {
        final int offset;
        final int yearPart;
        final int twelves;
        final int remainder;
        final int fours;
        final int monthCode;
        final int total;
        final int leapYearOffset;

        offset = getCenturyOffset(year);

        yearPart = year % YEARS_PER_CENTURY;
        twelves = yearPart / MONTHS_PER_YEAR;
        remainder = yearPart - (twelves * MONTHS_PER_YEAR);
        fours = remainder / YEARS_DIVISOR_4;


        if(month == JANUARY)
        {
            monthCode = JANUARY_CODE;
        }
        else if(month == FEBRUARY)
        {
            monthCode = FEBRUARY_CODE;
        }
        else if(month == MARCH)
        {
            monthCode = MARCH_CODE;
        }
        else if(month == APRIL)
        {
            monthCode = APRIL_CODE;
        }
        else if(month == MAY)
        {
            monthCode = MAY_CODE;
        }
        else if(month == JUNE)
        {
            monthCode = JUNE_CODE;
        }
        else if(month == JULY)
        {
            monthCode = JULY_CODE;
        }
        else if(month == AUGUST)
        {
            monthCode = AUGUST_CODE;
        }
        else if(month == SEPTEMBER)
        {
            monthCode = SEPTEMBER_CODE;
        }
        else if(month == OCTOBER)
        {
            monthCode = OCTOBER_CODE;
        }
        else if(month == NOVEMBER)
        {
            monthCode = NOVEMBER_CODE;
        }
        else
        {
            monthCode = DECEMBER_CODE;
        }

        if (isLeapYear(year) &&
                (month == JANUARY || month == FEBRUARY))
        {
            leapYearOffset = CENTURY_OFFSET_2000S;
        }
        else
        {
            leapYearOffset = LEAP_YEAR_DEFAULT;
        }

        total = (leapYearOffset +
                monthCode +
                offset +
                twelves +
                remainder +
                fours +
                day) % DAYS_PER_WEEK;

        if( total == SUNDAY )
        {
            return "Sunday";
        }
        else if( total == MONDAY )
        {
            return "Monday";
        }
        else if( total == TUESDAY )
        {
            return "Tuesday";
        }
        else if( total == WEDNESDAY )
        {
            return "Wednesday";
        }
        else if( total == THURSDAY )
        {
            return "Thursday";
        }
        else if( total == FRIDAY )
        {
            return "Friday";
        }
        else
        {
            return "Saturday";
        }
    }

    /* Method that returns the month name. */
    public static String getMonthName(final int inputMonth)
    {
        final String monthName;

        if (inputMonth == Date.JANUARY)
        {
            monthName = "January";
        }
        else if (inputMonth == Date.FEBRUARY)
        {
            monthName = "February";
        }
        else if (inputMonth == Date.MARCH)
        {
            monthName = "March";
        }
        else if (inputMonth == Date.APRIL)
        {
            monthName = "April";
        }
        else if (inputMonth == Date.MAY)
        {
            monthName = "May";
        }
        else if (inputMonth == Date.JUNE)
        {
            monthName = "June";
        }
        else if (inputMonth == Date.JULY)
        {
            monthName = "July";
        }
        else if (inputMonth == Date.AUGUST)
        {
            monthName = "August";
        }
        else if (inputMonth == Date.SEPTEMBER)
        {
            monthName = "September";
        }
        else if (inputMonth == Date.OCTOBER)
        {
            monthName = "October";
        }
        else if (inputMonth == Date.NOVEMBER)
        {
            monthName = "November";
        }
        else
        {
            monthName = "December";
        }

        return monthName;
    }

    /* The method that calculates the century offset. */
    private int getCenturyOffset(final int year)
    {
        if (year >= FIRST_YEAR_OF_2000S)
        {
            return CENTURY_OFFSET_2000S;
        }
        else if (year >= FIRST_YEAR_OF_1900S)
        {
            return NO_OFFSET;
        }
        else
        {
            return OFFSET_FOR_1800S; // for 1800s
        }
    }

    /* The method that checks whether the given year is a leap year. */
    private static boolean isLeapYear(final int year)
    {
        return (year % LEAP_YEAR_DIVISOR_4 == NO_OFFSET)
                && (year % LEAP_YEAR_DIVISOR_100 != NO_OFFSET)
                || (year % LEAP_YEAR_DIVISOR_400 == NO_OFFSET);
    }

    /* The method that calculates the maximum number of days in a month. */
    private static int maxDayInMonth(final int year,
                                     final int month) {
        if (month == APRIL     ||
            month == JUNE      ||
            month == SEPTEMBER ||
            month == NOVEMBER)
        {
            return MAXIMUM_DAYS_IN_APRIL;
        }
        else if (month == FEBRUARY)
        {
            return isLeapYear(year) ?
                    MAXIMUM_DAYS_IN_LEAP_YEAR :
                    MAXIMUM_DAYS_IN_NON_LEAP_YEAR;
        }
        else
        {
            return MAXIMUM_DAYS_IN_JANUARY;
        }
    }

    /* Method to validate the year. */
    private static void validateYear(final int year)
    {
        if (year < MINIMUM_YEAR ||
                year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    /* Method to validate the month. */
    private static void validateMonth(final int month)
    {
        if (month < JANUARY ||
                month > DECEMBER)
        {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    /* Method to validate the day. */
    private static void validateDay(final int day,
                                    final int month,
                                    final int year)
    {
        if (day < FIRST_DAY_OF_MONTH ||
                day > maxDayInMonth(year, month))
        {
            throw new IllegalArgumentException("Invalid day");
        }
    }
}
