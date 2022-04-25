/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vespertino
 */
public class VentanaAlbergue extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAlbergue
     */
    public VentanaAlbergue() {
        initComponents();
        setTitle("Albergues");
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
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
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNombreAlbergue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtIdCiudad = new javax.swing.JTextField();
        txtIdAlbergue = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jButton2.setText("Baja");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel4.setText("id Ciudad:");

        jLabel3.setText("Capacidad:");

        jLabel2.setText("Nombre Albergue:");

        jButton1.setText("Limpiar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Id Albergue:");

        jButton3.setText("Alta");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreAlbergue, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtIdCiudad, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtIdAlbergue, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(9, 9, 9)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtIdAlbergue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombreAlbergue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtIdCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        txtNombreAlbergue.setText("");
        txtIdAlbergue.setText("");
        txtIdCiudad.setText("");
        txtCapacidad.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        System.out.println("ALTA");
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://192.168.209.128:3306/ELCAMINO?zeroDateTimeBehavior=convertToNull";
        String id, nombre, capacidad, idCiudad;

        id = txtIdAlbergue.getText().trim();
        nombre = txtNombreAlbergue.getText().trim();
        capacidad = txtCapacidad.getText().trim();
        idCiudad = txtCapacidad.getText().trim();

        if (id.equals("") || nombre.equals("")) {
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf, "Los campos de id y nombre son obligatorios");
            return;
        }
        
        if(!capacidad.matches("[0-9]+")){
            JFrame jf6 = new JFrame();
            JOptionPane.showMessageDialog(jf6, "La capacidad ha de ser numérica.");
            return;
        }        

        try {
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "usuario", "curso2122");
            Statement st = conn.createStatement();

            Statement st2 = conn.createStatement();

            ResultSet rs = st2.executeQuery("SELECT * FROM ALBERGUE WHERE idalbergue='" + id + "'");

            if (!rs.next()) {
                //st.execute("INSERT INTO ALBERGUE VALUES('"+id+"','"+nombre+"','"+capacidad+"','"+idCiudad+"')");
                st.executeUpdate("INSERT INTO ALBERGUE(idalbergue, nomalbergue, capacidad, idciudad) VALUES('" + id + "','" + nombre + "','" + capacidad + "','" + idCiudad + "')");
                System.out.println("Registro introducido con exito.");
            } else {
                JFrame jf3 = new JFrame();
                JOptionPane.showMessageDialog(jf3, "El Albergue con id: " + id + " ya esta introducido en la base de datos");
                //System.out.println("Ya esta metido");
            }
            rs.close();
            st.close();
            st2.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        System.out.println("BAJA");
        JFrame jf4 = new JFrame();
        int result = JOptionPane.showConfirmDialog(jf4, "Seguro que desea borrar el registro?");

        if (result == 1) {
            return;
        } else if (result == 0) {

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://192.168.209.128:3306/ELCAMINO?zeroDateTimeBehavior=convertToNull";
            String id;

            id = txtIdAlbergue.getText();

            try {
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "usuario", "curso2122");
                Statement st = conn.createStatement();

                Statement st2 = conn.createStatement();

                ResultSet rs = st2.executeQuery("SELECT * FROM ALBERGUE WHERE idalbergue='" + id + "'");

                if (rs.next()) {
                    st.executeUpdate("DELETE FROM ALBERGUE WHERE idalbergue='" + id + "'");
                    JFrame jf5 = new JFrame();
                    JOptionPane.showMessageDialog(jf5, "Registro borrado con éxito.");
                    System.out.println("Registro borrado.");
                } else {
                    JFrame jf6 = new JFrame();
                    JOptionPane.showMessageDialog(jf6, "El albergue con id: "+id+" no existe en la base de datos.");
                    System.out.println("Ya esta metido");
                }
                rs.close();
                st.close();
                st2.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return;
        }
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(VentanaAlbergue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAlbergue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAlbergue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAlbergue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAlbergue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtIdAlbergue;
    private javax.swing.JTextField txtIdCiudad;
    private javax.swing.JTextField txtNombreAlbergue;
    // End of variables declaration//GEN-END:variables
}