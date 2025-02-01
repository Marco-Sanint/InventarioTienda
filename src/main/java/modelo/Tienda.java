/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isa
 */
public class Tienda {

    private String nombre;
    private String lugar;
    private List<Producto> inventario;

    public Tienda(String nombre, String lugar) {
        this.lugar = lugar;
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setInventario(List<Producto> inventario) {
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public List<Producto> getInventario() {
        return inventario;
    }
}
