package Funcionalidades;
import dados.dataTree.Nodo;

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
                String valor = cont + "ϡ," + auxTexto.charAt(i);
                // System.out.println(i);
                passados[i] = cont + "ϡ," + auxTexto.charAt(i);

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

    public String[] emOrdem(String[] textos) {
        
        String[] adicionar = new String[textos.length];
        int cont;
        adicionar[0] = textos[0];
        for (int i = 1; i < textos.length; i++) {
            cont = 0;
            // System.out.println(textos[i]);
            for (int j = 0; j < adicionar.length; j++) {
                if(adicionar[j] != null){
                    System.out.println(adicionar[j]);
                    if(  Integer.parseInt(textos[i].split("ϡ,")[0]) <= Integer.parseInt(adicionar[j].split("ϡ,")[0]) ){
                        adicionar[cont] = textos[i];
                        System.out.println("ADICIONOU O ANT");
                        cont++;
                    }

                }
                
            }
        }
        return adicionar;
    }

    public String menorNumero(String[] textos) {
        int menorInt = Integer.parseInt(textos[0].split("ϡ,")[0]);
        String menor = "";
        String atual;
        for (int i = 0; i < textos.length; i++) {
            int atualInt = Integer.parseInt(textos[i].split("ϡ,")[0]);
            atual = textos[i];
            if(atualInt <= menorInt) {
                menorInt = atualInt;
                menor = textos[i];
                System.out.println(menorInt);
                
            }
        }
        return menor;
    }

    public String adicionaOrdem() {

    }
    
    public void criaNos( String[] array ) {
        for (int i = 0; i < array.length; i++) {
            Nodo novoDado = new Nodo();
        }
    }

} // Fim classe
