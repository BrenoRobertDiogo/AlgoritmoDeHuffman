package Funcionalidades;

import Funcionalidades.Operations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class interfaceArq extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel TextoCod = new JLabel("Digite o texto que deseja compactar");
    JTextArea TextoCodField = new JTextArea();
    JButton CodButton = new JButton("Compactar");
    JButton CodArquiButton = new JButton("Compactar Arquivo");

    JLabel TextoDesc = new JLabel("Texto descompactado");
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
        TextoCod.setBounds(420, 20, 300, 30);
        TextoCodField.setBounds(150, 50, 700, 250);
        CodButton.setBounds(150, 300, 350, 30);
        CodArquiButton.setBounds(500, 300, 350, 30);
        

        TextoDesc.setBounds(450, 370, 200, 30);
        TextoDescField.setBounds(150, 400, 700, 250);
        DescButton.setBounds(150, 650, 700, 30);
    }

    public void addComponentsToContainer() {
        container.add(TextoCod);
        container.add(TextoDesc);
        container.add(TextoCodField);
       
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
            String path = "";
            try {
                JFileChooser f = new JFileChooser();
                f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                f.showSaveDialog(null);
        
                // System.out.println(f.getCurrentDirectory());
                System.out.println(f.getSelectedFile());

                TextoParaComp = TextoCodField.getText();
                String caminho = Operations.ExcutaBinario(TextoParaComp,"PrimeiroTeste");
                Operations.compactaTexto(TextoParaComp,caminho);
                JOptionPane.showMessageDialog(this, "O arquivo está salvo na pasta 'data' contida na pasta do projeto !!!!");

            } catch (Exception ex) {}
        }
        if (e.getSource() == DescButton){
            TextoDescField.setBounds(150, 400, 700, 250);
            container.add(TextoDescField);
        }
    }
}
