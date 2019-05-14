
package password_frame;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


public class Password_frame extends JFrame {

	private final int w_pass = 340;
	private final int h_pass = 150;
	private JPanel panel_lable ;
	private JPanel panel_Text;
	private JPanel panel_button;
	private JLabel Lable_pass ;
	private JLabel Lable_user ;
	private JTextField user_Text;
	private JPasswordField pass_Text;
	private JButton OK_button;
	private JButton cansel_button;
        
	
	public Password_frame() throws IOException {
		
           
            
                super("log in ");
		setSize(w_pass, h_pass);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Pass_panel1();
		
                
                panel_button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel_Text.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panel_lable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                
                add(panel_button, BorderLayout.SOUTH);
		add(panel_lable, BorderLayout.WEST);
		add(panel_Text, BorderLayout.CENTER);
               
                panel_button.setBackground(Color.GRAY);
                panel_lable.setBackground(Color.GRAY); 
                panel_Text.setBackground(Color.GRAY);
		
		
                OK_button.addActionListener(new OK_ACT());
                cansel_button.addActionListener(new Cancel_ACT());
                
                setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		 File f = new File("pass.txt");
         if(!f.exists()) { 
             f.createNewFile();
             PrintWriter pw = new PrintWriter (f);
             pw.print("hassan:hassan:");
             pw.close();
              }
                

		
	}
		
	private void Pass_panel1() throws IOException {
		
	
		
                
                
		panel_lable = new JPanel(new BorderLayout( ));
		Lable_user = new JLabel("user");
		Lable_pass  = new JLabel("password");
		
                Lable_user.setOpaque(true);
                Lable_pass.setOpaque(true);
                Lable_user.setBackground(Color.WHITE);
                Lable_pass.setBackground(Color.WHITE);
                
		panel_lable.add(Lable_user, BorderLayout.NORTH);
		panel_lable.add(Lable_pass , BorderLayout.SOUTH);
		
		panel_Text = new JPanel(new BorderLayout());
		pass_Text = new JPasswordField(10);
		user_Text = new JTextField(10);
		
		pass_Text.setEchoChar('*');
		panel_Text.add(user_Text, BorderLayout.NORTH);
		panel_Text.add(pass_Text,BorderLayout.SOUTH);
		
		panel_button = new JPanel();
		OK_button = new JButton("OK");
		cansel_button = new JButton("Cancel");
		
		panel_button.add(OK_button);
		panel_button.add(cansel_button);
                
               
		
    }
private class OK_ACT implements ActionListener
{
        public void actionPerformed(ActionEvent e) {
        
       boolean log_in = false;
       boolean log_in_admin = false;
       File f = new File("pass.txt");
       
       
            try {
                Scanner scan = new Scanner(f);
                scan.useDelimiter(":");
                
                while(scan.hasNext()){
                    String user = scan.next();
                    String pass = scan.next();
                    scan.nextLine();
                  if(user_Text.getText().equals(user)&& pass_Text.getText().equals(pass)){
                      log_in = true;
                      break;
                  }
                  else if (user_Text.getText().equals("admin")&& pass_Text.getText().equals("admin")){
                      log_in_admin = true;
                      break;
                  }
                }
                scan.close();
                if(log_in){
                    new Mother_Page();
                    dispose();
                }
                else if(log_in_admin){
                    new New_User();
                    dispose();
                }
                else{
                 JOptionPane.showMessageDialog(null, " your passwprd or user is not correct");
                    user_Text.setText("");
                    pass_Text.setText("");   
                }
                 } catch (FileNotFoundException ex) {
                Logger.getLogger(Password_frame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Password_frame.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            
    }
}

private class Cancel_ACT implements ActionListener
{
public void actionPerformed(ActionEvent e) 
{
    System.exit(1);
    
    }
    
}
}


            





