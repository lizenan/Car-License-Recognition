package org.platesystem.operation;


import java.io.*;

import javax.annotation.Resource;
import javax.swing.*;

import org.platesystem.dao.plateDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


/**
*
* @author Administrator
*/
@Component
public class plateInterface extends javax.swing.JFrame {
   private JFileChooser chooser;
   @Resource
	plateMainOperation mainoperation;
	public void setplateMainOperation(plateMainOperation mainoperation) {
		this.mainoperation = mainoperation;
	}
 String name;
//   private JLabel label;
   /**
    * Creates new form lala
    */
   public plateInterface() {
       initComponents();
       setTitle("ͣ�����Ʒ�ϵͳ");
//       label = new JLabel();
//        add(label);
       chooser = new JFileChooser();
             chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("E:"));
        

        
     


   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       choose = new javax.swing.JButton();
       PicLocation = new javax.swing.JTextField();
       money = new javax.swing.JTextField();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       action = new javax.swing.JButton();
       jPanel1 = new javax.swing.JPanel();
       jLabel3 = new javax.swing.JLabel();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       choose.setLabel("ѡ��");
       choose.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               chooseActionPerformed(evt);
           }
       });

       PicLocation.setDisabledTextColor(new java.awt.Color(0, 0, 0));
       PicLocation.setEnabled(false);
       PicLocation.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               PicLocationActionPerformed(evt);
           }
       });

       jLabel1.setText("ͼƬλ��:");

       jLabel2.setText("Ӧ�ս��:");

       action.setText("ȷ�ϼƷ�");
       action.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               try {
				actionActionPerformed(evt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
       });

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGap(0, 303, Short.MAX_VALUE)
           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGap(0, 440, Short.MAX_VALUE)
           .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                   .addContainerGap()
                   .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                   .addContainerGap()))
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(37, 37, 37)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel1))
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(PicLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                               .addComponent(choose))
                           .addGroup(layout.createSequentialGroup()
                               .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                               .addComponent(action))))
                   .addGroup(layout.createSequentialGroup()
                       .addGap(38, 38, 38)
                       .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addContainerGap(407, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(choose)
                   .addComponent(PicLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel1))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(action)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(jLabel2)
                       .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGap(13, 13, 13))
       );

       pack();
   }// </editor-fold>                        

   private void PicLocationActionPerformed(java.awt.event.ActionEvent evt) {                                            
       // TODO add your handling code here:
   }                                           

   private void chooseActionPerformed(java.awt.event.ActionEvent evt) {                                       
      int result = chooser.showOpenDialog(null);
              if(result == JFileChooser.APPROVE_OPTION){
                    name = chooser.getSelectedFile().getPath();
                    
                    jLabel3.setIcon(new ImageIcon(name));
                    jLabel3.setBounds(0,0,jPanel1.getWidth(),jPanel1.getHeight());
                    PicLocation.setText(name);
                }  // TODO add your handling code here:
   }                                      

   private void actionActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                       
	   int moneyInt = mainoperation.plateMainOperation(name);
	   String moneyDisplay = String.valueOf(moneyInt);
	   money.setText(moneyDisplay);
   }                                      

   /**
    * @param args the command line arguments
    */
  

   // Variables declaration - do not modify                     
   private javax.swing.JTextField PicLocation;
   private javax.swing.JButton action;
   private javax.swing.JButton choose;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JTextField money;
   // End of variables declaration                   
}