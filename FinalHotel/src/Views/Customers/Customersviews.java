/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Customers;
import Views.Reservations.Reservationsviews;
import Controller.CustomersController;
import Models.EntitiesManagers.Manager;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 22893
 */
public class Customersviews extends javax.swing.JPanel {
    public static int[] nono;
    /**
     * Creates new form Customers
     */
    Reservationsviews volo= new Reservationsviews();

    public Customersviews() {
        initComponents();
        Manager.connect();
        CUSTOMERS_LIST_JTABLE.setModel(CustomersController.getAll());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LAST_NAME_JLABEL = new javax.swing.JLabel();
        FIRST_NAME_JLABEL = new javax.swing.JLabel();
        PHONE_JLABEL = new javax.swing.JLabel();
        CONTRY_JLABEL = new javax.swing.JLabel();
        TYPE_JLABEL = new javax.swing.JLabel();
        CARTE_JLABEL = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        last_name_TF = new javax.swing.JTextField();
        firt_name_TF = new javax.swing.JTextField();
        phone_TF = new javax.swing.JTextField();
        pays_CB = new javax.swing.JComboBox<>();
        type_client_CB = new javax.swing.JComboBox<>();
        carte_CB = new javax.swing.JComboBox<>();
        RECHERCHE_JLABEL = new javax.swing.JLabel();
        recherche_TF = new javax.swing.JTextField();
        SUPRIMER_JB = new javax.swing.JButton();
        AJOUTER_JB = new javax.swing.JButton();
        MODIFIER_JB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CUSTOMERS_LIST_JTABLE = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1653, 1023));
        setPreferredSize(new java.awt.Dimension(1653, 1023));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LAST_NAME_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        LAST_NAME_JLABEL.setText(" Name :");
        jPanel1.add(LAST_NAME_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 160, -1));

        FIRST_NAME_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        FIRST_NAME_JLABEL.setText("First name :");
        jPanel1.add(FIRST_NAME_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        PHONE_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        PHONE_JLABEL.setText("Num Phone :");
        jPanel1.add(PHONE_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, -1));

        CONTRY_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CONTRY_JLABEL.setText("Citizen : ");
        jPanel1.add(CONTRY_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, -1, -1));

        TYPE_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        TYPE_JLABEL.setText(" Customer Type :");
        jPanel1.add(TYPE_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, -1, -1));

        CARTE_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CARTE_JLABEL.setText(" Fidélity Card : ");
        jPanel1.add(CARTE_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 730, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Customers/client5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 262, 230, 10));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 380, 1170));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(120, 56));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2040, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2040, 45));

        last_name_TF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        last_name_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        last_name_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_name_TFActionPerformed(evt);
            }
        });
        add(last_name_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 410, 40));

        firt_name_TF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        firt_name_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(firt_name_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 410, 40));

        phone_TF.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        phone_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(phone_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 410, 40));

        pays_CB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pays_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OUI", "NON" }));
        add(pays_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 590, 410, 40));

        type_client_CB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        type_client_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AUTRES", "CLIENTS PRIVÉS", "CLIENTS AFFAIRES", "CLIENTS GROUPES", "VIP" }));
        add(type_client_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, 410, 40));

        carte_CB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        carte_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OUI", "NON" }));
        add(carte_CB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 780, 410, 40));

        RECHERCHE_JLABEL.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        RECHERCHE_JLABEL.setForeground(new java.awt.Color(255, 255, 255));
        RECHERCHE_JLABEL.setText(" Research :");
        add(RECHERCHE_JLABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 320, 220, 50));

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
        add(recherche_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 330, 410, 40));

        SUPRIMER_JB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SUPRIMER_JB.setText("DELETE");
        SUPRIMER_JB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPRIMER_JBActionPerformed(evt);
            }
        });
        add(SUPRIMER_JB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 780, 140, 40));

        AJOUTER_JB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AJOUTER_JB.setText("ADD");
        AJOUTER_JB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AJOUTER_JBActionPerformed(evt);
            }
        });
        add(AJOUTER_JB, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 780, 140, 40));

        MODIFIER_JB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MODIFIER_JB.setText("MODIFY");
        MODIFIER_JB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODIFIER_JBActionPerformed(evt);
            }
        });
        add(MODIFIER_JB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 780, 140, 40));

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
        jScrollPane1.setViewportView(CUSTOMERS_LIST_JTABLE);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 840, 1160, 170));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/Customers/fleure2.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 1610, 1190));
    }// </editor-fold>//GEN-END:initComponents

    private void last_name_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_name_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last_name_TFActionPerformed

    private void AJOUTER_JBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AJOUTER_JBActionPerformed
        // TODO add your handling code here:
        if (CustomersController.store(last_name_TF.getText(), firt_name_TF.getText(), phone_TF.getText(), pays_CB.getSelectedItem().toString(), type_client_CB.getSelectedItem().toString(), carte_CB.getSelectedItem().toString())) {
            CUSTOMERS_LIST_JTABLE.setModel(CustomersController.getAll());
            JOptionPane.showMessageDialog(null, " Insertion réussi ");
            
            
        }
        
    }//GEN-LAST:event_AJOUTER_JBActionPerformed

    private void recherche_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recherche_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recherche_TFActionPerformed

    private void SUPRIMER_JBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPRIMER_JBActionPerformed
        // TODO add your handling code here:
         int myIndex = CUSTOMERS_LIST_JTABLE.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, " Aucune line du tableau n'est selectionné ");
        } else {
                    DefaultTableModel model = (DefaultTableModel) CUSTOMERS_LIST_JTABLE.getModel();
            if (CustomersController.destroy(Integer.parseInt(model.getValueAt(myIndex, 0).toString()))) {
                CUSTOMERS_LIST_JTABLE.setModel(CustomersController.getAll());// pour rafraichir la table
            }
        }
    }//GEN-LAST:event_SUPRIMER_JBActionPerformed

    private void MODIFIER_JBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODIFIER_JBActionPerformed
        // TODO add your handling code here:
         int myIndex = CUSTOMERS_LIST_JTABLE.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null," No table row is selected ");
        } else {
            DefaultTableModel model = (DefaultTableModel) CUSTOMERS_LIST_JTABLE.getModel();
            if (CustomersController.update(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), last_name_TF.getText(), firt_name_TF.getText(), phone_TF.getText(), pays_CB.getSelectedItem().toString(), type_client_CB.getSelectedItem().toString(), carte_CB.getSelectedItem().toString())) {
                CUSTOMERS_LIST_JTABLE.setModel(CustomersController.getAll());
                JOptionPane.showMessageDialog(null, "the modification is carried out successfully");
            }
        }
    }//GEN-LAST:event_MODIFIER_JBActionPerformed

    private void CUSTOMERS_LIST_JTABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CUSTOMERS_LIST_JTABLEMouseClicked
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) CUSTOMERS_LIST_JTABLE.getModel();
        
        //pour changer la couleur quand on clique dessus et pour mettre la ligne en exergue
        CUSTOMERS_LIST_JTABLE.setSelectionForeground(new Color(255, 255, 255, 255));
        CUSTOMERS_LIST_JTABLE.setSelectionForeground(new Color(232, 57, 95));
        int myIndex = CUSTOMERS_LIST_JTABLE.getSelectedRow();
        last_name_TF.setText(model.getValueAt(myIndex, 1).toString());
        firt_name_TF.setText(model.getValueAt(myIndex, 2).toString());
        phone_TF.setText(model.getValueAt(myIndex, 3).toString());
        pays_CB.setSelectedItem(model.getValueAt(myIndex, 4).toString());
        type_client_CB.setSelectedItem(model.getValueAt(myIndex, 5).toString());
        carte_CB.setSelectedItem(model.getValueAt(myIndex, 6).toString());
    }//GEN-LAST:event_CUSTOMERS_LIST_JTABLEMouseClicked

    private void recherche_TFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recherche_TFKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) CUSTOMERS_LIST_JTABLE.getModel();
        CUSTOMERS_LIST_JTABLE.setModel(CustomersController.search(recherche_TF.getText()));
    }//GEN-LAST:event_recherche_TFKeyReleased
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AJOUTER_JB;
    private javax.swing.JLabel CARTE_JLABEL;
    private javax.swing.JLabel CONTRY_JLABEL;
    private javax.swing.JTable CUSTOMERS_LIST_JTABLE;
    private javax.swing.JLabel FIRST_NAME_JLABEL;
    private javax.swing.JLabel LAST_NAME_JLABEL;
    private javax.swing.JButton MODIFIER_JB;
    private javax.swing.JLabel PHONE_JLABEL;
    private javax.swing.JLabel RECHERCHE_JLABEL;
    private javax.swing.JButton SUPRIMER_JB;
    private javax.swing.JLabel TYPE_JLABEL;
    private javax.swing.JComboBox<String> carte_CB;
    private javax.swing.JTextField firt_name_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField last_name_TF;
    private javax.swing.JComboBox<String> pays_CB;
    private javax.swing.JTextField phone_TF;
    private javax.swing.JTextField recherche_TF;
    private javax.swing.JComboBox<String> type_client_CB;
    // End of variables declaration//GEN-END:variables
}
