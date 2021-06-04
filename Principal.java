import Funcionalidades.ManipulaTexto;
import TAD.AB;

public class Principal {
    public static void main(String[] args) throws Exception {

        /* AB ab = new AB();

        System.out.println(ab.inserir(50));
        System.out.println(ab.inserir(40));
        System.out.println(ab.inserir(60));
        System.out.println(ab.inserir(20));
        System.out.println(ab.inserir(45));
        System.out.println(ab.inserir(70));
        System.out.println(ab.inserir(5));
        System.out.println(ab.inserir(65));
        System.out.println(ab.inserir(10));
        System.out.println(ab.inserir(100)); */


        String texto = "Ana ama sua nana, sua mana e banana.";
        ManipulaTexto a = new ManipulaTexto(texto);
        int cont = 0;
        for (String i : a.frequencia()) {
            System.out.println(cont+": "+i);
            cont++;
        }
    }
}
