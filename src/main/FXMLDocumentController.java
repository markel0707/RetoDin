/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.UserManagerFactory;
import clases.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 2dam
 */
public class FXMLDocumentController implements Initializable {
    Usuario usu;
    @FXML
    private Label label;
    
    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtTelefono;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        try {
            Usuario usu = UserManagerFactory.getDataAccesible().consultarUsu();
            txtDni.setText(usu.getDni());
            txtNombre.setText(usu.getNombre());
            txtApellido.setText(usu.getApellido());
            txtTelefono.setText(String.valueOf(usu.getNumTel()));
            
        } catch (Exception ex) {
            Logger.getLogger("reto0markelandoni").severe(ex.getLocalizedMessage());
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
