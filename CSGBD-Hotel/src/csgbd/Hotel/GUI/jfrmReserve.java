package csgbd.Hotel.GUI;

import csgbd.Hotel.Common.DB.ConnectionFactory;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Facade.Default.HotelFacade;
import csgbd.Hotel.Common.Facade.IHotelFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italopessoa
 */
public class jfrmReserve extends javax.swing.JFrame {

    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Reserve> reserves;
    private IHotelFacade facade;

    /**
     * Creates new form jfrmReserve
     */
    public jfrmReserve() {
        initComponents();
        ConnectionFactory.OpenConnection();
        this.facade = new HotelFacade();
        this.enableFiltersPanel(false);
        this.showGuests();
        this.showRooms();
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
        jtbGuests = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbRoom = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbReserves = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtReserveId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtGuestName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtRoomId = new javax.swing.JTextField();
        jtxtGuestId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dccIn = new datechooser.beans.DateChooserCombo();
        dccOut = new datechooser.beans.DateChooserCombo();
        jpnlFilters = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcbxRoom = new javax.swing.JCheckBox();
        jcbxGuest = new javax.swing.JCheckBox();
        jbtnOk = new javax.swing.JButton();
        jbtnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtbGuests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Phone", "Idade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbGuests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbGuestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbGuests);

        jtbRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Price", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbRoomMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbRoom);

