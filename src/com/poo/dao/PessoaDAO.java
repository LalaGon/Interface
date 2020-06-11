package com.poo.dao;
/*
 * Aluna: Laís Gonçalves Senna
 * Matrícula: 0050015880
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Pessoa;

public class PessoaDAO {
	
	//inserir aluno no banco CRUD - Create, Read, Update, Delete
		public void create(Pessoa pessoa)
		{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			String sql = "insert into pessoa(nome, sexo) values (?, ?)";
			
			try {
				
				
				stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
				stmt.setString(1, pessoa.getNome()); //primeiro parametro da query
				stmt.setString(2, pessoa.getSexo()); //segundo parametro
				
				stmt.executeUpdate();
				System.out.println("[PessoaDAO] Pessoa incluida com sucesso");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
			
	
		}
		
		//ler todos os registros da tabela pessoa
		public List<Pessoa> readAll()
		{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			String sql = " select id, nome, sexo from pessoa";
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			try{
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				while(rs.next())
				{
					Pessoa pessoa = new Pessoa();
					pessoa.setId(rs.getInt("id"));
					pessoa.setNome(rs.getString("nome"));
					pessoa.setSexo(rs.getString("sexo"));
					
					pessoas.add(pessoa);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Erro ao tentar ler tabela pessoa");
			}
			finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
			
			return pessoas;
		}
		
		//altera os dados de um aluno do banco
		public void update(Pessoa pessoa) {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			String sql = "update pessoa set nome=?, sexo=? where id=?";
			
			try {
				
				
				stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
				stmt.setString(1, pessoa.getNome()); //primeiro parametro da query
				stmt.setString(2, pessoa.getSexo()); //segundo parametro
				stmt.setLong(3, pessoa.getId()); //terceiro parametro
				
				stmt.executeUpdate();
				System.out.println("[PessoaDAO] Dados alterados com sucesso!");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
	    }
		
		//deletar uma pessoa do banco
		public void delete(Pessoa pessoa) {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			String sql = "delete from pessoa where id=?";
			
			try {
				
				
				stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
				stmt.setLong(1, pessoa.getId()); //primeiro parametro da query
				
				
				stmt.executeUpdate();
				System.out.println("[PessoaDAO] Pessoa deletada com sucesso!");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
	    }

	

		
		
		
	
}
