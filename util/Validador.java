package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.StockInsuficienteException;


public class Validador {
    
    public static void validarNombre(String nombre){
        // un nombre nulo o vacío, no representa un producto válido
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecio(double precio){
        //no puede ser negativo
        //acepta 0 como precio válido
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser un número negativo.");
        }
    }

    public static void validarStock(int stock){
        // el stock negativo no es válido
        // usamos nuestra excepción personalizada creada
        if (stock < 0){
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria){
        if (categoria == null || categoria.trim().isEmpty()){
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
    }
    
    // lectura por consola

    public static int leerEntero(Scanner sc , String mensaje){
        // bucle infinito que solo se rompe cuando el usuario ingresa un entero valido.
        while (true) {
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine();// limpia el salto de línea
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número entero. Intente nuevamente.");
                sc.nextLine();// limpia el salto de línea
            }
        }
    }

    public static double leerDouble (Scanner sc, String mensaje){
        while (true) {
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (Exception e) {
                System.out.println("Debe ingresar un número decimal.(coma o punto");
                sc.nextLine();
            }
            
        }
    }

    public static String leerTexto(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }

    

}
