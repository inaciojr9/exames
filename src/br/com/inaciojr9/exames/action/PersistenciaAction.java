package br.com.inaciojr9.exames.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.helper.ConstantesGerais;
import br.com.inaciojr9.exames.model.Exame;
import br.com.inaciojr9.exames.service.ExameService;
import br.com.inaciojr9.exames.service.ExameServiceImpl;

public class PersistenciaAction extends ActionSupport{

	private static final long serialVersionUID = 8286344634475467764L;
	
	private ExameService service = new ExameServiceImpl();
	
	private Exame exame;

	public String execute() throws Exception {
		try {
			if(this.exame.getId() == null || this.exame.getId() == 0) {
				service.incluir(exame);
			} else {
				service.atualizar(exame);
			}
		}catch(MinhaException me) {
			me.printStackTrace();
			addActionError(me.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(ConstantesGerais.ERRO_GERAL);
		}
		
		return "success";
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
	public void validate(){
	    if (exame.getNome().length() == 0) {
	        addFieldError("exame.nome", "Nome é obrigatório.");
	    }
	    if (exame.getDescricao().length() == 0) {
	        addFieldError("exame.descricao", "O campo Descrição é obrigatório.");
	    }
	    if (exame.getCadastro() == null) {
	        addFieldError("exame.cadastro", "O campo data de cadastro é obrigatório.");
	    }

	}
	
	

}
