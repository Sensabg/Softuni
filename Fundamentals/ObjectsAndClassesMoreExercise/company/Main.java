package ObjectsAndClassesMoreExercise.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            Employee newEmployee = getEmployee(inputData, name, salary);
            employeeList.add(newEmployee);
        }
        String highestSalaryDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Highest Average Salary: " + highestSalaryDepartment);

        employeeList.stream()
                .filter(employee -> employee.getDepartment().equals(highestSalaryDepartment))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(employee ->
                        System.out.printf("%s %.2f %s %s\n",
                                employee.getName(), employee.getSalary(),
                                employee.getEmail(), employee.getAge()));
    }
    private static Employee getEmployee(String[] inputData, String name, double salary) {
        String position = inputData[2];
        String department = inputData[3];
        String email = "n/a";
        String age = "-1";

        if (inputData.length == 5) {
            if (!inputData[4].contains("@")) {
                age = inputData[4];
            } else {
                email = inputData[4];
            }
        } else if (inputData.length == 6) {
            if (!inputData[4].contains("@")) {
                age = inputData[4];
                email = inputData[5];
            } else {
                age = inputData[5];
                email = inputData[4];
            }
        }
        return new Employee(name, salary, position, department, email, age);
    }
}
