
package password_frame;
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





public class New_User {
    static  JFrame Add_user; 
    static JTable table_user_1;
    static JScrollPane table_user_j;
    private JButton add_user_button;
    private JButton del_user_button;
    private JButton update_user_button;
    private JPanel panel_button_user;
    private JLabel user_user_lable;
    private JLabel user_pass_lable ;
    private JPanel panel_lable;
    static JTextField Text_user;
    static JTextField Text_pass;
    private JPanel Text_panel;
    static  DefaultTableModel model;
    static Object [] data_1;
    private JPanel table_panle;
    private  JButton Clear_button;
    static  String File_Name = "pass.txt";
    
    public New_User() throws IOException{
        Add_user = new JFrame();
        Add_user.setTitle("User page");
        Add_user.setSize(500, 400);
        Add_user.setVisible(true);
        Add_user.setDefaultCloseOperation(Add_user.EXIT_ON_CLOSE);
        Add_user.setLocationRelativeTo(null);
        
        Add_user.setLayout(null);
        //Add_user.setLayout(new BorderLayout());
        page_add_method();
        Add_user.add(panel_button_user);
        Add_user.add(panel_lable);
        Add_user.add(Text_panel);
        Add_user.add(table_panle);
        Add_user.setResizable(false);
        
        File_reader();
        
        add_user_button.addActionListener(new ADD_User());
        del_user_button.addActionListener(new DEL_User());
        update_user_button.addActionListener(new UP_User());
        Clear_button.addActionListener(new Clear_text());
        table_user_1.addMouseListener(new mouse_c());
        
        
        
        
    }

    private void page_add_method() {
        table_user_1= new JTable();
        String [] data = {"user name" , "password"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(data );
        table_user_1.setModel(model);
        
        table_user_j = new JScrollPane(table_user_1);
        table_user_j.setPreferredSize(new Dimension(400, 250));
        table_user_1.setFillsViewportHeight(true);
       
        
        table_panle = new JPanel();
        table_panle.add(table_user_j);
        table_panle.setBounds(5, 5, 500, 500);
        
        
        
        panel_lable = new JPanel();
        user_user_lable = new JLabel("user");
        user_pass_lable = new JLabel("passowrd");
        
        panel_lable.setBounds(2, 300, 60, 50);
        
        panel_lable.add(user_user_lable);
        panel_lable.add(user_pass_lable);
        
        user_user_lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        user_pass_lable.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        
       
    Text_panel = new JPanel();
    
    Text_user = new JTextField(10);
    Text_pass = new JTextField(10);
    
    Text_panel.setBounds(45, 300, 160, 50);
    
    Text_panel.add(Text_user);
    Text_panel.add(Text_pass);
    
    
    
        
        
    panel_button_user = new JPanel();
    add_user_button = new JButton("Add");
    del_user_button = new JButton("Delet");
    update_user_button = new JButton("Update");
    Clear_button = new JButton("clean");
    
    
    panel_button_user.setBounds(270, 270, 200, 100);
    
    panel_button_user.add(add_user_button);
    panel_button_user.add(del_user_button);
    panel_button_user.add(update_user_button);
    panel_button_user.add(Clear_button);
    
    
    }

    private static class ADD_User implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model = (DefaultTableModel)table_user_1.getModel();
            data_1  =  new Object[2];
            
            
            data_1[0] = Text_user.getText();
            data_1[1] = Text_pass.getText();
                 
            model.addRow(data_1);
            file_Writer();
        }
    }


    private static class DEL_User implements ActionListener {

        

        @Override
        public void actionPerformed(ActionEvent e) {
            model = (DefaultTableModel) table_user_1.getModel();
            int Get_row = table_user_1.getSelectedRow();;
            
            
            if(Get_row >= 0 ){
               model.removeRow(Get_row);
               file_Writer();
               
               
           }
           else{
               JOptionPane.showMessageDialog(null, "you didnt selct anything");
           }    
        
        }
    }

    private static class UP_User implements ActionListener {
            
        

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int Get_row = table_user_1.getSelectedRow();
            model = (DefaultTableModel)table_user_1.getModel();
             if (Get_row >= 0)
            {
               model.setValueAt(Text_user.getText(),Get_row,0);
                model.setValueAt(Text_pass.getText(), Get_row, 1);
                file_Writer();
                
            }
        }
    }

    private static class Clear_text implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
           Text_user.setText("");
           Text_pass.setText("");
            
            
        }
    }

    private static class mouse_c implements MouseListener {

        public mouse_c() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            model = (DefaultTableModel)table_user_1.getModel();
            int Get_row =table_user_1.getSelectedRow();
            Text_user.setText(model.getValueAt(Get_row, 0).toString());
           Text_pass.setText(model.getValueAt(Get_row, 1).toString());
            
            
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
    private static void file_Writer(){
       
        File F = new File(File_Name);
        try {
        FileWriter fw =new FileWriter(F);
        BufferedWriter bw = new BufferedWriter(fw);
            
        for(int row= 0 ; row < table_user_1.getRowCount() ; row ++ ){// read the row
           for( int col = 0 ; col < table_user_1.getColumnCount() ; col ++ ){
             bw.write(table_user_1.getValueAt(row, col).toString()  );
                if (col!=3){
                    bw.write(":");
                }
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
    private static void File_reader () throws IOException{
        File F = new File(File_Name);
        
        try {
            model = (DefaultTableModel)table_user_1.getModel(); 
            
            FileReader fr = new FileReader(F);
            BufferedReader br= new BufferedReader(fr);
            data_1 = br.lines().toArray();
            for (int i = 0 ; i < data_1.length ; i ++){
            
                
                String [] row = data_1[i].toString().split(":");
                model.addRow(row);
                br.close();
                fr.close();
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mem_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}