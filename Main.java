import java.util.Scanner;

import exception.ProductoNoEncontradoException;
import exception.StockInsuficienteException;
import model.Producto;
import service.ProductoService;
import ui.MenuProducto;
import util.Validador;


public class Main {
    public static void main(String[] args) {
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        MenuProducto menu = new MenuProducto(sc, service);
        cargarDatosDePrueba(service);

        int opcion;

        do{
            menu.mostrarMenu();
            opcion = Validador.leerEntero(sc, "Elija una opcion: ");

            try{
                switch (opcion) {
                    case 1 -> menu.agregarProducto();
                    case 2 -> menu.listarProductos();
                    case 3 -> menu.buscarProducto();
                    case 4 -> menu.actualizarProducto();
                    case 5 -> menu.eliminarProducto();
                    case 6 -> System.out.println("Gracias por su visita. Hasta pronto!!!"); 
                    default -> System.out.println("Opción INVÁLIDA");
                
                }

            } catch (ProductoNoEncontradoException | StockInsuficienteException e){
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }





        } while (opcion != 6);
    
        sc.close();
    
    }

    private static void cargarDatosDePrueba (ProductoService service){
        service.guardar(new Producto("Alimento Seco Perros 3kg", 12000, 30, "Perros"));
        service.guardar(new Producto("Alimento Seco Gatos", 11500, 23, "Gatos"));
        service.guardar(new Producto("Antiparasitario Perros", 15500, 35, "Perros"));
        service.guardar(new Producto("Antiparasitario Gatos", 13500, 25, "Gatos"));
        System.out.println("Se cargaron 4 productos de prueba. \n");
    }

}
