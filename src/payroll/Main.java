package payroll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.setEmployees(FileUtil.loadEmployeesFromFile());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Payroll System ---");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume invalid token
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Monthly Salary: ");
                double salary = scanner.nextDouble();
                payrollSystem.addEmployee(new FullTimeEmployee(name, id, salary));
                System.out.println("Full-Time Employee added.");
            } else if (choice == 2) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Hours Worked: ");
                int hours = scanner.nextInt();
                System.out.print("Enter Hourly Rate: ");
                double rate = scanner.nextDouble();
                payrollSystem.addEmployee(new PartTimeEmployee(name, id, hours, rate));
                System.out.println("Part-Time Employee added.");
            } else if (choice == 3) {
                System.out.print("Enter ID of employee to remove: ");
                int id = scanner.nextInt();
                payrollSystem.removeEmployee(id);
                System.out.println("Employee removed if ID existed.");
            } else if (choice == 4) {
                System.out.println("\nEmployee Details:");
                payrollSystem.displayEmployees();
            } else if (choice == 5) {
                FileUtil.saveEmployeesToFile(payrollSystem.getEmployees());
                System.out.println("Exiting the system.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
