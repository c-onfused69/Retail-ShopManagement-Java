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
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Bill implements ActionListener{

     JButton add=new JButton("Add to cart");
    JButton delete=new JButton("Delete");
    JButton next=new JButton("Next");
    JButton print=new JButton("Print");
    JButton printback=new JButton("Back");
    JFrame bframe=new JFrame("Print bill");
          Font jf= new Font("Arial",Font.BOLD+Font.HANGING_BASELINE,14);

    JTextField t1,t2,t3,t4,t6,t7;  
    JFrame frame;
    JLabel l1,l2,l3,l4,l5,l6,l7; 
     JTextArea area;
    JTable table;
    JScrollPane scroll;
    DefaultTableModel model;
     JButton back=new JButton("Back");
    String col[]={"Product code","Name ","Quantity","Unit Price","Total price"};
    String row[]=new String[5];
    
    
    double totalprice=0;
    
    double vat=5;
    
    Bill(){
      frame=new JFrame("PAYMENT");
       
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
  //  SelectedRow();
    customerInfo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    }

    
     @Override
    public void actionPerformed(ActionEvent ae) {
                 //  AddItem i =new AddItem();
            if(ae.getSource()==add){     
                
          
                
                
                
             
               model.addRow(addtocart());}
            if(ae.getSource()==delete){
            int r= table.getSelectedRow();
            if(r>=0)
            {
                totalprice-= Integer.parseInt(model.getValueAt(r, 3).toString());
                
                
                model.removeRow(r);
             }
            else
              JOptionPane.showMessageDialog(null,"No row has been Selected!");   
            
            
            
            
            }
                    if(ae.getSource()==next){
              
                        newwindow();

             
                        
                    }         
                 
                 if(ae.getSource()==print){
                 
                try {
                    area.print();
                   
                } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null,"ERROR! unable to print."); 
                }
                 
                 }
if(ae.getSource()== back){
RetailShopManagement kk =new RetailShopManagement();
frame.setVisible(false);

}
if(ae.getSource()== printback){
area.setText("");
bframe.setVisible(false);

}
          // JOptionPane.showMessageDialog(null,"Hello, Welcome to Javatpoint."); 
    }
  void AddButton(){
  
  add.setBounds(60, 220, 150,30);
      add.addActionListener(this);
      frame.add(add);
  
   delete.setBounds(290, 220, 150,30);
      delete.addActionListener(this);
      frame.add(delete);
  
  
     next.setBounds(500, 220, 150,30);
      next.addActionListener(this);
      frame.add(next);
  
  backButton();
  
        back.addActionListener(this);

  add.setFont(jf);
 delete.setFont(jf);
  next.setFont(jf);
  
  
  
  }
    
 void AddtextView(){
 

    t1=new JTextField();  
    t1.setBounds(170,50, 150,30);  
    t2=new JTextField("1");  
    t2.setBounds(490,50, 150,30);  
    frame.add(t1); frame.add(t2);  
 t1.setFont(jf);
 t1.setFont(jf);

//    t3=new JTextField();  
//    t3.setBounds(200,110, 200,30); 
// 
//    t4=new JTextField();  
//    t4.setBounds(200,150, 200,30); 
   frame.add(t1); frame.add(t2);
   //frame.add(t3); frame.add(t4);  
 }
void AddLebel(){
 l1=new JLabel("Product code");  
    l1.setBounds(10,50, 100,30);  
    l2=new JLabel("Quantity");  
    l2.setBounds(330,50, 100,30);
//    l3=new JLabel("Price");  
//    l3.setBounds(50,110, 100,30);  
//    l4=new JLabel("VAT");  
//    l4.setBounds(50,150, 100,30);
 frame.add(l1);
    frame.add(l2); 
//    frame.add(l3);
//    frame.add(l4);

l1.setFont(jf);
l2.setFont(jf);
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
scroll.setBounds(10, 300, 760, 300);

frame.add(scroll);




}    
  
