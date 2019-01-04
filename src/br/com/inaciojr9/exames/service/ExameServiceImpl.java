package br.com.inaciojr9.exames.service;

import java.util.List;

import br.com.inaciojr9.exames.dao.ExameDao;
import br.com.inaciojr9.exames.dao.jdbc.ExameDaoJdbc;
import br.com.inaciojr9.exames.model.Exame;

public class ExameServiceImpl implements ExameService{
	
	private final ExameDao dao;
	
	public ExameServiceImpl() {
		this.dao = new ExameDaoJdbc();
	}

	@Override
	public Exame obterPorId(Integer id) {
		return dao.obterPorId(id);
	}

	@Override
	public List<Exame> pesquisar(String nome) {
		return dao.pesquisar(nome);
	}

	@Override
	public List<Exame> obterTodos() {
		return dao.obterTodos();
	}

	@Override
	public void incluir(Exame exame) {
		dao.incluir(exame);
	}

	@Override
	public void atualizar(Exame exame) {
		dao.atualizar(exame);
	}

	@Override
	public void excluir(Integer id) {
		dao.excluir(id);
	}

}
