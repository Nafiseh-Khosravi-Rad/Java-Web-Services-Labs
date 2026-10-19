package webBilling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/webBilling")
public class WebBillingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public WebBillingServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		Billing[] BillingRecords = new Billing[3];

		for (int i = 0; i < BillingRecords.length; i++) {
			BillingRecords[i] = new Billing();
		}

		BillingRecords[0].setClient_LName("Johnston");
		BillingRecords[0].setClient_FName("Jane");
		BillingRecords[0].setproduct_Name("Chair");
		BillingRecords[0].setPrd_Price(99.99);
		BillingRecords[0].setPrd_Qty(2);

		BillingRecords[1].setClient_LName("Fikhali");
		BillingRecords[1].setClient_FName("Samuel");
		BillingRecords[1].setproduct_Name("Table");
		BillingRecords[1].setPrd_Price(139.99);
		BillingRecords[1].setPrd_Qty(1);

		BillingRecords[2].setClient_LName("Samson");
		BillingRecords[2].setClient_FName("Amina");
		BillingRecords[2].setproduct_Name("KeyUSB");
		BillingRecords[2].setPrd_Price(14.99);
		BillingRecords[2].setPrd_Qty(2);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Billing Data</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>client_LName</th>");
		out.println("<th>client_FName</th>");
		out.println("<th>product_Name</th>");
		out.println("<th>prd_Price</th>");
		out.println("<th>prd_Qty</th>");
		out.println("<th>Total Billing</th>");
		out.println("</tr>");

		double totalBilling = 0.0;

		for (Billing record : BillingRecords) {
			double billingAmount = record.CalculateBilling();
			totalBilling += billingAmount;

			out.printf(Locale.US,
					"<tr>" + "<td>%s</td>" + "<td>%s</td>" + "<td>%s</td>" + "<td>%.2f$</td>" + "<td>%d</td>"
							+ "<td>%.2f$</td>" + "</tr>%n",
					record.getClient_LName(), record.getClient_FName(), record.getproduct_Name(), record.getPrd_Price(),
					record.getPrd_Qty(), billingAmount);
		}

		out.println("</table>");

		out.printf(Locale.US, "<h2>The Total of Billing is: %.2f$</h2>", totalBilling);

		out.println("</body>");
		out.println("</html>");
	}
}