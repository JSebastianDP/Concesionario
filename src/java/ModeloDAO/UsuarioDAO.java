/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.ConexionBD;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SENA
 */
public class UsuarioDAO extends ConexionBD implements Crud {

    //1. Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String usuId = "", usuLogin = "", usuPassword = "";

    //2.Metodo constructor para recibir los datos VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        //3.conectarse a la base de datos 

        try {

            conexion = this.obtenerConexion();
            //4.traer al DAO los datos del VO para hacer la operación

            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();

        } catch (Exception e) {

        }

    }

    @Override
    public boolean agregarRegistro() {
        try {

            sql = "insert into usuario(usuLogin, usuPassword) values (?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion = true;
            
            

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update usuario set usuLogin = ?,usuPassword =? WHERE usuId=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {
            sql = "DELETE FROM `usuario` WHERE usuId = ? ";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public boolean iniciarSesion(String usuario, String clave) {

        try {

            conexion = this.obtenerConexion();
            sql = "select*from usuario where usulogin =? and usupassword =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                operacion = true;
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }


}
