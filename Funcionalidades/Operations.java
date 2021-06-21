package Funcionalidades;

import TAD.LE;
import dados.dataTree.Nodo;

import dados.dataList.NoList;
import java.io.IOException;
import java.io.PrintWriter;
// Escrever objetos
import java.io.BufferedWriter;
import java.io.FileWriter;

// Ler objetos
import java.io.FileReader;
import java.io.BufferedReader;

public class Operations {

    private static NoList criaArvore(LE listaEncadeada, ManipulaTexto manipulaTexto) {

        NoList[] baiocco2;
        int tamanhoLE = listaEncadeada.getQuantidadeDeNos() - 1;
        NoList pai = null;

        for (int i = 0; i < tamanhoLE; i++) {
            // System.out.println(listaEncadeada.toString());
            baiocco2 = manipulaTexto.doisMenores(listaEncadeada);
            pai = manipulaTexto.adicionaPai(baiocco2);
            listaEncadeada.inserirLogica(pai);
        }
        return pai;
    }

    public static void printaArvore(String[] arrayFrequencia, LE listaEncadeada) {
        int temp;
        char letra;
        for (String i : arrayFrequencia) {
            temp = Integer.parseInt(i.split("ϡ,")[0]);
            letra = i.split("ϡ,")[1].charAt(0);
            listaEncadeada.inserir(temp, letra);
        }
    }

    private static void binarioLetra(Nodo r, int lado, String total, BufferedWriter buffWrite) {
        if (r != null) {
            String retornar = total;
            if (lado == 0) {
                retornar += "0";
            } else if (lado == 1) {
                retornar += "1";

            }
            if (r.isFolha()) {
                try {

                    buffWrite.append(retornar + "" + r.getDadoLetra() + "S2");
                } catch (Exception e) {
                }

            }
            binarioLetra(r.getFE(), 0, retornar, buffWrite);
            binarioLetra(r.getFD(), 1, retornar, buffWrite);
        }
    }

    private static String pegaCabecalho(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        String Cabecalho = "";
        while (true) {
            
            if (!linha.equals("")) {
                Cabecalho+=linha;
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
        return Cabecalho;
    }
    private static String pegaCabecalhoComp(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        buffRead.close();
        return linha;
    }

    private static int estaContido(String valor, String[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i].equals(valor)  ) {
                return i;
            }
        }
        return -1;
    }
    
    public static String descompactaTexto(String path) {
        String retorna = "";
        String linesFile = "";
        String texto = "";
        try {
            linesFile = pegaCabecalhoComp(path);
            texto = lerBinario(path);
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] cabecalho = linesFile.split("S2");
        String[] binarios = new String[cabecalho.length] ;
        char[] caracter = new char[cabecalho.length] ;

        for (int i = 0; i < cabecalho.length; i++) {
            binarios[i] = cabecalho[i].substring(0, cabecalho[i].length()-1);
            caracter[i] = cabecalho[i].charAt(cabecalho[i].length()-1);
        }
        

        String aux = "";
        for (int i = 0; i < texto.length() ; i++) {
            aux += texto.charAt(i)+""; 
            
            int numeroContido = estaContido(aux, binarios);
            
            if(numeroContido!=-1){
                retorna+=caracter[numeroContido];
                aux = "";
            }

        }
        return retorna;

    }

    public static String compactaTexto(String texto, String path) {
        String linesFile = "";
        String retorna = "";
        try {
            linesFile = pegaCabecalhoComp(path);

        } catch (IOException e) {
            System.out.println(e);
        }

        String[] cabecalho = linesFile.split("S2");
        String[] binarios = new String[cabecalho.length] ;
        char[] caracter = new char[cabecalho.length] ;
        for (int i = 0; i < cabecalho.length; i++) {
            binarios[i] = cabecalho[i].substring(0, cabecalho[i].length()-1);
            caracter[i] = cabecalho[i].charAt(cabecalho[i].length()-1);
        }

        for (int i = 0; i < texto.length(); i++) {
            for (int j = 0; j < caracter.length; j++) {
                String letraAtual = ""+texto.charAt(i);
                String binarioAtual = binarios[j];
                if(letraAtual.equals((caracter[j])+"")){
                    retorna += binarioAtual;
                    break;
                }
            }
        }
        return retorna;
    }

    

    public static String ExecutaBinario(String texto,String nomearq,String path) throws IOException{
        ManipulaTexto manipulaTexto = new ManipulaTexto(texto);
        String[] arrayFrequencia = manipulaTexto.frequencia(100);
        LE listaEncadeada = manipulaTexto.arrayToList(arrayFrequencia);
        NoList pai = criaArvore(listaEncadeada, manipulaTexto);

        BufferedWriter buffWrite;

        buffWrite = new BufferedWriter(new FileWriter(path+"\\"+nomearq+".mexirica"));
        Operations.binarioLetra(pai.getNoTree().getFrequencia(), 2, "", buffWrite);
        buffWrite.close();

        return path+"\\"+nomearq+".mexirica";
    }

    public static String ExecutaBinarioArq(String nomearq,String path,String pathM) throws IOException{
        String Texto = leitor(path);
        ManipulaTexto manipulaTexto = new ManipulaTexto(Texto);
        String[] arrayFrequencia = manipulaTexto.frequencia(100);
        LE listaEncadeada = manipulaTexto.arrayToList(arrayFrequencia);
        NoList pai = criaArvore(listaEncadeada, manipulaTexto);

        BufferedWriter buffWrite;

        buffWrite = new BufferedWriter(new FileWriter(pathM+"\\"+nomearq+".mexirica"));
        Operations.binarioLetra(pai.getNoTree().getFrequencia(), 2, "", buffWrite);
        buffWrite.close();

        return pathM+"\\"+nomearq+".mexirica";
    }

    public static String leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
        String Texto = "";
		while (true) {
			if (linha != null) {
				Texto += linha;

			} else
				break;
			linha = buffRead.readLine();
		}
        buffRead.close();
        return Texto;
		
	}

    public static String lerBinario(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();
        String Texto = "";

        linha = buffRead.readLine();
        Texto+= linha;
		buffRead.close();
        return Texto;
	}

    public static void escritorDesc(String path,String texto) throws IOException {
        try(FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            
            out.print("\n"+texto);
        }
         catch (IOException e){
            
        }
	}

    public static void escritorArq(String path,String texto, String nome) throws IOException {
        try(FileWriter fw = new FileWriter(path+"\\"+nome+".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            out.print(texto);
        }
         catch (IOException e){
            
        }
	}

}