        jtbReserves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Guest", "Room", "In", "Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbReserves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbReservesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbReserves);

        jButton1.setText("Make Reserve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("In:");

        jLabel2.setText("Out:");

        jtxtReserveId.setEditable(false);
        jtxtReserveId.setEnabled(false);

        jLabel3.setText("Id:");

        jLabel4.setText("Guest:");

        jLabel5.setText("Room:");

        jLabel6.setText("Guest Id:");

        jLabel7.setText("Filters:");

        jcbxRoom.setText("Room:");
        jcbxRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxRoomItemStateChanged(evt);
            }
        });

        jcbxGuest.setText("Guest");
        jcbxGuest.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxGuestItemStateChanged(evt);
            }
        });

        jbtnOk.setText("Ok");
        jbtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlFiltersLayout = new javax.swing.GroupLayout(jpnlFilters);
        jpnlFilters.setLayout(jpnlFiltersLayout);
        jpnlFiltersLayout.setHorizontalGroup(
            jpnlFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFiltersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jcbxRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbxGuest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlFiltersLayout.setVerticalGroup(
            jpnlFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlFiltersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(jcbxRoom)
                .addComponent(jcbxGuest)
                .addComponent(jbtnOk))
        );

        jbtnSearch.setText("Seach");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(dccIn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(dccOut, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnSearch))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtReserveId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtxtGuestName, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxtGuestId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1)
                            .addComponent(jpnlFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtReserveId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtGuestName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtGuestId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dccIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(dccOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpnlFilters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbtnSearch))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbGuestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbGuestsMouseClicked
        int linha = this.jtbGuests.getSelectedRow();
        if(linha >-1){
            this.jtxtGuestId.setText(String.valueOf(this.jtbGuests.getValueAt(linha,0)));
            this.jtxtGuestName.setText(String.valueOf(this.jtbGuests.getValueAt(linha,1)));
        }
    }//GEN-LAST:event_jtbGuestsMouseClicked

    private void jtbRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbRoomMouseClicked
        int linha = this.jtbRoom.getSelectedRow();
        if(linha >-1){
            this.jtxtRoomId.setText(String.valueOf(this.jtbRoom.getValueAt(linha,0)));
        }
    }//GEN-LAST:event_jtbRoomMouseClicked

    private void jtbReservesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbReservesMouseClicked
        // TODO add your handling code here:
        int linha = this.jtbReserves.getSelectedRow();
        if(linha >-1){
            this.jtxtReserveId.setText(String.valueOf(this.jtbReserves.getValueAt(linha,0)));
            this.jtxtGuestName.setText(String.valueOf(this.jtbReserves.getValueAt(linha,1)));
            this.jtxtRoomId.setText(String.valueOf(this.jtbReserves.getValueAt(linha,2)));
            //this.jftxtPhone.setText(String.valueOf(this.jtbReserves.getValueAt(linha,3)));
            //this.jtxtAge.setText(String.valueOf(this.jtbReserves.getValueAt(linha,4)));
        }
    }//GEN-LAST:event_jtbReservesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date dtIn = dccIn.getSelectedDate().getTime();
        Date dtOut = dccOut.getSelectedDate().getTime();
        
        Guest guest = null;
        Room room = null;
        int linha = this.jtbGuests.getSelectedRow();
        if(linha >-1){
            guest = new Guest(Integer.parseInt(this.jtbGuests.getValueAt(linha,0).toString()));
        }
        
        linha = this.jtbRoom.getSelectedRow();
        if(linha >-1){
            room = new Room(Integer.parseInt(this.jtbRoom.getValueAt(linha,0).toString()));
        }
        
        Reserve reserve = new Reserve(guest, room, dtIn,dtOut);
        
        this.newReserve(reserve);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbxRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxRoomItemStateChanged

    }//GEN-LAST:event_jcbxRoomItemStateChanged

    private void jcbxGuestItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxGuestItemStateChanged
    }//GEN-LAST:event_jcbxGuestItemStateChanged

    private void jbtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOkActionPerformed

        Guest guest = null;
        Room room = null;
        int linha=0;
        if(this.jcbxRoom.isSelected()){
            linha = this.jtbRoom.getSelectedRow();
            if(linha >-1){
                room = new Room(Integer.parseInt(this.jtbRoom.getValueAt(linha,0).toString()));
            }
        }
        if(this.jcbxGuest.isSelected()){
            linha = this.jtbGuests.getSelectedRow();
            if(linha >-1){
                guest = new Guest(Integer.parseInt(this.jtbGuests.getValueAt(linha,0).toString()));
            }
        }
        
        try {
            this.reserves = this.facade.SelectReservesByRoomAndGuest(room, guest);
        } catch (SQLException ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.showReserves();

    }//GEN-LAST:event_jbtnOkActionPerformed

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        this.enableFiltersPanel(true);
    }//GEN-LAST:event_jbtnSearchActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrmReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmReserve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmReserve().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dccIn;
    private datechooser.beans.DateChooserCombo dccOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnOk;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JCheckBox jcbxGuest;
    private javax.swing.JCheckBox jcbxRoom;
    private javax.swing.JPanel jpnlFilters;
    private javax.swing.JTable jtbGuests;
    private javax.swing.JTable jtbReserves;
    private javax.swing.JTable jtbRoom;
    private javax.swing.JTextField jtxtGuestId;
    private javax.swing.JTextField jtxtGuestName;
    private javax.swing.JTextField jtxtReserveId;
    private javax.swing.JTextField jtxtRoomId;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc=" Room ">
    
    private void getRooms(){
        try {        
            this.rooms = this.facade.SelectAllRooms();
        } catch (SQLException ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void showRooms() {
        this.getRooms();
        DefaultTableModel model = (DefaultTableModel) this.jtbRoom.getModel();
        model.setNumRows(0);

        for (Room room : this.rooms) {
            model.addRow(new Object[]{room.getId(), room.getPrice(),room.getType()});
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Guest ">

    private void getGuests(){
        try {
            this.guests = this.facade.SelectAllGuests();
        } catch (SQLException ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showGuests() {
        this.getGuests();
        DefaultTableModel model = (DefaultTableModel) this.jtbGuests.getModel();
        model.setNumRows(0);

        for (Guest guest : this.guests) {
            model.addRow(new Object[]{guest.getId(), guest.getName(), guest.getEmail(), guest.getPhone(), guest.getAge()});
        }
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Reserve ">
    
    private void getReserves(){
        try {
            this.reserves = this.facade.SelectAllReserves();
        } catch (SQLException ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showReserves() {
//        this.getReserves();
        DefaultTableModel model = (DefaultTableModel) this.jtbReserves.getModel();
        model.setNumRows(0);

        for (Reserve reserve : this.reserves) {
            model.addRow(new Object[]{reserve.getId(), reserve.getGuest(), reserve.getRoom().getId(), 
                reserve.getEntryDate().toString(), reserve.getOutDate().toString()});
        }
    }
    
    private void newReserve(Reserve reserve){
        try {
            this.facade.MakeSave(reserve);
        } catch (SQLException ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(jfrmReserve.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Guest saved sucefull!");
        showReserves();
    }
    
    //</editor-fold>

    private void enableFiltersPanel(boolean enabled){
        this.jpnlFilters.setEnabled(enabled);
        this.jcbxGuest.setEnabled(enabled);
        this.jcbxRoom.setEnabled(enabled);
        this.jbtnOk.setEnabled(enabled);
    }

}
