
package electicity.billing.system;

import java.sql.*;

public class conn {
    Connection C;
    Statement s;
   
    conn(){
         try{
            C = DriverManager.getConnection("jdbc:mysql:///ebs","root","arnab@1995");
            s=C.createStatement();
            
         }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
       
    }
}
