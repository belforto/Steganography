/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stegan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Markoo
 */
public class GUI extends javax.swing.JFrame {
    
    File file;
    Steganography steg;
    String outputFileName1,message1;
    private String ext;
    private String savedFileName;
    String path;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        steg= new Steganography();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encodeBtn = new javax.swing.JButton();
        decodeBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        message = new javax.swing.JTextField();
        outputFileName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dekodiraniText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dalmatian Spot");
        setLocation(new java.awt.Point(500, 150));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        encodeBtn.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        encodeBtn.setText("Encode");
        encodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(encodeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 105, 48));

        decodeBtn.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        decodeBtn.setText("Decode");
        decodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(decodeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 102, 48));

        infoBtn.setFont(new java.awt.Font("Kalinga", 0, 11)); // NOI18N
        infoBtn.setText("Info");
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(infoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        message.setToolTipText("Enter secret message here");
        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });
        getContentPane().add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 30));

        outputFileName.setToolTipText("Set the name of the output file");
        outputFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileNameActionPerformed(evt);
            }
        });
        getContentPane().add(outputFileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 30));

        jLabel1.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter message here:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Output file name(.png):");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        dekodiraniText.setColumns(20);
        dekodiraniText.setRows(5);
        jScrollPane1.setViewportView(dekodiraniText);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 160, 90));

        jLabel3.setFont(new java.awt.Font("Kalinga", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Decoded text is :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 120, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stegan/bytes.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -20, 580, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encodeBtnActionPerformed
        // OTVARA SE FILE CHOOSER
         JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          
           path=selectedFile.getPath();
         // final String FPATH = "/home/mem/index.html";
    //Filename myHomePage = new Filename(FPATH, '/', '.');
           // System.out.println("original path je "+ path);
          Filename filename= new Filename(path, '\\', '.');
             
                ext=filename.filenameExtension();
                savedFileName= filename.filenameWithoutExtension();
                path= filename.pathWithoutFileName();
                message1=message.getText();
                  outputFileName1=outputFileName.getText();
                  //System.out.println("extenzija je "+ ext+" filename je "+savedFileName+" path je "+path);
            try{
            steg.encode(path, savedFileName, ext, outputFileName1, message1);
            JOptionPane.showMessageDialog(null, "Encoding is done!");
            }
            catch(Exception e){
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");

                    // show a joptionpane dialog using showMessageDialog
                    JOptionPane.showMessageDialog(frame,
                        "Problem with encoding : '" + e.toString(),
                        "Encoding problem",
                        JOptionPane.ERROR_MESSAGE);
                    
            }
        //  System.out.println("tekst i poruka "+message1+outputFileName1);
        }
        
    }//GEN-LAST:event_encodeBtnActionPerformed

    private void decodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
                     path=selectedFile.getPath();
                    // System.out.println("Path je "+path);
                     
                     Filename filename= new Filename(path, '\\', '.');
                     savedFileName= filename.filenameWithoutExtension();
                path= filename.pathWithoutFileName();
                     
        }
        try{
        // ovaj metod treba nahranit sa pathom i filenameoom
        dekodiraniText.setText(steg.decode(path, savedFileName));
        JOptionPane.showMessageDialog(null, "Decoding is done!");
            }
            catch(Exception e){
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");

                    // show a joptionpane dialog using showMessageDialog
                    JOptionPane.showMessageDialog(frame,
                        "Problem with decoding : '" + e.toString(),
                        "Decoding problem",
                        JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_decodeBtnActionPerformed

    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        
    }//GEN-LAST:event_messageActionPerformed

    private void outputFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFileNameActionPerformed
        
        
    }//GEN-LAST:event_outputFileNameActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        // informacije
       Information info= new Information();
       info.setVisible(true);
       info.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_infoBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decodeBtn;
    private javax.swing.JTextArea dekodiraniText;
    private javax.swing.JButton encodeBtn;
    private javax.swing.JButton infoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message;
    private javax.swing.JTextField outputFileName;
    // End of variables declaration//GEN-END:variables
}
