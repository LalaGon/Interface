package com.poo.controller;

/*
 * Aluna: Laís Gonçalves Senna
 * Matrícula: 0050015880
 */

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.PessoaDAO;
import com.poo.model.Pessoa;

public class PessoaController {
	//regra para incluir um aluno
	
		//create
		public void create(Pessoa pessoa)
		{
			try {
				PessoaDAO dao = new PessoaDAO();
				
				dao.create(pessoa);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro no Controller");
			}
			finally {
				System.out.println("Fim inserção");
			}
		}
		
		//update
		public void update(Pessoa pessoa) {
			try {
				PessoaDAO dao = new PessoaDAO();
				
				dao.update(pessoa);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro no Controller");
			}
			finally {
				System.out.println("Fim update");
			}
		}
		
		//read
		public List<Pessoa> readAll()
		{
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			try{
				PessoaDAO dao = new PessoaDAO();
				pessoas = dao.readAll();		
			}
			finally {
				//System.out.println("Fim da leitura!");
			}
			
			return pessoas;
		}
		
		//delete
				public void delete(Pessoa pessoa) {
					try {
						PessoaDAO dao = new PessoaDAO();
						
						dao.delete(pessoa);
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Erro no Controller");
					}
					finally {
						System.out.println("Fim delete");
					}
				}
}
