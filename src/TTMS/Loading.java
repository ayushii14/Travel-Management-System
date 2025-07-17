package src.TTMS;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {
    Thread t;

    JProgressBar progressBar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = progressBar.getMaximum();
                int value = progressBar.getValue();

                if (value < max) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    setVisible(false);
                    // new class object
                    new Dashboard(username);
                }
                Thread.sleep(60);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {

        this.username=username;
        t = new Thread(this);

        setBounds(250, 100, 900, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(180, 20, 600, 40);
        // text.setForeground(new Color(72, 209, 204));
        text.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        add(text);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(250, 135, 300, 30);
        add(progressBar);

        JLabel loading = new JLabel("Loading, Please wait....");
        loading.setBounds(280, 185, 800, 25);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("raleway", Font.BOLD, 16));
        add(loading);

        JLabel lblusername = new JLabel("Welcome " +username);
        lblusername.setBounds(15, 475, 800, 25);
        lblusername.setForeground(Color.BLUE);
        lblusername.setFont(new Font("raleway", Font.BOLD, 16));
        add(lblusername);

        

        t.start();
        setVisible(true);
    }

    public static void main(String args[]) {
        new Loading("");
    }
}
