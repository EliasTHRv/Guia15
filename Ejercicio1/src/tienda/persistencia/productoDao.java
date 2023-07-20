package tienda.persistencia;

import tienda.entidades.Producto;

/**
 *
 * @author Elias Barreto
 */
public final class productoDao extends DAO {

    public void guardarProducto(Producto p) throws Exception {
        try {
            if (p == null) {
                throw new Exception("Debe indicar un producto");
            }

            String sql = "INSERT INTO producto(codigo, nombre,precio,codigo_fabricante)"
                    + "VALUES ( '" + p.getCodigo() + "' , '" + p.getNombre() + "' , '" + p.getPrecio() + "' , '"
                    + p.getCodigoFabricante() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
           
            String sql = "UPDATE producto SET nombre='" + producto.getNombre()
            + "', precio=" + producto.getPrecio()
            + " WHERE codigo=" + producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo ='" + codigo + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM producto"
                    + " WHERE nombre = '" + nombre + "'";
            consultarBase(sql);

            Producto producto = null;

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    /*
     * a) Lista el nombre de todos los productos que hay en la tabla producto.
     * b) Lista los nombres y los precios de todos los productos de la tabla
     * producto.
     * c) Listar aquellos productos que su precio esté entre 120 y 202.
     * d) Buscar y listar todos los Portátiles de la tabla producto.
     * e) Listar el nombre y el precio del producto más barato.
     * f) Ingresar un producto a la base de datos.
     * g) Ingresar un fabricante a la base de datos
     * h) Editar un producto con datos a elección.
     */

     
    public void listarTodo() throws Exception {
        try {
            String sql = "SELECT * FROM producto";
            consultarBase(sql);
            System.out.printf("%-6s %-35s %-10s %-15s\n", "CODIGO", "NOMBRE", "PRECIO", "COD_FABRICANTE");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-6d %-35s %-10.2f %-15d\n",
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getInt("codigo_fabricante"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void listarNombre() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);
            System.out.printf("%-6s\n", "NOMBRE");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.println(resultado.getString("nombre"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void listarNombresPrecios() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);
            System.out.printf("%-35s %-6s\n", "NOMBRE", "PRECIO");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-35s %-6s\n", resultado.getString("nombre"), resultado.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void listarPreciosEntre() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio > 120 AND precio < 202";
            consultarBase(sql);
            System.out.printf("%-35s %-6s\n", "NOMBRE", "PRECIO");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-35s %-6s\n", resultado.getString("nombre"), resultado.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void listarPrecioMasBarato() throws Exception {
        try {
            String sql = "SELECT * FROM producto ORDER BY precio ASC LIMIT 1";
            consultarBase(sql);
            System.out.printf("%-6s %-35s %-10s %-15s\n", "CODIGO", "NOMBRE", "PRECIO", "COD_FABRICANTE");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-6d %-35s %-10.2f %-15d\n",
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getInt("codigo_fabricante"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE 'portatil%' ";
            consultarBase(sql);
            System.out.printf("%-6s %-35s %-10s %-15s\n", "CODIGO", "NOMBRE", "PRECIO", "COD_FABRICANTE");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                   System.out.printf("%-6d %-35s %-10.2f %-15d\n",
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getInt("codigo_fabricante"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }



}
