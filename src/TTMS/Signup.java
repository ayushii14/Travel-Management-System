package src.TTMS;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JComboBox Question;
    JButton back, create;
    JTextField tfusername,tfname, tfpassword, tfsecurity;
    Choice security;
    // JFrame frame = new JFrame("Colourful window");

    Signup() {
        JFrame frame = new JFrame("SignUp window");
        frame.setLocation(180, 60);
        frame.setSize(900, 550);
        frame.setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(500, 0, 550, 600);
        // p1.setBackground(Color.BLACK);
        frame.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 400, 550);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(131, 193, 233));
        p2.setBounds(0, 0, 500, 550);
        p2.setLayout(null);
        frame.add(p2);


        JLabel l = new JLabel("Name: ");
        l.setBounds(50, 30, 95, 30);
        l.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l);

        tfname = new JTextField();
        tfname.setBounds(190, 30, 250, 30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfname);


        JLabel l1 = new JLabel("Username: ");
        l1.setBounds(50, 80, 95, 30);
        l1.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l1);

        tfusername = new JTextField();
        tfusername.setBounds(190, 80, 250, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel l2 = new JLabel("Password: ");
        l2.setBounds(50, 130, 95, 30);
        l2.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l2);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 130, 250, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        JLabel l3 = new JLabel("Security Question: ");
        l3.setBounds(50, 180, 150, 30);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l3);

        String items[] = { "What is your childhood name", "Which Fruit you like the most",
                "Your childhood fav. cartoon", "Your lucky number" };
        Question = new JComboBox<>(items);
        Question.setBounds(190, 180, 250, 30);
        Question.setBorder(BorderFactory.createEmptyBorder());
        p2.add(Question);

        JLabel l4 = new JLabel("Answer: ");
        l4.setBounds(50, 240, 150, 30);
        l4.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(l4);

        tfsecurity = new JTextField();
        tfsecurity.setBounds(190, 240, 250, 30);
        tfsecurity.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfsecurity);

        create = new JButton("Create");
        create.setBounds(130, 350, 100, 30);
        // create.setBackground(Color.WHITE);
        // create.setForeground(new Color(133,193,233));
        create.setBorder(BorderFactory.createEmptyBorder());
        create.addActionListener(this);
        p2.add(create);

        back = new JButton("Back");
        back.setBounds(270, 350, 100, 30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p2.add(back);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) { // through this function we describe what action should be done after
                                                  // clicking on create button
        if (ae.getSource() == create) {
            String name = tfname.getText();
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String question = (String) Question.getSelectedItem();
            String answer = tfsecurity.getText();

            String query = "insert into account value('"+name+"','" + username + "','" + password + "','" + question + "','"
                    + answer + "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
            
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
