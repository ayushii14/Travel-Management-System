package src.TTMS;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DeleteDetails extends JFrame implements ActionListener{
      JLabel labelusername, labelid, labelnumber, labelname, labelgender, labelcountry, labeladdress, labelphone,
            labelemail;
    JButton back;
String username;
DeleteDetails(String username){
    this.username=username;
            setBounds(300, 100, 850, 530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(200, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(200, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 290, 150, 25);
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(200, 290, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(470, 50, 150, 25);
        add(lblcountry);

        labelcountry = new JLabel();
        labelcountry.setBounds(650, 50, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(470, 110, 150, 25);
        add(lbladdress);

        labeladdress = new JLabel();
        labeladdress.setBounds(650, 110, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(470, 170, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(650, 170, 150, 25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(470, 230, 150, 25);
        add(lblemail);

        labelemail = new JLabel();
        labelemail.setBounds(650, 230, 150, 25);
        add(labelemail);

        back = new JButton("Delete");
        back.setBounds(600, 350, 100, 25);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/viewcustomer.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(850, 530, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 530);
        add(image);

        try {
            Conn conn = new Conn();
            String query = "Select * from customer where username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);

}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==back){
 try{
Conn c=new Conn();
c.s.executeUpdate("delete from account where username= '"+username+"'");
c.s.executeUpdate("delete from customer where username= '"+username+"'");
c.s.executeUpdate("delete from bookpackage where username= '"+username+"'");
c.s.executeUpdate("delete from bookhotel where username= '"+username+"'");

JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
System.exit(0);

 }

 catch(Exception e){
    e.printStackTrace();
 } }else{
    setVisible(false);
 }
}

public static void main(String args[]) {
    new DeleteDetails("ayushi02");
}
}
