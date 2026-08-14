import java.util.Scanner;

class StudentD {
    // Declare registrationId, name and attendancePercentage
    int registrationId;
    String name;
    double attendancePercentage;

    public class Student_registration_obj_system {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Create and populate firstStudent
            StudentD firstStudent = new StudentD();
            firstStudent.registrationId = scanner.nextInt();
            firstStudent.name = scanner.next();
            firstStudent.attendancePercentage = scanner.nextDouble();

            // Create and populate secondStudent
            StudentD secondStudent = new StudentD();
            secondStudent.registrationId = scanner.nextInt();
            secondStudent.name = scanner.next();
            secondStudent.attendancePercentage = scanner.nextDouble();

            // Read the selected ID and new attendance
            int selectedRegistrationId = scanner.nextInt();
            double newAttendancePercentage = scanner.nextDouble();

            StudentD selectedStudent = null;

            // Make selectedStudent refer to the matching existing object
            if (selectedRegistrationId == firstStudent.registrationId) {
                selectedStudent = firstStudent;
            } else if (selectedRegistrationId == secondStudent.registrationId) {
                selectedStudent = secondStudent;
            }

            // Update through selectedStudent when a match exists
            if (selectedStudent != null) {
                selectedStudent.attendancePercentage = newAttendancePercentage;

                System.out.println(firstStudent.registrationId + " " + firstStudent.name + "-"
                        + firstStudent.attendancePercentage + "%");
                System.out.println(secondStudent.registrationId + " " + secondStudent.name + "-"
                        + secondStudent.attendancePercentage + "%");
            } else {
                System.out.println("Student not found.");
                System.out.println(firstStudent.registrationId + " " + firstStudent.name + "-"
                        + firstStudent.attendancePercentage + "%");
                System.out.println(secondStudent.registrationId + " " + secondStudent.name + "-"
                        + secondStudent.attendancePercentage + "%");
            }
        }
    }
}
