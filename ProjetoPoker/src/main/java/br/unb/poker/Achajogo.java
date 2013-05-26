package br.unb.poker;



public class Achajogo {
	
	
	private Carta[] melhor_mao = new Carta[7];
	private Carta[] mao = new Carta[7];
	private Carta aux0;
	private Carta aux1;
	private Carta[] maoFlush = new Carta[7];
	private Carta[] maoStraight = new Carta[7];
	
	public Achajogo(Carta[] mao, Carta[] Mesa){
		
		
		this.mao[0] = mao[0];
		this.mao[1] = mao[1];
		this.mao[2] = Mesa[0];
		this.mao[3] = Mesa[1];
		this.mao[4] = Mesa[2];
		this.mao[5] = Mesa[3];
		this.mao[6] = Mesa[4];
		
		
				
		for (int i = 0; i < 7; i++) { //Este laço ordena a mao da maior carta para a menor, sendo ás a maior e 2 a menor, não importando o naipe
			for (int j = 0; j < 6; j++) {
				if (this.mao[j].getValor() < this.mao[j + 1].getValor()) {
					aux0 = this.mao[j];
					this.mao[j] = this.mao[j + 1];
					this.mao[j + 1] = aux0;
				} 
			}
		}
		
		melhor_mao = this.mao;
		
	}
		
		
	public boolean achaPar(Carta[] a){ //Esta função verifica se a mao do jogador contém algum par e o coloca nas posições 3 e 4 da mao, este será o maior segundo par que o jogador possui, pois a mão foi previamente ordenada
			for (int i = 0; i < 6; i++) {
				for (int j = i; j < 6; j++) {
					if (a[j].getValor() == a[j + 1].getValor()) {
						switch (j) {

						case 0:
							break;
						case 1:
							aux0 = a[j + 1];
							a[j + 1] = a[0];
							a[0] = aux0;
							break;
						case 2:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[0];
							a[j + 1] = a[1];
							a[0] = aux0;
							a[1] = aux1;
							break;
						case 3:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[1];
							a[j + 1] = a[2];
							a[2] = a[0];
							a[1] = aux0;
							a[0] = aux1;
							break;
						case 4:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[2];
							a[j + 1] = a[3];
							a[3] = a[1];
							a[2] = a[0];
							a[0] = aux0;
							a[1] = aux1;
							break;
						case 5:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[3];
							a[j + 1] = a[4];
							a[4] = a[2];
							a[3] = a[1];
							a[2] = a[0];
							a[0] = aux0;
							a[1] = aux1;
							break;
						}
						mao = a;
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean achaDoisPares(Carta[] a) { //Esta função verifica se a mao do jogador contém algum par e o coloca nas posições 3 e 4 da mao, este será o maior segundo par que o jogador possui, pois a mão foi previamente ordenada
			for (int i = 2; i < 6; i++) {
				for (int j = i; j < 6; j++) {
					if (a[j].getValor() == a[j + 1].getValor()) {
						switch (j) {

						case 2:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[2];
							a[j + 1] = a[3];
							a[2] = aux0;
							a[3] = aux1;
							break;
						case 3:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[3];
							a[j + 1] = a[4];
							a[4] = a[2];
							a[3] = aux0;
							a[2] = aux1;
							break;
						case 4:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[4];
							a[j + 1] = a[5];
							a[5] = a[3];
							a[4] = a[2];
							a[2] = aux0;
							a[3] = aux1;
							break;
						case 5:
							aux0 = a[j];
							aux1 = a[j + 1];
							a[j] = a[5];
							a[j + 1] = a[6];
							a[6] = a[4];
							a[5] = a[3];
							a[4] = a[2];
							a[2] = aux0;
							a[3] = aux1;
							break;
						}
						mao = a;
						return true;
					}
				}
			}
			return false;
		}

		public boolean achaTrinca(Carta[] a) { //Esta função verifica se a mao do jogador contém alguma trinca e coloca este nas três primeiras posições da mao, este será a maior trinca que o jogador possui, pois a mão foi previamente ordenada
			for (int j = 2; j < 7; j++) {
				if (a[1].getValor() == a[j].getValor()) {
					switch (j) {
					case (2):
						break;
					case (3):
						aux0 = a[j];
						a[j] = a[2];
						a[2] = aux0;
						break;
					case (4):
						aux0 = a[j];
						a[j] = a[3];
						a[3] = a[2];
						a[2] = aux0;
						break;
					case (5):
						aux0 = a[j];
						a[j] = a[4];
						a[4] = a[3];
						a[3] = a[2];
						a[2] = aux0;
						break;
					case (6):
						aux0 = a[j];
						a[j] = a[5];
						a[5] = a[4];
						a[4] = a[3];
						a[3] = a[2];
						a[2] = aux0;
						break;
					}
					return true;
				}
			}
			return false;
		}
		
		public boolean achaQuadra(Carta[] a) { //Esta função verifica se a mao do jogador contém alguma quadra e a coloca nas quatro primeiras posições da mao, esta será a maior quadra que o jogador possui, pois a mão foi previamente ordenada
			for (int j = 3; j < 7; j++) {
				if (a[1].getValor() == a[j].getValor()) {
					switch (j) {
					case (3):
						break;
					case (4):
						aux0 = a[j];
						a[j] = a[3];
						a[3] = aux0;
						break;
					case (5):
						aux0 = a[j];
						a[j] = a[4];
						a[4] = a[3];
						a[3] = aux0;
						break;
					case (6):
						aux0 = a[j];
						a[j] = a[5];
						a[5] = a[4];
						a[4] = a[3];
						a[3] = aux0;
						break;
					}
					return true;
				}
			}
			return false;
		}
		
		public boolean achaFullHouse(Carta[] a) { //Esta função verifica se a mao do jogador contém algum full house e o coloca nas cinco primeiras posições da mao, este será o maior full house que o jogador possui, pois a mão foi previamente ordenada

			if (a[3].getValor() == a[4].getValor()) {
				mao = a;
				return true;
			}
			if (a[4].getValor() == a[5].getValor()) {
				a[3] = a[4];
				mao = a;
				return true;
			}
			if (a[5].getValor() == a[6].getValor()) {
				a[3] = a[5];
				a[4] = a[5];
				mao = a;
				return true;
			}

			return false;

		}
		
		public boolean achaFlush(Carta[] a) { //Esta função verifica se a mao do jogador contém flush, verifica se pelo menos 5 das 7 cartas contêm o mesmo naipe e retorna o maior flush do jogador nas cinco primeiras posições da mao
			int[] cont = new int[4];
			cont[0] = 0;
			cont[1] = 0;
			cont[2] = 0;
			cont[3] = 0;
			for (int i = 0; i < 7; i++) {
				switch (a[i].getNaipe()) {

				case (0):
					cont[0]++;
					break;
				case (1):
					cont[1]++;
					break;
				case (2):
					cont[2]++;
					break;
				case (3):
					cont[3]++;
					break;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (cont[i] >= 5) {

					switch (cont[i]) {

					case (7):
						maoFlush[5] = mao[5];
						maoFlush[6] = mao[6];
						mao = maoFlush;
						break;
					case (6):
						int z = 0;
						for (int j = 0; j < 7; j++) {
							if (a[j].getNaipe() == i) {
								maoFlush[z++] = a[j];
							}
						}
						maoFlush[5] = mao[5];
						maoFlush[6] = mao[6];
						mao = maoFlush;
						break;
					case (5):
						int x = 0;
						for (int j = 0; j < 7; j++) {
							if (a[j].getNaipe() == i) {
								maoFlush[x++] = a[j];
							}
						}
						maoFlush[5] = mao[5];
						maoFlush[6] = mao[6];
						mao = maoFlush;
						break;

					}
					return true;

				}

			}
			return false;
		}
		
		public boolean achaStraight(Carta[] a) { //Esta função verifica se a mao do jogador contém straight, verifica se pelo menos 5 das 7 cartas estão em sequência e retorna o maior straight nas cinco primeiras posições da mão
			if ((a[0].getValor() == a[1].getValor() + 1) && (a[1].getValor() == a[2].getValor() + 1)
					&& (a[2].getValor() == a[3].getValor() + 1)
					&& (a[3].getValor() == a[4].getValor() + 1)) {
				mao = a;
				return true;
			} else if ((a[1].getValor() == a[2].getValor() + 1)
					&& (a[2].getValor() == a[3].getValor() + 1)
					&& (a[3].getValor() == a[4].getValor() + 1)
					&& (a[4].getValor() == a[5].getValor() + 1)) {
				int x = 0;
				for (int j = 1; j < 7; j++)
					maoStraight[x++] = a[j];
				maoStraight[5] = mao[5];
				maoStraight[6] = mao[6];
				mao = maoStraight;
				return true;
			} else if ((a[2].getValor() == a[3].getValor() + 1)
					&& (a[3].getValor() == a[4].getValor() + 1)
					&& (a[4].getValor() == a[5].getValor() + 1)
					&& (a[5].getValor() == a[6].getValor() + 1)) {
				int x = 0;
				for (int j = 2; j < 7; j++)
					maoStraight[x++] = a[j];
				maoStraight[5] = mao[5];
				maoStraight[6] = mao[6];
				mao = maoStraight;
				return true;
			}
			return false;
		}
		
		public boolean achaStraightFlush(Carta[] a) { //Esta função verifica se a mao do jogador contém straight flush, verifica se pelo menos 5 das 7 cartas contêm o mesmo naipe e estão em sequência e retorna o maior straight flush do jogador nas cinco primeiras posições da mao
			if ((a[0].getValor() == a[1].getValor() + 1) && (a[1].getValor() == a[2].getValor() + 1)
					&& (a[2].getValor() == a[3].getValor() + 1)
					&& (a[3].getValor() == a[4].getValor() + 1)) {

				if ((a[0].getNaipe() == a[1].getNaipe()) && (a[1].getNaipe() == a[2].getNaipe())
						&& (a[2].getNaipe() == a[3].getNaipe()) && (a[3].getNaipe() == a[4].getNaipe())) {
					mao = a;
					return true;
				}
			} else if ((a[1].getValor() == a[2].getValor() + 1)
					&& (a[2].getValor() == a[3].getValor() + 1)
					&& (a[3].getValor() == a[4].getValor() + 1)
					&& (a[4].getValor() == a[5].getValor() + 1)) {
				if ((a[1].getNaipe() == a[2].getNaipe()) && (a[2].getNaipe() == a[3].getNaipe())
						&& (a[3].getNaipe() == a[4].getNaipe()) && (a[4].getNaipe() == a[5].getNaipe())) {
					mao = a;
					int x = 0;
					for (int j = 1; j < 7; j++)
						maoStraight[x++] = a[j];
					maoStraight[5] = mao[5];
					maoStraight[6] = mao[6];
					mao = maoStraight;
					return true;
				}
			} else if ((a[2].getValor() == a[3].getValor() + 1)
					&& (a[3].getValor() == a[4].getValor() + 1)
					&& (a[4].getValor() == a[5].getValor() + 1)
					&& (a[5].getValor() == a[6].getValor() + 1)) {
				if ((a[2].getNaipe() == a[3].getNaipe()) && (a[3].getNaipe() == a[4].getNaipe())
						&& (a[4].getNaipe() == a[5].getNaipe()) && (a[5].getNaipe() == a[6].getNaipe())) {
					int x = 0;
					for (int j = 2; j < 7; j++)
						maoStraight[x++] = a[j];
					maoStraight[5] = mao[5];
					maoStraight[6] = mao[6];
					mao = maoStraight;
					return true;
				}
			}
			return false;
		}
		
	
	public int determinaMelhorMao(){
		
		boolean[] nivel = new boolean[8];
		
		nivel[7] = achaStraightFlush(melhor_mao);
		nivel[3] = achaStraight(melhor_mao);
		nivel[4] = achaFlush(melhor_mao);
		
		nivel[0] = achaPar(melhor_mao);
		
		if (nivel[0] == true){
			nivel[2] = achaTrinca(melhor_mao);
			if(nivel[2]== true){
				nivel[5] = achaFullHouse(melhor_mao);
				nivel[6] = achaQuadra(melhor_mao);
					
			}else{
				nivel[1] = achaDoisPares(melhor_mao);
			}
		}
		
		
		for (int i = 7; i>-1; i--){
			if (nivel[i] == true){
				return i;
			}
		} //Este laço verifica qual o maior valor que contém true na variável boolean teste
		
		return -1; //É retornado -1 caso o melhor jogo seja uma High Card
		
			
		
		
	}
		
		
	}


