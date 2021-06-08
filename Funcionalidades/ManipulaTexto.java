package Funcionalidades;

import dados.dataList.NoList;
import dados.dataTree.Nodo;
import TAD.LE;

public class ManipulaTexto {
    String texto = "";
    String binarioAtual = "";


    public String getBinarioAtual() {
        return binarioAtual;
    }

    public void setBinarioAtual(String binarioAtual) {
        this.binarioAtual = binarioAtual;
    }

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
                // System.out.println("A letra " + auxTexto.charAt(i) + " aparece " + cont + "
                // vezes.");
                String valor = cont + "ϡ," + auxTexto.charAt(i);
                // System.out.println(i);
                passados[i] = cont + "ϡ," + auxTexto.charAt(i);

            }
            cont = 0;
        }
        String[] retornar = new String[cont2];
        cont = 0;
        for (String i : passados) {
            if (i != null) {
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
                if (adicionar[j] != null) {
                    // System.out.println(adicionar[j]);
                    if (Integer.parseInt(textos[i].split("ϡ,")[0]) <= Integer.parseInt(adicionar[j].split("ϡ,")[0])) {
                        adicionar[cont] = textos[i];
                        // System.out.println("ADICIONOU O ANT");
                        cont++;
                    }

                }

            }
        }
        return adicionar;
    }

    public LE arrayToList(String[] textos) {
        LE lista = new LE();
        int frequencia;
        char letra;
        for (String i : textos) {
            frequencia = Integer.parseInt(i.split("ϡ,")[0]);
            letra = i.split("ϡ,")[1].charAt(0);
            Nodo noPassar = new Nodo(frequencia, letra);
            NoList No = new NoList(noPassar);
            lista.inserirLogica(No);
        }
        return lista;
    }

    public NoList menorNumero(LE lista) {
        int menorInt = Integer.parseInt(lista.getInicioDaLista().getNoTree().getFrequencia().getDadoFrequencia());
        NoList atual = lista.getInicioDaLista();
        NoList retornar = null;
        // String menor = "";
        // String atual;

        while (atual != null) {
            int numAtual = Integer.parseInt(atual.getNoTree().getFrequencia().getDadoFrequencia());
            if (numAtual <= menorInt && atual != retornar) {
                menorInt = numAtual;
                retornar = atual;
            }
            atual = atual.getProximo();

        }
        atual = lista.getInicioDaLista();
        while (atual != null) {
            int numAtual = Integer.parseInt(atual.getNoTree().getFrequencia().getDadoFrequencia());
            if(numAtual == Integer.parseInt(retornar.getNoTree().getFrequencia().getDadoFrequencia())  ){
                System.out.println("RETORNAR = "+ atual.getNoTree().getFrequencia().getDadoLetra()  );
                retornar = atual;
                break;
            }
            atual = atual.getProximo();
        }
        return retornar;

    }

    public NoList[] doisMenores(LE lista) {
        NoList[] retornar = new NoList[2];
        NoList menor1 = lista.removerNo(menorNumero(lista));
        // System.out.println("Retirou "+menor1.getNoTree().getFrequencia().getDadoLetra()    );
        NoList menor2 = lista.removerNo(menorNumero(lista));
        // System.out.println("Retirou "+menor2.getNoTree().getFrequencia().getDadoLetra()    );
        retornar[0] = menor1;
        retornar[1] = menor2;

        return retornar;
    }

    public NoList adicionaPai(NoList[] valores) {
        // Pegando os dados dos nós que forame excluídos
        NoList no1 = valores[0];
        NoList no2 = valores[1];
        // Frequencia de cada um
        int frequenciaNo1 = Integer.parseInt(no1.getNoTree().getFrequencia().getDadoFrequencia());
        int frequenciaNo2 = Integer.parseInt(no2.getNoTree().getFrequencia().getDadoFrequencia());
        // Frequencia do pai é a soma dos filhos
        int frequenciaPai = frequenciaNo1 + frequenciaNo2;
        char charPai = 'ϡ';
        // pai ta on
        Nodo paiManda = new Nodo(frequenciaPai, charPai);
        NoList pai = new NoList(paiManda);
        // Qual filho vai pra qual lado?
        if( frequenciaNo1 <= frequenciaNo2 ) {
            pai.getNoTree().getFrequencia().setFE(no1.getNoTree().getFrequencia());
            pai.getNoTree().getFrequencia().setFD(no2.getNoTree().getFrequencia());
        } else {
            pai.getNoTree().getFrequencia().setFE(no2.getNoTree().getFrequencia());
            pai.getNoTree().getFrequencia().setFD(no1.getNoTree().getFrequencia());
        }

        return pai;
    }

    
    /* public String[] criaBinarios( String[] arrayFrequencia, LE listaEncadeada ) {

        
        return arrayFrequencia;
    } */
    

    public void criaNos(String[] array) {
        for (int i = 0; i < array.length; i++) {
            Nodo novoDado = new Nodo();
        }
    }

} // Fim classe
