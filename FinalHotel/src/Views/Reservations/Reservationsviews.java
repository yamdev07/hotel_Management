/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Reservations;

import Controller.CustomersController;
import Controller.ReservationsController;
import Controller.RoomsController;
import Models.Entities.Customers;
import Models.EntitiesManagers.CustomersManagers;
import Models.EntitiesManagers.Manager;
import static Models.EntitiesManagers.Manager.connection;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 22893
 */
public class Reservationsviews extends javax.swing.JPanel {

    public Reservationsviews() {
        initComponents();
        Manager.connect();
        RESERVATION_TABLE.setModel(ReservationsController.getAll());

        CUSTOMERS_LIST_JTABLE.setModel(CustomersController.getAll());
        //momo();
        chambre_TABLE.setModel(RoomsController.getAll());//Affiche tout les étudiants dans le tableau      
        
    }

    /*private String formatDate(Calendar date){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date.getTime());
        }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        mise_ajour_BTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id_chambre_CB = new javax.swing.JComboBox<>();
        id_client_CB = new javax.swing.JComboBox<>();
        date_arrivé_CL = new com.toedter.calendar.JDateChooser();
        date_sorti_CL = new com.toedter.calendar.JDateChooser();
        recherche_TF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        RESERVATION_TABLE = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        chambre_TABLE = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        CUSTOMERS_LIST = new javax.swing.JTable();
        SUPRIMER_BTN = new javax.swing.JButton();
        MODIFIER_BTN = new javax.swing.JButton();
        AJOUTER_BTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        payé_TF = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        CUSTOMERS_LIST_JTABLE = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1991, 1269));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(120, 56));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel13.setText("RESERVATION");

        mise_ajour_BTN.setText(" UPDATE");
        mise_ajour_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mise_ajour_BTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1125, Short.MAX_VALUE)
                .addComponent(mise_ajour_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(mise_ajour_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1991, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(382, 764));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(380, 256));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Reservations/reservation-en-ligne.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(59, 59, 59))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Id Rooms :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("Id Customers : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Date of Entry :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("Date Exit :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("Paid :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(47, 47, 47)
                .addComponent(jLabel6)
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addGap(0, 562, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 63, -1, 1206));

        id_chambre_CB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        id_chambre_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_chambre_CBMouseClicked(evt);
            }
        });
        id_chambre_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_chambre_CBActionPerformed(evt);
            }
        });
        add(id_chambre_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 300, 40));

        id_client_CB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        id_client_CB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_client_CBMouseClicked(evt);
            }
        });
        id_client_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_client_CBActionPerformed(evt);
            }
        });
        add(id_client_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 300, 40));

        date_arrivé_CL.setDateFormatString("yyyy-MM-dd");
        date_arrivé_CL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        date_arrivé_CL.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_arrivé_CLPropertyChange(evt);
            }
        });
        date_arrivé_CL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                date_arrivé_CLKeyReleased(evt);
            }
        });
        add(date_arrivé_CL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 300, 40));

        date_sorti_CL.setDateFormatString("yyyy-MM-dd");
        date_sorti_CL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add(date_sorti_CL, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 300, 40));

        recherche_TF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        recherche_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        recherche_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recherche_TFActionPerformed(evt);
            }
        });
        recherche_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                recherche_TFKeyReleased(evt);
            }
        });
        add(recherche_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 660, 40));

        RESERVATION_TABLE.setModel(new javax.swing.table.DefaultTableModel(
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
        RESERVATION_TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RESERVATION_TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RESERVATION_TABLE);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 860, 1220, 160));

        chambre_TABLE.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(chambre_TABLE);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 600, 890, 150));

        CUSTOMERS_LIST.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(CUSTOMERS_LIST);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 890, 150));

        SUPRIMER_BTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SUPRIMER_BTN.setText("DELETE");
        SUPRIMER_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPRIMER_BTNActionPerformed(evt);
            }
        });
        add(SUPRIMER_BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 790, 140, 40));

        MODIFIER_BTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MODIFIER_BTN.setText("MODIFY");
        MODIFIER_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFIER_BTNActionPerformed(evt);
            }
        });
        add(MODIFIER_BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 790, 140, 40));

        AJOUTER_BTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AJOUTER_BTN.setText("ADD");
        AJOUTER_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AJOUTER_BTNActionPerformed(evt);
            }
        });
        add(AJOUTER_BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 791, 130, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Research :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 330, 230, 40));

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TABLEAU CHAMBRES");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 440, -1));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("TABLEAU  CLIENTS");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 450, -1));

        payé_TF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payé_TF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OUI", "NON" }));
        add(payé_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 660, 300, 40));

        CUSTOMERS_LIST_JTABLE.setModel(new javax.swing.table.DefaultTableModel(
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
        CUSTOMERS_LIST_JTABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CUSTOMERS_LIST_JTABLEMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(CUSTOMERS_LIST_JTABLE);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 1160, 170));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Reservations/fleure2.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 63, -1, 1206));
    }// </editor-fold>//GEN-END:initComponents

    private void recherche_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recherche_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recherche_TFActionPerformed

    private void AJOUTER_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AJOUTER_BTNActionPerformed
        // TODO add your handling code here:

        try {
            // Récupérer la date d'arrivée
            Date dateArrivee = date_arrivé_CL.getDate();
            Date dateSorti = date_sorti_CL.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateArriveeFormatted = dateFormat.format(dateArrivee);
            String dateSortiFormatted = dateFormat.format(dateSorti);

            if (ReservationsController.store(id_chambre_CB.getSelectedItem().toString(), id_client_CB.getSelectedItem().toString(), dateArriveeFormatted, dateSortiFormatted, payé_TF.getSelectedItem().toString())) {
                RESERVATION_TABLE.setModel(ReservationsController.getAll());
                JOptionPane.showMessageDialog(null, " Insertion réussi ");
            }
        } catch (Exception e) {
            // Gérer les exceptions, afficher des messages d'erreur, etc.
            e.printStackTrace();
        }
    }//GEN-LAST:event_AJOUTER_BTNActionPerformed

    private void SUPRIMER_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPRIMER_BTNActionPerformed
        // TODO add your handling code here:
        int myIndex = RESERVATION_TABLE.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, " Aucune line du tableau n'est selectionné ");
        } else {
            DefaultTableModel model = (DefaultTableModel) RESERVATION_TABLE.getModel();
            if (ReservationsController.destroy(Integer.parseInt(model.getValueAt(myIndex, 0).toString()))) {
                RESERVATION_TABLE.setModel(ReservationsController.getAll());// pour rafraichir la table
            }
        }
    }//GEN-LAST:event_SUPRIMER_BTNActionPerformed

    private void MODIFIER_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFIER_BTNActionPerformed
        // TODO add your handling code here:
        int myIndex = RESERVATION_TABLE.getSelectedRow();

        Date dateArrivee1 = date_arrivé_CL.getDate();
        Date dateSorti1 = date_sorti_CL.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateArriveeFormatted1 = dateFormat.format(dateArrivee1);
        String dateSortiFormatted1 = dateFormat.format(dateSorti1);

        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, " No table row is selected ");
        } else {
            DefaultTableModel model = (DefaultTableModel) RESERVATION_TABLE.getModel();
            if (ReservationsController.update(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), id_chambre_CB.getSelectedItem().toString(), id_client_CB.getSelectedItem().toString(), dateArriveeFormatted1, dateSortiFormatted1, payé_TF.getSelectedItem().toString())) {
                RESERVATION_TABLE.setModel(ReservationsController.getAll());
                JOptionPane.showMessageDialog(null, "the modification is carried out successfully");
            }
        }
    }//GEN-LAST:event_MODIFIER_BTNActionPerformed

    private void recherche_TFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recherche_TFKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) RESERVATION_TABLE.getModel();
        RESERVATION_TABLE.setModel(ReservationsController.search(recherche_TF.getText()));
    }//GEN-LAST:event_recherche_TFKeyReleased

    private void RESERVATION_TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RESERVATION_TABLEMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) RESERVATION_TABLE.getModel();

        //pour changer la couleur quand on clique dessus et pour mettre la ligne en exergue
        RESERVATION_TABLE.setSelectionForeground(new Color(255, 255, 255, 255));
        RESERVATION_TABLE.setSelectionForeground(new Color(232, 57, 95));
        int myIndex = RESERVATION_TABLE.getSelectedRow();
        id_chambre_CB.setSelectedItem(model.getValueAt(myIndex, 1).toString());
        id_client_CB.setSelectedItem(model.getValueAt(myIndex, 2).toString());
        date_arrivé_CL.setDate((Date) model.getValueAt(myIndex, 3));
        date_sorti_CL.setDate((Date) model.getValueAt(myIndex, 4));
        payé_TF.setSelectedItem(model.getValueAt(myIndex, 5).toString());


    }//GEN-LAST:event_RESERVATION_TABLEMouseClicked

    private void date_arrivé_CLPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_arrivé_CLPropertyChange
        // TODO add your handling code 


    }//GEN-LAST:event_date_arrivé_CLPropertyChange

    private void date_arrivé_CLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_date_arrivé_CLKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_date_arrivé_CLKeyReleased

    private void CUSTOMERS_LIST_JTABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CUSTOMERS_LIST_JTABLEMouseClicked
        // TODO add your handling code here:
        /*DefaultTableModel model = (DefaultTableModel) CUSTOMERS_LIST_JTABLE.getModel();

        //pour changer la couleur quand on clique dessus et pour mettre la ligne en exergue
        CUSTOMERS_LIST_JTABLE.setSelectionForeground(new Color(255, 255, 255, 255));
        CUSTOMERS_LIST_JTABLE.setSelectionForeground(new Color(232, 57, 95));
        int myIndex = CUSTOMERS_LIST_JTABLE.getSelectedRow();
        last_name_TF.setText(model.getValueAt(myIndex, 1).toString());
        firt_name_TF.setText(model.getValueAt(myIndex, 2).toString());
        phone_TF.setText(model.getValueAt(myIndex, 3).toString());
        pays_CB.setSelectedItem(model.getValueAt(myIndex, 4).toString());
        type_client_CB.setSelectedItem(model.getValueAt(myIndex, 5).toString());
        carte_CB.setSelectedItem(model.getValueAt(myIndex, 6).toString());*/
    }//GEN-LAST:event_CUSTOMERS_LIST_JTABLEMouseClicked

    private void mise_ajour_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mise_ajour_BTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mise_ajour_BTNActionPerformed

    private void id_chambre_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_chambre_CBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_chambre_CBActionPerformed

    private void id_client_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_client_CBActionPerformed
        //pour les action sur le jcombobox


    }//GEN-LAST:event_id_client_CBActionPerformed

    private void id_client_CBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_client_CBMouseClicked
        // TODO add your handling code here:

        try {
            Manager.connect();
            String query = "SELECT * FROM Customers";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            id_client_CB.removeAllItems();
            while (resultSet.next()) {
                id_client_CB.addItem(resultSet.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_id_client_CBMouseClicked

    private void id_chambre_CBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_chambre_CBMouseClicked
        // TODO add your handling code here:
        try {
            Manager.connect();
            String query = "SELECT * FROM rooms";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            id_chambre_CB.removeAllItems();
            while (resultSet.next()) {
                id_chambre_CB.addItem(resultSet.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_id_chambre_CBMouseClicked

    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AJOUTER_BTN;
    private javax.swing.JTable CUSTOMERS_LIST;
    private javax.swing.JTable CUSTOMERS_LIST_JTABLE;
    private javax.swing.JButton MODIFIER_BTN;
    private javax.swing.JTable RESERVATION_TABLE;
    private javax.swing.JButton SUPRIMER_BTN;
    private javax.swing.JTable chambre_TABLE;
    private com.toedter.calendar.JDateChooser date_arrivé_CL;
    private com.toedter.calendar.JDateChooser date_sorti_CL;
    private javax.swing.JComboBox<String> id_chambre_CB;
    private javax.swing.JComboBox<String> id_client_CB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mise_ajour_BTN;
    private javax.swing.JComboBox<String> payé_TF;
    private javax.swing.JTextField recherche_TF;
    // End of variables declaration//GEN-END:variables
}
