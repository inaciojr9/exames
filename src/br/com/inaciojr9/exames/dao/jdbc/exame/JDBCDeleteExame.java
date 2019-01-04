package br.com.inaciojr9.exames.dao.jdbc.exame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.inaciojr9.exames.dao.jdbc.Conexao;
import br.com.inaciojr9.exames.exception.MinhaException;

public class JDBCDeleteExame {

	public static void delete(Integer id){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String deleteTableSQL = "DELETE from exame WHERE id = ?";

		try {
			conn = Conexao.getConexao();
			pstmt = conn.prepareStatement(deleteTableSQL);
			pstmt.setInt(1, id);
			pstmt.execute();

		} catch (SQLException e) {
			throw new MinhaException("Problemas ao buscar excluir o exame: " + id + ": " + e.getMessage(), e);

		} finally {
			Conexao.encerrar(conn, pstmt, rs);
		}

	}

}
