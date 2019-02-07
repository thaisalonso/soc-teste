package br.com.tpa.soc_teste.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.tpa.soc_teste.model.Exame;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ExameServer {
	
	@WebMethod 
	Exame[] listar();
	
	@WebMethod
	void inserir(Exame exame);
	
	@WebMethod
	void atualizar(Exame exame);
	
	@WebMethod
	void excluir(Long id);
	
	@WebMethod
	Exame buscarExame(Long id);

}
