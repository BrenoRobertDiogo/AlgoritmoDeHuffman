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
        // System.out.print(finalDaLista.getNoTree().getFrequencia().getDadoFrequencia()+",
        // ");
        // System.out.println(finalDaLista.getNoTree().getFrequencia().getDadoLetra());
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
            System.out.println("ESTAVA VAZIOOOOOOOOOOOOOOOOOOOOOOOOOO");
            System.out.println("Inserindo char " + insercao.getNoTree().getFrequencia().getDadoLetra());
            this.inicioDaLista = insercao;
            this.finalDaLista = insercao;
            quantidadeDeNos++;
            return;
        }
        // System.out.println("Inicio da lista: "+
        // inicioDaLista.getNoTree().getFrequencia().getDadoLetra());
        System.out.println("Inserindo char " + insercao.getNoTree().getFrequencia().getDadoLetra() + " | "
                + insercao.getNoTree().getFrequencia().getDadoFrequencia());
        do {
            if (ant.getProximo() == null || ant.getProximo() == finalDaLista) { // Caso não tenha um número menor, chegou no final da lista
                System.out.println(atual.getNoTree().getFrequencia().getDadoLetra() + " ENTROU NO IFFFFFFF");
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

    // Método para remover um nó da lista
    public boolean remover(int p) {

        // Se a lista estiver vazia ou
        // Se posição negativa ou
        // Se posição maior ou igual a quantidade de nós

        if (isEmpty() || (p < 0) || (p >= quantidadeDeNos)) {

            return false; // Não é possível remover nós da lista.

        } else {

            // Caso 1: existe apenas 1 elemento.
            if (quantidadeDeNos == 1) {

                inicializarLista(); // Inicializa os valores do descritor da lista.

            } else {

                // Atributo responsável por percorrer a lista encadeada.
                // 'referenciaAtual' recebe uma cópia do endereço do nó
                // que está na 1ª posição da lista.
                NoList referenciaAtual = inicioDaLista;

                // Caso 2: posição == 0
                if (p == 0) {

                    // Registro o início da lista como sendo o 2º nó da lista.
                    inicioDaLista.setProximo(referenciaAtual.getProximo());

                    // O nó a ser excluído, não terá mais acesso a outro nó.
                    referenciaAtual.setProximo(null);

                } else {

                    // Sentinela usado para percorrer até a posição desejada.
                    int i = 0;

                    // Enquanto não chegar na posição anterior a que se
                    // quer remover o nó, vai percorrendo a lista.
                    while (i < (p - 1)) {
                        referenciaAtual = referenciaAtual.getProximo();
                        i++;
                    }

                    // Quando chegar na posição desejada, verificar se caso:
                    // 3 ou 4.

                    // Caso 3: remover o nó que está na última posição da lista.
                    if (p == (quantidadeDeNos - 1)) {

                        // Diz que o nó atual não terá mais acesso ao endereço
                        // do último nó da lista.
                        referenciaAtual.setProximo(null);

                        // O último nó da lista passa a ser
                        // o nó anterior ao que foi removido.
                        finalDaLista.setProximo(referenciaAtual);

                    } else {

                        // Caso 4: remover quem está entre 0 e p.

                        // Copia o endereço do nó a ser removido.
                        NoList proximaReferencia = referenciaAtual.getProximo();

                        // Registra o endereço do nó posterior ao nó a
                        // ser removido como endereço do nó atual (nó anterior
                        // ao que será removido.
                        referenciaAtual.setProximo(proximaReferencia.getProximo());

                        // O nó a ser removido não tem mais acesso ao
                        // endereço do próximo nó.
                        proximaReferencia.setProximo(null);

                    }

                }

            }

            // Atualiza a quantidade de nós da lista.
            quantidadeDeNos = quantidadeDeNos - 1;

            return true;

        }

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
        // System.out.println(mandar);
        return mandar;
    }

    // Método para imprimir a lista encadeada (relatório dos dados dos usuáios)
    public String relatorio() {

        // Atributo responsável por armazenar os dados dos usuários.
        // presentes na lista.
        String relatorio = "";

        // Se a lista não estiver vazia, que dizer que existe pelo menos 1 nó na lista.
        if (!isEmpty()) {

            // Atributo para percorrer a lista encadeada.
            NoList referenciaAuxiliar = inicioDaLista;

            // Enquanto não chegar no final da lista.
            while (referenciaAuxiliar != null) {

                // Vai resgatando os valores do nó (dados do usuário) e já vai
                // formatando a string de retorno.
                relatorio += "\n[ " + referenciaAuxiliar.getNoTree().getFrequencia() + " -> ";
                // relatorio += "\n[ " + referenciaAuxiliar.getNoTree().getFrequencia() + " ->
                // ";
                // Avança para o próximo nó.
                referenciaAuxiliar = referenciaAuxiliar.getProximo();

            }

        }

        // Retorna a string vazia ou com dados.
        return relatorio;

    }

}
