import Funcionalidades.ManipulaTexto;
import java.util.Arrays;
import TAD.*;

public class Principal {
    public static void main(String[] args) throws Exception {

        /*
         * AB ab = new AB();
         * 
         * System.out.println(ab.inserir(50)); System.out.println(ab.inserir(40));
         * System.out.println(ab.inserir(60)); System.out.println(ab.inserir(20));
         * System.out.println(ab.inserir(45)); System.out.println(ab.inserir(70));
         * System.out.println(ab.inserir(5)); System.out.println(ab.inserir(65));
         * System.out.println(ab.inserir(10)); System.out.println(ab.inserir(100));
         */

        String texto = "Ana ama sua nana, sua mana e banana.";
        ManipulaTexto a = new ManipulaTexto(texto);
        int cont = 0;
        String[] valor = a.frequencia();
        // Arrays.sort(valor);
        Arrays.sort(valor);

        LE listaEncadeada = new LE();
        int temp;
        char letra;
        System.out.println(
                "=================================================\n=================================================");
        // System.out.println(a.frequencia()[0]);
        System.out.println(a.menorNumero(a.frequencia()));



        for (String i : a.emOrdem(a.frequencia())) {
            // System.out.println(cont + ": " + i);
            cont++;
        } // Final for

        /* for (String i : valor) {
            temp = Integer.parseInt(i.split("ϡ,")[0]);
            letra = i.split("ϡ,")[1].charAt(0);
            listaEncadeada.inserir(temp, letra);

        } */

    } // Final func main
} // Final classe main
