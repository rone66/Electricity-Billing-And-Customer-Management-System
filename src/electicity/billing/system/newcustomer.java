
package electicity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.sql.PreparedStatement;

public class newcustomer extends JFrame implements ActionListener{
    JTextField name,address,state,city,pin,email,phno,addhr;
    JLabel addpic,addpic1,meter;
    JButton addimg,addimg1,next,cancel;
    byte[]person_image=null;
    byte[]person_doc=null;
    String filename=null;
    String filename1=null;
    File f=null;
    File f1=null;
    JFileChooser chooser1,chooser2;
    FileInputStream fis,fis1;
   // Random ran;
    newcustomer(){
        setSize(1100,800);
        setLocation(200,20);
       
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("New Customer");
        heading.setBounds(450, 30, 200, 20);
        heading.setFont(new Font("tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(90, 80, 200, 20);
        lblname.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblname);
        
        name=new JTextField();
        name.setBounds(160, 80, 150, 20);
        p.add(name);
        
        JLabel meterno=new JLabel("Meter no.");
        meterno.setBounds(90, 140, 200, 20);
        meterno.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(meterno);
        
        meter=new JLabel("");
        meter.setBounds(200, 140, 100, 20);
        meter.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(meter);
        
        Random ran=new Random();
        long number=ran.nextLong()% 100000;
        meter.setText("" + Math.abs(number));
                
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(90, 200, 200, 20);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lbladdress);
        
        address=new JTextField();
        address.setBounds(200, 200, 150, 20);
        p.add(address);
        
        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(90, 260, 200, 20);
        lblstate.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblstate);
        
        state=new JTextField();
        state.setBounds(200, 260, 150, 20);
        p.add(state);
        
