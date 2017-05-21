package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.Contagem;
import view.ViewGUI;

public class Executar {
	public static final String ARQUIVO_CONTAGEM = "../Contagem.txt";
	public static final String ARQUIVO_VOTOS = "../Votos.csv";
	
	public static void main(String[] args) throws FileNotFoundException{
		IO io = new IO();
		ViewGUI gui = new ViewGUI();
		Contagem cont = new Contagem();
		List<String> listaVotos = new ArrayList<String>();
		
		io.deletarArquivo(ARQUIVO_CONTAGEM);
		io.verificarArquivo(ARQUIVO_VOTOS);
		listaVotos = io.lerVotos(ARQUIVO_VOTOS);
		
		for(int i = 0; i < listaVotos.size(); i++){
			if(listaVotos.get(i).equals("Sim"))
				cont.setContaSim(cont.getContaSim() + 1);
			else if(listaVotos.get(i).equals("Não"))
				cont.setContaNao(cont.getContaNao() + 1);
			else if(listaVotos.get(i).equals("Abstenção"))
				cont.setContaAbstencao(cont.getContaAbstencao() + 1);
			else if(listaVotos.get(i).equals("Ausente"))
				cont.setContaAusente(cont.getContaAusente() + 1);
		}
		

		io.escreverContagem(cont.toString(), ARQUIVO_CONTAGEM);
		gui.exibeMsg(cont.toString());
		
		if(cont.getContaSim() > (cont.getContaAbstencao() + cont.getContaAusente() + cont.getContaNao()))
			gui.exibeMsg("PROJETO APROVADO!");

	}

}
