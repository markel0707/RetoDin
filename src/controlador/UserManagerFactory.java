/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.FileUserDataAccessible;
import modelo.DBUserDataAccesor;
import controlador.DataAccessible;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {
    public static DataAccessible getDataAccesible() {
        String tipoConsulta = ResourceBundle.getBundle("reto0markelandoni.Propiedades").getString("implementacion");
        if ("archivo".equals(tipoConsulta)) {
            return new FileUserDataAccessible();
        } else if ("database".equals(tipoConsulta)) {
            return new DBUserDataAccesor();
        } else {
            throw new IllegalArgumentException("No se encuentra el dao");
        }
    }
}
