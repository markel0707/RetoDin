/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Usuario;

/**
 *
 * @author 2dam
 */
public interface DataAccessible {
    public Usuario consultarUsu() throws Exception;
}
