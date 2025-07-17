package src.TTMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfpassword, tfquestion, tfanswer;
    JButton search, back, retrieve;

    ForgetPassword() {
        setBounds(250, 100, 900, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 530, 450);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(310, 240, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570, 90, 310, 240);
        add(image);

        JLabel username = new JLabel("Username: ");
        username.setBounds(10, 20, 100, 30);
        username.setFont(new Font("Tahoma", Font.BOLD, 13));
        p1.add(username);

        tfusername = new JTextField();
        tfusername.setBounds(170, 20, 210, 30);
        // tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBounds(390, 20, 100, 30);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name: ");
        name.setBounds(10, 70, 100, 30);
        name.setFont(new Font("Tahoma", Font.BOLD, 13));
        p1.add(name);

        tfname = new JTextField();
        tfname.setBounds(170, 70, 210, 30);
        // tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel question = new JLabel("Security Question: ");
        question.setBounds(10, 120, 200, 30);
        question.setFont(new Font("Tahoma", Font.BOLD, 13));
        p1.add(question);

        tfquestion = new JTextField();
        tfquestion.setBounds(170, 120, 210, 30);
        // tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel answer = new JLabel("Answer: ");
        answer.setBounds(10, 170, 200, 30);
        answer.setFont(new Font("Tahoma", Font.BOLD, 13));
        p1.add(answer);

        tfanswer = new JTextField();
        tfanswer.setBounds(170, 170, 210, 30);
        // tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(390, 170, 100, 30);
        // retrieve.setBackground(Color.GRAY);
        // retrieve.setForeground(Color.WHITE);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel password = new JLabel("Password: ");
        password.setBounds(10, 220, 200, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 13));
        p1.add(password);

        tfpassword = new JTextField();
        tfpassword.setBounds(170, 220, 210, 30);
        // tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(170, 300, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                String query = "select * from account where username= '" + tfusername.getText() + "'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                   tfquestion.setText( rs.getString("question"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
            try {
                String query = "select * from account where answer= '" + tfanswer.getText() + "' AND username= '" + tfusername.getText() + "'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
            
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
