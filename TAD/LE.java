package TAD;

import dados.dataTree.Nodo;

import dados.dataList.*;

public class LE {

    /*-----------------------------------
              ATRIBUTOS DA CLASSE
      -----------------------------------*/

    private int quantidadeDeNos;

    private NoList inicioDaLista;

    private NoList finalDaLista;

    /*-----------------------------------
             GETTER E SETTER
    -----------------------------------*/
    public NoList getInicioDaLista() {
        return inicioDaLista;
    }

    public void setInicioDaLista(NoList inicioDaLista) {
        this.inicioDaLista = inicioDaLista;
    }

    /*-----------------------------------
             CONSTRUTOR DA CLASSE
      -----------------------------------*/

    public LE() {

        /*
         * inicioDaLista = null; quantidadeDeNos = 0; finalDaLista = null;
         */

        inicializarLista();

    }

    /*-----------------------------------
            MÉTODOS get | set DA CLASSE
      -----------------------------------*/

    public int getQuantidadeDeNos() {
        return quantidadeDeNos;
    }

    /*-----------------------------------
                OEPRAÇÕES DA LSE
      -----------------------------------*/

    // inicializar a lista
    private void inicializarLista() {
        inicioDaLista = null;
        quantidadeDeNos = 0;
        finalDaLista = null;
    }

    // Método para apagar a lista encadeada.
    public void apagarLista() {

        // Se a lista não estiver vazia, inicializa os valores!
        if (!isEmpty())
            inicializarLista();

    }

    // Método para verificar se a lista está vazia.
    public boolean isEmpty() {
        return quantidadeDeNos == 0 || inicioDaLista == null;

    }

    public void inserir(int frequencia, char letra) {
        Nodo noPassar = new Nodo(frequencia, letra);
        NoList No = new NoList(noPassar);
        if (isEmpty()) {
            inicioDaLista = No;
        } else {
            finalDaLista.setProximo(No);
        }
        finalDaLista = No;
        quantidadeDeNos++;

    }

    public void inserir(NoList insercao) {
        if (isEmpty()) {
            inicioDaLista = insercao;
        } else {
            // adicionando no final
            finalDaLista.setProximo(insercao);
            // insercao.setProximo(inicioDaLista);
        }
        finalDaLista = insercao;
        quantidadeDeNos++;

    }

    public void inserirLogica(NoList insercao) {
        NoList ant = inicioDaLista, atual = inicioDaLista; // Numeros de frequencia do nó atual e de inserção
        int dadoFrequenciaInsercao = Integer.parseInt(insercao.getNoTree().getFrequencia().getDadoFrequencia()),
        dadoFrequenciaAtual = 0;
        
        if (isEmpty() || inicioDaLista == null) {
            this.inicioDaLista = insercao;
            this.finalDaLista = insercao;
            quantidadeDeNos++;
            return;
        }
        do {
            if (ant.getProximo() == null || ant.getProximo() == finalDaLista) { // Caso não tenha um número menor, chegou no final da lista
                insercao.setProximo(null);
                finalDaLista.setProximo(insercao);
                this.finalDaLista = insercao;
                // inserir(insercao);
                break;
            }

            dadoFrequenciaAtual = Integer.parseInt(atual.getNoTree().getFrequencia().getDadoFrequencia());

            if (dadoFrequenciaInsercao < dadoFrequenciaAtual) {
                if (atual == inicioDaLista) {
                    insercao.setProximo(inicioDaLista);
                    inicioDaLista = insercao;
                    break;
                }
                /*
                 * ant.setProximo(insercao); insercao.setProximo(atual);
                 */
                // Caso esteja no final da lista

                ant.setProximo(insercao);
                insercao.setProximo(atual);

                /*
                 * insercao.setProximo(null); finalDaLista.setProximo(insercao);
                 * this.finalDaLista = insercao;
                 */
                break;

            } // final if
            ant = atual;
            atual = atual.getProximo();
        } while (ant.getProximo() != null && atual != insercao); // Final while
        quantidadeDeNos++;
    }

    public NoList removerNo(NoList noRemover) {
        NoList atual = inicioDaLista;
        NoList ant = null;

        if (isEmpty()) {
            return null;
        }

        while (atual.getProximo() != null && atual != noRemover) {
            ant = atual;
            atual = atual.getProximo();
        }

        if (atual == inicioDaLista) {
            if (inicioDaLista == finalDaLista) {
                this.finalDaLista = null;
            }
            this.inicioDaLista = inicioDaLista.getProximo();
        } else {
            if (atual == this.finalDaLista) {
                finalDaLista = ant;
            }
            ant.setProximo(atual.getProximo());
        }
        quantidadeDeNos--;

        return noRemover;
    }



    @Override
    public String toString() {
        NoList atual = inicioDaLista;
        String mandar = "";
        while (atual != null) {
            mandar += "Char [" + atual.getNoTree().getFrequencia().getDadoLetra() + "] aparece ";
            mandar += atual.getNoTree().getFrequencia().getDadoFrequencia() + " vezes\n";
            atual = atual.getProximo();
        }
        return mandar;
    }


}
