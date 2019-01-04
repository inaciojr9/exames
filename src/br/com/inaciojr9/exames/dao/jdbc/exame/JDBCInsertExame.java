package br.com.inaciojr9.exames.dao.jdbc.exame;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.inaciojr9.exames.dao.jdbc.Conexao;
import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.model.Exame;
 
public class JDBCInsertExame {
 
	public static void insert(Exame exame) {
 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String insertTableSQL = "INSERT INTO exame"
				+ "(nome, descricao, cadastro, ativo, obs) VALUES (?,?,?,?,?)";
		
		try{
			conn = Conexao.getConexao();
			pstmt = conn.prepareStatement(insertTableSQL);
		    pstmt.setString(1, exame.getNome());
		    pstmt.setString(2, exame.getDescricao());
		    pstmt.setDate(3, new java.sql.Date(exame.getCadastro().getTime()));
		    pstmt.setBoolean(4, exame.getAtivo());
		    pstmt.setString(5, exame.getObs());
		    
		    pstmt.executeUpdate();
		    
		} catch (SQLException e) {
			throw new MinhaException("Problemas ao buscar inserir o exame: " + exame.getNome() + ": " + e.getMessage(), e);

		} finally {
			Conexao.encerrar(conn, pstmt, rs);
		}
 
	}
}
