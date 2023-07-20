package tienda.servicio;

import tienda.persistencia.fabricanteDao;

/**
 *
 * @author elias
 */
public class fabricanteService {

    private fabricanteDao dao;
    
    public fabricanteService(){
        this.dao = new fabricanteDao();
    }

    public void listarTodo(){
        try {
            dao.listarTodo();
        } catch (Exception e) {
            System.out.println("Error al traer los datos de fabricante" + e.getMessage());
        }
    }

}
