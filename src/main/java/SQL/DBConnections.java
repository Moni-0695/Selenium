package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "Root"; // Change this if your MySQL password is different

        try {
        	
        	
            // Step 1: Connect to MySQL
            Connection con1 = DriverManager.getConnection(url, user, pass);
            Statement stmt1 = con1.createStatement();
            System.out.println("Database connected successfully!");

            // Step 2: Create database and table
            stmt1.execute("CREATE DATABASE IF NOT EXISTS emp_details");
            stmt1.execute("USE emp_details");
            stmt1.execute("DROP TABLE IF EXISTS Empl");

            String createTable = "Create Table Empl (" +
                    "empno INT, ename VARCHAR(50), job VARCHAR(50), mgr INT, " +
                    "hiredate DATE, sal DECIMAL(10,2), comm DECIMAL(10,2), deptno INT)";
            stmt1.execute(createTable);

            // Step 3: Insert sample employee records
            String insertData = "INSERT INTO Empl VALUES " +
                    "(8369, 'SMITH', 'CLERK', 8902, '1990-12-18', 800.00, NULL, 20)," +
                    "(8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00, 30)," +
                    "(8521, 'SETH', 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00, 30)," +
                    "(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02', 2985.00, NULL, 20)," +
                    "(8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30)," +
                    "(8698, 'BINA', 'MANAGER', 8839, '1991-05-01', 2850.00, NULL, 20)," +
                    "(8882, 'SHIVHANSH', 'MANAGER', 8839, '1991-06-09', 2450.00, NULL, 30)," +
                    "(8888, 'SCOTT', 'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20)," +
                    "(8890, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10)," +
                    "(8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30)";
            stmt1.executeUpdate(insertData);

            // ---------------------------------------
            // Query A: Salary ≥ 2200
            System.out.println("\nA. Employees with salary >= 2200:");
            ResultSet rsA = stmt1.executeQuery("SELECT ename, sal FROM Empl WHERE sal >= 2200");
            while (rsA.next()) {
                System.out.println(rsA.getString("ename") + " | " + rsA.getDouble("sal"));
            }

            // Query B: No commission
            System.out.println("\nB. Employees with no commission:");
            ResultSet rsB = stmt1.executeQuery("SELECT empno, ename, job, sal FROM Empl WHERE comm IS NULL OR comm = 0");
            while (rsB.next()) {
                System.out.println(rsB.getInt("empno") + " | " + rsB.getString("ename") +
                        " | " + rsB.getString("job") + " | " + rsB.getDouble("sal"));
            }

            // Query C: Salary not between 2500 and 4000
            System.out.println("\nC. Salary NOT between 2500 and 4000:");
            ResultSet rsC = stmt1.executeQuery("SELECT ename, sal FROM Empl WHERE sal < 2500 OR sal > 4000");
            while (rsC.next()) {
                System.out.println(rsC.getString("ename") + " | " + rsC.getDouble("sal"));
            }

            // Query D: Employees without a manager
            System.out.println("\nD. Employees without a manager:");
            ResultSet rsD = stmt1.executeQuery("SELECT ename, job, sal FROM Empl WHERE mgr IS NULL");
            while (rsD.next()) {
                System.out.println(rsD.getString("ename") + " | " + rsD.getString("job") +
                        " | " + rsD.getDouble("sal"));
            }

            // Query E: Names with 3rd letter 'A'
            System.out.println("\nE. Employees with 3rd letter 'A':");
            ResultSet rsE = stmt1.executeQuery("SELECT ename FROM Empl WHERE ename LIKE '__A%'");
            while (rsE.next()) {
                System.out.println(rsE.getString("ename"));
            }

            // Query F: Names ending with 'T'
            System.out.println("\nF. Employees whose name ends with 'T':");
            ResultSet rsF = stmt1.executeQuery("SELECT ename FROM Empl WHERE ename LIKE '%T'");
            while (rsF.next()) {
                System.out.println(rsF.getString("ename"));
            }

            // Close connection
            con1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
