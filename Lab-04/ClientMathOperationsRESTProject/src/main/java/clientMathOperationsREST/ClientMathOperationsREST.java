package clientMathOperationsREST;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientMathOperationsREST {

    public static void main(String[] args) {

        String baseUri =
                "http://localhost:8081/WebMathOperationsRESTProject2/rest/MathOp";

        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        // Test 1 - Query Parameters
        WebTarget mathTarget = client.target(baseUri)
                .queryParam("x", 1)
                .queryParam("y", 2)
                .queryParam("z", 3);

        String mathResponse = mathTarget.request()
                .accept(MediaType.TEXT_HTML)
                .get(String.class);

        System.out.println("===== Math Operations =====");
        System.out.println(mathResponse);


        // Test 2 - ArrayList
        WebTarget listTarget =
                client.target(baseUri + "/displayListZYZ");

        String listResponse = listTarget.request()
                .accept(MediaType.TEXT_HTML)
                .get(String.class);

        System.out.println("\n===== ArrayList =====");
        System.out.println(listResponse);


        // Test 3 - HashMap Search
        WebTarget hashMapTarget =
                client.target(baseUri + "/OpHashMap/4");

        String hashMapResponse = hashMapTarget.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println("\n===== HashMap Search x = 4 =====");
        System.out.println(hashMapResponse);

        client.close();
    }
}