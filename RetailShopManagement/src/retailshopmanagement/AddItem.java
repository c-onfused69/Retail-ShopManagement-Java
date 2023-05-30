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
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static retailshopmanagement.RetailShopManagement.home;

public class AddItem implements ActionListener{
    
    JButton add=new JButton("Add");
    JButton delete=new JButton("Delete");
    JButton update=new JButton("Update");
    JButton clear=new JButton("Clear");
           Font jf= new Font("Arial",Font.BOLD+Font.HANGING_BASELINE,14);

    JTextField t1,t2,t3,t4;  
    JFrame frame;
    JLabel l1,l2,l3,l4,l5; 
        JButton back=new JButton("Back");
    JTable table;
    JScrollPane scroll;
    DefaultTableModel model;
    
    String col[]={"Product code","Product name ","Price","Stock"};
    String row[]=new String[4];
    
    AddItem(){
    frame=new JFrame();
       
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
  
  add.setBounds(450, 50, 150,30);
      add.addActionListener(this);
      frame.add(add);
  
   delete.setBounds(450, 90, 150,30);
      delete.addActionListener(this);
      frame.add(delete);
  
  
   update.setBounds(450, 130, 150,30);
      update.addActionListener(this);
      frame.add(update);
  clear.setBounds(450, 170, 150,30);
      clear.addActionListener(this);
      frame.add(clear);
  
  backButton();
  
        back.addActionListener(this);
 clear.addActionListener(this);

  back.setFont(jf);
   add.setFont(jf);
    update.setFont(jf);
     delete.setFont(jf);
  
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
   frame.add(t1); frame.add(t2);    frame.add(t3); frame.add(t4);  
   t1.setFont(jf);
   t3.setFont(jf);
   t2.setFont(jf);
   t4.setFont(jf);
 }
void AddLebel(){
 l1=new JLabel("Product Code :");  
    l1.setBounds(10,50, 150,30);  
    l2=new JLabel("Product Name :");  
    l2.setBounds(10,90, 150,30);
    l3=new JLabel("Price         :");  
    l3.setBounds(10,130, 150,30);  
    l4=new JLabel("Stock        :");  
    l4.setBounds(10,170, 150,30);
 frame.add(l1);
    frame.add(l2); 
    frame.add(l3);
    frame.add(l4);

l1.setFont(jf);l2.setFont(jf);l3.setFont(jf);l4.setFont(jf);


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
File file=new File("Itemlist.txt");
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
            File fm=new File("Itemlist.txt");
                     
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
