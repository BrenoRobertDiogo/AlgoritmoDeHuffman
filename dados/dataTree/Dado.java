package dados.dataTree;
public class Dado{
    
    private int frequencia;
    private char letra;

    /* ====================================
                Getters e setters
       ====================================*/
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }


    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    /* ====================================
                CONSTRUTOR
       ====================================*/

    public Dado(int frequencia, char letra){ 
        this.frequencia = frequencia;
        this.letra = letra;
    }

}
