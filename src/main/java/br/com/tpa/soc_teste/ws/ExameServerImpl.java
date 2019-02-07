package br.com.tpa.soc_teste.ws;

import javax.jws.WebService;

import br.com.tpa.soc_teste.model.Exame;
import br.com.tpa.soc_teste.service.ExameService;

@WebService(endpointInterface = "br.com.tpa.soc_teste.ws.ExameServer")
public class ExameServerImpl implements ExameServer {

	private ExameService exameService = new ExameService();
	
	@Override
	public Exame[] listar() {
		Exame[] exames = exameService.listarArray();
		return exames;
	}

	@Override
	public void inserir(Exame exame) {
		exameService.inserir(exame);
	}

	@Override
	public void atualizar(Exame exame) {
		exameService.atualizar(exame);
	}

	@Override
	public void excluir(Long id) {
		exameService.excluir(id);
	}

	@Override
	public Exame buscarExame(Long id) {
		Exame exame = exameService.buscarExame(id);
		return exame;
	}

}
