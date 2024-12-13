package com.example.estacion_clima;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class resultados_Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultados_clima_seq")
    @SequenceGenerator(name = "resultados_clima_seq", sequenceName = "resultados_clima_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coord_id", referencedColumnName = "id")
    private Coord coord;
    @Version
    private Long version;
    @OneToMany(mappedBy = "resultadosClima", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weather> weatherList = new ArrayList<>();
    private String base;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_id")
    private Main main;
    private String visibility;
    @ManyToOne(cascade = CascadeType.ALL)
    private Wind wind;
    @OneToOne(cascade = CascadeType.ALL)
    private Clouds clouds;
    private int dt;
    @ManyToOne(cascade = CascadeType.ALL)
    private Sys sys;
    private int timezone;
    private String name;
    private int cod;


    protected resultados_Clima(){}


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public resultados_Clima(Long id, Coord coord, List<Weather> weatherList, String base, Main main, String visibility, Wind wind, Clouds clouds, Sys sys, int dt, int timezone, int cod, String name) {
        this.id = id;
        this.coord = coord;
        this.weatherList = weatherList;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.sys = sys;
        this.dt = dt;
        this.timezone = timezone;
        this.cod = cod;
        this.name = name;
    }

    @Override
    public String toString() {
        return "resultados_Clima{" +
                "id=" + id +
                ", coord=" + coord +
                ", weatherList=" + weatherList +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility='" + visibility + '\'' +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
