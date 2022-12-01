
package electicity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class customerdetail extends JFrame implements ActionListener{
    JButton print;
    JTable table;
    customerdetail(){
        super("Customer Detail");
        
        setSize(1200,650);
        setLocation(200,150);
        
       
        
        table=new JTable();
         
           try{
             conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
            
        }
       
        JScrollPane sp=new JScrollPane(table);
        add(sp);
         
        print=new JButton("Print");
        print.addActionListener(this);
        add(print,"South");
        
         setVisible(true);
    }
  public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }            
  }
    
     public static void main(String[] args){
        new customerdetail();
    }
}
