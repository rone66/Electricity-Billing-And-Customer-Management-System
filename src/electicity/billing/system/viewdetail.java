
package electicity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
public class viewdetail extends JFrame implements ActionListener{
    Blob blob;
    JButton cancel;
    viewdetail(String meter){
        
        setBounds(350,150,850,650);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("View Customer Information");
        heading.setBounds(250, 30, 300, 20);
        heading.setFont(new Font("tahoma",Font.PLAIN,24));
        add(heading);
        
          
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(70, 90, 100, 20);
        lblname.setFont(new Font("tahoma",Font.PLAIN,16));
        add(lblname);
        
        JLabel name=new JLabel("");
        name.setBounds(250, 90, 100, 20);
        add(name);
        
        
        JLabel lblmetetno=new JLabel("Meter NO.");
        lblmetetno.setBounds(70, 140, 100, 20);
        lblmetetno.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblmetetno);
        
         JLabel metetnum=new JLabel("");
        metetnum.setBounds(250, 140, 100, 20);
        add(metetnum); 
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(70, 190, 200, 20);
        lbladdress.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lbladdress);
        
        JLabel address=new JLabel("");
        address.setBounds(250, 190, 150, 20);
        add(address);
        
        
        
        JLabel lblstate=new JLabel("State");
        lblstate.setBounds(70, 240, 200, 20);
        lblstate.setFont(new Font("tahoma",Font.PLAIN,18));
       add(lblstate);
        
        JLabel state=new JLabel("");
        state.setBounds(250, 240, 150, 20);
       add(state);
        
        JLabel lblcity=new JLabel("city");
        lblcity.setBounds(70, 290, 200, 20);
        lblcity.setFont(new Font("tahoma",Font.PLAIN,18));
       add(lblcity);
        
        JLabel city=new JLabel("");
        city.setBounds(250, 290, 150, 20);
        add(city);
        
        JLabel lblpin=new JLabel("Pincode");
        lblpin.setBounds(70, 340, 200, 20);
        lblpin.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblpin);
        
        JLabel pin=new JLabel("");
        pin.setBounds(250, 340, 150, 20);
        add(pin);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(70, 390, 200, 20);
        lblemail.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblemail);
        
        JLabel email=new JLabel("");
        email.setBounds(250, 390, 150, 20);
        add(email);
        
        JLabel lblphno=new JLabel("Phone no");
        lblphno.setBounds(70, 440, 200, 20);
        lblphno.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblphno);
        
        JLabel phno=new JLabel("");
        phno.setBounds(250, 440, 150, 20);
        add(phno);
        
        JLabel lbladdhar=new JLabel("Addhar no");
        lbladdhar.setBounds(70, 490, 200, 20);
        lbladdhar.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lbladdhar);
        
        JLabel addhr=new JLabel("");
        addhr.setBounds(250, 490, 150, 20);
        add(addhr);
        
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/g4.jpg"));
        Image i2= i1.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(15, 10, 800, 600);
        add(image);
        
        JLabel  pic=new JLabel("                Image");
        pic.setBounds(450, 90, 150, 150);
        pic.setBorder(new LineBorder(Color.BLACK));
        pic.setBackground(Color.WHITE);
        pic.setLayout(null);
        pic.setForeground(new Color(36,155,36));
        image.add(pic);
        
        
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
                    }
            
        }catch(Exception e){
            e.printStackTrace();  
        }
        
        
         cancel=new JButton("Cancel");
        cancel.setBounds(380, 540, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        
        
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==cancel){
             setVisible(false);
            
         }
     }
    
    
    
    
    public static void main(String[] args){
        new viewdetail("");
    }
}
