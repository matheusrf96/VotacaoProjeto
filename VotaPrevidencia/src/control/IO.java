package control;

import java.util.ArrayList;
import java.util.List;
import model.Voto;
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
	
	public List<String> lerArquivo(String arquivo) {
		List<String> listaItens = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				listaItens.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaItens;
	}
	
	public void escreverVotos(List<Voto> listaVotos, String arquivo) throws FileNotFoundException{		
			
		try{
			PrintWriter pw = new PrintWriter(new File(arquivo));
        	StringBuilder sb = new StringBuilder();
        
        	for(int i = 0; i < listaVotos.size(); i++){
        		sb.append(listaVotos.get(i).toString());
        	}

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
