package com.rescate.actividadesrescate.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Rescate {

    private String nombre;
    private String ubicacion;
    private String responsable;
    private EnumRescate tipoRescate;
    private Categoria categoria;
    private Stack<Integer> conteo;


    public Rescate() {
        this.conteo = new Stack<>();
    }


    public Rescate(String nombre, String ubicacion,
                   String responsable, EnumRescate tipoRescate,
                   Categoria categoria, Stack<Integer> conteo) {

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.responsable = responsable;
        this.tipoRescate = tipoRescate;
        this.categoria = categoria;
        this.conteo = (conteo == null) ? new Stack<>() : conteo;
    }


    public Rescate(String nombre, String ubicacion,
                   String responsable, EnumRescate tipoRescate,
                   Categoria categoria) {

        this(nombre, ubicacion, responsable, tipoRescate,
                categoria, new Stack<>());
    }


    public void agregarConteo(int numero) {
        conteo.push(numero);
    }


    public int verTotales(Function<Rescate, Integer> funcion) {
        int total = funcion.apply(this);
        System.out.println("Total de " + nombre + ": " + total);
        return total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
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

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = (conteo == null) ? new Stack<>() : conteo;
    }
}