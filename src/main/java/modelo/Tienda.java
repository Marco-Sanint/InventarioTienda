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
    private List<Empleado> empleados; // Lista de empleados

    public Tienda(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.inventario = new ArrayList<>();
        this.empleados = new ArrayList<>(); // Inicializamos la lista de empleados
    }

    // Métodos para agregar, eliminar, editar empleados
    public void agregarEmpleado(int id, String nombre, String rol) {
        Empleado empleado = new Empleado(id, nombre, rol);
        empleados.add(empleado);
    }

    public void eliminarEmpleado(int id) {
        empleados.removeIf(empleado -> empleado.getId() == id);
    }

    // Getters y setters
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
