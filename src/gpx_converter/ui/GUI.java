package gpx_converter.ui;


import gpx_converter.FileManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Petr
 */
public class GUI extends javax.swing.JFrame
{
    private final FileManager fm;
    private File currentDirectory;

    /**
     * Creates new form NewJFrameTest
     */
    public GUI()
    {
        initComponents();
        this.fm = new FileManager();
        String downloads = System.getProperty ("user.home") + "/";
        String suuntoFiles = System.getProperty ("user.home") + "/Library/Application Support/Suunto/Moveslink2";
        this.currentDirectory = new File(suuntoFiles);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        heading = new javax.swing.JLabel();
        subHead = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        convertButton = new javax.swing.JButton();
        results = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        heading.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        heading.setText("GPX Extractor");
        heading.setToolTipText("");

        subHead.setText("Extracts .gpx file from Suunto watch workout");

        textField.setEditable(false);
        textField.setText("Browse for source file");
        textField.setPreferredSize(new java.awt.Dimension(84, 35));
        textField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                textFieldActionPerformed(evt);
            }
        });

        browseButton.setText("Browse...");
        browseButton.setPreferredSize(new java.awt.Dimension(100, 35));
        browseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                browseButtonActionPerformed(evt);
            }
        });

        convertButton.setText("Convert");
        convertButton.setEnabled(false);
        convertButton.setPreferredSize(new java.awt.Dimension(93, 35));
        convertButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                convertButtonActionPerformed(evt);
            }
        });

        results.setText("Ready");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(convertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(subHead, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addComponent(heading)
                        .addComponent(results)
                        .addComponent(jSeparator3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heading)
                .addGap(18, 18, 18)
                .addComponent(subHead)
                .addGap(18, 18, 18)
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(results)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_browseButtonActionPerformed
    {//GEN-HEADEREND:event_browseButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(currentDirectory);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Suunto workout files", "sml");
        chooser.setFileFilter(filter);
        int result = chooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            String chosenFile = chooser.getSelectedFile().getPath();
            textField.setText(chosenFile);
            convertButton.setEnabled(true);
            fm.clear();
            fm.setInputFileName(chosenFile);
        }
        
    }//GEN-LAST:event_browseButtonActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_textFieldActionPerformed
    {//GEN-HEADEREND:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_convertButtonActionPerformed
    {//GEN-HEADEREND:event_convertButtonActionPerformed
        fm.processFile();
        if (fm.getFileSaved())
        {
            results.setText("Converted & Saved into Downloads");
            results.setForeground(Color.green.darker());

            Timer timer = new Timer(4000, new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    results.setText("Ready");
                    results.setForeground(Color.black);

                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        convertButton.setEnabled(false);
    }//GEN-LAST:event_convertButtonActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[])
//    {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try
//        {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
//            {
//                if ("Nimbus".equals(info.getName()))
//                {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex)
//        {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex)
//        {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex)
//        {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex)
//        {
//            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                new GUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JLabel heading;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel results;
    private javax.swing.JLabel subHead;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}
