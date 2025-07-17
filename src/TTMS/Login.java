package src.TTMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;
// if we import package then its classes will be imported not there subpackages

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfusername, tfpassword;

    Login() {

        setLocation(180, 60);
        setSize(900, 550);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 600);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/Login.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40, 10, 300, 600);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 500, 400);
        add(p2);

        JLabel l1 = new JLabel("Username: ");
        l1.setBounds(90, 50, 95, 24);
        l1.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l1);

        tfusername = new JTextField();
        tfusername.setBounds(90, 74, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel l2 = new JLabel("Password: ");
        l2.setBounds(90, 115, 95, 24);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l2);

        tfpassword = new JTextField();
        tfpassword.setBounds(90, 140, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(131, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(270, 200, 130, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(131, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(170, 260, 130, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(131, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(310, 265, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();

                String query = "Select * from account where username='" + username + "' AND password='" + pass + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);

                } else {
                    JOptionPane.showMessageDialog(null, "incorrect username or password");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == password) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
