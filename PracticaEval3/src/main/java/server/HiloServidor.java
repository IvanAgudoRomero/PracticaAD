/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HiloServidor implements Runnable{

    private String myDriver;
    private String myUrl;
    private Connection conn;

    public HiloServidor(){
        myDriver = "com.mysql.cj.jdbc.Driver";
        //myUrl = "jdbc:mysql://192.168.209.128:3306/ELCAMINO?zeroDateTimeBehavior=convertToNull";
        myUrl = "jdbc:mysql://192.168.25.128:3306/ELCAMINO";

        try {
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "usuario", "curso2122");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        String msg;
        String dato;
        while(true) {
            try {
                serverSocket = new ServerSocket(7777);
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader
                        (clientSocket.getInputStream()));
                msg = in.readLine();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.print(msg);

                dato = query(msg);

                out.println(dato);


            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                out.close();
                try {
                    in.close();
                    clientSocket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String query(String msg) throws SQLException{
        Statement st = conn.createStatement();
        String sql;
        
        String[] splitter = msg.split(" ");
        
        sql = "SELECT dni, nombre, nacion FROM PEREGRINO WHERE dni IN(SELECT dni FROM RESERVA WHERE fecha = '"+splitter[0]+"' AND idAlbergue = '"+splitter[1]+"')";

        ResultSet rs = st.executeQuery(sql);
        String s = "";
        while(rs.next()){
            s = String.format("%s%d\t\t%s\t%s\n", s, rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        rs.close();
        st.close();
        return s;
    }
}
