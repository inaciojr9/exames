package br.com.inaciojr9.exames.dao.jdbc.exame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.inaciojr9.exames.dao.jdbc.Conexao;
import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.model.Exame;

public class JDBCSelectPorNomeExame {
   
   public static List<Exame> getByNome(String nome){
	   List<Exame> exames = new ArrayList<>();
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   String sql = ConstantesJdbcExame.SELECT_BASE + " where nome like ? ";
	   
	   try{
		  conn = Conexao.getConexao();
	      
	      pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, "%"+nome+"%");
	      rs = pstmt.executeQuery();
	      
	      while(rs.next()){
		    Exame exame = ConversorExame.executar(rs); 
		    exames.add(exame);
	      }
	      
	   }catch(SQLException e) {
		      throw new MinhaException("Problemas ao buscar todos exame por id: "+e.getMessage(), e);
		       
	   }finally{
	      Conexao.encerrar(conn, pstmt, rs);
	   }
	   
	   return exames;
   }
   
   public static void main(String[] args) throws SQLException {
	   String nome = "desc";
	   List<Exame> exames = getByNome(nome);
	   for(Exame exame:exames) {
		   System.out.println(exame);
	   }
   }
}