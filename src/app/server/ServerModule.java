package app.server;

import app.arquivo.Arquivo;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno
 */
public class ServerModule {

    private static final int PORT = 5566;

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedInputStream buffer;
    private static Arquivo arquivo;
    private static FileOutputStream fileOutputStream;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor iniciado.");
            System.out.println("InetAddress: " + InetAddress.getLocalHost());
            System.out.println("Porta: " + serverSocket.getLocalPort());
            
            while (true) {
                System.out.println("Aguardando envio de arquivo...");
                socket = serverSocket.accept();
                System.out.println("Conexão aberta: " + socket);
                
                byte[] objectAsByte = new byte[socket.getReceiveBufferSize()];
                buffer = new BufferedInputStream(socket.getInputStream());
                buffer.read(objectAsByte);
                
                arquivo = (Arquivo) getObjectFromByte(objectAsByte);
                String diretorio = arquivo.getDiretorioDestino().endsWith("\\")
                        ? arquivo.getDiretorioDestino() + arquivo.getNome()
                        : arquivo.getDiretorioDestino() + "\\" + arquivo.getNome();

                System.out.println("Escrevendo arquivo em: " + diretorio);
                fileOutputStream = new FileOutputStream(diretorio);
                fileOutputStream.write(arquivo.getConteudo());
                fileOutputStream.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Object getObjectFromByte(byte[] objectAsByte) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(objectAsByte);
        ObjectInputStream inputStream = new ObjectInputStream(byteArray);
        Object objeto = inputStream.readObject();
        byteArray.close();
        inputStream.close();
        return objeto;
    }
}
