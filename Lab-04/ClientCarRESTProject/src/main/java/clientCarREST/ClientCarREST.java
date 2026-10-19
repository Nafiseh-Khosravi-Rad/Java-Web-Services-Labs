package clientCarREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientCarREST {

    public static void main(String[] args) {

        String baseUri =
                "http://localhost:8081/WebCarRESTProject2/rest/WebCar";

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        Scanner scanner = new Scanner(System.in);

        try {

            // Display all cars
            WebTarget carTarget = client.target(baseUri);

            String carResponse = carTarget.request()
                    .accept(MediaType.TEXT_PLAIN)
                    .get(String.class);

            System.out.println("===== All Cars =====");
            System.out.println(carResponse);

            // Search cars
            String choice;

            do {

                System.out.print("\nPlease Enter Valid Car vin: ");
                String vin = scanner.nextLine();

                WebTarget searchTarget =
                        client.target(baseUri + "/searchCar/" + vin);

                String searchResponse = searchTarget.request()
                        .accept(MediaType.APPLICATION_JSON)
                        .get(String.class);

                System.out.println("\nCar JSON Search Output:");
                System.out.println(searchResponse);

                System.out.print("Do you Want to continue y/n: ");
                choice = scanner.nextLine();

            } while (choice.equalsIgnoreCase("y"));

            // Total Car Benefit
            System.out.println(
                    "\nDisplay Car Benefits as Total Operating Cost - Total Car Price Discount");

            System.out.print(
                    "Please Enter Total Operating Car Cost: ");

            double totalOperatingCarCost =
                    Double.parseDouble(scanner.nextLine());

            WebTarget totalTarget =
                    client.target(baseUri + "/TotalCarPriceDiscount");

            String totalResponse = totalTarget.request()
                    .accept(MediaType.TEXT_PLAIN)
                    .get(String.class);

            double totalCarPriceDiscount =
                    Double.parseDouble(totalResponse);

            double carBenefit =
                    totalOperatingCarCost - totalCarPriceDiscount;

            System.out.println(
                    "\nTotal Car Price Discount Output is :"
                    + totalCarPriceDiscount + "$");

            System.out.println(
                    "Car Benefits is :"
                    + carBenefit + "$");

        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());

        } finally {

            scanner.close();
            client.close();
        }
    }
}