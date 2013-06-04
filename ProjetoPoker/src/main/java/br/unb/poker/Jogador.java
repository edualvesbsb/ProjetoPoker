package br.unb.poker;

public class Jogador { //Classe relacionada ao jogador. Esta será utilizada no decorrer do aplicativo e possui informações não pessoais (ie, nome, idade, etc),
					   //mas possui informações relacionadas ao jogo (mão, etc)
	
	private String nickname;
	private Carta mao_01;
	private Carta mao_02;
	private Carta[] mao = new Carta[2];
	private int fichas;
	
	public Jogador(String nickname, Carta mao_01, Carta mao_02){
		
		this.nickname = nickname;
		this.mao_01 = mao_01;
		this.mao_02 = mao_02;
		
		mao[0] = mao_01;
		mao[1] = mao_02;
		
		fichas = 1500;
	}

	public String getNickname() {
		return nickname;
	}


	public Carta getMao_01() {
		return mao_01;
	}


	public Carta getMao_02() {
		return mao_02;
	}


	public Carta[] getMao() {
		return mao;
	}

	
	public String toString(){
		return ("O jogador " + getNickname() +" tem " + getMao_01() +" e "+ getMao_02()) ; 
	}

	public int getFichas() {
		return fichas;
	}

	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	
	
}
