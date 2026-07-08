
/*
        PreparedStatement - you write the SQL once with placeholders (?)
        Advantages
        Protects against SQL injection.
        Easier to work with variables.
        Often faster when executing the same SQL many times.
        Automatic type handling (setInt, setString, setDouble, etc.).
        PreparedStatement prevents SQL injection because parameter values are bound separately from
        the SQL statement. User input is treated as data rather than executable SQL code,
        so malicious input cannot change the structure or logic of the query.
 */
//A CallableStatement is a specialized interface in the JDBC API used explicitly to execute stored procedures and functions defined within a database.
import java.sql.*;

public class EmployeeDatabaseDemo {

    private static final String URL
            = "jdbc:mysql://localhost:3306/georgian_college";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        try (Connection conn
                = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connected to database.");

            insertEmployee(conn);

            System.out.println("\nEmployees after insertion:");
            displayEmployees(conn);

            updateSalary(conn, "E1001", 75000);

            System.out.println("\nEmployees after update:");
            displayEmployees(conn);

            deleteEmployee(conn, "E1001");

            System.out.println("\nEmployees after deletion:");
            displayEmployees(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT
    public static void insertEmployee(Connection conn)
            throws SQLException {

        String sql = """
                INSERT INTO employee_information
                (employee_id, employee_name, employee_email,
                 hire_date, years_in_job, annual_salary, employee_type)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "E1001");
            stmt.setString(2, "John Smith");
            stmt.setString(3, "john.smith@georgiancollege.ca");
            stmt.setDate(4, Date.valueOf("2022-09-01"));
            stmt.setInt(5, 4);
            stmt.setDouble(6, 70000);
            stmt.setString(7, "Faculty");

            int rows = stmt.executeUpdate();

            System.out.println(rows + " employee inserted.");
        }
    }

    // SELECT
    public static void displayEmployees(Connection conn)
            throws SQLException {

        String sql = "SELECT * FROM employee_information";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        rs.getString("employee_id") + "\t"
                        + rs.getString("employee_name") + "\t"
                        + rs.getString("employee_email") + "\t"
                        + rs.getDate("hire_date") + "\t"
                        + rs.getInt("years_in_job") + "\t"
                        + rs.getDouble("annual_salary") + "\t"
                        + rs.getString("employee_type")
                );
            }
        }
    }

    // UPDATE
    public static void updateSalary(Connection conn,
            String employeeId,
            double newSalary)
            throws SQLException {

        String sql = """
                UPDATE employee_information
                SET annual_salary = ?
                WHERE employee_id = ?
                """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newSalary);
            stmt.setString(2, employeeId);

            int rows = stmt.executeUpdate();

            System.out.println(rows + " employee updated.");
        }
    }

    // DELETE
    public static void deleteEmployee(Connection conn,
            String employeeId)
            throws SQLException {

        String sql
                = "DELETE FROM employee_information WHERE employee_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employeeId);

            int rows = stmt.executeUpdate();

            System.out.println(rows + " employee deleted.");
        }
    }
}
