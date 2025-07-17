package src.TTMS;

import java.awt.*;

import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    // multiple inheritance with interfaces is allowed
    // runnable interface have a run method which is abstract thats why we had to
    // make splash class also as abstract
    // but as we cannot make obj of abstract class so we will override the run
    // method
    Thread thread;

    Splash() {
        // setLocation(200, 50);
        // setSize(1000, 600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/Splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }
@Override
    public void run() {
        try {
            Thread.sleep(6000);
             new Login();
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Splash frame = new Splash();

        int x = 1;
        
        for (int i = 1; i <= 500; x += 7, i += 6) {
            frame.setLocation(700 - (x + i) / 2, 320 - (i / 2));
            frame.setSize((x + i) - 70, i + 100);
            try {
                Thread.sleep(6);
            } catch (Exception e) {
            }
        }
    }
}