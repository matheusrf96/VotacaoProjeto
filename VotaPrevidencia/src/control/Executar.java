package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.Voto;
import view.ViewGUI;

public class Executar {
	public static final String ARQUIVO_VOTOS = "../Votos.csv";
	public static final String ARQUIVO_DEPUTADOS = "../Deputados.txt";		
	
	public static void main(String[] args) throws FileNotFoundException{
		ViewGUI gui = new ViewGUI();
		IO io = new IO();
		List<String> listaDeputados = new ArrayList<String>();
		List<Voto> listaVotos = new ArrayList<Voto>();
		
		io.deletarArquivo(ARQUIVO_VOTOS);
		io.verificarArquivo(ARQUIVO_DEPUTADOS);
		listaDeputados = io.lerArquivo(ARQUIVO_DEPUTADOS);
		
		for(int i = 0; i < listaDeputados.size(); i++){
			int opcao = gui.seletor(listaDeputados.get(i));
			String voto = "";
			
			if(opcao == 0)
				voto = "Sim";
			else if(opcao == 1)
				voto = "Não";
			else if(opcao == 2)
				voto = "Abstenção";
			else if(opcao == 3 || opcao == -1)
				voto = "Ausente";
			
			Voto v = new Voto(listaDeputados.get(i), voto);
			
			listaVotos.add(v);
		}
		
		io.escreverVotos(listaVotos, ARQUIVO_VOTOS);
	}
}
