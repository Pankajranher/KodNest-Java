import java.util.Scanner;

class Person {
    Person(String name) {
        // Print Person and name
        System.out.println("Person " + name);

    }
}

class Employee extends Person {
    Employee(String name) {
        // Call Person
        super(name);
        // Print Employee
        System.out.println("Employee");
    }
}

class Developer extends Employee {
    Developer(String name) {
        // Call Employee
        super(name);
        // Print Developer
        System.out.println("Developer");

    }
}

public class Build_a_simple_multilevel_hierarchy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read name and create Developer
        String name = scanner.next();
        Developer d = new Developer(name);
    }
}