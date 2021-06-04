package TAD;
/**
 *
 * @author Jefferson
 */
public class Usuario{

    /*-----------------------------------
              ATRIBUTOS DA CLASSE
      -----------------------------------*/
    
    private int codigoUsuario;
    private String nomeUsuario;

    /*-----------------------------------
             CONSTRUTORES DA CLASSE
      -----------------------------------*/

    public Usuario(int codigoUsuario, String nomeUsuario){
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
    }

    /*-----------------------------------
            MÉTODOS get | set DA CLASSE
      -----------------------------------*/

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String toString(){

        return " [ Código: " + codigoUsuario + " | " + "Nome: " +  nomeUsuario + " ]\n";

    }
    
}