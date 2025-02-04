/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import excepciones.ProductoExistenteException;
import excepciones.ProductoNoEncontradoException;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IGestorInventario {
    void agregarProducto(String idProducto, String nombre, String descripcion, double precio, int cantidad) throws ProductoExistenteException;
    void eliminarProducto(String idProducto) throws ProductoNoEncontradoException;
    void editarProducto(Producto p, String nombre, String descripcion, Double precio, Integer cantidad) throws ProductoNoEncontradoException;
    Producto buscarProductosPorNombre(String nombre);
    Producto buscarProductosPorID(String id);
    List<String> listaNombres();
    List<String> listaID();
    List<Producto> generarInformeStock();
}