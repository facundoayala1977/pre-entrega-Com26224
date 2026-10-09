package ui;

import java.util.List;
import java.util.Scanner;

import model.Producto;
import service.ProductoService;
import util.Validador;

public class MenuProducto {
    
    private final Scanner sc;
    private final ProductoService service;
    
    public MenuProducto(Scanner sc, ProductoService service){
        this.sc = sc;
        this.service = service;
    }

    //Menu Principal

    public void mostrarMenu(){
        System.out.println("------------------------------");
        System.out.println("**** Gestión de Productos ****");
        System.out.println("****      Mi   PetShop   *****");
        System.out.println("------------------------------");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar producto por ID");
        System.out.println("4) Actualizar producto");
        System.out.println("5) Eliminar producto");
        System.out.println("6) Salir");
        System.out.println("------------------------------");
        System.out.println("******************************");
    }

    //Operaciones de CRUD

    public void agregarProducto(){
        System.out.println("**** Nuevo Producto ****");
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoria: ");

        
        Producto p = new Producto(nombre, precio, stock, categoria);
        Producto guardado = service.guardar(p);
        System.out.println("Producto agregado con el id " + guardado.getId());
    }
    public void listarProductos(){
        List<Producto> lista = service.listarTodos();
        if (lista.isEmpty()){
            System.out.println("No hay productos cargados.");
            return;
        }

        System.out.println("****    Catálogo de Productos en Stock   *****");
        for (Producto p : lista){
            System.out.println(p);
        }

    }

    public void buscarProducto(){
        int id = Validador.leerEntero(sc, "Ingrese el id del producto: ");
        
        Producto p = service.obtenerPorId(id);
        System.out.println("Encontrado: " + p);
    }

    public void actualizarProducto(){
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a actualizar: ");

        Producto actual = service.obtenerPorId(id);
        System.out.println("Datos actuales: " + actual);

        System.out.println("**** Ingrese los nuevos datos ****");
        String nombre = Validador.leerTexto(sc,"Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoria: ");

        Producto datos = new Producto(nombre, precio, stock, categoria);
        Producto actualizado = service.actualizar(id, datos);

        System.out.println("Producto actualizado: " + actualizado);
    }

    public void eliminarProducto(){
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a eliminar: ");
        service.eliminar(id);
        System.out.println("Producto eliminado.");
    }

}