package br.com.inaciojr9.exames.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.helper.ConstantesGerais;
import br.com.inaciojr9.exames.model.Exame;
import br.com.inaciojr9.exames.service.ExameService;
import br.com.inaciojr9.exames.service.ExameServiceImpl;

public class PesquisaAction extends ActionSupport{

	private static final long serialVersionUID = -7547352095878758778L;

	private String nome;
	public List<Exame> exames = new ArrayList<>();
	
	private ExameService service = new ExameServiceImpl();

	public String execute() {
		try {
			exames = service.pesquisar(this.nome);
		}catch(MinhaException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(ConstantesGerais.ERRO_GERAL);
		}
		return "success";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

}
