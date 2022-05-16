/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Usuario
 */
public class ServidorInforme {
    public static void main(String[] args) {
        HiloServidor server = new HiloServidor();
        Thread hilo = new Thread(server);
        hilo.start();
    }
}
