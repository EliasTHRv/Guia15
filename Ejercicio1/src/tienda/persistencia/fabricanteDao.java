package tienda.persistencia;

import tienda.entidades.Fabricante;

/**
 *
 * @author Elias Barreto
 */
public final class fabricanteDao extends DAO{
    
    public void guardarFabricante(Fabricante f) throws Exception {
        try {
            if (f == null) {
                throw new Exception("Debe indicar un fabricante");
            }

            String sql = "INSERT INTO fabricante(codigo, nombre)"
                    + "VALUES ( '" + f.getCodigo() + "' , '" + f.getNombre() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void modificarFabricante(Fabricante f) throws Exception {
        try {
            if (f == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }

            String sql = "UPDATE fabricante SET"
                    + "codigo = '" + f.getCodigo() + "' ,WEHE nombre '" + f.getNombre() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarFabricante(String nombre) throws Exception {
        try {
            String sql = "DELETE FROM fabricante WHERE nombre ='" + nombre + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM fabricante"
                    + " WHERE nombre = '" + nombre + "'";
            consultarBase(sql);

            Fabricante fabricante = null;

            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public void listarTodo() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);
            System.out.printf("%-6s %-35s\n", "CODIGO", "NOMBRE");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-6d %-35s\n",
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}


