package com.example.estacion_clima;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
    public class Clouds {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

    @JsonProperty("all")
    private String allData;

        public Clouds() {} // Constructor por defecto requerido por JPA



        public Long getId() {
            return id;
        }

    public String getAllData() {
        return allData;
    }

    public void setAllData(String allData) {
        this.allData = allData;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "id=" + id +
                ", allData='" + allData + '\'' +
                '}';
    }
}
