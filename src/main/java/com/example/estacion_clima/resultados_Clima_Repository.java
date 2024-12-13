package com.example.estacion_clima;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface resultados_Clima_Repository extends JpaRepository<resultados_Clima, Long> {
    //En esta madre se van creando los metodos que usamos
    //creo que con esta tabla tengo y me sobra bastantito
    List<resultados_Clima> findByName(String name);
}
