package Funcionalidades;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class interfaceArq extends JFrame implements ActionListener {
    //Texto digitado
    Container container = getContentPane();
    JLabel TextoCod = new JLabel("Digite o texto que deseja compactar:");
    JTextArea TextoCodField = new JTextArea();
    JButton CodButton = new JButton("Compactar");
    JLabel nomeArqLabel = new JLabel("Nome do Arquivo:");
    JTextField nomeArq = new JTextField();

    // Texto de Arquivo
    JLabel CodArqui= new JLabel("Selecione o Arquivo que deseja compactar:");
    JButton CodArquiButton = new JButton("Compactar Arquivo");

    // Descompacta
    JLabel TextoDesc = new JLabel("Texto descompactado:");
    JTextArea TextoDescField = new JTextArea();
    JScrollPane sp = new JScrollPane(TextoDescField);
    // JScrollPane scrollPane = new JScrollPane(TextoDescField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JButton DescButton = new JButton("Descompactar");

    public interfaceArq() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);

        TextoCodField.setLineWrap(true);
        TextoDescField.setLineWrap(true);
    }

    public void setLocationAndSize() {
        TextoCod.setBounds(45, 20, 300, 30);
        TextoCodField.setBounds(45, 50, 900, 250);
        CodButton.setBounds(45, 300, 900, 30);

        CodArqui.setBounds(45,400,250,30);
        CodArquiButton.setBounds(310, 400, 350, 30);

        nomeArqLabel.setBounds(695, 6, 100, 60);
        nomeArq.setBounds(795, 25, 150, 20);
        

        TextoDesc.setBounds(45, 450, 200, 30);
        sp.setBounds(45, 480, 900, 250);
        DescButton.setBounds(45, 740, 900, 30);
    }

    public void addComponentsToContainer() {
        container.add(TextoCod);
        container.add(TextoDesc);
        container.add(CodArqui);

        container.add(TextoCodField);
        container.add(nomeArqLabel);
        container.add(nomeArq);
       
        container.add(CodButton);
        container.add(CodArquiButton);
        container.add(DescButton);
    }

    public void addActionEvent() {
        CodButton.addActionListener(this);
        DescButton.addActionListener(this);
        CodArquiButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == CodArquiButton){
            String NomeArq = "";
            String pathM = "";
            JFileChooser f = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = f.showOpenDialog(null);
            String path = "";
            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File selectedFile = f.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                int position = path.lastIndexOf("\\")+1;
                int tam = path.length();
                NomeArq = path.substring(position,tam);
                pathM = path.substring(0,position-1);
                int pontoArq = NomeArq.lastIndexOf(".");
                NomeArq = NomeArq.substring(0,pontoArq);
            }
        
            try {
                String caminho = Operations.ExecutaBinarioArq(NomeArq,path,pathM);
                String binario = Operations.compactaTexto(Operations.leitor(caminho),caminho);
                Operations.escritorDesc(caminho, binario);
                JOptionPane.showMessageDialog(this, "O arquivo está salvo na pasta "+caminho+" contida na pasta do projeto !!!!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao compactar o arquivo");
                System.out.println(ex.getMessage());
            }
        }

        else if (e.getSource() == CodButton) {
            String TextoParaComp = TextoCodField.getText();
            String NomeArq = nomeArq.getText();
            String path = "";
            if (NomeArq.equals("")){
                NomeArq = "GomaD";
            }
            try {
                JFileChooser f = new JFileChooser();
                f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                f.showSaveDialog(null);
                path = f.getSelectedFile().toString();
                String caminho = Operations.ExecutaBinario(TextoParaComp,NomeArq,path);
                String binario = Operations.compactaTexto(TextoParaComp,caminho);
                Operations.escritorDesc(caminho, binario);
                JOptionPane.showMessageDialog(this, "O arquivo está salvo na pasta "+caminho+" contida na pasta do projeto !!!!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao compactar o texto");
                System.out.println(ex);
            }
        }
        if (e.getSource() == DescButton){
            container.add(sp);
            
            JFileChooser f = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = f.showOpenDialog(null);
            String path = "",NomeArq="",pathM="";
            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File selectedFile = f.getSelectedFile();
                path = selectedFile.getAbsolutePath();

                int position = path.lastIndexOf("\\")+1;
                int tam = path.length();
                NomeArq = path.substring(position,tam);
                pathM = path.substring(0,position-1);
                int pontoArq = NomeArq.lastIndexOf(".");
                NomeArq = NomeArq.substring(0,pontoArq);                
            }
            
            try{
                String Descompacta = Operations.descompactaTexto(path);
                TextoDescField.setText(Descompacta);
                Operations.escritorArq(pathM,Descompacta,NomeArq);
                JOptionPane.showMessageDialog(this, "O arquivo foi descompactado com sucesso e foi salvo na pasta de destino !!!!");
            }
            catch(Exception sla){
                System.out.println(sla);
                JOptionPane.showMessageDialog(this, "Impossivel Descompactar");
            }
           
        }
    }
}
