package br.unb.poker;

public class Carta {
	
	private String s_valor, s_naipe;
	private int valor, naipe; 

	
		public Carta( String s_valor, String s_naipe, int cardValor, int cardNaipe) //Construtor da classe Carta
	{
		
		this.s_valor= s_valor;
		this.s_naipe= s_naipe;
		valor = cardValor;
		naipe = cardNaipe;
		

	}
		
		public String getS_valor() {
			return s_valor;
		}

		public void setS_valor(String s_valor) {
			this.s_valor = s_valor;
		}

		public String getS_naipe() {
			return s_naipe;
		}

		public void setS_naipe(String s_naipe) {
			this.s_naipe = s_naipe;
		}

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

		public int getNaipe() {
			return naipe;
		}

		public void setNaipe(int naipe) {
			this.naipe = naipe;
		}
	
	
	public String toString(){
		return s_valor + " de " + s_naipe ; 
	}
		
}