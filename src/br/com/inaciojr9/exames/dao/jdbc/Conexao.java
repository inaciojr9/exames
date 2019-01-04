package br.com.inaciojr9.exames.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.inaciojr9.exames.exception.MinhaException;

public class Conexao {

	// Para conexão ao oracle
	/*
	 * private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	 * private static final String DB_CONNECTION =
	 * "jdbc:oracle:thin:@localhost:49161:xe"; private static final String DB_USER =
	 * "system"; private static final String DB_PASSWORD = "oracle";
	 */

	// Para conexão mysql
	static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_CONNECTION = "jdbc:mysql://localhost/exames";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";

	public static Connection getConexao() {

		carregarDrive();
		return conectar();

	}
	
	public static void carregarDrive() {
		
		try {		
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new MinhaException("Classe "+DB_DRIVER+" não encontrada.", e);
		}
		
	}
	
	public static Connection conectar() {

		Connection dbConnection = null;

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			throw new MinhaException("Problemas na conexão com o banco: "+e.getMessage(), e);
		}

		return dbConnection;

	}

	public static void encerrar(Connection conn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException se3) {
			throw new MinhaException("Problemas ao fechar o resultset: " + se3.getMessage(), se3);
		}

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
			throw new MinhaException("Problemas ao fechar o statement: " + se2.getMessage(), se2);
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			throw new MinhaException("Problemas ao fechar a conexão: " + se.getMessage(), se);
		}

	}

}
