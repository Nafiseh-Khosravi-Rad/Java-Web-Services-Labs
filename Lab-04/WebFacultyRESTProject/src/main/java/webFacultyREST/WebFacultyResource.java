package webFacultyREST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

@Path("/WebFaculty")
public class WebFacultyResource {

    private HashMap<Integer, Faculty> createFacultyHashMap() {

        HashMap<Integer, Faculty> facultyHashMap = new HashMap<>();

        facultyHashMap.put(101,
                new Faculty(101, "Robertson", "Myra", "98121", 60000.00, 2.50));

        facultyHashMap.put(212,
                new Faculty(212, "Smith", "Neal", "85001", 40000.00, 3.00));

        facultyHashMap.put(315,
                new Faculty(315, "Arlec", "Lisa", "71601", 55000.00, 1.50));

        facultyHashMap.put(857,
                new Faculty(857, "Fillipo", "Paul", "90001", 30000.00, 5.00));

        facultyHashMap.put(370,
                new Faculty(370, "Denkan", "Anais", "15001", 95000.00, 1.50));

        return facultyHashMap;
    }

    private String getZipCodeJSON(String zipCode) {

        Client client = ClientBuilder.newClient();

        String uri = "http://api.zippopotam.us/us/" + zipCode;

        WebTarget target = client.target(uri);

        String response = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        client.close();

        return response;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String displayHTMLFacultyInfo() {

        HashMap<Integer, Faculty> facultyHashMap = createFacultyHashMap();

        StringBuilder output = new StringBuilder();

        output.append("<html><body>");

        output.append("<h2>Unsorted Faculty List</h2>");

        output.append("<table border='1'>");

        output.append("<tr>")
              .append("<th>ID</th>")
              .append("<th>Last Name</th>")
              .append("<th>First Name</th>")
              .append("<th>Faculty Zip Code</th>")
              .append("<th>Salary</th>")
              .append("<th>Bonus Rate</th>")
              .append("<th>Bonus</th>")
              .append("</tr>");

        for (Map.Entry<Integer, Faculty> entry : facultyHashMap.entrySet()) {

            Faculty f = entry.getValue();

            String zipJSON = getZipCodeJSON(f.getF_zipcodeBirth());

            output.append("<tr>")
                  .append("<td>").append(f.getF_Id()).append("</td>")
                  .append("<td>").append(f.getF_Lname()).append("</td>")
                  .append("<td>").append(f.getF_Fname()).append("</td>")
                  .append("<td>").append(zipJSON).append("</td>")
                  .append("<td>").append(f.getF_Salary()).append("</td>")
                  .append("<td>").append(f.getF_BonusRate()).append("</td>")
                  .append("<td>").append(f.doCalc_Bonus()).append("</td>")
                  .append("</tr>");
        }

        output.append("</table>");

        List<Faculty> sortedFacultyList =
                new ArrayList<>(facultyHashMap.values());

        sortedFacultyList.sort(
                Comparator.comparingDouble(Faculty::doCalc_Bonus));

        output.append("<h2>Sorted Faculty List by Bonus</h2>");

        output.append("<table border='1'>");

        output.append("<tr>")
              .append("<th>ID</th>")
              .append("<th>Last Name</th>")
              .append("<th>First Name</th>")
              .append("<th>Faculty Zip Code</th>")
              .append("<th>Salary</th>")
              .append("<th>Bonus Rate</th>")
              .append("<th>Bonus</th>")
              .append("</tr>");

        for (Faculty f : sortedFacultyList) {

            String zipJSON = getZipCodeJSON(f.getF_zipcodeBirth());

            output.append("<tr>")
                  .append("<td>").append(f.getF_Id()).append("</td>")
                  .append("<td>").append(f.getF_Lname()).append("</td>")
                  .append("<td>").append(f.getF_Fname()).append("</td>")
                  .append("<td>").append(zipJSON).append("</td>")
                  .append("<td>").append(f.getF_Salary()).append("</td>")
                  .append("<td>").append(f.getF_BonusRate()).append("</td>")
                  .append("<td>").append(f.doCalc_Bonus()).append("</td>")
                  .append("</tr>");
        }

        output.append("</table>");
        output.append("</body></html>");

        return output.toString();
    }
}