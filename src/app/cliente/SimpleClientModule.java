package app.cliente;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno
 */
public class SimpleClientModule {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("192.168.56.1", 5566)) {
            System.out.println("Nome do arquivo da pasta \"Hard-coded\":");
            Scanner sc = new Scanner(System.in);
            String filename = sc.next();
            
            File file = new File("C:\\Users\\2016101533\\Desktop\\", filename);
            ObjectInputStream objectIn = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream objectOut = new ObjectOutputStream(clientSocket.getOutputStream());
            objectOut.writeObject(file.getName());
            FileInputStream fileIn = new FileInputStream(file);
            
            byte[] buffer = new byte[1024];
            Integer bytesRead = 0;
            while ((bytesRead = fileIn.read(buffer)) > 0) {
                objectOut.writeObject(bytesRead);
                objectOut.writeObject(Arrays.copyOf(buffer, buffer.length));
            }
            
            objectIn.close();
            objectOut.close();
        } catch (IOException ex) {
            Logger.getLogger(SimpleClientModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
