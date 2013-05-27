package br.unb.poker;

import java.util.Arrays;

import me.prettyprint.cassandra.model.ConfigurableConsistencyLevel;
import me.prettyprint.cassandra.service.ThriftKsDef;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.HConsistencyLevel;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.ddl.ColumnFamilyDefinition;
import me.prettyprint.hector.api.ddl.ComparatorType;
import me.prettyprint.hector.api.ddl.KeyspaceDefinition;
import me.prettyprint.hector.api.factory.HFactory;

public class DBHandler {

	public void SetupDB() {

		Cluster cluster = HFactory.getOrCreateCluster("poker-cluster", //cria a conexão
				"localhost:9160");

		// cria o banco
		KeyspaceDefinition keyspaceDef = cluster.describeKeyspace("BancoPokerHOLDEM"); //Cria as definições do cluster e keyspace utilizados no aplicativo
		if (keyspaceDef == null) {
			ColumnFamilyDefinition cfDef = HFactory
					.createColumnFamilyDefinition("BancoPokerHOLDEM",
							"CfPessoa", ComparatorType.BYTESTYPE);

			KeyspaceDefinition newKeyspace = HFactory.createKeyspaceDefinition(
					"BancoPokerHOLDEM", ThriftKsDef.DEF_STRATEGY_CLASS, 1, // No nosso caso, utiliza-se apenas um nó (um único servidor) e portanto o fator de replicação deve ser 1.
					Arrays.asList(cfDef));

			cluster.addKeyspace(newKeyspace, true);
		
		}
	}
	
	public void SetupDBConsistencyLevel(){ //Seta o nivel de consistência, este valor está relacionado ao fator de replicação do cluster. Quanto maior for o número de replicas da informação
										   // distribuida na rede de servidores do Cassandra, maior pode ser o nivel de consistencia utilizado.
										   // http://www.datastax.com/docs/0.8/dml/data_consistency
										   
		
		Cluster cluster = HFactory.getOrCreateCluster("poker-cluster",
				"localhost:9160");
		
		Keyspace bancoPoker = HFactory.createKeyspace("BancoPokerHOLDEM", cluster);
		
		ConfigurableConsistencyLevel configurableConsistencyLevelPolicy = new ConfigurableConsistencyLevel();
		configurableConsistencyLevelPolicy
				.setDefaultWriteConsistencyLevel(HConsistencyLevel.ANY);
		configurableConsistencyLevelPolicy
				.setDefaultReadConsistencyLevel(HConsistencyLevel.ONE);
		bancoPoker
				.setConsistencyLevelPolicy(configurableConsistencyLevelPolicy);
		
		
		
	}

}
