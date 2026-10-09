package service;

import java.util.ArrayList;
import java.util.List;

import exception.ProductoNoEncontradoException;
import model.Producto;
import util.Validador;

public class ProductoService {
    
    private List <Producto> productos = new ArrayList<>();
    
    private static int contadorId = 1;

    // Operaciones CRUD(crear, leer, actualizar, eliminar)

    // Crear Producto
    public Producto guardar (Producto p){
        // validamos antes de guardar. Si algo esta mal, se lanza excepcion y no se agrega el producto a la lista

        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        //El id lo asigna el servicio, no el usuario
        //Despues de asignarlo, incrementamos el contador

        p.setId(contadorId);
        contadorId++;

        productos.add(p);

        return p;

    }

    // Devuelve toda la lista de productos
    public List<Producto> listarTodos(){
        return productos; 
    }
    
    // Buscar un producto por ID

    public Producto obtenerPorId(int id){
        for (Producto p : productos){
            if(p.getId() == id){
                return p;
            }
        }

        throw new ProductoNoEncontradoException("No se encontró un producto con el ID " + id);
    }

    // Actualizar los datos de un producto existente
    public Producto actualizar(int id, Producto datos){
        // reutilizamos obtenerPorId, si lanza excepcion la actualizacion se cancela
        Producto p= obtenerPorId(id);

        // validamos datos antes de aplicarlos
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());

        // modificamos el producto encontrado

        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;

    }

    // Eliminar un producto por ID
    public void eliminar(int id){
        Producto p = obtenerPorId(id);
        productos.remove(p);
    }

}
