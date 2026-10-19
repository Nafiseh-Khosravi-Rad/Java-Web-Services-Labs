package clientHelloREST;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientHelloREST {

    public static void main(String[] args) {

        String uri = "http://api.zippopotam.us/us/98121";

        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(uri);

        String response = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        System.out.println(response);

        client.close();
    }
}