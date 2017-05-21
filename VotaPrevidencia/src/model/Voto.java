package model;

public class Voto {
	private String nomeDeputado;
	private String voto;
	
	
	public Voto(String nomeDeputado, String voto) {
		super();
		this.nomeDeputado = nomeDeputado;
		this.voto = voto;
	}
	
	public String getNomeDeputado() {
		return nomeDeputado;
	}
	public void setNomeDeputado(String nomeDeputado) {
		this.nomeDeputado = nomeDeputado;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return nomeDeputado + ";" + voto + "\n";
	}	
	
}
