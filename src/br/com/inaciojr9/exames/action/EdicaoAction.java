package br.com.inaciojr9.exames.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import br.com.inaciojr9.exames.exception.MinhaException;
import br.com.inaciojr9.exames.helper.ConstantesGerais;
import br.com.inaciojr9.exames.model.Exame;
import br.com.inaciojr9.exames.service.ExameService;
import br.com.inaciojr9.exames.service.ExameServiceImpl;

public class EdicaoAction extends ActionSupport{

	private static final long serialVersionUID = 8286344634475467764L;
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private Integer id;
	private Exame exame;
	private String txtCadastro;
	
	private ExameService service = new ExameServiceImpl();

	public String execute() {
		try {
			if(this.id != null && this.id != 0) {
				this.exame = service.obterPorId(this.id);
				this.txtCadastro = dateConverter(this.exame.getCadastro(), DATE_FORMAT);
			}
		}catch(MinhaException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTxtCadastro() {
		return txtCadastro;
	}
	
	private String dateConverter(Date date, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(date);
	}

}
