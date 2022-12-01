
package electicity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

public class updateinfo extends JFrame implements ActionListener{
    String meter;
    JTextField address,city,state,email,phno,pin,addhr;
    Blob blob,blob2;
    JButton update,addimg,cancel;
    JFileChooser chooser;
    byte[] person_image=null;
    String filename=null;
    File f=null;
    JLabel  pic,name,metetnum;
    FileInputStream fis;
    updateinfo(String meter){
       this.meter=meter;
      
        setBounds(300,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Your Information");
        heading.setBounds(250, 30, 350, 30);
        heading.setFont(new Font("tahoma",Font.PLAIN,24));
        add(heading);
        
          
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(70, 90, 100, 20);
        lblname.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lblname);
        
        name=new JLabel("");
        name.setBounds(250, 90, 100, 20);
        add(name);
        
        
        JLabel lblmetetno=new JLabel("Meter NO.");
        lblmetetno.setBounds(70, 140, 100, 20);
        lblmetetno.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblmetetno);
        
          metetnum=new JLabel("");
        metetnum.setBounds(250, 140, 100, 20);
        add(metetnum); 
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(70, 190, 200, 20);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lbladdress);
        
        address=new JTextField();
        address.setBounds(250, 190, 150, 20);
        add(address);
        
        
        
        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(70, 240, 200, 20);
        lblstate.setFont(new Font("tahoma",Font.PLAIN,18));
       add(lblstate);
        
         state=new JTextField();
        state.setBounds(250, 240, 150, 20);
       add(state);
        
        JLabel lblcity=new JLabel("city");
        lblcity.setBounds(70, 290, 200, 20);
        lblcity.setFont(new Font("tahoma",Font.PLAIN,18));
       add(lblcity);
        
        city=new JTextField();
        city.setBounds(250, 290, 150, 20);
        add(city);
        
        JLabel lblpin=new JLabel("Pincode");
        lblpin.setBounds(70, 340, 200, 20);
        lblpin.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblpin);
        
        pin=new JTextField();
        pin.setBounds(250, 340, 150, 20);
        add(pin);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(70, 390, 200, 20);
        lblemail.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblemail);
        
        email=new JTextField();
        email.setBounds(250, 390, 150, 20);
        add(email);
        
        JLabel lblphno=new JLabel("Phone no");
        lblphno.setBounds(70, 440, 200, 20);
        lblphno.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblphno);
        
       phno=new JTextField();
        phno.setBounds(250, 440, 150, 20);
        add(phno);
        
        JLabel lbladdhar=new JLabel("Addhar no");
        lbladdhar.setBounds(70, 490, 200, 20);
        lbladdhar.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lbladdhar);
        
        addhr=new JTextField("");
        addhr.setBounds(250, 490, 150, 20);
        add(addhr);
        
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/g4.jpg"));
        Image i2= i1.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(15, 10, 800, 600);
        add(image);
        
       pic=new JLabel("                Image");
        pic.setBounds(450, 90, 150, 150);
        pic.setBorder(new LineBorder(Color.BLACK));
        pic.setBackground(Color.WHITE);
        pic.setLayout(null);
        pic.setForeground(new Color(36,155,36));
        image.add(pic);
        
        
        update=new JButton("Update");
        update.setBounds(300, 540, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        image.add(update);
        
        addimg=new JButton("Add Profile Image");
        addimg.setBounds(460, 290, 170, 30);
        addimg.setBackground(Color.BLACK);
        addimg.setForeground(Color.WHITE);
        addimg.addActionListener(this);
        image.add(addimg);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(420, 540, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        image.add(cancel);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer Where meter_no='"+meter+"'");
                 while (rs.next()) {
                        name.setText(rs.getString("name"));
                        address.setText(rs.getString("address"));
                        city.setText(rs.getString("city"));
                        pin.setText(rs.getString("pincode"));
                        email.setText(rs.getString("email"));
                        phno.setText(rs.getString("phno"));
                        addhr.setText(rs.getString("addharno"));
                        state.setText(rs.getString("state"));
                        metetnum.setText(rs.getString("meter_no"));
                        
                        
                        blob = rs.getBlob("customer_pic");
                        InputStream in = blob.getBinaryStream();
                        BufferedImage image1 = ImageIO.read(in);
                        ImageIcon i4 = new ImageIcon(image1);
                        Image img = i4.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        pic.setIcon(new ImageIcon(img));
                        
                        blob2=rs.getBlob("customer_doc_pic");
                    }
            
        }catch(Exception e){
            e.printStackTrace();  
        }
        
        
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==addimg){
             chooser=new JFileChooser();
            int l=chooser.showOpenDialog(null);
            
            
            if(l==chooser.APPROVE_OPTION){
                f=chooser.getSelectedFile();
                filename=f.getAbsolutePath();
                ImageIcon i1=new ImageIcon(filename);
                Image img=i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                pic.setIcon(new ImageIcon(img));
            
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
         
        }else if(ae.getSource()==update){
             try{
                conn c=new conn(); 
                
                String tname=name.getText() ;
                String metro= metetnum.getText();
                String tadd= address.getText();
                String tstate=state.getText() ;
                String tcity= city.getText();
                String tpin= pin.getText();
                String teml= email.getText();
                String tph=phno.getText() ;
                String add=addhr.getText();
              
                c.s.executeUpdate("update customer set name='"+tname+"',address='"+tadd+"',state='"+tstate+"',city='"+tcity+"',pincode='"+tpin+"',email='"+teml+"',phno='"+tph+"',addharno='"+add+"'  where meter_no ='"+meter+"'");
               
                 
               
                //for query3
                String query2="update customer set customer_pic=? where meter_no='"+meter+"'";
               
                PreparedStatement pst=c.C.prepareStatement(query2);
                pst.setBytes(1,person_image);
             
             
                pst.executeUpdate();
            
                JOptionPane.showMessageDialog(null, "Account updated successfully *");
                setVisible(false);
               
                }catch(Exception e){
                    e.printStackTrace();
                }
                 
        }
    
    }
    
     public static void main(String[] args){
        new updateinfo("");
    }
    
}
