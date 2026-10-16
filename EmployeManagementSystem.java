import java.util.Scanner;
import java.util.ArrayList;

public class EmployeManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employe> arr = new ArrayList<>();
        int choice = 0;
        System.out.println("===== EMPLOYEE MANAGEMENT SYSTEM =====");

        while (choice != 6) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("Enter Your Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 2:
                    if (arr.isEmpty()) {
                        System.out.println("No employees found!");
                    } else {
                        for (Employe e : arr) {
                            e.displayDetails();
                        }
                    }
                    break;

                case 1:
                    System.out.println("Enter the id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter employee name");
                    String name = sc.nextLine();
                    System.out.println("Enter department");
                    String department = sc.nextLine();
                    System.out.println("Enter salary");
                    double salary = sc.nextDouble();

                    Employe emp = new Employe(id, name, department, salary);
                    arr.add(emp);

                    System.out.println("Employee added successfully!");
                    break;

                case 3:
                    System.out.println("Enter employee ID to search:");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Employe e : arr) {
                        if (e.getId() == searchId) {
                            e.displayDetails();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter employee ID to update:");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Employe e : arr) {
                        if (e.getId() == updateId) {
                            sc.nextLine();

                            System.out.println("Enter new name:");
                            String newName = sc.nextLine();

                            System.out.println("Enter new department:");
                            String newDepartment = sc.nextLine();

                            System.out.println("Enter new salary:");
                            double newSalary = sc.nextDouble();

                            e.setName(newName);
                            e.setDepartment(newDepartment);
                            e.setSalary(newSalary);

                            System.out.println("Employee updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 5:
                    System.out.println("Enter employee ID to delete:");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < arr.size(); i++) {
                        if (arr.get(i).getId() == deleteId) {
                            arr.remove(i);
                            System.out.println("Employee deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Employee Management System...");
                    break;

            }

        }

    }
}
