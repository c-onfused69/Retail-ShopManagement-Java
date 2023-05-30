
package retailshopmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class RetailShopManagement implements ActionListener {
   static JButton admin = new JButton("ADMIN");
   static JButton bill = new JButton("Payment");
   static JFrame home = new JFrame("Aquarium Shop Management System");
   ImageIcon img = new ImageIcon(getClass().getResource("Retailshop2.png"));
   JLabel l1 = new JLabel("Aquarium Shop Management System");
   JLabel l2 = new JLabel(img);
   static Font jf = new Font("Times New Roman", Font.BOLD + Font.HANGING_BASELINE, 18);

   RetailShopManagement() {
      home.setLayout(null);
      home.setSize(800, 800);
      l1.setBounds(10, 2, 780, 50);
      admin.setBounds(200, 700, 150, 40);
      bill.setBounds(500, 700, 150, 40);
      l2.setBounds(0, 0, 800, 800);
      l1.setForeground(Color.WHITE);
      l2.add(admin);
      home.add(l2);
      l1.setHorizontalAlignment(javax.swing.JLabel.CENTER);
      l2.add(bill);
      l2.add(l1);
      l1.setFont(new Font("Times New Roman", Font.BOLD, 44));
      home.setVisible(true);
      home.setLayout(null);
      admin.setFont(jf);
      bill.setFont(jf);
      home.setLocationRelativeTo(null);
      // home.getContentPane().setBackground(img);

      bill.addActionListener(this);
      admin.addActionListener(this);
      home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   public static void main(String[] args) {
      new RetailShopManagement();

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == bill) {
         Bill b = new Bill();
         home.setVisible(false);

      } else if (e.getSource() == admin) {

         String s = JOptionPane.showInputDialog("Enter Password");
         if (s.equals("2486")) {
            home.setVisible(false);
            Admin a = new Admin();
         } else {
            JOptionPane.showMessageDialog(null, "Wrong Password!");

         }

      }
   }

}
