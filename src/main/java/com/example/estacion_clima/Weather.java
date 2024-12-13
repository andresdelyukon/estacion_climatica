package com.example.estacion_clima;

import jakarta.persistence.*;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //hay que ponerle la forma en que mapea de un lado o de otro
    @ManyToOne
    @JoinColumn(name = "resultados_clima_id")
    private resultados_Clima resultadosClima;
    private String main;
    private String description;
    private String icon;

    protected Weather(){}

    public Weather(Long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public resultados_Clima getResultadosClima() {
        return resultadosClima;
    }

    public void setResultadosClima(resultados_Clima resultadosClima) {
        this.resultadosClima = resultadosClima;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

}
