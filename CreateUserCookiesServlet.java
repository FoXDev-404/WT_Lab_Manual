import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CreateUserCookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create cookies for each user

        Cookie user1 = new Cookie("user1", "pwd1");
        Cookie user2 = new Cookie("user2", "pwd2");
        Cookie user3 = new Cookie("user3", "pwd3");
        Cookie user4 = new Cookie("user4", "pwd4");

        // Set cookie expiration time to 1 hour user1.setMaxAge(60 * 60);
        user2.setMaxAge(60 * 60);
        user3.setMaxAge(60 * 60);
        user4.setMaxAge(60 * 60);

        // Add cookies to the response response.addCookie(user1);
        // response.addCookie(user2); response.addCookie(user3);
        // response.addCookie(user4);

        // Inform the user out.println("<html><body>");
        out.println("<h1>Cookies Created Successfully!</h1>");
        out.println("<p>User credentials are now stored as cookies.</p>");
        out.println("<a href='login.html'>Go to Login Page</a>");
        out.println("</body></html>");
    }
}