        JLabel lblcity=new JLabel("city");
        lblcity.setBounds(90, 320, 200, 20);
        lblcity.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblcity);
        
        city=new JTextField();
        city.setBounds(200, 320, 150, 20);
        p.add(city);
        
        JLabel lblpin=new JLabel("Pincode");
        lblpin.setBounds(90, 380, 200, 20);
        lblpin.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblpin);
        
        pin=new JTextField();
        pin.setBounds(200, 380, 150, 20);
        p.add(pin);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(90, 440, 200, 20);
        lblemail.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblemail);
        
        email=new JTextField();
        email.setBounds(200, 440, 150, 20);
        p.add(email);
        
        JLabel lblphno=new JLabel("Phone no");
        lblphno.setBounds(90, 500, 200, 20);
        lblphno.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblphno);
        
        phno=new JTextField();
        phno.setBounds(200, 500, 150, 20);
        p.add(phno);
        
        JLabel lbladdhar=new JLabel("Addhar no");
        lbladdhar.setBounds(90, 560, 200, 20);
        lbladdhar.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lbladdhar);
        
        addhr=new JTextField();
        addhr.setBounds(200, 560, 150, 20);
        p.add(addhr);
        
        
        addpic=new JLabel();
        addpic.setBounds(650,70,150,150);
        addpic.setBorder(new LineBorder(Color.BLACK));
        addpic.setBackground(Color.WHITE);
        addpic.setLayout(null);
        addpic.setForeground(new Color(36,155,36));
        p.add(addpic);
        
        addimg=new JButton("Add Customer Image");
        addimg.setBounds(640, 250, 170, 30);
        addimg.setBackground(Color.BLACK);
        addimg.setForeground(Color.WHITE);
        addimg.addActionListener(this);
        p.add(addimg);
        
        addpic1=new JLabel();
        addpic1.setBounds(570,350,350,150);
        addpic1.setBorder(new LineBorder(Color.BLACK));
        addpic1.setBackground(Color.WHITE);
        addpic1.setLayout(null);
        addpic1.setForeground(new Color(36,155,36));
        p.add(addpic1);
        
        addimg1=new JButton("Attach Document");
        addimg1.setBounds(660, 520, 170, 30);
        addimg1.setBackground(Color.BLACK);
        addimg1.setForeground(Color.WHITE);
        addimg1.addActionListener(this);
        p.add(addimg1);
        
        next=new JButton("Next");
        next.setBounds(400, 620, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(530, 620, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
         setVisible(true);
    } 
         public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==next){
                /*String cname=name.getText();
                String cadd=address.getText();
                String cstate=state.getText();
                String ccity=city.getText();
                String cpin=pin.getText();
                String cemail=email.getText();
                String cph=phno.getText();
                String caddhr=addhr.getText();*/
                String cmeter=meter.getText();
                try{
                conn c=new conn(); 
              
                String query3="insert into customer(name,meter_no,address,state,city,pincode,email,phno,addharno,customer_pic,customer_doc_pic)values(?,?,?,?,?,?,?,?,?,?,?)";
                String query2="insert into login(meter_no,username,name,password,acctype,prfl_pic) values(?,?,?,?,?,?)";
                PreparedStatement pst=c.C.prepareStatement(query3);
                PreparedStatement pst1=c.C.prepareStatement(query2);
                //for query3
                pst.setString(1,name.getText() );
                pst.setString(2, meter.getText());
                pst.setString(3, address.getText());
                pst.setString(4,state.getText() );
                pst.setString(5, city.getText());
                pst.setString(6, pin.getText());
                pst.setString(7, email.getText());
                pst.setString(8,phno.getText() );
                pst.setString(9,addhr.getText() );
                pst.setBytes(10,person_image);
                pst.setBytes(11,person_doc);
                //for query2
                pst1.setString(1, meter.getText());
                pst1.setString(2, "");
                pst1.setString(3, name.getText());
                pst1.setString(4, "");
                pst1.setString(5, "");
                pst1.setBytes(6, person_image);
                
                
                
                pst.executeUpdate();
                pst1.executeUpdate();
                JOptionPane.showMessageDialog(null, "Account updated successfully *");
                setVisible(false);
                new meterinfo(cmeter);
                }catch(Exception e){
                    e.printStackTrace();
                }
                 
             }else if(ae.getSource()==addimg){
                 
                 chooser1=new JFileChooser();
                 int l=chooser1.showOpenDialog(null);
            
            
                if(l==chooser1.APPROVE_OPTION){
                    f=chooser1.getSelectedFile();
                    filename=f.getAbsolutePath();
                    ImageIcon i1=new ImageIcon(filename);
                    Image img=i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    addpic.setIcon(new ImageIcon(img));
            
                    try{
                        File image = new File(filename);
                        fis= new FileInputStream(image);
                        ByteArrayOutputStream bos=new ByteArrayOutputStream();
                        byte[] buf1=new byte[1024];
                
                        for(int readnum;(readnum=fis.read(buf1))!=-1;){
                        bos.write(buf1,0,readnum);
                    }
                     person_image=bos.toByteArray();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                }
            }
             }else if(ae.getSource()==addimg1){
                
                 chooser2=new JFileChooser();
                 int l1=chooser2.showOpenDialog(null);
            
            
                if(l1==chooser2.APPROVE_OPTION){
                    f1=chooser2.getSelectedFile();
                    filename1=f1.getAbsolutePath();
                    ImageIcon i2=new ImageIcon(filename1);
                    Image img1=i2.getImage().getScaledInstance(350, 150, Image.SCALE_SMOOTH);
                    addpic1.setIcon(new ImageIcon(img1));
            
                    try{
                        File image = new File(filename1);
                        fis1= new FileInputStream(image);
                        ByteArrayOutputStream bos=new ByteArrayOutputStream();
                        byte[] buf2=new byte[1024];
                
                        for(int readnum;(readnum=fis1.read(buf2))!=-1;){
                        bos.write(buf2,0,readnum);
                    }
                    person_doc=bos.toByteArray();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }else{
                
                 setVisible(false); 
             }
         }
    
    public static void main(String[] args){
        new newcustomer();
    }
    
}
