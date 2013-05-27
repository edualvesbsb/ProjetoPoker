package br.unb.poker.cassandra.entity;

public class CfPessoa { //Classe relacionada a pessoa cadastrada no banco de dados

	private String key;
	private String nome;
	private String idade;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

}
