package webCarREST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;

@Path("/WebCar")
public class WebCarResource {

    private HashMap<String, Car> createCarHashMap() {

        HashMap<String, Car> carHashMap = new HashMap<>();

        carHashMap.put("K1245", new Car("K1245", "Ford", 35000));
        carHashMap.put("M198754", new Car("M198754", "Honda", 40000));
        carHashMap.put("M98524M4", new Car("M98524M4", "Hyundai", 25000));
        carHashMap.put("S741582", new Car("S741582", "Nissan", 30000));

        return carHashMap;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String displayHTMLCarInfo() {

        HashMap<String, Car> carHashMap = createCarHashMap();

        String output = "<html><body>";
        output += "<h2>Unsorted Car List</h2>";
        output += "<table border='1'>";
        output += "<tr><th>VIN</th><th>Description</th><th>Price</th><th>Discount Price</th></tr>";

        for (Map.Entry<String, Car> entry : carHashMap.entrySet()) {
            Car car = entry.getValue();

            output += "<tr>"
                    + "<td>" + car.getVin() + "</td>"
                    + "<td>" + car.getDesc() + "</td>"
                    + "<td>" + car.getPrice() + "</td>"
                    + "<td>" + car.discountPrice() + "</td>"
                    + "</tr>";
        }

        output += "</table>";

        List<Car> sortedCars = new ArrayList<>(carHashMap.values());

        sortedCars.sort(Comparator.comparingDouble(Car::discountPrice));

        output += "<h2>Sorted Car List by Discount Price</h2>";
        output += "<table border='1'>";
        output += "<tr><th>VIN</th><th>Description</th><th>Price</th><th>Discount Price</th></tr>";

        for (Car car : sortedCars) {
            output += "<tr>"
                    + "<td>" + car.getVin() + "</td>"
                    + "<td>" + car.getDesc() + "</td>"
                    + "<td>" + car.getPrice() + "</td>"
                    + "<td>" + car.discountPrice() + "</td>"
                    + "</tr>";
        }

        output += "</table>";
        output += "</body></html>";

        return output;
    }
    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String displayTextCarInfo() {

        HashMap<String, Car> carHashMap = createCarHashMap();

        String output = "";

        for (Map.Entry<String, Car> entry : carHashMap.entrySet()) {
            Car car = entry.getValue();

            output += "VIN: " + car.getVin()
                    + ", Description: " + car.getDesc()
                    + ", Price: " + car.getPrice()
                    + ", Discount Price: " + car.discountPrice()
                    + "\n";
        }

        return output;
    }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String, Car> displayJSONCarInfo() {
        return createCarHashMap();
    }
    @GET
    @Path("/searchCar/{vin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car searchJSONCarInfo(@PathParam("vin") String carVin) {

        HashMap<String, Car> carHashMap = createCarHashMap();

        return carHashMap.get(carVin);
    }
}