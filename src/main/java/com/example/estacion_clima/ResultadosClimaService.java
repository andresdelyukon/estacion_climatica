package com.example.estacion_clima;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultadosClimaService {
    @Autowired
    private resultados_Clima_Repository resultadosClimaRepository;

    @Transactional
    public resultados_Clima guardarResultados(resultados_Clima resultadosClima) {
        // Si no estás utilizando el id proporcionado por la API, anula su valor
        resultadosClima.setId(null);

        // Configura la relación inversa para cada objeto Weather (si es necesario)

        if (resultadosClima.getWeatherList() != null && !resultadosClima.getWeatherList().isEmpty()) {
            for (Weather weather : resultadosClima.getWeatherList()) {
                weather.setResultadosClima(resultadosClima);
            }
        }

        // Si el objeto 'main' ya está creado, se vincula automáticamente
        Main main = resultadosClima.getMain();
        if (main != null) {
            main.setName(resultadosClima.getName()); // Asegúrate de que el nombre también esté relacionado
        }

        return resultadosClimaRepository.save(resultadosClima);
    }

    //metodo para obtener todos los reportes climaticos

    }


