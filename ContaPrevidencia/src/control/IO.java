package control;

import java.util.ArrayList;
import java.util.List;
import view.ViewGUI;
//leitura
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//escrita
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class IO {

	ViewGUI gui = new ViewGUI();
	
	public List<String> lerVotos(String arquivo){
		List<String> listaVotos = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String linhaAtual;

			while ((linhaAtual = br.readLine()) != null) {
				String[] partes = linhaAtual.split(";");
				String voto = partes[1];
				
				listaVotos.add(voto);
			}

		} catch (IOException e) {
			gui.exibeMsg("Ocorreu um erro durante a leitura do arquivo " + arquivo);
		}

		return listaVotos;
	}
	
	public void escreverContagem(String conteudo, String arquivo) throws FileNotFoundException{		
			
		try{
			PrintWriter pw = new PrintWriter(new File(arquivo));
        	StringBuilder sb = new StringBuilder();
        
        	sb.append(conteudo);

        	pw.write(sb.toString());
        	pw.close();
		}
		catch (Exception e) {
			gui.exibeMsg("Erro ao escrever o arquivo " + arquivo);
		}
	}
	
	public void deletarArquivo(String nome){
		File arqAnterior = new File(nome);
		boolean existe = arqAnterior.exists();
		
		if(existe){
			arqAnterior.delete();
		}
	}
	
	public void verificarArquivo(String nome){
		File arquivo = new File(nome);
		boolean existe = arquivo.exists();
		
		if(!existe){
			gui.exibeMsg("Arquivo de entrada " + nome + " não encontrado");
			System.exit(0);
		}
	}
}
