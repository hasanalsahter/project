package password_frame;


import com.sun.security.auth.module.JndiLoginModule;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class mem_Page {
    private final int w = 750;
    private final int h = 650;
    static JFrame Mem_P;
    static JTable table;
    private JPanel Panel_Mem_Act;
    private JButton Add_Button;
    private JButton Remove_Button;
    private JButton up_Button;
    private JButton Back_Button;
    private JButton Button_Clean;
    private JPanel Panel_text_label;
    static JTextField name;
    static JTextField sur_name;
    static JTextField gender;
    static JTextField age;
    static JTextField T_C;
    static JTextField telf;
    static JTextField blood;
    static JTextField start_day;
    static JTextField finsh_day;
    static JTextField ID;
    private JLabel name_Lable;
    private JLabel surname_Lable;
    private JLabel gender_Lable;
    private JLabel age_Lable;
    private JLabel T_C_Lable;
    private JLabel Telf_Lable;
    private JLabel blood_Lable;
    private JLabel start_day_Lable;
    private JLabel finsh_day_Lable;
    private JLabel Money_Lable;
    private JPanel panel_Text;
    private JScrollPane scrol;
    private JPanel table_panel;
    static Object[] r;
    static DefaultTableModel M;
    static String File_Name = "Members.txt";
   
    public mem_Page() throws IOException {
        
        Mem_P = new JFrame();
        Mem_P.setTitle("Member Page");
        Mem_P.setSize(w, h);
        Mem_P.setVisible(true);
        Mem_P.setDefaultCloseOperation(Mem_P.EXIT_ON_CLOSE);
        Mem_P.setLocationRelativeTo(null);
        //Mem_P.setLayout(null);
        Member_Page();
        Mem_P.add(Panel_Mem_Act);
        Mem_P.add(Panel_text_label);
        Mem_P.add(panel_Text);
        Mem_P.add(table_panel);
        
        Mem_P.setResizable(false);
       
        Button_Clean.addActionListener(new Clean_Text());
       Back_Button.addActionListener(new Return_ACT());
       Add_Button.addActionListener(new add_ACT());
       Remove_Button.addActionListener(new Remove_ACT());
       up_Button.addActionListener(new UP_ACT());
       table.addMouseListener(new M_ACT());
       
       File_read ();
    }

    private void Member_Page() {
    
        
    table = new JTable();
    String [] row_data  = { "ID","name","sur name","age","T.C","phone ","gender","Blood","Start","Finsh"};
    M = new DefaultTableModel();           
    M.setColumnIdentifiers(row_data );
    table.setModel(M);
   
    scrol = new JScrollPane(table);
    scrol.setPreferredSize(new Dimension(730, 330));
    table.setFillsViewportHeight(true);
  
    
    table_panel = new JPanel( );
    table.setRowHeight(1 , 40);
    table_panel.add(scrol);
    
       
        
    Panel_Mem_Act = new JPanel();
    Panel_Mem_Act.setBorder(BorderFactory.createEtchedBorder());
    Add_Button = new JButton("ADD");
    Remove_Button = new JButton("Remove");
    up_Button = new JButton("Update");
    Back_Button = new JButton("Back");
    Button_Clean = new JButton("clean");
    
    Add_Button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    Remove_Button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    up_Button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    Back_Button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    Button_Clean.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    Panel_Mem_Act.setBounds(600,360,100,220);
    Panel_Mem_Act.add(Add_Button);
    Panel_Mem_Act.add(Remove_Button);
    Panel_Mem_Act.add(up_Button);
    Panel_Mem_Act.add (Button_Clean);
    Panel_Mem_Act.add(Back_Button);
    
    Panel_text_label = new JPanel();
    
    
    name_Lable = new JLabel("ID:");
    surname_Lable = new JLabel("Name :");
    gender_Lable = new JLabel("surname:");
    age_Lable = new JLabel("Age:");
    T_C_Lable = new JLabel("T.C:");
    Telf_Lable = new JLabel("Phone:");
    blood_Lable = new JLabel("Gender:");
    start_day_Lable = new JLabel("Blood:");
    finsh_day_Lable = new JLabel("Start Day:");
    Money_Lable = new JLabel("Finsh Day:");
    
    Panel_text_label.setBounds(2, 350, 60, 300);
    
    Panel_text_label.setBorder(BorderFactory.createEtchedBorder());
    name_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    surname_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    gender_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    age_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    T_C_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    Telf_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    blood_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    start_day_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    finsh_day_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    Money_Lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    
    
    Panel_text_label.add(name_Lable);
    Panel_text_label.add(surname_Lable);
    Panel_text_label.add(gender_Lable);
    Panel_text_label.add(age_Lable);
    Panel_text_label.add(T_C_Lable);
    Panel_text_label.add(Telf_Lable);
    Panel_text_label.add(blood_Lable);
    Panel_text_label.add(start_day_Lable);
    Panel_text_label.add(finsh_day_Lable);
    Panel_text_label.add(Money_Lable);
    
    
    
    panel_Text = new JPanel();
    
   
    panel_Text.setBounds(75,350,160,300);
    
    name = new JTextField(14);
    sur_name = new JTextField(14);
    gender = new JTextField(14);
    age = new JTextField(14);
    T_C = new JTextField(14);
    telf = new JTextField(14);
    blood = new JTextField(14);
    start_day= new JTextField(14);
    finsh_day = new JTextField(14);
    ID = new JTextField(14);
    
    panel_Text.add(ID);        
    panel_Text.add(name);
    panel_Text.add(sur_name);
    panel_Text.add(age);
    panel_Text.add(T_C);
    panel_Text.add(telf);
    panel_Text.add(gender);
    panel_Text.add(blood);
    panel_Text.add(start_day);
    panel_Text.add(finsh_day);
    
    }

    private static class Return_ACT implements ActionListener {  
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
     
            new Mother_Page();
            Mem_P.dispose();
        }
    }
    
    private static class add_ACT implements  ActionListener  {

       
        @Override
        public void actionPerformed(ActionEvent e)  {
            
                 
         
          M = (DefaultTableModel)table.getModel();
     r = new Object[10];
     
     r [0] = ID.getText();
     r [1] = name.getText();
     r [2] = sur_name.getText();
     r [3] = age.getText();            
     r [4] = T_C.getText();
     r [5] = telf.getText();
     r [6] = gender.getText();
     r [7] = blood.getText();
     r [8] = start_day.getText();
     r [9] = finsh_day.getText();
     
    M.addRow(r);
    file_ACT();
         
        }
    }
  
    
    private static class Remove_ACT implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            
            
           M = (DefaultTableModel)table.getModel();  
           int GetRow= table.getSelectedRow();
           
           if(GetRow >=0 ){
               M.removeRow(GetRow);
               file_ACT();
               
           }
           else{
               JOptionPane.showMessageDialog(null, "you didnt selct anything");
           }    
        }
    }

    private static class M_ACT implements MouseListener {

      
        @Override
        public void mouseClicked(MouseEvent e) {
            
        M = (DefaultTableModel)table.getModel(); 
        int Get_Row = table.getSelectedRow();
        
        ID.setText(M.getValueAt(Get_Row, 0).toString());
        name.setText(M.getValueAt(Get_Row, 1).toString());
        sur_name.setText(M.getValueAt(Get_Row, 2).toString());
        age.setText(M.getValueAt(Get_Row, 3).toString());
        T_C.setText(M.getValueAt(Get_Row, 4).toString());
        telf.setText(M.getValueAt(Get_Row, 5).toString());
        gender.setText(M.getValueAt(Get_Row, 6).toString());
        blood.setText(M.getValueAt(Get_Row, 7).toString());
        start_day.setText(M.getValueAt(Get_Row, 8).toString());
        finsh_day.setText(M.getValueAt(Get_Row, 9).toString());
            
     //  boolean Edit =table.isEditing();
        
       // if(Edit == false)
        //{
             
        //} 
        
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

       
       
    }

    private static class UP_ACT implements ActionListener {

        

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int Get_row= table.getSelectedRow();
            M = (DefaultTableModel)table.getModel(); 
            
            if(Get_row >= 0)
            {
            M.setValueAt(ID.getText(), Get_row, 0);
            M.setValueAt(name.getText(), Get_row, 1);
            M.setValueAt(sur_name.getText(), Get_row, 2);
            M.setValueAt(age.getText(), Get_row, 3);
            M.setValueAt(T_C.getText(), Get_row, 4);
            M.setValueAt(telf.getText(), Get_row, 5);
            M.setValueAt(gender.getText(), Get_row, 6);
            M.setValueAt(blood.getText(), Get_row, 7);
            M.setValueAt(start_day.getText(), Get_row, 8);
            M.setValueAt(finsh_day.getText(), Get_row, 9);
            file_ACT();
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Error");  
            }   
            
        }
    }
    private static void file_ACT(){
       
        File F = new File(File_Name);
        try {
        FileWriter fw =new FileWriter(F);
        BufferedWriter bw = new BufferedWriter(fw);
            
        for(int row= 0 ; row < table.getRowCount() ; row ++ ){// read the row
           for( int col = 0 ; col < table.getColumnCount() ; col ++ ){
             bw.write(table.getValueAt(row, col).toString() + " " );
                
                }
           bw.newLine();
            }
        
        bw.close();
        fw.close();
        
        
        } 
        catch (IOException ex) {
            Logger.getLogger(mem_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void File_read () throws IOException{
        File F = new File(File_Name);
        
        try {
            M = (DefaultTableModel)table.getModel(); 
            
            FileReader fr = new FileReader(F);
            BufferedReader br= new BufferedReader(fr);
            r = br.lines().toArray();
            for (int i = 0 ; i < r.length ; i ++){
            
                
                String [] row = r[i].toString().split(" ");
                M.addRow(row);
                br.close();
                fr.close();
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mem_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private static class Clean_Text implements ActionListener {

       
        @Override
        public void actionPerformed(ActionEvent e) {
            name.setText("");
            sur_name.setText("");
            age.setText("");
            T_C.setText("");
            telf.setText("");
            blood.setText("");
            start_day.setText("");
            finsh_day.setText("");
            gender.setText("");
            ID.setText("");
        }
    }
}  