//void SelectedRow(){
//
//table.addMouseListener(new MouseAdapter() {
//
//public void mouseClicked(MouseEvent e){
//int r=table.getSelectedRow();
//String id=model.getValueAt(r, 0).toString();
//String name=model.getValueAt(r, 1).toString();
//String price=model.getValueAt(r, 2).toString();
//String vat=model.getValueAt(r, 3).toString();
//t1.setText(id);
//t2.setText(name);
//t3.setText(price);
//t4.setText(vat);
//
//
//}
//
//
//});
//
//}


String[] addtocart(){
    File file=new File("Itemlist.txt");
 Scanner reader;
        try {
            reader=new Scanner(file);
            
           while(reader.hasNext()){
          row[0]=reader.next();
          row[1]=reader.next();
          row[3]=reader.next();
          row[4]=reader.next();
          
          int id=Integer.parseInt(row[0]);
          if(id==Integer.parseInt(t1.getText().toString()))
          {
              
            int q =Integer.parseInt(t2.getText().toString());
             row[2]= t2.getText().toString();
            int sum=q*(Integer.parseInt(row[3]));
            row[4]=String.valueOf(sum);
            totalprice+=sum;
              break;
          }

}
           reader.close();
           
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }   
    return row;           

}    
   
void newwindow(){


bframe.setSize(600,600);
bframe.setLocationRelativeTo(null);
  area=new JTextArea();  
 area.setBounds(10,50,500,400);  
bframe.add(area);




area.setEditable(false);
printback.setBounds(10,500,100,30);
bframe.add(printback);

   print.setBounds(350, 500, 150,30);
      print.addActionListener(this);
      printback.addActionListener(this);
area.setFont(jf);
      bframe.add(print);
bframe.setLayout(null);
bframe.getContentPane().setBackground(new Color(188,230,235,255));
bframe.setVisible(true);
area.append("\n                                 Aquarius Aquarium Shop Management System \n____________________________________________\n");
area.append("Customer name : "+t6.getText()+"\n\n"+"Mobile number :"+t7.getText()+"\n\n================================================\n");
area.append("Id     Product name      Unit        Per unit price     Total price \n");
int l=table.getRowCount();
    for (int i = 0; i < l; i++) {
        area.append(model.getValueAt(i,0)+"      "+model.getValueAt(i,1)+"                        "+model.getValueAt(i,2)+"             "+model.getValueAt(i,3)+"              "+model.getValueAt(i, 4)+"\n");

    }
double vatp;
         vatp = (totalprice*5)/100;
         double grandtotal;
         grandtotal = vatp+totalprice;
area.append("\n___________________________________________________________\n                                                                               Total : "+totalprice+"\n \n                                                                       Vat(5%)  :"+vatp);
area.append("\n\n========================================================\n                                                                    Grand Total : "+grandtotal+"\n\n");

  try {
                    savebilltofile();
                } catch (Exception ex) {
                  //  Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
                       JOptionPane.showMessageDialog(null,ex);   
                }

}    
    
void customerInfo(){
 l6=new JLabel("Customer name : ");  
    l6.setBounds(10,10, 150,30);  
 t6=new JTextField();
 t6.setBounds(170, 10, 150, 30);
   l7=new JLabel("Phone number :");  
    l7.setBounds(330,10, 150,30);
   t7=new JTextField();
 t7.setBounds(490, 10, 150, 30);
 frame.add(t6);
 frame.add(t7);
 frame.add(l6);
 frame.add(l7);
l6.setFont(jf);
l7.setFont(jf);
 t6.setFont(jf);
 t7.setFont(jf);
}    
 void savebilltofile() throws Exception{
 
 
 String bb=area.getText();
 
  try {
            File fm=new File("BillRecord.txt");
                     
                FileWriter input =new FileWriter(fm,true);
 //JOptionPane.showMessageDialog(null,"Bill record saved"); 
//JOptionPane.showMessageDialog(null,"File Created");   
        input.write(bb);
           input.close();
        } catch (FileNotFoundException ex) {
 JOptionPane.showMessageDialog(null,"File not found");         }

 
 
 
 
 }   
  



void backButton(){

back.setBounds(10,700,100,30);
frame.add(back);
}
 
 
//    public static void main(String[] args) {
//        new Bill();
//    }

}
