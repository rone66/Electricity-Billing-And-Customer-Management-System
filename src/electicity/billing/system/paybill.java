
package electicity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class paybill extends JFrame implements ActionListener {
    String meter;
    Choice cmonth;
    JButton pay,back;
    paybill(String meter){
     this.meter=meter;   
     setLayout(null);
     setBounds(300,150,900,600);
        
    JLabel heading=new JLabel("Electricity Bill");
    heading.setBounds(380, 5, 400, 30);
    heading.setFont(new Font("tahoma",Font.PLAIN,24));
    add(heading);   
     
    JLabel lblmetetno=new JLabel("Meter NO.");
    lblmetetno.setBounds(35, 80, 200, 20);
    lblmetetno.setFont(new Font("tahoma",Font.PLAIN,18));
    add(lblmetetno);
        
    JLabel metetnum=new JLabel("");
    metetnum.setBounds(150, 80, 100, 20);
    metetnum.setFont(new Font("tahoma",Font.PLAIN,18));
    add(metetnum); 
    
     
    JLabel lblname=new JLabel("Name");
    lblname.setBounds(35, 140, 200, 20);
    lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lblname);
    
    JLabel name=new JLabel("");
    name.setBounds(250, 140, 200, 20);
    add(name);
    
     JLabel lblmonth=new JLabel("Month");
     lblmonth.setBounds(35, 200, 200, 20);
     lblmonth.setFont(new Font("Tahoma",Font.PLAIN,18));
     add(lblmonth);
     
       cmonth=new Choice();
      cmonth.setBounds(250,200,150,20);
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
     
    JLabel lblunits=new JLabel("units");
    lblunits.setBounds(35, 260, 200, 20);
    lblunits.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lblunits);
    
    JLabel unit=new JLabel("");
    unit.setBounds(250, 260, 200, 20);
    add(unit);
    
    JLabel lbltotalbill=new JLabel("Total Bill");
    lbltotalbill.setBounds(35, 320, 200, 20);
    lbltotalbill.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lbltotalbill);
    
    JLabel totalbill=new JLabel("");
    totalbill.setBounds(250, 320, 200, 20);
    add(totalbill);
    
    JLabel lblstatus=new JLabel("Payment Status");
    lblstatus.setBounds(35, 380, 200, 20);
    lblstatus.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lblstatus);
    
    JLabel status=new JLabel("");
    status.setBounds(250, 380, 200, 20);
    status.setForeground(Color.red);
    add(status);
    
    try{
             conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"' ");
            while(rs.next()){
              metetnum.setText(rs.getString("meter_no"));
              name.setText(rs.getString("name"));
            }
             rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' and month ='"+cmonth.getSelectedItem()+"' ");
            while(rs.next()){
              unit.setText(rs.getString("units"));
              totalbill.setText(rs.getString("totalbill"));
              status.setText(rs.getString("status"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
    cmonth.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent ae){
              try{
             conn c=new conn();
             ResultSet rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' and month ='"+cmonth.getSelectedItem()+"' ");
            while(rs.next()){
              unit.setText(rs.getString("units"));
              totalbill.setText(rs.getString("totalbill"));
              status.setText(rs.getString("status"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
            
        }
    
    });
    
    
     pay=new JButton("Pay");
        pay.setBounds(100, 460, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);
    
    
        back=new JButton("Back");
        back.setBounds(230, 460, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/pb4.png"));
        Image i2= i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400, 120, 600, 300);
        add(image);
        
        
    setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
             try{
             conn c=new conn();
             c.s.executeUpdate("update bill set status='Paid' where meter_no='"+meter+"' and month ='"+cmonth.getSelectedItem()+"'");
            
             }catch(Exception e){
                  e.printStackTrace();
             }
             setVisible(false);
             //new paytm(meter);
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new paybill("");
    }
}
