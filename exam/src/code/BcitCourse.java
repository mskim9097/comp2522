import java.awt.color.ICC_ColorSpace;

public class BcitCourse
{
    private static final int MINIMUM_COURSE_NUMBER = 0;
    private static final int MAXIMUM_COURSE_NUMBER = 9999;

    private final int courseNumber;
    private final String department;

    public BcitCourse(final int courseNumber,
                 final String department)
    {
        validateCourseNumber(courseNumber);
        validateDepartment(department);

        this.courseNumber = courseNumber;
        this.department = department;
    }

    public int getCourseNumber()
    {
        return courseNumber;
    }

    public String getDepartment()
    {
        return department;
    }

    private static void validateCourseNumber(final int courseNumber)
    {
        if(courseNumber < MINIMUM_COURSE_NUMBER ||
           courseNumber > MAXIMUM_COURSE_NUMBER)
        {
            throw new IllegalArgumentException(
                    "Invalid course number."
            );
        }
    }

    private static void validateDepartment(final String department)
    {
        if(department == null || department.isBlank())
        {
            throw new IllegalArgumentException("Invalid Department name.");
        }
    }

    public static void main(final String[] args)
    {
        final BcitCourse c1;
        final BcitCourse c2;

        c1 = new BcitCourse(100, "OOP");
        c2 = new BcitCourse(100, "CS");
    }

}
