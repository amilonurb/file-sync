package app.tests;

import app.arquivo.Arquivo;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class _Server {

    public static void main(String args[]) {
        try {
            ServerSocket srvSocket = new ServerSocket(5566);
            System.out.println(InetAddress.getLocalHost());
            System.out.println("Aguardando envio de arquivo ...");
            Socket socket = srvSocket.accept();

            byte[] objectAsByte = new byte[socket.getReceiveBufferSize()];
            BufferedInputStream bf = new BufferedInputStream(socket.getInputStream());
            bf.read(objectAsByte);

            Arquivo arquivo = (Arquivo) getObjectFromByte(objectAsByte);

            String dir = arquivo.getDiretorioDestino().endsWith("\\") ? 
                    arquivo.getDiretorioDestino() + arquivo.getNome() : 
                    arquivo.getDiretorioDestino() + "\\" + arquivo.getNome();
            
            System.out.println("Escrevendo arquivo em: " + dir);

            FileOutputStream fos = new FileOutputStream(dir);
            fos.write(arquivo.getConteudo());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object getObjectFromByte(byte[] objectAsByte) {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(objectAsByte);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            bis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
