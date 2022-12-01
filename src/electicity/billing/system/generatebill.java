
package electicity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class generatebill extends JFrame implements ActionListener {
   String meter;
   JButton bill;
   Choice cmonth;
   JTextArea area;
    generatebill(String meter){
        this.meter=meter;
        setSize(500,800);
        setLocation(550,30);
        
        setLayout(new BorderLayout());
        
        JPanel p1= new JPanel();
        
        JLabel heading=new JLabel("Generate Bill");
        JLabel meternum=new JLabel(meter);
         
       cmonth=new Choice();
        cmonth.setBounds(520,20,150,20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        
        add(cmonth);
        
       area=new JTextArea(50,15);
        area.setFont(new Font("senserif",Font.ITALIC,18));
        area.setText("\n\n\t---------Click on the--------\n\t press Generate Bill button to get\n\t the bill of the Selected Month");
        
        
        JScrollPane pane=new JScrollPane(area);
        
        bill=new JButton("Generate Bill");
        bill.addActionListener(this);
        
        p1.add(heading);
        p1.add(meternum);
        p1.add(cmonth);
        add(p1,"North");
        
        add(pane,"Center");
        add(bill,"South");
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bill){
             try{
                conn c=new conn();
                String month=cmonth.getSelectedItem();
                area.setText("      WestBengal Power Distribution Corporation Limited\n\n\tELECTRIC BILL GENERATED FOR\n\tTHE MONTHOF"+month+",2022 ");
                
                ResultSet rs=c.s.executeQuery("select * from customer Where meter_no='"+meter+"' ");
                if(rs.next()){
                    area.append("\n \n    Customer name: "+ rs.getString("name"));
                    area.append("\n     Meter Number:  "+ rs.getString("meter_no"));
                    area.append("\n     Address:             "+ rs.getString("address"));
                    area.append("\n     State:                  "+ rs.getString("state"));
                    area.append("\n     City:                    "+ rs.getString("city"));
                    area.append("\n     Email:                 "+ rs.getString("email"));
                    area.append("\n     Phno:                 "+ rs.getString("phno"));
                    area.append("\n     ------------------------------------------------------------     ");
                }
                
                 rs=c.s.executeQuery("select * from meter_info Where meter_no='"+meter+"' ");
                if(rs.next()){
                    area.append("\n \n    Meter Location:     "+ rs.getString("meter_location"));
                    area.append("\n       Meter Type:       "+ rs.getString("meter_type"));
                    area.append("\n       Phase Code:      "+ rs.getString("phase_code"));
                    area.append("\n       Billtype:              "+ rs.getString("bill_type"));
                    area.append("\n       Days:                 "+ rs.getString("days"));
                    area.append("\n     ------------------------------------------------------------     ");
                    area.append("\n     ------------------------------------------------------------     ");
                }  
                
                  rs=c.s.executeQuery("select * from tax  ");
                if(rs.next()){
                    area.append("\n\n     Cost Per Unit:                  "+ rs.getString("cost_per_unit"));
                    area.append("\n       Meter Rent:                 "+ rs.getString("meter_rent"));
                    area.append("\n       Service Charge:         "+ rs.getString("service_charge"));
                    area.append("\n       Service Tax:               "+ rs.getString("service_tax"));
                    area.append("\n       Fixed Tax:                  "+ rs.getString("fixed_tax"));
                    area.append("\n       Swaach Barat Cess:    "+ rs.getString("swacch_bharat_cess"));
                    area.append("\n     ------------------------------------------------------------     ");
        
                }  
                
                   rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' and month='"+month+"'");
                if(rs.next()){
                    area.append("\n\n     Current Month:                  "+ rs.getString("month"));
                    area.append("\n       Unit Consumed:                 "+ rs.getString("units"));
                    area.append("\n       Total Charges:                "+ rs.getString("totalbill"));
                    
                    area.append("\n     ------------------------------------------------------------     ");
                      area.append("\n     Total Payeble:    "+ rs.getString("totalbill"));
                }  
                
                }catch(Exception e){
                        e.printStackTrace();
                    }            
            
            
            
        }
        
    }
    
    
    public static void main(String[] args){
        new generatebill("");
    }
}
