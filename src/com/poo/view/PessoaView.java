package com.poo.view;
/*
 * Aluna: Laís Gonçalves Senna
 * Matrícula: 0050015880
 */

import java.util.Scanner;

import com.poo.controller.PessoaController;
import com.poo.model.Pessoa;

public class PessoaView {

	
		//pede dados da pessoa para gravar no banco
		public void create() 
		{
		
			try
			{	
				Scanner sc = new Scanner(System.in);
				
				Pessoa pessoa = new Pessoa();
				PessoaController controller = new PessoaController();
				
				System.out.println("Entre com o nome:");
				pessoa.setNome(sc.nextLine());
				
				System.out.println("Entre com o seu sexo:");
				pessoa.setSexo(sc.nextLine());
				
				controller.create(pessoa);

			}
			catch(Exception e)
			{
				System.out.println("Erro na tela de incluir pessoa");
			}
		}
		
		//ler dados da pessoa
		public void readAll()
		{
			PessoaController controller = new PessoaController();
			
			System.out.println("Listagem de pessoas");
			System.out.println("*******************");
			
			for(Pessoa pessoa:controller.readAll())
			{
				System.out.println("ID:" + pessoa.getId());
				System.out.println("Nome:" + pessoa.getNome());
				System.out.println("Sexo:" + pessoa.getSexo());
				System.out.println("-------------------------");
			}
			
		}	
		
		//atualizar dados da pessoa
		public void update() 
		{
		
			try
			{	
				Scanner sc = new Scanner(System.in);
				
				Pessoa pessoa = new Pessoa();
				PessoaController controller = new PessoaController();
			
				System.out.println("Entre com o nome:");
				pessoa.setNome(sc.nextLine());
				
				System.out.println("Entre com o seu sexo:");
				pessoa.setSexo(sc.nextLine());
				
				System.out.println("Entre com o ID:");
				pessoa.setId(sc.nextInt());
								
				controller.update(pessoa);

			}
			catch(Exception e)
			{
				System.out.println("Erro na tela de alterar pessoa");
			}
		}
		
		//deletar pessoa
				public void delete() 
				{
				
					try
					{	
						Scanner sc = new Scanner(System.in);
						
						Pessoa pessoa = new Pessoa();
						PessoaController controller = new PessoaController();
					
						
						System.out.println("Entre com o ID:");
						pessoa.setId(sc.nextInt());
										
						controller.delete(pessoa);

					}
					catch(Exception e)
					{
						System.out.println("Erro na tela de alterar pessoa");
					}
				}
				

		public static void main(String[] args) {
	
			PessoaView crud = new PessoaView();
		
			System.out.println("---INSERT---");
			crud.create();
			
			System.out.println("---READ---");
			crud.readAll();
	
			System.out.println("---UPDATE---");
			crud.update();
			
			System.out.println("---DELETE---");
			crud.delete();
		}	

}


