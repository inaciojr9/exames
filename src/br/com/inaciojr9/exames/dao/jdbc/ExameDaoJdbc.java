package br.com.inaciojr9.exames.dao.jdbc;

import java.util.List;

import br.com.inaciojr9.exames.dao.ExameDao;
import br.com.inaciojr9.exames.dao.jdbc.exame.JDBCDeleteExame;
import br.com.inaciojr9.exames.dao.jdbc.exame.JDBCInsertExame;
import br.com.inaciojr9.exames.dao.jdbc.exame.JDBCSelectExame;
import br.com.inaciojr9.exames.dao.jdbc.exame.JDBCSelectPorIdExame;
import br.com.inaciojr9.exames.dao.jdbc.exame.JDBCSelectPorNomeExame;
import br.com.inaciojr9.exames.dao.jdbc.exame.JDBCUpdateExame;
import br.com.inaciojr9.exames.model.Exame;

public class ExameDaoJdbc implements ExameDao {

	@Override
	public Exame obterPorId(Integer id) {
		return JDBCSelectPorIdExame.getById(id);
	}

	@Override
	public List<Exame> pesquisar(String nome) {
		return JDBCSelectPorNomeExame.getByNome(nome);
	}

	@Override
	public List<Exame> obterTodos() {
		return JDBCSelectExame.getAll();
	}

	@Override
	public void incluir(Exame exame) {
		JDBCInsertExame.insert(exame);
	}

	@Override
	public void atualizar(Exame exame) {
		JDBCUpdateExame.update(exame);
	}

	@Override
	public void excluir(Integer id) {
		JDBCDeleteExame.delete(id);
	}

}
