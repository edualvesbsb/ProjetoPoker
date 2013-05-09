package jogo;

public class Carta {
	String face,suit;
	public String endereço; 
	int valor, naipe; 

	int valortemp = 0;
	String naipetemp = "";

	public Carta( String cardFace, String cardSuit, int cardValor, int cardNaipe) //Construtor da classe Carta
	{
		face= cardFace;
		suit= cardSuit;
		valor = cardValor;
		naipe = cardNaipe;
		
		
		
		if (valor< 13){
			valortemp = valor +1; 
		} else{
			valortemp = valor - 12; 
		} //Este laço atribui o valor das cartas, onde o ás é 1, 2 é 2, ... , Rei é 12
			
	   	switch(naipe){
	   	
	   	case 0: naipetemp = "c"; break;
	   	case 1: naipetemp = "d"; break;
	   	case 2: naipetemp = "h"; break;
	   	case 3: naipetemp = "s"; break;
	    	
	   	} //Este laço atribui um valor String para os naipes, onde c é cloves(paus), d é diamonds(ouros), h é hearts(copas) e s é spades(espadas)
	   	
	   	endereço = "img/"+valortemp+naipetemp+".png"; //É atribuido o endereço da variável endereço assim como deve ser formatado para ser acessado no package img
		
		
	}
		
}