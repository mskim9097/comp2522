class Student
{
    private final String studentId;

    Student(final String studentId)
    {
        validateStudentId(studentId);
        this.studentId = studentId;
    }

    private static void validateStudentId(final String studentId)
    {
        if(studentId == null || studentId.length() != 9)
        {
            throw new IllegalArgumentException("bad id");
        }
    }
}
