package src.TTMS;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Paytm extends JFrame  implements ActionListener{
 Paytm(){

    setLayout(null);
        setBounds(300, 70, 800, 610);
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
            j.setPage("https://paytm.com/recharge");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load,Error 404</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
      
      setPreferredSize(new Dimension(800,600));
        
     JButton back=new JButton("Back");
     back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             setVisible(false);
         }
     });
     back.setBounds(610, 20, 80, 40);
     getContentPane().add(back);
     
       
        setVisible(true);
    }
    public static void main(String[] args){
        new Paytm();
    }
    
}
