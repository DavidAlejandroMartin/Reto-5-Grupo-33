/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;


/**
 *
 * @author alejo
 */
public class Conexion {
    private static final String Ubicacion="ProyectosConstruccion.db";
    
    String url = "jdbc:sqlite:" + Ubicacion;
    
    Connection conn = null;
    public Conexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexion establecida");
                    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ResultSet consultarRegistros(String url){
        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println("e");
            return null;
        }
    } 
    
    
    
}
