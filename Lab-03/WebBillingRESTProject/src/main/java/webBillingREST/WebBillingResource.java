package webBillingREST;

import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;

@Path("/WebBilling")
public class WebBillingResource {

    private ArrayList<Billing> createBillingList() {

        ArrayList<Billing> BillingList = new ArrayList<>();

        BillingList.add(new Billing(1, "Smith", "John",
                "Laptop", 1200, 1));

        BillingList.add(new Billing(2, "Brown", "Anna",
                "Printer", 300, 2));

        BillingList.add(new Billing(3, "Wilson", "Mark",
                "Monitor", 250, 3));

        return BillingList;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String displayHTMLBillingInfo() {

        ArrayList<Billing> BillingList = createBillingList();

        String output = "<html><body>";
        output += "<h2>Billing List</h2>";

        output += "<table border='1'>";
        output += "<tr>"
                + "<th>Client ID</th>"
                + "<th>Last Name</th>"
                + "<th>First Name</th>"
                + "<th>Product</th>"
                + "<th>Price</th>"
                + "<th>Quantity</th>"
                + "<th>Total Billing</th>"
                + "</tr>";

        for (Billing bill : BillingList) {
            output += "<tr>"
                    + "<td>" + bill.getClient_ID() + "</td>"
                    + "<td>" + bill.getClient_LName() + "</td>"
                    + "<td>" + bill.getClient_FName() + "</td>"
                    + "<td>" + bill.getProduct_Name() + "</td>"
                    + "<td>" + bill.getPrd_Price() + "</td>"
                    + "<td>" + bill.getPrd_Qty() + "</td>"
                    + "<td>" + bill.CalculateBilling() + "</td>"
                    + "</tr>";
        }

        output += "</table>";
        output += "</body></html>";

        return output;
    }
    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String displayTextBillingInfo() {

        ArrayList<Billing> BillingList = createBillingList();

        String output = "";

        for (Billing bill : BillingList) {
            output += "Client ID: " + bill.getClient_ID()
                    + ", Last Name: " + bill.getClient_LName()
                    + ", First Name: " + bill.getClient_FName()
                    + ", Product: " + bill.getProduct_Name()
                    + ", Price: " + bill.getPrd_Price()
                    + ", Quantity: " + bill.getPrd_Qty()
                    + ", Total Billing: " + bill.CalculateBilling()
                    + "\n";
        }

        return output;
    }
    @GET
    @Path("/searchBilling/{client_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing searchJSONBillingInfo(@PathParam("client_id") int clientId) {

        ArrayList<Billing> BillingList = createBillingList();

        for (Billing bill : BillingList) {
            if (bill.getClient_ID() == clientId) {
                return bill;
            }
        }

        return null;
    }
}