public class Employee {
    String name;
    String dept;
    static String company = "niit";

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public static void main(String[] args) {
        Employee em1 = new Employee("uche", "accounting");

    }
}
