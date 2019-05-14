package password_frame;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class See_Info_Page {
static JFrame info_page;
private JPanel Info_Textfeld_panel;
private JPanel Info_Label_panel;
private JPanel But_panel;
static JTextField info_name;
static JTextField info_sur_name;
static JTextField info_gender;
static JTextField info_age;
static JTextField info_TC;
static JTextField info_telf;             
static JTextField info_blood;
static JTextField info_start_day;
static JTextField info_finsh_day;
static JTextField info_ID;
static JTextField S_Space;
private JLabel S_Lable;
private JLabel info_name_Lable;
private JLabel info_surname_Lable;
private JLabel info_gender_Lable;
private JLabel info_age_Lable;
private JLabel info_TC_Lable;
private JLabel info_Telf_Lable;
private JLabel info_blood_Lable;
private JLabel info_start_day_Lable;
private JLabel info_finsh_day_Lable;
private JLabel info_ID_Lable;
private JButton Back_But;
private JButton S_But;
//static String[] r;
static String[] arrSplit;
static String File_Name = "Members.txt";

   
    public See_Info_Page() {
    
    
    info_page = new JFrame("searsh");
   
    info_page.setSize(400,320);
        info_page.setVisible(true);
        info_page.setDefaultCloseOperation(info_page.EXIT_ON_CLOSE);
        info_page.setLocationRelativeTo(null);
        info_page.setLayout(null);
        
        see_Inf_page_1();
        info_page.add(Info_Textfeld_panel);
        info_page.add(Info_Label_panel);
        info_page.add(But_panel);
        info_page.setBackground(Color.GRAY);
        Info_Textfeld_panel.setBackground(Color.GRAY);
        Info_Label_panel.setBackground(Color.GRAY);
        But_panel.setBackground(Color.GRAY);

         
        info_page.setLocationRelativeTo(null);
	info_page.setResizable(false);
        S_But.addActionListener(new search_ACT());
        Back_But.addActionListener(new INFO_BACK_ACT());
    }

    private void see_Inf_page_1() {
    
         
    Info_Label_panel = new JPanel();
    S_Lable = new JLabel(" search ID :");
    info_ID_Lable = new JLabel("    ID     :");
    info_name_Lable = new JLabel("Name     :");
    info_surname_Lable = new JLabel(" Surname :");
    info_age_Lable = new JLabel("    age     :");
    info_TC_Lable = new JLabel("    TC      :");
    info_Telf_Lable = new JLabel(" Phone    :");
    info_gender_Lable = new JLabel("Gender   :");
    info_blood_Lable = new JLabel("Blood tayp:");
    info_start_day_Lable = new JLabel("Start Day:");
    info_finsh_day_Lable = new JLabel("Finsh Day:");
    
    
    info_start_day_Lable.setOpaque(true);
    S_Lable.setOpaque(true);
    info_ID_Lable.setOpaque(true);
    info_name_Lable.setOpaque(true);
    info_surname_Lable.setOpaque(true);
    info_age_Lable.setOpaque(true);
    info_TC_Lable.setOpaque(true);
    info_Telf_Lable.setOpaque(true);
    info_gender_Lable.setOpaque(true);
    info_blood_Lable.setOpaque(true);
    info_finsh_day_Lable.setOpaque(true);
    
    info_start_day_Lable.setBackground(Color.WHITE);
    S_Lable.setBackground(Color.WHITE);
    info_ID_Lable.setBackground(Color.WHITE);
    info_name_Lable.setBackground(Color.WHITE);
    info_surname_Lable.setBackground(Color.WHITE);
    info_age_Lable.setBackground(Color.WHITE);
    info_TC_Lable.setBackground(Color.WHITE);
    info_Telf_Lable.setBackground(Color.WHITE);
    info_gender_Lable.setBackground(Color.WHITE);
    info_blood_Lable.setBackground(Color.WHITE);
    info_finsh_day_Lable.setBackground(Color.WHITE);
 
    Info_Label_panel.setBounds(1, 2, 75, 300);
    S_Lable.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
    info_name_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_surname_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_gender_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_age_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_TC_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_Telf_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_blood_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_start_day_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_finsh_day_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_ID_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    
    Info_Label_panel.add(S_Lable);
    Info_Label_panel.add(info_ID_Lable);
    Info_Label_panel.add(info_name_Lable);
    Info_Label_panel.add(info_surname_Lable);     
    Info_Label_panel.add(info_age_Lable);
    Info_Label_panel.add(info_TC_Lable);
    Info_Label_panel.add(info_Telf_Lable);
    Info_Label_panel.add(info_gender_Lable);
    Info_Label_panel.add(info_blood_Lable);
    Info_Label_panel.add(info_start_day_Lable);
    Info_Label_panel.add(info_finsh_day_Lable);
    
    
    
    Info_Textfeld_panel = new JPanel();
    S_Space = new JTextField(13);
    info_ID = new JTextField(13);
    info_name = new JTextField(13);
    info_sur_name = new JTextField(13);
    info_age = new JTextField(13);
    info_TC = new JTextField(13);
    info_telf = new JTextField(13);
    info_gender = new JTextField(13);
    info_blood = new JTextField(13);
    info_start_day = new JTextField(13);
    info_finsh_day= new JTextField(13);
    
    
    Info_Textfeld_panel.setBounds(75, 2, 220, 300);
    S_Space.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
    info_name.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_sur_name.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_gender.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_age.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_TC.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_telf.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_blood.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_start_day.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_finsh_day.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    info_ID.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    
    Info_Textfeld_panel.add(S_Space);
    Info_Textfeld_panel.add(info_ID);
    Info_Textfeld_panel.add(info_name);
    Info_Textfeld_panel.add(info_sur_name);
    Info_Textfeld_panel.add(info_age);
    Info_Textfeld_panel.add(info_TC);
    Info_Textfeld_panel.add(info_telf);
    Info_Textfeld_panel.add(info_gender);
    Info_Textfeld_panel.add(info_blood);
    Info_Textfeld_panel.add(info_start_day);
    Info_Textfeld_panel.add(info_finsh_day);
    
    info_ID.setEditable(false);
    info_name.setEditable(false);
    info_sur_name.setEditable(false);
    info_age.setEditable(false);
    info_TC.setEditable(false);
    info_telf.setEditable(false);
    info_blood.setEditable(false);
    info_start_day.setEditable(false);
    info_finsh_day.setEditable(false);
    info_gender.setEditable(false);

    But_panel = new JPanel();
    S_But = new JButton("searsh");
    Back_But = new JButton(" Back  ");
    
    But_panel.setBounds(285, 2, 110, 290);
    S_But.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
    Back_But.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
   
    
    But_panel.add(S_But);
    But_panel.add(Back_But);
    
    }

    private static class search_ACT implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        
            ArrayList<String> taker_info = new ArrayList<String>();
            try{
            File file = new File(File_Name);
            Scanner scan = new Scanner(file);
            
            String line;
            
            while(scan.hasNext()){
                line = scan.nextLine();
                
                taker_info.add(line);
                
            }
            scan.close();
            
            String[] arry_hold = new String[taker_info.size()];// to hand the value from arrylist
            String[] split ;//to spelt the data in holder arry
            String[] split_arr = new String[taker_info.size()];// to hold the first colem in the data wich is the ID and comber it with the key  
          
           for (int i = 0; i<= taker_info.size() - 1; i++ ){// print the value insde the arrray list into the arry_s -1 beacase .size alowese start from 1
            arry_hold[i]= taker_info.get(i);//take the value from arrlist into arry_s String []
            
            split = arry_hold[i].split(" ");// its hand the value that inside Arry_s and split with spasec
            
            split_arr[i]= split[0];// to take the first elment which is the ID and comper that i giong to combeber it woth the other elment
           } 
                               
           int elment_palce = Arrays.binarySearch(split_arr, S_Space.getText());//it is get the number of the elment paramter is object [] , object key
             
                      
           split= arry_hold[elment_palce].split(" ");  // to spilt the line that we chose by binery search 
            
           for( int rederfile= 0; rederfile <=split.length ; rederfile++)
           if (split[rederfile].equals(S_Space.getText())){
              info_ID.setText(split[rederfile]);
              info_name.setText(split[rederfile+1]);
              info_sur_name.setText(split[rederfile+2]);
              info_age.setText(split[rederfile+3]);
              info_TC.setText(split[rederfile+4]);
              info_telf.setText(split[rederfile+5]);
              info_gender.setText(split[rederfile+6]);
              info_blood.setText(split[rederfile+7]);
              info_start_day.setText(split[rederfile+8]);
              info_finsh_day.setText(split[rederfile+9]);
                
            }
            
            }
            catch(Exception ex){
                ex.getStackTrace();
                
            }
            
            
            
        
       
        
        
}
    }       
        
    private static class INFO_BACK_ACT implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new Mother_Page();
            info_page.dispose();
        }
    }
    
}

