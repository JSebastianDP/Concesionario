/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SENA
 */
public class ConexionBD {
    
    //Declarar Variables y Objetos  paso 1
    private String driver,userDB, passwordDB,dataBase, urlDB; //ELEMENTOS QUE SE REQUIEREN PARA LA BASE DE DATOS 
    private Connection conexion;
    
    public ConexionBD(){
        //2.Asignar valores 
        driver="com.mysql.jdbc.Driver"; 
        userDB="root";
        passwordDB="";
        dataBase="concesionario";
        urlDB="jdbc:mysql://localhost:3306/"+dataBase;
        
        //3.conectar base de datos
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlDB, userDB, passwordDB);
            System.out.println("Conexion OK!");
            
        } catch (Exception e) {
            System.out.println("Error al Conectar" + e.toString());
        }
    
    }
    
    public Connection obtenerConexion(){
        
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion .close();
        conexion=null;
        return conexion;
    }
    
    public static void main(String[] args) {
        new ConexionBD();
    }
}
