package webHelloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WebHello")
public class WebHello extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public WebHello() {
        super();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Web Services Lab 1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World, so cool to develop Web Services</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
