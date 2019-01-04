package br.com.inaciojr9.exames.jaxws;

import java.util.List;

import javax.jws.WebService;

import br.com.inaciojr9.exames.model.Exame;
import br.com.inaciojr9.exames.service.ExameService;
import br.com.inaciojr9.exames.service.ExameServiceImpl;

@WebService
public class ExameWs {
	
	private ExameService service = new ExameServiceImpl();
	
	public List<Exame> getAll(){
		return service.obterTodos();
	}
	
	public Exame getById(Integer id){
		return service.obterPorId(id);
	}

}
