
package electicity.billing.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;



public class project extends JFrame implements ActionListener{
    String atype,meter,username;
    project(String atype,String meter,String username){
        this.atype=atype;
        this.meter=meter;
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/project.jpg"));
        Image i2= i1.getImage().getScaledInstance(1550, 850, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        setLayout(new FlowLayout());

        JMenu master= new JMenu("Master");
        master.setForeground(Color.BLUE);
       
        
        JMenuItem newc=new JMenuItem("New Customer");
        newc.setFont(new Font("monospaced",Font.BOLD,16));
        newc.setBackground(Color.WHITE);
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icon/addcus32.png"));
        Image image1= icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newc.setIcon(new ImageIcon(image1));
        newc.setMnemonic('D');
        newc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        newc.addActionListener(this);
        master.add(newc);
        
        JMenuItem cusdetail=new JMenuItem("Customer Details");
        cusdetail.setFont(new Font("monospaced",Font.BOLD,16));
        cusdetail.setBackground(Color.WHITE);
        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("icon/addcus2.png"));
        Image image2= icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cusdetail.setIcon(new ImageIcon(image2));
        cusdetail.setMnemonic('M');
        cusdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        cusdetail.addActionListener(this);
        master.add(cusdetail);
        
        JMenuItem depositdetail=new JMenuItem("Deposit Details");
        depositdetail.setFont(new Font("monospaced",Font.BOLD,16));
        depositdetail.setBackground(Color.WHITE);
        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("icon/depod2.png"));
        Image image3= icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetail.setIcon(new ImageIcon(image3));
        depositdetail.setMnemonic('N');
        depositdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        depositdetail.addActionListener(this);
        master.add(depositdetail);
        
