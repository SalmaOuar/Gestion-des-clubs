/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;

/**
 *
 * @author Yoga
 */
public class MDIApplication extends javax.swing.JFrame {

    /**
     * Creates new form MDIApplication
     */
    public MDIApplication() {
        initComponents();
        this.setTitle("Gestion des clubs");
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        ClubMenuItem = new javax.swing.JMenuItem();
        EtudiantForm = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        byClub = new javax.swing.JMenuItem();
        Recherche = new javax.swing.JMenuItem();
        StatMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/e N S C L U B (2) (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(170, 30, 800, 730);

        menuBar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        fileMenu.setMnemonic('f');
        fileMenu.setText("Gestion");

        ClubMenuItem.setMnemonic('o');
        ClubMenuItem.setText("Créer un club");
        ClubMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClubMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(ClubMenuItem);

        EtudiantForm.setMnemonic('s');
        EtudiantForm.setText("Gérer les adhésions");
        EtudiantForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtudiantFormActionPerformed(evt);
            }
        });
        fileMenu.add(EtudiantForm);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Recherche");

        byClub.setMnemonic('t');
        byClub.setText("Filtrer les membres par club");
        byClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byClubActionPerformed(evt);
            }
        });
        editMenu.add(byClub);

        Recherche.setText("Rechercher club par nom");
        Recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercheActionPerformed(evt);
            }
        });
        editMenu.add(Recherche);

        StatMenuItem.setText("Statistiques");
        StatMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(StatMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ClubMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClubMenuItemActionPerformed
        // TODO add your handling code here:
        for (javax.swing.JInternalFrame frame : desktopPane.getAllFrames()) {
            frame.dispose();
        }

        ClubForm cf = ClubForm.getInstance();
        desktopPane.add(cf);
        cf.setVisible(true);

        
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = cf.getSize();
        cf.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }//GEN-LAST:event_ClubMenuItemActionPerformed

    private void EtudiantFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtudiantFormActionPerformed
        // TODO add your handling code here:
        for (javax.swing.JInternalFrame frame : desktopPane.getAllFrames()) {
            frame.dispose();
        }
        EtudiantForm ef = new EtudiantForm();
        desktopPane.add(ef);
        ef.setVisible(true);
        
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = ef.getSize();
        ef.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }//GEN-LAST:event_EtudiantFormActionPerformed

    private void byClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byClubActionPerformed
        // TODO add your handling code here:

        EtudiantByClub ebc = new EtudiantByClub();
        desktopPane.add(ebc);
        ebc.setVisible(true);
        
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = ebc.getSize();
        ebc.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }//GEN-LAST:event_byClubActionPerformed

    private void RechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercheActionPerformed
        // TODO add your handling code here:
        Recherche rc = new Recherche();
        desktopPane.add(rc);
        rc.setVisible(true);
        
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = rc.getSize();
        rc.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }//GEN-LAST:event_RechercheActionPerformed

    private void StatMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatMenuItemActionPerformed
        // TODO add your handling code here:
        for (javax.swing.JInternalFrame frame : desktopPane.getAllFrames()) {
        frame.dispose();
    }
    StatMembresParClub stat = new StatMembresParClub();
    desktopPane.add(stat);
    stat.setVisible(true);
    }//GEN-LAST:event_StatMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ClubMenuItem;
    private javax.swing.JMenuItem EtudiantForm;
    private javax.swing.JMenuItem Recherche;
    private javax.swing.JMenuItem StatMenuItem;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem byClub;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
