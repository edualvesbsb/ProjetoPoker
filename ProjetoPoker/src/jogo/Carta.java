package jogo;

public class Carta {
	String face,suit;
	public String endere�o; 
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
		} //Este la�o atribui o valor das cartas, onde o �s � 1, 2 � 2, ... , Rei � 12
			
	   	switch(naipe){
	   	
	   	case 0: naipetemp = "c"; break;
	   	case 1: naipetemp = "d"; break;
	   	case 2: naipetemp = "h"; break;
	   	case 3: naipetemp = "s"; break;
	    	
	   	} //Este la�o atribui um valor String para os naipes, onde c � cloves(paus), d � diamonds(ouros), h � hearts(copas) e s � spades(espadas)
	   	
	   	endere�o = "img/"+valortemp+naipetemp+".png"; //� atribuido o endere�o da vari�vel endere�o assim como deve ser formatado para ser acessado no package img
		
		
	}
		
}