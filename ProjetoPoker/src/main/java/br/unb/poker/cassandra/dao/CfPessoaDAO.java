package br.unb.poker.cassandra.dao;

import java.util.ArrayList;
import java.util.List;

import me.prettyprint.cassandra.model.CqlQuery;
import me.prettyprint.cassandra.model.CqlRows;
import me.prettyprint.cassandra.serializers.LongSerializer;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.beans.ColumnSlice;
import me.prettyprint.hector.api.beans.Row;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;
import me.prettyprint.hector.api.query.QueryResult;
import me.prettyprint.hector.api.query.SliceQuery;
import br.unb.poker.cassandra.entity.CfPessoa;

public class CfPessoaDAO {

	private static final String NOME_CF = "CfPessoa";

	private ColumnFamilyTemplate template;
	private Keyspace bancoPoker;

	public CfPessoaDAO(Keyspace bancoPoker) {
		this.bancoPoker = bancoPoker;
		template = new ThriftColumnFamilyTemplate<String, String>(bancoPoker,
				NOME_CF, StringSerializer.get(), StringSerializer.get());
	}

	public void update(CfPessoa pessoa) {

		try {
			
			// Cria um objeto cluster a partir de uma definação previamente criada no Cassandra
			Cluster cluster = HFactory.getOrCreateCluster("poker-cluster",
					"localhost:9160");

			// Cria um objeto keyspace a partir de uma definação previamente criada no Cassandra
			Keyspace keyspace = HFactory.createKeyspace("BancoPokerHOLDEM",
					cluster);

			// Cria um objeto mutator para o keyspace utilizando codificação utf-8
			Mutator<String> mutator = HFactory.createMutator(keyspace,
					StringSerializer.get());

			// Utiliza o mutator para inserir colunas (triplet) com nome, valor e key associada
			mutator.insert(pessoa.getKey(), "CfPessoa",
					HFactory.createStringColumn("nome", pessoa.getNome()));

			System.out.println("Dado inserido:" + "nome " + pessoa.getNome());

			mutator.insert(pessoa.getKey(), "CfPessoa",
					HFactory.createStringColumn("idade", pessoa.getIdade()));

			System.out.println("Dado inserido:" + "idade " + pessoa.getIdade());
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Erro ao inserir dados!");
			ex.printStackTrace();
		}
	}


	/*//Método alternativo
	 * ColumnFamilyUpdater<String, String> updater = template.createUpdater(
	 * pessoa.getKey() ); updater.setString("nome", pessoa.getNome());
	 * updater.setString("idade", pessoa.getIdade()); template.update(updater);
	 */

	public CfPessoa read(String key) {

		CfPessoa p = new CfPessoa();
		try {
			
			// Cria um objeto cluster a partir de uma definação previamente criada no Cassandra
			Cluster cluster = HFactory.getOrCreateCluster("poker-cluster",
					"localhost:9160");

			// Cria um objeto keyspace a partir de uma definação previamente criada no Cassandra
			Keyspace keyspace = HFactory.createKeyspace("BancoPokerHOLDEM",
					cluster);
			
			// Cria um Query que "Cortará" a família de colunas de acordo com os parametros setados.

			SliceQuery<String, String, String> sliceQuery = HFactory
					.createSliceQuery(keyspace, StringSerializer.get(),
							StringSerializer.get(), StringSerializer.get());
			sliceQuery.setColumnFamily("CfPessoa").setKey(key);
			sliceQuery.setColumnNames("nome");
			sliceQuery.setRange("", "", false, 4);

			QueryResult<ColumnSlice<String, String>> result = sliceQuery
					.execute();

			System.out.println("\nDado capturado:\n" + result.get());
			System.out.println();

			p.setKey(key);
			p.setNome(result.get().getColumnByName("nome").getValue());
			p.setIdade(result.get().getColumnByName("idade").getValue());
			
			return p;

		} catch (Exception ex) {
			System.out.println("Erro ao receber dados!");
			ex.printStackTrace();
		}

		return p;

	}



	public List<String> listKeys() { //EM DESENVOLVIMENTO
		CqlQuery<String, String, Long> cqlQuery = new CqlQuery<String, String, Long>(
				bancoPoker, StringSerializer.get(), StringSerializer.get(),
				LongSerializer.get());
		cqlQuery.setQuery("SELECT * FROM " + NOME_CF);
		QueryResult<CqlRows<String, String, Long>> result = cqlQuery.execute();

		List<String> keys = new ArrayList<String>();

		for (Row row : result.get().getList()) {
			keys.add((String) row.getKey());
			System.out.println("key encontrada: " + row.getKey());
		}

		return keys;
	}
}
