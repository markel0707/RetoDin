/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Usuario;
import controlador.DataAccessible;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class DBUserDataAccesor implements DataAccessible {

    private Connection con;
    private PreparedStatement stmt;

    private ResourceBundle configFichero;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;
    private String id;

    final String consultarusuario = "select * from usuario";

    /**
     * Constructor de DaoImplementacionBD. Inicializa los parámetros de conexión
     * a la base de datos a partir de un archivo de configuración.
     */
    public DBUserDataAccesor() {
        this.configFichero = ResourceBundle.getBundle("modelo.config");
        this.driverBD = this.configFichero.getString("Driver");
        this.urlBD = this.configFichero.getString("Conn");
        this.userBD = this.configFichero.getString("DBUser");
        this.passwordBD = this.configFichero.getString("DBPass");
    }

    // Este método sirve para abrir la conexion
    /**
     * Abre la conexión a la base de datos.
     */
    public void openConnection() {
        try {
            con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Se ha abierto la base de datos");
            e.printStackTrace();
        }
    }

    /**
     * Cierra la conexión a la base de datos y el PreparedStatement si están
     * abiertos.
     *
     * @throws SQLException si ocurre un error al cerrar la conexión o el
     * PreparedStatement.
     */
    // Este metodo sirve para cerrar la conexion
    private void closeConnection() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public Usuario consultarUsu() {
        this.openConnection();
        Usuario usu = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(consultarusuario);
            rs = stmt.executeQuery();
            usu = new Usuario();
            usu.setDni(rs.getString(1));
            usu.setNombre(rs.getString(2));
            usu.setApellido(rs.getString(3));
            usu.setNumTel(Integer.parseInt(rs.getString(4)));
            System.out.println("Hola mi usu es " + usu);        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usu;
    }

}
