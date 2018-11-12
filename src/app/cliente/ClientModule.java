package app.cliente;

import app.arquivo.Arquivo;
import java.awt.EventQueue;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Bruno
 */
public class ClientModule extends JFrame {
    
    private static final Integer MAX_FILE_LENGHT_KB = 5120;
    private Arquivo arquivo;

    public ClientModule() {
        initComponents();
        setVisible(true);
        initListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelServidor = new javax.swing.JPanel();
        labelIP = new javax.swing.JLabel();
        campoIP = new javax.swing.JTextField();
        labelPorta = new javax.swing.JLabel();
        campoPorta = new javax.swing.JTextField();
        labelDiretorio = new javax.swing.JLabel();
        campoDiretorio = new javax.swing.JTextField();
        panelArquivo = new javax.swing.JPanel();
        labelArquivo = new javax.swing.JLabel();
        campoArquivoEscolhido = new javax.swing.JTextField();
        buttonArquivo = new javax.swing.JButton();
        labelTamanhoArquivo = new javax.swing.JLabel();
        campoTamanhoArquivo = new javax.swing.JTextField();
        panelOpcoes = new javax.swing.JPanel();
        buttonEnviar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sincronizador de Arquivos (BETA)");
        setResizable(false);

        labelTitulo.setText("Sincronizador de Arquivos");

        panelServidor.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes do servidor"));

        labelIP.setText("IP");

        labelPorta.setText("Porta");

        labelDiretorio.setText("Diretório de destino");

        javax.swing.GroupLayout panelServidorLayout = new javax.swing.GroupLayout(panelServidor);
        panelServidor.setLayout(panelServidorLayout);
        panelServidorLayout.setHorizontalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServidorLayout.createSequentialGroup()
                        .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelPorta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoPorta)
                            .addComponent(campoIP)))
                    .addGroup(panelServidorLayout.createSequentialGroup()
                        .addComponent(labelDiretorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDiretorio)))
                .addContainerGap())
        );
        panelServidorLayout.setVerticalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoIP)
                    .addComponent(labelIP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoPorta)
                    .addComponent(labelPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoDiretorio)
                    .addComponent(labelDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelArquivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Arquivo a ser enviado"));

        labelArquivo.setText("Arquivo carregado");

        campoArquivoEscolhido.setText("Nenhum arquivo selecionado...");

        buttonArquivo.setText("Escolher arquivo...");

        labelTamanhoArquivo.setText("Tamanho do arquivo");

        javax.swing.GroupLayout panelArquivoLayout = new javax.swing.GroupLayout(panelArquivo);
        panelArquivo.setLayout(panelArquivoLayout);
        panelArquivoLayout.setHorizontalGroup(
            panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArquivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelArquivoLayout.createSequentialGroup()
                        .addGroup(panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTamanhoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoArquivoEscolhido, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(campoTamanhoArquivo))))
                .addContainerGap())
        );
        panelArquivoLayout.setVerticalGroup(
            panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArquivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoArquivoEscolhido)
                    .addComponent(labelArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoTamanhoArquivo)
                    .addComponent(labelTamanhoArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonArquivo)
                .addContainerGap())
        );

        buttonEnviar.setText("Enviar");

        buttonCancelar.setText("Cancelar");

        javax.swing.GroupLayout panelOpcoesLayout = new javax.swing.GroupLayout(panelOpcoes);
        panelOpcoes.setLayout(panelOpcoesLayout);
        panelOpcoesLayout.setHorizontalGroup(
            panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEnviar)
                .addContainerGap())
        );
        panelOpcoesLayout.setVerticalGroup(
            panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEnviar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        EventQueue.invokeLater(ClientModule::new);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonArquivo;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JTextField campoArquivoEscolhido;
    private javax.swing.JTextField campoDiretorio;
    private javax.swing.JTextField campoIP;
    private javax.swing.JTextField campoPorta;
    private javax.swing.JTextField campoTamanhoArquivo;
    private javax.swing.JLabel labelArquivo;
    private javax.swing.JLabel labelDiretorio;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelPorta;
    private javax.swing.JLabel labelTamanhoArquivo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelArquivo;
    private javax.swing.JPanel panelOpcoes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelServidor;
    // End of variables declaration//GEN-END:variables

    private void initListeners() {
        buttonArquivo.addActionListener(evtFile -> escolherArquivo());
        buttonCancelar.addActionListener(evtExit -> System.exit(0));
        buttonEnviar.addActionListener(evtSend -> enviarArquivo());
    }

    private void escolherArquivo() {
        FileInputStream inputStream;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle("Escolha o arquivo");
        
        if (chooser.showOpenDialog(this) == JFileChooser.OPEN_DIALOG) {
            File arquivoSelecionado = chooser.getSelectedFile();
            byte[] byteArquivo = new byte[(int) arquivoSelecionado.length()];
            try {
                
                inputStream = new FileInputStream(arquivoSelecionado);
                inputStream.read(byteArquivo);
                inputStream.close();
                
                System.out.println(arquivoSelecionado.length());
                long kbSize = arquivoSelecionado.length() / 1024;
                campoArquivoEscolhido.setText(arquivoSelecionado.getName());
                campoTamanhoArquivo.setText(kbSize + " KB");
                
                arquivo = new Arquivo();
                arquivo.setConteudo(byteArquivo);
                arquivo.setDataHoraUpload(new Date());
                arquivo.setNome(arquivoSelecionado.getName());
                arquivo.setTamanhoKB(kbSize);
                arquivo.setIpDestino(campoIP.getText());
                arquivo.setPortaDestino(campoPorta.getText());
                System.out.println(campoDiretorio.getText().trim());
                arquivo.setDiretorioDestino(campoDiretorio.getText().trim());
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void enviarArquivo() {
        if (arquivoValido()) {
            String ip = this.campoIP.getText().trim();
            Integer porta = Integer.parseInt(campoPorta.getText().trim());
            try (Socket socket = new Socket(ip, porta)) {
                BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream());
                byte[] byteArray = serializarArquivo();
                output.write(byteArray);
                output.flush();
                output.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private boolean arquivoValido() {
        if (arquivo.getTamanhoKB() > MAX_FILE_LENGHT_KB) {
            JOptionPane.showMessageDialog(this, "Tamanho máximo excedido (" + (MAX_FILE_LENGHT_KB / 1024) +")");
            return false;
        }
        return true;
    }

    private byte[] serializarArquivo() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objeto = new ObjectOutputStream(outputStream);
            objeto.writeObject(arquivo);
            return outputStream.toByteArray();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
