package payroll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "employees.csv";

    public static void saveEmployeesToFile(List<Employee> employees) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee employee : employees) {
                if (employee instanceof FullTimeEmployee) {
                    FullTimeEmployee ft = (FullTimeEmployee) employee;
                    writer.println("FullTime," + ft.getId() + "," + ft.getName() + "," + ft.getMonthlySalary());
                } else if (employee instanceof PartTimeEmployee) {
                    PartTimeEmployee pt = (PartTimeEmployee) employee;
                    writer.println("PartTime," + pt.getId() + "," + pt.getName() + "," + pt.getHoursWorked() + "," + pt.getHourlyRate());
                }
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployeesFromFile() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return employees;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String type = parts[0];
                    if ("FullTime".equals(type) && parts.length == 4) {
                        int id = Integer.parseInt(parts[1]);
                        String name = parts[2];
                        double salary = Double.parseDouble(parts[3]);
                        employees.add(new FullTimeEmployee(name, id, salary));
                    } else if ("PartTime".equals(type) && parts.length == 5) {
                        int id = Integer.parseInt(parts[1]);
                        String name = parts[2];
                        int hours = Integer.parseInt(parts[3]);
                        double rate = Double.parseDouble(parts[4]);
                        employees.add(new PartTimeEmployee(name, id, hours, rate));
                    }
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
        }
        return employees;
    }
}
