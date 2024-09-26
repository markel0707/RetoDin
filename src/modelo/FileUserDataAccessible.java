/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import clases.Usuario;
import controlador.DataAccessible;
import java.util.logging.Logger;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class FileUserDataAccessible implements DataAccessible {

    @Override
    public Usuario consultarUsu() {
        Usuario usu = new Usuario();
        ResourceBundle bundle = ResourceBundle.getBundle("reto0markelandoni.userDataFile");
        
        usu.setDni(bundle.getString("dni"));
        usu.setNombre(bundle.getString("nombre"));
        usu.setApellido(bundle.getString("apellido"));
        
        try {
            int numeroTelefono = Integer.parseInt(bundle.getString("numTel"));
            usu.setNumTel(numeroTelefono);
        } catch (NumberFormatException e) {
            Logger.getLogger("reto0markelandoni").severe(e.getLocalizedMessage());
        }
        
        
        return usu;
    }
    
}
