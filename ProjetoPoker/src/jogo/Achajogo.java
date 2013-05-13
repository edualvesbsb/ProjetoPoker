package jogo;

import Carta;


public class Achajogo {
	
	
	
	Carta[] mao = new Carta[7];
	Carta aux0;
	Carta aux1;
	Carta[] maoFlush = new Carta[7];
	Carta[] maoStraight = new Carta[7];
	
	public Achajogo(Carta[] mao){
		
		
		this.mao = mao;
		
				
		for (int i = 0; i < 7; i++) { //Este la�o ordena a mao da maior carta para a menor, sendo �s a maior e 2 a menor, n�o importando o naipe
			for (int j = 0; j < 6; j++) {
				if (mao[j].valor < mao[j + 1].valor) {
					aux0 = mao[j];
					mao[j] = mao[j + 1];
					mao[j + 1] = aux0;
				} 
			}
		}
		
	}
		
		
		public boolean achaPar(Carta[] a){ //Esta fun��o verifica se a mao do jogador cont�m algum par e o coloca nas posi��es 3 e 4 da mao, este ser� o maior segundo par que o jogador possui, pois a m�o foi previamente ordenada
			for (int i = 0; i < 6; i++) {
				for (int j = i; j < 6; j++) {
					if (a[j].valor == a[j + 1].valor) {
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
		
		public boolean achaDoisPares(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m algum par e o coloca nas posi��es 3 e 4 da mao, este ser� o maior segundo par que o jogador possui, pois a m�o foi previamente ordenada
			for (int i = 2; i < 6; i++) {
				for (int j = i; j < 6; j++) {
					if (a[j].valor == a[j + 1].valor) {
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

		public boolean achaTrinca(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m alguma trinca e coloca este nas tr�s primeiras posi��es da mao, este ser� a maior trinca que o jogador possui, pois a m�o foi previamente ordenada
			for (int j = 2; j < 7; j++) {
				if (a[1].valor == a[j].valor) {
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
		
		public boolean achaQuadra(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m alguma quadra e a coloca nas quatro primeiras posi��es da mao, esta ser� a maior quadra que o jogador possui, pois a m�o foi previamente ordenada
			for (int j = 3; j < 7; j++) {
				if (a[1].valor == a[j].valor) {
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
		
		public boolean achaFullHouse(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m algum full house e o coloca nas cinco primeiras posi��es da mao, este ser� o maior full house que o jogador possui, pois a m�o foi previamente ordenada

			if (a[3].valor == a[4].valor) {
				mao = a;
				return true;
			}
			if (a[4].valor == a[5].valor) {
				a[3] = a[4];
				mao = a;
				return true;
			}
			if (a[5].valor == a[6].valor) {
				a[3] = a[5];
				a[4] = a[5];
				mao = a;
				return true;
			}

			return false;

		}
		
		public boolean achaFlush(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m flush, verifica se pelo menos 5 das 7 cartas cont�m o mesmo naipe e retorna o maior flush do jogador nas cinco primeiras posi��es da mao
			int[] cont = new int[4];
			cont[0] = 0;
			cont[1] = 0;
			cont[2] = 0;
			cont[3] = 0;
			for (int i = 0; i < 7; i++) {
				switch (a[i].naipe) {

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
							if (a[j].naipe == i) {
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
							if (a[j].naipe == i) {
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
		
		public boolean achaStraight(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m straight, verifica se pelo menos 5 das 7 cartas est�o em sequ�ncia e retorna o maior straight nas cinco primeiras posi��es da m�o
			if ((a[0].valor == a[1].valor + 1) && (a[1].valor == a[2].valor + 1)
					&& (a[2].valor == a[3].valor + 1)
					&& (a[3].valor == a[4].valor + 1)) {
				mao = a;
				return true;
			} else if ((a[1].valor == a[2].valor + 1)
					&& (a[2].valor == a[3].valor + 1)
					&& (a[3].valor == a[4].valor + 1)
					&& (a[4].valor == a[5].valor + 1)) {
				int x = 0;
				for (int j = 1; j < 7; j++)
					maoStraight[x++] = a[j];
				maoStraight[5] = mao[5];
				maoStraight[6] = mao[6];
				mao = maoStraight;
				return true;
			} else if ((a[2].valor == a[3].valor + 1)
					&& (a[3].valor == a[4].valor + 1)
					&& (a[4].valor == a[5].valor + 1)
					&& (a[5].valor == a[6].valor + 1)) {
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
		
		public boolean achaStraightFlush(Carta[] a) { //Esta fun��o verifica se a mao do jogador cont�m straight flush, verifica se pelo menos 5 das 7 cartas cont�m o mesmo naipe e est�o em sequ�ncia e retorna o maior straight flush do jogador nas cinco primeiras posi��es da mao
			if ((a[0].valor == a[1].valor + 1) && (a[1].valor == a[2].valor + 1)
					&& (a[2].valor == a[3].valor + 1)
					&& (a[3].valor == a[4].valor + 1)) {

				if ((a[0].naipe == a[1].naipe) && (a[1].naipe == a[2].naipe)
						&& (a[2].naipe == a[3].naipe) && (a[3].naipe == a[4].naipe)) {
					mao = a;
					return true;
				}
			} else if ((a[1].valor == a[2].valor + 1)
					&& (a[2].valor == a[3].valor + 1)
					&& (a[3].valor == a[4].valor + 1)
					&& (a[4].valor == a[5].valor + 1)) {
				if ((a[1].naipe == a[2].naipe) && (a[2].naipe == a[3].naipe)
						&& (a[3].naipe == a[4].naipe) && (a[4].naipe == a[5].naipe)) {
					mao = a;
					int x = 0;
					for (int j = 1; j < 7; j++)
						maoStraight[x++] = a[j];
					maoStraight[5] = mao[5];
					maoStraight[6] = mao[6];
					mao = maoStraight;
					return true;
				}
			} else if ((a[2].valor == a[3].valor + 1)
					&& (a[3].valor == a[4].valor + 1)
					&& (a[4].valor == a[5].valor + 1)
					&& (a[5].valor == a[6].valor + 1)) {
				if ((a[2].naipe == a[3].naipe) && (a[3].naipe == a[4].naipe)
						&& (a[4].naipe == a[5].naipe) && (a[5].naipe == a[6].naipe)) {
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
		
	
		
		
	}


