package src.TTMS;

import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewPackage extends JFrame implements ActionListener {
    JLabel labelpackage, labelusername, labelid, labelnumber, labelname, labelgender, labelcountry, labeladdress, labelphone,
    labelemail,labelpersons,labelprice;
JButton back;

    ViewPackage(String username) {
        setBounds(300, 100, 850, 530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD,20));
        text.setBounds(60,0,300,30 );
        add(text);


        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);

         labelpackage = new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,170,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,210,150,25);
        add(lblnumber);

    labelnumber = new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,250,150,25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,290,150,25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);

  

        back = new JButton("Back");
        back.setBounds(600, 350, 100, 25);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/bookeddetails.jpg")); 
    Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(450,20,400,300);
    add(image);


try {
    Conn conn = new Conn();
    String query = "select * from bookpackage where username ='"+username+"'";
    ResultSet rs = conn.s.executeQuery(query);
    while(rs.next()) {
        labelusername.setText(rs.getString("Username"));
        labelid.setText(rs.getString("Id"));
        labelnumber.setText(rs.getString("number"));
        labelpackage.setText(rs.getString("package"));
        labelphone.setText(rs.getString("phone"));
        labelprice.setText(rs.getString("price"));
        labelpersons.setText(rs.getString("persons"));
    }
}catch (Exception e){
    e.printStackTrace();
}   
setVisible(true);
}

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }


    public static void main(String[] args) {
        new ViewPackage("ayushi02");
    }
}
