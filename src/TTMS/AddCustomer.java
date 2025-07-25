package src.TTMS;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel lblusername, labelusername, lblid, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;

    AddCustomer(String username) {
        setBounds(300, 100, 850, 530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox<>(new String[] { "PassPort", "Adhar Card", "Pan Card" });
        comboid.setBounds(220, 90, 150, 25);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel("");
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        lbladdress.setForeground(Color.white);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        lblphone.setForeground(Color.white);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        lblemail.setForeground(Color.white);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        add = new JButton("ADD");
        add.setBounds(70, 430, 100, 25);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(220, 430, 100, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/userdetails.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 530, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 530);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from account where username = '"+username+"'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }

            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
              Conn c=new Conn();
              String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"') ";
         c.s.executeUpdate(query);

         JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
         setVisible(false);
         
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer(" ");
    }
}
