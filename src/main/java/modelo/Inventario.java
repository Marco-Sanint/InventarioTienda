/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.ProductoExistenteException;
import excepciones.ProductoNoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import util.RegistroDeOperaciones;

/**
 *
 * @author Isa
 */
public class Inventario implements IGestorInventario{

    private Map<String , Producto> productos = new ConcurrentHashMap<>();

    /**
     * sirve para una búsqueda rápida - Map<Integer, Producto> -> Declara un
     * mapa donde el integer representa id del producto y producto es la
     * instancia del producto asociado - new ConcurrentHashMap<>() -> Es
     * utilizada para cuando se están } ejecutando varios hilos (procesos),
     * almacena los datos clave-valor y acceso rápido
     *
     */

    @Override
    public void agregarProducto(String idProducto, String nombre, String descripcion, double precio, int cantidad) throws ProductoExistenteException {
        if (productos.containsKey(idProducto)) {
            throw new ProductoExistenteException("El producto ya existe en el inventario");
        }
        Producto producto = new Producto(idProducto, nombre, descripcion, precio, cantidad);
        productos.put(idProducto, producto);
        RegistroDeOperaciones.registrarOperacion("Agregar Producto", "Admin", "127.0.0.1", producto);
    }

    @Override
    public void eliminarProducto(String idProducto) throws ProductoNoEncontradoException {
        if (!productos.containsKey(idProducto)) {
            throw new ProductoNoEncontradoException("El producto no existe");
        }
        Producto producto = productos.get(idProducto);
        productos.remove(idProducto);
        RegistroDeOperaciones.registrarOperacion("Eliminar Producto", "Admin", "127.0.0.1", producto);
    }

    @Override
    public void editarProducto(Producto p, String nombre, String descripcion, Double precio, Integer cantidad) throws ProductoNoEncontradoException {

        Producto producto = p;
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
        RegistroDeOperaciones.registrarOperacion("Editar Producto", "Admin", "127.0.0.1", p);
    }

    @Override
    public Producto buscarProductosPorNombre(String nombre) {
        return productos.values().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst() // Devuelve un Optional<Producto>
                .orElse(null); // Retorna null si no se encuentra el producto
    }

    @Override
    public Producto buscarProductosPorID(String id) {
        return productos.values().stream()
                .filter(p -> p.getIdProducto().equalsIgnoreCase(id))
                .findFirst() // Devuelve un Optional<Producto>
                .orElse(null); // Retorna null si no se encuentra el producto
    }
    
    @Override
    public List<Producto> generarInformeStock() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public List<String> listaNombres() {
        return productos.values().stream()
            .map(Producto::getNombre) // Extrae el nombre de cada producto
            .collect(Collectors.toList());
    }

    @Override
    public List<String> listaID() {
        return productos.values().stream()
            .map(Producto::getIdProducto) // Extrae el ID de cada producto
            .collect(Collectors.toList());
    }
}