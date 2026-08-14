import java.util.Scanner;

class StudentB {
    // Declare id, name and javaScore
    int id;
    String name;
    int javaScore;
}

class Create_and_compare_two_objects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create and populate the first Student object
        StudentB firstStudent = new StudentB();
        firstStudent.id = scanner.nextInt();
        firstStudent.name = scanner.next();
        firstStudent.javaScore = scanner.nextInt();

        // Create and populate the second Student object
        StudentB secondStudent = new StudentB();
        secondStudent.id = scanner.nextInt();
        secondStudent.name = scanner.next();
        secondStudent.javaScore = scanner.nextInt();

        // Display both records
        System.out.println(firstStudent.id + " - " + firstStudent.name + " - " + firstStudent.javaScore);
        System.out.println(secondStudent.id + " - " + secondStudent.name + " - " + secondStudent.javaScore);

        // Compare both scores and print one result
        if (firstStudent.javaScore > secondStudent.javaScore) {
            System.out.println(firstStudent.name + " has the higher Java score.");
        } else if (firstStudent.javaScore < secondStudent.javaScore) {
            System.out.println(secondStudent.name + " has the higher Java score.");
        } else {
            System.out.println("Both students have the same Java score.");
        }
        scanner.close();
    }
}
