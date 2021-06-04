package TAD;
import dados.*;

public class AB {
    
    // Descritor
    private Nodo raiz;
    private boolean adicionado;

    public AB(){
        raiz = null;
    }

    public boolean isEmpty(Nodo r){
        return r == null;
    }

    /* ====================================
                 MÉTODO INSERIR
       ==================================== */

    // Método que compara códigos.
    private int compara(Nodo r, int frequencia){

        // Se o código a ser inserido é menor que o
        // código registrado no nó atual, então retorna -1.
        if (frequencia < r.getObjeto().getFrequencia()){
            return -1; // à esquerda.
        }else{

            // Se o código a ser inserido é maior que o
            // código registrado no nó atual, então retorna +1.
            if (frequencia > r.getObjeto().getFrequencia())
                return 1; // à direita.
            
        }

        return 0;

    }

    private Nodo inserirP(Nodo r, int frequencia){

        // Se a raiz atual é 'null', então
        if (isEmpty(this.raiz)){

            // Cria um nó, insere os dados e faz a ligação com a raiz,
            // Ou seja, pega o endereço do nó criado e insere no
            // atributo _raiz "atual".
            r = new Nodo(frequencia); // Caso a raiz seja null, já cria o nó
            adicionado = true;
            
        }else{

            // Atributo que registra -1, 0 ou +1.
            int resultado = compara(r,frequencia);

             // Se _resultado = -1, quer dizer que a possível inserção do nó,
            // se dá à esquerda do nó atual.
            if (resultado < 0){
                r.setFE(inserirP(raiz, frequencia));
            }else{

                // Se _resultado = +1, quer dizer que a possível inserção do nó,
                // se dá à direita do nó atual.  
                if (resultado > 0)
                    r.setFD(inserirP(raiz, frequencia));
                else
                   adicionado = false;
                
            }

        }

        return r; // Retorna o endereço da 1ª raiz.

    }

    public boolean inserir(int frequencia){

        // Registra o último endereço retornado.
        raiz = inserirP(raiz, frequencia);
        return adicionado;

    }


}
