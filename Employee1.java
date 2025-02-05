import java.util.*;
import java.util.stream.Collectors;

class Employee1 {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee1(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class Employee1StreamDemo {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee1> employees = Arrays.asList(
            new Employee1("Alice", 28, 50000),
            new Employee1("Bob", 35, 70000),
            new Employee1("Charlie", 32, 65000),
            new Employee1("Diana", 26, 48000),
            new Employee1("Edward", 45, 90000)
        );

        // Filter employees older than 30.
        List<Employee1> filteredEmployee1s = employees.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());

        // Find the average salary of employees who are older than 30.
        OptionalDouble averageSalary = filteredEmployee1s.stream()
                .mapToDouble(Employee1::getSalary)
                .average();

        // Collect the names of these employees into a List.
        List<String> employeeNames = filteredEmployee1s.stream()
                .map(Employee1::getName)
                .collect(Collectors.toList());

        // Print the list of employee names.
        System.out.println("Employee1s older than 30: " + employeeNames);

        // Print the average salary if present; otherwise, print a default message.
        if (averageSalary.isPresent()) {
            System.out.println("Average salary: " + averageSalary.getAsDouble());
        } else {
            System.out.println("No employees older than 30 found.");
        }
    }
}
