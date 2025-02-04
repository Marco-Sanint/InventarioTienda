/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;
import modelo.Producto;

/**
 *
 * @author Isa
 */
public class RegistroDeOperaciones {

    private static final String ARCHIVO_REGISTRO = "registro_operaciones.txt";
    private static final ReentrantLock lock = new ReentrantLock();

    public static void registrarOperacion(String operacion, String usuario, String ip, Producto producto) {
        lock.lock(); 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_REGISTRO, true))) {
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHora = formatter.format(new Date());

            
            String registro = String.format("[%s] Operación: %s | Usuario: %s | IP: %s | Producto: %s (ID: %s, Nombre: %s, Precio: %.2f, Stock: %d)%n",
                    fechaHora, operacion, usuario, ip, producto.getNombre(), producto.getIdProducto(), producto.getNombre(), producto.getPrecio(), producto.getStock());

            
            writer.write(registro);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de registro: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
