
package electicity.billing.system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class meterinfo extends JFrame implements ActionListener{
    Choice mtrlocation,mtrtype, phasecd,billtype;
    JButton next,cancel; 
   
    String meternum;
    meterinfo(String meternum){
        this.meternum=meternum;
        setSize(800,600);
        setLocation(420,100);
        
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(310, 30, 200, 20);
        heading.setFont(new Font("tahoma",Font.PLAIN,24));
        p.add(heading);
        
        
        
        JLabel lblmetetno=new JLabel("Meter NO.");
        lblmetetno.setBounds(50, 80, 100, 20);
        lblmetetno.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(lblmetetno);
        
         JLabel metetnum=new JLabel(meternum);
        metetnum.setBounds(150, 80, 100, 20);
        metetnum.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(metetnum); 
        
        JLabel meterl=new JLabel("Meter Location");
        meterl.setBounds(50, 120, 150, 20);
        meterl.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(meterl);
        
        
        mtrlocation=new Choice();
        mtrlocation.add("Inside");
        mtrlocation.add("Outside");
        mtrlocation.setBounds(200, 120, 150, 20);
        p.add(mtrlocation);
        
        
        JLabel metertype=new JLabel("Meter Type");
        metertype.setBounds(50, 160, 150, 20);
        metertype.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(metertype);
        
        
        mtrtype=new Choice();
        mtrtype.add("Digital Meter");
        mtrtype.add("Smart Meter");
        mtrtype.setBounds(200, 160, 150, 20);
        p.add(mtrtype);
        
        JLabel phase=new JLabel("Phase Code");
        phase.setBounds(50, 200, 150, 20);
        phase.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(phase);
        
        
        phasecd=new Choice();
        phasecd.add("011");
        phasecd.add("022");
        phasecd.add("033");
        phasecd.add("044");
        phasecd.add("055");
        phasecd.add("066");
        phasecd.add("077");
        phasecd.add("088");
        phasecd.add("099");
        phasecd.setBounds(200, 200, 150, 20);
        p.add(phasecd);
        
        
        JLabel billt=new JLabel("Bill Type");
        billt.setBounds(50, 240, 150, 20);
        billt.setFont(new Font("tahoma",Font.PLAIN,18));
        p.add(billt);
        
         billtype=new Choice();
        billtype.add("Industrial Type");
        billtype.add("Domestic Type");
        billtype.setBounds(200, 240, 150, 20);
        p.add(billtype);
        
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
        
        next=new JButton("Next");
        next.setBounds(290, 420, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(420, 420, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        
        setVisible(true);
        
        
    }
     public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==next){
                String meter=meternum;
                String location=mtrlocation.getSelectedItem();
                String type=mtrtype.getSelectedItem();
                String phasecode=phasecd.getSelectedItem();
                String typebill=billtype.getSelectedItem();
                String days="30";
                
                String query="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+phasecode+"','"+typebill+"','"+days+"')";
                try{
                conn c=new conn();
                c.s.executeUpdate(query);
                JOptionPane.showInternalMessageDialog(null, "meter info successfully updated");
                setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
             }
     }
    public static void main(String[]args){
        new meterinfo("");
    }
}
