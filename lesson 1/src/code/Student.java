public class Student {

    private final String studentId;

    Student(final String studentID) {
        this.studentId = studentID;
    }

    private static void validateStudentId(final String studentId) {
        if (studentId == null || studentId.length() != 9) {
            throw new IllegalArgumentException("bad id");
        }
    }

}
