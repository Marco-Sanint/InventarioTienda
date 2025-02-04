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

    private String id;
    private String nombre;
    private String rol;
    private String password;

    public Empleado(String id, String nombre, String rol, String password) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.password = password;
    }

    public boolean verificarCedula(String cedula) {
        return this.id.equals(cedula);
    }
    
    public boolean verificarPassword(String password) {
        return this.password.equals(password);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPassword() {
        return password; 
    }

    @Override
    public String toString() {
        return "Empleado{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", rol='" + rol + '\''
                + '}';
    }
}