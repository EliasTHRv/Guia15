package tienda.mainTienda;

// import tienda.servicio.fabricanteService;
import tienda.servicio.productoService;

public class mainT {
    public static void main(String[] args) {

        productoService p1 = new productoService();
        // fabricanteService f1 = new fabricanteService();

        // p1.listarTodo();
        // System.out.println("\n");
        // p1.listarNombre();
        // System.out.println("\n");
        // p1.listarNombresPrecios();
        // System.out.println("\n");
        // p1.listarPreciosEntre();
        // System.out.println("\n");
        // p1.listarPrecioMasBarato();
        // System.out.println("\n");
        // p1.listarPortatiles();
        // System.out.println("\n");
        // p1.modificarProducto();
        // System.out.println("\n");
        // p1.guardarProducto();
        System.out.println("\n");
        p1.eliminarProducto();
        System.out.println("\n");
        p1.listarTodo();

    }
}
