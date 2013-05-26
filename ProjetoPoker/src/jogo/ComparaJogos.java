package jogo;

public class ComparaJogos {
	
	Carta[] mao1 = new Carta[7];
	Carta[] mao2 = new Carta[7];
	Carta[] Mesa = new Carta[5];
	Carta[] jogador1_mao = new Carta[2];
	Carta[] jogador2_mao = new Carta[2];
	Achajogo jogador1_jogos;
	Achajogo jogador2_jogos;
	int vencedor = 0;
	
	public ComparaJogos(Carta[] jogador1_mao, Carta[] jogador2_mao, Carta[] Mesa ){ //Construtor da classe ComparaJogos
	
		
		jogador1_jogos = new Achajogo(jogador1_mao, Mesa);
		jogador2_jogos = new Achajogo(jogador2_mao, Mesa);
		this.jogador1_mao = jogador1_mao;
		this.jogador2_mao = jogador2_mao;
		this.Mesa = Mesa;
		
		for (int i = 0; i<2; i++){
			this.mao1[i] = jogador1_mao[i];
		}
		
		for (int i = 0; i<5; i++){
			this.mao1[i+2] = Mesa[i];
			this.mao2[i+2] = Mesa[i];
			
		}
		
		for (int i = 0; i<2; i++){
			this.mao2[i] = jogador2_mao[i];
			
		}
		
				
	}
	
	
	public int determinaNiveldaMao(Carta[] mao, Carta[] Mesa){
		
		Achajogo jogos = new Achajogo(jogador1_mao, Mesa);
		
		return jogos.determinaMelhorMao();
					
	}
	
	public Carta[] determinaVencedor(){
	
	if (jogador1_jogos.determinaMelhorMao() > jogador2_jogos.determinaMelhorMao()){
		
		return jogador1_mao;
		
	} else if (jogador1_jogos.determinaMelhorMao() < jogador2_jogos.determinaMelhorMao()) {
		
		return jogador2_mao;
		
	}

	 //Se a melhor mão de cada jogador corresponder em peso, deve-se procurar por High Cards (famosos kickers)

		for(int i = 0; i < 5; i++){
			if(mao1[i].getValor() > mao2[i].getValor()){
				return jogador1_mao; 
				
			}
			if(mao1[i].getValor() < mao2[i].getValor()){
				return jogador2_mao; 
				
			}
			
		}
		
		return jogador1_mao; //Necessário para compilar
		
	}
		 
	public boolean determinaEmpate(){
		
		boolean empate = false;
		
		if (jogador1_jogos.determinaMelhorMao() == jogador2_jogos.determinaMelhorMao()){
			
		empate = true;
			
		for(int i = 0; i < 5; i++){
			if(mao1[i].getValor() > mao2[i].getValor()){
				empate = false; 
				
			}
			if(mao1[i].getValor() < mao2[i].getValor()){
				empate = false;
				
			}
		}
		
	 }
		return empate;
		
	}
	
	
}


	
	


