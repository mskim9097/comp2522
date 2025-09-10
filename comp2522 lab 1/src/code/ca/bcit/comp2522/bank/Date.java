package ca.bcit.comp2522.bank;

public class Date {

    private static final int FIRST_YEAR_OF_1800S = 1800;
    private static final int LAST_YEAR_OF_1800S = 1899;
    private static final int FIRST_YEAR_OF_1900S = 1900;
    private static final int LAST_YEAR_OF_1999S = 1999;
    private static final int FIRST_YEAR_OF_2000S = 2000;
    private static final int CURRENT_YEAR = 2025;
    private static final int TEN = 10;
    private static final int HUNDRED = 100;

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private static final int NUMBER_OF_MONTHS = 12;
    private static final int MIN_YEAR = 1800;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private final int year;
    private final int month;
    private final int day;

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

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public String getYyyyMmDd()
    {
        String m = (month < TEN) ? "0" + month : "" + month;
        String d = (day < TEN) ? "0" + day : "" + day;
        return year + "-" + m + "-" + d;
    }

    public int getDayOfTheWeek()
    {
        final int zero = 0;
        final int two = 2;
        final int four = 4;
        final int six = 6;
        final int twelve = 12;

        int yy = year % HUNDRED;
        int result = zero;

        if (year >= FIRST_YEAR_OF_1800S
                && year <= LAST_YEAR_OF_1800S)
        {
            result += two;
        } else if (year <= CURRENT_YEAR
                && year >= FIRST_YEAR_OF_2000S)
        {
            result += six;
        }

        if (isLeapYear(year)
                && (month == FEBRUARY || month == JANUARY))
        {
            result += six;
        }

        int twelvesInYy = yy / twelve;
        int remainder = yy % four;
        int foursInRemainder = remainder / four;

        result += day + twelvesInYy + remainder + foursInRemainder;

        int[] monthCodes = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
        result += monthCodes[month - 1];

        return result % 7;
    }

    private static boolean isLeapYear(final int year)
    {
        return (year % 4 == 0)
                && (year % 100 != 0)
                || (year % 400 == 0);
    }

    private static int maxDayInMonth(final int year,
                                     final int month)
    {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
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
        if (month < 1
            || month > 12)
        {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    private static void validateDay(final int day,
                                    final int month,
                                    final int year)
    {
        if (day < 1
            || day > maxDayInMonth(year, month))
        {
            throw new IllegalArgumentException("Invalid day");
        }
    }
}
