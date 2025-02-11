package com.api.apirest.Entities;

import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String name;
    @Column
    private double precio;
    @Column
    private String categoria;

    public Producto(Long id, String name, double precio, String categoria) {
        Id = id;
        this.name = name;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto() {
    }

    /*+++++++++++++++++++++Getter and Setters+++++++++++++++++++++++++++++++++++++*/
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}

