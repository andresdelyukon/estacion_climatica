package com.example.estacion_clima;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class API {
    public String obtenerDatos(String url) {
        // Crear cliente
        HttpClient client = HttpClient.newHttpClient();

        // Configurar la solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            // Enviar la solicitud y obtener la respuesta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Mostrar el código de estado y el cuerpo de la respuesta
            //System.out.println("Código de estado: " + response.statusCode());
            //System.out.println("Cuerpo de la respuesta: " + response.body());

            //se supone que el response ya trae lo mero bueno entonces conviene ponerlo en una variable
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = response.body();
        return json;
    }
}
