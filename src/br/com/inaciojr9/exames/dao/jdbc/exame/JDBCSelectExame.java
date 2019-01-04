package br.com.inaciojr9.exames.dao.jdbc.exame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.inaciojr9.exames.dao.jdbc.Conexao;
import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.model.Exame;

public class JDBCSelectExame {
   
   public static List<Exame> getAll() {
	   List<Exame> exames = new ArrayList<>();
	   
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   
	   try{
		   
		  conn = Conexao.getConexao();
	      stmt = conn.createStatement();
	      String sql = ConstantesJdbcExame.SELECT_BASE;
	
	      rs = stmt.executeQuery(sql);

	      while(rs.next()){
	    	 Exame exame = ConversorExame.executar(rs); 
	    	 exames.add(exame);
	      }
	      
	   }catch(SQLException e) {
	      throw new MinhaException("Problemas ao buscar todos os exames: "+e.getMessage(), e);
	      
	   }finally{
	      Conexao.encerrar(conn, stmt, rs);
	   }
	   
	   return exames;
   }
   
   public static void main(String[] args) throws SQLException {
	   List<Exame> exames = getAll();
	   for(Exame exame:exames){
		   System.out.println(exame);
	   }
   }
}