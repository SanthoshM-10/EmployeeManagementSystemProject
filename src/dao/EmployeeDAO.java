package dao;

import java.sql.*;
import model.Employee;
import util.DBConnection;

public class EmployeeDAO {

    public void addEmployee(Employee e) {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getEmpId());
            ps.setString(2, e.getEmpName());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());
            ps.setString(5, e.getEmail());

            ps.executeUpdate();
            System.out.println("Employee Added Successfully");

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void viewEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nID\tName\tDepartment\tSalary\tEmail");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + "\t" +
                    rs.getString("emp_name") + "\t" +
                    rs.getString("department") + "\t" +
                    rs.getDouble("salary") + "\t" +
                    rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateEmployee(int empId, double salary) {

        String sql = "UPDATE employees SET salary = ? WHERE emp_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee salary updated successfully");
            } else {
                System.out.println("Employee ID not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEmployee(int empId) {

        String sql = "DELETE FROM employees WHERE emp_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Employee ID not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void searchEmployee(int empId) {

        String sql = "SELECT * FROM employees WHERE emp_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + " | " +
                    rs.getString("emp_name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary") + " | " +
                    rs.getString("email")
                );
            } else {
                System.out.println("Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
