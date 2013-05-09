package jogo;

public class Dealer {
	
	public static void main(String[] args) {
		
		Baralho meuBaralho = new Baralho();
		meuBaralho.shuffle();
		Jogador Vergne = new Jogador("Vergne", meuBaralho.dealCard(), meuBaralho.dealCard());
		Jogador Alves = new Jogador("Alves", meuBaralho.dealCard(), meuBaralho.dealCard());
		System.out.println("Alves's cards: "+Alves.mao_01+" e "+Alves.mao_02);
		System.out.println("Vergne's cards: "+Vergne.mao_01+" e "+Vergne.mao_02);
		
				
	}

}
