package abstraction.studentSystem;

public class StudentInfoFormatter {

    public static String getFormatted(Student student) {
        return String.format("%s is %s years old. %s",
                student.getName(), student.getAge(), getCommentary(student.getGrade()));
    }

    private static String getCommentary(double grade) {
        if (grade >= 5.00) {
            return "Excellent student.";
        } else if (grade >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";
    }
}
