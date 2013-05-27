package br.unb.poker;

import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import br.unb.poker.cassandra.dao.CfPessoaDAO;
import br.unb.poker.cassandra.entity.CfPessoa;

public class MainDealer {

	public static void main(String[] args) {

		DBHandler dbHandler = new DBHandler(); 
		dbHandler.SetupDB();
		dbHandler.SetupDBConsistencyLevel();

		Cluster cluster = HFactory.getOrCreateCluster("poker-cluster",
				"localhost:9160");

		Keyspace bancoPoker = HFactory.createKeyspace("BancoPokerHOLDEM",
				cluster);

		CfPessoaDAO cfPessoaDAO = new CfPessoaDAO(bancoPoker);

		/*
		 * ThriftCfDef tcf = new ThriftCfDef(cf);
		 * tcf.setColumnType(ColumnType.STANDARD);
		 * tcf.setComparatorType(ComparatorType.UTF8TYPE);
		 * tcf.setDefaultValidationClass("UTF8Type");
		 */

		CfPessoa cf1 = new CfPessoa();
		cf1.setKey("3");
		cf1.setNome("Vergne");
		cf1.setIdade("19");
		cfPessoaDAO.update(cf1);

		CfPessoa cf2 = new CfPessoa();
		cf1.setKey("5");
		cf1.setNome("Chucky");
		cf1.setIdade("20");
		cfPessoaDAO.update(cf1);

		CfPessoa pessoa1 = cfPessoaDAO.read("3");
		CfPessoa pessoa2 = cfPessoaDAO.read("5");

		Baralho meuBaralho = new Baralho();
		meuBaralho.shuffle();

		Jogador jogadorA = new Jogador(pessoa1.getNome(),
				meuBaralho.dealCard(), meuBaralho.dealCard());
		Jogador jogadorB = new Jogador(pessoa2.getNome(),
				meuBaralho.dealCard(), meuBaralho.dealCard());

		System.out.println(jogadorA);
		System.out.println(jogadorB);

		Carta[] Mesa = new Carta[5];

		for (int k = 0; k < 5; k++) {
			Mesa[k] = meuBaralho.dealCard();
		}

		System.out.println("Mesa: " + Mesa[0] + ", " + Mesa[1] + ", " + Mesa[2]
				+ ", " + Mesa[3] + ", " + Mesa[4]);

		ComparaJogos comparador = new ComparaJogos(jogadorA.getMao(),
				jogadorB.getMao(), Mesa);

		System.out.println("Nivel do jogo de" + jogadorA.getNickname() + ": "
				+ comparador.determinaNiveldaMao(jogadorA.getMao(), Mesa));
		System.out.println("Nivel do jogo de" + jogadorB.getNickname() + ": "
				+ comparador.determinaNiveldaMao(jogadorB.getMao(), Mesa));

		if (!comparador.determinaEmpate()) {

			System.out.println("Vencedor: " + comparador.determinaVencedor()[0]
					+ ", " + comparador.determinaVencedor()[1]);

		}

	}

}
