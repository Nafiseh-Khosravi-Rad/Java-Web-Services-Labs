package webCarREST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/WebCar")
public class WebCarResource {

    private HashMap<String, Car> createCarHashMap() {

        HashMap<String, Car> carHashMap = new HashMap<>();

        carHashMap.put("K1245",
                new Car("K1245", "Ford", 35000));

        carHashMap.put("M198754",
                new Car("M198754", "Honda", 40000));

        carHashMap.put("M98524M4",
                new Car("M98524M4", "Hyundai", 25000));

        carHashMap.put("S741582",
                new Car("S741582", "Nissan", 30000));

        return carHashMap;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String displayTextCarInfo() {

        HashMap<String, Car> carHashMap = createCarHashMap();

        StringBuilder output = new StringBuilder();

        output.append("Unsorted Car List\n");

        for (Map.Entry<String, Car> entry : carHashMap.entrySet()) {

            Car c = entry.getValue();

            output.append("VIN: ").append(c.getVin())
                  .append(", Desc: ").append(c.getDesc())
                  .append(", Price: ").append(c.getPrice())
                  .append(", Discount Price: ").append(c.discountPrice())
                  .append("\n");
        }

        List<Car> sortedList = new ArrayList<>(carHashMap.values());

        sortedList.sort(
                Comparator.comparingDouble(Car::discountPrice));

        output.append("\nSorted Car List by Discount Price\n");

        for (Car c : sortedList) {

            output.append("VIN: ").append(c.getVin())
                  .append(", Desc: ").append(c.getDesc())
                  .append(", Price: ").append(c.getPrice())
                  .append(", Discount Price: ").append(c.discountPrice())
                  .append("\n");
        }

        return output.toString();
    }

    @GET
    @Path("/searchCar/{vin}")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchJSONCarInfo(@PathParam("vin") String carVin) {

        HashMap<String, Car> carHashMap = createCarHashMap();

        Car car = carHashMap.get(carVin);

        if (car == null) {
            return "{\"error\":\"Car not found\"}";
        }

        return "{"
                + "\"vin\":\"" + car.getVin() + "\","
                + "\"desc\":\"" + car.getDesc() + "\","
                + "\"price\":" + car.getPrice() + ","
                + "\"discountPrice\":" + car.discountPrice()
                + "}";
    }

    @GET
    @Path("/TotalCarPriceDiscount")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateTotalCarPriceDiscount() {

        HashMap<String, Car> carHashMap = createCarHashMap();

        double total = 0;

        for (Car c : carHashMap.values()) {
            total += c.discountPrice();
        }

        return String.valueOf(total);
    }
}