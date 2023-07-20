package tienda.servicio;

import tienda.entidades.Producto;
import tienda.persistencia.productoDao;

/**
 *
 * @author elias
 */
public class productoService {

    private productoDao dao;

    public productoService() {
        this.dao = new productoDao();
    }

    public void listarTodo() {
        try {
            dao.listarTodo();

        } catch (Exception e) {
            System.out.println("Error al listr todos los productos" + e.getMessage());
        }
    }

    public void listarNombre() {
        try {
            dao.listarNombre();
        } catch (Exception e) {
            System.out.println("Error al obtener el nombre del producto" + e.getMessage());
        }
    }

    public void listarNombresPrecios() {
        try {
            dao.listarNombresPrecios();
        } catch (Exception e) {
            System.out.println("Error al obtener los nombres y precios del los productos" + e.getMessage());
        }
    }

    public void listarPreciosEntre() {
        try {
            dao.listarPreciosEntre();
        } catch (Exception e) {
            System.out.println("Error al obtener precio entre 120 y 202" + e.getMessage());
        }
    }

    public void listarPortatiles() {
        try {
            dao.listarPortatiles();
        } catch (Exception e) {
            System.out.println("Error al obtener los portatiles " + e.getMessage());
        }
    }

    public void listarPrecioMasBarato() {
        try {
            dao.listarPrecioMasBarato();
        } catch (Exception e) {
            System.out.println("Error al obtener el producto mas barato " + e.getMessage());
        }
    }

    public void guardarProducto(){
        try {
            Producto p = new Producto(0, "Mouse", 50, 3);
            dao.guardarProducto(p);
        } catch (Exception e) {
            System.out.println("Error al guardar producto " + e.getMessage());
        }
    }

    public void modificarProducto() {
        try {
            Producto p = new Producto(10, "Disquette", 300, 2);
            dao.modificarProducto(p);
        } catch (Exception e) {
            System.out.println("Error al modificar el producto " + e.getMessage());
        }
    }

    public void eliminarProducto(){
        try {
           int codigo = 12;
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
           System.out.println("Error al eliminar un producto ");
           e.printStackTrace();
        }
    }

}
