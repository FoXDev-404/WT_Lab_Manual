import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthenticateServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get user credentials from the login form
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		// Get cookies from the request
		Cookie[] cookies = request.getCookies();
		boolean isAuthenticated = false;

		// Check if the cookies contain valid credentials
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// If the userID matches the cookie name, check the password
				if (cookie.getName().equals(userId) && cookie.getValue().equals(password)) {
					isAuthenticated = true;
					break;
				}
			}
		}

		// Send the response based on authentication status
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		if (isAuthenticated) {
			out.println("<h1>Login Successful!</h1>");
			out.println("<p>Welcome, " + userId + "!</p>");
		} else {
			out.println("<h1>Login Failed!</h1>");
			out.println("<p>Invalid User ID or Password.</p>");
		}

		out.println("</body></html>");
	}
}
