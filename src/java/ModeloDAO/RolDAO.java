/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SENA
 */
public class RolDAO extends ConexionBD {
    //Declarar variables y/o objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    private String rolId = "", rolTipo = "";
    
 UsuarioVO usuVO = new UsuarioVO();

    public RolDAO() {
    }
    
     public RolDAO(RolVO rolVO) {
        super();

        try {
            conexion = this.obtenerConexion();

            rolId = rolVO.getRolId();
            rolTipo = rolVO.getRolTipo();
            
        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    public ArrayList<RolVO> rol(String usuLogin) {

        ArrayList<RolVO> listaRoles = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT usuario.USUID, rol.ROLTIPO FROM rol INNER JOIN usuario_rol ON rol.ROLID = usuario_rol.ROLID INNER JOIN  usuario ON usuario_rol.USUID = usuario.USUID WHERE usuario.USULOGIN =?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                RolVO rolVO = new RolVO(mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(rolVO);
            }

        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaRoles;

    }
}
