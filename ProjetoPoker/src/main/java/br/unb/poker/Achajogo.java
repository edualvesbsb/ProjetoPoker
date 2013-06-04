package br.unb.poker;

public class Achajogo {

	private Carta[] melhor_mao = new Carta[7];
	private Carta[] mao = new Carta[7];
	private Carta aux0;
	private Carta aux1;
	private Carta[] maoFlush = new Carta[7];
	private Carta[] maoStraight = new Carta[7];

	public Achajogo(Carta[] mao, Carta[] Mesa) {

		this.mao[0] = mao[0];
		this.mao[1] = mao[1];
		this.mao[2] = Mesa[0];
		this.mao[3] = Mesa[1];
		this.mao[4] = Mesa[2];
		this.mao[5] = Mesa[3];
		this.mao[6] = Mesa[4];

		for (int i = 0; i < 7; i++) { // Este laço ordena a mao da maior carta
										// para a menor, sendo ás a maior e 2 a
										// menor, não importando o naipe
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

	public boolean achaPar(Carta[] mao_intermediaria) { // Esta função verifica se a mao do
										// jogador contém algum par e o coloca
										// nas posições 3 e 4 da mao, este será
										// o maior segundo par que o jogador
										// possui, pois a mão foi previamente
										// ordenada
		for (int i = 0; i < 6; i++) {
			for (int j = i; j < 6; j++) {
				if (mao_intermediaria[j].getValor() == mao_intermediaria[j + 1].getValor()) {
					switch (j) {

					case 0:
						break;
					case 1:
						aux0 = mao_intermediaria[j + 1];
						mao_intermediaria[j + 1] = mao_intermediaria[0];
						mao_intermediaria[0] = aux0;
						break;
					case 2:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[0];
						mao_intermediaria[j + 1] = mao_intermediaria[1];
						mao_intermediaria[0] = aux0;
						mao_intermediaria[1] = aux1;
						break;
					case 3:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[1];
						mao_intermediaria[j + 1] = mao_intermediaria[2];
						mao_intermediaria[2] = mao_intermediaria[0];
						mao_intermediaria[1] = aux0;
						mao_intermediaria[0] = aux1;
						break;
					case 4:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[2];
						mao_intermediaria[j + 1] = mao_intermediaria[3];
						mao_intermediaria[3] = mao_intermediaria[1];
						mao_intermediaria[2] = mao_intermediaria[0];
						mao_intermediaria[0] = aux0;
						mao_intermediaria[1] = aux1;
						break;
					case 5:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[3];
						mao_intermediaria[j + 1] = mao_intermediaria[4];
						mao_intermediaria[4] = mao_intermediaria[2];
						mao_intermediaria[3] = mao_intermediaria[1];
						mao_intermediaria[2] = mao_intermediaria[0];
						mao_intermediaria[0] = aux0;
						mao_intermediaria[1] = aux1;
						break;
					}
					mao = mao_intermediaria;
					return true;
				}
			}
		}
		return false;
	}

	public boolean achaDoisPares(Carta[] mao_intermediaria) { // Esta função verifica se a mao
												// do jogador contém algum par e
												// o coloca nas posições 3 e 4
												// da mao, este será o maior
												// segundo par que o jogador
												// possui, pois a mão foi
												// previamente ordenada
		for (int i = 2; i < 6; i++) {
			for (int j = i; j < 6; j++) {
				if (mao_intermediaria[j].getValor() == mao_intermediaria[j + 1].getValor()) {
					switch (j) {

					case 2:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[2];
						mao_intermediaria[j + 1] = mao_intermediaria[3];
						mao_intermediaria[2] = aux0;
						mao_intermediaria[3] = aux1;
						break;
					case 3:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[3];
						mao_intermediaria[j + 1] = mao_intermediaria[4];
						mao_intermediaria[4] = mao_intermediaria[2];
						mao_intermediaria[3] = aux0;
						mao_intermediaria[2] = aux1;
						break;
					case 4:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[4];
						mao_intermediaria[j + 1] = mao_intermediaria[5];
						mao_intermediaria[5] = mao_intermediaria[3];
						mao_intermediaria[4] = mao_intermediaria[2];
						mao_intermediaria[2] = aux0;
						mao_intermediaria[3] = aux1;
						break;
					case 5:
						aux0 = mao_intermediaria[j];
						aux1 = mao_intermediaria[j + 1];
						mao_intermediaria[j] = mao_intermediaria[5];
						mao_intermediaria[j + 1] = mao_intermediaria[6];
						mao_intermediaria[6] = mao_intermediaria[4];
						mao_intermediaria[5] = mao_intermediaria[3];
						mao_intermediaria[4] = mao_intermediaria[2];
						mao_intermediaria[2] = aux0;
						mao_intermediaria[3] = aux1;
						break;
					}
					mao = mao_intermediaria;
					return true;
				}
			}
		}
		return false;
	}

	public boolean achaTrinca(Carta[] mao_intermediaria) { // Esta função verifica se a mao do
											// jogador contém alguma trinca e
											// coloca este nas três primeiras
											// posições da mao, este será a
											// maior trinca que o jogador
											// possui, pois a mão foi
											// previamente ordenada
		for (int j = 2; j < 7; j++) {
			if (mao_intermediaria[1].getValor() == mao_intermediaria[j].getValor()) {
				switch (j) {
				case (2):
					break;
				case (3):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[2];
					mao_intermediaria[2] = aux0;
					break;
				case (4):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[3];
					mao_intermediaria[3] = mao_intermediaria[2];
					mao_intermediaria[2] = aux0;
					break;
				case (5):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[4];
					mao_intermediaria[4] = mao_intermediaria[3];
					mao_intermediaria[3] = mao_intermediaria[2];
					mao_intermediaria[2] = aux0;
					break;
				case (6):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[5];
					mao_intermediaria[5] = mao_intermediaria[4];
					mao_intermediaria[4] = mao_intermediaria[3];
					mao_intermediaria[3] = mao_intermediaria[2];
					mao_intermediaria[2] = aux0;
					break;
				}
				return true;
			}
		}
		return false;
	}

	public boolean achaQuadra(Carta[] mao_intermediaria) { // Esta função verifica se a mao do
											// jogador contém alguma quadra e a
											// coloca nas quatro primeiras
											// posições da mao, esta será a
											// maior quadra que o jogador
											// possui, pois a mão foi
											// previamente ordenada
		for (int j = 3; j < 7; j++) {
			if (mao_intermediaria[1].getValor() == mao_intermediaria[j].getValor()) {
				switch (j) {
				case (3):
					break;
				case (4):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[3];
					mao_intermediaria[3] = aux0;
					break;
				case (5):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[4];
					mao_intermediaria[4] = mao_intermediaria[3];
					mao_intermediaria[3] = aux0;
					break;
				case (6):
					aux0 = mao_intermediaria[j];
					mao_intermediaria[j] = mao_intermediaria[5];
					mao_intermediaria[5] = mao_intermediaria[4];
					mao_intermediaria[4] = mao_intermediaria[3];
					mao_intermediaria[3] = aux0;
					break;
				}
				return true;
			}
		}
		return false;
	}

	public boolean achaFullHouse(Carta[] mao_intermediaria) { // Esta função verifica se a mao
												// do jogador contém algum full
												// house e o coloca nas cinco
												// primeiras posições da mao,
												// este será o maior full house
												// que o jogador possui, pois a
												// mão foi previamente ordenada

		if (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor()) {
			mao = mao_intermediaria;
			return true;
		}
		if (mao_intermediaria[4].getValor() == mao_intermediaria[5].getValor()) {
			mao_intermediaria[3] = mao_intermediaria[4];
			mao = mao_intermediaria;
			return true;
		}
		if (mao_intermediaria[5].getValor() == mao_intermediaria[6].getValor()) {
			mao_intermediaria[3] = mao_intermediaria[5];
			mao_intermediaria[4] = mao_intermediaria[5];
			mao = mao_intermediaria;
			return true;
		}

		return false;

	}

	public boolean achaFlush(Carta[] mao_intermediaria) { // Esta função verifica se a mao do
											// jogador contém flush, verifica se
											// pelo menos 5 das 7 cartas contêm
											// o mesmo naipe e retorna o maior
											// flush do jogador nas cinco
											// primeiras posições da mao
		int[] cont = new int[4];
		cont[0] = 0;
		cont[1] = 0;
		cont[2] = 0;
		cont[3] = 0;
		for (int i = 0; i < 7; i++) {
			switch (mao_intermediaria[i].getNaipe()) {

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
						if (mao_intermediaria[j].getNaipe() == i) {
							maoFlush[z++] = mao_intermediaria[j];
						}
					}
					maoFlush[5] = mao[5];
					maoFlush[6] = mao[6];
					mao = maoFlush;
					break;
				case (5):
					int x = 0;
					for (int j = 0; j < 7; j++) {
						if (mao_intermediaria[j].getNaipe() == i) {
							maoFlush[x++] = mao_intermediaria[j];
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

	public boolean achaStraight(Carta[] mao_intermediaria) { // Esta função verifica se a mao do
												// jogador contém straight,
												// verifica se pelo menos 5 das
												// 7 cartas estão em sequência e
												// retorna o maior straight nas
												// cinco primeiras posições da
												// mão
		if ((mao_intermediaria[0].getValor() == mao_intermediaria[1].getValor() + 1)
				&& (mao_intermediaria[1].getValor() == mao_intermediaria[2].getValor() + 1)
				&& (mao_intermediaria[2].getValor() == mao_intermediaria[3].getValor() + 1)
				&& (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor() + 1)) {
			mao = mao_intermediaria;
			return true;
		} else if ((mao_intermediaria[1].getValor() == mao_intermediaria[2].getValor() + 1)
				&& (mao_intermediaria[2].getValor() == mao_intermediaria[3].getValor() + 1)
				&& (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor() + 1)
				&& (mao_intermediaria[4].getValor() == mao_intermediaria[5].getValor() + 1)) {
			int x = 0;
			for (int j = 1; j < 7; j++)
				maoStraight[x++] = mao_intermediaria[j];
			maoStraight[5] = mao[5];
			maoStraight[6] = mao[6];
			mao = maoStraight;
			return true;
		} else if ((mao_intermediaria[2].getValor() == mao_intermediaria[3].getValor() + 1)
				&& (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor() + 1)
				&& (mao_intermediaria[4].getValor() == mao_intermediaria[5].getValor() + 1)
				&& (mao_intermediaria[5].getValor() == mao_intermediaria[6].getValor() + 1)) {
			int x = 0;
			for (int j = 2; j < 7; j++)
				maoStraight[x++] = mao_intermediaria[j];
			maoStraight[5] = mao[5];
			maoStraight[6] = mao[6];
			mao = maoStraight;
			return true;
		}
		return false;
	}

	public boolean achaStraightFlush(Carta[] mao_intermediaria) { // Esta função verifica se a
													// mao do jogador contém
													// straight flush, verifica
													// se pelo menos 5 das 7
													// cartas contêm o mesmo
													// naipe e estão em
													// sequência e retorna o
													// maior straight flush do
													// jogador nas cinco
													// primeiras posições da mao
		if ((mao_intermediaria[0].getValor() == mao_intermediaria[1].getValor() + 1)
				&& (mao_intermediaria[1].getValor() == mao_intermediaria[2].getValor() + 1)
				&& (mao_intermediaria[2].getValor() == mao_intermediaria[3].getValor() + 1)
				&& (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor() + 1)) {

			if ((mao_intermediaria[0].getNaipe() == mao_intermediaria[1].getNaipe())
					&& (mao_intermediaria[1].getNaipe() == mao_intermediaria[2].getNaipe())
					&& (mao_intermediaria[2].getNaipe() == mao_intermediaria[3].getNaipe())
					&& (mao_intermediaria[3].getNaipe() == mao_intermediaria[4].getNaipe())) {
				mao = mao_intermediaria;
				return true;
			}
		} else if ((mao_intermediaria[1].getValor() == mao_intermediaria[2].getValor() + 1)
				&& (mao_intermediaria[2].getValor() == mao_intermediaria[3].getValor() + 1)
				&& (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor() + 1)
				&& (mao_intermediaria[4].getValor() == mao_intermediaria[5].getValor() + 1)) {
			if ((mao_intermediaria[1].getNaipe() == mao_intermediaria[2].getNaipe())
					&& (mao_intermediaria[2].getNaipe() == mao_intermediaria[3].getNaipe())
					&& (mao_intermediaria[3].getNaipe() == mao_intermediaria[4].getNaipe())
					&& (mao_intermediaria[4].getNaipe() == mao_intermediaria[5].getNaipe())) {
				mao = mao_intermediaria;
				int x = 0;
				for (int j = 1; j < 7; j++)
					maoStraight[x++] = mao_intermediaria[j];
				maoStraight[5] = mao[5];
				maoStraight[6] = mao[6];
				mao = maoStraight;
				return true;
			}
		} else if ((mao_intermediaria[2].getValor() == mao_intermediaria[3].getValor() + 1)
				&& (mao_intermediaria[3].getValor() == mao_intermediaria[4].getValor() + 1)
				&& (mao_intermediaria[4].getValor() == mao_intermediaria[5].getValor() + 1)
				&& (mao_intermediaria[5].getValor() == mao_intermediaria[6].getValor() + 1)) {
			if ((mao_intermediaria[2].getNaipe() == mao_intermediaria[3].getNaipe())
					&& (mao_intermediaria[3].getNaipe() == mao_intermediaria[4].getNaipe())
					&& (mao_intermediaria[4].getNaipe() == mao_intermediaria[5].getNaipe())
					&& (mao_intermediaria[5].getNaipe() == mao_intermediaria[6].getNaipe())) {
				int x = 0;
				for (int j = 2; j < 7; j++)
					maoStraight[x++] = mao_intermediaria[j];
				maoStraight[5] = mao[5];
				maoStraight[6] = mao[6];
				mao = maoStraight;
				return true;
			}
		}
		return false;
	}

	public int determinaMelhorMao() {

		boolean[] nivel = new boolean[8];

		nivel[7] = achaStraightFlush(melhor_mao);
		nivel[3] = achaStraight(melhor_mao);
		nivel[4] = achaFlush(melhor_mao);

		nivel[0] = achaPar(melhor_mao);

		if (nivel[0]) {
			nivel[2] = achaTrinca(melhor_mao);
			if (nivel[2]) {
				nivel[5] = achaFullHouse(melhor_mao);
				nivel[6] = achaQuadra(melhor_mao);

			} else {
				nivel[1] = achaDoisPares(melhor_mao);
			}
		}

		for (int i = 7; i > -1; i--) {
			if (nivel[i]) {
				return i;
			}
		} // Este laço verifica qual o maior valor que contém true na variável
			// boolean teste

		return -1; // É retornado -1 caso o melhor jogo seja uma High Card

	}

}
