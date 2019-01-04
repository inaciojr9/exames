package br.com.inaciojr9.exames.dao.jdbc.exame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.inaciojr9.exames.dao.jdbc.Conexao;
import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.model.Exame;

public class JDBCSelectPorIdExame {
   
   public static Exame getById(Integer id){
	   Exame exame = null;
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   String sql = ConstantesJdbcExame.SELECT_BASE + " where id = ?";
	   
	   try{
		  conn = Conexao.getConexao();
	      
	      pstmt = conn.prepareStatement(sql);
		  pstmt.setInt(1, id);
	      rs = pstmt.executeQuery();
	      
	      if(rs.next()) {
	    	  exame = ConversorExame.executar(rs); 
	      }
	      
	   }catch(SQLException e) {
		      throw new MinhaException("Problemas ao buscar todos exame por id: "+e.getMessage(), e);
		       
	   }finally{
	      Conexao.encerrar(conn, pstmt, rs);
	   }
	   
	   return exame;
   }
   
   public static void main(String[] args) throws SQLException {
	   int id = 1;
	   Exame exame = getById(id);
	   System.out.println(exame);
   }
}