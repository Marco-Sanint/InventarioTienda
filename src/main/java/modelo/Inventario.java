/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.ProductoExistenteException;
import excepciones.ProductoNoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import util.RegistroDeOperaciones;

/**
 *
 * @author Isa
 */
public class Inventario {

    private List<Producto> productos = new ArrayList<>(); // Usamos una lista para almacenar los productos

    /**
     * Este método agrega un producto al inventario, verificando si ya existe.
     * Si el producto existe, lanza una excepción.
     */
    public void agregarProducto(int idProducto, String nombre, String descripcion, double precio, int cantidad) throws ProductoExistenteException {
        // Verificamos si el producto ya existe por ID
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                throw new ProductoExistenteException("El producto ya existe en el inventario.");
            }
        }

        Producto producto = new Producto(idProducto, nombre, descripcion, precio, cantidad);
        productos.add(producto);  // Añadimos el producto a la lista
        RegistroDeOperaciones.registrarOperacion("Agregar Producto", "Admin", "127.0.0.1", producto);
    }

    /**
     * Este método elimina un producto del inventario. Si el producto no se
     * encuentra, lanza una excepción.
     */
    public void eliminarProducto(int idProducto) throws ProductoNoEncontradoException {
        Producto productoParaEliminar = null;

        // Buscamos el producto a eliminar
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                productoParaEliminar = producto;
                break;
            }
        }

        if (productoParaEliminar == null) {
            throw new ProductoNoEncontradoException("El producto no existe.");
        }

        productos.remove(productoParaEliminar); // Eliminamos el producto de la lista
        RegistroDeOperaciones.registrarOperacion("Eliminar Producto", "Admin", "127.0.0.1", productoParaEliminar);
    }

    /**
     * Este método edita un producto en el inventario. Si no se encuentra, lanza
     * una excepción.
     */
    public void editarProducto(int idProducto, String nombre, String descripcion, Double precio, Integer cantidad) throws ProductoNoEncontradoException {
        Producto productoParaEditar = null;

        // Buscamos el producto a editar
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                productoParaEditar = producto;
                break;
            }
        }

        if (productoParaEditar == null) {
            throw new ProductoNoEncontradoException("El producto no existe.");
        }

        // Editamos los campos que no sean nulos
        if (nombre != null) {
            productoParaEditar.setNombre(nombre);
        }
        if (descripcion != null) {
            productoParaEditar.setDescripcion(descripcion);
        }
        if (precio != null) {
            productoParaEditar.setPrecio(precio);
        }
        if (cantidad != null) {
            productoParaEditar.setStock(cantidad);
        }

        RegistroDeOperaciones.registrarOperacion("Editar Producto", "Admin", "127.0.0.1", productoParaEditar);
    }

    /**
     * Este método busca productos por nombre.
     */
    public List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }

    /**
     * Este método genera un informe con todos los productos del inventario.
     */
    public List<Producto> generarInformeStock() {
        return new ArrayList<>(productos);  // Devuelve todos los productos en una lista
    }
}
