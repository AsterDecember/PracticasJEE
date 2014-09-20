/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package class2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aster
 */
public class Querys extends Conexion{
    String consulta="";
    
    public boolean AUtenticacion(String user,String pass) throws SQLException{
        boolean opt=false;
        Statement st=con.createStatement();
        consulta="Select * from Empleados";
        ResultSet rs= st.executeQuery(consulta);
        
        while(rs.next()){
            if(user.equals(rs.getString("usuario"))&& pass.equals(rs.getString("password"))){
                opt=true;
                break;
            }
            
        }
        
      
        
        return opt;
    }
      public void Insertar(int id,String user, String pass) throws SQLException{
          Statement st= con.createStatement();
          consulta="Insert Into Empleados values("+id+",'"+user+"','"+pass+"')";
          st.execute(consulta);
      }
      public void Actualiza(int id,String user,String pass) throws SQLException{
          Statement st= con.createStatement();
          consulta="Update Empleados Set usuario = '"+user+"',password = '"+pass+"' where id_empleado = '"+id+"';";
          st.execute(consulta);

      }
      
      
      public ResultSet getalldates() throws SQLException
      {
          ResultSet rs = null;
          
          Statement st= con.createStatement();
          consulta="Select * from Empleados";
          rs = st.executeQuery(consulta);
          
          return rs;    
      }
      
      
   public void Delete(String id_empleado) throws SQLException
   {
       
       Statement st= con.createStatement();
          consulta="Delete from Empleados where id_empleados ='"+id_empleado+"';";
          st.execute(consulta);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
      
      
}
