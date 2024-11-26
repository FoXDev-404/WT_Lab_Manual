import java.sql.*;

public class BookQueryJDBC {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:odbc:BookDSN"; // ODBC Data Source Name
        String query = "SELECT * FROM Books";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load JDBC ODBC Driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Establish a connection
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the database.");

            // Create a statement
            stmt = conn.createStatement();

            // Execute the query
            rs = stmt.executeQuery(query);

            // Process the result
            System.out.println("Book Details:");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                double price = rs.getDouble("Price");

                System.out.printf("ID: %d, Title: %s, Author: %s, Price: %.2f\n", id, title, author, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close connections
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}