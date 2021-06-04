package TAD;
import dados.Dado;

public class No {

    private Usuario frequencia;
    private No proximo;

    public No(int frequencia, String nome){

        Usuario u = new Usuario(frequencia,nome);
        frequencia = u;
        
    }

    public Usuario getFrequencia() {
        return frequencia;
    }

    public No getReferencia() {
        return proximo;
    }

    public void setReferencia(No proximo) {
        this.proximo = proximo;
    }
    
}
