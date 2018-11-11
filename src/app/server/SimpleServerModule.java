package app.server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno
 */
public class SimpleServerModule {

    public static void main(String[] args) {
        BufferedInputStream bufferInput;
        FileInputStream fileInput;
        byte[] byteArray;
        
        try (ServerSocket serverSocket = new ServerSocket(5566)) {
            Socket socket = null;
            while (true) {
                System.out.println("Listening on: " + InetAddress.getLocalHost() + ":" + serverSocket.getLocalPort());
                socket = serverSocket.accept();
                System.out.println("Client Found! Waiting for file...");
                
                ObjectOutputStream objectOut = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
                FileOutputStream fileOut;
                byte[] buffer = new byte[1024];
                
                Object objeto = objectIn.readObject();
                fileOut = new FileOutputStream(objeto.toString());
                //fileOut = new FileOutputStream(new File("C:\\temp\\teste-copia.txt"));
                
                Integer bytesRead = 0;
                
                do {
                    objeto = objectIn.readObject();
                    bytesRead = (Integer) objeto;
                    objeto = objectIn.readObject();
                    buffer = (byte[]) objeto;
                    fileOut.write(buffer, 0, bytesRead);
                } while(bytesRead == 1024);
                
                System.out.println("File transfered!");
                
                fileOut.close();
                objectIn.close();
                objectOut.close();
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(SimpleServerModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SimpleServerModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
