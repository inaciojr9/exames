package br.com.inaciojr9.exames.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.helper.ConstantesGerais;
import br.com.inaciojr9.exames.service.ExameService;
import br.com.inaciojr9.exames.service.ExameServiceImpl;

public class DeleteAction extends ActionSupport{

	private static final long serialVersionUID = 8330406154434095370L;
	
	private Integer id;
	
	private ExameService service = new ExameServiceImpl();

	public String execute() {
		try {
			service.excluir(id);
		}catch(MinhaException me) {
			me.printStackTrace();
			addActionError(me.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(ConstantesGerais.ERRO_GERAL);
		}
		
		return "success";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
