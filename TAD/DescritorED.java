package TAD;

public class DescritorED {

    /*-----------------------------------
              ATRIBUTOS DA CLASSE
      -----------------------------------*/

    private int quantidadeDeNos;

    private No inicioDaLista;
    private No finalDaLista;

    /*-----------------------------------
             CONSTRUTOR DA CLASSE
      -----------------------------------*/

    public DescritorED(){

        /*inicioDaLista = null;
        quantidadeDeNos = 0;
        finalDaLista = null;*/

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
    private void inicializarLista(){
        inicioDaLista = null;
        quantidadeDeNos = 0;
        finalDaLista = null;
    }

    // Método para apagar a lista encadeada.
    public void apagarLista(){
        
        // Se a lista não estiver vazia, inicializa os valores!
        if ( !isEmpty() )
            inicializarLista();
        
    }

    // Método para verificar se a lista está vazia.
    public boolean isEmpty(){
        return quantidadeDeNos == 0;

    }

    // Método para inserir um nó na lista
    public boolean inserir(int codigo, String nome, int p){
        
        // Se posição negativa ou maior que a quantidade de nós
        if ( (p < 0) || (p > quantidadeDeNos) ){
            
            return false; // Quer dizer que não será possível inserir dados.
        
        }else{

            // Cria-se uma instância da classe 'No'.
            No novoNo = new No(codigo, nome);

            // Caso 1: Lista está vazia.
            if ( isEmpty() ){

                // Registra null como próxima referência.
                novoNo.setReferencia(null);

                // Diz para  descritor quem é o 1º e último nó da lista.
                inicioDaLista = novoNo;
                finalDaLista = novoNo;
                
            }else{

                // Caso 2: posição = 0
                if (p == 0){

                    // O endereço do 1º nó da lista é copiado para
                    // o campo próximo do novoNo.
                    novoNo.setReferencia(inicioDaLista);

                    // Registra o novoNo como 1º nó da lista.
                    inicioDaLista = novoNo;
                    
                }else{

                     // Caso 3: posição = ultima posição válida
                    if (p == quantidadeDeNos){
                        
                        // Registra null como próxima referência.
                        novoNo.setReferencia(null);

                        // O último nó da lista a partir deste momento
                        // tem o endereço do novoNo.
                        //finalDaLista.getReferencia().setReferencia(novoNo); <--- Fiz esse erro.
                        finalDaLista.setReferencia(novoNo); // <--- Código correto.

                        // Registra o novoNo como último nó da lista.
                        finalDaLista = novoNo;
                        
                    }else{

                        // Caso 4: Inserir entre as posições 0 e quantidadeDeNos.

                        // Atributo responsável por percorrer a lista.
                        // Começa apontando para o 1º nó da lista.
                        No referenciaAtual = inicioDaLista;

                        // Necessário percorrer da 1ª posição até uma posição
                        // antes da que realmente quer inserir.
                        // Para avançar para o próximo nó, necessário acessar
                        // o campo próximo.
                        for (int i = 0; i < (p-1); i++){
                            referenciaAtual = referenciaAtual.getReferencia();    
                        }

                        // Registra o endereço do nó que está na posição 'p'
                        // no campo próximo do novoNo.
                        novoNo.setReferencia(referenciaAtual.getReferencia());

                        // O nó anterior ao novoNo registra o endereço do mesmo.
                        referenciaAtual.setReferencia(novoNo);
                        
                    }

                }

            }

            // Atualiza a quantidade de nós da lista.
            quantidadeDeNos = quantidadeDeNos + 1;

            return true;

        }

    }

    // Método para remover um nó da lista
    public boolean remover(int p){

        // Se a lista estiver vazia ou
        // Se posição negativa ou
        // Se posição maior ou igual a quantidade de nós

        if ( isEmpty() ||  (p < 0) || (p >= quantidadeDeNos)){

            return false; // Não é possível remover nós da lista.

        }else{

            // Caso 1: existe apenas 1 elemento.
            if (quantidadeDeNos == 1){

                inicializarLista(); // Inicializa os valores do descritor da lista.

            }else{

                // Atributo responsável por percorrer a lista encadeada.
                // 'referenciaAtual' recebe uma cópia do endereço do nó
                // que está na 1ª posição da lista.
                No referenciaAtual = inicioDaLista;;

                // Caso 2: posição == 0
                if (p == 0){
                    
                    // Registro o início da lista como sendo o 2º nó da lista.
                    inicioDaLista.setReferencia(referenciaAtual.getReferencia());

                    // O nó a ser excluído, não terá mais acesso a outro nó.
                    referenciaAtual.setReferencia(null);

                }else{

                    // Sentinela usado para percorrer até a posição desejada.
                    int i = 0;

                    // Enquanto não chegar na posição anterior a que se
                    // quer remover o nó, vai percorrendo a lista.
                    while( i < (p-1) ){
                        referenciaAtual = referenciaAtual.getReferencia();
                        i++;
                    }

                    // Quando chegar na posição desejada, verificar se caso:
                    // 3 ou 4.
                    
                    // Caso 3: remover o nó que está na última posição da lista.
                    if (p == (quantidadeDeNos - 1)){

                        // Diz que o nó atual não terá mais acesso ao endereço
                        // do último nó da lista.
                        referenciaAtual.setReferencia(null);

                        // O último nó da lista passa a ser
                        // o nó anterior ao que foi removido.
                        finalDaLista.setReferencia(referenciaAtual);
                        
                    }else{

                        // Caso 4: remover quem está entre 0 e p.

                        // Copia o endereço do nó a ser removido.
                        No proximaReferencia = referenciaAtual.getReferencia();

                        // Registra o endereço do nó posterior ao nó a
                        // ser removido como endereço do nó atual (nó anterior
                        // ao que será removido.
                        referenciaAtual.setReferencia(proximaReferencia.getReferencia());

                        // O nó a ser removido não tem mais acesso ao 
                        // endereço do próximo nó.
                        proximaReferencia.setReferencia(null);

                    }

                }

            }

            // Atualiza a quantidade de nós da lista.
            quantidadeDeNos = quantidadeDeNos - 1;

            return true;

        }

    }

    /*
    // Método para pesquisar um determinado registro através
    // de uma chave (na aplicação, essa chave será o código).
    public int pesquisarElemento(int codigo){
        
        
        
    }
    */

    /*
     Método para alterar dados de um nó da lista.
       
       A forma de alteração poderá ser:
       1 - Acessando uma determinada posição, ou
       2 - Pesquisando pela chave (código).
    
       Sugere-se que o método pesquisarElemento() seja utilizado.
    
    public boolean alterarDados(int codigoAntigo, int novoCodigo, String novoNome){
        
        
        
    }
    */
    
    // Método para imprimir a lista encadeada (relatório dos dados dos usuáios)
    public String relatorio(){
        
        // Atributo responsável por armazenar os dados dos usuários.
        // presentes na lista.
        String relatorio = "";
        
        // Se a lista não estiver vazia, que dizer que existe pelo menos 1 nó na lista.
        if ( !isEmpty() ){
            
            // Atributo para percorrer a lista encadeada.
            No referenciaAuxiliar = inicioDaLista;
            
            // Enquanto não chegar no final da lista.
            while ( referenciaAuxiliar != null ){
                
                // Vai resgatando os valores do nó (dados do usuário) e já vai
                // formatando a string de retorno.
                relatorio = relatorio + "\n[ " + referenciaAuxiliar.getDado().getCodigoUsuario() + " -> ";
                relatorio = relatorio + referenciaAuxiliar.getDado().getNomeUsuario() + " ]";
                
                // Avança para  o próximo nó.
                referenciaAuxiliar = referenciaAuxiliar.getReferencia();
                
            }
                      
        }
       
        // Retorna a string vazia ou com dados.
        return relatorio;
        
    }

    /*
    // Método para unir 2 ou + listas encadeadas
    public void unirListas( ? ){
        
        
    
    }
    */
    
    /*
    // Método para dividir uma lista encadeada
    public void dividirLista( ? ){
        
        
    
    }
    */

}
