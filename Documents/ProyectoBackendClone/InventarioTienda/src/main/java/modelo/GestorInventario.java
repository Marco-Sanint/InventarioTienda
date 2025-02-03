/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import excepciones.ProductoExistenteException;
import excepciones.ProductoNoEncontradoException;
import util.RegistroDeOperaciones;

/**
 *
 * @author Isa
 */
/**
 * Clase principal, de donde seán heredados la mayoría de métodos
 *
 */
public class GestorInventario {

    private Map<Integer, Producto> productos = new ConcurrentHashMap<>();

    /**
     * sirve para una búsqueda rápida - Map<Integer, Producto> -> Declara un
     * mapa donde el integer representa id del producto y producto es la
     * instancia del producto asociado - new ConcurrentHashMap<>() -> Es
     * utilizada para cuando se están } ejecutando varios hilos (procesos),
     * almacena los datos clave-valor y acceso rápido
     * cantidad = stock
     * IP ================= DE ZEROTIER
     */
    public void agregarProducto(int idProducto, String nombre, String descripcion, double precio, int cantidad, String usuario) {
        if (productos.containsKey(idProducto)) {
            throw new ProductoExistenteException("El producto ya existe en el inventario");
        }
        Producto producto = new Producto(idProducto, nombre, descripcion, precio, cantidad);
        productos.put(idProducto, producto);
        RegistroDeOperaciones.registrarOperacion("Agregar Producto", usuario, " 192.168.196.167", producto);
    }

    public void eliminarProducto(int idProducto, String usuario, String ip) {
        if (!productos.containsKey(idProducto)) {
            throw new ProductoNoEncontradoException("El producto no existe");
        }
        Producto producto = productos.get(idProducto);
        productos.remove(idProducto);
        RegistroDeOperaciones.registrarOperacion("Eliminar Producto", usuario, " 192.168.196.167", producto);
    }

    public void editarProducto(int idProducto, String nombre, String descripcion, Double precio, Integer cantidad, String usuario) {
        if (!productos.containsKey(idProducto)) {
            throw new ProductoNoEncontradoException("El producto no existe");
        }
        Producto producto = productos.get(idProducto);
        if (nombre != null) {
            producto.setNombre(nombre);
        }
        if (descripcion != null) {
            producto.setDescripcion(descripcion);
        }
        if (precio != null) {
            producto.setPrecio(precio);
        }
        if (cantidad != null) {
            producto.setStock(cantidad);
        }
        RegistroDeOperaciones.registrarOperacion("Editar Producto", usuario, " 192.168.196.167", producto);
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productos.values().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    // Método para generar un informe de stock
    public List<Producto> generarInformeStock() {
        return new ArrayList<>(productos.values());
    }
}
