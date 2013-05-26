package br.unb.poker;


public class Jogador {
	
	private String nome;
	private Carta mao_01;
	private Carta mao_02;
	private Carta[] mao = new Carta[2];
	
	public Jogador(String nome, Carta mao_01, Carta mao_02){
		
		this.nome = nome;
		this.mao_01 = mao_01;
		this.mao_02 = mao_02;
		

		
		mao[0] = mao_01;
		mao[1] = mao_02;			
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Carta getMao_01() {
		return mao_01;
	}

	public void setMao_01(Carta mao_01) {
		this.mao_01 = mao_01;
	}

	public Carta getMao_02() {
		return mao_02;
	}

	public void setMao_02(Carta mao_02) {
		this.mao_02 = mao_02;
	}

	public Carta[] getMao() {
		return mao;
	}

	public void setMao(Carta[] mao) {
		this.mao = mao;
	}
	
	public String toString(){
		return ("O jogador " + nome +" tem " + mao_01 +" e "+ mao_02) ; 
	}
	
	
}
