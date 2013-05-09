package jogo;

import java.util.Random;

public class Baralho {
	
	public Carta[] baralho;
	int cartaAtual;
	Random r = new Random(); //Cria-se uma varíavel r aleatória

	public Baralho() //Construtor da classe Baralho
	{
		String [] faces ={ "Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Valete", "Dama", "Rei"};
		String [] suits = {"Paus", "Ouro",  "Copas","Espada"};
		
		baralho = new Carta[52];
		cartaAtual = 0;
		 
		for (int count = 0; count < baralho.length; count ++){
			 if(count%13==0)
				 baralho[count]= new Carta(faces[count %13], suits [ count/13],13,count/13);
			 else
				 baralho[count]= new Carta(faces[count %13], suits [ count/13],count%13,count/13);
			 
		} //Este laço atribui valor e naipe a todas as 52 cartas do deck, de forma ordenada
			 
			 
	}
		 
	public void shuffle(){ //Esta função embaralha as cartas do deck
		
		cartaAtual = 0;
			 
			 for (int first=0; first<baralho.length; first++){
				 int second= r.nextInt(52); //Gera-se um número aleatório entre 0 e 51
				 Carta temp = baralho [first];
				 baralho[ first]= baralho[ second];
				 baralho[second]= temp;
			 }
	}
	
	public Carta dealCard(){ //Esta função distribui, carta a carta, as cartas do deck
		 {
			 if (cartaAtual < baralho.length)
				 return baralho[cartaAtual++];
			 else //Se o deck acabar, nenhuma carta é retornada
				 return null;
	}
}
}

