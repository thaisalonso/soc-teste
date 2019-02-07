package br.com.tpa.soc_teste.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import br.com.tpa.soc_teste.model.Exame;
import br.com.tpa.soc_teste.service.ExameService;

public class ExameAction extends ActionSupport implements Preparable {
	
	private Exame exame;
	private List<Exame> exames;
	private ExameService exameService = new ExameService();
	
	@Override
	public void prepare() throws Exception {
		if (exame != null && exame.getId() != null) {
            exame = exameService.buscarExame(exame.getId());
        }
	}
	
	public String save() {
        if (exame.getId() == null) {
        	exameService.inserir(exame);
        } else {
        	exameService.atualizar(exame);
        }
        exame = null;
        return SUCCESS;
    }
	
	public String listar() {
		exames = exameService.listar();
        return SUCCESS;
    }
	
	public String delete() {
		exameService.excluir(exame.getId());
        return SUCCESS;
    }

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

}
