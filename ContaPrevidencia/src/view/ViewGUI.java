package view;

import javax.swing.JOptionPane;

public class ViewGUI {
	
	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
	
	public String recebeString(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

	public Double recebeDouble(String texto) {
		return Double.parseDouble(JOptionPane.showInputDialog(texto));
	}
	
	public Long recebeLong(String texto) {
		return Long.parseLong(JOptionPane.showInputDialog(texto));
	}
	
	public int seletor(String deputado){
		Object[] opcoes = { "Sim", "Não", "Abstenção", "Ausente" };
		
		int escolha = JOptionPane.showOptionDialog(null, 
		    "Voto do deputado: " + deputado, 
		    "Votação Previdência", 
		    JOptionPane.YES_NO_OPTION, 
		    JOptionPane.QUESTION_MESSAGE, 
		    null, 
		    opcoes, 
		    opcoes[0]);

		return escolha;
	}
}