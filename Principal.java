import Funcionalidades.ManipulaTexto;
import java.util.Arrays;
import TAD.*;
import dados.dataList.*;
import dados.dataTree.*;

public class Principal {
    public static void main(String[] args) throws Exception {

        String texto = "Ana ama sua nana, sua mana e banana";
        String texto2 = "asdinmaiscniasci123151232149102301285asicmaisidnsa";
        ManipulaTexto manipulaTexto = new ManipulaTexto(texto);
        int cont = 0;
        String[] arrayFrequencia = manipulaTexto.frequencia();

        for (String string : arrayFrequencia) {
            System.out.println(string);
        }
        LE listaEncadeada = manipulaTexto.arrayToList(arrayFrequencia);
        // System.out.println(listaEncadeada.toString());
        // NoList menor = manipulaTexto.menorNumero(listaEncadeada);
        // System.out.println(menor.getNoTree().getFrequencia().getDadoFrequencia()+": "+menor.getNoTree().getFrequencia().getDadoLetra() );
        int temp;
        char letra;
        System.out.println(
                "=================================================\n=================================================");

        
                // System.out.println(listaEncadeada.toString());
        // NoList removido = listaEncadeada.removerNo(menor);

        // NoList[] doisMenores = manipulaTexto.doisMenores(listaEncadeada);

        // System.out.println(listaEncadeada.toString());

        // NoList pai = manipulaTexto.adicionaPai(doisMenores);
        
        /* System.out.println("FILHOS DE UM PAI????????");
        System.out.println(pai.getNoTree().getFrequencia().getFD().getDadoLetra());
        System.out.println(pai.getNoTree().getFrequencia().getFE().getDadoLetra());
        
        listaEncadeada.inserir(pai); */
        System.out.println(listaEncadeada.toString());
        NoList[] baiocco2;
        int tamanhoLE = listaEncadeada.getQuantidadeDeNos()-1;
        NoList pai = null;

        for (int i = 0; i < tamanhoLE; i++) {
            // System.out.println(listaEncadeada.toString());
            baiocco2 = manipulaTexto.doisMenores(listaEncadeada);
            pai = manipulaTexto.adicionaPai(baiocco2);
            listaEncadeada.inserirLogica(pai);
        }

        /* for (String string : arrayFrequencia) {
            pai.getNoTree().getFrequencia().binarioLetra(pai.getNoTree().getFrequencia(), "", string.split("ϡ,")[1].charAt(0), manipulaTexto);
            
        } */
        System.out.println(listaEncadeada.toString());
        
        Nodo.toString(pai.getNoTree().getFrequencia());
        System.out.println("");
        Nodo.binarioLetra2(pai.getNoTree().getFrequencia(), 2, "");


        // System.out.println(retornadoNessaMerda);

        // System.out.println(manipulaTexto.frequencia()[0]);
        // System.out.println(manipulaTexto.menorNumero(manipulaTexto.frequencia()));

        for (String i : arrayFrequencia) {
            temp = Integer.parseInt(i.split("ϡ,")[0]);
            letra = i.split("ϡ,")[1].charAt(0);
            listaEncadeada.inserir(temp, letra);
        }

    } // Final func main
} // Final classe main
