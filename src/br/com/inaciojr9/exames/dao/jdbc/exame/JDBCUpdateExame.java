package br.com.inaciojr9.exames.dao.jdbc.exame;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.inaciojr9.exames.dao.jdbc.Conexao;
import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.model.Exame;
 
public class JDBCUpdateExame {
 
 
	public static void update(Exame exame) {
 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
 
		String updateTableSQL = "UPDATE exame"
				+ " SET nome = ?, descricao = ?, cadastro = ?, ativo = ?, obs = ?, ultima_atualizacao = ? "
				+ " WHERE id = ?";
 
		try {
			conn = Conexao.getConexao();
			
			pstmt = conn.prepareStatement(updateTableSQL);
		    pstmt.setString(1, exame.getNome());
		    pstmt.setString(2, exame.getDescricao());
		    pstmt.setDate(3, new java.sql.Date(exame.getCadastro().getTime()));
		    pstmt.setBoolean(4, exame.getAtivo());
		    pstmt.setString(5, exame.getObs());
		    pstmt.setTimestamp(6, new java.sql.Timestamp(new Date().getTime()));
		    pstmt.setInt(7, exame.getId());
 
			pstmt.execute();
 
		} catch (SQLException e) {
			throw new MinhaException("Problemas ao atualizar o exame: " + exame.getId() + ": " + e.getMessage(), e);

		} finally {
			Conexao.encerrar(conn, pstmt, rs);
		}
 
	}
 
}
