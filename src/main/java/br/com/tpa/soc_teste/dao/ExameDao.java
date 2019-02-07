package br.com.tpa.soc_teste.dao;

import java.util.List;

import br.com.tpa.soc_teste.model.Exame;

public interface ExameDao {
	
	List<Exame> listar();
		
	void atualizar(Exame exame);
	
	void inserir(Exame exame);
	
	void excluir(Long id);
	
	Exame buscar(Long id);

}
