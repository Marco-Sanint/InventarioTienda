/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Isa
 */
public class ProductoExistenteException extends Exception {

    public ProductoExistenteException() {
        super("El producto ya existe en el sistema.");
    }

    public ProductoExistenteException(String message) {
        super(message);
    }

    public ProductoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoExistenteException(Throwable cause) {
        super(cause);
    }
}
