
package electicity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.border.*;
import java.sql.*;
import javax.imageio.ImageIO;

public class signup extends JFrame implements ActionListener{
    byte[] person_image=null;
    String filename=null;
    File f=null;
    //private ImageIcon format=null;
    JButton creat,back,addimg;
    JLabel panel1,lblmeterno;
    JFileChooser chooser;
    Choice actype;
    JTextField meterno,username,name,password;
    FileInputStream fis;
    Blob blob;
    signup(){
      
        setBounds(350,150,800,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout (null);
        
        JPanel panel=new JPanel();
        panel.setBounds(20,30,750,400);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(176,216,230),2),"Creat-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(176,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(36,155,36));
        add(panel);
        
        panel1=new JLabel();
        panel1.setBounds(450,60,150,150);
        panel1.setBorder(new LineBorder(Color.BLACK));
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);
        panel1.setForeground(new Color(36,155,36));
        panel.add(panel1);
        
        JLabel heading=new JLabel("Create Account As");
        heading.setBounds(40, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(heading);
        
        actype=new Choice();
        actype.add("Admin");
        actype.add("Customer");
        actype.setBounds(210, 50, 150, 20);
        panel.add(actype);
        
        lblmeterno=new JLabel("Meter Number");
        lblmeterno.setBounds(40, 110, 140, 20);
        lblmeterno.setForeground(Color.GRAY);
        lblmeterno.setFont(new Font("Tahoma",Font.BOLD,15));
        lblmeterno.setVisible(false);
        panel.add(lblmeterno);
        
         meterno= new JTextField();
        meterno.setBounds(180,110,150,20);
        meterno.setVisible(false);
        panel.add(meterno);
        
       
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40, 150, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(lblusername);
        
        username= new JTextField();
        username.setBounds(180,150,150,20);
        panel.add(username);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(40, 190, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(lblname);
        
        name= new JTextField();
        name.setBounds(180,190,150,20);
        panel.add(name);
        
         meterno.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){
                
            }
            @Override
            public void focusLost(FocusEvent fe){
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from login where meter_no='"+meterno.getText()+"'");
                    while(rs.next()){
                        name.setText(rs.getString("name"));
                        blob=rs.getBlob("prfl_pic");
                        InputStream in=blob.getBinaryStream();
                        BufferedImage image=ImageIO.read(in);
                        ImageIcon i1=new ImageIcon(image);
                        Image img=i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        panel1.setIcon(new ImageIcon(img));
                    }
                }catch(Exception e){
                    
                    
                }
                    
                  
            }
        });
        
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40, 230, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(lblpassword);
        
        password= new JTextField();
        password.setBounds(180,230,150,20);
        panel.add(password);
        
        actype.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user=actype.getSelectedItem();
                if(user.equals("Customer")){
                    lblmeterno.setVisible(true);
                    meterno.setVisible(true);
                    name.setEditable(false);
                    addimg.setEnabled(false);
                }else{
                    meterno.setVisible(false);
                    lblmeterno.setVisible(false);
                     name.setEditable(true);
                    addimg.setEnabled(true);
                    }
                
            }
        
        });
        
        creat=new JButton("Create");
        creat.setBounds(140, 300, 150, 30);
        creat.setBackground(Color.BLACK);
        creat.setForeground(Color.WHITE);
        creat.addActionListener(this);
        panel.add(creat);
        
        back=new JButton("Back");
        back.setBounds(400, 300, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        addimg=new JButton("Add Profile Image");
        addimg.setBounds(440, 230, 170, 30);
        addimg.setBackground(Color.BLACK);
        addimg.setForeground(Color.WHITE);
        addimg.addActionListener(this);
        panel.add(addimg);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==creat){
           
            try{
                conn c=new conn();
              
                String query2=null;
                if(actype.equals("admin")){
                       query2 ="insert into login(meter_no,username,name,password,acctype,prfl_pic) values(?,?,?,?,?,?)";
                          PreparedStatement pst=c.C.prepareStatement(query2);
                        pst.setString(1, meterno.getText());
                        pst.setString(2,username.getText());
                        pst.setString(3,name.getText());
                        pst.setString(4,password.getText());
                        pst.setString(5,actype.getSelectedItem());
                        pst.setBytes(6, person_image);
                        pst.executeUpdate();
                }else{
                    query2="update login set username='"+username.getText()+"',name='"+name.getText()+"',password='"+password.getText()+"',acctype='"+actype.getSelectedItem()+"' where meter_no='"+meterno.getText()+"'";
                    c.s.executeUpdate(query2);
                   
                }
               
                JOptionPane.showMessageDialog(null, "Account updated successfully *");
                setVisible(false);
                new login();
                
            }catch(Exception e){
               e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new login();
            
        }else{
            chooser=new JFileChooser();
            int l=chooser.showOpenDialog(null);
            
            
            if(l==chooser.APPROVE_OPTION){
                f=chooser.getSelectedFile();
                filename=f.getAbsolutePath();
                ImageIcon i1=new ImageIcon(filename);
                Image img=i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                panel1.setIcon(new ImageIcon(img));
            
                try{
                    File image = new File(filename);
                    fis= new FileInputStream(image);
                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    byte[] buf=new byte[1024];
                
                    for(int readnum;(readnum=fis.read(buf))!=-1;){
                    bos.write(buf,0,readnum);
                    }
                    person_image=bos.toByteArray();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }
 public static void main(String[] args){
     new signup();
 }    
}
