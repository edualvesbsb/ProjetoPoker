package br.unb.poker;

public class Controlador {

	Model model;

	public Controlador(Model model) {

		this.model = model;

	}

	public void alterarPote(int aposta) {

		model.setPote(model.getPote() + aposta);

	}

	public void alterarFichasJogador1(int aposta) throws Exception {

		if (aposta > model.getJogador1Fichas()) {
			throw new Exception("Aposta alta");
		}
		model.setJogador1Fichas(model.getJogador1Fichas() - aposta);

	}

	public void alterarFichasJogador2(int aposta) {

		model.setJogador2Fichas(model.getJogador2Fichas() - aposta);

	}

}
