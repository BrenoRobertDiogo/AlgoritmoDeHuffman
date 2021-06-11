import Funcionalidades.ManipulaTexto;
import Funcionalidades.Operations;
import TAD.*;
import dados.dataList.*;
import dados.dataTree.*;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Principal {
    public static void main(String[] args) throws Exception {

        String texto2 = "Ana ama sua nana, sua mana e banana";
        String texto = "AAAAAABBBBBCCCCDDDEEF";
        ManipulaTexto manipulaTexto = new ManipulaTexto(texto);
        String[] arrayFrequencia = manipulaTexto.frequencia();
        LE listaEncadeada = manipulaTexto.arrayToList(arrayFrequencia);

        System.out.println(
                "=================================================\n"+
                "          Caracteres e suas frequências"+
                "\n================================================="
                );

        System.out.println(listaEncadeada.toString());
        NoList pai = Operations.criaArvore(listaEncadeada, manipulaTexto);

        // NoList paiAtual = ois.readObject();
        // Operations.writeObject(pai);

        // NoList noPaiAtual = (NoList) Operations.ler("NoSalvo\\object.dat");
        System.out.println(
                "=================================================\n"+
                "                     ARVORE\n"+
                "================================================="
                );
        // Nodo.toString(noPaiAtual.getNoTree().getFrequencia());
        String path = "NoSalvo\\test.txt";
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        Operations.binarioLetra(pai.getNoTree().getFrequencia(), 2, "", buffWrite);
        buffWrite.close();
        String anaBanana = "1001010111110111001011010011100011011011110111100110011100011010010111011100000001111011110111";
        String binari2 = "000000000000000000001001001001001010010010010011011011100100101";
        String binario = "101010101010010101010100000000110110110111111111110";
        
        System.out.print("\nFrase: "+texto);

        System.out.print("\nCompactado: ");
        Operations.compactaTexto(texto, path);
        
        System.out.print("\nDescompactado: ");
        Operations.descompactaTexto(binario, path);

        // Printando o array

    } // Final func main
} // Final classe main
