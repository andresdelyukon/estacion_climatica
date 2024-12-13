package com.example.estacion_clima;

import org.springframework.stereotype.Component;


public interface IconvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
