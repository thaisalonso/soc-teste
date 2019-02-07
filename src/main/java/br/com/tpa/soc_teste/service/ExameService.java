package br.com.tpa.soc_teste.service;

import java.util.List;

import br.com.tpa.soc_teste.dao.ExameDao;
import br.com.tpa.soc_teste.dao.ExameJdbcDao;
import br.com.tpa.soc_teste.model.Exame;

public class ExameService {
	
	private ExameDao exameDao = new ExameJdbcDao();
	
	public void inserir(Exame exame) {
		exameDao.inserir(exame);
	}
	
	public void atualizar(Exame exame) {
		exameDao.atualizar(exame);
	}
	
	public void excluir(Long id) {
		exameDao.excluir(id);
	}
	
	public List<Exame> listar() {
		return exameDao.listar();
	}
	
	public Exame[] listarArray() {
		List<Exame> lista = listar();
		return lista.toArray(new Exame[lista.size()]);
	}

	public Exame buscarExame(Long id) {
		return exameDao.buscar(id);
	}
}
