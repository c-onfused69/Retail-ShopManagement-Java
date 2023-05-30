/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshopmanagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class BillRecord implements ActionListener{
    
    
  JButton back=new JButton("Back");  
    JTextArea area;
           Font jf= new Font("Arial",Font.BOLD+Font.HANGING_BASELINE,18);

    JFrame frame=new JFrame("Bill Record ");
    BillRecord(){
    frame.setSize(800,800);
    area= new JTextArea();
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    backButton();
    JScrollPane scroll= new JScrollPane(area);
    scroll.setBounds(50,20,700,680);
    frame.setVisible(true);
    area.setFont(jf);
    area.setEditable(false);
    frame.add(scroll);
    back.addActionListener(this);
    displaybill();
            }
    void displaybill(){
       File file=new File("BillRecord.txt");
 Scanner reader;
        try {
            reader=new Scanner(file);
            
           while(reader.hasNext()){
          String s= reader.nextLine()+"\n";
          area.append(s);

}
           reader.close();
           
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
if(ae.getSource()== back){
Admin kk =new Admin();
frame.setVisible(false);



}
    }
 
    
    void backButton(){

back.setBounds(10,700,100,30);
frame.add(back);
back.setFont(jf);







}
}
