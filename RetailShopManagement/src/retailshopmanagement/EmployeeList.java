/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshopmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class EmployeeList implements ActionListener {
     JButton add=new JButton("Add Employee");
    JButton delete=new JButton("Remove Employee");
    JButton update=new JButton("Update");
    JButton clear=new JButton("Clear");
    JTextField t1,t2,t3,t4;  
    JFrame frame;
    JLabel l1,l2,l3,l4,l5; 
        JButton back=new JButton("Back");
    JTable table;
    JScrollPane scroll;
    DefaultTableModel model;
           Font jf= new Font("Arial",Font.BOLD+Font.HANGING_BASELINE,14);

    String col[]={"Employee Name","Designation ","Salary","Date of Joining"};
    String row[]=new String[4];
    
    EmployeeList(){
    frame=new JFrame();
       
   //frame.getContentPane().setBackground(Color.CYAN);
   frame.getContentPane().setBackground(new Color(32,85,99,255));
    frame.setSize(800,800);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    // add.setBounds(300, 260, 100,80);
     // add.addActionListener(this);
     // frame.add(add);
   AddLebel();
    AddtextView();
    AddButton();
    AddTable();
    SelectedRow();
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
 @Override
    public void actionPerformed(ActionEvent ae) {
                 //  AddItem i =new AddItem();
            if(ae.getSource()==add){     
                try {
                    row[0]=t1.getText();
                    row[1]=t2.getText();
                    row[2]=t3.getText();
                    row[3]=t4.getText();
                    model.addRow(row);
                    SaveItem(row[0],row[1],row[2],row[3]);
                } catch (Exception ex) {
                                  JOptionPane.showMessageDialog(null,"Data could not be saved!");   

                }
            }
            if(ae.getSource()==delete){
            int r= table.getSelectedRow();
            if(r>=0)
                model.removeRow(r);
            else
              JOptionPane.showMessageDialog(null,"No row has been Selected!");   
            
            
            
            
            }
                    if(ae.getSource()==update){
                        int r=table.getSelectedRow();
              row[0]=t1.getText();
             row[1]=t2.getText();
             row[2]=t3.getText();
             row[3]=t4.getText();
             model.setValueAt(row[0], r, 0);
             model.setValueAt(row[1], r, 1);
             model.setValueAt(row[2], r, 2);
             model.setValueAt(row[3], r, 3);

             
                        
                    }         
                 
              

if(ae.getSource()== back){
Admin kk =new Admin();
kk.setVisible(true);
frame.setVisible(false);

}
if(ae.getSource()== clear){
t1.setText("");
             t2.setText("");
             t3.setText("");
             t4.setText("");

}
          // JOptionPane.showMessageDialog(null,"Hello, Welcome to Javatpoint."); 
    }
  void AddButton(){
  
  add.setBounds(450, 50, 200,30);
      add.addActionListener(this);
      frame.add(add);
  
   delete.setBounds(450, 90, 200,30);
      delete.addActionListener(this);
      frame.add(delete);
  
  
   update.setBounds(450, 130, 200,30);
      update.addActionListener(this);
      frame.add(update);
  
  
  backButton();
  
        back.addActionListener(this);

  add.setFont(jf);
    delete.setFont(jf);
  update.setFont(jf);
  back.setFont(jf);

  
  }
    
 void AddtextView(){
 

    t1=new JTextField();  
    t1.setBounds(200,50, 200,30);  
    t2=new JTextField();  
    t2.setBounds(200,90, 200,30);  
    frame.add(t1); frame.add(t2);  
 
    t3=new JTextField();  
    t3.setBounds(200,130, 200,30); 
 
    t4=new JTextField();  
    t4.setBounds(200,170, 200,30); 
    t1.setFont(jf);
     t2.setFont(jf);
      t3.setFont(jf);
       t4.setFont(jf);
   frame.add(t1); frame.add(t2);    frame.add(t3); frame.add(t4);  
 }
void AddLebel(){
 l1=new JLabel("Employee Name:");  
    l1.setBounds(20,50, 150,30);  
    l2=new JLabel("Designation :");  
    l2.setBounds(20,90, 150,30);
    l3=new JLabel("Sallary     :");  
    l3.setBounds(20,130, 150,30);  
    l4=new JLabel("Date of Joining");  
    l4.setBounds(20,170, 150,30);
 frame.add(l1);
    frame.add(l2); 
    frame.add(l3);
    frame.add(l4);

l1.setFont(jf);
l2.setFont(jf);
l3.setFont(jf);
l4.setFont(jf);
} 
    
void AddTable(){

table =new JTable();
model=new DefaultTableModel();
model.setColumnIdentifiers(col);
table.setModel(model);
table.setSelectionBackground(Color.yellow);
table.setBackground(new Color(188,230,235,255));
table.setRowHeight(30);
scroll =new JScrollPane(table);
scroll.setBounds(10, 400, 760, 300);

frame.add(scroll);
File file=new File("EmployeeList.txt");
 Scanner reader;
        try {
            reader=new Scanner(file);
            
           while(reader.hasNext()){
          row[0]=reader.next();
          row[1]=reader.next();
          row[2]=reader.next();
          row[3]=reader.next();
          model.addRow(row);


}
           reader.close();
           
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File not found"); 
           // Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }


}    
  
void SelectedRow(){

table.addMouseListener(new MouseAdapter() {

public void mouseClicked(MouseEvent e){
int r=table.getSelectedRow();
String id=model.getValueAt(r, 0).toString();
String name=model.getValueAt(r, 1).toString();
String price=model.getValueAt(r, 2).toString();
String vat=model.getValueAt(r, 3).toString();
t1.setText(id);
t2.setText(name);
t3.setText(price);
t4.setText(vat);


}






});










}

void SaveItem(String id,String name,String price,String vat) throws Exception{

        try {
            File fm=new File("EmployeeList.txt");
                     
                FileWriter input =new FileWriter(fm,true);

            String s=id+" "+name+" "+price+" "+vat+"\n";
        //    fm.format("%s %s %s %s\r\n",id,name,price,vat);
        input.write(s);
           input.close();
        } catch (FileNotFoundException ex) {
 JOptionPane.showMessageDialog(null,"File not found");         }



}
  
void backButton(){

back.setBounds(10,700,100,30);
frame.add(back);
} 
    
}
