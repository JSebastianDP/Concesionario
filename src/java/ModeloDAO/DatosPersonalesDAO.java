/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DatosPersonalesVO;
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
 * @author User
 */
public class DatosPersonalesDAO extends ConexionBD {

    //1. Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    //se inicializan las variables en vacio
    private String datId = "", usuId = "", datNombre = "", datApellido = "", datTipoId = "",
            datNumeroId = "", datTelefono = "", datCorreo = "";

    public DatosPersonalesDAO() {
    }
//2.Metodo constructor para recibir los datos VO

    public DatosPersonalesDAO(DatosPersonalesVO datVO) {
        super();
        //3.conectarse a la base de datos 
        try {
            conexion = this.obtenerConexion();

            datId = datVO.getDatId();
            usuId = datVO.getUsuId();
            datNombre = datVO.getDatNombre();
            datApellido = datVO.getDatApellido();
            datTipoId = datVO.getDatTipoId();
            datNumeroId = datVO.getDatNumeroId();
            datTelefono = datVO.getDatTelefono();
            datCorreo = datVO.getDatCorreo();

        } catch (Exception e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<DatosPersonalesVO> DatosP(String datId) {

        ArrayList<DatosPersonalesVO> ListarDatos = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM datospersonales WHERE datospersonales.DATID=?";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                DatosPersonalesVO datVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                ListarDatos.add(datVO);
            }
        } catch (Exception e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return ListarDatos;

    }

    public DatosPersonalesVO consultarDatos(String datId) {
        DatosPersonalesVO datVO = null;
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM datospersonales INNER JOIN vehiculo ON vehiculo.DATID = datospersonales.DATID WHERE datospersonales.DATID=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datId);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                datVO = new DatosPersonalesVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),
                        mensajero.getString(4), mensajero.getString(5), mensajero.getString(6),
                        mensajero.getString(7), mensajero.getString(8));
            }

        } catch (SQLException e) {
            Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(DatosPersonalesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return datVO;

    }

}
