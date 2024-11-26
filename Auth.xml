<%@ page import="java.sql.*" %>
<%
// Get the username and password entered by the user String username

// Database connection parameters
String dbUrl = "jdbc:mysql://localhost:3306/your_database"; String dbUser = "root"; 

Connection conn = null; PreparedStatement stmt = null; ResultSet rs = null;
String selectSQL = "SELECT * FROM users WHERE username = ? AND password = ?"; try {

// Load the MySQL JDBC driver Class.forName("com.mysql.cj.jdbc.Driver");

// Establish connection
conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

// Prepare and execute the SQL statement stmt = conn.prepareStatement(selectSQL);
rs = stmt.executeQuery(); if (rs.next()) {
out.println("<h2>Login successful! Welcome, " + rs.getString("name") + ".</h2>");
// You can set session attributes or redirect to a logged-in page
} else {
out.println("<h2>Invalid username or password.</h2>");
}
} catch (Exception e) {
out.println("<h2>Error: " + e.getMessage() + "</h2>"); e.printStackTrace();
} finally { try {
if (rs != null) rs.close();
if (stmt != null) stmt.close(); if (conn != null) conn.close();
} catch (SQLException e) { e.printStackTrace();
}
}
%>