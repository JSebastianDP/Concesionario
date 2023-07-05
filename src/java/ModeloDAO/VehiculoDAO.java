/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.VehiculoVO;
import Util.ConexionBD;
import Util.Crud;
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
public class VehiculoDAO extends ConexionBD implements Crud {

    //1. Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    //se inicializan las variables en vacio
    private String vehPlaca = "", datId = "", catId = "", vehModelo = "", vehMarca = "", vehEstado = "", vehPrecio = "";

    public VehiculoDAO() {
    }

//2.Metodo constructor para recibir los datos VO
    public VehiculoDAO(VehiculoVO vehVO) {
        super();
//3.conectarse a la base de datos 

        try {
            conexion = this.obtenerConexion();
            //4.traer al DAO los datos del VO para hacer la operación

            vehPlaca = vehVO.getVehPlaca();
            datId = vehVO.getDatId();
            catId = vehVO.getCatId();
            vehModelo = vehVO.getVehModelo();
            vehMarca = vehVO.getVehMarca();
            vehEstado = vehVO.getVehEstado();
            vehPrecio = vehVO.getVehPrecio();

        } catch (Exception e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {

            sql = "insert into vehiculo(vehPlaca, datId, catId, vehModelo, vehMarca, vehEstado, vehPrecio) values (?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.setString(2, datId);
            puente.setString(3, catId);
            puente.setString(4, vehModelo);
            puente.setString(5, vehMarca);
            puente.setString(6, vehEstado);
            puente.setString(7, vehPrecio);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }

        }
        return operacion;
    }

    @Override
public boolean actualizarRegistro() {
        try {
            sql = "UPDATE vehiculo SET DATID = ?, CATID = ?, VEHMODELO = ?, VEHMARCA = ?, VEHESTADO = ?, VEHPRECIO = ? WHERE VEHPLACA = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datId);
            puente.setString(2, catId);
            puente.setString(3, vehModelo);
            puente.setString(4, vehMarca);
            puente.setString(5, vehEstado);
            puente.setString(6, vehPrecio);
            puente.setString(7, vehPlaca);
            puente.executeUpdate();
            operacion = true;
        } 
        catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {
            try {
                this.cerrarConexion();
            } 
            catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
   public boolean eliminarRegistro() {
        try {

            sql = "UPDATE vehiculo SET DATID=?, CATID=?, VEHMODELO=?, VEHMARCA=?, VEHESTADO=?, VEHPRECIO=? WHERE VEHPLACA=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datId);
            puente.setString(2, catId);
            puente.setString(3, vehModelo);
            puente.setString(4, vehMarca);
            puente.setString(5, vehEstado);
            puente.setString(6, vehPrecio);
            puente.setString(7, vehPlaca);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    public VehiculoVO consultarPlaca(String placa) {
        VehiculoVO vehVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "select * from vehiculo where VEHPLACA=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, placa);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                vehVO = new VehiculoVO(mensajero.getString("VEHPLACA"), mensajero.getString("DATID"), mensajero.getString("CATID"), mensajero.getString("VEHMODELO"), mensajero.getString("VEHMARCA"), mensajero.getString("VEHESTADO"), mensajero.getString(7));
            }

        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return vehVO;
    }

    public ArrayList<VehiculoVO> listar() {

        ArrayList<VehiculoVO> listaVehiculos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from vehiculo";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                VehiculoVO vehVO = new VehiculoVO(mensajero.getString("VEHPLACA"), mensajero.getString("DATID"), mensajero.getString("CATID"), mensajero.getString("VEHMODELO"), mensajero.getString("VEHMARCA"), mensajero.getString("VEHESTADO"), mensajero.getString("VEHPRECIO"));
                listaVehiculos.add(vehVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return listaVehiculos;
    }
}
