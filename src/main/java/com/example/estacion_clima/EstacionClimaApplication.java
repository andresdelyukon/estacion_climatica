package com.example.estacion_clima;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static jdk.javadoc.doclet.DocletEnvironment.ModuleMode.API;

@SpringBootApplication
public class EstacionClimaApplication {

	@Autowired
	private API api;

	@Autowired
	private IconvierteDatos converter;

	@Autowired
	private ResultadosClimaService resultadosClimaService;

	private final Scanner teclado = new Scanner(System.in);

	private final String URL_BASE = "https://api.openweathermap.org/data/2.5/weather?q=";
	private final String API_KEY = "&APPID=f02121742f35153f2711d66a2ceb2a7b";

	public static void main(String[] args) {
		var context = SpringApplication.run(EstacionClimaApplication.class, args);
		EstacionClimaApplication app = context.getBean(EstacionClimaApplication.class);
		app.ejecutar();


	}

	public void ejecutar() {
		try {
			HashMap<String, Integer> datos = mainData();
			System.out.println("Datos procesados: " + datos);
		} catch (Exception e) {
			System.err.println("Error en la ejecución: " + e.getMessage());
		}
	}

	public String obtenerDatosDeAPI() {
		System.out.println("Escribe el nombre de la ciudad:");
		var nombreCiudad = teclado.nextLine();
		try {
			var json = api.obtenerDatos(URL_BASE + nombreCiudad.replace(" ", "+") + API_KEY);
			System.out.println("JSON recibido:\n" + json);
			return json;
		} catch (Exception e) {
			System.err.println("Error al obtener datos de la API: " + e.getMessage());
			return null;
		}
	}

	public resultados_Clima convertirJSONaObjeto() {
		var json = obtenerDatosDeAPI();
		if (json == null) return null;

		resultados_Clima resultados_clima = converter.obtenerDatos(json, resultados_Clima.class);
		if (resultados_clima != null) {
			System.out.println("Objeto deserializado: " + resultados_clima);
		} else {
			System.out.println("Error al deserializar el JSON.");
		}
		return resultados_clima;
	}

	public HashMap<String, Integer> mainData() {
		resultados_Clima resultados_clima_2 = convertirJSONaObjeto();
		if (resultados_clima_2 == null) throw new RuntimeException("No se pudo procesar la información.");

		resultados_clima_2 = resultadosClimaService.guardarResultados(resultados_clima_2); // Guardar en BD
		System.out.println(resultados_clima_2.getMain().diccionarioMain());
		return resultados_clima_2.getMain().diccionarioMain();
	}







	
}

