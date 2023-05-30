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
import javax.swing.*;
import static retailshopmanagement.RetailShopManagement.home;


 class Admin extends JFrame implements ActionListener {
    
     JButton additem=new JButton("Add Item");
     JButton billrecord= new JButton("Bill Record");
     JButton employeelist= new JButton("Enployee list");
    // JButton itemlist= new JButton("Item list");
     
     JButton back=new JButton("Back");
       

     
       Font jf= new Font("Arial",Font.BOLD+Font.HANGING_BASELINE,18);

     
     
     Admin(){
     setTitle("Admin page");
     setLayout(null);
    setSize(800,800);
      additem.setBounds(300, 260, 200,30);
      additem.addActionListener(this);
      add(additem);
      //getContentPane().setBackground(Color.cyan);
      getContentPane().setBackground(new Color(32,85,99,255));
    setLocationRelativeTo(null);

       billrecord.setBounds(300, 300, 200,30);
      billrecord.addActionListener(this);
      add(billrecord);
      employeelist.setBounds(300, 340, 200,30);
      employeelist.addActionListener(this);
      add(employeelist);
      back.setBounds(10,700,100,30);
      add(back);
      
      additem.setFont(jf);
       back.setFont(jf);
        billrecord.setFont(jf);
         employeelist.setFont(jf);
        back.addActionListener(this);
      setVisible(true);
      
      
      
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
      
          // JOptionPane.showMessageDialog(this,"Hello, Welcome to Javatpoint."); 
           if(ae.getSource()==additem)
           {AddItem i =new AddItem();
           this.setVisible(false);}
        if(ae.getSource()==billrecord){
        BillRecord bil= new BillRecord();
        this.setVisible(false);
        
        
        }
         if(ae.getSource()==employeelist){
        EmployeeList bil= new EmployeeList();
        this.setVisible(false);
        
        
        }
        if(ae.getSource()== back){
RetailShopManagement kk =new RetailShopManagement();
this.setVisible(false);

}
    }
 



    
    
}
