
package electicity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener{
    JButton login,signup,cancel;
    JTextField username,password;
    Choice log;
    login(){
        super("Login");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);
        
        username=new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);
        
       password=new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);
        
        JLabel loginas=new JLabel("Loggin in as");
        loginas.setBounds(300, 100, 100, 20);
        add(loginas);
        
       log=new Choice();
        log.add("Admin");
        log.add("Customer");
        log.setBounds(400, 100, 150, 20);
        add(log);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login=new JButton("Login",new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel=new JButton("Cancel",new ImageIcon(i4));
        cancel.setBounds(450, 160, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/sup.png"));
        Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup=new JButton("Signup",new ImageIcon(i6));
        signup.setBounds(380, 200, 100, 20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/prfl logo2.png"));
        Image i8=i7.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
        
        
    }
      public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String suername=username.getText();
            String spassword=password.getText();
            String user=log.getSelectedItem();
            
            try{
                conn c=new conn();
                String query="select * from login where username='"+suername+"'and password='"+spassword+"'and acctype='"+user+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    String meter=rs.getString("meter_no");
                    setVisible(false);
                    new project(user,meter,suername);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new signup();
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new login();
    }
}
