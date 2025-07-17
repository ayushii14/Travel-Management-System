package src.TTMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import java.sql.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails, deletePersonalDetails,notepad,about,calculator, bookHotel,payment,viewBookedHotel,destination, viewHotel,viewPersonalDetails, updatePersonalDetails, checkPackage, bookPackage, viewPackage;
    String username;

    Dashboard(String username) {

        this.username = username;
        // setBounds(0,0,1500,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 400, 50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 27));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 270, 1100);
        // add(p2);

        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setBounds(0, 65, 270, 900); // Set bounds for the scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Never show horizontal
                                                                                         // scrollbar
        add(scrollPane, BorderLayout.WEST); // Add the JScrollPane to the frame

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 270, 50);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 270, 50);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 100, 270, 50);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

         deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 150, 270, 50);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 50));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackage = new JButton("Check Packages");
        checkPackage.setBounds(0, 200, 270, 50);
        checkPackage.setBackground(new Color(0, 0, 102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        checkPackage.setMargin(new Insets(0, 0, 0, 110));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 250, 270, 50);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bookPackage.setMargin(new Insets(0, 0, 0, 120));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 300, 270, 50);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        viewPackage.setMargin(new Insets(0, 0, 0, 120));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotel = new JButton("View Hotels");
        viewHotel.setBounds(0, 350, 270, 50);
        viewHotel.setBackground(new Color(0, 0, 102));
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        viewHotel.setMargin(new Insets(0, 0, 0, 130));
        viewHotel.addActionListener(this);
        p2.add(viewHotel);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 400, 270, 50);
        bookHotel.setBackground(new Color(0, 0, 102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        bookHotel.setMargin(new Insets(0, 0, 0, 140));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 450, 270, 50);
        viewBookedHotel.setBackground(new Color(0, 0, 102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        viewBookedHotel.setMargin(new Insets(0, 0, 0, 100));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);


    destination = new JButton("Destinations");
        destination.setBounds(0, 500, 270, 50);
        destination.setBackground(new Color(0, 0, 102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma", Font.PLAIN, 15));
        destination.setMargin(new Insets(0, 0, 0, 140));
        destination.addActionListener(this);
        p2.add(destination);

         payment = new JButton("Payments");
        payment.setBounds(0, 600, 270, 50);
        payment.setBackground(new Color(0, 0, 102));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma", Font.PLAIN, 15));
        payment.setMargin(new Insets(0, 0, 0, 140));
        payment.addActionListener(this);
        p2.add(payment);

       calculator = new JButton("Calculator");
        calculator.setBounds(0, 550, 270, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 15));
        calculator.setMargin(new Insets(0, 0, 0, 140));
        calculator.addActionListener(this);
        p2.add(calculator);

       notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 270, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 15));
        notepad.setMargin(new Insets(0, 0, 0, 140));
        notepad.addActionListener(this);
        p2.add(notepad);

        JButton about = new JButton("about");
        about.setBounds(0, 700, 270, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 15));
        about.setMargin(new Insets(0, 0, 0, 140));
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("src/icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon1 = new JLabel(i6);
        icon1.setBounds(170, 10, 1200, 680);
        add(icon1);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(330, 60, 1500, 70);
        text.setFont(new Font("Tahoma", Font.BOLD, 30));
        text.setForeground(new Color(260 - 0 - 3));
        icon1.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkPackage) {
            new CheckPackage();
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotel) {
            new CheckHotels();
        }else if (ae.getSource() == destination) {
            new Destinations();
        } else if (ae.getSource() == bookHotel) {
            new BookHotel(username);
        } else if (ae.getSource() == viewBookedHotel) {
            new ViewBookedHotel(username);
        }else if (ae.getSource() == payment) {
            new Payment();
        }else if (ae.getSource() ==calculator) {
            try {
                File calculator = new File("C:\\Windows\\System32\\calc.exe");
                if (calculator.exists()) {
                    ProcessBuilder pb = new ProcessBuilder(calculator.getAbsolutePath());
                    pb.start();
                } else {
                    System.out.println("Calculator not found at the specified path.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource() ==  deletePersonalDetails) {
            new DeleteDetails(username);
        }
        
    
    }

    public static void main(String args[]) {
        new Dashboard(" ");
    }
}
