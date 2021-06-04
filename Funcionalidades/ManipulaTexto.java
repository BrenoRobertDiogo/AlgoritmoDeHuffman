package Funcionalidades;
import dados.Nodo;

import java.util.stream.IntStream;

public class ManipulaTexto {
    String texto = "";

    public ManipulaTexto(String texto) {
        this.texto = texto;
    }

    public String[] frequencia() {
        String auxTexto = this.texto;
        String[] passados = new String[93];

        int cont = 0, cont2 = 0;
        String v = "";
        for (int i = 0; i < auxTexto.length(); i++) {
            for (int j = 0; j < auxTexto.length(); j++) {
                if (auxTexto.charAt(i) == auxTexto.charAt(j)) {
                    cont++;
                }
            }
            // ao imprimir as frequências, exclui a contagem dos espaços
            char c = auxTexto.charAt(i);
            if (c >= ' ' && c <= '~' && !v.contains("" + c)) {
                cont2++;
                v = v + c;
                // System.out.println("A letra " + auxTexto.charAt(i) + " aparece " + cont + " vezes.");
                String valor = auxTexto.charAt(i) + "ϡ," + cont;
                // System.out.println(i);
                passados[i] = auxTexto.charAt(i) + "ϡ," + cont;

            }
            cont = 0;
        }
        String[] retornar = new String[cont2];
        cont = 0;
        for (String i : passados) {
            if(i!=null){
                retornar[cont] = i;
                cont++;
            }
        }
        return retornar;

    } // Fim frequencia

    public void criaNos( String[] array ) {
        for (int i = 0; i < array.length; i++) {
            Nodo novoDado = new Nodo();
        }
    }

} // Fim classe
