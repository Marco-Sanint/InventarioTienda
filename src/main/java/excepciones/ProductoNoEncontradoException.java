/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Isa
 */
public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException() {
        super("El producto no fue encontrado.");
    }

    public ProductoNoEncontradoException(String message) {
        super(message);
    }

    public ProductoNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductoNoEncontradoException(Throwable cause) {
        super(cause);
    }
}
