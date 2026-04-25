package main;

import java.util.Scanner;
import model.Employee;
import dao.EmployeeDAO;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    // Basic validation
                    if (id <= 0 || salary <= 0 || !email.contains("@")) {
                        System.out.println("Invalid input! Please try again.");
                        break;
                    }

                    Employee e = new Employee(id, name, dept, salary, email);
                    dao.addEmployee(e);
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new Salary: ");
                    double sal = sc.nextDouble();

                    if (sal <= 0) {
                        System.out.println("Salary must be greater than 0");
                        break;
                    }

                    dao.updateEmployee(uid, sal);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;

                case 5:
                    System.out.print("Enter Employee ID to search: ");
                    int sid = sc.nextInt();
                    dao.searchEmployee(sid);
                    break;

                case 6:
                    System.out.println("Thank you! Exiting application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please select 1–6.");
            }
        }
    }
}