        JMenuItem calcbill=new JMenuItem("Calculate Bill");
        calcbill.setFont(new Font("monospaced",Font.BOLD,16));
        calcbill.setBackground(Color.WHITE);
        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("icon/calcbill2.png"));
        Image image4= icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calcbill.setIcon(new ImageIcon(image4));
        calcbill.setMnemonic('C');
        calcbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        calcbill.addActionListener(this);
        master.add(calcbill);
        
        JMenu info= new JMenu("Information");
        info.setForeground(Color.red);
       
        
        JMenuItem updateinfo=new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.BOLD,16));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("icon/up.png"));
        Image image5= icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image5));
        updateinfo.setMnemonic('F');
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        updateinfo.addActionListener(this);
        info.add(updateinfo);
        
        JMenuItem viewinfo=new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.BOLD,16));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("icon/view1.png"));
        Image image6= icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));
        viewinfo.setMnemonic('G');
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        viewinfo.addActionListener(this);
        info.add(viewinfo);
        
        
         JMenuItem cbill=new JMenuItem("Bill Calculate");
        cbill.setFont(new Font("monospaced",Font.BOLD,16));
        cbill.setBackground(Color.WHITE);
        ImageIcon icon13=new ImageIcon(ClassLoader.getSystemResource("icon/view1.png"));
        Image image14= icon13.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        cbill.setIcon(new ImageIcon(image14));
        cbill.setMnemonic('F');
        cbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
        cbill.addActionListener(this);
        info.add(cbill);
        
        JMenu user= new JMenu("User");
       user.setForeground(Color.blue);
       
        
         JMenuItem paybill=new JMenuItem("PayBill");
        paybill.setFont(new Font("monospaced",Font.BOLD,16));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7=new ImageIcon(ClassLoader.getSystemResource("icon/p.png"));
        Image image7= icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.setMnemonic('A');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        paybill.addActionListener(this);
        user.add(paybill);
        
         JMenuItem billdetail=new JMenuItem("Bill Detail");
        billdetail.setFont(new Font("monospaced",Font.BOLD,16));
        billdetail.setBackground(Color.WHITE);
        ImageIcon icon8=new ImageIcon(ClassLoader.getSystemResource("icon/billd.jpg"));
        Image image8= icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetail.setIcon(new ImageIcon(image8));
        billdetail.setMnemonic('B');
        billdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        billdetail.addActionListener(this);
        user.add(billdetail);
        
        
         JMenu report= new JMenu("Report");
        report.setForeground(Color.red);
        
        
         JMenuItem gbill=new JMenuItem("Generate Bill");
        gbill.setFont(new Font("monospaced",Font.BOLD,16));
        gbill.setBackground(Color.WHITE);
        ImageIcon icon9=new ImageIcon(ClassLoader.getSystemResource("icon/p.png"));
        Image image9= icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        gbill.setIcon(new ImageIcon(image9));
        gbill.setMnemonic('E');
        gbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        gbill.addActionListener(this);
        report.add(gbill);
        
         JMenu uti= new JMenu("Utility");
        uti.setForeground(Color.blue);
        
        
         JMenuItem calc=new JMenuItem("Calculator");
        calc.setFont(new Font("monospaced",Font.BOLD,16));
        calc.setBackground(Color.WHITE);
        ImageIcon icon10=new ImageIcon(ClassLoader.getSystemResource("icon/calc.png"));
        Image image10= icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calc.setIcon(new ImageIcon(image10));
        calc.setMnemonic('C');
        calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        calc.addActionListener(this);
        uti.add(calc);
        
          JMenuItem note=new JMenuItem("Notepad");
        note.setFont(new Font("monospaced",Font.BOLD,16));
        note.setBackground(Color.WHITE);
        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/note1.png"));
        Image image11= icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        note.setIcon(new ImageIcon(image11));
        note.setMnemonic('N');
        note.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        note.addActionListener(this);
        uti.add(note);
        
        JMenu mexit= new JMenu("Exit");
        mexit.setForeground(Color.red);
       
        
         JMenuItem exit=new JMenuItem("Exit From Menu");
        exit.setFont(new Font("monospaced",Font.BOLD,16));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image image12= icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        mexit.add(exit);
        
        
        JLabel pic=new JLabel("                Image");
        pic.setBounds(1300, 60, 150, 150);
        pic.setBorder(new LineBorder(Color.WHITE));
        pic.setBackground(Color.WHITE);
        pic.setLayout(null);
        pic.setForeground(new Color(36,155,36));
        image.add(pic);
        
        
        JLabel lblatype=new JLabel();
        lblatype.setBounds(1350, 230, 100, 20);
        lblatype.setForeground(Color.WHITE);
        lblatype.setFont(new Font("tahoma",Font.PLAIN,18));
        image.add(lblatype);
        
        JLabel lblloginid=new JLabel();
        lblloginid.setBounds(1350, 30, 100, 20);
        lblloginid.setForeground(Color.WHITE);
        lblloginid.setFont(new Font("tahoma",Font.PLAIN,18));
        image.add(lblloginid);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from login Where username='"+username+"'");
            while(rs.next()){
                
                lblatype.setText(rs.getString("acctype"));
                lblloginid.setText(username);
                
                 Blob blob = rs.getBlob("prfl_pic");
                 InputStream in = blob.getBinaryStream();
                 BufferedImage image17 = ImageIO.read(in);
                 ImageIcon i4 = new ImageIcon(image17);
                 Image img = i4.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                  pic.setIcon(new ImageIcon(img));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        if(atype.equals("Admin")){
         mb.add(master);
        }else{
         mb.add(user);
         mb.add(report);
         mb.add(info);
         
        }
         mb.add(uti);
         mb.add(mexit);
         
         
        setVisible(true);
        
        
   }
     public void actionPerformed(ActionEvent ae){
         String msg=ae.getActionCommand();
         if(msg.equals("New Customer")){
             new newcustomer();
         }else if(msg.equals("Customer Details")){
             new customerdetail();
         }else if(msg.equals("Deposit Details")){
             new depositdetail();
         }else if(msg.equals("Calculate Bill")){
             new calculatebill();
         }else if(msg.equals("Update Information")){
             new updateinfo(meter);
         
         }else if(msg.equals("PayBill")){
             new paybill(meter);
        
         }else if(msg.equals("Bill Detail")){
             new billdetail(meter);
         }else if(msg.equals("Generate Bill")){
             new generatebill(meter);
         }else if(msg.equals("Calculator")){
              try{
                 Runtime.getRuntime().exec("calc.exe");
             }catch(Exception e){
                 e.printStackTrace();
             }
         }else if(msg.equals("Notepad")){
             try{
                 Runtime.getRuntime().exec("notepad.exe");
             }catch(Exception e){
                 e.printStackTrace();
             }
         }else if(msg.equals("View Information")){
             new viewdetail(meter);
         }else if(msg.equals("Exit From Menu")){
             setVisible(false);
             new login();
         }else if(msg.equals("Bill Calculate")){
             new billcalculate(meter);
         }
     }
    
    
    public static void main(String[] args){
        new project("","","");
    } 
    
}
