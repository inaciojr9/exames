package br.com.inaciojr9.exames.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.helper.ConstantesGerais;
import br.com.inaciojr9.exames.model.Exame;
import br.com.inaciojr9.exames.service.ExameService;
import br.com.inaciojr9.exames.service.ExameServiceImpl;

public class ListagemAction extends ActionSupport {
	
	private static final long serialVersionUID = -1403454009476535328L;
	
	private ExameService service = new ExameServiceImpl();
	
	public List<Exame> exames = new ArrayList<>();
	
	public String execute() {
		try {
			this.exames = service.obterTodos();
		}catch(MinhaException me) {
			me.printStackTrace();
			addActionError(me.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(ConstantesGerais.ERRO_GERAL);
		}
		
		return "success";
	}

}
