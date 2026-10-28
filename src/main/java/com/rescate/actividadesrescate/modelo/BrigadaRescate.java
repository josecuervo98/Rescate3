package com.rescate.actividadesrescate.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrigadaRescate {

    private String nombre;
    private String sede;
    private EnumRescate tipoRescate;
    private Categoria categoria;
    private Deque<Rescate> rescates;


    public BrigadaRescate() {
        this.rescates = new ArrayDeque<>();
    }


    public BrigadaRescate(String nombre, String sede,
                          EnumRescate tipoRescate, Categoria categoria,
                          Deque<Rescate> rescates) {

        this.nombre = nombre;
        this.sede = sede;
        this.tipoRescate = tipoRescate;
        this.categoria = categoria;
        this.rescates = (rescates == null)
                ? new ArrayDeque<>()
                : rescates;
    }


    public BrigadaRescate(String nombre, String sede,
                          EnumRescate tipoRescate, Categoria categoria) {

        this(nombre, sede, tipoRescate, categoria, new ArrayDeque<>());
    }


    public void agregarRescate(Rescate rescate) {
        rescates.addLast(rescate);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public EnumRescate getTipoRescate() {
        return tipoRescate;
    }

    public void setTipoRescate(EnumRescate tipoRescate) {
        this.tipoRescate = tipoRescate;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Deque<Rescate> getRescates() {
        return rescates;
    }

    public void setRescates(Deque<Rescate> rescates) {
        this.rescates = (rescates == null)
                ? new ArrayDeque<>()
                : rescates;
    }
}