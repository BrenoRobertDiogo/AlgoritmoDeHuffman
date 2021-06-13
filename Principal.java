import Funcionalidades.Operations;
import Funcionalidades.interfaceArq;
import javax.swing.*;
public class Principal {
    public static void main(String[] args) throws Exception {
         interfaceArq frame = new interfaceArq();
         frame.setTitle("Mexericas Compactors");
         frame.setVisible(true);
         frame.setBounds(10,10,1000,1000);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);

        // // String texto2 = "Ana ama sua nana, sua mana e banana";
        // String TextoParaComp;
        // String path = "";

        // StringBuilder mensagem = new StringBuilder();
        // UIManager.put("OptionPane.minimumSize", new Dimension(500, 600));

        // TextoParaComp = JOptionPane.showInputDialog("Digite o texto que deseja compactar:");
        // String Arqv = JOptionPane.showInputDialog("Digite o nome do arquivo para salvar:");
        // try {
        //     path = Operations.ExcutaBinario(TextoParaComp,Arqv);
        // } catch (Exception e) {
        // }
        // mensagem.append("Texto Compactado:"+Operations.compactaTexto(TextoParaComp,path)).append("\nTexto não compactado:"+
        // TextoParaComp);
        // JOptionPane.showMessageDialog(null, mensagem);


        // String texto = "AAAAAABBBBBCCCCDDDEEF";
        // ManipulaTexto manipulaTexto = new ManipulaTexto(texto);
        // String[] arrayFrequencia = manipulaTexto.frequencia();
        // LE listaEncadeada = manipulaTexto.arrayToList(arrayFrequencia);

        // System.out.println(
        //         "=================================================\n"+
        //         "          Caracteres e suas frequências"+
        //         "\n================================================="
        //         );

        // System.out.println(listaEncadeada.toString());
        // NoList pai = Operations.criaArvore(listaEncadeada, manipulaTexto);

        // System.out.println(
        //         "=================================================\n"+
        //         "                     ARVORE\n"+
        //         "================================================="
        //         );
        // Nodo.toString(pai.getNoTree().getFrequencia());
        // String path = "NoSalvo\\test.txt";
        // BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        // Operations.binarioLetra(pai.getNoTree().getFrequencia(), 2, "", buffWrite);
        // buffWrite.close();
        // // String anaBanana = "1001010111110111001011010011100011011011110111100110011100011010010111011100000001111011110111";
        // String binario = "101010101010010101010100000000110110110111111111110";
        
        // System.out.print("\nFrase: "+texto);

        // System.out.print("\nCompactado: ");
        // Operations.compactaTexto(texto, path);
        
        // System.out.print("\nDescompactado: ");
        // Operations.descompactaTexto(binario, path);

        // Printando o array

    } // Final func main
} // Final classe main
