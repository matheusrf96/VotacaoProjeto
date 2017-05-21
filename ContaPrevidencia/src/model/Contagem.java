package model;

public class Contagem {
	private Long contaSim;
	private Long contaNao;
	private Long contaAbstencao;
	private Long contaAusente;
	
	
	public Contagem() {
		super();
		this.contaSim = 0l;
		this.contaNao = 0l;
		this.contaAbstencao = 0l;
		this.contaAusente = 0l;
	}

	public Long getContaSim() {
		return contaSim;
	}
	public void setContaSim(Long contaSim) {
		if(contaSim < 0)
			this.contaSim = 0l;
		else
			this.contaSim = contaSim;
	}
	public Long getContaNao() {
		return contaNao;
	}
	public void setContaNao(Long contaNao) {
		if(contaNao < 0)
			this.contaNao = 0l;
		else
			this.contaNao = contaNao;
	}
	public Long getContaAbstencao() {
		return contaAbstencao;
	}
	public void setContaAbstencao(Long contaAbstencao) {
		if(contaAbstencao < 0)
			this.contaAbstencao = 0l;
		else
			this.contaAbstencao = contaAbstencao;
	}
	public Long getContaAusente() {
		return contaAusente;
	}
	public void setContaAusente(Long contaAusente) {
		if(contaAusente < 0)
			this.contaAusente = 0l;
		else
			this.contaAusente = contaAusente;
	}
	
	@Override
	public String toString() {
		return "Contagem dos Votos: " +
				"\nSim: " + this.contaSim +
				"\nNão: " + this.contaNao +
				"\nAbsteções: " + this.contaAbstencao +
				"\nAusentes: " + this.contaAusente;
	}
	
}
