package br.com.inaciojr9.exames.dao.jdbc.exame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.inaciojr9.exames.model.Exame;

public class ConversorExame {
	
	public static Exame executar(ResultSet rs) {
		
		Exame exame = null;
		try {
			Integer id = rs.getInt("id");
			String nome = rs.getString("nome");
	        String descricao = rs.getString("descricao");
	        Date cadastro = rs.getDate("cadastro");
	        Boolean ativo = rs.getBoolean("ativo");
	        String obs = rs.getString("obs");
	        Date ultimaAtualizacao = rs.getTimestamp("ultima_atualizacao");
	        exame = new Exame(id, nome, descricao, cadastro, ativo, obs, ultimaAtualizacao);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao converter o resultset para java.", e);
		}
        
        return exame;
		
	}

}
