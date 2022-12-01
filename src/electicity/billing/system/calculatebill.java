
package electicity.billing.system;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;



public class calculatebill extends JFrame implements ActionListener{
    Choice meternum,month;
    JTextField tfunit;
    JButton submit,cancel; 
    JLabel lblname,madd,add,pic;
    Blob blob;
    
    calculatebill() {
        
        setSize(800,600);
        setLocation(420,100);
        
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(300, 30, 400, 25);
        heading.setFont(new Font("tahoma",Font.PLAIN,24));
        p.add(heading);
        
        pic=new JLabel("                Image");
        pic.setBounds(450, 90, 150, 150);
        pic.setBorder(new LineBorder(Color.BLACK));
        pic.setBackground(Color.WHITE);
        pic.setLayout(null);
        pic.setForeground(new Color(36,155,36));
        p.add(pic);
        
           
        JLabel lblmetetno=new JLabel("Meter NO.");
        lblmetetno.setBounds(50, 80, 100, 20);
        lblmetetno.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblmetetno);
        
        meternum=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternum.add(rs.getString("meter_no"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        meternum.setBounds(150, 80, 200, 20);
        p.add(meternum); 
        
        
        
        JLabel name=new JLabel("Name");
        name.setBounds(50, 120, 150, 20);
        name.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(name);
        
        
        lblname=new JLabel("");
        lblname.setBounds(200, 120, 150, 20);
        p.add(lblname);
        
        
        madd=new JLabel("Adress");
        madd.setBounds(50, 160, 150, 20);
        madd.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(madd);
        
        
        add=new JLabel("");
        add.setBounds(200, 160, 200, 20);
        p.add(add);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer Where meter_no='"+meternum.getSelectedItem()+"'");
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                add.setText(rs.getString("address"));
                 blob=rs.getBlob("customer_pic");
                InputStream in=blob.getBinaryStream();
                BufferedImage image=ImageIO.read(in);
                ImageIcon i1=new ImageIcon(image);
                Image img=i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                pic.setIcon(new ImageIcon(img));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        meternum.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from customer Where meter_no='"+meternum.getSelectedItem()+"'");
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        add.setText(rs.getString("address"));
                        blob = rs.getBlob("customer_pic");
                        InputStream in = blob.getBinaryStream();
                        BufferedImage image = ImageIO.read(in);
                        ImageIcon i1 = new ImageIcon(image);
                        Image img = i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        pic.setIcon(new ImageIcon(img));
                    }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
    });
        
        JLabel phase=new JLabel("Unit Consumed");
        phase.setBounds(50, 200, 150, 20);
        phase.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(phase);
        
        
        tfunit=new JTextField();
        tfunit.setBounds(200, 200, 150, 20);
        p.add(tfunit);
        
        
        JLabel tfmonth=new JLabel("month");
        tfmonth.setBounds(50, 240, 150, 20);
        tfmonth.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(tfmonth);
        
         month=new Choice();
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        month.setBounds(200, 240, 150, 20);
        p.add(month);
        
         JLabel dy=new JLabel("Days");
        dy.setBounds(50, 280, 150, 20);
        dy.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(dy);
        
         JLabel day=new JLabel("30 Days");
        day.setBounds(150, 280, 150, 20);
        day.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(day);
        
         JLabel dE=new JLabel("**By Default Bill is Calculated for 30 days only**");
        dE.setBounds(200, 360, 400, 20);
        dE.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(dE);
        
        submit=new JButton("Submit");
        submit.setBounds(290, 420, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(420, 420, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String meter=meternum.getSelectedItem();
            String unit=tfunit.getText();
            String month1=month.getSelectedItem();
            
            int totalbill=0;
            int unit_consumed=Integer.parseInt(unit);
            String query="select * from tax";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    totalbill=unit_consumed*Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                    totalbill+=Integer.parseInt(rs.getString("service_charge"));
                    totalbill+=Integer.parseInt(rs.getString("service_tax"));
                    totalbill+=Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
                 
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            String query2="insert into bill values('"+meter+"','"+month1+"','"+unit+"','"+totalbill+"','Not Paid')";
             try{
                conn c=new conn();
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Bill Updated successfully *");
                setVisible(false);
               
             }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            
        }
            
              
            
    }
    
    
    public static void main(String[] args){
        new calculatebill();
    }
}
