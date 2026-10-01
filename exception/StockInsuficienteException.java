package exception;
/* Excepción personalizada que se lanza cuando se intenta asignar un stock inválido(ej.: valor negativo)
   Si se incorpora un carrito, se puede intentar comprar un producto señalando mas unidades de las que existen

*/
public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException (String mensaje) {
        super(mensaje);
    }    
}
