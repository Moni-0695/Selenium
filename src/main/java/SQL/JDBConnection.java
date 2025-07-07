package SQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class JDBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "Root"; // Change this to your actual password

        try {
            // Step 1: Connect to MySQL
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Database connected successfully!");

            Statement stmt = ((java.sql.Connection) con).createStatement();

            // Step 2: Create database and use it
            stmt.execute("CREATE DATABASE IF NOT EXISTS company");
            stmt.execute("USE company");

            // Step 3: Create employee_data table
            String createTable = "CREATE TABLE IF NOT EXISTS employee_data (" +
                    "empcode INT, empname VARCHAR(50), empage INT, esalary INT)";
            stmt.execute(createTable);

            // Step 4: Insert employee records
            String insertData = "INSERT INTO employee_data VALUES " +
                    "(101, 'Jenny', 25, 10000)," +
                    "(102, 'Jacky', 30, 20000)," +
                    "(103, 'Joe', 20, 40000)," +
                    "(104, 'John', 40, 80000)," +
                    "(105, 'Shameer', 25, 90000)";
            stmt.executeUpdate(insertData);

            System.out.println("Records inserted successfully!");

            // Step 5: View the inserted records (optional)
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee_data");
            System.out.println("\n Employee Table Data:");
            System.out.println("EmpCode | Name    | Age | Salary");
            System.out.println("----------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("empcode") + "      | " +
                        rs.getString("empname") + "  | " +
                        rs.getInt("empage") + "  | " +
                        rs.getInt("esalary"));
            }

            // Close connection
            con.close();
            System.out.println("\n Database connection closed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
