package webCourse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/WebCourse")
public class WebCourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public WebCourseServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		Course[] CourseRecords = new Course[7];

		for (int i = 0; i < CourseRecords.length; i++) {
			CourseRecords[i] = new Course();
		}

		CourseRecords[0].setCourse_no("MIS 101");
		CourseRecords[0].setCourse_name("Intro. to Info. Systems");
		CourseRecords[0].setMax_enrl(140);

		CourseRecords[1].setCourse_no("MIS 301");
		CourseRecords[1].setCourse_name("Systems Analysis");
		CourseRecords[1].setMax_enrl(35);

		CourseRecords[2].setCourse_no("MIS 441");
		CourseRecords[2].setCourse_name("Database Management");
		CourseRecords[2].setMax_enrl(12);

		CourseRecords[3].setCourse_no("CS 155");
		CourseRecords[3].setCourse_name("Programming in C++");
		CourseRecords[3].setMax_enrl(90);

		CourseRecords[4].setCourse_no("MIS 451");
		CourseRecords[4].setCourse_name("Web-Based Systems");
		CourseRecords[4].setMax_enrl(30);

		CourseRecords[5].setCourse_no("MIS 551");
		CourseRecords[5].setCourse_name("Advanced Web");
		CourseRecords[5].setMax_enrl(30);

		CourseRecords[6].setCourse_no("MIS 651");
		CourseRecords[6].setCourse_name("Advanced Java");
		CourseRecords[6].setMax_enrl(30);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Course Data</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Course Number</th>");
		out.println("<th>Course Name</th>");
		out.println("<th>Max Enrolment</th>");
		out.println("<th>Credits</th>");
		out.println("<th>Total Course Fees</th>");
		out.println("</tr>");

		double totalCourseFees = 0.0;

		for (Course record : CourseRecords) {
			double courseFees = record.CalculateTotalFees();
			totalCourseFees += courseFees;

			out.printf(Locale.US,
					"<tr>" + "<td>%s</td>" + "<td>%s</td>" + "<td>%d</td>" + "<td>%d</td>" + "<td>%.2f$</td>"
							+ "</tr>%n",
					record.getCourse_no(), record.getCourse_name(), record.getMax_enrl(), Course.credits, courseFees);
		}

		out.println("</table>");

		out.printf(Locale.US, "<h2>The Total of Course Fees is: %.2f$</h2>", totalCourseFees);

		out.println("</body>");
		out.println("</html>");
	}
}