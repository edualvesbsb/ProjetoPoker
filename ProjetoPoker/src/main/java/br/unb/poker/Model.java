package br.unb.poker;

public class Model {

	private int pote;
	private int jogador1Fichas;
	private int jogador2Fichas;

	public Model(int pote, int jogador1Fichas, int jogador2Fichas) {

		this.pote = pote;
		this.jogador1Fichas = jogador1Fichas;
		this.jogador2Fichas = jogador2Fichas;

	}

	public int getPote() {
		return pote;
	}

	public void setPote(int pote) {
		this.pote = pote;
	}

	public int getJogador1Fichas() {
		return jogador1Fichas;
	}

	public void setJogador1Fichas(int jogador1Fichas) {
		this.jogador1Fichas = jogador1Fichas;

	}

	public int getJogador2Fichas() {
		return jogador2Fichas;
	}

	public void setJogador2Fichas(int jogador2Fichas) {
		this.jogador2Fichas = jogador2Fichas;
	}

}
