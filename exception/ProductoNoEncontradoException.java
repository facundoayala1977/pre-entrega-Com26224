package exception;

/* Excepción personalizada que se lanza cuando se busca un producto por su id y no existe en el sistema.
   Hereda de RunTimeException (unChecked): no obliga a quien usa el metodo a envolver la llamada en try/catch, pero si permite capturar cuando nos interesa.
   Crear nuestras excepciones permite informar errores con nombres claros,en lugar de usar las excepciones genéricas(Exception, IllegalArgumentException)
*/

public class ProductoNoEncontradoException extends RuntimeException {
    public ProductoNoEncontradoException(String mensaje) {
        //super llama al constructor de la clase padre(RunTimeException) que es quien guarda el mensaje y lo expone con getmessage(); 
        super(mensaje);
    }
}
