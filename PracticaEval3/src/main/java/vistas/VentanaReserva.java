/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Vespertino
 */
public class VentanaReserva extends javax.swing.JFrame {

    private String myDriver;
    private String myUrl;
    private Connection conn;
    /**
     * Creates new form VentanaReserva
     */

    private void instanciaConexion(){
        try {
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "usuario", "curso2122");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public VentanaReserva() {
        setTitle("Reservas");
        myDriver = "com.mysql.cj.jdbc.Driver";
        //myUrl = "jdbc:mysql://192.168.209.128:3306/ELCAMINO?zeroDateTimeBehavior=convertToNull";
        myUrl = "jdbc:mysql://192.168.25.128:3306/ELCAMINO";

        instanciaConexion();

        initComponents();
        jComboBox2.setEditable(false);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        Action buscarPeregrino = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar y poner el peregrino
                Statement st = null;
                try {
                    st = conn.createStatement();
                    String dniTextField = jTextField1.getText().trim();
                    st.execute("select nombre from PEREGRINO WHERE dni= "+"'"+dniTextField+"'");
                    ResultSet rs = st.getResultSet();
                    if(!rs.next()){
                        //no esta
                        System.out.println("no está");
                    }else{
                        //esta
                        jLabel8.setText(rs.getString(1));
                        //System.out.println(rs.getString(1));
                    }
                    //el primero
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    try {
                        st.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        };

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

        jTextField1.addActionListener(buscarPeregrino);

        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String idAlbergue;
                String nombre;
                int capacidad;

                List<String> opciones = new ArrayList<>();

                String etapa = jComboBox1.getSelectedItem().toString();

                etapa = getEtapa(etapa);

                String sql = "SELECT A.idalbergue, A.nomalbergue, A.capacidad FROM CIUDAD C INNER JOIN ETAPA E ON(C.idciudad=E.destino) " +
                        "inner join ALBERGUE A ON(C.idciudad=A.idciudad) where C.nomciudad = '"+etapa+"'";

                ResultSet rs = null;

                Statement st = null;
                try {
                    st = conn.createStatement();
                    rs = st.executeQuery(sql);

                    while(rs.next()){
                        idAlbergue = rs.getString(1);
                        nombre = rs.getString(2);
                        capacidad = rs.getInt(3);

                        opciones.add(idAlbergue+"-"+nombre+": "+capacidad);
                    }

                    String[] datos = new String[opciones.size()];
                    opciones.toArray(datos);
                    jComboBox2.setModel(new DefaultComboBoxModel<String>(datos));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally {
                    if(rs != null) {
                        try {
                            rs.close();
                            st.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservar();
            }
        });
    }

    private String getEtapa(String etapa) {
        StringTokenizer st = new StringTokenizer(etapa, "-");
        return st.nextToken();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("CAMINO DE SANTIAGO");

        jLabel2.setText("Camino:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Francés");
        jRadioButton1.setName("frances"); // NOI18N
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Aragonés");
        jRadioButton2.setName("aragones"); // NOI18N
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jLabel3.setText("Etapa");

        jComboBox1.setToolTipText("");
        jComboBox1.setName("etapa"); // NOI18N
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jLabel4.setText("Albergue");

        jComboBox2.setEditable(true);
        jComboBox2.setName("albergue"); // NOI18N

        jLabel5.setText("Peregrino");

        jTextField1.setName("nomPeregrino"); // NOI18N

        jLabel6.setText("Teclea DNI y pulsa ENTER");

        jLabel7.setText("Fecha(dd/mm/aaaa)");

        jTextField2.setName("fecha"); // NOI18N

        jButton1.setText("RESERVAR");

        jButton2.setText("LIMPIAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addGap(57, 57, 57)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(226, 226, 226)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(232, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)))
                .addGap(79, 79, 79)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(170, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        System.out.println("ARAGONES");
        //datos para etapa
        ArrayList<String> total = new ArrayList<>();

        ResultSet rsOrigen = null;
        ResultSet rsDestino = null;

        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();

            rsOrigen = st.executeQuery("select c.nomciudad from ETAPA e inner join CIUDAD c on(e.origen=c.idciudad) where e.nomcamino = 'Aragones'");
            rsDestino = st2.executeQuery("select c.nomciudad from ETAPA e inner join CIUDAD c on(e.destino=c.idciudad) where e.nomcamino = 'Aragones'");

            //guardas el origen
            while (rsOrigen.next()) {
                total.add(rsOrigen.getString(1).trim()); //da nulo aquí
            }

            //añades el destino donde se guarda el origen
            for (int i = 0; /*i < total.size()*/ rsDestino.next(); i++) {
                total.add(i, total.get(i) + "-" + rsDestino.getString(1).trim());
                total.remove(i+1);
            }

            String[] datos = new String[total.size()];
            total.toArray(datos);

            jComboBox1.setModel(new DefaultComboBoxModel<String>(datos)); //resulta que no se traga las listas y lo he puesto en array

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rsOrigen.close();
                rsDestino.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        System.out.println("FRANCES");
        //datos para etapa
        ArrayList<String> total = new ArrayList<>();

        ResultSet rsOrigen = null;
        ResultSet rsDestino = null;

        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();

            rsOrigen = st.executeQuery("select c.nomciudad from ETAPA e inner join CIUDAD c on(e.origen=c.idciudad) where e.nomcamino = 'Frances'");
            rsDestino = st2.executeQuery("select c.nomciudad from ETAPA e inner join CIUDAD c on(e.destino=c.idciudad) where e.nomcamino = 'Frances'");

            //guardas el origen
            while (rsOrigen.next()) {
                total.add(rsOrigen.getString(1).trim()); //da nulo aquí
            }

            //añades el destino donde se guarda el origen
            for (int i = 0; /*i < total.size()*/ rsDestino.next(); i++) {
                total.add(i, total.get(i) + "-" + rsDestino.getString(1).trim());
                total.remove(i+1);
            }

            String[] datos = new String[total.size()];
            total.toArray(datos);

            jComboBox1.setModel(new DefaultComboBoxModel<String>(datos)); //resulta que no se traga las listas y lo he puesto en array

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rsOrigen.close();
                rsDestino.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        buttonGroup1.clearSelection();
        jTextField1.setText("");
        jTextField2.setText("");
        jLabel8.setText("");
        jComboBox2.removeAllItems();
        try {
            jComboBox1.removeAllItems();
        }catch(Exception ex){
            System.out.println("Todo Limpio!");   //asi no se ve el error jajaja
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged
       // System.out.println("Francés?");
    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
       // System.out.println("Aragonés?");
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange

    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt){
        reservar();
    }

    private void reservar(){
        String dni;
        String fecha;
        String idAlbergue = null;

        dni = jTextField1.getText().trim();
        fecha = fixFecha(jTextField2.getText().trim());
        idAlbergue = jComboBox2.getSelectedItem().toString();  //no creo que esto funcione la verdad ||| pd: pues si funciona, si.

        idAlbergue = getIdAlbergue(idAlbergue);

        try {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();
            Statement st3 = conn.createStatement();
            Statement st4 = conn.createStatement();

            ResultSet rs = st2.executeQuery("select * from RESERVA where dni='"+dni+"' and fecha='"+fecha+"'");
            ResultSet rs2;
            int plazas = 0;
            if(!rs.next()){
                //no hay ninguna
                st.executeUpdate("INSERT INTO RESERVA(dni, fecha, idalbergue) VALUES('"+dni+"','"+fecha+"','"+idAlbergue+"')");
                JFrame jf2 = new JFrame();
                JOptionPane.showMessageDialog(jf2, "Reserva introducida con éxito.");

                rs2 = st3.executeQuery("SELECT plazaslibres FROM ALBERGUE WHERE idalbergue='"+idAlbergue+"'");
                while(rs2.next()){
                    plazas = rs2.getInt(1);
                }
                st4.executeUpdate("UPDATE ALBERGUE SET plazaslibres = '"+(plazas-1)+"' WHERE idalbergue ='"+idAlbergue+"'");
            }else{
                //ya hay una
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "La reserva con dni: "+dni+" y fecha: "+fecha+" ya se ha realizado.");;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private String getIdAlbergue(String idAlbergue) {
        StringTokenizer st = new StringTokenizer(idAlbergue,"-");
        return st.nextToken();
    }

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
            java.util.logging.Logger.getLogger(VentanaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
