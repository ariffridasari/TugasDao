package views;

import controllers.LocationController;
import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import models.Location;
import tools.DBConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LocationView extends javax.swing.JFrame {

    DBConnection connection = new DBConnection();
    ILocationController ilc = new LocationController(connection.getConnection());

    public LocationView() {
        initComponents();
        ShowtableLocations();
    }

    public void resetTextLocations() {
        id.setText("");
        street.setText("");
        postal.setText("");
        city.setText("");
        province.setText("");
        countryid.setText("");
        insertbutton.setEnabled(true);
    }

    public void ShowtableLocations() {
        DefaultTableModel model = (DefaultTableModel) tablelocation.getModel();
        Object[] row = new Object[7];
        List<Location> Locations = new ArrayList<>();
        Locations = ilc.getAll();
        for (int i = 0; i < Locations.size(); i++) {
            row[0] = Locations.get(i).getId();
            row[1] = Locations.get(i).getStreet_address();
            row[2] = Locations.get(i).getPostal_code();
            row[3] = Locations.get(i).getCity();
            row[4] = Locations.get(i).getState_province();
            row[5] = Locations.get(i).getCountry_id();
            model.addRow(row);
        }
    }

    public void ShowtableLocations(String s) {
        DefaultTableModel model = (DefaultTableModel) tablelocation.getModel();
        Object[] row = new Object[7];
        List<Location> Locations = new ArrayList<>();
        Locations = ilc.search(s);
        for (int i = 0; i < Locations.size(); i++) {
            row[0] = Locations.get(i).getId();
            row[1] = Locations.get(i).getStreet_address();
            row[2] = Locations.get(i).getPostal_code();
            row[3] = Locations.get(i).getCity();
            row[4] = Locations.get(i).getState_province();
            row[5] = Locations.get(i).getCountry_id();
            model.addRow(row);
        }
    }

    public void updateTableLocations() {
        DefaultTableModel model = (DefaultTableModel) tablelocation.getModel();
        model.setRowCount(0);
        ShowtableLocations();
    }

    public void updateTableLocations(String s) {
        DefaultTableModel model = (DefaultTableModel) tablelocation.getModel();
        model.setRowCount(0);
        if (s == "") {
            ShowtableLocations();
        }
        ShowtableLocations(s);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        street = new javax.swing.JTextField();
        postal = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        countryid = new javax.swing.JTextField();
        province = new javax.swing.JTextField();
        insertbutton = new javax.swing.JToggleButton();
        updatebutton = new javax.swing.JToggleButton();
        deletebutton = new javax.swing.JToggleButton();
        txtsearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablelocation = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Insert New Location");

        jLabel2.setText("id");

        jLabel3.setText("Street Address");

        jLabel4.setText("Postal code");

        jLabel5.setText("City");

        jLabel6.setText("State Province");

        jLabel7.setText("Country id");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetActionPerformed(evt);
            }
        });

        postal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postalActionPerformed(evt);
            }
        });

        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });

        countryid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryidActionPerformed(evt);
            }
        });

        province.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinceActionPerformed(evt);
            }
        });

        insertbutton.setText("Insert");
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });

        updatebutton.setText("Update");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsearchKeyTyped(evt);
            }
        });

        jLabel8.setText("Search");

        tablelocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Location id", "Street Address", "Postal Code", "City", "State Province", "Country id"
            }
        ));
        tablelocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablelocationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablelocation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertbutton)
                                .addGap(18, 18, 18)
                                .addComponent(updatebutton)
                                .addGap(18, 18, 18)
                                .addComponent(deletebutton)
                                .addGap(56, 56, 56)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(0, 49, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(43, 43, 43)
                                        .addComponent(postal, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(street, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(90, 90, 90)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(countryid, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(street, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(postal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(countryid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertbutton)
                    .addComponent(updatebutton)
                    .addComponent(deletebutton)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void provinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_provinceActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void streetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetActionPerformed

    private void postalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postalActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void countryidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryidActionPerformed

    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "apakah anda yakin melakukan insert? ", "confirm insert ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ilc.insert(id.getText(), street.getText(), postal.getText(), city.getText(), province.getText(), countryid.getText()));
            updateTableLocations();
            resetTextLocations();
        }
    }//GEN-LAST:event_insertbuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "apakah anda yakin melakukan update? ", "confirm insert ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ilc.update(id.getText(), street.getText(), postal.getText(), city.getText(), province.getText(), countryid.getText()));
            updateTableLocations();
            resetTextLocations();
        }
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "apakah anda yakin melakukan delete? ", "confirm delete ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ilc.delete(id.getText()));
            updateTableLocations();
            resetTextLocations();
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void tablelocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelocationMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tablelocation.getModel();
        int SelectedRowIndex = tablelocation.getSelectedRow();

        id.setEditable(false);
        insertbutton.setEnabled(false);
        id.setText(model.getValueAt(SelectedRowIndex, 0).toString());
        street.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        postal.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        city.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        province.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        countryid.setText(model.getValueAt(SelectedRowIndex, 5).toString());
    }//GEN-LAST:event_tablelocationMouseClicked

    private void txtsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyTyped
        // TODO add your handling code here:
        updateTableLocations(txtsearch.getText());
    }//GEN-LAST:event_txtsearchKeyTyped

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
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocationView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField city;
    private javax.swing.JTextField countryid;
    private javax.swing.JToggleButton deletebutton;
    private javax.swing.JTextField id;
    private javax.swing.JToggleButton insertbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField postal;
    private javax.swing.JTextField province;
    private javax.swing.JTextField street;
    private javax.swing.JTable tablelocation;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JToggleButton updatebutton;
    // End of variables declaration//GEN-END:variables
}
