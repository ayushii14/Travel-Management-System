package src.TTMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JLabel labelusername, labelpersons, labelfood, labeldays, labelac, labelnumber, labelname, labelphone,
            labelid, labelprice;
    JButton back;

    ViewBookedHotel(String username) {
        setBounds(300, 100, 850, 530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("VIEW BOOKED HOTEL  DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 400, 30);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 25);
        add(labelusername);

        JLabel lblname = new JLabel("Hotel Name");
        lblname.setBounds(30, 90, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 90, 150, 25);
        add(labelname);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        add(labelpersons);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);

        labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/NON-AC");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);

        labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30, 410, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBounds(600, 460, 100, 25);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

      ImageIcon i1 = new
          ImageIcon(ClassLoader.getSystemResource("src/icons/bookeddetails.jpg"));
          Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
         image.setBounds(400,40,500,400);
         add(image);
         

        try {
            Conn conn = new Conn();
            String query = "select * from bookhotel where username ='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                labelpersons.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("ayushi02");
    }
}
