package br.unb.poker;

public class Carta {

	private String s_valor, s_naipe;
	private int valor, naipe; //Tanto o número como o naipe da carta possui um valor associado

	public Carta(String s_valor, String s_naipe, int cardValor, int cardNaipe) // Construtor da classe Carta
																				
	{

		this.s_valor = s_valor;
		this.s_naipe = s_naipe;
		valor = cardValor;
		naipe = cardNaipe;

	}

	public String getS_valor() {
		return s_valor;
	}

	
	public String getS_naipe() {
		return s_naipe;
	}


	public int getValor() {
		return valor;
	}


	public int getNaipe() {
		return naipe;
	}


	public String toString() {
		return getS_valor() + " de " + getS_naipe();
	}

}