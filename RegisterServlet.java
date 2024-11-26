import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name"; // Change to your DB URL
    private static final String DB_USER = "root"; // Change to your DB username
    private static final String DB_PASSWORD = "root"; // Change to your DB password

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user data from form
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Establish a connection to the database
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the database driver (optional with modern JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL query to insert data into the table
            String sql = "INSERT INTO users (name, password, email, phone_number) VALUES (?, ?, ?, ?)";

            // Create prepared statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();

            // Redirect based on successful registration
            if (rowsAffected > 0) {
                response.sendRedirect("success.html"); // Redirect to success page
            } else {
                response.sendRedirect("failure.html"); // Redirect to failure page
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html"); // Redirect to error page
        } finally {
            // Close resources
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}