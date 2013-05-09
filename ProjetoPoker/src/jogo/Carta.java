package jogo;

public class Carta {
	
	String s_valor, s_naipe;
	int valor, naipe; 

	
	public Carta( String s_valor, String s_naipe, int cardValor, int cardNaipe) //Construtor da classe Carta
	{
		
		this.s_valor= s_valor;
		this.s_naipe= s_naipe;
		valor = cardValor;
		naipe = cardNaipe;
		

	}
	
	public String toString(){
		return s_valor + " de " + s_naipe ; 
	}
		
}