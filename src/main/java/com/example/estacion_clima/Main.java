package com.example.estacion_clima;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Main {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int temp;
    private int feels_like;
    private int temp_min;
    private int temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;

    @OneToMany(mappedBy = "main")
    private List<resultados_Clima> resultadosClimaList;

    // Constructor por defecto (obligatorio para Jackson)
    public Main() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Main(resultados_Clima resultados) {
        this.temp = resultados.getMain().getTemp();
        this.feels_like = resultados.getMain().getFeels_like();
        // Inicializa los demás campos
        this.temp_min = resultados.getMain().getTemp_min();
        this.temp_max = resultados.getMain().getTemp_max();
        this.pressure = resultados.getMain().getPressure();
        this.humidity = resultados.getMain().getHumidity();
        this.sea_level = resultados.getMain().getSea_level();
        this.grnd_level = resultados.getMain().getGrnd_level();
    }
    //se puede crear un array con los datos de Main directamente de la clase?
    //es que en contexto global solo tomo los elementos y los voy a anexando en el array.
    //la duda es como tomo los parametros de la clase y los meto a un arraylist
    //


    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(int feels_like) {
        this.feels_like = feels_like;
    }

    public int getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSea_level() {
        return sea_level;
    }

    public void setSea_level(int sea_level) {
        this.sea_level = sea_level;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(int grnd_level) {
        this.grnd_level = grnd_level;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
    public List<Object> listaMain(){
        List<Object> atributos = new ArrayList<>();
        var diccionario = diccionarioMain();
        atributos.add(diccionario);
        return atributos;
    }

    public HashMap<String, Integer> diccionarioMain(){
        HashMap<String, Integer> atributosDiccionario = new HashMap<>();
        atributosDiccionario.put("temperatura", temp);
        atributosDiccionario.put("sesacion_térmica", feels_like);
        atributosDiccionario.put("temperatura_minima", temp_min);
        atributosDiccionario.put("temperatura_maxima", temp_max);
        atributosDiccionario.put("presion", pressure);
        atributosDiccionario.put("humedad", humidity);
        return atributosDiccionario;
    }


    public void setName(String name) {
        
    }
}
