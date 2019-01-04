package br.com.inaciojr9.exames.dao;

import java.util.List;

import br.com.inaciojr9.exames.model.Exame;

public interface ExameDao {
	
	public Exame obterPorId(Integer id);
	
	public List<Exame> pesquisar(String nome);
	
	public List<Exame> obterTodos();
	
	public void incluir(Exame exame);
	
	public void atualizar(Exame exame);
	
	public void excluir(Integer id);
	
}
