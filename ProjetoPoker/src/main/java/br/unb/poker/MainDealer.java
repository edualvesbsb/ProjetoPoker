package br.unb.poker;


public class MainDealer {
	
	public static void main(String[] args) {
		
		Baralho meuBaralho = new Baralho();
		meuBaralho.shuffle();
		
		Jogador Vergne = new Jogador("Vergne", meuBaralho.dealCard(), meuBaralho.dealCard());
		Jogador Alves = new Jogador("Alves", meuBaralho.dealCard(), meuBaralho.dealCard());
		
		
		System.out.println(Vergne);
		System.out.println(Alves);
		
		Carta[] Mesa = new Carta[5];
		
	    for (int k = 0; k < 5; k++){
		Mesa[k] = meuBaralho.dealCard();
	    }
		
	    System.out.println("Mesa: " +Mesa[0] +", " +Mesa[1] +", " +Mesa[2] +", " +Mesa[3] +", " +Mesa[4]);
	    
		ComparaJogos comparador = new ComparaJogos (Vergne.getMao(), Alves.getMao(), Mesa);
		
		System.out.println("Nivel do jogo de Alves: "+ comparador.determinaNiveldaMao(Alves.getMao(), Mesa));
		System.out.println("Nivel do jogo de Vergne: "+ comparador.determinaNiveldaMao(Vergne.getMao(), Mesa));
		
		if (!comparador.determinaEmpate()){
						
			System.out.println("Vencedor: "+ comparador.determinaVencedor()[0] + ", " + comparador.determinaVencedor()[1]);
			
		}
		
						
	}

}
