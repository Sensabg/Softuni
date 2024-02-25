package company;

public class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    String age;

    public Employee(String name, double salary, String position, String department, String email, String age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public String getPosition() {
        return position;
    }
    public String getDepartment() {
        return department;
    }
    public String getEmail() {
        return email;
    }
    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " " + salary + " " + position + " " + department + " " + email + " " + age;
    }
}