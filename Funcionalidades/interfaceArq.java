package Funcionalidades;

import Funcionalidades.Operations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        TextoDescField.setBounds(45, 480, 900, 250);
        DescButton.setBounds(45, 730, 900, 30);
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
            final JFileChooser fc = new JFileChooser();
            System.out.println(fc.showOpenDialog(this)); 
            try {
                
                fc.getSelectedFile();
                // path = String.valueOf(reader);
                // TextoParaComp = TextoCodField.getText();
                // JOptionPane.showMessageDialog(this, TextoParaComp);
                // String caminho = Operations.ExcutaBinario(TextoParaComp,path);
                // Operations.compactaTexto(TextoParaComp,caminho);

            } catch (Exception ex) {}
        }

        else if (e.getSource() == CodButton) {
            String TextoParaComp = TextoCodField.getText();
            System.out.println(TextoParaComp);
            String NomeArq = nomeArq.getText();
            System.out.println(NomeArq);
            String path = "";
            if (NomeArq.equals("")){
                NomeArq = "GomaD";
            }
            try {
                JFileChooser f = new JFileChooser();
                f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                f.showSaveDialog(null);
                path = f.getSelectedFile().toString();
                String caminho = Operations.ExcutaBinario(TextoParaComp,NomeArq,path);
                System.out.println(caminho);
                System.out.println(Operations.compactaTexto(TextoParaComp,caminho));
                JOptionPane.showMessageDialog(this, "O arquivo está salvo na pasta "+caminho+" contida na pasta do projeto !!!!");

            } catch (Exception ex) {}
        }
        if (e.getSource() == DescButton){
            container.add(TextoDescField);
        }
    }
}
