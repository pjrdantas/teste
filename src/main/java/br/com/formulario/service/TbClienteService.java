package br.com.formulario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formulario.model.dto.TbClienteDTO;
import br.com.formulario.repository.impl.ItbClienteDAO;
import br.com.formulario.service.impl.ITbClienteService;





@Service
public class TbClienteService  implements ITbClienteService {
	
	
	@Autowired
	private ItbClienteDAO tbClienteDAO;


	@Override
	public void addTbClienteDTO(TbClienteDTO tbClienteDTO)   throws Exception, Throwable {
		tbClienteDAO.addTbClienteDTO(tbClienteDTO);
		
	}
	

	 
	@Override
	public void updateTbClienteDTO(TbClienteDTO tbClienteDTO)  throws Exception, Throwable {
		tbClienteDAO.updateTbClienteDTO(tbClienteDTO);
	}
	

	@Override
	public List<TbClienteDTO> consultar()   throws Exception, Throwable {
		return tbClienteDAO.getAllTbClientes();
	}

	
	
	@Override
	public TbClienteDTO getTbClienteById(int id)  throws Exception, Throwable {
		TbClienteDTO obj = tbClienteDAO.getTbClienteById(id);
		return obj;
	}	
	
	 
	
	@Override
	public void deleteTbCliente(int id)  throws Exception, Throwable {
		tbClienteDAO.deleteTbCliente(id);
	}

  

}
