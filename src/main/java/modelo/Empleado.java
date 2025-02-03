/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Isa
 */
public class Empleado {

    private int id;
    private String nombre;
    private String rol;

    public Empleado(int id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", puesto='" + rol + '\''
                + '}';
    }
}
