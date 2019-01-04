package br.com.inaciojr9.exames.model;

import java.util.Date;


public class Exame {
	
	private Integer id;
	private String nome;
	private String descricao;
	private Date cadastro;
	private Boolean ativo;
	private String obs;
	private Date ultimaAtualizacao;
	
	
	
	public Exame() {
		super();
	}

	public Exame(Integer id, String nome, String descricao, Date cadastro, Boolean ativo, String obs,
			Date ultimaAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cadastro = cadastro;
		this.ativo = ativo;
		this.obs = obs;
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public String getObs() {
		return obs;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", cadastro=" + cadastro + ", ativo="
				+ ativo + ", obs=" + obs + ", ultimaAtualizacao=" + ultimaAtualizacao + "]";
	}

}
