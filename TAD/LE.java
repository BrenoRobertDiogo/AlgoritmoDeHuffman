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
        return quantidadeDeNos == 0;

    }

    // Método para inserir um nó na lista
    public boolean inserir(Nodo noTree, int p) { // p = posição

        // Se posição negativa ou maior que a quantidade de nós
        if ((p < 0) || (p > quantidadeDeNos)) {

            return false; // Quer dizer que não será possível inserir dados.

        } else {
            NoList novoNo = new NoList(noTree);

            // Caso 1: Lista está vazia.
            if (isEmpty()) {

                // Registra null como próxima referência.
                novoNo.setProximo(null);

                // Diz para descritor quem é o 1º e último nó da lista.
                inicioDaLista = novoNo;
                finalDaLista = novoNo;

            } else {

                // Caso 2: posição = 0
                if (p == 0) {
                    novoNo.setProximo(inicioDaLista);

                    // Registra o novoNo como 1º nó da lista.
                    inicioDaLista = novoNo;

                } else {

                    // Caso 3: posição = ultima posição válida
                    if (p == quantidadeDeNos) {

                        // Registra null como próxima referência.
                        novoNo.setProximo(null);

                        // O último nó da lista a partir deste momento
                        // tem o endereço do novoNo.
                        // finalDaLista.getProximo().setProximo(novoNo); <--- Fiz esse erro.
                        finalDaLista.setProximo(novoNo); // <--- Código correto.

                        // Registra o novoNo como último nó da lista.
                        finalDaLista = novoNo;

                    } else {

                        // Caso 4: Inserir entre as posições 0 e quantidadeDeNos.

                        // Atributo responsável por percorrer a lista.
                        // Começa apontando para o 1º nó da lista.
                        NoList referenciaAtual = inicioDaLista;

                        // Necessário percorrer da 1ª posição até uma posição
                        // antes da que realmente quer inserir.
                        // Para avançar para o próximo nó, necessário acessar
                        // o campo próximo.
                        for (int i = 0; i < (p - 1); i++) {
                            referenciaAtual = referenciaAtual.getProximo();
                        }

                        // Registra o endereço do nó que está na posição 'p'
                        // no campo próximo do novoNo.
                        novoNo.setProximo(referenciaAtual.getProximo());

                        // O nó anterior ao novoNo registra o endereço do mesmo.
                        referenciaAtual.setProximo(novoNo);

                    }

                }

            }

            // Atualiza a quantidade de nós da lista.
            quantidadeDeNos = quantidadeDeNos + 1;

            return true;

        }

    }


    public void inserir(int frequencia, char letra){
        Nodo noPassar = new Nodo(frequencia, letra);
        NoList No = new NoList(noPassar);
        if(isEmpty()){
            inicioDaLista = No;
        }
        else{
            finalDaLista.setProximo(No);
        }
        finalDaLista = No;
        // System.out.print(finalDaLista.getNoTree().getFrequencia().getDadoFrequencia()+", ");
        // System.out.println(finalDaLista.getNoTree().getFrequencia().getDadoLetra());
        quantidadeDeNos++;

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
                // relatorio += "\n[ " + referenciaAuxiliar.getNoTree().getFrequencia() + " -> ";
                // Avança para o próximo nó.
                referenciaAuxiliar = referenciaAuxiliar.getProximo();

            }

        }

        // Retorna a string vazia ou com dados.
        return relatorio;

    }

}
