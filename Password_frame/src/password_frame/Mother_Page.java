package password_frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Mother_Page {
    private final int w = 475;
    private final int h = 260;
    private JButton Button_mem;
    private JButton Button_seeInfo;
    private JPanel panel_Button_Mother_page;
    private JPanel Pic_Gym;
    private JLabel Pic_holder;
    static JFrame frame;
   public  Mother_Page(){
       
       frame = new JFrame();
       frame.setTitle("Main Page");
       frame.setSize(w, h);
       
       frame.setVisible(true);
       frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
              
       Mother_Page_Button();
       frame.add(panel_Button_Mother_page , BorderLayout.EAST);
       frame.add(Pic_Gym , BorderLayout.WEST);
       
       frame.setBackground(Color.gray);
       Button_mem.addActionListener(new Button_Act_mem());
       Button_seeInfo.addActionListener(new Button_Act_seeInfo());
       frame.setResizable(false);
       
   }

    private void Mother_Page_Button() {
       
       panel_Button_Mother_page = new JPanel();
      
       Button_mem = new JButton("Members");
      Button_seeInfo = new JButton("informtion");
     
       panel_Button_Mother_page.add(Button_mem , BorderLayout.SOUTH);
       panel_Button_Mother_page.add(Button_seeInfo , BorderLayout.NORTH);
       panel_Button_Mother_page.setBackground(Color.GRAY);
       
       Pic_Gym = new JPanel();
       ImageIcon pic = new ImageIcon("Aydin Gym.png" );
       Pic_holder =new JLabel(pic);
       Pic_Gym.add(Pic_holder);
       Pic_Gym.setBackground(Color.GRAY);
       
       
    }

    private static class Button_Act_mem implements ActionListener {

        public void actionPerformed(ActionEvent e) 
        {
            
             
            try {
                new mem_Page();
            } catch (IOException ex) {
                Logger.getLogger(Mother_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
          frame.dispose();
        }
        
        
       
    }

    private static class Button_Act_seeInfo implements ActionListener {
       
        public void actionPerformed(ActionEvent e) {
            
            new See_Info_Page();
            frame.dispose();
        }
    }
        
            
            
        
 }
