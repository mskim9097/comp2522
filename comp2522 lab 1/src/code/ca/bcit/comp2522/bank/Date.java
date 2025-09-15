package ca.bcit.comp2522.bank;

/**
 * Represents a calendar date with utilities for validation and calculations.
 * Firstly, it defines constants for years, such as the first year of the 1900s,
 * the first year of the 2000s, and the current year.
 * Secondly, it defines constants for the number of days in months,
 * including leap year and non-leap year variations.
 * Thirdly, it stores useful divisors (like 4, 100, and 400) to check
 * leap years.
 * Fourthly, it defines constants for months (e.g., January, February, etc.)
 * and for common numeric values (0, 1, 2, 4, 6, 7, 12, 100).
 * Finally, it provides month codes used for calculating the day of the week.
 *
 * @author Minsu
 * @author Hali
 * @author Esin
 * @version 1.0
 */
public class Date
{

    private static final int FIRST_YEAR_OF_1900S = 1900;
    private static final int FIRST_YEAR_OF_2000S = 2000;
    private static final int CURRENT_YEAR = 2025;

    private static final int MAX_DAYS_IN_LEAP_YEAR = 29;
    private static final int MAX_DAYS_IN_NON_LEAP_YEAR = 28;
    private static final int MAX_DAYS_IN_JANUARY = 31;
    private static final int MAX_DAYS_IN_APRIL = 30;
    private static final int DIV_400 = 400;
    private static final int DIV_100 = 100;
    private static final int DIV_4   = 4;

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int FOUR = 4;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int TWELVE = 12;
    private static final int HUNDRED = 100;

    private static final int MIN_YEAR = 1800;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int[] MONTH_CODES =
            {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

    /**
     * Array of month names from January to December.
     * Can be used to display the month's name based on its number.
     */
    public static final String[] MONTH_NAMES =
            {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};

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
     * /**
     *  Calculates the day of the week for the given date (year, month, and day).
     *  This method uses century offsets, month codes, and leap year rules
     *  to determine the correct weekday. The result is returned as a
     *  string such as "monday", "tuesday", etc.
     *
     *  @return the name of the day (Saturday, Sunday, Monday, etc.)
     */
    public String getDayOfTheWeek()
    {
        String[] weekdays =
                {"saturday",
                "sunday",
                "monday",
                "tuesday",
                "wednesday",
                "thursday",
                "friday"};

        int offset = getCenturyOffset(year);
        int yearPart = year % HUNDRED;

        int twelves = yearPart/TWELVE;
        int remainder = yearPart - (twelves * TWELVE);
        int fours = remainder / FOUR;

        int total =  MONTH_CODES[month - ONE]
                + offset
                + twelves
                + remainder
                + fours
                + day;

        if (isLeapYear(year) &&
                (month == JANUARY || month == FEBRUARY))
        {
            total += SIX;
        }
        return weekdays[total % SEVEN];
    }

    private int getCenturyOffset(final int year)
    {
        if (year >= FIRST_YEAR_OF_2000S) {
            return SIX;
        } else if (year >= FIRST_YEAR_OF_1900S){
            return ZERO;
        } else {
            return TWO; // for 1800s
        }
    }

    private static boolean isLeapYear(final int year)
    {
        return (year % DIV_4 == ZERO)
                && (year % DIV_100 != ZERO)
                || (year % DIV_400 == ZERO);
    }

    private static int maxDayInMonth(final int year,
                                     final int month)
    {
        return switch (month) {
            case APRIL,
                 JUNE,
                 SEPTEMBER,
                 NOVEMBER
                    -> MAX_DAYS_IN_APRIL;
            case FEBRUARY
                    -> isLeapYear(year)
                    ? MAX_DAYS_IN_LEAP_YEAR
                    : MAX_DAYS_IN_NON_LEAP_YEAR;
            default -> MAX_DAYS_IN_JANUARY;
        };
    }

    private static void validateYear(final int year)
    {
        if (year < MIN_YEAR
            || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    private static void validateMonth(final int month)
    {
        if (month < JANUARY
            || month > DECEMBER)
        {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    private static void validateDay(final int day,
                                    final int month,
                                    final int year)
    {
        if (day < ONE
            || day > maxDayInMonth(year, month))
        {
            throw new IllegalArgumentException("Invalid day");
        }
    }
}
