/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vespertino
 */
public class VentanaPeregrino extends javax.swing.JFrame {
    private String myDriver;
    //private String myUrl = "jdbc:mysql://192.168.209.128:3306/ELCAMINO?zeroDateTimeBehavior=convertToNull";
    private String myUrl;
    private Connection conn;

    /**
     * Creates new form VentanaAlbergue
     */
    public VentanaPeregrino() {
        initComponents();
        setTitle("Peregrinos");
        //hacer conexión
        myDriver = "com.mysql.cj.jdbc.Driver";
        myUrl = "jdbc:mysql://192.168.25.128:3306/ELCAMINO";
        try {
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "usuario", "curso2122");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    conn.close(); //se cierra la conexión al cerrar la ventana.
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

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
        txtNombrePeregrino = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtFechaFinal = new javax.swing.JTextField();
        txtIdPeregrino = new javax.swing.JTextField();
        txtNacionPeregrino = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jButton2.setText("Baja");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel4.setText("Fecha final:");

        jLabel3.setText("Nación:");

        jLabel2.setText("Nombre Peregrino:");

        jButton1.setText("Limpiar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setText("Id Peregrino:");

        jButton3.setText("Alta");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
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
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(txtNombrePeregrino, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFechaFinal, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNacionPeregrino, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtIdPeregrino, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(9, 9, 9)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtIdPeregrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombrePeregrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNacionPeregrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        txtNombrePeregrino.setText("");
        txtIdPeregrino.setText("");
        txtFechaFinal.setText("");
        txtNacionPeregrino.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private String fixFecha(String fecha){
        String resultado = "";
        StringTokenizer st = new StringTokenizer(fecha, "/");
        String[] elementos = new String[3];
        for (int i = 0; i < elementos.length; i++) {
            elementos[i]=st.nextToken();
        }

        for (int i = elementos.length-1; i >-1 ; i--) {
            resultado += elementos[i]+"/";
        }

        resultado = resultado.substring(0, resultado.length()-1); //elimina el ultimo caracter

        System.out.println(resultado);

        return resultado;
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        System.out.println("Alta");
        String id, nombre, nacion, fecha;
        String dateClean;

        id = txtIdPeregrino.getText().trim();
        nombre = txtNombrePeregrino.getText().trim();
        nacion = txtNacionPeregrino.getText().trim();
        fecha = txtFechaFinal.getText().trim();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        


        if (id.equals("") || nombre.equals("") || fecha.equals("")) {
            JFrame jf5 = new JFrame();
            JOptionPane.showMessageDialog(jf5, "Los campos dni, nombre y fecha son obligatorios");
            return;
        }
        
        if(!id.matches("[0-9]+")){
            JFrame jf6 = new JFrame();
            JOptionPane.showMessageDialog(jf6, "El id del peregrino ha de ser un número.");
            return;
        }

        try {
            Statement st = conn.createStatement();

            Statement st2 = conn.createStatement();

            ResultSet rs = st2.executeQuery("SELECT * FROM PEREGRINO WHERE dni='" + id + "'");

            if (!rs.next()) {
                fecha = fixFecha(fecha);
                st.executeUpdate("INSERT INTO PEREGRINO(dni, nombre, nacion, fechafinal) VALUES('" + id + "','" + nombre + "','" + nacion + "','" + /*dateClean*/ fecha + "')");
                System.out.println("Registro introducido con exito.");
            } else {
                JFrame jf3 = new JFrame();
                JOptionPane.showMessageDialog(jf3, "El Peregrino con dni: " + id + " ya esta introducido en la base de datos");
                //System.out.println("Ya esta metido");
            }
            rs.close();
            st.close();
            st2.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        System.out.println("Baja");
        JFrame jf = new JFrame();
        int result = JOptionPane.showConfirmDialog(jf, "Seguro que desea borrar el registro?");

        if (result == 1) {
            return;
        } else if (result == 0) {
            String id;

            id = txtIdPeregrino.getText();

            try {
                Statement st = conn.createStatement();
                Statement st2 = conn.createStatement();

                ResultSet rs = st2.executeQuery("SELECT * FROM PEREGRINO WHERE dni='" + id + "'");

                if (rs.next()) {
                    st.executeUpdate("DELETE FROM PEREGRINO WHERE dni='" + id + "'");
                    JFrame jf4 = new JFrame();
                    JOptionPane.showMessageDialog(jf4, "Registro borrado con éxito.");
                    System.out.println("Registro borrado.");
                } else {
                    JFrame jf2 = new JFrame();
                    JOptionPane.showMessageDialog(jf2, "El Peregrino con dni: " + id + " no esta introducido en la base de datos");
                    //System.out.println("Ya esta metido");
                }
                rs.close();
                st.close();
                st2.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return;
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        System.out.println("UPDATE");
        String id, nombre, nacion, fecha;
        String dateClean;

        id = txtIdPeregrino.getText().trim();
        nombre = txtNombrePeregrino.getText().trim();
        nacion = txtNacionPeregrino.getText().trim();
        fecha = txtFechaFinal.getText().trim();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        if (id.equals("") || nombre.equals("") || fecha.equals("")) {
            JFrame jf5 = new JFrame();
            JOptionPane.showMessageDialog(jf5, "Los campos dni, nombre y fecha son obligatorios");
            return;
        }
        
        if(!id.matches("[0-9]+")){
            JFrame jf6 = new JFrame();
            JOptionPane.showMessageDialog(jf6, "El id del peregrino ha de ser un número.");
            return;
        }

        try {
            Statement st = conn.createStatement();

            Statement st2 = conn.createStatement();

            ResultSet rs = st2.executeQuery("SELECT * FROM PEREGRINO WHERE dni='" + id + "'");

            if (!rs.next()) {
                JFrame jf3 = new JFrame();
                JOptionPane.showMessageDialog(jf3, "El Peregrino con dni: " + id + " no esta introducido en la base de datos");                                
            } else {
                st.executeUpdate("UPDATE PEREGRINO set nombre='"+nombre+"', nacion='"+nacion+"', fechafinal='"+fixFecha(fecha)+"' where dni= '"+id+"'");
               // st.executeUpdate("UPDATE PEREGRINO set nacion='"+nacion+"' where id= '"+id+"'");
               // st.executeUpdate("UPDATE PEREGRINO set fechafinal='"+fecha+"' where id= '"+id+"'");
                System.out.println("Registro introducido con exito.");
                //System.out.println("Ya esta metido");
            }
            rs.close();
            st.close();
            st2.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAlbergue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4MouseClicked

    public static void abrir() {
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
            java.util.logging.Logger.getLogger(VentanaPeregrino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPeregrino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPeregrino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPeregrino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPeregrino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtIdPeregrino;
    private javax.swing.JTextField txtNacionPeregrino;
    private javax.swing.JTextField txtNombrePeregrino;
    // End of variables declaration//GEN-END:variables
}
