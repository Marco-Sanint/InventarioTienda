/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.ProductoExistenteException;
import excepciones.ProductoNoEncontradoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isa
 */

public class Tienda {

    private static Tienda tienda;
    private String nombre;
    private String lugar;
    private Inventario inventario;
    private List<Empleado> empleados; 

    public Tienda(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.inventario = new Inventario();
        this.empleados = new ArrayList<>(); 
        empleadosEjemplo();
    }

    public static Tienda getInstancia(String nombre, String lugar) {
        if (tienda == null) {
            tienda = new Tienda(nombre, lugar);
        }
        return tienda;
    }
    
    public void agregarEmpleado(String id, String nombre, String rol, String password) {
        Empleado empleado = new Empleado(id, nombre, rol, password);
        empleados.add(empleado);
    }

    public void eliminarEmpleado(int id) {
        empleados.removeIf(empleado -> empleado.getId().equals(id));
    }
    
    public boolean verificarEmpleado(String cedula, String password) {
        for (Empleado empleado : empleados) {
            if (empleado.verificarCedula(cedula) && empleado.verificarPassword(password)) {
                return true;
            }
        }
        return false;
    }
    
    public void empleadosEjemplo(){
        agregarEmpleado("10", "Marco Sanint", "Gerente", "10");
    }

    // Métodos para interactuar con el inventario

    public void agregarProducto(String idProducto, String nombre, String descripcion, double precio, int cantidad) throws ProductoExistenteException {
        inventario.agregarProducto(idProducto, nombre, descripcion, precio, cantidad);
    }

    public void eliminarProducto(String idProducto) throws ProductoNoEncontradoException {
        inventario.eliminarProducto(idProducto);
    }

    public void editarProducto(Producto p, String nombre, String descripcion, Double precio, Integer cantidad) throws ProductoNoEncontradoException {
        inventario.editarProducto(p, nombre, descripcion, precio, cantidad);
    }

    public Producto buscarProductosPorNombree(String nombre) {
        return inventario.buscarProductosPorNombre(nombre);
    }

    public Producto buscarProductosPorID(String id) {
        return inventario.buscarProductosPorID(id);
    }
    
    public List<String> listaNombres() {
        return inventario.listaNombres();
    }

    public List<String> listaID() {
        return inventario.listaID();
    }

    public List<Producto> generarInformeStock() {
        return inventario.generarInformeStock();
    }

    // Getters y setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}