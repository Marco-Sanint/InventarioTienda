/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Isa
 */
public class RegistroDeOperaciones {

    private static final String ARCHIVO_DE_REGISTRO = "registro_operaciones,txt";
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void registrarOperacion(String operacion, String usuario, String ip, modelo.Producto producto) {
        String log = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + " | Usuario: " + usuario
                + " | IP: " + ip
                + " | Operación: " + operacion
                + " | Producto: " + producto.getId() + " - " + producto.getNombre();

        executor.submit(() -> escribirEnArchivo(log));

        System.out.println("Las operaciones que han sido registradas: " + log);
    }

    private static void escribirEnArchivo(String log) {
        try (FileWriter file = new FileWriter(ARCHIVO_DE_REGISTRO, true)) {
            file.write(log + "\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de registro: " + e.getMessage());
        }
    }
    
    public static void cerrar(){
        executor.shutdown();
    }

}
