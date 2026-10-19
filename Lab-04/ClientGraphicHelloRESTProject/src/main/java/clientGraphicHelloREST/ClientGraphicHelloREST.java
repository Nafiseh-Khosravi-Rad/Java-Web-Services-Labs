package clientGraphicHelloREST;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientGraphicHelloREST extends JFrame {

    private JTextArea outputArea;
    private JButton getButton;

    public ClientGraphicHelloREST() {

        setTitle("REST Web Service Client");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 16));

        getButton = new JButton("Get REST Response");

        getButton.addActionListener(e -> consumeRESTService());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getButton);

        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void consumeRESTService() {

    	String uri =
    	        "http://localhost:8081/WebHelloRESTProject2/rest/HiHi";

        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(uri);

        try {

            String response = target.request()
                    .accept(MediaType.TEXT_PLAIN)
                    .get(String.class);

            outputArea.setText(response);

        } catch (Exception ex) {

            outputArea.setText("Error: " + ex.getMessage());

        } finally {

            client.close();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ClientGraphicHelloREST window =
                    new ClientGraphicHelloREST();

            window.setVisible(true);
        });
    }
}