/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csgbd.Hotel.GUI;

import csgbd.Hotel.Common.DAO.Implements.GuestDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
import csgbd.Hotel.Common.Entity.Guest;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italopessoa
 */
public class jfrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form jfrmPrincipal
     */
    public jfrmPrincipal() {
        initComponents();
        prepareGuestTableModel();
    }
    
    private void prepareGuestTableModel() {
        ArrayList<Guest> guests;
        ConnectionManager.OpenConnection();
        GuestDAO gd = new GuestDAO();
        guests = gd.SelectAll();//new ArrayList<Guest>();
                
        DefaultTableModel tabmodel = (DefaultTableModel) jTable1.getModel();
        tabmodel.setNumRows(0);

        for (Guest guest : guests) {
            tabmodel.addRow(new Object[]{guest.getId(), guest.getName(), guest.getAge(), guest.getEmail()});
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jmbPrincipal = new javax.swing.JMenuBar();
        jMenuNovo = new javax.swing.JMenu();
        jmiNewGuest = new javax.swing.JMenuItem();
        jmiNewRoom = new javax.swing.JMenuItem();
        jmbNewRoomType = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jmiEditGuest = new javax.swing.JMenuItem();
        jmiEditRoom = new javax.swing.JMenuItem();
        jmiEditRoomType = new javax.swing.JMenuItem();
        jMenuReserve = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jMenuNovo.setText("New");

        jmiNewGuest.setText("Guest");
        jMenuNovo.add(jmiNewGuest);

        jmiNewRoom.setText("Room");
        jMenuNovo.add(jmiNewRoom);

        jmbNewRoomType.setText("Room Type");
        jMenuNovo.add(jmbNewRoomType);
        jMenuNovo.add(jSeparator1);

        jmbPrincipal.add(jMenuNovo);

        jMenu2.setText("Edit");

        jmiEditGuest.setText("Guest");
        jMenu2.add(jmiEditGuest);

        jmiEditRoom.setText("Room");
        jMenu2.add(jmiEditRoom);

        jmiEditRoomType.setText("RoomType");
        jMenu2.add(jmiEditRoomType);

        jmbPrincipal.add(jMenu2);

        jMenuReserve.setText("Reserve");
        jmbPrincipal.add(jMenuReserve);

        setJMenuBar(jmbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        JOptionPane.showConfirmDialog(rootPane, jTable1.getSelectedRow());
                
    }//GEN-LAST:event_jTable1MouseClicked

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
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {
             javax.swing.UIManager.setLookAndFeel(info.getClassName());
             javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    
             break;               
             }
             }*/
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuNovo;
    private javax.swing.JMenu jMenuReserve;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem jmbNewRoomType;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmiEditGuest;
    private javax.swing.JMenuItem jmiEditRoom;
    private javax.swing.JMenuItem jmiEditRoomType;
    private javax.swing.JMenuItem jmiNewGuest;
    private javax.swing.JMenuItem jmiNewRoom;
    // End of variables declaration//GEN-END:variables
}
